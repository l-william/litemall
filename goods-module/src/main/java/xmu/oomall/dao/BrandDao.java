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

/**
 * 商标的dao层
 */
@Repository
public class BrandDao {
    @Autowired(required = false)
    private BrandMapper brandMapper;

    /**
     * 查看商标列表
     *
     * @return 商标列表
     */
    public List<Brand> findBrandList(){
        return brandMapper.findBrandList();
    }

    /**
     * 通过id和名字查找商标
     *
     * @param id
     * @param name
     * @return 商标列表
     */
    public List<Brand> findBrandListByIdAndName(String id,String name){
        return brandMapper.findBrandListByIdAndName(id,name);
    }

    /**
     * 通过id查找商标
     *
     * @param id
     * @return 商标
     */
    public Brand findBrandById(Integer id){
        return brandMapper.findBrandById(id);
    }

    /**
     * 添加商标
     *
     * @param brand
     * @return 操作成功与否
     */
    public int addBrand(Brand brand){
        brand.setGmtCreate(LocalDateTime.now());
        brand.setGmtModified(LocalDateTime.now());
        brand.setBeDeleted(false);
        return brandMapper.addBrand(brand);
    }

    /**
     * 更新商标信息
     *
     * @param brand
     * @return 操作成功与否
     */
    public int updateBrand(Brand brand){
        brand.setGmtModified(LocalDateTime.now());
        return brandMapper.updateBrand(brand);
    }

    /**
     * 通过id删除商标
     *
     * @param id
     * @return 操作成功与否
     */
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
