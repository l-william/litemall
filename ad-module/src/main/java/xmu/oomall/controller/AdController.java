/**
 * @author xingzhou
 * @date 2019/12/6 15:58
 * @version 1.0
 */
package xmu.oomall.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.annotation.Order;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import xmu.oomall.domain.Ad;
import xmu.oomall.domain.Log;
import xmu.oomall.service.AdService;
import xmu.oomall.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@RequestMapping("/ads")
public class AdController {
    @Autowired
    private AdService adService;
    private LoadBalancerClient loadBalancerClient;
    /**
     * 参数验证函数
     *
     * @param newAd
     * @return object
     */
    private Object validate(Ad newAd) {
        String name=newAd.getName();
        if(StringUtils.isEmpty(name))
        {
            return ResponseUtil.badArgument();
        }
        String content = newAd.getContent();
        if (StringUtils.isEmpty(content)) {
            return ResponseUtil.badArgument();
        }
        return null;
    }

    /**
     * 日志记录
     *
     * @param log
     */
    private void writeLog(Log log) {
        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance instance = loadBalancerClient.choose("Log");
        String reqURL = String.format("http://%s:%s", instance.getHost(), instance.getPort() + "/logs");
        restTemplate.getForObject(reqURL, Log.class);
    }

    /**
     * 管理员查看所有的广告
     *
     * @param request
     * @param page
     * @param limit
     * @param name
     * @param content
     * @return Object
     */
    @GetMapping("/admins/ads")
    @ApiOperation(value="管理员查看所有的广告  /list")
    public Object adminFindAdList(HttpServletRequest request,
                                  @RequestParam(defaultValue = "1") Integer page,
                                  @RequestParam(defaultValue = "10") Integer limit,
                                  @RequestParam String name,
                                  @RequestParam String content
    ) {
        String id= request.getHeader("id");
        if (id==null){
            return ResponseUtil.unlogin();
        }
        Log log=new Log();
        log.setAdminId(Integer.valueOf(id));
        log.setIp(request.getRemoteAddr());
        log.setType(0);
        log.setStatusCode(1);
        log.setActions("查询广告列表");
        writeLog(log);
        List<Ad> adList = adService.adminFindAdList(name, content);
        return ResponseUtil.ok(adList);
    }


    /**
     * 管理员新建一条广告
     *
     * @param ad
     * @return Object
     */
    @PostMapping("/ads")
    @ApiOperation(value="新建一条广告 /create")
    public Object adminCreateAd(HttpServletRequest request,@RequestBody Ad ad) {
        String adminId= request.getHeader("id");
        if (adminId==null){
            return ResponseUtil.unlogin();
        }
        Log log=new Log();
        log.setAdminId(Integer.valueOf(adminId));
        log.setIp(request.getRemoteAddr());
        log.setType(0);
        log.setActions("新建广告");

        Object re=validate(ad);
        if(re!=null)
        {
            log.setStatusCode(0);
            writeLog(log);
            return re;
        }
        else
        {
            log.setStatusCode(1);
            writeLog(log);
            adService.createAd(ad);
            return ResponseUtil.ok();
        }
    }

    /**
     * 管理员查看单条广告
     *
     * @param id
     * @return Object
     */
    @GetMapping("/ads/{id}")
    @ApiOperation(value="查看单条广告 /read")
    public Object adminFindAd(HttpServletRequest request,@PathVariable Integer id)
    {
        String adminId= request.getHeader("id");
        if (adminId==null){
            return ResponseUtil.unlogin();
        }
        Log log=new Log();
        log.setAdminId(Integer.valueOf(adminId));
        log.setIp(request.getRemoteAddr());
        log.setType(0);
        log.setActions("查询广告详情");

        Ad ad=adService.findAdById(id);
        if(ad!=null)
        {
            log.setStatusCode(1);
            writeLog(log);
            Object object = ResponseUtil.ok(ad);
            return object;
        }
        else
        {
            log.setStatusCode(0);
            writeLog(log);
            Object object = ResponseUtil.badArgumentValue();
            return object;
        }
    };

    /**
     * 管理员修改广告
     *
     * @param id
     * @param ad
     * @return Object
     */
    @PutMapping("/ads/{id}")
    @ApiOperation(value="修改广告信息 /update")
    public Object adminUpdateAd(HttpServletRequest request,@PathVariable Integer id,@RequestBody Ad ad)
    {

        String adminId= request.getHeader("id");
        if (adminId==null){
            return ResponseUtil.unlogin();
        }
        Log log=new Log();
        log.setAdminId(Integer.valueOf(adminId));
        log.setIp(request.getRemoteAddr());
        log.setType(0);
        log.setActions("修改广告信息");

        ad.setId(id);
        if(adService.updateAd(ad))
        {
            log.setStatusCode(1);
            writeLog(log);
            Object object = ResponseUtil.ok(ad);
            return object;
        }
        else
        {
            log.setStatusCode(0);
            writeLog(log);
            Object object=ResponseUtil.badArgumentValue();
            return object;
        }
    };


    /**
     * 管理员删除广告
     *
     * @param id
     * @return Object
     */
    @DeleteMapping("/ads/{id}")
    @ApiOperation(value="删除一条广告 /delete")
    public Object adminDeleteAd(HttpServletRequest request,@PathVariable Integer id)
    {
        String adminId= request.getHeader("id");
        if (adminId==null){
            return ResponseUtil.unlogin();
        }
        Log log=new Log();
        log.setAdminId(Integer.valueOf(adminId));
        log.setIp(request.getRemoteAddr());
        log.setType(0);
        log.setActions("删除广告");

        int ret=adService.deleteAd(id);
        if(ret==0){
            log.setStatusCode(0);
            writeLog(log);
            return ResponseUtil.badArgumentValue();
        }
        log.setStatusCode(1);
        writeLog(log);
        return ResponseUtil.ok();
    };

    /**
     * 用户端获得广告，获取在当前时间点可以播放的广告列表，如果没有，则返回默认广告
     *
     * @return Object
     */
    @GetMapping("/ads")
    @ApiOperation(value="用户查询广告")
    public Object userFindAd()
    {
        List<Ad> adList=adService.userFindAd();
        return ResponseUtil.ok(adList);
    };

}