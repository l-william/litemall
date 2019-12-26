package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.Product;
import xmu.oomall.domain.ProductPo;

import java.util.List;

@Service
/**
 * @author Administrator
 */
public interface ProductService {

    /**
     * 寻找产品
     *
     * @param id
     * @return 产品信息
     */
    ProductPo findProductById(Integer id);

    /**
     * 添加产品
     *
     * @param productPo
     * @return 新增的产品
     */
    ProductPo addProduct(ProductPo productPo);

    /**
     * 删除产品
     *
     * @param id
     * @return 是否操作成功
     */
    int deleteProduct(Integer id);

    /**
     * 更新产品
     *
     * @param productPo
     * @return 更新后的产品
     */
    ProductPo updateProduct(ProductPo productPo);

    /**
     * 寻找产品列表
     *
     * @param goodsId
     * @return 产品列表
     */
    List<ProductPo> findProductListByGoodsId(Integer goodsId);

    /**
     * 更新库存
     *
     * @param id
     * @param number
     * @return int
     */
    int updateStock(Integer id, Integer number);
}
