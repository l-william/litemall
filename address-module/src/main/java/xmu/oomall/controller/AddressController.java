package xmu.oomall.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import xmu.oomall.domain.Address;
import xmu.oomall.domain.AddressPo;
import xmu.oomall.domain.Log;
import xmu.oomall.service.AddressService;
import xmu.oomall.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author CFH
 * @date 2019/12/9 23:58
 * @version 1.0
 *
 */
@RestController
@RequestMapping("")
@Validated
public class AddressController {

    @Autowired
    private AddressService addressService;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 用户获取自己所有的地址列表
     *
     * @param request 网页请求
     * @param page 分页页号
     * @param limit 分页大小
     * @return 用户所有的收货地址列表
     */
    @GetMapping("/addresses")
    public Object getUserAddressList(HttpServletRequest request,
                                     @RequestParam(defaultValue = "1") Integer page,
                                     @RequestParam(defaultValue = "10") Integer limit) {
        Integer userId= request.getIntHeader("userId");
        if(userId==null||userId==0){
            return ResponseUtil.unlogin();
        }
        List<Address> addressList=addressService.findAddressListByUserId(userId,page,limit);
        return ResponseUtil.ok(addressList);
    }

    /**
     * 查看收货地址详情
     *
     * @param id 收货地址ID
     * @return 收货地址详情
     */
    @GetMapping("/addresses/{id}")
    public Object getAddressById(@PathVariable Integer id) {
        Address address=addressService.findAddressById(id);
        if(address==null){
            return ResponseUtil.fail(744, "地址不存在");
        }
        return ResponseUtil.ok(address);
    }

    /**
     * 用户添加收货地址
     *
     * @param addressPo 用户收货地址
     * @return 新添加的地址
     */
    @PostMapping("/addresses")
    public Object addAddress(@RequestBody AddressPo addressPo) {
        if(!validate(addressPo)){
            return ResponseUtil.fail(751, "地址新增失败");
        }
        if(addressPo.isBeDefault()){
            Integer userId=addressPo.getUserId();
            addressService.clearDefaultAddress(userId);
        }
        AddressPo retPo=addressService.addAddress(addressPo);
        if(retPo==null){
            return ResponseUtil.fail(751, "地址新增失败");
        }
        return ResponseUtil.ok(retPo);
    }

    /**
     * 用户删除收货地址
     *
     * @param id 地址ID
     * @return 删除操作结果
     */
    @DeleteMapping("/addresses/{id}")
    public Object deleteAddress(@PathVariable Integer id) {
        int ret= addressService.deleteAddress(id);
        if(ret==0){
            return ResponseUtil.fail(753, "地址删除失败");
        }
        return  ResponseUtil.ok();
    }


    /**
     * 用户更新地址
     *
     * @param addressPo 地址信息
     * @return 更新成功后的地址
     */
    @PutMapping("/addresses/{id}")
    public Object updateAddress(@PathVariable Integer id,@RequestBody AddressPo addressPo) {
        if(!validate(addressPo)){
            return ResponseUtil.fail(752, "地址修改是失败");
        }
        if(addressPo.isBeDefault()){
            Integer userId=addressPo.getUserId();
            addressService.clearDefaultAddress(userId);
        }
        addressPo.setId(id);
        AddressPo retPo=addressService.updateAddress(addressPo);
        if(retPo==null){
            return ResponseUtil.fail(752, "地址修改失败");
        }
        return ResponseUtil.ok(retPo);
    }

    /**
     * 管理员获取地址列表
     *
     * @param userId 用户id
     * @param name 用户名
     * @return 用户的地址列表
     */
    @GetMapping("/admin/addresses")
    public Object getAddressList(HttpServletRequest request,
                              @RequestParam Integer userId,
                              @RequestParam String name,
                              @RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "10") Integer limit)
    {
        if(name=="")
        {
            name=null;
        }
        Log log=createLog(request, 0, 1, "查询地址列表",null);
        if(log!=null) {
            writeLog(log);
        }
        else {
            return ResponseUtil.unlogin();
        }
        List<Address> addressList=addressService.findAddressListByUserIdAndConsignee(userId,name,page,limit);
        return ResponseUtil.ok(addressList);
    }

    /**
     * 验证传入的地址是否合法
     *
     * @param addressPo 地址信息
     * @return 是否合法
     */
    private boolean validate(AddressPo addressPo){
        boolean notValidate=addressPo.getCityId()==0
                ||addressPo.getCountyId()==0
                ||addressPo.getProvinceId()==0
                ||StringUtils.isEmpty(addressPo.getAddressDetail())
                ||StringUtils.isEmpty(addressPo.getPostalCode())
                ||StringUtils.isEmpty(addressPo.getConsignee())
                ||StringUtils.isEmpty(addressPo.getMobile());
        return !notValidate;
    }

    /**
     * 日志记录函数
     *
     * @param log 日志
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
     * @param actionId
     * @return 返回生成的日志或者空值，空值则进行未登录错误处理
     */
    private Log createLog(HttpServletRequest request,Integer type,Integer status,String action,Integer actionId)
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
        log.setActionId(actionId);
        log.setStatusCode(status);
        return log;
    }
}