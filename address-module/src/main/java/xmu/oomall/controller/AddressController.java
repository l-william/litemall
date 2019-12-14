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
    public Object list(Integer userId) {
        List<Address> addressList=addressService.findAddressListByUserId(userId);
        return ResponseUtil.ok(addressList);
    }

    /**
     * 收货地址详情
     *
     * @param userId 用户ID
     * @param id     收货地址ID
     * @return 收货地址详情
     */
    @GetMapping("/addresses/{id}")
    public Object detail(Integer userId, Integer id) {
        Address address=addressService.findAddressById(id);
        boolean found=address!=null&& address.getUserId().equals(userId);
        if(found){
            return ResponseUtil.ok(address);
        }
        return ResponseUtil.fail();
    }

    /**
     * 测试地址是否合法，比如是否有country/province等
     * 用int作为返回值表示成功与否
     */
    private int validate(Address address) {
        return 1;
    }

    /**
     * 添加或更新收货地址
     *
     * @param userId  用户ID
     * @param address 用户收货地址
     * @return 添加或更新操作结果
     */
    @PostMapping("/addresses")
    public Object save(Integer userId,  Address address) {
        //CFH: 新增？？？
        address.setUserId(userId);
        int ret=addressService.addAddress(address);
        if(ret==1){
            return ResponseUtil.ok(address);
        }
        return ResponseUtil.fail();
    }

    /**
     * 删除收货地址
     *
     * @param userId  用户ID
     * @param address 用户收货地址，{ id: xxx }
     * @return 删除操作结果
     */
    @DeleteMapping("/address/{id}")
    //这里用int表示删除操作成功与否
    public Object delete(Integer userId, Address address, Integer id) {
        //CFH:userId与address如何应用？？
        int ret= addressService.deleteAddressById(id);
        if(ret==1){
            return ResponseUtil.ok();
        }
        return  ResponseUtil.fail();
    }


    @PutMapping("/addresses/{id}")
    public Object update(Integer userId,  Address address, Integer id) {
        address.setId(id);
        address.setUserId(userId);
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

    @GetMapping("/addresses")
    public Object addressList(Integer userId,  String name)
    {
        return null;
    }
}