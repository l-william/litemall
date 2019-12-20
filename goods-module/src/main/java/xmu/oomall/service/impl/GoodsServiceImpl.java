/**
 * @author xingzhou
 * @date 2019/12/7 23:48
 * @version 1.0
 */

package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.GoodsDao;
import xmu.oomall.dao.ProductDao;
import xmu.oomall.domain.Goods;
import xmu.oomall.domain.GoodsPo;
import xmu.oomall.service.GoodsService;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private ProductDao productDao;

    /**
     * 管理员查看商品列表
     *
     * @param goodsSn
     * @param name
     * @param page
     * @param limit
     * @return 商品列表
     */
    @Override
    public List<GoodsPo> adminFindGoodsList(String goodsSn, String name, Integer page, Integer limit) {
        List<GoodsPo> goodsList=goodsDao.adminFindGoodsList(goodsSn,name);
        return divideByPage(goodsList,page,limit);
    }

    /**
     * 用户查看商品列表
     *
     * @param name
     * @param page
     * @param limit
     * @return 商品列表
     */
    @Override
    public List<GoodsPo> userFindGoodsList(String name, Integer page, Integer limit) {
        List<GoodsPo> goodsList=goodsDao.userFindGoodsList(name);
        return divideByPage(goodsList,page,limit);
    }

    /**
     * 查找品牌下的所有商品
     *
     * @param brandId
     * @return 商品列表
     */
    @Override
    public List<GoodsPo> findGoodsListByBrandId(Integer brandId) {
        return goodsDao.findGoodsListByBrandId(brandId);
    }

    @Override
    public List<GoodsPo> findGoodsListByCategoryId(Integer categoryId) {
        return goodsDao.findGoodsListByCategoryId(categoryId);
    }

    /**
     * 管理员通过id查找商品
     *
     * @param id
     * @return 商品
     */
    @Override
    public GoodsPo adminFindGoodsById(Integer id) {
        return goodsDao.adminFindGoodsById(id);
    }

    /**
     * 用户通过id查找商品
     *
     * @param id
     * @return 商品
     */
    @Override
    public GoodsPo userFindGoodsById(Integer id) {
        return goodsDao.userFindGoodsById(id);
    }

    /**
     * 更新商品
     *
     * @param goodsPo
     * @return 操作码
     */
    @Override
    public GoodsPo updateGoods(GoodsPo goodsPo) {
        return goodsDao.updateGoods(goodsPo);
    }

    /**
     * 删除商品
     *
     * @param id
     * @return  操作码
     */
    @Override
    public int deleteGoods(Integer id) {
        int ret = goodsDao.deleteGoods(id);
        if(ret!=0){
            productDao.deleteProductByGoodsId(id);
        }
        return ret;
    }

    /**
     * 添加商品
     *
     * @param goodsPo
     * @return 操作码
     */
    @Override
    public GoodsPo addGoods(GoodsPo goodsPo) {
        return goodsDao.addGoods(goodsPo);
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
