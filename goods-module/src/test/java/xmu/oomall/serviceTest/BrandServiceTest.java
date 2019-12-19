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
import xmu.oomall.domain.BrandPo;
import xmu.oomall.service.BrandService;

import java.util.List;

@SpringBootTest
public class BrandServiceTest {
    @Autowired
    private BrandService brandService;

    @Test
    void findBrandListByIdAndName(){
        List<BrandPo> brandList=brandService.findBrandListByIdAndName(123,"132",1,10);
        if(brandList==null) {
            System.out.println("null");
            return;
        }
        for (BrandPo brand:brandList) {
            System.out.println(brand.toString());
        }
    }

    @Test
    void findBrandList(){
        List<BrandPo> brandList=brandService.findBrandList(1, 10);
        if(brandList==null) {
            System.out.println("null");
            return;
        }
        for (BrandPo brand:brandList) {
            System.out.println(brand.toString());
        }
    }

    @Test
    void findBrandById(){
        if(brandService.findBrandById(100002)==null)
        {
            System.out.println("no find");
        }
        else
        {
            System.out.println(brandService.findBrandById(100002).getId());
        }

    }

    @Test
    void addBrand(){
        Brand brand=new Brand();
        brand.setName("cfh_add_Test");
        brand.setBeDeleted(false);
        brandService.addBrand(brand);
    }

    @Test
    void updateBrand(){
        BrandPo brand=new BrandPo();
        brand.setId(10005);
        brand.setBeDeleted(false);
        brand.setName("cfh_update_Test2");
        brandService.updateBrand(brand);
    }

    @Test
    void deleteBrand(){
        brandService.deleteBrand(10006);
    }
}
