/**
 * @author xingzhou
 * @date 2019/12/7 23:48
 * @version 1.0
 */
package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.Goods;

import javax.validation.OverridesAttribute;
import java.util.List;

@Service
public interface GoodsService {
    /**
     * @param goodsn
     * @param name
     * @return 查找到的goods列表
     */
    public List<Goods> findGoodsList(String goodsn,String name);

    /**
     * @param id
     * @return 查找到的商品
     */
    public Goods findGoodsById(Integer id);

    /**
     * @param goods
     * @return 返回操作结果
     */
    public int updateGoods(Goods goods);

    /**
     * @param id
     * @return 返回操作结果
     */
    public int deleteGoodsById(Integer id);

    /**
     * @param goods
     * @return 操作结果
     */
    public int addGoods(Goods goods);

    /**
     * @param userId
     * @param id
     * @return 返回的是找到的商品
     */
    public Goods findGoodsById(Integer userId,Integer id);

    /**
     * @param goodsCategoryId
     * @param brandId
     * @param keyword
     * @param isNew
     * @param isHot
     * @return 找到的商品列表
     */
    public List<Goods>findGoodsListBySearchInfo(Integer goodsCategoryId, Integer brandId, String keyword, Boolean isNew, Boolean isHot);

    /**
     * @param id
     * @return 找到的推荐商品列表
     */
    public Goods findRecommendedGoods(Integer id);

    /**
     * @return 在售商品总数
     */
    public int findGoodsCounts();

}


