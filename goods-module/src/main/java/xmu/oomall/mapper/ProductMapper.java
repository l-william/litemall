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
     * @param id
     * @return
     */
    ProductPo findProductById(Integer id);

    /**
     * @param productPo
     * @return status
     */
    int addProduct(ProductPo productPo);

    /**
     * @param id
     * @param deleteTime
     * @return status
     */
    int deleteProduct(Integer id,LocalDateTime deleteTime);

    /**
     * @param goodsId
     * @param deleteTime
     * @return status
     */
    int deleteProductByGoodsId(Integer goodsId,LocalDateTime deleteTime);

    /**
     * @param productPo
     * @return status
     */
    int updateProduct(ProductPo productPo);

    /**
     * @return
     */
    List<ProductPo> findProductListByGoodsId(Integer goodsId);


    /**
     * @param id
     * @param number
     * @param updateTime
     * @return
     */
    int updateStock(Integer id,Integer number,LocalDateTime updateTime);

}
