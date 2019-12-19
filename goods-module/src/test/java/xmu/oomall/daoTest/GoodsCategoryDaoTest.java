package xmu.oomall.daoTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.dao.GoodsCategoryDao;
import xmu.oomall.domain.GoodsCategory;
import xmu.oomall.domain.GoodsCategoryPo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GoodsCategoryDaoTest {
    @Autowired
    private GoodsCategoryDao goodsCategoryDao;

    @Test
    void findGoodsCategoryById() {
        Integer id=122;
        GoodsCategoryPo goodsCategory=goodsCategoryDao.findGoodsCategoryById(id);
        if(goodsCategory==null)
            System.out.println("not find!");
        else
            System.out.println(goodsCategory.getId());

    }

    @Test
    void addGoodsCategory() {
        GoodsCategoryPo goodsCategory=new GoodsCategoryPo();
        goodsCategory.setId(100007);
        if(goodsCategoryDao.addGoodsCategory(goodsCategory)!=null)
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
        GoodsCategoryPo goodsCategory=new GoodsCategoryPo();
        goodsCategory.setId(100001);
        goodsCategory.setPicUrl("brand");
        if(goodsCategoryDao.updateGoodsCategory(goodsCategory)!=null)
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
        List<GoodsCategoryPo> goodsCategory=goodsCategoryDao.findGoodsCategoryList();
        if(goodsCategory==null)
            System.out.println("not find!");
        else
            System.out.println(goodsCategory.size());
    }

    @Test
    void findFirstLevelGoodsCategoryList() {
        List<GoodsCategoryPo> goodsCategory=goodsCategoryDao.findFirstLevelGoodsCategoryList();
        if(goodsCategory==null)
            System.out.println("not find!");
        else
            System.out.println(goodsCategory.size());
    }

    @Test
    void findSecondLevelGoodsCategoryList() {
        List<GoodsCategoryPo> goodsCategory=goodsCategoryDao.findSecondLevelGoodsCategoryList();
        if(goodsCategory==null)
            System.out.println("not find!");
        else
            System.out.println(goodsCategory.size());
    }

    @Test
    void findSecondLevelGoodsCategoryListByPid() {
        Integer id=122;
        List<GoodsCategoryPo> goodsCategory=goodsCategoryDao.findSecondLevelGoodsCategoryListByPid(id);
        if(goodsCategory==null)
            System.out.println("not find!");
        else
            System.out.println(goodsCategory.size());
    }
    @Test
    void deleteGoodsCategoryByPid(){
        Integer id = 10006;

        if(goodsCategoryDao.deleteGoodsCategoryByPid(id) == 1) {
            System.out.println("delete successfully!");
        } else {
            System.out.println("Failed!");
        }
    }
    @Test
    void updateGoodsCategoryPid(){
        GoodsCategoryPo goodsCategory=new GoodsCategoryPo();
        goodsCategory.setId(100001);
        goodsCategory.setPicUrl("brand");
        if(goodsCategoryDao.updateGoodsCategoryPid(goodsCategory)!=null)
        {
            System.out.println("update success");
        }
        else
        {
            System.out.println("failed");
        }
    }
}