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

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandDao brandDao;

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

    @Override
    public int addBrand(Brand brand) {
        return brandDao.addBrand(brand);
    }

    @Override
    public Brand findBrandById(Integer id) {
        return brandDao.findBrandById(id);
    }

    @Override
    public int updateBrandById(Integer id,Brand brand) {
        brand.setId(id);
        return brandDao.updateBrand(brand);
    }

    @Override
    public int deleteBrandById(Integer id) {
        return brandDao.deleteBrandById(id);
    }

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
