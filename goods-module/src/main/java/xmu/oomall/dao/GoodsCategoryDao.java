/**
 * @author xingzhou
 * @date 2019/12/8 10:24
 * @version 1.0
 */

package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.GoodsCategory;
import xmu.oomall.mapper.GoodsCategoryMapper;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 商品分类的dao层
 */
@Repository
public class GoodsCategoryDao {
    @Autowired(required = false)
    private GoodsCategoryMapper goodsCategoryMapper;
    public GoodsCategory findGoodsCategoryById(Integer id)
    {
        return goodsCategoryMapper.findGoodsCategoryById(id);
    }

    /**
     * 添加商品分类
     *
     * @param goodsCategory
     * @return 操作成功与否
     */
    public int addGoodsCategory(GoodsCategory goodsCategory)
    {
        goodsCategory.setGmtCreate(LocalDateTime.now());
        goodsCategory.setGmtModified(LocalDateTime.now());
        goodsCategory.setBeDeleted(false);
        return goodsCategoryMapper.addGoodsCategory(goodsCategory);
    }

    /**
     * 删除商品分类，通过id
     *
     * @param id
     * @return 操作成功与否
     */
    public int deleteGoodsCategory(Integer id)
    {
        GoodsCategory goodsCategory=goodsCategoryMapper.findGoodsCategoryById(id);
        if(goodsCategory!=null)
        {
            goodsCategory.setGmtModified(LocalDateTime.now());
            goodsCategoryMapper.updateGoodsCategory(goodsCategory);
        }
        return goodsCategoryMapper.deleteGoodsCategoryById(id);
    }

    /**
     * 更新商品分类
     *
     * @param goodsCategory
     * @return 操作成功与否
     */
    public int updateGoodsCategory(GoodsCategory goodsCategory)
    {
        if(goodsCategoryMapper.findGoodsCategoryById(goodsCategory.getId())!=null) {
            goodsCategory.setGmtCreate(goodsCategoryMapper.findGoodsCategoryById(goodsCategory.getId()).getGmtCreate());
        }
        goodsCategory.setGmtModified(LocalDateTime.now());
        return goodsCategoryMapper.updateGoodsCategory(goodsCategory);
    }

    /**
     * 查看商品分类列表
     *
     * @return 商品分类列表
     */
    public List<GoodsCategory> findGoodsCategoryList()
    {
        return goodsCategoryMapper.findGoodsCategoryList();
    }

    /**
     * 查看商品一级目录列表
     *
     * @return 商品分类列表
     */
    public List<GoodsCategory> findOneLevelGoodsCategoryList()
    {
        return goodsCategoryMapper.findOneLevelGoodsCategoryList();
    }

    /**
     * 查看商品二级目录列表
     *
     * @return 商品分类列表
     */
    public List<GoodsCategory> findSecondLevelGoodsCategoryList()
    {
        return goodsCategoryMapper.findSecondLevelGoodsCategoryList();
    }

    /**
     * 查看某个一级目录下的二级目录列表
     *
     * @param id
     * @return 商品分类列表
     */
    public List<GoodsCategory> findSecondLevelGoodsCategoryListById(Integer id)
    {
        return goodsCategoryMapper.findGoodsCategoryListByPid(id);
    }
}
