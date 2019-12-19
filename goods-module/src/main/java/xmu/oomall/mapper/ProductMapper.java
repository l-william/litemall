package xmu.oomall.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xmu.oomall.domain.Product;
import xmu.oomall.domain.ProductPo;

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
     * @return
     */
    ProductPo addProduct(ProductPo productPo);

    /**
     * @param id
     * @return status
     */
    int deleteProduct(Integer id);

    /**
     * @param productPo
     * @return
     */
    ProductPo updateProduct(ProductPo productPo);

    /**
     * @return
     */
    List<ProductPo> findProductListByGoodsId(Integer goodsId);

}
