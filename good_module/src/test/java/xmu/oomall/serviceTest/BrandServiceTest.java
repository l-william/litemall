/**
 * @author xingzhou
 * @date 2019/12/7 23:50
 * @version 1.0
 */

package xmu.oomall.serviceTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.domain.Brand;
import xmu.oomall.service.BrandService;

import java.util.List;

@SpringBootTest
public class BrandServiceTest {
    @Autowired
    private BrandService brandService;

    @Test
    void findBrandListByIdAndName(){
        List<Brand> brandList=brandService.findBrandListByIdAndName("001","",1,10);
        if(brandList==null) {
            System.out.println("null");
            return;
        }
        for (Brand brand:brandList) {
            System.out.println(brand.toString());
        }
    }

    @Test
    void findBrandList(){
        List<Brand> brandList=brandService.findBrandList(1, 10);
        if(brandList==null) {
            System.out.println("null");
            return;
        }
        for (Brand brand:brandList) {
            System.out.println(brand.toString());
        }
    }

    @Test
    void findBrandById(){
        Brand brand=brandService.findBrandById(10003);
        System.out.println(brand.toString());
    }

    @Test
    void addBrand(){
        Brand brand=new Brand();
        brand.setName("cfh_add_Test");
        brand.setBeDeleted(false);
        brandService.addBrand(brand);
    }

    @Test
    void updateBrandById(){
        Brand brand=new Brand();
        brand.setId(10005);
        brand.setBeDeleted(false);
        brand.setName("cfh_update_Test2");
        brandService.updateBrandById(10005,brand);
    }

    @Test
    void deleteBrand(){
        brandService.deleteBrandById(10006);
    }
}
