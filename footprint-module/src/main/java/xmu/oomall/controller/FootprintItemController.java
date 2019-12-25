package xmu.oomall.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import xmu.oomall.domain.FootprintItem;
import xmu.oomall.domain.FootprintItemPo;
import xmu.oomall.domain.Log;
import xmu.oomall.service.FootprintItemService;
import xmu.oomall.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @author CFH 12/23
 */

@RestController
@RequestMapping("")
@Validated
public class FootprintItemController {
    @Autowired
    private FootprintItemService footprintItemService;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 用户浏览自己的足迹
     *
     * @param request 网页请求
     * @param page 分页页号
     * @param limit 分页大小
     * @return 用户的足迹列表
     */
    @GetMapping("/footprints")
    public Object userGetFootprintList(HttpServletRequest request,
                                   @RequestParam(defaultValue = "1") Integer page,
                                   @RequestParam(defaultValue = "10") Integer limit) {
        Integer userId= request.getIntHeader("userId");
        if(userId==null){
            return ResponseUtil.unlogin();
        }
        List<FootprintItem> footprintList=footprintItemService.userFindFootprintList(userId,page,limit);
        if(footprintList.size()==0){
            return ResponseUtil.fail(742,"足迹查询失败");
        }
        return ResponseUtil.ok(footprintList);
    }

    /**
     * 管理员根据条件查询足迹列表
     *
     * @param request 网页请求
     * @param userId 用户ID
     * @param goodsId 商品ID
     * @param page 分页页号
     * @param limit 分页大小
     * @return 足迹列表
     */
    @GetMapping("/admin/footprints")
    public Object adminGetFootprintList(HttpServletRequest request,
                                        @RequestParam Integer userId,
                                        @RequestParam Integer goodsId,
                                        @RequestParam(defaultValue = "1") Integer page,
                                        @RequestParam(defaultValue = "10") Integer limit) {

        List<FootprintItem> footprintList=footprintItemService.adminFindFootprintList(userId,goodsId,page,limit);
        if(footprintList.size()==0){
            Log log=createLog(request, 0, 0, "查看足迹",null);
            if(log!=null) { writeLog(log); }
            else {return ResponseUtil.unlogin();}
            return ResponseUtil.fail(742,"足迹查询失败");
        }
        else {
            Log log=createLog(request, 0, 1, "查看足迹",null);
            if(log!=null) { writeLog(log); }
            else {return ResponseUtil.unlogin();}
            return ResponseUtil.ok(footprintList);
        }
    }

    /**
     * 添加足迹
     *
     * @param footprintItemPo 待添加的足迹信息
     * @return 新增的足迹
     */
    @PostMapping("/footprints")
    public Object addFootprint(@RequestBody FootprintItemPo footprintItemPo){
        FootprintItemPo retPo=footprintItemService.addFootprint(footprintItemPo);
        if(retPo==null){
            return ResponseUtil.fail(741,"足迹添加失败");
        }
        return ResponseUtil.ok(retPo);
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
