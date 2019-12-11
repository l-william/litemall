/**
 * @author xingzhou
 * @date 2019/12/8 12:05
 * @version 1.0
 */

package xmu.oomall.serviceTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.domain.GoodsCategory;
import xmu.oomall.service.GoodsCategoryService;

import java.util.List;

@SpringBootTest
public class GoodsCategoryServiceTest {
    @Autowired
    private GoodsCategoryService goodsCategoryService;
    @Test
    public void findGoodsCategoryById()
    {
        GoodsCategory goodsCategory=goodsCategoryService.findGoodsCategoryById(10001);
        if(goodsCategory==null)
        {
            System.out.println("not find");
        }
        else
        {
            System.out.println(goodsCategory.toString());
        }
    }
    @Test
    public void createGoodsCategory()
    {
        GoodsCategory goodsCategory=new GoodsCategory();
        goodsCategory.setName("医药用品");
        if(goodsCategoryService.CreateGoodsCategory(goodsCategory)==1)
        {
            System.out.println("create success");
        }
        else
        {

            System.out.println("create failed");
        }
    }
    @Test
    public void deleteGoodsCategory()
    {
        if(goodsCategoryService.deleteGoodsCategory(10001)==1) {
            System.out.println("delete success");
        }
        else {
            System.out.println("delete failed");
        }
    }
    @Test
    public void updateGoodsCategory()
    {
        GoodsCategory goodsCategory=new GoodsCategory();
        goodsCategory.setId(10002);
        goodsCategory.setName("床上用品");
        if(goodsCategoryService.updateGoodsCategory(goodsCategory)==1)
        {
            System.out.println("update success");
        }
        else
        {
            System.out.println("update failed");
        }
    }

    @Test
    public void findGoodsCategoryList()
    {
        List<GoodsCategory> goodsCategoryList=goodsCategoryService.findGoodsCategoryList();
        if(goodsCategoryList.size()!=0) {
            System.out.println(goodsCategoryList.size());
        }
        else {
            System.out.println("not find");
        }
    }
    @Test
    public void findL1GoodsCategoryList()
    {
        List<GoodsCategory> goodsCategoryList=goodsCategoryService.findOneLevelGoodsCategoryList();
        if(goodsCategoryList.size()!=0) {
            System.out.println(goodsCategoryList.size());
        }
        else {
            System.out.println("not find");
        }

    }
    @Test
    public void findL2GoodsCategoryList()
    {
        List<GoodsCategory> goodsCategoryList=goodsCategoryService.findSecondLevelGoodsCategoryList();
        if(goodsCategoryList.size()!=0) {
            System.out.println(goodsCategoryList.size());
        }
        else {
            System.out.println("not find");
        }
    }
    @Test
    public void findL2GoodsCategoryListById()
    {
        List<GoodsCategory> goodsCategoryList=goodsCategoryService.findSecondLevelGoodsCategoryListById(10001);
        if(goodsCategoryList.size()!=0) {
            System.out.println(goodsCategoryList.size());
        }
        else {
            System.out.println("not find");
        }
    }
}
