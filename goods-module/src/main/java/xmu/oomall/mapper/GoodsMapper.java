package xmu.oomall.mapper;


import org.apache.ibatis.annotations.Mapper;
import xmu.oomall.domain.Goods;
import xmu.oomall.domain.GoodsPo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lianh
 * @date 2019/12/07
 */
@Mapper
public interface GoodsMapper {

    /**
     *adminFindGoodsList
     *
     * @param goodsSn
     * @param name
     * @return 商品列表(包括下架的）
     */
    List<GoodsPo> adminFindGoodsList(String goodsSn, String name);

    /**
     * adminFindGoodsById
     *
     * @param id
     * @return 商品信息(包括下架的）
     */
    GoodsPo adminFindGoodsById(Integer id);

    /**
     * updateGoods
     *
     * @param goodsPo
     * @return 操作结果码
     */
    int updateGoods(GoodsPo goodsPo);

    /**
     * deleteGoods
     *
     * @param id
     * @param deleteTime
     * @return 操作结果码
     */
    int deleteGoods(Integer id, LocalDateTime deleteTime);

    /**
     * addGoods
     *
     * @param goodsPo
     * @return 操作结果码
     */
    int addGoods(GoodsPo goodsPo);

    /**
     * userFindGoodsById
     *
     * @param id
     * @return 商品信息(不包括下架的）
     */
    GoodsPo userFindGoodsById(Integer id);

    /**
     * userFindGoodsList
     *
     * @param name
     * @return 商品列表(不包括下架的）
     */
    List<GoodsPo> userFindGoodsList(String name);

    /**
     * findGoodsListByBrandId
     *
     * @param brandId
     * @return 商品列表
     */
    List<GoodsPo> findGoodsListByBrandId(Integer brandId);

    /**
     * findGoodsListByCategoryId
     *
     * @param categoryId
     * @return 商品列表
     */
    List<GoodsPo> findGoodsListByCategoryId(Integer categoryId);
}