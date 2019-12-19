//package xmu.oomall.daoTest;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import xmu.oomall.dao.FreightDao;
//import xmu.oomall.domain.*;
//
//
//import java.util.List;
//
//@SpringBootTest
//public class FreightDaoTest {
//    @Autowired
//    private FreightDao freightDao;
//
//    @Test
//    void findDefaultFreightById(){
//        Integer a=10080;
//        DefaultFreight defaultFreight=freightDao.findDefaultFreightById(a);
//        if(defaultFreight==null)
//            System.out.println("not find!");
//        else
//            System.out.println(defaultFreight.getId());
//    }
//
//    @Test
//    void findDefaultFreightList(){
//        List<DefaultFreightPo> defaultFreight = freightDao.findDefaultFreightList();
//        if(defaultFreight==null)
//            System.out.println("not find!");
//        else
//            System.out.println(defaultFreight.size());
//    }
//
//    @Test
//    void addDefaultFreight(){
//        DefaultFreight freight=new DefaultFreight();
//        freight.setDestination("Shanghai");
//        if(freightDao.addDefaultFreight(freight)==1)
//        {
//            System.out.println("add success");
//        }
//        else
//        {
//            System.out.println("failed");
//        }
//    }
//
//    @Test
//    void deleteDefaultFreightById()
//    {
//        if(freightDao.deleteDefaultFreightById(11085)==1)
//        {
//            System.out.println("del success");
//        }
//        else
//        {
//            System.out.println("failed");
//        }
//    }
//    @Test
//    void updateDefaultFreight(){
//        DefaultFreight defaultFreight=new DefaultFreight();
//        defaultFreight.setId(10085);
//        defaultFreight.setDestination("北京");
//        if(freightDao.updateDefaultFreight(defaultFreight)==1)
//        {
//            System.out.println("update success");
//        }
//        else
//        {
//            System.out.println("failed");
//        }
//    }
//    //
//    @Test
//    void findDefaultPieceFreightById(){
//        Integer a=11080;
//        DefaultPieceFreightPo defaultPieceFreight = freightDao.findDefaultPieceFreightById(a);
//        if(defaultPieceFreight==null)
//            System.out.println("not find!");
//        else
//            System.out.println(defaultPieceFreight.getId());
//    }
//
//    @Test
//    void findDefaultPieceFreightList(){
//        List<DefaultPieceFreightPo> defaultPieceFreight = freightDao.findDefaultPieceFreightList();
//        if(defaultPieceFreight==null)
//            System.out.println("not find!");
//        else
//            System.out.println(defaultPieceFreight.size());
//    }
//
//    @Test
//    void addDefaultPieceFreight(){
//        DefaultPieceFreight freight=new DefaultPieceFreight();
//        freight.setDestination("Beijing");
//        if(freightDao.addDefaultPieceFreight(freight)==1)
//        {
//            System.out.println("add success");
//        }
//        else
//        {
//            System.out.println("failed");
//        }
//    }
//
//    @Test
//    void deleteDefaultPieceFreightById()
//    {
//        if(freightDao.deleteDefaultPieceFreightById(11085)==1)
//        {
//            System.out.println("del success");
//        }
//        else
//        {
//            System.out.println("failed");
//        }
//    }
//    @Test
//    void updateDefaultPieceFreight(){
//        DefaultPieceFreight defaultPieceFreight=new DefaultPieceFreight();
//        defaultPieceFreight.setId(11085);
//        defaultPieceFreight.setDestination("北京");
//        if(freightDao.updateDefaultPieceFreight(defaultPieceFreight)==1)
//        {
//            System.out.println("update success");
//        }
//        else
//        {
//            System.out.println("failed");
//        }
//    }
//
//    @Test
//    void findIdFromRegion()
//    {
//        Integer id=freightDao.findIdFromRegion("北京市");
//        System.out.println(id);
//    }
//    @Test
//    void findItemsInAOrder()
//    {
//        Order order=new Order();
//        order.setId(35);
//        List<OrderItem> orderItems=freightDao.findItemsInAOrder(order);
//        if(orderItems!=null)
//            System.out.println(orderItems.size());
//        else
//            System.out.println("Failed");
//    }
//}
