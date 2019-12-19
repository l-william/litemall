///**
// * @author xingzhou
// * @date 2019/12/7 23:50
// * @version 1.0
// */
//
//package xmu.oomall.controllerTest;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
////import xmu.oomall.controller.GoodsController;
//import xmu.oomall.domain.Brand;
//import xmu.oomall.domain.Goods;
//import xmu.oomall.domain.GoodsCategory;
//
//import java.util.List;
//
//@SpringBootTest
//public class GoodsControllerTest {
//    @Autowired
//    private GoodsController goodsController;
//    @Test
//    public void listBrandByCodition()
//    {
//        System.out.println(goodsController.listBrandByCodition("10","华",1,5).toString());
//        System.out.println(goodsController.listBrandByCodition("","",1,3).toString());
//
//    }
//    @Test
//    public void addBrand()
//    {
//        Brand brand=new Brand();
//        brand.setName("ABC");
//        brand.setDescription("addBrandTest");
//        brand.setBeDeleted(false);
//        System.out.println(goodsController.addBrand(brand));
//    }
//    @Test
//    public void getBrandById()
//    {
//        System.out.println(goodsController.getBrandById(10003).toString());
//    }
//    @Test
//    public void updateBrandById()
//    {
//        Brand brand=new Brand();
//        brand.setName("苹果");
//        brand.setDescription("updateBrandTest");
//        brand.setBeDeleted(false);
//        System.out.println(goodsController.updateBrandById(10005,brand).toString());
//    }
//    @Test
//    public void deleteBrandById(){
//        Brand brand=new Brand();
//        brand.setId(10002);
//        brand.setName("得力");
//        brand.setDescription("这是个订书机品牌");
//        brand.setBeDeleted(false);
//        System.out.println(goodsController.deleteBrandById(brand).toString());
//    }
//    @Test
//    public void listGoodsCategory()
//    {
//        System.out.println(goodsController.listGoodsCategory().toString());
//    }
//    @Test
//    public void addGoodsCategory()
//    {
//        GoodsCategory goodsCategory=new GoodsCategory();
//        goodsCategory.setName("水产品");
//        goodsCategory.setPid(10004);
//        System.out.println(goodsController.addGoodsCategory(goodsCategory).toString());
//    }
//    @Test
//    public void getGoodsCategoryById()
//    {
//        System.out.println(goodsController.getGoodsCategoryById(10002).toString());
//    }
//    @Test
//    public void updateGoodsCategoryById()
//    {
//        GoodsCategory goodsCategory=new GoodsCategory();
//        goodsCategory.setId(10008);
//        goodsCategory.setName("肉与肉制品");
//        goodsCategory.setPid(10004);
//        goodsCategory.setBeDeleted(false);
//        System.out.println(goodsController.updateGoodsCategoryById(10008,goodsCategory).toString());
//    }
//    @Test
//    public void deleteGoodsCategory()
//    {
//        GoodsCategory goodsCategory=new GoodsCategory();
//        goodsCategory.setId(10009);
//        goodsCategory.setName("乳制品");
//        goodsCategory.setPid(10004);
//        goodsCategory.setBeDeleted(false);
//        System.out.println(goodsController.deleteGoodsCategory(10009,goodsCategory).toString());
//    }
//    @Test
//    public void listOneLevelGoodsCategory()
//    {
//        System.out.println(goodsController.listOneLevelGoodsCategory().toString());
//    }
//    @Test
//    public void listGoods()
//    {
//        System.out.println(goodsController.listGoods("da",null).toString());
//        System.out.println(goodsController.listGoods(null,"手").toString());
//    }
//    @Test
//    public void updateGoodsById()
//    {
//        Goods goods=new Goods();
//        goods.setId(10004);
//        goods.setName("联想电脑");
//        goods.setBeDeleted(false);
//        System.out.println(goodsController.updateGoodsById(10004,goods).toString());
//    }
//    @Test
//    public void deleteGoodsById()
//    {
//
//    }
//    @Test
//    public void addGoods()
//    {
//
//    }
//    @Test
//    public void getGoodsById()
//    {
//
//    }
//    @Test
//    public void listBrand()
//    {
//
//    }
//    @Test
//    public void listSecondLevelGoodsCategory()
//    {
//
//    }
//    @Test
//    public void listSecondLevelGoodsCategoryById()
//    {
//
//    }
//    @Test
//    public void getGoodsById2()
//    {
//
//    }
//    @Test
//    public void listGoodsBySearchInfo()
//    {
//
//    }
//    @Test
//    public void getRecommendedGoods()
//    {
//
//    }
//    @Test
//    public void getGoodsCounts()
//    {
//
//    }
//
//}
