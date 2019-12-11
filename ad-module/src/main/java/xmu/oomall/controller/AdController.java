/**
 * @author xingzhou
 * @date 2019/12/6 15:58
 * @version 1.0
 */
package xmu.oomall.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.Ad;
import xmu.oomall.service.AdService;
import xmu.oomall.util.ResponseUtil;

import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@RequestMapping("")
public class AdController {
    @Autowired
    private AdService adService;

    @GetMapping("/admins/ads")
    @ApiOperation(value="管理员查看所有的广告  /list")
    public Object adminFindAdList(String name, String content
//                                  @RequestParam(defaultValue = "1") Integer page,
//                                  @RequestParam(defaultValue = "10") Integer limit
//                       @Sort @RequestParam(defaultValue = "add_time") String sort,
//                       @Order @RequestParam(defaultValue = "desc") String order
    ) {
        List<Ad> adList = adService.adminFindAdList(name, content);
        return ResponseUtil.ok(adList);
    }


    @PostMapping("/ads")
    @ApiOperation(value="新建一条广告 /create")
    public Object adminCreateAd(@RequestBody Ad ad) {
        adService.createAd(ad);
        return ResponseUtil.ok();
    }

    @GetMapping("/ads/{id}")
    @ApiOperation(value="查看单条广告 /read")
    public Object adminFindAd(@PathVariable Integer id)
    {
        Ad ad=adService.findAdById(id);
        if(ad!=null)
        {
            Object object = ResponseUtil.ok(ad);
            return object;
        }
        else
        {
            Object object = ResponseUtil.fail();
            return object;
        }
    };

    @PutMapping("/ads/{id}")
    @ApiOperation(value="修改广告信息 /update")
    public Object adminUpdateAd(@PathVariable Integer id,@RequestBody Ad ad)
    {
        ad.setId(id);
        if(adService.updateAd(ad))
        {
            Object object = ResponseUtil.ok(ad);
            return object;
        }
        else
        {
            Object object=ResponseUtil.fail();
            return object;
        }
    };


    @DeleteMapping("/ads/{id}")
    @ApiOperation(value="删除一条广告 /delete")
    public Object adminDeleteAd(@PathVariable Integer id,@RequestBody Ad ad)
    {
        int ret=adService.deleteAd(id);
        if(ret==0){
            return ResponseUtil.fail();
        }
        return ResponseUtil.ok();
    };

    @GetMapping("/ads")
    @ApiOperation(value="用户查询广告")
    public Object userFindAd()
    {
        List<Ad> adList=adService.userFindAd();
        return ResponseUtil.ok(adList);
    };

}