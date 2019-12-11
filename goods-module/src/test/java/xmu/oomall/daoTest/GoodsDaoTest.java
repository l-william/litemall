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
    public void findGoodsListByGoodSnAndName()
    {
        String goodsSn = "we";
        String name = "劳力";
        List<Goods> goodsList = goodsDao.findGoodsListByGoodSnAndName(goodsSn, name);

        for(Goods goods : goodsList) {
            System.out.println(goods);
        }
    }

    @Test
    public void findGoodsById()
    {
        Integer id = 10003;
        Goods goods = goodsDao.findGoodsById(id);

        System.out.println(goods);
    }

    @Test
    public void addGoods()
    {
        Goods goods = new Goods();
        goods.setName("水杯");

        System.out.println(goods);

        if(goodsDao.addGoods(goods) == 1) {
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

        if(goodsDao.updateGoods(goods) == 1) {
            System.out.println("Update successfully!");
        } else {
            System.out.println("Failed!");
        }
    }

    @Test
    public void deleteGoodsById()
    {
        Integer id = 10006;

        if(goodsDao.deleteGoodsById(id) == 1) {
            System.out.println("delete successfully!");
        } else {
            System.out.println("Failed!");
        }
    }

    @Test
    public void getGoodsCount() {
        int count = goodsDao.getGoodsCount();
        System.out.println("On sale goods count: " + count);
    }
}
