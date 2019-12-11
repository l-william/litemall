package xmu.oomall.daoTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.dao.FreightDao;
import xmu.oomall.domain.DefaultFreight;
import xmu.oomall.domain.DefaultPieceFreight;

@SpringBootTest
public class FreightDaoTest {
    @Autowired
    private FreightDao freightDao;

    @Test
    void findDefaultFreightById(){
        Integer a=10001;
        DefaultFreight defaultFreight=freightDao.findDefaultFreightById(a);
        if(defaultFreight==null)
            System.out.println("not find!");
        else
            System.out.println(defaultFreight.getId());
    }

    @Test
    void addDefaultFreight(){
        DefaultFreight freight=new DefaultFreight();
        freight.setDestination("Shanghai");
        if(freightDao.addDefaultFreight(freight)==1)
        {
            System.out.println("add success");
        }
        else
        {
            System.out.println("failed");
        }
    }

    @Test
    void deleteDefaultFreightById()
    {
        if(freightDao.deleteDefaultFreightById(10007)==1)
        {
            System.out.println("del success");
        }
        else
        {
            System.out.println("failed");
        }
    }
    @Test
    void updateDefaultFreight(){
        DefaultFreight defaultFreight=new DefaultFreight();
        defaultFreight.setId(10001);
        defaultFreight.setDestination("北京");
        if(freightDao.updateDefaultFreight(defaultFreight)==1)
        {
            System.out.println("update success");
        }
        else
        {
            System.out.println("failed");
        }
    }

    @Test
    void findDefaultPieceFreightById(){
        Integer a=10001;
        DefaultPieceFreight DefaultPieceFreight=freightDao.findDefaultPieceFreightById(a);
        if(DefaultPieceFreight==null)
            System.out.println("not find!");
        else
            System.out.println(DefaultPieceFreight.getId());
    }

    @Test
    void addDefaultPieceFreight(){
        DefaultPieceFreight freight=new DefaultPieceFreight();
        freight.setDestination("Beijing");
        if(freightDao.addDefaultPieceFreight(freight)==1)
        {
            System.out.println("add success");
        }
        else
        {
            System.out.println("failed");
        }
    }

    @Test
    void deleteDefaultPieceFreightById()
    {
        if(freightDao.deleteDefaultPieceFreightById(10007)==1)
        {
            System.out.println("del success");
        }
        else
        {
            System.out.println("failed");
        }
    }
    @Test
    void updateDefaultPieceFreight(){
        DefaultPieceFreight DefaultPieceFreight=new DefaultPieceFreight();
        DefaultPieceFreight.setId(10001);
        DefaultPieceFreight.setDestination("北京");
        if(freightDao.updateDefaultPieceFreight(DefaultPieceFreight)==1)
        {
            System.out.println("update success");
        }
        else
        {
            System.out.println("failed");
        }
    }
}
