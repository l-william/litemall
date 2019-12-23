package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.Log;


import java.util.List;

/**
 * @author CFH 12/23
 */
@Service
public interface LogService {

    /**
     * 根据管理员ID查找日志列表
     *
     * @param adminId 管理员ID
     * @param page 分页页号
     * @param limit 分页大小
     * @return 该管理员的操作日志记录
     */
    List<Log> findLogListByAdminId(Integer adminId,Integer page,Integer limit);

    /**
     * @param log 日志
     * @return 添加的日志
     */
    Log addLog(Log log);
}
