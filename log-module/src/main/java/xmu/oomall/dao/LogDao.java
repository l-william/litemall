package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.FootprintItem;
import xmu.oomall.domain.FootprintItemPo;
import xmu.oomall.domain.Log;
import xmu.oomall.mapper.LogMapper;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author CFH 12/23
 */
@Repository
public class LogDao {
    @Autowired(required = false)
    LogMapper logMapper;

    public List<Log> findLogListByAdminId(Integer adminId){
        return logMapper.findLogListByAdminId(adminId);
    }

    public Log addLog(Log log){
        log.setGmtCreate(LocalDateTime.now());
        log.setGmtModified(LocalDateTime.now());
        logMapper.addLog(log);
        return log;
    }
}
