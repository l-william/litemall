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

/**
 * 商品分类的service实现类
 */
@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {
@Autowired
    private GoodsCategoryDao goodsCategoryDao;

    /**
     * 通过id查找商品分类
     *
     * @param id
     * @return 商品分类
     */
    @Override
    public GoodsCategory findGoodsCategoryById(Integer id) {
        return goodsCategoryDao.findGoodsCategoryById(id);
    }

    /**
     * 新建商品分类
     *
     * @param goodsCategory
     * @return 操作码
     */
    @Override
    public int CreateGoodsCategory(GoodsCategory goodsCategory) {
        return goodsCategoryDao.addGoodsCategory(goodsCategory);
    }

    /**
     *通过id删除商品分类
     *
     * @param id
     * @return 操作码
     */
    @Override
    public int deleteGoodsCategory(Integer id) {
        return goodsCategoryDao.deleteGoodsCategory(id);
    }

    /**
     * 更新商品分类信息
     *
     * @param goodsCategory
     * @return 操作码
     */
    @Override
    public int updateGoodsCategory(GoodsCategory goodsCategory) {
        return goodsCategoryDao.updateGoodsCategory(goodsCategory);
    }

    /**
     * 查看商标分类列表
     *
     * @return 商品分类列表
     */
    @Override
    public List<GoodsCategory> findGoodsCategoryList() {
        return goodsCategoryDao.findGoodsCategoryList();
    }

    /**
     * 查看商品一级目录列表
     *
     * @return 商品分类列表
     */
    @Override
    public List<GoodsCategory> findOneLevelGoodsCategoryList() {
        return goodsCategoryDao.findOneLevelGoodsCategoryList();
    }

    /**
     * 查看商品二级目录列表
     *
     * @return 商品分类列表
     */
    @Override
    public List<GoodsCategory> findSecondLevelGoodsCategoryList() {
        return goodsCategoryDao.findSecondLevelGoodsCategoryList();
    }

    /**
     * 查看某一级目录下的二级目录列表
     *
     * @param id
     * @return 商品分类列表
     */
    @Override
    public List<GoodsCategory> findSecondLevelGoodsCategoryListById(Integer id) {
        return goodsCategoryDao.findSecondLevelGoodsCategoryListById(id);
    }
}
