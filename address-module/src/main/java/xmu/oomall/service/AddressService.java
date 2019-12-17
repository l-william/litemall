package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.Address;
import xmu.oomall.domain.AddressPo;

import java.util.List;

/**
 * @author CFH
 * @date 2019/12/9 00:14
 * @version 1.0
 */
public interface AddressService {

    /**
     * 查询用户所有地址
     *
     * @param userId 用户ID
     * @param page 分页页号
     * @param limit 分页大小
     * @return 该用户的所有地址列表
     */
    List<Address> findAddressListByUserId(Integer userId,Integer page,Integer limit);

    /**
     * 根据地址ID查找地址
     *
     * @param id 地址ID
     * @return 地址信息
     */
    Address findAddressById(Integer id);

    /**
     * 通过用户ID与收货人查找地址
     *
     * @param userId 用户ID
     * @param consignee 收货人姓名
     * @param page 分页页号
     * @param limit 分页大小
     * @return 地址列表
     */
    List<Address> findAddressListByUserIdAndConsignee(Integer userId,String consignee,Integer page,Integer limit);

    /**
     * 添加地址
     *
     * @param addressPo
     * @return 新增的地址
     */
    AddressPo addAddress(AddressPo addressPo);

    /**
     * 更新地址
     *
     * @param addressPo
     * @return 更新后的地址
     */
    AddressPo updateAddress(AddressPo addressPo);

    /**
     * 删除地址
     *
     * @param id 地址ID
     * @return 是否操作成功
     */
    int deleteAddress(Integer id);

    /**
     * 清除默认地址
     *
     * @param userId 用户ID
     */
    void clearDefaultAddress(Integer userId);
}

