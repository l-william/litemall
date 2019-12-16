/**
 * @author xingzhou
 * @date 2019/12/8 22:34
 * @version 1.0
 */

package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.DefaultFreight;
import xmu.oomall.domain.DefaultPieceFreight;
import xmu.oomall.domain.Order;
import xmu.oomall.domain.OrderItem;
import xmu.oomall.mapper.FreightMapper;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lianh
 * @date 2019/12/09
 */
@Repository
public class FreightDao {

    @Autowired (required = false)
    private FreightMapper freightMapper;

    /**
     * 根据ID查找默认重量运费模板
     *
     * @param id
     * @return 基于重量的默认运费模板
     */
    public DefaultFreight findDefaultFreightById(Integer id) {
        return freightMapper.findDefaultFreightById(id);
    }

    /**
     * 管理员查看当前定义的所有默认重量运费模板
     *
     * @return 重量模板列表
     */
    public List<DefaultFreight> findDefaultFreightList() {
        return freightMapper.findDefaultFreightList();
    }

    /**
     * 添加默认重量运费模板
     *
     * @param defaultFreight
     * @return 操作状态码
     */
    public int addDefaultFreight(DefaultFreight defaultFreight) {
        defaultFreight.setGmtCreate(LocalDateTime.now());
        defaultFreight.setGmtModified(LocalDateTime.now());
        defaultFreight.setBeDeleted(false);

        return freightMapper.addDefaultFreight(defaultFreight);
    }

    /**
     * 更新默认重量运费模板
     *
     * @param defaultFreight
     * @return 操作状态码
     */
    public int updateDefaultFreight(DefaultFreight defaultFreight) {
        if(freightMapper.findDefaultFreightById(defaultFreight.getId())!=null)
        {
            defaultFreight.setGmtCreate(freightMapper.findDefaultFreightById(defaultFreight.getId()).getGmtCreate());
        }
        defaultFreight.setGmtModified(LocalDateTime.now());
        return freightMapper.updateDefaultFreight(defaultFreight);
    }

    /**
     * 删除默认重量运费模板
     *
     * @param id
     * @return 操作状态码
     */
    public int deleteDefaultFreightById(Integer id) {
        DefaultFreight defaultFreight=freightMapper.findDefaultFreightById(id);
        if(defaultFreight!=null)
        {
            defaultFreight.setGmtModified(LocalDateTime.now());
            freightMapper.updateDefaultFreight(defaultFreight);
        }
        return freightMapper.deleteDefaultFreightById(id);
    }

    /**
     * 根据ID查找默认件数运费模板
     *
     * @param id
     * @return 基于件数的默认运费模板
     */
    public DefaultPieceFreight findDefaultPieceFreightById(Integer id) {
        return freightMapper.findDefaultPieceFreightById(id);
    }

    /**
     * 管理员查看当前定义的所有默认件数运费模板
     *
     * @return 基于重量的默认运费模板
     */
    public  List<DefaultPieceFreight> findDefaultPieceFreightList() {
        return  freightMapper.findDefaultPieceFreightList();
    }

    /**
     * 添加默认件数运费模板
     *
     * @param defaultPieceFreight
     * @return 操作状态码
     */
    public int addDefaultPieceFreight(DefaultPieceFreight defaultPieceFreight) {
        defaultPieceFreight.setGmtCreate(LocalDateTime.now());
        defaultPieceFreight.setGmtModified(LocalDateTime.now());
        defaultPieceFreight.setBeDeleted(false);

        return freightMapper.addDefaultPieceFreight(defaultPieceFreight);
    }

    /**
     * 更新默认件数运费模板
     *
     * @param defaultPieceFreight
     * @return 操作状态码
     */
    public int updateDefaultPieceFreight(DefaultPieceFreight defaultPieceFreight) {
        if(freightMapper.findDefaultPieceFreightById(defaultPieceFreight.getId())!=null)
        {
            defaultPieceFreight.setGmtCreate(freightMapper.findDefaultPieceFreightById(defaultPieceFreight.getId()).getGmtCreate());
        }
        defaultPieceFreight.setGmtModified(LocalDateTime.now());
        return freightMapper.updateDefaultPieceFreight(defaultPieceFreight);
    }

    /**
     * 删除默认件数运费模板
     *
     * @param id
     * @return 操作状态码
     */
    public int deleteDefaultPieceFreightById(Integer id) {
        DefaultPieceFreight defaultPieceFreight=freightMapper.findDefaultPieceFreightById(id);
        if(defaultPieceFreight!=null)
        {
            defaultPieceFreight.setGmtModified(LocalDateTime.now());
            freightMapper.updateDefaultPieceFreight(defaultPieceFreight);
        }
        return freightMapper.deleteDefaultPieceFreightById(id);
    }
    public List<OrderItem> findItemsInAOrder(Order order)
    {
        return freightMapper.findOrderItemListByOrderId(order.getId());
    }

}
