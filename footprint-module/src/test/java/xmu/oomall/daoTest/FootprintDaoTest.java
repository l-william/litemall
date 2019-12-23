package xmu.oomall.daoTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.dao.FootprintItemDao;
import xmu.oomall.domain.FootprintItem;
import xmu.oomall.domain.FootprintItemPo;

import java.util.List;

@SpringBootTest
public class FootprintDaoTest {

    @Autowired
    private FootprintItemDao footprintItemDao;

    @Test
    void userFindFootprintList()
    {
        List<FootprintItem> footprintItems=footprintItemDao.userFindFootprintList(123);
        if (footprintItems!=null)
            System.out.println(footprintItems.size());
        else
            System.out.println("查找失败");
    }
    @Test
    void adminFindFootprintList()
    {
        List<FootprintItem> footprintItems=footprintItemDao.adminFindFootprintList(123,123);
        if (footprintItems!=null)
            System.out.println(footprintItems.size());
        else
            System.out.println("查找失败");
    }
    @Test
    void addFootprint()
    {
        FootprintItemPo footprintItemPo=new FootprintItemPo();
        footprintItemDao.addFootprint(footprintItemPo);
    }
}
