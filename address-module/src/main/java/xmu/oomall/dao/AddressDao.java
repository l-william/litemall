package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.Address;
import xmu.oomall.domain.AddressPo;
import xmu.oomall.mapper.AddressMapper;

import java.time.LocalDateTime;
import java.util.List;


/**
 * @author CFH
 * @date 2019/12/9 00:06
 * @version 1.0
 */
@Repository
public class AddressDao {

    @Autowired(required = false)
    AddressMapper addressMapper;

    public Address findAddressById(Integer id){
        return addressMapper.findAddressById(id);
    }

    public List<Address> findAddressListByUserId(Integer userId){
        return addressMapper.findAddressListByUserId(userId);
    }

    public List<Address> findAddressListByUserIdAndConsignee(Integer userId,String consignee){
        return addressMapper.findAddressListByUserIdAndConsignee(userId,consignee);
    }

    public AddressPo addAddress(AddressPo addressPo){
        addressPo.setGmtCreate(LocalDateTime.now());
        addressPo.setGmtModified(LocalDateTime.now());
        addressPo.setBeDeleted(false);
        int ret=addressMapper.addAddress(addressPo);
        if(ret==0){
            return null;
        }
        return addressPo;
    }

    public AddressPo updateAddress(AddressPo addressPo) {
        addressPo.setGmtModified(LocalDateTime.now());
        int ret=addressMapper.updateAddress(addressPo);
        if(ret==0){
            return null;
        }
        return addressPo;
    }

    public int deleteAddress(Integer id){
        LocalDateTime deleteTime=LocalDateTime.now();
        return addressMapper.deleteAddress(id,deleteTime);
    }
}
