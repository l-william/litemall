/**
 * @author xingzhou
 * @date 2019/12/7 23:48
 * @version 1.0
 */
package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.Goods;
import xmu.oomall.domain.GoodsPo;

import javax.validation.OverridesAttribute;
import java.util.List;

@Service
public interface GoodsService {
    /**
     * 寻找商品
     *
     * @param goodsSn
     * @param name
     * @param page
     * @param limit
     * @return 商品列表(包括下架的）
     */
    List<GoodsPo> adminFindGoodsList(String goodsSn, String name,Integer page,Integer limit);

    /**
     * 寻找商品
     *
     * @param id
     * @return 商品信息(包括下架的）
     */
    GoodsPo adminFindGoodsById(Integer id);

    /**
     * 修改商品
     *
     * @param goodsPo
     * @return 更新后的商品
     */
    GoodsPo updateGoods(GoodsPo goodsPo);

    /**
     * 删除商品
     *
     * @param id
     * @return 返回操作结果
     */
    int deleteGoods(Integer id);

    /**
     * 新增商品
     *
     * @param goodsPo
     * @return 新增的商品
     */
    GoodsPo addGoods(GoodsPo goodsPo);

    /**
     * 寻找商品
     *
     * @param id
     * @return 商品信息(不包括下架的）
     */
    GoodsPo userFindGoodsById(Integer id);

    /**
     * 寻找商品
     *
     * @param name
     * @param page
     * @param limit
     * @return 商品列表(不包括下架的）
     */
    List<GoodsPo> userFindGoodsList(String name,Integer page,Integer limit);

    /**
     * 寻找品牌
     *
     * @param brandId
     * @return
     */
    List<GoodsPo> findGoodsListByBrandId(Integer brandId);

    /**
     * 寻找分类
     *
     * @param categoryId
     * @return
     */
    List<GoodsPo> findGoodsListByCategoryId(Integer categoryId);
}


