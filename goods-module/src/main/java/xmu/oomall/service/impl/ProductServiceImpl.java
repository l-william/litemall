package xmu.oomall.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.ProductDao;
import xmu.oomall.domain.Product;
import xmu.oomall.domain.ProductPo;
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
    public ProductPo findProductById(Integer id) {
        return productDao.findProductById(id);
    }

    /**
     * 添加产品
     *
     * @param productPo
     * @return 新增的产品
     */
    @Override
    public ProductPo addProduct(ProductPo productPo) {
        return productDao.addProduct(productPo);
    }

    /**
     * 删除产品
     *
     * @param id
     * @return 操作码
     */
    @Override
    public int deleteProduct(Integer id) {
        return productDao.deleteProduct(id);
    }

    /**
     * 更新产品信息
     *
     * @param productPo
     * @return 更新后的产品
     */
    @Override
    public ProductPo updateProduct(ProductPo productPo) {
        return productDao.updateProduct(productPo);
    }

    /**
     * 查看产品列表
     *
     * @param goodsId
     * @return 产品列表
     */
    @Override
    public List<ProductPo> findProductListByGoodsId(Integer goodsId) {
        return productDao.findProductListByGoodsId(goodsId);
    }

}
