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
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressDao addressDao;

    @Override
    public List<Address> findAddressList(Integer page,Integer limit) {
        List<Address> addressList=addressDao.findAddressList();
        return divideByPage(addressList,page,limit);
    }

    @Override
    public Address findAddressById(Integer id) {
        return addressDao.findAddressById(id);
    }

    @Override
    public List<Address> findAddressListByUserId(Integer userId) {
        return addressDao.findAddressListByUserId(userId);
    }

    @Override
    public List<Address> findAddressListByUserIdAndConsignee(Integer userId, String consignee, Integer page, Integer limit) {
        List<Address> addressList=addressDao.findAddressListByUserIdAndConsignee(userId,consignee);
        return divideByPage(addressList,page,limit);
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
        return addressDao.deleteAddressById(id);
    }

    @Override
    public void clearDefaultAddress(Integer userId) {
        List<Address> addressList=addressDao.findAddressListByUserId(userId);
        for (Address address:addressList) {
            if(address.isBeDefault()==true){
                address.setBeDefault(false);
                addressDao.updateAddress(address);
            }
        }
    }

    @Override
    public int validate(Address address) {
        boolean valid=address.getCityId()!=null
                &&address.getCountyId()!=null
                &&address.getProvinceId()!=null;
        if(valid){
            return 1;
        }
        return 0;
    }

    private <T> List<T> divideByPage(List<T> list,Integer page,Integer limit){
        int maxPages=(list.size()-1)/limit+1;
        if(page<maxPages){
            return list.subList((page-1)*limit,page*limit);
        }
        if(page==maxPages){
            return list.subList((page-1)*limit,list.size());
        }
        //page>maxPages
        return null;
    }
}