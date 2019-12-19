/**
 * @author xingzhou
 * @date 2019/12/7 23:50
 * @version 1.0
 */

package xmu.oomall.daoTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.dao.GoodsDao;
import xmu.oomall.domain.Goods;
import xmu.oomall.domain.GoodsPo;

import java.util.List;

/**
 * @author lianh
 * @date 2019/12/08
 */
@SpringBootTest
public class GoodsDaoTest {

    @Autowired
    private GoodsDao goodsDao;

    @Test
    void adminFindGoodsList(){
        String goodsSn="ad";
        String name="张三";
        List<GoodsPo> goodsPos=goodsDao.adminFindGoodsList(goodsSn,name);
        if(goodsPos!=null) {
            System.out.println("Find successfully!");
        } else {
            System.out.println("Failed!");
        }
    }

    @Test
    void userFindGoodsList(){
        String name="张三";
        List<GoodsPo> goodsPos=goodsDao.userFindGoodsList(name);
        if(goodsPos!=null) {
            System.out.println("Find successfully!");
        } else {
            System.out.println("Failed!");
        }
    }

    @Test
    void adminFindGoodsById(){
        GoodsPo goodsPos=goodsDao.adminFindGoodsById(123);
        if(goodsPos!=null) {
            System.out.println("Find successfully!");
        } else {
            System.out.println("Failed!");
        }

    }

    @Test
    void userFindGoodsById(){
        GoodsPo goodsPos=goodsDao.userFindGoodsById(123);
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

        if(goodsDao.addGoods(goods)!=null) {
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

        if(goodsDao.updateGoods(goods)!=null) {
            System.out.println("Update successfully!");
        } else {
            System.out.println("Failed!");
        }
    }

    @Test
    public void deleteGoods()
    {
        Integer id = 10006;

        if(goodsDao.deleteGoods(id) == 1) {
            System.out.println("delete successfully!");
        } else {
            System.out.println("Failed!");
        }
    }
}
