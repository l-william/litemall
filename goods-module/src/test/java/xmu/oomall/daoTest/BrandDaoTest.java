package xmu.oomall.daoTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.dao.BrandDao;
import xmu.oomall.domain.Brand;
import xmu.oomall.domain.BrandPo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BrandDaoTest {

    @Autowired
    private BrandDao brandDao;

    @Test
    void findBrandList() {
        List<Brand> goods = brandDao.findBrandList();
        if(goods==null)
            System.out.println("not find!");
        else
            System.out.println(goods.size());
    }

    @Test
    void findBrandListByIdAndName() {
        Integer id=85;
        String name="张松茂";
        List<Brand> goods = brandDao.findBrandListByIdAndName(name,id.toString());
        if(goods==null)
            System.out.println("not find!");
        else
            System.out.println(goods.size());
    }

    @Test
    void findBrandById() {
        Integer id=85;
        Brand brand = brandDao.findBrandById(id);
        if(brand==null)
            System.out.println("not find!");
        else
            System.out.println(brand.getId());
    }

    @Test
    void addBrand() {
        BrandPo brand=new BrandPo();
        brand.setId(100007);
        if(brandDao.addBrand(brand)!=null)
        {
            System.out.println("add success");
        }
        else
        {
            System.out.println("failed");
        }
    }

    @Test
    void updateBrand() {
        BrandPo brandPo=new BrandPo();
        brandPo.setId(100001);
        brandPo.setPicUrl("brand");
        BrandPo retPo=brandDao.updateBrand(brandPo);
        if(retPo!=null)
        {
            System.out.println("update success");
        }
        else
        {
            System.out.println("failed");
        }

    }
    @Test
    void deleteBrand(){
        Integer id = 10006;

        if(brandDao.deleteBrand(id) == 1) {
            System.out.println("delete successfully!");
        } else {
            System.out.println("Failed!");
        }
    }
}