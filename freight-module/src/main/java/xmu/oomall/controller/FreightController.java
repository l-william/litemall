/**
 * @author xingzhou
 * @date 2019/12/8 22:12
 * @version 1.0
 */

package xmu.oomall.controller;

import com.sun.xml.internal.bind.v2.runtime.InlineBinaryTransducer;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.*;
import xmu.oomall.service.FreightService;
import xmu.oomall.util.ResponseUtil;

import java.util.List;

@RestController
@RequestMapping("")

public class FreightController {

    @Autowired
    private FreightService freightService;


    /**
     * 获取默认运费比例表
     *
     * @param page
     * @param limit
     * @return object
     */
    @GetMapping("/defaultPieceFreights")
    @ApiOperation(value = "获取默认运费比率表", notes = "")
    public Object getDefaultPieceFreights(@RequestParam (defaultValue = "1") Integer page,
                                          @RequestParam (defaultValue = "10") Integer limit)
    {
        return null;
    }

    /**
     * 新建默认运费比率表
     *
     * @param defaultFreightPo
     * @return object
     */
    @PostMapping("/defaultPieceFreights")
    @ApiOperation(value = "新建默认运费比率", notes = "")
    public Object addDefaultPieceFreights(@RequestBody DefaultFreightPo defaultFreightPo)
    {
        return null;
    }

    /**
     * 修改默认运费比率表
     *
     * @param id
     * @param defaultFreightPo
     * @return object
     */
    @PutMapping("/defaultPieceFreights/{id}")
    @ApiOperation(value = "修改默认运费比率", notes = "")
    public Object updateDefaultPieceFreights(@PathVariable Integer id,@RequestBody DefaultFreightPo defaultFreightPo)
    {
        return null;
    }

    /**
     * 删除默认运费比率
     *
     * @param id
     * @return
     */
    @DeleteMapping("/defaultPieceFreights/{id}")
    @ApiOperation(value = "删除默认运费比率", notes = "")
    public Object deleteDefaultPieceFreights(@PathVariable Integer id)
    {
        return null;
    }

    /**
     * 获取默认运费规则（返回为po 待修改,以及分页待修改）
     *
     * @return object
     */
    @GetMapping("/defaultFreights")
    @ApiOperation(value = "获取默认运费规则", notes = "")
    public Object getDefaultFreights(@RequestParam (defaultValue = "1") Integer page,
                                     @RequestParam (defaultValue = "10") Integer limit)
    {
        List<DefaultFreight> defaultFreightList =freightService.findDefaultFreightsList(page,limit);
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


    /**
     * 获取特殊运费规则（分页）（返回值错了）
     *
     * @param page
     * @param limit
     * @return object
     */
    @GetMapping("/specialFreight")
    @ApiOperation(value = "获取特殊运费规则", notes = "")
    public Object getSpecialFreight(@RequestParam (defaultValue="1") Integer page,
                                    @RequestParam (defaultValue = "10") Integer limit)
    {
        List<DefaultPieceFreight> defaultPieceFreightList =freightService.findSpecialFreightList();
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

    /**
     * 获得单条特殊运费规则
     *
     * @param id
     * @return object
     */
    @GetMapping("/specialFreight/{id}")
    @ApiOperation(value = "获得单条特殊运费规则", notes = "")
    public Object getSpecialFreightById(@PathVariable Integer id)
    {
        return null;
    }

    /**
     * 新增默认运费规则（po 待修改）
     *
     * @param body
     * @return object
     */
    @PostMapping("/defaultFreights")
    @ApiOperation(value = "新增默认运费规则", notes = "")
    public Object addDefaultFreights(@RequestBody DefaultFreightPo body)
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

    /**
     * 新增特殊运费规则（特殊运费误解）
     *
     * @param specialFreight
     * @return obj
     */
    @PostMapping("/specialFreight")
    @ApiOperation(value = "新增特殊运费规则", notes = "")
    public Object addSpecialFreight(@RequestBody SpecialFreight specialFreight)
    {
        if(freightService.addSpecialFreight(specialFreight)==1)
        {
            Object object = xmu.oomall.util.ResponseUtil.ok(specialFreight);
            return object;
        }
        else
        {
            Object object = ResponseUtil.fail();
            return object;
        }
    };

    /**
     * 删除默认运费规则（参数不匹配）
     *
     * @param id
     * @return object
     */
    @DeleteMapping("/defaultFreights/{id}")
    @ApiOperation(value = "删除默认运费规则", notes = "")
    public Object deleteDefaultFreight(@PathVariable Integer id)
    {
        if(freightService.deleteDefaultFreight(id)==1)
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
    public Object deleteSpecialFreight(@PathVariable Integer id)
    {
        if(freightService.deleteSpecialFreight(id)==1)
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

    /**
     * 修改特殊运费规则
     *
     * @param id
     * @param specialFreight
     * @return object
     */
    @PutMapping("/specialFreights/{id}")
    @ApiOperation(value = "修改特殊运费规则/delete", notes = "")
    public Object updateSpecialFreight(@PathVariable Integer id,@RequestBody SpecialFreight specialFreight)
    {
        if(freightService.updateSpecialFreight(specialFreight)==1)
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

    /**
     * 修改默认运费规则（po 待修改）
     *
     * @param id
     * @param defaultFreightsPo
     * @return object
     */
    @PutMapping("/defaultFreights/{id}")
    @ApiOperation(value = "修改默认运费规则", notes = "")
    public Object updateDefaultFreight(@PathVariable Integer id,@RequestBody DefaultFreightPo defaultFreightsPo)
    {
        if(freightService.updateDefaultFreight(defaultFreightsPo)==1)
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