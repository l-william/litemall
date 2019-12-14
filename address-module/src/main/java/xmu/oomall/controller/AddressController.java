package xmu.oomall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xmu.oomall.domain.Address;
import xmu.oomall.service.AddressService;
import xmu.oomall.util.ResponseUtil;

import javax.validation.constraints.NotNull;
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
    AddressService addressService;
    /**
     * 用户收货地址列表
     *
     * @param userId 用户ID
     * @return 收货地址列表
     */
    @GetMapping("/addresses")
    public Object getAddressListByUserId(Integer userId) {
        List<Address> addressList=addressService.findAddressListByUserId(userId.toString());
        return ResponseUtil.ok(addressList);
    }

    /**
     * 收货地址详情
     *
     * @param id     收货地址ID
     * @return 收货地址详情
     */
    @GetMapping("/addresses/{id}")
    public Object getAddressById(@PathVariable Integer id) {
        Address address=addressService.findAddressById(id);
        if(address!=null){
            return ResponseUtil.ok(address);
        }
        return ResponseUtil.fail();
    }

    /**
     * 测试地址是否合法，比如是否有country/province等
     * 用int作为返回值表示成功与否
     */
    private int validate(Address address) {
        return addressService.validate(address);
    }

    /**
     * API设计者：添加收货地址
     *
     * @param userId  用户ID
     * @param address 用户收货地址
     * @return 新添加的地址
     */
    @PostMapping("/addresses")
    public Object save(Integer userId,@RequestBody Address address) {
        address.setUserId(userId);
        if(address.isBeDefault()==true){
            addressService.clearDefaultAddress(userId);
        }
        int ret=addressService.addAddress(address);
        if(ret==1){
            return ResponseUtil.ok(address);
        }
        return ResponseUtil.fail();
    }

    /**
     * 删除收货地址
     *
     * @param id 地址ID
     * @return 删除操作结果
     */
    @DeleteMapping("/addresses/{id}")
    public Object delete(@PathVariable Integer id) {
        int ret= addressService.deleteAddressById(id);
        if(ret==1){
            return ResponseUtil.ok();
        }
        return  ResponseUtil.fail();
    }


    /**
     * 更新地址
     *
     * @param userId 用户ID
     * @param address 地址信息
     * @param id 地址ID
     * @return 更新成功后的地址
     */
    @PutMapping("/addresses/{id}")
    public Object update(Integer userId,@RequestBody Address address,@PathVariable Integer id) {
        address.setId(id);
        address.setUserId(userId);
        if(address.isBeDefault()==true){
            addressService.clearDefaultAddress(userId);
        }
        int ret=addressService.updateAddress(address);
        if(ret==1){
            return ResponseUtil.ok(address);
        }
        return ResponseUtil.fail();
    }

    /**
     * 管理员获取地址列表
     *
     * @param userId 用户id
     * @param name 用户名
     * @return 用户的地址列表
     */
    @GetMapping("admin/addresses")
    public Object addressList(@RequestParam Integer userId,
                              @RequestParam String name,
                              @RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "1") Integer limit)
    {
        return null;
    }
}