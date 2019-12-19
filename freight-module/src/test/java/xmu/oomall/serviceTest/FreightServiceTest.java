package xmu.oomall.serviceTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.domain.*;
import xmu.oomall.service.FreightService;

import java.util.List;

@SpringBootTest
public class FreightServiceTest {
    @Autowired
    private FreightService freightService;

    @Test
    void findDefaultFreightsById(){
        Integer a=10001;
        DefaultFreight defaultFreight=freightService.findDefaultFreightsById(a);
        if(defaultFreight==null)
            System.out.println("not find!");
        else
            System.out.println(defaultFreight.getId());
    }

    @Test
    void addDefaultFreights(){
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
    void deleteDefaultFreight()
    {
        if(freightService.deleteDefaultFreight(10007)==1)
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
    void findDefaultFreightsList()
    {
        List<DefaultFreightPo> defaultFreights = freightService.findDefaultFreightsList(1,10);
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
        DefaultPieceFreightPo defaultPieceFreightPo=freightService.findDefaultPieceFreightById(a);
        if(defaultPieceFreightPo==null)
            System.out.println("not find!");
        else
            System.out.println(defaultPieceFreightPo.getId());
    }

    @Test
    void addDefaultPieceFreights(){
        DefaultPieceFreight freight=new DefaultPieceFreight();
        freight.setId(10007);
        if(freightService.addDefaultPieceFreights(freight)==1)
        {
            System.out.println("add success");
        }
        else
        {
            System.out.println("failed");
        }
    }

    @Test
    void deleteDefaultPieceFreight()
    {
        if(freightService.deleteDefaultPieceFreight(10007)==1)
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
        DefaultPieceFreightPo defaultPieceFreightPo=new DefaultPieceFreightPo();
        defaultPieceFreightPo.setId(10001);
        defaultPieceFreightPo.setDestination("北京");
        if(freightService.updateDefaultPieceFreight(defaultPieceFreightPo)==1)
        {
            System.out.println("update success");
        }
        else
        {
            System.out.println("failed");
        }
    }
    @Test
    void findDefaultPieceFreightList()
    {
        List<DefaultPieceFreightPo> defaultFreights = freightService.findDefaultPieceFreightList(1,10);
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
    void  getFreight()
    {
        Order order=new Order();
        order.setId(35);
        double sum=freightService.getFreight(order);
        System.out.println(sum);
    }
    @Test
    void findSpecialFreightList()
    {
        List<SpecialFreight> specialFreights = freightService.findSpecialFreightList(1,10);
        if(specialFreights.isEmpty())
        {
            System.out.println("is null");
        }
        else
        {
            System.out.println("have "+specialFreights.size());
        }
    }
    @Test
    void findSpecialFreightById()
    {
        Integer a=10001;
        SpecialFreight specialFreight=freightService.findSpecialFreightById(a);
        if(specialFreight==null)
            System.out.println("not find!");
        else
            System.out.println(specialFreight.getId());
    }
    @Test
    void addSpecialFreight()
    {
        SpecialFreight freight=new SpecialFreight();
        freight.setId(10007);
        freight.setContinueNumPiece(12);
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
    void deleteSpecialFreight()
    {
        if(freightService.deleteSpecialFreight(10007)==1)
        {
            System.out.println("del success");
        }
        else
        {
            System.out.println("failed");
        }
    }
    @Test
    void  updateSpecialFreight()
    {
        SpecialFreight specialFreight=new SpecialFreight();
        specialFreight.setId(10001);
        specialFreight.setContinueNumPiece(1200);
        if(freightService.updateSpecialFreight(specialFreight)==1)
        {
            System.out.println("update success");
        }
        else
        {
            System.out.println("failed");
        }
    }
}
