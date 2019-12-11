package xmu.oomall.serviceTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.domain.Product;
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
        if(productService.addProduct(product)==1)
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
        if(productService.deleteProductById(100008)==1)
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
        if(productService.updateProduct(product)==true)
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
        String product_ids = "100002";
        Integer goods_id = 100002;
        List<Product> productList = productService.findProductList(product_ids,goods_id);
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
