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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import xmu.oomall.domain.Ad;
import xmu.oomall.domain.Log;
import xmu.oomall.service.AdService;
import xmu.oomall.util.FileUploadUtil;
import xmu.oomall.util.IdUtil;
import xmu.oomall.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("")
public class AdController {
    @Autowired
    private AdService adService;
    @Autowired
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
    private Log createLog(HttpServletRequest request,Integer type,Integer status,String action)
    {
//        String adminId= request.getHeader("id");
//        if (adminId==null){
//            return null;
//        }
        Log log=new Log();
//      log.setAdminId(Integer.valueOf(adminId));
        log.setIp(request.getRemoteAddr());
        log.setType(type);
        log.setActions(action);
        log.setStatusCode(status);
        return log;
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
        if(name.equals(""))
        {
            name=null;
        }
        if(content.equals(""))
        {
            content=null;
        }
        Log log=createLog(request, 0, 1, "查询广告列表");
        System.out.println(page + " " + limit);
        if(log!=null) {
            writeLog(log);
        }
        else
        {
            return ResponseUtil.unlogin();
        }
        List<Ad> adList = adService.adminFindAdList(page,limit,name, content);
        return ResponseUtil.ok(adList);
    }

    /**
     * 管理员上传图片
     *
     * @param file
     * @return object
     * @throws Exception
     */
    @RequestMapping(value="/pics",method = RequestMethod.POST)
    public Object uploadPicture(@RequestParam(value = "file",required = false) MultipartFile file) throws Exception {
        if(file==null){
            return ResponseUtil.badArgument();
        }
        String path = "E:/testPic/"
                + IdUtil.genImageName()
                +file.getOriginalFilename();
        String ok="Success";
        if(ok.equals(FileUploadUtil.upload(file,path))){
            String prefix="http://localhost";
            return ResponseUtil.ok(prefix+path);
        }
        return ResponseUtil.fail();
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
        Object re=validate(ad);
        if(re!=null)
        {
            Log log=createLog(request, 0, 0, "新建广告");
            if(log!=null) {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
            return re;
        }
        else
        {
            Log log=createLog(request, 0, 1, "新建广告");
            if(log!=null) {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
            adService.createAd(ad);
            return ResponseUtil.ok(ad);
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

        Ad ad=adService.findAdById(id);
        if(ad!=null)
        {
            Log log=createLog(request, 0, 1, "查看单条广告");
            if(log!=null) {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
            Object object = ResponseUtil.ok(ad);
            return object;
        }
        else
        {
            Log log=createLog(request, 0, 0, "查看单条广告");
            if(log!=null) {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
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
        ad.setId(id);
        if(adService.updateAd(ad))
        {
            Log log=createLog(request, 0, 1, "修改广告信息");
            if(log!=null) {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
            Object object = ResponseUtil.ok(ad);
            return object;
        }
        else
        {
            Log log=createLog(request, 0, 0, "修改广告信息");
            if(log!=null) {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
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
        int ret=adService.deleteAd(id);
        if(ret==0){
            Log log=createLog(request, 0, 0, "删除广告");
            if(log!=null) {
                writeLog(log);
            }
            else
            {
                return ResponseUtil.unlogin();
            }
            return ResponseUtil.badArgumentValue();
        }
        Log log=createLog(request, 0, 1, "删除广告");
        if(log!=null) {
            writeLog(log);
        }
        else
        {
            return ResponseUtil.unlogin();
        }
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