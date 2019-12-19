/**
 * @author xingzhou
 * @date 2019/12/8 10:24
 * @version 1.0
 */

package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.GoodsCategory;
import xmu.oomall.domain.GoodsCategoryPo;
import xmu.oomall.mapper.GoodsCategoryMapper;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 商品分类的dao层
 */
@Repository
public class GoodsCategoryDao {
    @Autowired(required = false)
    private GoodsCategoryMapper goodsCategoryMapper;

    /**
     * 通过ID查找商品分类
     *
     * @param id
     * @return 商品分类
     */
    public GoodsCategoryPo findGoodsCategoryById(Integer id)
    {
        return goodsCategoryMapper.findGoodsCategoryById(id);
    }

    /**
     * 添加商品分类
     *
     * @param goodsCategoryPo
     * @return 新增的商品分类
     */
    public GoodsCategoryPo addGoodsCategory(GoodsCategoryPo goodsCategoryPo)
    {
        goodsCategoryPo.setGmtCreate(LocalDateTime.now());
        goodsCategoryPo.setGmtModified(LocalDateTime.now());
        goodsCategoryPo.setBeDeleted(false);
        return goodsCategoryMapper.addGoodsCategory(goodsCategoryPo);
    }

    /**
     * 删除商品分类，通过id
     *
     * @param id
     * @return 操作成功与否
     */
    public int deleteGoodsCategory(Integer id)
    {
        GoodsCategoryPo goodsCategoryPo=goodsCategoryMapper.findGoodsCategoryById(id);
        if(goodsCategoryPo!=null)
        {
            goodsCategoryPo.setGmtModified(LocalDateTime.now());
            goodsCategoryMapper.updateGoodsCategory(goodsCategoryPo);
        }
        return goodsCategoryMapper.deleteGoodsCategory(id);
    }

    public int deleteGoodsCategoryByPid(Integer pid)
    {
        return goodsCategoryMapper.deleteGoodsCategoryByPid(pid);
    }

    /**
     * 更新商品分类
     *
     * @param goodsCategoryPo
     * @return 更新后的商品分类
     */
    public GoodsCategoryPo updateGoodsCategory(GoodsCategoryPo goodsCategoryPo)
    {
        if(goodsCategoryMapper.findGoodsCategoryById(goodsCategoryPo.getId())!=null) {
            goodsCategoryPo.setGmtCreate(goodsCategoryMapper.findGoodsCategoryById(goodsCategoryPo.getId()).getGmtCreate());
        }
        goodsCategoryPo.setGmtModified(LocalDateTime.now());
        return goodsCategoryMapper.updateGoodsCategory(goodsCategoryPo);
    }

    /**
     * 更新商品分类
     *
     * @param goodsCategoryPo
     * @return 更新后的商品分类
     */
    public GoodsCategoryPo updateGoodsCategoryPid(GoodsCategoryPo goodsCategoryPo)
    {
        if(goodsCategoryMapper.findGoodsCategoryById(goodsCategoryPo.getId())!=null) {
            goodsCategoryPo.setGmtCreate(goodsCategoryMapper.findGoodsCategoryById(goodsCategoryPo.getId()).getGmtCreate());
        }
        goodsCategoryPo.setGmtModified(LocalDateTime.now());
        return goodsCategoryMapper.updateGoodsCategoryPid(goodsCategoryPo);
    }

    /**
     * 查看商品分类列表
     *
     * @return 商品分类列表
     */
    public List<GoodsCategoryPo> findGoodsCategoryList()
    {
        return goodsCategoryMapper.findGoodsCategoryList();
    }

    /**
     * 查看商品一级目录列表
     *
     * @return 商品分类列表
     */
    public List<GoodsCategoryPo> findFirstLevelGoodsCategoryList()
    {
        return goodsCategoryMapper.findFirstLevelGoodsCategoryList();
    }

    /**
     * 查看商品二级目录列表
     *
     * @return 商品分类列表
     */
    public List<GoodsCategoryPo> findSecondLevelGoodsCategoryList()
    {
        return goodsCategoryMapper.findSecondLevelGoodsCategoryList();
    }

    /**
     * 查看某个一级目录下的二级目录列表
     *
     * @param id
     * @return 商品分类列表
     */
    public List<GoodsCategoryPo> findSecondLevelGoodsCategoryListByPid(Integer id)
    {
        return goodsCategoryMapper.findGoodsCategoryListByPid(id);
    }
}
