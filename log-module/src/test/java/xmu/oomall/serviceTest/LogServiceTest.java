package xmu.oomall.serviceTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.domain.Log;
import xmu.oomall.service.LogService;

import java.util.List;

@SpringBootTest
public class LogServiceTest {
    @Autowired
    private LogService logService;

    @Test
    void findLogListByAdminId()
    {
        Integer adminId=123;
        List<Log> logs=logService.findLogListByAdminId(adminId,1,10);
        if(logs!=null)
            System.out.println("查找失败");
        else
            System.out.println(logs.size());
    }
    @Test
    void addLog()
    {
        Log log=new Log();
        logService.addLog(log);

    }
}
