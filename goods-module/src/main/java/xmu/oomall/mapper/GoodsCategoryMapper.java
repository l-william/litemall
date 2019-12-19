package xmu.oomall.mapper;


import org.apache.ibatis.annotations.Mapper;
import xmu.oomall.domain.GoodsCategory;
import xmu.oomall.domain.GoodsCategoryPo;

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
    GoodsCategoryPo findGoodsCategoryById(Integer id);

    /**
     * @param pid
     * @return 一级目录下的二级目录列表
     */
    List<GoodsCategoryPo> findGoodsCategoryListByPid(Integer pid);

    /**
     * @param goodsCategoryPo
     * @return 新增的分类
     */
    GoodsCategoryPo addGoodsCategory(GoodsCategoryPo goodsCategoryPo);

    /**
     * @param goodsCategoryPo
     * @return 更新后的分类
     */
    GoodsCategoryPo updateGoodsCategory(GoodsCategoryPo goodsCategoryPo);

    /**
     * @param goodsCategoryPo
     * @return 更新后的分类
     */
    GoodsCategoryPo updateGoodsCategoryPid(GoodsCategoryPo goodsCategoryPo);

    /**
     * @param id
     * @return 操作状态码
     */
    int deleteGoodsCategory(Integer id);

    /**
     * @param pid
     * @return 操作状态码
     */
    int deleteGoodsCategoryByPid(Integer pid);

    /**
     * @return 所有的商品分类
     */
    List<GoodsCategoryPo> findGoodsCategoryList();

    /**
     * @return 所有的商品的一级分类
     */
    List<GoodsCategoryPo> findFirstLevelGoodsCategoryList();

    /**
     * @return 所有的商品的二级分类
     */
    List<GoodsCategoryPo> findSecondLevelGoodsCategoryList();

}