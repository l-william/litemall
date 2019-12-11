/**
 * @author xingzhou
 * @date 2019/12/8 11:04
 * @version 1.0
 */
package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.GoodsCategory;

import java.util.List;

@Service
public interface GoodsCategoryService {
    /**
     * @param id
     * @return 返回查找到的分类
     */
    GoodsCategory findGoodsCategoryById(Integer id);

    /**
     * @param goodsCategory
     * @return 创建成功与否
     */
    public int CreateGoodsCategory(GoodsCategory goodsCategory);

    /**
     * @param id
     * @return 删除成功与否
     */
    public int deleteGoodsCategory(Integer id);

    /**
     * @param goodsCategory
     * @return 修改成功与否
     */
    public int updateGoodsCategory(GoodsCategory goodsCategory);

    /**
     * @return 全部分类的列表
     */
    public List<GoodsCategory> findGoodsCategoryList();

    /**
     * @return 全部一级分类的列表
     */
    public List<GoodsCategory> findOneLevelGoodsCategoryList();

    /**
     * @return 全部二级分类列表
     */
    public List<GoodsCategory> findSecondLevelGoodsCategoryList();

    /**
     * @param id
     * @return 某个一级目录下的全部二级目录
     */
    public List<GoodsCategory> findSecondLevelGoodsCategoryListById(Integer id);
}
