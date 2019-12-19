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
     * @param goodsSn
     * @param name
     * @param page
     * @param limit
     * @return 商品列表(包括下架的）
     */
    List<GoodsPo> adminFindGoodsList(String goodsSn, String name,Integer page,Integer limit);

    /**
     * @param id
     * @return 商品信息(包括下架的）
     */
    GoodsPo adminFindGoodsById(Integer id);

    /**
     * @param goodsPo
     * @return 更新后的商品
     */
    GoodsPo updateGoods(GoodsPo goodsPo);

    /**
     * @param id
     * @return 返回操作结果
     */
    int deleteGoods(Integer id);

    /**
     * @param goodsPo
     * @return 新增的商品
     */
    GoodsPo addGoods(GoodsPo goodsPo);

    /**
     * @param id
     * @return 商品信息(不包括下架的）
     */
    GoodsPo userFindGoodsById(Integer id);

    /**
     * @param name
     * @param page
     * @param limit
     * @return 商品列表(不包括下架的）
     */
    List<GoodsPo> userFindGoodsList(String name,Integer page,Integer limit);

}


