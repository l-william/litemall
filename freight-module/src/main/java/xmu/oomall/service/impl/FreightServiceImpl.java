/**
 * @author xingzhou
 * @date 2019/12/8 22:33
 * @version 1.0
 */

package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.FreightDao;
import xmu.oomall.domain.DefaultFreight;
import xmu.oomall.domain.DefaultPieceFreight;
import xmu.oomall.domain.Order;
import xmu.oomall.service.FreightService;

import java.util.List;

/**
 * 运费的service实现类
 *
 */
@Service
public class FreightServiceImpl implements FreightService {
    @Autowired
    private FreightDao freightDao;


    /**
     * 查找默认运费
     *
     * @return 默认运费模板列表
     */
    @Override
    public List<DefaultFreight> findDefaultFreightsList() {
        return freightDao.findDefaultFreightList();
    }

    /**
     * 查找特殊运费
     *
     * @return 特殊运费模板列表
     */
    @Override
    public List<DefaultPieceFreight> findgetSpecialFreightList() {
        return freightDao.findDefaultPieceFreightList();
    }

    /**
     * 添加默认运费模板
     *
     * @param defaultFreight
     * @return 操作成功与否
     */
    @Override
    public int addDefaultFreights(DefaultFreight defaultFreight) {
        return freightDao.addDefaultFreight(defaultFreight);
    }

    /**
     * 添加特殊运费模板
     *
     * @param defaultPieceFreight
     * @return  操作成功与否
     */
    @Override
    public int addSpecialFreight(DefaultPieceFreight defaultPieceFreight) {
        return freightDao.addDefaultPieceFreight(defaultPieceFreight);
    }

    /**
     * 删除默认运费模板
     *
     * @param id
     * @return 操作成功与否
     */
    @Override
    public int deleteDefaultFreight(String id) {
        Integer defaultFreightid=Integer.valueOf(id);
        return freightDao.deleteDefaultFreightById(defaultFreightid);
    }

    /**
     * 删除特殊运费模板
     *
     * @param id
     * @return 操作成功与否
     */
    @Override
    public int deleteSpecialFreight(String id) {
        Integer defaultPieceFreightid=Integer.valueOf(id);
        return freightDao.deleteDefaultPieceFreightById(defaultPieceFreightid);
    }

    /**
     * 更新特殊运费模板
     *
     * @param defaultPieceFreight
     * @return 操作成功与否
     */
    @Override
    public int updateSpecialFreight(DefaultPieceFreight defaultPieceFreight) {
        return freightDao.updateDefaultPieceFreight(defaultPieceFreight);
    }

    /**
     * 更新默认运费模板
     *
     * @param defaultFreight
     * @return 操作成功与否
     */
    @Override
    public int updateDefaultFreight(DefaultFreight defaultFreight) {
        return freightDao.updateDefaultFreight(defaultFreight);
    }

    /**
     * 计算运费所需要的值
     *
     * @param OrderId
     * @return 计算好的运费
     */
    @Override
    public double getFreight(Integer OrderId) {
        //调用order模块，拿到这个id的order下的所有orderitem，并计算重量进行下面的运算
        //有待调用的时候，进行重写,下面仅此为模拟占位
        Order order=new Order();
        //？？？？？？？？？？？？
        return 0;
    }

    /**
     * 通过id查找默认运费模板
     *
     * @param id
     * @return 默认运费模板
     */
    @Override
    public DefaultFreight findDefaultFreightsById(Integer id) {
        return null;
    }

    /**
     * 通过id查找特殊运费模板
     *
     * @param id
     * @return 特殊默认运费模板
     */
    @Override
    public DefaultPieceFreight findSpecialFreightById(Integer id) {
        return null;
    }
}
