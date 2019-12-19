///**
// * @author xingzhou
// * @date 2019/12/7 17:00
// * @version 1.0
// */
//
//package xmu.oomall.controllerTest;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import xmu.oomall.controller.AdController;
//import xmu.oomall.domain.Ad;
//
//import java.util.HashMap;
//import java.util.List;
//
//@SpringBootTest
//public class AdControllerTest {
//    @Autowired
//    private AdController adController;
//    @Test
//    void adminFindAd()
//    {
//        System.out.println(adController.adminFindAd(11111));
//    }
//    @Test
//    void adminUpdateAd()
//    {
//        Ad ad=new Ad();
//        ad.setLink("www.XingZhou.com");
//        System.out.println(adController.adminUpdateAd(11111, ad));
//    }
//
//    @Test
//    void createAdTest() {
//        Ad ad = new Ad();
//        ad.setName("linlianhui");
//
//        adController.adminCreateAd(ad);
//    }
//
//    @Test
//    void findAdListTest() {
//        String name = "mall";
//        String content = "content";
//
//        HashMap<String, Object> res = (HashMap<String, Object>)adController.adminFindAdList(name, content);
//
//        List<Ad> adList = (List<Ad>)res.get("data");
//
//        for(Ad ad : adList) {
//            System.out.println(ad);
//        }
//    }
//
//    @Test
//    void deleteAd(){
//        Ad ad = new Ad();
//        ad.setName("cfh:uselessObj");
//        adController.adminDeleteAd(12345);
//    }
//
//    @Test
//    void userFindAd(){
//        HashMap<String, Object> res = (HashMap<String, Object>)adController.userFindAd();
//        List<Ad> adList = (List<Ad>)res.get("data");
//        for(Ad ad : adList) {
//            System.out.println(ad);
//        }
//    }
//}
