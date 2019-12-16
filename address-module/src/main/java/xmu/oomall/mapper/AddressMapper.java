package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Mapper;
import xmu.oomall.domain.Address;

import java.util.List;

/**
 * @author CFH
 * @date 2019/12/8 23:50
 * @version 1.0
 */
@Mapper
public interface AddressMapper {

    /**
     * 查询所有地址（意义不明）
     *
     * @return 所有地址列表
     */
    List<Address> findAddressList();

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
     * 通过用户ID与收货人查找地址
     *
     * @param userId 用户ID
     * @param consignee 收货人姓名
     * @return 地址列表
     */
    List<Address> findAddressListByUserIdAndConsignee(Integer userId,String consignee);

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
}
