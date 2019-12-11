package xmu.oomall.daoTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xmu.oomall.dao.AddressDao;
import xmu.oomall.domain.Address;

import java.util.List;

@SpringBootTest
public class AddressDaoTest {
    /**
     * xyt
     */
    @Autowired
    private AddressDao addressDao;
    @Test
    void findAddressById(){
        Integer a=10001;
        Address address=addressDao.findAddressById(a);
        if(address==null)
            System.out.println("not find!");
        else
            System.out.println(address.getId());
    }
    @Test
    void findAddressListByUserId(){
        Integer a=100002;
        List<Address> address=addressDao.findAddressListByUserId(a);
        if(address==null)
            System.out.println("not find!");
        else
            System.out.println(address.size());
    }
    @Test
    void addAddress(){
        Address address=new Address();
        address.setAddressDetail("厦门");
        if(addressDao.addAddress(address)==1)
        {
            System.out.println("add success");
        }
        else
        {
            System.out.println("failed");
        }
    }
    @Test
    void updateAddress(){
        Address address=new Address();
        address.setId(10001);
        address.setAddressDetail("xiamen");
        if(addressDao.updateAddress(address)==1)
        {
            System.out.println("update success");
        }
        else
        {
            System.out.println("failed");
        }
    }
    @Test
    void deleteAddressById(){
        if(addressDao.deleteAddressById(1)==1)
        {
            System.out.println("del success");
        }
        else
        {
            System.out.println("failed");
        }
    }

}
