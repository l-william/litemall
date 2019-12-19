/**
 * @author xingzhou
 * @date 2019/12/7 23:48
 * @version 1.0
 */
package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.Brand;
import xmu.oomall.domain.BrandPo;

import java.util.List;

@Service
public interface BrandService {
    /**
     * 根据条件搜索品牌
     *
     * @param id 品牌ID
     * @param name 品牌名称
     * @param page 分页页号
     * @param limit 分页大小
     * @return 品牌列表
     */
    List<BrandPo> findBrandListByIdAndName(Integer id, String name,Integer page,Integer limit);

    /**
     * 查看品牌列表
     *
     * @param page 分页页号
     * @param limit 分页大小
     * @return 品牌列表
     */
    List<BrandPo> findBrandList(Integer page,Integer limit);

    /**
     * 查看单个品牌信息
     *
     * @param id 品牌ID
     * @return 品牌信息
     */
    BrandPo findBrandById(Integer id);

    /**
     * 创建一个品牌
     *
     * @param brandPo 品牌信息
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
     * @return 是否操作成功
     */
    int deleteBrand(Integer id);

}
