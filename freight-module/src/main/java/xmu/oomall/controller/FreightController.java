/**
 * @author xingzhou
 * @date 2019/12/8 22:12
 * @version 1.0
 */

package xmu.oomall.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.DefaultFreight;
import xmu.oomall.domain.DefaultPieceFreight;
import xmu.oomall.domain.Order;
import xmu.oomall.service.FreightService;
import xmu.oomall.util.ResponseUtil;

import java.util.List;

@RestController
@RequestMapping("/admin-freight")// /wx/order

public class FreightController {

    @Autowired
    private FreightService freightService;

    @GetMapping("/defaultFreights")
    @ApiOperation(value = "获取默认运费规则", notes = "")
    public Object getDefaultFreights()
    {
        List<DefaultFreight> defaultFreightList =freightService.findDefaultFreightsList();
        if(!defaultFreightList.isEmpty())
        {
            Object object = xmu.oomall.util.ResponseUtil.ok(defaultFreightList);
            return object;
        }
        else
        {
            Object object = ResponseUtil.fail();
            return object;
        }
    };


    @GetMapping("/specialFreight")
    @ApiOperation(value = "获取特殊运费规则", notes = "")
    public Object getSpecialFreight()
    {
        List<DefaultPieceFreight> defaultPieceFreightList =freightService.findgetSpecialFreightList();
        if(!defaultPieceFreightList.isEmpty())
        {
            Object object = xmu.oomall.util.ResponseUtil.ok(defaultPieceFreightList);
            return object;
        }
        else
        {
            Object object = ResponseUtil.fail();
            return object;
        }
    };


    @PostMapping("/defaultFreights")
    @ApiOperation(value = "新增默认运费规则", notes = "")
    public Object addDefaultFreights(@RequestBody DefaultFreight body)
    {
        if(freightService.addDefaultFreights(body)==1)
        {
            Object object = xmu.oomall.util.ResponseUtil.ok(body);
            return object;
        }
        else
        {
            Object object = ResponseUtil.fail();
            return object;
        }
    };

    @PostMapping("/specialFreight")
    @ApiOperation(value = "新增特殊运费规则", notes = "")
    public Object addSpecialFreight(@RequestBody DefaultPieceFreight body)
    {
        if(freightService.addSpecialFreight(body)==1)
        {
            Object object = xmu.oomall.util.ResponseUtil.ok(body);
            return object;
        }
        else
        {
            Object object = ResponseUtil.fail();
            return object;
        }
    };

    @DeleteMapping("/defaultFreights/{id}")
    @ApiOperation(value = "删除默认运费规则", notes = "")
    public Object deleteDefaultFreight(@PathVariable("defaultFreightsId") String defaultFreightsId)
    {
        if(freightService.deleteDefaultFreight(defaultFreightsId)==1)
        {
            Object object = xmu.oomall.util.ResponseUtil.ok();
            return object;
        }
        else
        {
            Object object = ResponseUtil.fail();
            return object;
        }
    };

    @DeleteMapping("/specialFreights/{id}")
    @ApiOperation(value = "删除特殊运费规则", notes = "")
    public Object deleteSpecialFreight(@PathVariable("specialFreightsId") String specialFreightsId)
    {
        if(freightService.deleteSpecialFreight(specialFreightsId)==1)
        {
            Object object = xmu.oomall.util.ResponseUtil.ok();
            return object;
        }
        else
        {
            Object object = ResponseUtil.fail();
            return object;
        }
    };

    @PutMapping("/specialFreights/{id}")
    @ApiOperation(value = "修改特殊运费规则/delete", notes = "")
    public Object updateSpecialFreight(DefaultPieceFreight specialFreights)
    {
        if(freightService.updateSpecialFreight(specialFreights)==1)
        {
            Object object = xmu.oomall.util.ResponseUtil.ok();
            return object;
        }
        else
        {
            Object object = ResponseUtil.fail();
            return object;
        }
    };

    @DeleteMapping("/defaultFreights/{id}")
    @ApiOperation(value = "修改默认运费规则", notes = "")
    public Object updateDefaultFreight(DefaultFreight defaultFreights)
    {
        if(freightService.updateDefaultFreight(defaultFreights)==1)
        {
            Object object = xmu.oomall.util.ResponseUtil.ok();
            return object;
        }
        else
        {
            Object object = ResponseUtil.fail();
            return object;
        }
    };

    @GetMapping("/freightPrice")
    @ApiOperation(value = "获取运费", notes = "")
    public Object getFreight(Order order)
    {
        //此处有问题，参数不对
        double freight=freightService.getFreight(order);
        Object object = xmu.oomall.util.ResponseUtil.ok(freight);
        return object;
    };

}