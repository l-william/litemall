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

    @GetMapping("/logs")
    public Object findLogList(HttpServletRequest request,
                                @RequestParam Integer adminId,
                                @RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "10") Integer limit)
    {
        List<Log> logList=logService.findLogListByAdminId(adminId,page,limit);
        if(logList.size()==0){
            return ResponseUtil.fail(901,"查看日志失败");
        }
        return ResponseUtil.ok(logList);
    }
    

    @PostMapping("/log")
    public Object addLog(@RequestBody Log log){
        Log retLog=logService.addLog(log);
        return ResponseUtil.ok(retLog);
    }


}
