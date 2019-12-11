/**
 * @author xingzhou
 * @date 2019/12/8 11:34
 * @version 1.0
 */

package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.GoodsCategoryDao;
import xmu.oomall.domain.GoodsCategory;
import xmu.oomall.service.GoodsCategoryService;

import java.util.List;

@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {
@Autowired
    private GoodsCategoryDao goodsCategoryDao;
    @Override
    public GoodsCategory findGoodsCategoryById(Integer id) {
        return goodsCategoryDao.findGoodsCategoryById(id);
    }

    @Override
    public int CreateGoodsCategory(GoodsCategory goodsCategory) {
        return goodsCategoryDao.addGoodsCategory(goodsCategory);
    }

    @Override
    public int deleteGoodsCategory(Integer id) {
        return goodsCategoryDao.deleteGoodsCategory(id);
    }

    @Override
    public int updateGoodsCategory(GoodsCategory goodsCategory) {
        return goodsCategoryDao.updateGoodsCategory(goodsCategory);
    }

    @Override
    public List<GoodsCategory> findGoodsCategoryList() {
        return goodsCategoryDao.findGoodsCategoryList();
    }

    @Override
    public List<GoodsCategory> findOneLevelGoodsCategoryList() {
        return goodsCategoryDao.findOneLevelGoodsCategoryList();
    }

    @Override
    public List<GoodsCategory> findSecondLevelGoodsCategoryList() {
        return goodsCategoryDao.findSecondLevelGoodsCategoryList();
    }

    @Override
    public List<GoodsCategory> findSecondLevelGoodsCategoryListById(Integer id) {
        return goodsCategoryDao.findSecondLevelGoodsCategoryListById(id);
    }
}
