/**
 * @author xingzhou
 * @date 2019/12/6 15:17
 * @version 1.0
 */

package xmu.oomall.daoTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.dao.AdDao;
import xmu.oomall.domain.Ad;
import java.util.List;

@SpringBootTest
public class AdDaoTest {
    @Autowired
    private AdDao adDao;
    @Test
    void findAdById()
    {
        Integer a=10001;
        Ad ad=adDao.findAdById(a);
        if(ad==null)
            System.out.println("not find!");
        else
            System.out.println(ad.getId());
    }
    @Test
    void addAd()
    {
        Ad ad=new Ad();
        ad.setContent("www.4399.com");
        if(adDao.addAd(ad)==1)
        {
            System.out.println("add success");
        }
        else
        {
            System.out.println("failed");
        }
    }
    @Test
    void deleteAdById()
    {
        if(adDao.deleteAdById(1)==1)
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
        if(adDao.updateAd(ad)==1)
        {
            System.out.println("update success");
        }
        else
        {
            System.out.println("failed");
        }
    }
    @Test
    void findAdListBynameAndContent()
    {
        String name = "mall";
        String content = "content";
        List<Ad> adList = adDao.findAdListByNameAndContent(name ,content);
        if(adList.isEmpty())
        {
            System.out.println("is null");
        }
        else
        {
            System.out.println("have "+adList.size());
        }
    }
}
