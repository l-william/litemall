package xmu.oomall.serviceTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.domain.DefaultFreight;
import xmu.oomall.domain.DefaultPieceFreight;
import xmu.oomall.service.FreightService;

import java.util.List;

@SpringBootTest
public class FreightServiceTest {
    @Autowired
    private FreightService freightService;

    @Test
    void findDefaultFreightById(){
        Integer a=10001;
        DefaultFreight defaultFreight=freightService.findDefaultFreightsById(a);
        if(defaultFreight==null)
            System.out.println("not find!");
        else
            System.out.println(defaultFreight.getId());
    }

    @Test
    void addDefaultFreight(){
        DefaultFreight freight=new DefaultFreight();
        freight.setId(10007);
        if(freightService.addDefaultFreights(freight)==1)
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
        if(freightService.deleteDefaultFreight("10007")==1)
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
        if(freightService.updateDefaultFreight(defaultFreight)==1)
        {
            System.out.println("update success");
        }
        else
        {
            System.out.println("failed");
        }
    }
    @Test
    void findDefaultFreightList()
    {
        List<DefaultFreight> defaultFreights = freightService.findDefaultFreightsList();
        if(defaultFreights.isEmpty())
        {
            System.out.println("is null");
        }
        else
        {
            System.out.println("have "+defaultFreights.size());
        }
    }

    @Test
    void findDefaultPieceFreightById(){
        Integer a=10001;
        DefaultPieceFreight DefaultPieceFreight=freightService.findSpecialFreightById(a);
        if(DefaultPieceFreight==null)
            System.out.println("not find!");
        else
            System.out.println(DefaultPieceFreight.getId());
    }

    @Test
    void addDefaultPieceFreight(){
        DefaultPieceFreight freight=new DefaultPieceFreight();
        freight.setId(10007);
        if(freightService.addSpecialFreight(freight)==1)
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
        if(freightService.deleteSpecialFreight("10007")==1)
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
        if(freightService.updateSpecialFreight(DefaultPieceFreight)==1)
        {
            System.out.println("update success");
        }
        else
        {
            System.out.println("failed");
        }
    }
    @Test
    void findgetSpecialFreightList()
    {
        List<DefaultPieceFreight> defaultFreights = freightService.findgetSpecialFreightList();
        if(defaultFreights.isEmpty())
        {
            System.out.println("is null");
        }
        else
        {
            System.out.println("have "+defaultFreights.size());
        }
    }
}
