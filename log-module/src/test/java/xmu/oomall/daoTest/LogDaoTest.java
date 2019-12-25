package xmu.oomall.daoTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.dao.LogDao;
import xmu.oomall.domain.Log;

import java.util.List;

@SpringBootTest
public class LogDaoTest {

    @Autowired
    private LogDao logDao;

    @Test
    void  findLogListByAdminId()
    {
        Integer adminId=123;
        List<Log> logs=logDao.findLogListByAdminId(adminId);
        if(logs!=null)
            System.out.println("查找失败");
        else
            System.out.println(logs.size());
    }
    @Test
    void addLog()
    {
        Log log=new Log();
        logDao.addLog(log);

    }
}
