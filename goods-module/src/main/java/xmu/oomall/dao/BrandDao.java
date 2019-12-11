/**
 * @author xingzhou
 * @date 2019/12/7 23:46
 * @version 1.0
 */

package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.Brand;
import xmu.oomall.mapper.BrandMapper;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class BrandDao {
    @Autowired(required = false)
    private BrandMapper brandMapper;

    public List<Brand> findBrandList(){
        return brandMapper.findBrandList();
    }

    public List<Brand> findBrandListByIdAndName(String id,String name){
        return brandMapper.findBrandListByIdAndName(id,name);
    }

    public Brand findBrandById(Integer id){
        return brandMapper.findBrandById(id);
    }

    public int addBrand(Brand brand){
        brand.setGmtCreate(LocalDateTime.now());
        brand.setGmtModified(LocalDateTime.now());
        brand.setBeDeleted(false);
        return brandMapper.addBrand(brand);
    }

    public int updateBrand(Brand brand){
        brand.setGmtModified(LocalDateTime.now());
        return brandMapper.updateBrand(brand);
    }

    public int deleteBrandById(Integer id){
        Brand brand=brandMapper.findBrandById(id);
        if(brand!=null)
        {
            brand.setGmtModified(LocalDateTime.now());
            brandMapper.updateBrand(brand);
        }
        return brandMapper.deleteBrandById(id);
    }
}
