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
     * @param goodsSn
     * @param name
     * @return 商品列表(包括下架的）
     */
    List<GoodsPo> adminFindGoodsList(String goodsSn, String name);

    /**
     * @param id
     * @return 商品信息(包括下架的）
     */
    GoodsPo adminFindGoodsById(Integer id);

    /**
     * @param goodsPo
     * @return 操作结果码
     */
    int updateGoods(GoodsPo goodsPo);

    /**
     * @param id
     * @param deleteTime
     * @return 操作结果码
     */
    int deleteGoods(Integer id, LocalDateTime deleteTime);

    /**
     * @param goodsPo
     * @return 操作结果码
     */
    int addGoods(GoodsPo goodsPo);

    /**
     * @param id
     * @return 商品信息(不包括下架的）
     */
    GoodsPo userFindGoodsById(Integer id);

    /**
     * @param name
     * @return 商品列表(不包括下架的）
     */
    List<GoodsPo> userFindGoodsList(String name);

    /**
     * @param brandId
     * @return 商品列表
     */
    List<GoodsPo> findGoodsListByBrandId(Integer brandId);

    /**
     * @param categoryId
     * @return 商品列表
     */
    List<GoodsPo> findGoodsListByCategoryId(Integer categoryId);
}