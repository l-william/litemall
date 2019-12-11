package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.Product;
import xmu.oomall.mapper.ProductMapper;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Administrator
 */
@Repository
public class ProductDao {

    @Autowired(required = false)
    private ProductMapper productMapper;
    public Product findProductById(Integer id){
        return productMapper.findProductById(id);
    }
    public int addProduct(Product product){
        product.setGmtCreate(LocalDateTime.now());
        product.setGmtModified(LocalDateTime.now());
        product.setBeDeleted(false);
        return productMapper.addProduct(product);
    }
    public int deleteProductById(Integer id){
        Product product=productMapper.findProductById(id);
        if(product!=null)
        {
            product.setGmtModified(LocalDateTime.now());
            productMapper.updateProduct(product);
        }
        return productMapper.deleteProductById(id);
    }
    public int updateProduct(Product product){
        if(productMapper.findProductById(product.getId())!=null)
        {
            product.setGmtModified(productMapper.findProductById(product.getId()).getGmtModified());
        }
        product.setGmtModified(LocalDateTime.now());
        return productMapper.updateProduct(product);
    }
    public List<Product> findProductList(String productIds, Integer goodsId){
        return productMapper.findProductList(productIds,goodsId);
    }
}
