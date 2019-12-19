/**
 * @author xingzhou
 * @date 2019/12/8 11:34
 * @version 1.0
 */

package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.GoodsCategoryDao;
import xmu.oomall.domain.GoodsCategory;
import xmu.oomall.domain.GoodsCategoryPo;
import xmu.oomall.service.GoodsCategoryService;

import java.util.List;

/**
 * 商品分类的service实现类
 */
@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {
    @Autowired
    private GoodsCategoryDao goodsCategoryDao;

    /**
     * 通过id查找商品分类
     *
     * @param id
     * @return 商品分类
     */
    @Override
    public GoodsCategoryPo findGoodsCategoryById(Integer id) {
        return goodsCategoryDao.findGoodsCategoryById(id);
    }

    /**
     * 新建商品分类
     *
     * @param goodsCategoryPo
     * @return 操作码
     */
    @Override
    public GoodsCategoryPo addGoodsCategory(GoodsCategoryPo goodsCategoryPo) {
        return goodsCategoryDao.addGoodsCategory(goodsCategoryPo);
    }

    /**
     *通过id删除商品分类
     *
     * @param id
     * @return 操作码
     */
    @Override
    public int deleteGoodsCategory(Integer id) {
        return goodsCategoryDao.deleteGoodsCategory(id);
    }

    /**
     * 更新商品分类信息
     *
     * @param goodsCategoryPo
     * @return 操作码
     */
    @Override
    public GoodsCategoryPo updateGoodsCategory(GoodsCategoryPo goodsCategoryPo) {
        return goodsCategoryDao.updateGoodsCategory(goodsCategoryPo);
    }


    /**
     * 更改子分类在父分类下的位置
     *
     * @param goodsCategoryPo
     * @return 更新后的分类
     */
    @Override
    public GoodsCategoryPo updateGoodsCategoryPid(GoodsCategoryPo goodsCategoryPo) {
        return goodsCategoryDao.updateGoodsCategoryPid(goodsCategoryPo);
    }

    /**
     * 查看商标分类列表
     * @param page
     * @param limit
     * @return 商品分类列表
     */
    @Override
    public List<GoodsCategoryPo> findGoodsCategoryList(Integer page,Integer limit) {
        List<GoodsCategoryPo> goodsCategoryList=goodsCategoryDao.findGoodsCategoryList();
        return divideByPage(goodsCategoryList,page,limit);
    }

    /**
     * 查看商品一级目录列表
     *
     * @return 商品分类列表
     */
    @Override
    public List<GoodsCategoryPo> findFirstLevelGoodsCategoryList() {
        return goodsCategoryDao.findFirstLevelGoodsCategoryList();
    }

    /**
     * 查看商品二级目录列表
     *
     * @return 商品分类列表
     */
    @Override
    public List<GoodsCategoryPo> findSecondLevelGoodsCategoryList() {
        return goodsCategoryDao.findSecondLevelGoodsCategoryList();
    }

    /**
     * 查看某一级目录下的二级目录列表
     *
     * @param id
     * @return 商品分类列表
     */
    @Override
    public List<GoodsCategoryPo> findSecondLevelGoodsCategoryListByPid(Integer id) {
        return goodsCategoryDao.findSecondLevelGoodsCategoryListByPid(id);
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
