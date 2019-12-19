package xmu.oomall.daoTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.dao.GoodsCategoryDao;
import xmu.oomall.domain.GoodsCategory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoodsCategoryDaoTest {
    @Autowired
    private GoodsCategoryDao goodsCategoryDao;

    @Test
    void findGoodsCategoryById() {
        Integer id=122;
        GoodsCategory goodsCategory=goodsCategoryDao.findGoodsCategoryById(id);
        if(goodsCategory==null)
            System.out.println("not find!");
        else
            System.out.println(goodsCategory.getId());

    }

    @Test
    void addGoodsCategory() {
        GoodsCategory goodsCategory=new GoodsCategory();
        goodsCategory.setId(100007);
        if(goodsCategoryDao.addGoodsCategory(goodsCategory)==1)
        {
            System.out.println("add success");
        }
        else
        {
            System.out.println("failed");
        }
    }

    @Test
    void deleteGoodsCategory() {
        Integer id = 10006;

        if(goodsCategoryDao.deleteGoodsCategory(id) == 1) {
            System.out.println("delete successfully!");
        } else {
            System.out.println("Failed!");
        }
    }

    @Test
    void updateGoodsCategory() {
        GoodsCategory goodsCategory=new GoodsCategory();
        goodsCategory.setId(100001);
        goodsCategory.setPicUrl("brand");
        if(goodsCategoryDao.updateGoodsCategory(goodsCategory)==1)
        {
            System.out.println("update success");
        }
        else
        {
            System.out.println("failed");
        }
    }

    @Test
    void findGoodsCategoryList() {
        List<GoodsCategory> goodsCategory=goodsCategoryDao.findGoodsCategoryList();
        if(goodsCategory==null)
            System.out.println("not find!");
        else
            System.out.println(goodsCategory.size());
    }

    @Test
    void findOneLevelGoodsCategoryList() {
        List<GoodsCategory> goodsCategory=goodsCategoryDao.findOneLevelGoodsCategoryList();
        if(goodsCategory==null)
            System.out.println("not find!");
        else
            System.out.println(goodsCategory.size());
    }

    @Test
    void findSecondLevelGoodsCategoryList() {
        List<GoodsCategory> goodsCategory=goodsCategoryDao.findSecondLevelGoodsCategoryList();
        if(goodsCategory==null)
            System.out.println("not find!");
        else
            System.out.println(goodsCategory.size());
    }

    @Test
    void findSecondLevelGoodsCategoryListById() {
        Integer id=122;
        List<GoodsCategory> goodsCategory=goodsCategoryDao.findSecondLevelGoodsCategoryListById(id);
        if(goodsCategory==null)
            System.out.println("not find!");
        else
            System.out.println(goodsCategory.size());
    }
}