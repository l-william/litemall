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

    /**
     * 根据管理员ID查找日志列表
     *
     * @param adminId 管理员ID
     * @return 该管理员的操作日志列表
     */
    public List<Log> findLogListByAdminId(Integer adminId){
        return logMapper.findLogListByAdminId(adminId);
    }

    /**
     * 添加日志
     *
     * @param log 待新增的日志信息
     * @return 新增的日志
     */
    public Log addLog(Log log){
        log.setGmtCreate(LocalDateTime.now());
        log.setGmtModified(LocalDateTime.now());
        int ret=logMapper.addLog(log);
        if(ret==0){
            return null;
        }
        return log;
    }
}
