package xmu.oomall.daoTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.dao.ProductDao;
import xmu.oomall.domain.Product;
import xmu.oomall.domain.ProductPo;

import java.util.List;

/**
 * @author xiaoyutian
 * @date 2019/12/08
 */
@SpringBootTest
public class ProductDaoTest {
    @Autowired
    private ProductDao productDao;

    @Test
    void findProductById(){
        Integer a=100001;
        ProductPo product=productDao.findProductById(a);
        if(product==null)
            System.out.println("not find!");
        else
            System.out.println(product.getId());
    }

    @Test
    void addProduct(){
        Product product=new Product();
        product.setId(100007);
        if(productDao.addProduct(product)!=null)
        {
            System.out.println("add success");
        }
        else
        {
            System.out.println("failed");
        }
    }

    @Test
    void deleteAdById()
    {
        if(productDao.deleteProduct(100007)==1)
        {
            System.out.println("del success");
        }
        else
        {
            System.out.println("failed");
        }
    }
    @Test
    void updateProduct(){
        Product product=new Product();
        product.setId(100001);
        product.setPicUrl("asfsaf");
        if(productDao.updateProduct(product)!=null)
        {
            System.out.println("update success");
        }
        else
        {
            System.out.println("failed");
        }
    }
    @Test
    void findProductList()
    {
        Integer goods_id = 100002;
        List<ProductPo> productList = productDao.findProductListByGoodsId(goods_id);
        if(productList.isEmpty())
        {
            System.out.println("is null");
        }
        else
        {
            System.out.println("have "+productList.size());
        }
    }
}

