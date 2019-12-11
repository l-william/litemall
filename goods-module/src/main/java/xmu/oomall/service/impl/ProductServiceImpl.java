package xmu.oomall.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.ProductDao;
import xmu.oomall.domain.Product;
import xmu.oomall.service.ProductService;

import java.util.List;

/**
 * 产品的service实现类
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    /**
     * 通过id查找产品
     *
     * @param id
     * @return 产品
     */
    @Override
    public Product findProductById(Integer id) {
        return productDao.findProductById(id);
    }

    /**
     * 添加产品
     *
     * @param product
     * @return 操作码
     */
    @Override
    public int addProduct(Product product) {
        return productDao.addProduct(product);
    }

    /**
     * 删除产品
     *
     * @param id
     * @return 操作码
     */
    @Override
    public int deleteProductById(Integer id) {
        return productDao.deleteProductById(id);
    }

    /**
     * 更新产品信息
     *
     * @param product
     * @return 操作成功与否
     */
    @Override
    public boolean updateProduct(Product product) {
        return productDao.updateProduct(product)==1;
    }

    /**
     * 查看产品列表
     *
     * @param productIds
     * @param goodsId
     * @return 产品列表
     */
    @Override
    public List<Product> findProductList(String productIds, Integer goodsId) {
        return productDao.findProductList(productIds,goodsId);
    }
}
