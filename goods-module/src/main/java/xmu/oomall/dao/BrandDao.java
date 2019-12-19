/**
 * @author xingzhou
 * @date 2019/12/7 23:46
 * @version 1.0
 */

package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.BrandPo;
import xmu.oomall.mapper.BrandMapper;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author CFH
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
    public List<BrandPo> findBrandList(){
        return brandMapper.findBrandList();
    }

    /**
     * 通过id和名字查找商标
     *
     * @param id
     * @param name
     * @return 商标列表
     */
    public List<BrandPo> findBrandListByIdAndName(Integer id, String name){
        return brandMapper.findBrandListByIdAndName(id,name);
    }

    /**
     * 通过id查找商标
     *
     * @param id
     * @return 商标
     */
    public BrandPo findBrandById(Integer id){
        return brandMapper.findBrandById(id);
    }

    /**
     * 添加商标
     *
     * @param brandPo
     * @return 操作成功与否
     */
    public BrandPo addBrand(BrandPo brandPo){
        brandPo.setGmtCreate(LocalDateTime.now());
        brandPo.setGmtModified(LocalDateTime.now());
        brandPo.setBeDeleted(false);
        int ret= brandMapper.addBrand(brandPo);
        if(ret==0){
            return null;
        }
        return brandPo;
    }

    /**
     * 更新商标信息
     *
     * @param brandPo
     * @return 操作成功与否
     */
    public BrandPo updateBrand(BrandPo brandPo){
        brandPo.setGmtModified(LocalDateTime.now());
        int ret=brandMapper.updateBrand(brandPo);
        if(ret==0){
            return null;
        }
        return brandPo;
    }

    /**
     * 通过id删除商标
     *
     * @param id
     * @return 操作成功与否
     */
    public int deleteBrand(Integer id){
        LocalDateTime deleteTime=LocalDateTime.now();
        return brandMapper.deleteBrand(id,deleteTime);
    }
}
