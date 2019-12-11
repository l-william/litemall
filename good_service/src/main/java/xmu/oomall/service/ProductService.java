package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.Product;

import java.util.List;

@Service
public interface ProductService {

    /**
     * @param id
     * @return
     */
    public Product findProductById(Integer id);

    /**
     * @param product
     * @return status
     */
    public int addProduct(Product product);

    /**
     * @param id
     * @return status
     */
    public int deleteProductById(Integer id);

    /**
     * @param product
     * @return status
     */
    public boolean updateProduct(Product product);

    /**
     * @return status
     */
    public List<Product> findProductList(String productIds, Integer goodsId);
}
