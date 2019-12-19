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

import java.util.List;

@SpringBootTest
public class AdServiceTest {
    @Autowired
    private AdService adService;

    @Test
    void findAdById()
    {
        Integer id = 1;
        Ad ad=adService.findAdById(id);
        if(ad==null)
            System.out.println("not find!");
        else
            System.out.println(ad.getId());
    }
    @Test
    void adminFindAdList()
    {
        List<Ad> ads=adService.adminFindAdList(1,10,"诚",null);
        if(ads!=null)
            System.out.println(ads);
        else
            System.out.println("Failed find");
    }
    @Test
    void createAd()
    {
        Ad ad=new Ad();
        ad.setContent("www.4399.com");
        if(adService.createAd(ad)==1)
        {
            System.out.println("add success");
        }
        else
        {
            System.out.println("failed");
        }
    }
    @Test
    void deleteAd()
    {
        if(adService.deleteAd(1)==1)
        {
            System.out.println("del success");
        }
        else
        {
            System.out.println("failed");
        }
    }
    @Test
    void updateAd()
    {
        Ad ad=new Ad();
        ad.setId(11111);
        ad.setName("好好学习");
        if(adService.updateAd(ad)==true)
        {
            System.out.println("update success");
        }
        else
        {
            System.out.println("failed");
        }
    }
    @Test
    void userFindAd()
    {
        List<Ad> adList = adService.userFindAd();
        if(adList.isEmpty())
        {
            System.out.println("is null");
        }
        else
        {
            for(Ad ad : adList) {
                System.out.println(ad);
            }
        }
    }
}
