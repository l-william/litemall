package xmu.oomall.mapper;


import org.apache.ibatis.annotations.Mapper;
import xmu.oomall.domain.GoodsCategory;

import java.util.List;

/**
 * @author lianh
 */
@Mapper
public interface GoodsCategoryMapper {
    /**
     * @param id
     * @return 对应ID的分类目录
     */
    GoodsCategory findGoodsCategoryById(Integer id);

    /**
     * @param pid
     * @return 一级目录下的二级目录列表
     */
    List<GoodsCategory> findGoodsCategoryListByPid(Integer pid);

    /**
     * @param goodsCategory
     * @return 操作状态码
     */
    int addGoodsCategory(GoodsCategory goodsCategory);

    /**
     * @param goodsCategory
     * @return 操作状态码
     */
    int updateGoodsCategory(GoodsCategory goodsCategory);

    /**
     * @param id
     * @return 操作状态码
     */
    int deleteGoodsCategoryById(Integer id);

    /**
     * @return 所有的商品分类
     */
    List<GoodsCategory> findGoodsCategoryList();

    /**
     * @return 所有的商品的一级分类
     */
    List<GoodsCategory> findOneLevelGoodsCategoryList();

    /**
     * @return 所有的商品的二级分类
     */
    List<GoodsCategory> findSecondLevelGoodsCategoryList();

}