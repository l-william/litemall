/**
 * @author xingzhou
 * @date 2019/12/8 22:35
 * @version 1.0
 */
package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Mapper;
import xmu.oomall.domain.DefaultFreight;
import xmu.oomall.domain.DefaultPieceFreight;

import java.util.List;


/**
 * @author lianh
 * @date 2019/12/09
 */
@Mapper
public interface FreightMapper {

    /**
     * 根据ID查找默认重量运费模板
     *
     * @param id
     * @return 基于重量的默认运费模板
     */
    DefaultFreight findDefaultFreightById(Integer id);

    /**
     * 管理员查看当前定义的所有默认重量运费模板
     *
     * @return 重量模板列表
     */
    List<DefaultFreight> findDefaultFreightList();

    /**
     * 添加默认重量运费模板
     *
     * @param defaultFreight
     * @return 操作状态码
     */
    int addDefaultFreight(DefaultFreight defaultFreight);

    /**
     * 更新默认重量运费模板
     *
     * @param defaultFreight
     * @return 操作状态码
     */
    int updateDefaultFreight(DefaultFreight defaultFreight);

    /**
     * 删除默认重量运费模板
     *
     * @param id
     * @return 操作状态码
     */
    int deleteDefaultFreightById(Integer id);

    /**
     * 根据ID查找默认件数运费模板
     *
     * @param id
     * @return 基于件数的默认运费模板
     */
    DefaultPieceFreight findDefaultPieceFreightById(Integer id);

    /**
     * 管理员查看当前定义的所有默认件数运费模板
     *
     * @return 基于重量的默认运费模板
     */
    List<DefaultPieceFreight> findDefaultPieceFreightList();

    /**
     * 添加默认件数运费模板
     *
     * @param defaultFreight
     * @return 操作状态码
     */
    int addDefaultPieceFreight(DefaultPieceFreight defaultFreight);

    /**
     * 更新默认件数运费模板
     *
     * @param defaultFreight
     * @return 操作状态码
     */
    int updateDefaultPieceFreight(DefaultPieceFreight defaultFreight);

    /**
     * 删除默认件数运费模板
     *
     * @param id
     * @return 操作状态码
     */
    int deleteDefaultPieceFreightById(Integer id);
}
