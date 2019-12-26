package xmu.oomall.mapper;


import org.apache.ibatis.annotations.Mapper;
import xmu.oomall.domain.GoodsCategory;
import xmu.oomall.domain.GoodsCategoryPo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lianh
 */
@Mapper
public interface GoodsCategoryMapper {
    /**
     * 寻找分类
     *
     * @param id
     * @return 对应ID的分类目录
     */
    GoodsCategoryPo findGoodsCategoryById(Integer id);

    /**
     * 寻找分类
     *
     * @param pid
     * @return 一级目录下的二级目录列表
     */
    List<GoodsCategoryPo> findGoodsCategoryListByPid(Integer pid);

    /**
     * 增加分类
     *
     * @param goodsCategoryPo
     * @return 操作状态码
     */
    int addGoodsCategory(GoodsCategoryPo goodsCategoryPo);

    /**
     * 更新分类
     *
     * @param goodsCategoryPo
     * @return 操作状态码
     */
    int updateGoodsCategory(GoodsCategoryPo goodsCategoryPo);

    /**
     * 更新分类
     *
     * @param goodsCategoryPo
     * @return 操作状态码
     */
    int updateGoodsCategoryPid(GoodsCategoryPo goodsCategoryPo);

    /**
     * 删除分类
     *
     * @param id
     * @param deleteTime
     * @return 操作状态码
     */
    int deleteGoodsCategory(Integer id, LocalDateTime deleteTime);

    /**
     * 删除分类
     *
     * @param pid
     * @param deleteTime
     * @return 操作状态码
     */
    int deleteGoodsCategoryByPid(Integer pid,LocalDateTime deleteTime);

    /**
     * 寻找商品分类
     *
     * @return 所有的商品分类
     */
    List<GoodsCategoryPo> findGoodsCategoryList();

    /**
     * 寻找一级分类
     *
     * @return 所有的商品的一级分类
     */
    List<GoodsCategoryPo> findFirstLevelGoodsCategoryList();

    /**
     * 寻找二级分类
     *
     * @return 所有的商品的二级分类
     */
    List<GoodsCategoryPo> findSecondLevelGoodsCategoryList();

}