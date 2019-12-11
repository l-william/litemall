/**
 * @author xingzhou
 * @date 2019/12/7 23:48
 * @version 1.0
 */
package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.Brand;

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
    public List<Brand> findBrandListByIdAndName(String id, String name,Integer page,Integer limit);

    /**
     * 创建一个品牌
     *
     * @param brand 品牌信息
     * @return 是否操作成功
     */
    public int addBrand(Brand brand);

    /**
     * 查看单个品牌信息
     *
     * @param id 品牌ID
     * @return 品牌信息
     */
    public Brand findBrandById(Integer id);

    /**
     * 更新品牌
     *
     * @param id 品牌ID
     * @param brand 品牌
     * @return 是否操作成功
     */
    public int updateBrandById(Integer id,Brand brand);

    /**
     * 删除品牌
     *
     * @param id 品牌ID
     * @return 是否操作成功
     */
    public int deleteBrandById(Integer id);

    /**
     * 查看品牌列表
     *
     * @param page 分页页号
     * @param limit 分页大小
     * @return 品牌列表
     */
    public List<Brand> findBrandList(Integer page,Integer limit);
}
