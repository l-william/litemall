package xmu.oomall.serviceTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.domain.Product;
import xmu.oomall.domain.ProductPo;
import xmu.oomall.service.ProductService;

import java.util.List;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productService;
    @Test
    void findProductById(){
        if(productService.findProductById(100002)==null)
        {
            System.out.println("no find");
        }
        else
        {
            System.out.println(productService.findProductById(100002).getId());
        }
    }

    @Test
    void addProduct(){
        Product product=new Product();
        product.setId(100007);
        if(productService.addProduct(product)!=null)
        {
            System.out.println("add success");
        }
        else
        {
            System.out.println("failed");
        }
    }

    @Test
    void deleteProduct()
    {
        if(productService.deleteProduct(100008)==1)
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
        product.setPicUrl("weqwqwqr");
        if(productService.updateProduct(product)!=null)
        {
            System.out.println("update success");
        }
        else
        {
            System.out.println("failed");
        }
    }
    @Test
    void findProductListByGoodsId()
    {
        Integer goods_id = 100002;
        List<ProductPo> productList = productService.findProductListByGoodsId(goods_id);
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
