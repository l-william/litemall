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
    @Override
    public List<Goods> findGoodsList(String goodsSn, String name) {
        return goodsDao.findGoodsListByGoodSnAndName(goodsSn,name);
    }

    @Override
    public Goods findGoodsById(Integer id) {
        return goodsDao.findGoodsById(id);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsDao.updateGoods(goods);
    }

    @Override
    public int deleteGoodsById(Integer id) {
        return goodsDao.deleteGoodsById(id);
    }

    @Override
    public int addGoods(Goods goods) {
        return goodsDao.addGoods(goods);
    }

    @Override
    public Goods findGoodsById(Integer userId, Integer id) {
        //记录用户的足迹待补充
        //！！！！！！！！！！
        return goodsDao.findGoodsById(userId,id);
    }

    @Override
    public List<Goods> findGoodsListBySearchInfo(Integer goodsCategoryId, Integer brandId, String keyword, Boolean isNew, Boolean isHot) {
        //待补充缺省值判断
        //！！！！！！！！
        return goodsDao.findGoodsListBySearchInfo(goodsCategoryId, brandId, keyword, isNew, isHot);
    }

    @Override
    public Goods findRecommendedGoods(Integer id) {
        return goodsDao.findRecommendedGoods(id);
    }

    @Override
    public int findGoodsCounts() {
        return goodsDao.getGoodsCount();
    }
}
