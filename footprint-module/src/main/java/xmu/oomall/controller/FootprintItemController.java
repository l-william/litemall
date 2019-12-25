package xmu.oomall.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import xmu.oomall.domain.FootprintItem;
import xmu.oomall.domain.FootprintItemPo;
import xmu.oomall.service.FootprintItemService;
import xmu.oomall.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @author CFH 12/23
 */

@RestController
@RequestMapping("")
@Validated
public class FootprintItemController {
    @Autowired
    private FootprintItemService footprintItemService;

    /**
     * 用户浏览自己的足迹
     *
     * @param request 网页请求
     * @param page 分页页号
     * @param limit 分页大小
     * @return 用户的足迹列表
     */
    @GetMapping("/footprints")
    public Object userGetFootprintList(HttpServletRequest request,
                                   @RequestParam(defaultValue = "1") Integer page,
                                   @RequestParam(defaultValue = "10") Integer limit) {
        Integer userId= request.getIntHeader("userId");
        if(userId==null){
            return ResponseUtil.unlogin();
        }
        List<FootprintItem> footprintList=footprintItemService.userFindFootprintList(userId,page,limit);
        if(footprintList.size()==0){
            return ResponseUtil.fail(742,"足迹查询失败");
        }
        return ResponseUtil.ok(footprintList);
    }

    /**
     * 管理员根据条件查询足迹列表
     *
     * @param request 网页请求
     * @param userId 用户ID
     * @param goodsId 商品ID
     * @param page 分页页号
     * @param limit 分页大小
     * @return 足迹列表
     */
    @GetMapping("/admin/footprints")
    public Object adminGetFootprintList(HttpServletRequest request,
                                        @RequestParam Integer userId,
                                        @RequestParam Integer goodsId,
                                        @RequestParam(defaultValue = "1") Integer page,
                                        @RequestParam(defaultValue = "10") Integer limit) {

        List<FootprintItem> footprintList=footprintItemService.adminFindFootprintList(userId,goodsId,page,limit);
        if(footprintList.size()==0){
            return ResponseUtil.fail(742,"足迹查询失败");
        }
        return ResponseUtil.ok(footprintList);
    }

    /**
     * 添加足迹
     *
     * @param footprintItemPo 待添加的足迹信息
     * @return 新增的足迹
     */
    @PostMapping("/footprints")
    public Object addFootprint(@RequestBody FootprintItemPo footprintItemPo){
        FootprintItemPo retPo=footprintItemService.addFootprint(footprintItemPo);
        if(retPo==null){
            return ResponseUtil.fail(741,"足迹添加失败");
        }
        return ResponseUtil.ok(retPo);
    }


}
