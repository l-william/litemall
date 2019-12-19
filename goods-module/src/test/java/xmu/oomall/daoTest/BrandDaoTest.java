package xmu.oomall.daoTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.dao.BrandDao;
import xmu.oomall.domain.BrandPo;
import java.util.List;


@SpringBootTest
class BrandDaoTest {

    @Autowired
    private BrandDao brandDao;

    @Test
    void findBrandList() {
        List<BrandPo> goods = brandDao.findBrandList();
        if(goods==null)
            System.out.println("not find!");
        else
            System.out.println(goods.size());
    }

    @Test
    void findBrandListByIdAndName() {
        Integer id=85;
        String name="张松茂";
        List<BrandPo> goods = brandDao.findBrandListByIdAndName(id,name);
        if(goods==null)
            System.out.println("not find!");
        else
            System.out.println(goods.size());
    }

    @Test
    void findBrandById() {
        Integer id=85;
        BrandPo brand = brandDao.findBrandById(id);
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