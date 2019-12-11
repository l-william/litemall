/**
 * @author xingzhou
 * @date 2019/12/7 23:48
 * @version 1.0
 */

package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.BrandDao;
import xmu.oomall.domain.Brand;
import xmu.oomall.service.BrandService;

import java.util.List;

/**
 * 商标的service实现类
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandDao brandDao;

    /**
     * 通过id和名字查找商标列表
     *
     * @param id    品牌ID
     * @param name  品牌名称
     * @param page  分页页号
     * @param limit 分页大小
     * @return 商标列表
     */
    @Override
    public List<Brand> findBrandListByIdAndName(String id, String name, Integer page, Integer limit) {
        List<Brand> brandList= brandDao.findBrandListByIdAndName(id,name);
        int maxPages=(brandList.size()-1)/limit+1;
        if(page<maxPages){
            return brandList.subList((page-1)*limit,page*limit);
        }
        if(page==maxPages){
            return brandList.subList((page-1)*limit,brandList.size());
        }
        //page>maxPage的情况有待修改
        return null;
    }

    /**
     * 添加商标
     *
     * @param brand 品牌信息
     * @return 操作成功与否
     */
    @Override
    public int addBrand(Brand brand) {
        return brandDao.addBrand(brand);
    }

    /**
     * 通过id查找id
     *
     * @param id 品牌ID
     * @return 商标
     */
    @Override
    public Brand findBrandById(Integer id) {
        return brandDao.findBrandById(id);
    }

    /**
     * 通过id更新商标
     *
     * @param id    品牌ID
     * @param brand 品牌
     * @return 操作成功与否
     */
    @Override
    public int updateBrandById(Integer id,Brand brand) {
        brand.setId(id);
        return brandDao.updateBrand(brand);
    }

    /**
     * 通过id删除商标
     *
     * @param id 品牌ID
     * @return 操作成功与否
     */
    @Override
    public int deleteBrandById(Integer id) {
        return brandDao.deleteBrandById(id);
    }

    /**
     * 查看商标列表
     *
     * @param page  分页页号
     * @param limit 分页大小
     * @return 商标列表
     */
    @Override
    public List<Brand> findBrandList(Integer page, Integer limit) {
        List<Brand> brandList= brandDao.findBrandList();
        int maxPages=(brandList.size()-1)/limit+1;
        if(page<maxPages){
            return brandList.subList((page-1)*limit,page*limit);
        }
        if(page==maxPages){
            return brandList.subList((page-1)*limit,brandList.size());
        }
        //page>maxPage的情况有待修改
        return null;
    }
}
