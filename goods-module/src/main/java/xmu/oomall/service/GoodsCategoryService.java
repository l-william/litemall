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
     * @param id
     * @return 返回查找到的分类
     */
    GoodsCategoryPo findGoodsCategoryById(Integer id);

    /**
     * @param goodsCategoryPo
     * @return 创建成功与否
     */
    GoodsCategoryPo addGoodsCategory(GoodsCategoryPo goodsCategoryPo);

    /**
     * @param id
     * @return 删除成功与否
     */
    int deleteGoodsCategory(Integer id);

    /**
     * @param goodsCategoryPo
     * @return 修改成功与否
     */
    GoodsCategoryPo updateGoodsCategory(GoodsCategoryPo goodsCategoryPo);

    /**
     * @param goodsCategoryPo
     * @return 修改成功与否
     */
    GoodsCategoryPo updateGoodsCategoryPid(GoodsCategoryPo goodsCategoryPo);

    /**
     * @return 全部分类的列表
     */
    List<GoodsCategoryPo> findGoodsCategoryList(Integer page,Integer limit);

    /**
     * @return 全部一级分类的列表
     */
    List<GoodsCategoryPo> findFirstLevelGoodsCategoryList();

    /**
     * @return 全部二级分类列表
     */
    List<GoodsCategoryPo> findSecondLevelGoodsCategoryList();

    /**
     * @param id
     * @return 某个一级目录下的全部二级目录
     */
    List<GoodsCategoryPo> findSecondLevelGoodsCategoryListByPid(Integer id);
}
