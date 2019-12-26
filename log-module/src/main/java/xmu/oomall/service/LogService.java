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
     * 添加日志
     *
     * @param log 待添加的日志信息
     * @return 新增的日志
     */
    Log addLog(Log log);
}
