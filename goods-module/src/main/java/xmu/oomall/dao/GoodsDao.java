/**
 * @author xingzhou
 * @date 2019/12/7 23:46
 * @version 1.0
 */

package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.Goods;
import xmu.oomall.domain.GoodsPo;
import xmu.oomall.mapper.GoodsMapper;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lianh
 * @date 2019/12/07
 * 商品dao层
 *
 */
@Repository
public class GoodsDao {
    @Autowired(required = false)
    private GoodsMapper goodsMapper;

    /**
     * 管理员通过商品流水号或者名称搜索商品
     *
     * @param goodsSn
     * @param name
     * @return
     */
    public List<GoodsPo> adminFindGoodsList(String goodsSn, String name)
    {
        return goodsMapper.adminFindGoodsList(goodsSn, name);
    }

    /**
     * 用户通过商品名称搜索商品
     *
     * @param name
     * @return
     */
    public List<GoodsPo> userFindGoodsList(String name)
    {
        return goodsMapper.userFindGoodsList(name);
    }

    /**
     * 管理员通过id查找商品
     *
     * @param id
     * @return 商品的详细信息
     */
    public GoodsPo adminFindGoodsById(Integer id)
    {
        return goodsMapper.adminFindGoodsById(id);
    }


    /**
     * 用户通过id查找商品
     *
     * @param id
     * @return
     */
    public GoodsPo userFindGoodsById(Integer id) {
        return goodsMapper.userFindGoodsById(id);
    }


    /**
     * 添加商品
     *
     * @param goodsPo
     * @return 操作状态码
     */
    public GoodsPo addGoods(GoodsPo goodsPo)
    {
        goodsPo.setGmtCreate(LocalDateTime.now());
        goodsPo.setGmtModified(LocalDateTime.now());
        goodsPo.setBeDeleted(false);
        int ret=goodsMapper.addGoods(goodsPo);
        if(ret==0){
            return null;
        }
        return goodsPo;
    }

    /**
     * 更新商品信息
     *
     * @param goodsPo
     * @return 操作状态码
     */
    public GoodsPo updateGoods(GoodsPo goodsPo)
    {
        if(goodsMapper.adminFindGoodsById(goodsPo.getId())!=null)
        {
            goodsPo.setGmtCreate(goodsMapper.adminFindGoodsById(goodsPo.getId()).getGmtCreate());
        }
        goodsPo.setGmtModified(LocalDateTime.now());
        int ret=goodsMapper.updateGoods(goodsPo);
        if(ret==0){
            return null;
        }
        return goodsPo;
    }

    /**
     * 通过id删除商品
     *
     * @param id
     * @return 操作状态码
     */
    public int deleteGoods(Integer id)
    {
        LocalDateTime deleteTime=LocalDateTime.now();
        return goodsMapper.deleteGoods(id,deleteTime);
    }

    public List<GoodsPo> findGoodsListByBrandId(Integer brandId)
    {
        return goodsMapper.findGoodsListByBrandId(brandId);
    }

    public List<GoodsPo> findGoodsListByCategoryId(Integer categoryId)
    {
        return goodsMapper.findGoodsListByCategoryId(categoryId);
    }
}

