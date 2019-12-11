package xmu.oomall.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.ProductDao;
import xmu.oomall.domain.Product;
import xmu.oomall.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product findProductById(Integer id) {
        return productDao.findProductById(id);
    }

    @Override
    public int addProduct(Product product) {
        return productDao.addProduct(product);
    }

    @Override
    public int deleteProductById(Integer id) {
        return productDao.deleteProductById(id);
    }

    @Override
    public boolean updateProduct(Product product) {
        return productDao.updateProduct(product)==1;
    }

    @Override
    public List<Product> findProductList(String productIds, Integer goodsId) {
        return productDao.findProductList(productIds,goodsId);
    }
}
