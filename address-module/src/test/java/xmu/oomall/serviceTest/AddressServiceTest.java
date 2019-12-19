package xmu.oomall.serviceTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import xmu.oomall.domain.Address;
import xmu.oomall.domain.AddressPo;
import xmu.oomall.service.AddressService;

import java.util.List;

public class AddressServiceTest {
    
    @Autowired
    private AddressService addressService;
    @Test
    void findAddressById(){
        Integer id=1;
        Address address=addressService.findAddressById(id);
        if(address==null) {
            System.out.println("not found");
        }
        else {
            System.out.println("收货人："+address.getConsignee());
            System.out.println("默认地址："+address.isBeDefault());
            System.out.println(address.toString());
        }
    }
    @Test
    void findAddressListByUserId(){
        Integer userId=11;
        List<Address> addressList=addressService.findAddressListByUserId(userId,1,10);
        if(addressList.size()==0) {
            System.out.println("not found");
        }
        else {
            for (Address address :addressList) {
                System.out.println("收货人："+address.getConsignee());
                System.out.println("默认地址："+address.isBeDefault());
                System.out.println(address.toString());
            }
        }
    }
    @Test
    void findAddressListByUserIdAndConsignee(){
        Integer userId=0;
        String name="陈";
        List<Address> addressList=addressService.findAddressListByUserIdAndConsignee(userId,name,1,10);
        if(addressList.size()==0) {
            System.out.println("not found");
        }
        else {
            for (Address address :addressList) {
                System.out.println("收货人："+address.getConsignee());
                System.out.println("默认地址："+address.isBeDefault());
                System.out.println(address.toString());
            }
        }
    }
    @Test
    void addAddress(){
        AddressPo addressPo=new AddressPo();
        addressPo.setBeDefault(false);
        addressPo.setUserId(15);
        addressPo.setConsignee("陈12");
        AddressPo retPo=addressService.addAddress(addressPo);
        if(retPo!=null)
        {
            System.out.println("add succeeded");
            System.out.println(retPo.toString());
        }
        else
        {
            System.out.println("add failed");
        }
    }
    @Test
    void updateAddress(){
        Integer id=4;
        AddressPo addressPo=new AddressPo();
        addressPo.setId(id);
        addressPo.setBeDefault(true);
        addressPo.setAddressDetail("福州");
        AddressPo retPo=addressService.updateAddress(addressPo);
        if(retPo!=null)
        {
            System.out.println("update succeeded");
            System.out.println(retPo.toString());
        }
        else
        {
            System.out.println("update failed");
        }
    }
    @Test
    void deleteAddress(){
        Integer id=3;
        int ret=addressService.deleteAddress(id);
        if(ret!=0)
        {
            System.out.println("delete succeeded");
        }
        else
        {
            System.out.println("delete failed");
        }
    }

}
