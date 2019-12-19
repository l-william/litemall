package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.Product;
import xmu.oomall.domain.ProductPo;

import java.util.List;

@Service
public interface ProductService {

    /**
     * @param id
     * @return 产品信息
     */
    ProductPo findProductById(Integer id);

    /**
     * @param productPo
     * @return 新增的产品
     */
    ProductPo addProduct(ProductPo productPo);

    /**
     * @param id
     * @return 是否操作成功
     */
    int deleteProduct(Integer id);

    /**
     * @param productPo
     * @return 更新后的产品
     */
    ProductPo updateProduct(ProductPo productPo);

    /**
     * @param goodsId
     * @return 产品列表
     */
    List<ProductPo> findProductListByGoodsId(Integer goodsId);
}
