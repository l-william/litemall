/**
 * @author xingzhou
 * @date 2019/12/7 23:48
 * @version 1.0
 */

package xmu.oomall.service.impl;

import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.BrandDao;
import xmu.oomall.domain.Brand;
import xmu.oomall.domain.BrandPo;
import xmu.oomall.service.BrandService;

import java.util.List;

/**
 * @author CFH
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
    public List<BrandPo> findBrandListByIdAndName(Integer id, String name, Integer page, Integer limit) {
        List<BrandPo> brandList= brandDao.findBrandListByIdAndName(id,name);
        return divideByPage(brandList,page,limit);
    }

    /**
     * 查看商标列表
     *
     * @param page  分页页号
     * @param limit 分页大小
     * @return 商标列表
     */
    @Override
    public List<BrandPo> findBrandList(Integer page, Integer limit) {
        List<BrandPo> brandList= brandDao.findBrandList();
        return divideByPage(brandList,page,limit);
    }

    /**
     * 通过id查找id
     *
     * @param id 品牌ID
     * @return 商标
     */
    @Override
    public BrandPo findBrandById(Integer id) {
        return brandDao.findBrandById(id);
    }

    /**
     * 添加商标
     *
     * @param brandPo 品牌信息
     * @return 新增的品牌
     */
    @Override
    public BrandPo addBrand(BrandPo brandPo) {
        return brandDao.addBrand(brandPo);
    }

    /**
     * 通过id更新商标
     *
     * @param brandPo 品牌
     * @return 更新后的品牌
     */
    @Override
    public BrandPo updateBrand(BrandPo brandPo) {
        return brandDao.updateBrand(brandPo);
    }

    /**
     * 通过id删除商标
     *
     * @param id 品牌ID
     * @return 操作成功与否
     */
    @Override
    public int deleteBrand(Integer id) {
        return brandDao.deleteBrand(id);
    }

    /**
     * 分页功能
     *
     * @param list 父列表
     * @param page 分页页数
     * @param limit 分页大小
     * @param <T> 列表元素类型
     * @return 子列表
     */
    private <T> List<T> divideByPage(List<T> list,Integer page,Integer limit){
        int maxPages=(list.size()-1)/limit+1;
        if(page<maxPages){
            return list.subList((page-1)*limit,page*limit);
        }
        if(page==maxPages){
            return list.subList((page-1)*limit,list.size());
        }
        //page>maxPages
        return list.subList(0,0);
    }
}
