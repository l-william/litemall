package xmu.oomall.mapper;


import org.apache.ibatis.annotations.Mapper;
import xmu.oomall.domain.Goods;

import java.util.List;

/**
 * @author lianh
 * @date 2019/12/07
 */
@Mapper
public interface GoodsMapper {

    /**
     * @param id
     * @return 商品详细信息
     */
    Goods findGoodsById(Integer id);

    /**
     * @param goodsSn
     * @param name
     * @return 关键词的模糊查询结果
     */
    List<Goods> findGoodsListByGoodsSnAndName(String goodsSn, String name);

    /**
     * @param goods
     * @return 操作状态码
     */
    int addGoods(Goods goods);

    /**
     * @param goods
     * @return 操作状态码
     */
    int updateGoods(Goods goods);

    /**
     * @param id
     * @return 操作状态码
     */
    int deleteGoodsById(Integer id);

    /**
     * @return 在售商品数量
     */
    int getGoodsCount();

}