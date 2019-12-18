package xmu.oomall.daoTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.dao.AddressDao;
import xmu.oomall.domain.Address;
import xmu.oomall.domain.AddressPo;

import java.util.List;

/**
 * @author XYT,CFH
 *
 */
@SpringBootTest
public class AddressDaoTest {
    @Autowired
    private AddressDao addressDao;
    @Test
    void findAddressById(){
        Integer id=10001;
        Address address=addressDao.findAddressById(id);
        if(address==null)
            System.out.println("not found");
        else
            System.out.println(address.toString());
    }
    @Test
    void findAddressListByUserId(){
        Integer userId=100002;
        List<Address> addressList=addressDao.findAddressListByUserId(userId);
        if(addressList.size()==0) {
            System.out.println("not found");
        }
        else {
            for (Address address :addressList) {
                System.out.println(address.toString());
            }
        }
    }
    @Test
    void findAddressListByUserIdAndConsignee(){
        Integer userId=1001;
        String name="";
        List<Address> addressList=addressDao.findAddressListByUserIdAndConsignee(userId,name);
        if(addressList.size()==0) {
            System.out.println("not found");
        }
        else {
            for (Address address :addressList) {
                System.out.println(address.toString());
            }
        }
    }
    @Test
    void addAddress(){
        AddressPo addressPo=new AddressPo();
        addressPo.setBeDefault(false);
        addressPo.setAddressDetail("厦门");
        AddressPo retPo=addressDao.addAddress(addressPo);
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
        Integer id=10001;
        AddressPo addressPo=new AddressPo();
        addressPo.setId(id);
        addressPo.setBeDefault(true);
        addressPo.setAddressDetail("福州");
        AddressPo retPo=addressDao.updateAddress(addressPo);
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
        Integer id=1;
        int ret=addressDao.deleteAddress(id);
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
