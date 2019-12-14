package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.Address;

import java.util.List;

/**
 * @author CFH
 * @date 2019/12/9 00:14
 * @version 1.0
 */
public interface AddressService {
    /**
     * 根据地址ID查找地址
     *
     * @param id 地址ID
     * @return 地址信息
     */
    Address findAddressById(Integer id);

    /**
     * 根据用户ID查找地址
     *
     * @param userId 用户ID
     * @return 该用户的地址列表
     */
    List<Address> findAddressListByUserId(String userId);

    /**
     * 添加地址
     *
     * @param address
     * @return 是否操作成功
     */
    int addAddress(Address address);

    /**
     * 更新地址
     *
     * @param address
     * @return 是否操作成功
     */
    int updateAddress(Address address);

    /**
     * 删除地址
     *
     * @param id 地址ID
     * @return 是否操作成功
     */
    int deleteAddressById(Integer id);

    /**
     * 清除默认地址
     *
     * @param userId 用户ID
     */
    void clearDefaultAddress(Integer userId);

    /**
     * 检查地址是否合法
     *
     * @param address 地址
     * @return 是否合法
     */
    int validate(Address address);
}

