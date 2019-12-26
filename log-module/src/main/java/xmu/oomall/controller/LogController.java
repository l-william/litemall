package xmu.oomall.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.client.RestTemplate;
import xmu.oomall.domain.Log;
import xmu.oomall.service.LogService;
import xmu.oomall.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @author CFH 12/23
 */

@RestController
@RequestMapping("")
@Validated
public class LogController {
    @Autowired
    private LogService logService;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 根据管理员ID查找相关的日志列表
     *
     * @param request 网页请求
     * @param adminId 管理员ID
     * @param page 分页页号
     * @param limit 分页大小
     * @return 该管理员的操作日志列表
     */
    @GetMapping("/logs")
    public Object findLogList(HttpServletRequest request,
                                @RequestParam Integer adminId,
                                @RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "10") Integer limit)
    {
        Log log=createLog(request, 0, 1, "查看日志",null);
        if(log!=null) { writeLog(log); }
        else {return ResponseUtil.unlogin();}
        List<Log> logList=logService.findLogListByAdminId(adminId,page,limit);
        return ResponseUtil.ok(logList);
    }


    /**
     * 添加日志
     *
     * @param log 待新增的日志信息
     * @return 新增的日志
     */
    @PostMapping("/log")
    public Object addLog(@RequestBody Log log){
        Log retLog=logService.addLog(log);
        if(log==null){
            return ResponseUtil.fail(907,"写入日志失败");
        }
        return ResponseUtil.ok(retLog);
    }

    /**
     * 日志记录函数
     *
     * @param log 日志
     */
    private void writeLog(Log log) {
        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance instance = loadBalancerClient.choose("Log");
        System.out.println(instance.getHost());
        System.out.println(instance.getPort());
        String reqUrl = String.format("http://%s:%s", instance.getHost(), instance.getPort() + "/logs");
        restTemplate.postForObject(reqUrl,log,Log.class);
    }

    /**
     * 生成日志函数
     *
     * @param request 网页请求
     * @param type 操作类型
     * @param status 操作结果
     * @param action 操作的动作描述
     * @param actionId 操作对象的ID
     * @return 返回生成的日志或者空值，空值则进行未登录错误处理
     */
    private Log createLog(HttpServletRequest request,Integer type,Integer status,String action,Integer actionId)
    {
        String adminId= request.getHeader("id");
        if (adminId==null){
            return null;
        }
        Log log=new Log();
        log.setAdminId(Integer.valueOf(adminId));
        log.setIp(request.getRemoteAddr());
        log.setType(type);
        log.setActions(action);
        log.setActionId(actionId);
        log.setStatusCode(status);
        return log;
    }


}
