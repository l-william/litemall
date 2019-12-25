package xmu.oomall.controller;

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


}
