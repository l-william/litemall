package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.AddressDao;
import xmu.oomall.domain.Address;
import xmu.oomall.service.AddressService;

import java.util.List;

/**
 * @author CFH
 * @date 2019/12/9 00:17
 * @version 1.0
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressDao addressDao;

    @Override
    public Address findAddressById(Integer id) {
        return addressDao.findAddressById(id);
    }

    @Override
    public List<Address> findAddressListByUserId(Integer userId) {
        return addressDao.findAddressListByUserId(userId);
    }

    @Override
    public int addAddress(Address address) {
        return addressDao.addAddress(address);
    }

    @Override
    public int updateAddress(Address address) {
        return addressDao.updateAddress(address);
    }

    @Override
    public int deleteAddressById(Integer id) {
        return deleteAddressById(id);
    }

    @Override
    public int setDefaultAddress(Address address) {
        String userId=address.getUserId();
        List<Address> userAddressList=addressDao.findAddressListByUserId(Integer.valueOf(userId));
        for (Address userAddress:userAddressList) {
            if(userAddress.isBeDefault()){
                userAddress.setBeDefault(false);
                addressDao.updateAddress(userAddress);
                break;
            }
        }
        address.setBeDefault(true);
        return addressDao.updateAddress(address);
    }
}
