package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.Address;

import java.util.List;

/**
 * @author CFH
 * @date 2019/12/9 00:14
 * @version 1.0
 */
@Service
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
    List<Address> findAddressListByUserId(Integer userId);

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
     * 设置为默认地址
     *
     * @param address 待设置的地址
     * @return 是否操作成功
     */
    int setDefaultAddress(Address address);
}
