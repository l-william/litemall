/**
 * @author xingzhou
 * @date 2019/12/8 22:33
 * @version 1.0
 */

package xmu.oomall.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.FreightDao;
import xmu.oomall.domain.*;
import xmu.oomall.service.FreightService;

import java.awt.geom.RoundRectangle2D;
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
    public List<DefaultFreight> findDefaultFreightsList(Integer page,Integer limit) {
        PageHelper.startPage(page,limit);
        return freightDao.findDefaultFreightList();
    }

    /**
     * 查找默认运费比率表
     *
     * @return 默认运费比率表
     */
    @Override
    public List<DefaultPieceFreight> findDefaultPieceFreightList() {
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
     * 添加默认运费比率
     *
     * @param defaultPieceFreight
     * @return 操作码
     */
    @Override
    public int addDefaultPieceFreights(DefaultPieceFreight defaultPieceFreight) {
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
     * 删除默认运费比率
     *
     * @param id
     * @return 操作码
     */
    @Override
    public int deleteDefaultPieceFreight(String id) {
        Integer defaultPieceFreightid=Integer.valueOf(id);
        return freightDao.deleteDefaultPieceFreightById(defaultPieceFreightid);
    }

    /**
     * 更新默认运费比率
     *
     * @param defaultPieceFreight
     * @return 操作码
     */
    @Override
    public int updateDefaultPieceFreight(DefaultPieceFreight defaultPieceFreight) {
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
     * @param order
     * @return 计算好的运费
     */
    @Override
    public double getFreight(Order order) {
        //思路：
        /*
        先从找到order对应的orderitem
        然后根据orderitem对应的goods判断商品的运费模板的模式
        然后根据运费模板计算运费。。。
        ？？？？重量在哪？
         */
        if(order==null) {
            return -1;
        }
        List <OrderItem> orderItemList=freightDao.findItemsInAOrder(order);
        List<Integer> SpecialFreightID = null;
        //记录特殊模板的id
        List<Double> weight=null;
        //记录每个商品的重量
        List<Integer> nums=null;
        //记录每个商品的件数
        for(OrderItem orderItem:orderItemList)
        {
            Integer goodsId=orderItem.getGoodsId();
            //调用商品服务中的findgoodsbyid查看其运费模板类别
            //暂时不知道怎么调用，先占位模拟逻辑过程
            //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            Goods goods=new Goods();
            //goods=GoodsController.findGoodsById(goodsId);
            if(goods.getBeSpecial())
            {
                SpecialFreightID.add(goods.getSpecialFreightId());
            }
            weight.add(goods.getWeight().doubleValue()*orderItem.getNumber());
            nums.add(orderItem.getNumber());
        }
        double freeFreightPrice =998;
        //包邮的阀值价格
        if(order.getGoodsPrice().doubleValue()>=freeFreightPrice) {
            return 0;
        }
        //先计算默认运费模板：

        //再计算特殊运费模板(多种特殊运费模板)：
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

        return freightDao.findDefaultFreightById(id);
    }

    /**
     * 通过id查找默认运费比率
     *
     * @param id
     * @return 默认运费比率
     */
    @Override
    public DefaultPieceFreight findDefaultPieceFreightById(Integer id) {
        return freightDao.findDefaultPieceFreightById(id);
    }

}
