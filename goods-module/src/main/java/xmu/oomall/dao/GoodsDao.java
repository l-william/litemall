/**
 * @author xingzhou
 * @date 2019/12/7 23:46
 * @version 1.0
 */

package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.Goods;
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
     * @return 关键词的模糊查找
     */
    public List<Goods> findGoodsListByGoodSnAndName(String goodsSn, String name)
    {
        return goodsMapper.findGoodsListByGoodsSnAndName(goodsSn, name);
    }

    /**
     * 通过id查找商品
     *
     * @param id
     * @return 商品的详细信息
     */
    public Goods findGoodsById(Integer id)
    {
        return goodsMapper.findGoodsById(id);
    }

    /**
     * 尚未写完整
     *
     * @param goodsCategoryId
     * @param brandId
     * @param keyword
     * @param isNew
     * @param isHot
     * @return
     */
    public List<Goods> findGoodsListBySearchInfo(Integer goodsCategoryId, Integer brandId,
                       String keyword, boolean isNew, boolean isHot) {
        return null;
    }

    /**
     * 尚未写完整
     *
     * @param userId
     * @param goodsId
     * @return
     */
    public Goods findGoodsById(Integer userId, Integer goodsId) {
        return null;
    }

    /**
     * 尚未写完整
     *
     * @param id
     * @return
     */
    public Goods findRecommendedGoods(Integer id) {
        return null;
    }

    /**
     * 添加商品
     *
     * @param goods
     * @return 操作状态码
     */
    public int addGoods(Goods goods)
    {
        goods.setGmtCreate(LocalDateTime.now());
        goods.setGmtModified(LocalDateTime.now());
        goods.setBeDeleted(false);

        return goodsMapper.addGoods(goods);
    }

    /**
     * 更新商品信息
     *
     * @param goods
     * @return 操作状态码
     */
    public int updateGoods(Goods goods)
    {
        if(goodsMapper.findGoodsById(goods.getId())!=null)
        {
            goods.setGmtCreate(goodsMapper.findGoodsById(goods.getId()).getGmtCreate());
        }
        goods.setGmtModified(LocalDateTime.now());
        return goodsMapper.updateGoods(goods);
    }

    /**
     * 通过id删除商品
     *
     * @param id
     * @return 操作状态码
     */
    public int deleteGoodsById(Integer id)
    {
        Goods goods=goodsMapper.findGoodsById(id);
        if(goods!=null)
        {
            goods.setGmtModified(LocalDateTime.now());
            goodsMapper.updateGoods(goods);
        }
        return goodsMapper.deleteGoodsById(id);
    }

    /**
     * 获取商品在售的总数
     *
     * @return 在售商品数量
     */
    public int getGoodsCount() {
        return goodsMapper.getGoodsCount();
    }
}

