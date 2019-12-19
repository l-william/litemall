/**
 * @author llh,cfh
 * @date 2019/12/8 15:45
 * @version 1.0
 */
package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xmu.oomall.domain.Brand;
import xmu.oomall.domain.BrandPo;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface BrandMapper {
    /**
     * 查找所有品牌
     *
     * @return 品牌列表
     */
    List<BrandPo> findBrandList();

    /**
     * 根据品牌ID和品牌名称查找品牌列表
     *
     * @param id 品牌ID
     * @param name 品牌名称
     * @return 品牌列表
     */
    List<BrandPo> findBrandListByIdAndName(@Param("id") Integer id, @Param("name") String name);

    /**
     * 根据品牌ID获取品牌信息
     *
     * @param id 品牌ID
     * @return 品牌信息
     */
    BrandPo findBrandById(Integer id);

    /**
     * 添加品牌
     *
     * @param brandPo 品牌
     * @return 是否操作成功
     */
    BrandPo addBrand(BrandPo brandPo);

    /**
     * 更新品牌
     *
     * @param brandPo 品牌信息
     * @return 是否操作成功
     */
    BrandPo updateBrand(BrandPo brandPo);

    /**
     * 删除品牌
     *
     * @param id 品牌ID
     * @param deleteTime 删除时间
     * @return 是否操作成功
     */
    int deleteBrand(Integer id, LocalDateTime deleteTime);
}


