/**
 * @author xingzhou
 * @date 2019/12/7 17:01
 * @version 1.0
 */

package xmu.oomall.serviceTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.domain.Ad;
import xmu.oomall.service.AdService;

@SpringBootTest
public class AdServiceTest {
    @Autowired
    private AdService adService;
    @Test
    void findAdById()
    {
        if(adService.findAdById(11111)==null)
        {
            System.out.println("no find");
        }
        else
        {
            System.out.println(adService.findAdById(11111).getId());
        }
    }
    @Test
    void updateAd()
    {
        Ad ad=new Ad();
        ad.setId(11111);
        ad.setLink("www.zhoutreeman.com");
        if(adService.updateAd(ad))
        {
            System.out.println("update success");
        }
        else
        {
            System.out.println("failed");
        }
    }
}
