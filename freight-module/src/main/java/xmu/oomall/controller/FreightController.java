/**
 * @author xingzhou
 * @date 2019/12/8 22:12
 * @version 1.0
 */

package xmu.oomall.controller;

import ch.qos.logback.classic.pattern.RelativeTimeConverter;
import ch.qos.logback.core.joran.spi.XMLUtil;
import com.netflix.eureka.cluster.PeerEurekaNode;
import com.netflix.ribbon.proxy.annotation.Http;
import com.sun.xml.internal.bind.v2.runtime.InlineBinaryTransducer;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import sun.security.timestamp.HttpTimestamper;
import sun.text.normalizer.CharTrie;
import xmu.oomall.domain.*;
import xmu.oomall.service.FreightService;
import xmu.oomall.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("")

public class FreightController {

    @Autowired
    private FreightService freightService;
    @Autowired
    private LoadBalancerClient loadBalancerClient;


    /**
     * 日志记录函数
     *
     * @param log
     */
    private void writeLog(Log log) {
//        RestTemplate restTemplate = new RestTemplate();
//        ServiceInstance instance = loadBalancerClient.choose("Log");
//        System.out.println(instance.getHost());
//        System.out.println(instance.getPort());
//        String reqURL = String.format("http://%s:%s", instance.getHost(), instance.getPort() + "/logs");
//        restTemplate.postForObject(reqURL,log,Log.class);
    }

    /**
     * 生成日志函数
     *
     * @param request
     * @param type
     * @param status
     * @param action
     * @return 返回生成的日志或者空值，空值则进行未登录错误处理
     */
    private Log createLog(HttpServletRequest request, Integer type, Integer status, String action)
    {
        String adminId= request.getHeader("id");
        if (adminId==null){
            return null;
        }
        Log log=new Log();
      log.setAdminId(Integer.valueOf(adminId));
        log.setIp(request.getRemoteAddr());
        log.setType(type);
        log.setActions(action);
        log.setStatusCode(status);
        return log;
    }

    /**
     * 获取默认运费比例表
     *
     * @param request
     * @param page
     * @param limit
     * @return object
     */
    @GetMapping("/defaultPieceFreights")
    @ApiOperation(value = "获取默认运费比率表", notes = "")
    public Object getDefaultPieceFreights(HttpServletRequest request,
                                          @RequestParam (defaultValue = "1") Integer page,
                                          @RequestParam (defaultValue = "10") Integer limit)
    {
        Log log =createLog(request, 0, 1,"获取默认运费比率表" );
        if(log!=null)
        {
            writeLog(log);
        }
        else
        {
            return ResponseUtil.unlogin();
        }
        List<DefaultPieceFreightPo> defaultPieceFreightPoList=freightService.findDefaultPieceFreightList(page,limit);
        Object object= ResponseUtil.ok(defaultPieceFreightPoList);
        return object;
    }

    /**
     * 新建默认运费比率表
     *
     * @param request
     * @param defaultPieceFreightPo
     * @return object
     */
    @PostMapping("/defaultPieceFreights")
    @ApiOperation(value = "新建默认运费比率", notes = "")
    public Object addDefaultPieceFreights(HttpServletRequest request,
                                          @RequestBody DefaultPieceFreightPo defaultPieceFreightPo)
    {
        int re=freightService.addDefaultPieceFreights(defaultPieceFreightPo);
        if(re==1)
        {
            Log log =createLog(request, 0, 1,"新建默认运费比率" );
            if(log!=null)
            {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
            return ResponseUtil.ok(defaultPieceFreightPo);
        }
        else
        {
            Log log =createLog(request, 0, 0,"新建默认运费比率" );
            if(log!=null)
            {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
            return ResponseUtil.fail(636,"默认每件运费规则添加失败");
        }
    }

    /**
     * 修改默认运费比率表
     *
     * @param request
     * @param id
     * @param defaultPieceFreightPo
     * @return object
     */
    @PutMapping("/defaultPieceFreights/{id}")
    @ApiOperation(value = "修改默认运费比率", notes = "")
    public Object updateDefaultPieceFreights(HttpServletRequest request,@PathVariable Integer id,@RequestBody DefaultPieceFreightPo defaultPieceFreightPo)
    {
        defaultPieceFreightPo.setId(id);
        int re=freightService.updateDefaultPieceFreight(defaultPieceFreightPo);
        if(re==1)
        {
            Log log =createLog(request, 0, 1,"修改默认运费比率" );
            if(log!=null)
            {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
            return ResponseUtil.ok(defaultPieceFreightPo);
        }
        else
        {
            Log log =createLog(request, 0, 0,"修改默认运费比率" );
            if(log!=null)
            {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
            return ResponseUtil.fail(635, "默认每件运费规则更新失败");
        }
    }

    /**
     * 删除默认运费比率
     *
     * @param request
     * @param id
     * @return object
     */
    @DeleteMapping("/defaultPieceFreights/{id}")
    @ApiOperation(value = "删除默认运费比率", notes = "")
    public Object deleteDefaultPieceFreights(HttpServletRequest request,@PathVariable Integer id)
    {
        int re=freightService.deleteDefaultPieceFreight(id);
        if(re==1)
        {
            Log log =createLog(request, 0, 1,"删除默认运费比率" );
            if(log!=null)
            {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
            return ResponseUtil.ok();
        }
        else
        {
            Log log =createLog(request, 0, 0,"删除默认运费比率" );
            if(log!=null)
            {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
            return ResponseUtil.fail(637, "默认每件运费规则删除失败");
        }
    }

    /**
     * 获取默认运费规则
     *
     * @param request
     * @return object
     */
    @GetMapping("/defaultFreights")
    @ApiOperation(value = "获取默认运费规则", notes = "")
    public Object getDefaultFreights(HttpServletRequest request,
                                     @RequestParam (defaultValue = "1") Integer page,
                                     @RequestParam (defaultValue = "10") Integer limit)
    {
        Log log =createLog(request, 0, 1,"获取默认运费规则" );
        if(log!=null)
        {
            writeLog(log);
        }
        else
        {
            return ResponseUtil.unlogin();
        }

        List<DefaultFreightPo> defaultFreightPoList =freightService.findDefaultFreightsList(page,limit);
        Object object = xmu.oomall.util.ResponseUtil.ok(defaultFreightPoList);
        return object;
    };


    /**
     * 获取特殊运费规则
     *
     * @param request
     * @param page
     * @param limit
     * @return object
     */
    @GetMapping("/specialFreight")
    @ApiOperation(value = "获取特殊运费规则", notes = "")
    public Object getSpecialFreight(HttpServletRequest request,
                                    @RequestParam (defaultValue="1") Integer page,
                                    @RequestParam (defaultValue = "10") Integer limit)
    {
        Log log =createLog(request, 0, 1,"获取特殊运费规则" );
        if(log!=null)
        {
            writeLog(log);
        }
        else
        {
            return ResponseUtil.unlogin();
        }
        List<SpecialFreight> specialFreightList =freightService.findSpecialFreightList(page,limit);
        Object object = xmu.oomall.util.ResponseUtil.ok(specialFreightList);
        return object;
    };

    /**
     * 获得单条特殊运费规则
     *
     * @param request
     * @param id
     * @return object
     */
    @GetMapping("/specialFreight/{id}")
    @ApiOperation(value = "获得单条特殊运费规则", notes = "")
    public Object getSpecialFreightById(HttpServletRequest request, @PathVariable Integer id)
    {
        SpecialFreight specialFreight=freightService.findSpecialFreightById(id);
        if(specialFreight!=null)
        {
            Log log =createLog(request, 0, 1,"获得单条特殊运费规则" );
            if(log!=null)
            {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
            return ResponseUtil.ok(specialFreight);
        }
        else
        {
            Log log =createLog(request, 0, 0,"获得单条特殊运费规则" );
            if(log!=null)
            {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
            return ResponseUtil.fail(638,"该特殊运费规则是无效运费规则");
        }
    }

    /**
     * 新增默认运费规则
     *
     * @param request
     * @param body
     * @return object
     */
    @PostMapping("/defaultFreights")
    @ApiOperation(value = "新增默认运费规则", notes = "")
    public Object addDefaultFreights(HttpServletRequest request,@RequestBody DefaultFreightPo body)
    {
        if(freightService.addDefaultFreights(body)==1)
        {
            Log log =createLog(request, 0, 1,"新增默认运费规则" );
            if(log!=null)
            {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
            Object object = xmu.oomall.util.ResponseUtil.ok(body);
            return object;
        }
        else
        {
            Log log =createLog(request, 0, 0,"新增默认运费规则" );
            if(log!=null)
            {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
            Object object = ResponseUtil.fail(632, "默认运费规则添加失败");
            return object;
        }
    };

    /**
     * 新增特殊运费规则
     *
     * @param request
     * @param specialFreight
     * @return obj
     */
    @PostMapping("/specialFreight")
    @ApiOperation(value = "新增特殊运费规则", notes = "")
    public Object addSpecialFreight(HttpServletRequest request,@RequestBody SpecialFreight specialFreight)
    {
        if(freightService.addSpecialFreight(specialFreight)==1)
        {
            Log log =createLog(request, 0, 1,"新增特殊运费规则" );
            if(log!=null)
            {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
            Object object = ResponseUtil.ok(specialFreight);
            return object;
        }
        else
        {
            Log log =createLog(request, 0, 0,"新增特殊运费规则" );
            if(log!=null)
            {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
            Object object = ResponseUtil.fail(640,"特殊运费规则添加失败");
            return object;
        }
    };

    /**
     * 删除默认运费规则
     *
     * @param request
     * @param id
     * @return object
     */
    @DeleteMapping("/defaultFreights/{id}")
    @ApiOperation(value = "删除默认运费规则", notes = "")
    public Object deleteDefaultFreight(HttpServletRequest request,@PathVariable Integer id)
    {
        if(freightService.deleteDefaultFreight(id)==1)
        {
            Log log =createLog(request, 0, 1,"删除默认运费规则" );
            if(log!=null)
            {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
            Object object = xmu.oomall.util.ResponseUtil.ok();
            return object;
        }
        else
        {
            Log log =createLog(request, 0, 0,"删除默认运费规则" );
            if(log!=null)
            {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
            Object object = ResponseUtil.fail(633, "默认运费规则删除失败");
            return object;
        }
    };

    /**
     * 删除特殊运费模板
     *
     * @param request
     * @param id
     * @return Object
     */
    @DeleteMapping("/specialFreights/{id}")
    @ApiOperation(value = "删除特殊运费规则", notes = "")
    public Object deleteSpecialFreight(HttpServletRequest request, @PathVariable Integer id)
    {
        if(freightService.deleteSpecialFreight(id)==1)
        {
            Log log =createLog(request, 0, 1,"删除特殊运费规则" );
            if(log!=null)
            {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
            Object object = xmu.oomall.util.ResponseUtil.ok();
            return object;
        }
        else
        {
            Log log =createLog(request, 0, 0,"删除特殊运费规则" );
            if(log!=null)
            {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
            Object object = ResponseUtil.fail(641,"特殊运费规则删除失败");
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
    public Object updateSpecialFreight(HttpServletRequest request,@PathVariable Integer id,@RequestBody SpecialFreight specialFreight)
    {
        if(freightService.updateSpecialFreight(specialFreight)==1)
        {
            Log log =createLog(request, 0, 1,"修改特殊运费规则" );
            if(log!=null)
            {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
            Object object = xmu.oomall.util.ResponseUtil.ok();
            return object;
        }
        else
        {
            Log log =createLog(request, 0, 0,"修改特殊运费规则" );
            if(log!=null)
            {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
            Object object = ResponseUtil.fail(639, "特殊运费规则更新失败");
            return object;
        }
    };

    /**
     * 修改默认运费规则
     *
     * @param id
     * @param defaultFreightsPo
     * @return object
     */
    @PutMapping("/defaultFreights/{id}")
    @ApiOperation(value = "修改默认运费规则", notes = "")
    public Object updateDefaultFreight(HttpServletRequest request,@PathVariable Integer id,@RequestBody DefaultFreightPo defaultFreightsPo)
    {
        if(freightService.updateDefaultFreight(defaultFreightsPo)==1)
        {
            Log log =createLog(request, 0, 1,"修改默认运费规则" );
            if(log!=null)
            {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
            Object object = xmu.oomall.util.ResponseUtil.ok();
            return object;
        }
        else
        {
            Log log =createLog(request, 0, 0,"修改默认运费规则" );
            if(log!=null)
            {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
            Object object = ResponseUtil.fail(631,"默认运费规则更新失败");
            return object;
        }
    };

    @GetMapping("/freightPrice")
    @ApiOperation(value = "获取运费", notes = "")
    public BigDecimal getFreight(Order order)
    {
        double freight=freightService.getFreight(order);
        if(freight==-1)
        {
            return null;
        }
        return BigDecimal.valueOf(freight);
    };

}