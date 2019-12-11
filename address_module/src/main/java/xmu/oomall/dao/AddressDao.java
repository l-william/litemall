package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import xmu.oomall.domain.Address;
import xmu.oomall.mapper.AddressMapper;

import java.time.LocalDateTime;
import java.util.List;


/**
 * @author CFH
 * @date 2019/12/9 00:06
 * @version 1.0
 */
public class AddressDao {
    @Autowired
    AddressMapper addressMapper;

    public Address findAddressById(Integer id){
        return addressMapper.findAddressById(id);
    }

    public List<Address> findAddressListByUserId(String userId){
        return addressMapper.findAddressListByUserId(userId);
    }

    public int addAddress(Address address){
        address.setGmtCreate(LocalDateTime.now());
        address.setBeDeleted(false);
        return addressMapper.addAddress(address);
    }

    public int updateAddress(Address address){
        address.setGmtModified(LocalDateTime.now());
        return addressMapper.updateAddress(address);
    }

    public int deleteAddressById(Integer id){
        return addressMapper.deleteAddressById(id);
    }
}
