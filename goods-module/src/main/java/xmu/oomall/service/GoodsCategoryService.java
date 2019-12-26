/**
 * @author xingzhou
 * @date 2019/12/8 11:04
 * @version 1.0
 */
package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.GoodsCategory;
import xmu.oomall.domain.GoodsCategoryPo;

import java.util.List;

@Service
public interface GoodsCategoryService {
    /**
     * 寻找分类
     *
     * @param id
     * @return 返回查找到的分类
     */
    GoodsCategoryPo findGoodsCategoryById(Integer id);

    /**
     * 创建分类
     *
     * @param goodsCategoryPo
     * @return 创建成功与否
     */
    GoodsCategoryPo addGoodsCategory(GoodsCategoryPo goodsCategoryPo);

    /**
     * 删除分类
     *
     * @param id
     * @return 删除成功与否
     */
    int deleteGoodsCategory(Integer id);

    /**
     * 修改分类
     *
     * @param goodsCategoryPo
     * @return 修改成功与否
     */
    GoodsCategoryPo updateGoodsCategory(GoodsCategoryPo goodsCategoryPo);

    /**
     * 修改分类
     *
     * @param goodsCategoryPo
     * @return 修改成功与否
     */
    GoodsCategoryPo updateGoodsCategoryPid(GoodsCategoryPo goodsCategoryPo);

    /**
     * 寻找分类
     * @param limit
     * @param page
     * @return 全部分类的列表
     */
    List<GoodsCategoryPo> findGoodsCategoryList(Integer page,Integer limit);

    /**
     * 查找分类
     *
     * @return 全部一级分类的列表
     */
    List<GoodsCategoryPo> findFirstLevelGoodsCategoryList();

    /**
     * 寻找二级分类
     *
     * @return 全部二级分类列表
     */
    List<GoodsCategoryPo> findSecondLevelGoodsCategoryList();

    /**
     * 寻找分类
     *
     * @param id
     * @return 某个一级目录下的全部二级目录
     */
    List<GoodsCategoryPo> findSecondLevelGoodsCategoryListByPid(Integer id);
}
