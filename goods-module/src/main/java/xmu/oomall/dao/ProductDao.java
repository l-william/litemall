package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.Product;
import xmu.oomall.mapper.ProductMapper;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Administrator
 * 产品的dao层
 *
 */
@Repository
public class ProductDao {

    @Autowired(required = false)
    private ProductMapper productMapper;

    /**
     * 通过id查找产品
     *
     * @param id
     * @return 产品
     */
    public Product findProductById(Integer id){
        return productMapper.findProductById(id);
    }

    /**
     * 添加产品
     *
     * @param product
     * @return 操作成功与否
     */
    public int addProduct(Product product){
        product.setGmtCreate(LocalDateTime.now());
        product.setGmtModified(LocalDateTime.now());
        product.setBeDeleted(false);
        return productMapper.addProduct(product);
    }

    /**
     * 通过id删除产品
     *
     * @param id
     * @return 操作成功与否
     */
    public int deleteProductById(Integer id){
        Product product=productMapper.findProductById(id);
        if(product!=null)
        {
            product.setGmtModified(LocalDateTime.now());
            productMapper.updateProduct(product);
        }
        return productMapper.deleteProductById(id);
    }

    /**
     * 更新产品信息
     *
     * @param product
     * @return 操作成功与否
     */
    public int updateProduct(Product product){
        if(productMapper.findProductById(product.getId())!=null)
        {
            product.setGmtModified(productMapper.findProductById(product.getId()).getGmtModified());
        }
        product.setGmtModified(LocalDateTime.now());
        return productMapper.updateProduct(product);
    }

    /**
     * 查找产品列表
     *
     * @param productIds
     * @param goodsId
     * @return 产品列表
     */
    public List<Product> findProductList(String productIds, Integer goodsId){
        return productMapper.findProductList(productIds,goodsId);
    }
}
