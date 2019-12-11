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


    @Override
    public List<DefaultFreight> findDefaultFreightsList() {
        return freightDao.findDefaultFreightList();
    }

    @Override
    public List<DefaultPieceFreight> findgetSpecialFreightList() {
        return freightDao.findDefaultPieceFreightList();
    }

    @Override
    public int addDefaultFreights(DefaultFreight defaultFreight) {
        return freightDao.addDefaultFreight(defaultFreight);
    }

    @Override
    public int addSpecialFreight(DefaultPieceFreight defaultPieceFreight) {
        return freightDao.addDefaultPieceFreight(defaultPieceFreight);
    }

    @Override
    public int deleteDefaultFreight(String id) {
        Integer defaultFreightid=Integer.valueOf(id);
        return freightDao.deleteDefaultFreightById(defaultFreightid);
    }

    @Override
    public int deleteSpecialFreight(String id) {
        Integer defaultPieceFreightid=Integer.valueOf(id);
        return freightDao.deleteDefaultPieceFreightById(defaultPieceFreightid);
    }

    @Override
    public int updateSpecialFreight(DefaultPieceFreight defaultPieceFreight) {
        return freightDao.updateDefaultPieceFreight(defaultPieceFreight);
    }

    @Override
    public int updateDefaultFreight(DefaultFreight defaultFreight) {
        return freightDao.updateDefaultFreight(defaultFreight);
    }

    @Override
    public double getFreight(Integer OrderId) {
        //调用order模块，拿到这个id的order下的所有orderitem，并计算重量进行下面的运算
        //有待调用的时候，进行重写,下面仅此为模拟占位
        Order order=new Order();
        //？？？？？？？？？？？？
        return 0;
    }

    @Override
    public DefaultFreight findDefaultFreightsById(Integer id) {
        return null;
    }

    @Override
    public DefaultPieceFreight findSpecialFreightById(Integer id) {
        return null;
    }
}
