/**
 * @author xingzhou
 * @date 2019/12/8 22:35
 * @version 1.0
 */
package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import xmu.oomall.domain.*;

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
    List<DefaultFreightPo> findDefaultFreightList();

    /**
     * 添加默认重量运费模板
     *
     * @param defaultFreightPo
     * @return 操作状态码
     */
    int addDefaultFreight(DefaultFreightPo defaultFreightPo);

    /**
     * 更新默认重量运费模板
     *
     * @param defaultFreightPo
     * @return 操作状态码
     */
    int updateDefaultFreight(DefaultFreightPo defaultFreightPo);

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
    DefaultPieceFreightPo findDefaultPieceFreightById(Integer id);

    /**
     * 管理员查看当前定义的所有默认件数运费模板
     *
     * @return 基于重量的默认运费模板
     */
    List<DefaultPieceFreightPo> findDefaultPieceFreightList();

    /**
     * 添加默认件数运费模板
     *
     * @param defaultFreightPo
     * @return 操作状态码
     */
    int addDefaultPieceFreight(DefaultPieceFreightPo defaultFreightPo);

    /**
     * 更新默认件数运费模板
     *
     * @param defaultFreightPo
     * @return 操作状态码
     */
    int updateDefaultPieceFreight(DefaultPieceFreightPo defaultFreightPo);

    /**
     * 删除默认件数运费模板
     *
     * @param id
     * @return 操作状态码
     */
    int deleteDefaultPieceFreightById(Integer id);

    /**
     * 【测试】
     * 通过订单ID查找所对应的订单物品列表
     *
     * @param orderId 订单ID
     * @return
     */
    List<OrderItem> findOrderItemListByOrderId(Integer orderId);

    /**
     * 通过地址返回对应的运费模板
     *
     * @param place
     * @return 默认运费模板
     */
    DefaultFreight findDefaultFreightByPlace(String place);

    /**
     * 查看特殊运费模板
     *
     * @return 特殊运费模板列表
     */
    List<SpecialFreight> findSpecialFreightList();

    /**
     * 通过id查找特殊运费模板
     *
     * @param id
     * @return 特殊运费模板
     */
    SpecialFreight findSpecialFreightById(Integer id);

    /**
     * 添加特殊运费模板
     *
     * @param specialFreight
     * @return 操作码
     */
    int addSpecialFreight(SpecialFreight specialFreight);

    /**
     * 更新特殊运费模板
     *
     * @param specialFreight
     * @return 操作码
     */
    int updateSpecialFreight(SpecialFreight specialFreight);

    /**
     * 删除特殊运费模板
     *
     * @param id
     * @return 操作码
     */
    int deleteSpecialFreight(Integer id);
}
