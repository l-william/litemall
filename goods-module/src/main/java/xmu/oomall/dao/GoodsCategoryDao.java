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

@Repository
public class GoodsCategoryDao {
    @Autowired(required = false)
    private GoodsCategoryMapper goodsCategoryMapper;
    public GoodsCategory findGoodsCategoryById(Integer id)
    {
        return goodsCategoryMapper.findGoodsCategoryById(id);
    }
    public int addGoodsCategory(GoodsCategory goodsCategory)
    {
        goodsCategory.setGmtCreate(LocalDateTime.now());
        goodsCategory.setGmtModified(LocalDateTime.now());
        goodsCategory.setBeDeleted(false);
        return goodsCategoryMapper.addGoodsCategory(goodsCategory);
    }
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
    public int updateGoodsCategory(GoodsCategory goodsCategory)
    {
        if(goodsCategoryMapper.findGoodsCategoryById(goodsCategory.getId())!=null) {
            goodsCategory.setGmtCreate(goodsCategoryMapper.findGoodsCategoryById(goodsCategory.getId()).getGmtCreate());
        }
        goodsCategory.setGmtModified(LocalDateTime.now());
        return goodsCategoryMapper.updateGoodsCategory(goodsCategory);
    }
    public List<GoodsCategory> findGoodsCategoryList()
    {
        return goodsCategoryMapper.findGoodsCategoryList();
    }
    public List<GoodsCategory> findOneLevelGoodsCategoryList()
    {
        return goodsCategoryMapper.findOneLevelGoodsCategoryList();
    }
    public List<GoodsCategory> findSecondLevelGoodsCategoryList()
    {
        return goodsCategoryMapper.findSecondLevelGoodsCategoryList();
    }
    public List<GoodsCategory> findSecondLevelGoodsCategoryListById(Integer id)
    {
        return goodsCategoryMapper.findGoodsCategoryListByPid(id);
    }
}
