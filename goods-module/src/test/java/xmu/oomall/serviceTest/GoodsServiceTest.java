/**
 * @author xingzhou
 * @date 2019/12/7 23:50
 * @version 1.0
 */

package xmu.oomall.serviceTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.domain.Goods;
import xmu.oomall.domain.GoodsPo;
import xmu.oomall.service.GoodsService;

import java.util.List;

@SpringBootTest
public class GoodsServiceTest {

    @Autowired
    private GoodsService goodsService;

    @Test
    void adminFindGoodsList(){
        String goodsSn="ad";
        String name="张三";
        List<GoodsPo> goodsPos=goodsService.adminFindGoodsList(goodsSn,name,1,10);
        if(goodsPos!=null) {
            System.out.println("Find successfully!");
        } else {
            System.out.println("Failed!");
        }
    }

    @Test
    void userFindGoodsList(){
        String name="张三";
        List<GoodsPo> goodsPos=goodsService.userFindGoodsList(name,1,10);
        if(goodsPos!=null) {
            System.out.println("Find successfully!");
        } else {
            System.out.println("Failed!");
        }
    }

    @Test
    void adminFindGoodsById(){
        GoodsPo goodsPos=goodsService.adminFindGoodsById(273);
        if(goodsPos!=null) {
            System.out.println("Find successfully!");
        } else {
            System.out.println("Failed!");
        }

    }

    @Test
    void userFindGoodsById(){
        GoodsPo goodsPos=goodsService.userFindGoodsById(123);
        if(goodsPos!=null) {
            System.out.println("Find successfully!");
        } else {
            System.out.println("Failed!");
        }
    }

    @Test
    public void addGoods()
    {
        Goods goods = new Goods();
        goods.setName("水杯");

        System.out.println(goods);

        if(goodsService.addGoods(goods)!=null) {
            System.out.println("Add successfully!");
        } else {
            System.out.println("Failed!");
        }
    }

    @Test
    public void updateGoods()
    {
        Goods goods = new Goods();
        goods.setId(10003);
        goods.setName("咖啡");

        if(goodsService.updateGoods(goods)!=null) {
            System.out.println("Update successfully!");
        } else {
            System.out.println("Failed!");
        }
    }

    @Test
    public void deleteGoods()
    {
        Integer id = 10006;

        if(goodsService.deleteGoods(id) == 1) {
            System.out.println("delete successfully!");
        } else {
            System.out.println("Failed!");
        }
    }
}
