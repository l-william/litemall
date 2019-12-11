package xmu.oomall.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xmu.oomall.domain.Product;

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
    Product findProductById(Integer id);

    /**
     * @param product
     * @return status
     */
    int addProduct(Product product);

    /**
     * @param id
     * @return status
     */
    int deleteProductById(Integer id);

    /**
     * @param product
     * @return status
     */
    int updateProduct(Product product);

    /**
     * @return status
     */
    public List<Product> findProductList(@Param("productIds") String productIds, @Param("goodsId") Integer goodsId);
}
