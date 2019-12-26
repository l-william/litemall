package xmu.oomall.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xmu.oomall.domain.Product;
import xmu.oomall.domain.ProductPo;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Administrator
 */
@Mapper
public interface ProductMapper {

    /**
     * 寻找产品
     *
     * @param id
     * @return
     */
    ProductPo findProductById(Integer id);

    /**
     * 添加产品
     *
     * @param productPo
     * @return status
     */
    int addProduct(ProductPo productPo);

    /**
     * 删除产品
     *
     * @param id
     * @param deleteTime
     * @return status
     */
    int deleteProduct(Integer id,LocalDateTime deleteTime);

    /**
     * 删除产品
     *
     * @param goodsId
     * @param deleteTime
     * @return status
     */
    int deleteProductByGoodsId(Integer goodsId,LocalDateTime deleteTime);

    /**
     * 更新产品
     *
     * @param productPo
     * @return status
     */
    int updateProduct(ProductPo productPo);

    /**
     * 选产品
     *
     * @param goodsId
     * @return
     */
    List<ProductPo> findProductListByGoodsId(Integer goodsId);


    /**
     * 更新库存
     *
     * @param id
     * @param number
     * @param updateTime
     * @return
     */
    int updateStock(Integer id,Integer number,LocalDateTime updateTime);

}
