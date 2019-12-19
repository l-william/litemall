package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.Product;
import xmu.oomall.domain.ProductPo;
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
    public ProductPo findProductById(Integer id){
        return productMapper.findProductById(id);
    }

    /**
     * 添加产品
     *
     * @param productPo
     * @return 新增的产品
     */
    public ProductPo addProduct(ProductPo productPo){
        productPo.setGmtCreate(LocalDateTime.now());
        productPo.setGmtModified(LocalDateTime.now());
        productPo.setBeDeleted(false);
        int ret=productMapper.addProduct(productPo);
        if(ret==0){
            return null;
        }
        return productPo;
    }

    /**
     * 删除产品
     *
     * @param id
     * @return 操作成功与否
     */
    public int deleteProduct(Integer id){
        ProductPo productPo=productMapper.findProductById(id);
        if(productPo!=null)
        {
            productPo.setGmtModified(LocalDateTime.now());
            productMapper.updateProduct(productPo);
        }
        return productMapper.deleteProduct(id);
    }

    /**
     * 更新产品信息
     *
     * @param productPo
     * @return 更新后的产品
     */
    public ProductPo updateProduct(ProductPo productPo){
        if(productMapper.findProductById(productPo.getId())!=null)
        {
            productPo.setGmtModified(productMapper.findProductById(productPo.getId()).getGmtModified());
        }
        productPo.setGmtModified(LocalDateTime.now());
        int ret=productMapper.updateProduct(productPo);
        if(ret==0){
            return null;
        }
        return productPo;
    }

    /**
     * 查找产品列表
     *
     * @param goodsId
     * @return 产品列表
     */
    public List<ProductPo> findProductListByGoodsId(Integer goodsId){
        return productMapper.findProductListByGoodsId(goodsId);
    }

}
