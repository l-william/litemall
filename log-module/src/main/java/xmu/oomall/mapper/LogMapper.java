package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Mapper;
import xmu.oomall.domain.Log;

import java.util.List;

/**
 * @author CFH 12/23
 */
@Mapper
public interface LogMapper {

    /**
     * 根据管理员ID查找日志列表
     *
     * @param adminId 管理员ID
     * @return 该管理员的操作日志列表
     */
    List<Log> findLogListByAdminId(Integer adminId);

    /**
     * 添加日志
     *
     * @param log 日志
     * @return 操作状态码
     */
    int addLog(Log log);
}
