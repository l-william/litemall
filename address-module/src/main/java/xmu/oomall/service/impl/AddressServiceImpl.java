package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.AddressDao;
import xmu.oomall.domain.Address;
import xmu.oomall.domain.AddressPo;
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
    public List<Address> findAddressListByUserId(Integer userId,Integer page,Integer limit) {
        List<Address> addressList=addressDao.findAddressListByUserId(userId);
        return divideByPage(addressList,page,limit);
    }

    @Override
    public Address findAddressById(Integer id) {
        return addressDao.findAddressById(id);
    }

    @Override
    public List<Address> findAddressListByUserIdAndConsignee(Integer userId, String consignee, Integer page, Integer limit) {
        List<Address> addressList=addressDao.findAddressListByUserIdAndConsignee(userId,consignee);
        return divideByPage(addressList,page,limit);
    }

    @Override
    public AddressPo addAddress(AddressPo addressPo) {
        return addressDao.addAddress(addressPo);
    }

    @Override
    public AddressPo updateAddress(AddressPo addressPo) {
        return addressDao.updateAddress(addressPo);
    }

    @Override
    public int deleteAddress(Integer id) {
        return addressDao.deleteAddress(id);
    }

    @Override
    public void clearDefaultAddress(Integer userId) {
        List<Address> addressList=addressDao.findAddressListByUserId(userId);
        for (Address address:addressList) {
            if(address.isBeDefault()){
                address.setBeDefault(false);
                addressDao.updateAddress(address);
            }
        }
    }


    /**
     * 分页功能
     *
     * @param list 父列表
     * @param page 分页页数
     * @param limit 分页大小
     * @param <T> 列表元素类型
     * @return 子列表
     */
    private <T> List<T> divideByPage(List<T> list,Integer page,Integer limit){
        int maxPages=(list.size()-1)/limit+1;
        if(page<maxPages){
            return list.subList((page-1)*limit,page*limit);
        }
        if(page==maxPages){
            return list.subList((page-1)*limit,list.size());
        }
        //page>maxPages
        return list.subList(0,0);
    }
}