/**
 * @author xingzhou
 * @date 2019/12/7 23:48
 * @version 1.0
 */

package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.GoodsDao;
import xmu.oomall.domain.Goods;
import xmu.oomall.service.GoodsService;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    /**
     * 查看商品列表
     *
     * @param goodsSn
     * @param name
     * @return 商品列表
     */
    @Override
    public List<Goods> findGoodsList(String goodsSn, String name) {
        return goodsDao.findGoodsListByGoodSnAndName(goodsSn,name);
    }

    /**
     * 通过id查找商品
     *
     * @param id
     * @return 商品
     */
    @Override
    public Goods findGoodsById(Integer id) {
        return goodsDao.findGoodsById(id);
    }

    /**
     * 更新商品信息
     *
     * @param goods
     * @return 操作码
     */
    @Override
    public int updateGoods(Goods goods) {
        return goodsDao.updateGoods(goods);
    }

    /**
     * 通过id删除商品
     *
     * @param id
     * @return  操作码
     */
    @Override
    public int deleteGoodsById(Integer id) {
        return goodsDao.deleteGoodsById(id);
    }

    /**
     * 添加商品
     *
     * @param goods
     * @return 操作码
     */
    @Override
    public int addGoods(Goods goods) {
        return goodsDao.addGoods(goods);
    }

    /**
     * 通过两个id查找商品
     *
     * @param userId
     * @param id
     * @return 商品
     */
    @Override
    public Goods findGoodsById(Integer userId, Integer id) {
        //记录用户的足迹待补充
        //！！！！！！！！！！
        return goodsDao.findGoodsById(userId,id);
    }

    /**
     * 通过很多信息一起搜索商品
     *
     * @param goodsCategoryId
     * @param brandId
     * @param keyword
     * @param isNew
     * @param isHot
     * @return 商品列表
     */
    @Override
    public List<Goods> findGoodsListBySearchInfo(Integer goodsCategoryId, Integer brandId, String keyword, Boolean isNew, Boolean isHot) {
        //待补充缺省值判断
        //！！！！！！！！
        return goodsDao.findGoodsListBySearchInfo(goodsCategoryId, brandId, keyword, isNew, isHot);
    }

    /**
     * 查找推荐商品
     *
     * @param id
     * @return 商品
     */
    @Override
    public Goods findRecommendedGoods(Integer id) {
        return goodsDao.findRecommendedGoods(id);
    }

    /**
     * 查看在售商品总数
     *
     * @return 操作码
     */
    @Override
    public int findGoodsCounts() {
        return goodsDao.getGoodsCount();
    }
}
