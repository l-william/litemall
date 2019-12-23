package xmu.oomall.serviceTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.domain.FootprintItem;
import xmu.oomall.domain.FootprintItemPo;
import xmu.oomall.service.FootprintItemService;

import java.util.List;

@SpringBootTest
public class FootprintServiceTest {
    @Autowired
    private FootprintItemService footprintItemService;

    @Test
    void userFindFootprintList()
    {
        List<FootprintItem> footprintItems=footprintItemService.userFindFootprintList(123,1,10);
        if (footprintItems!=null)
            System.out.println(footprintItems.size());
        else
            System.out.println("查找失败");
    }
    @Test
    void adminFindFootprintList()
    {
        List<FootprintItem> footprintItems=footprintItemService.adminFindFootprintList(123,123,1,10);
        if (footprintItems!=null)
            System.out.println(footprintItems.size());
        else
            System.out.println("查找失败");
    }
    @Test
    void addFootprint()
    {
        FootprintItemPo footprintItemPo=new FootprintItemPo();
        footprintItemService.addFootprint(footprintItemPo);
    }
}
