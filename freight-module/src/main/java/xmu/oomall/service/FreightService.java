/**
 * @author xingzhou
 * @date 2019/12/8 22:31
 * @version 1.0
 */
package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.*;

import java.util.List;

/**
 * 运费的service接口
 * @author Administrator
 */
@Service
public interface FreightService {
    /**
     * 查找默认运费模板
     * @param page
     * @param limit
     * @return 默认运费模板
     */
    public List<DefaultFreightPo> findDefaultFreightsList(Integer page,Integer limit);

    /**
     * 查找默认运费比率表
     *
     * @param page
     * @param limit
     * @return 返回默认运费比率表
     */
    public List<DefaultPieceFreightPo> findDefaultPieceFreightList(Integer page, Integer limit);

    /**
     * 添加默认运费模板
     *
     * @param defaultFreightPo
     * @return 操作成功与否
     */
    public int addDefaultFreights(DefaultFreightPo defaultFreightPo);

    /**
     * 添加默认运费比率
     *
     * @param defaultPieceFreightPo
     * @return 操作成功与否
     */
    public int addDefaultPieceFreights(DefaultPieceFreightPo defaultPieceFreightPo);

    /**
     * 删除默认运费模板
     *
     * @param id
     * @return 操作成功与否
     */
    public int deleteDefaultFreight(Integer id);

    /**
     * 删除默认运费比率
     *
     * @param id
     * @return 操作成功与否
     */
    public int deleteDefaultPieceFreight(Integer id);


    /**
     * 更新默认运费比率
     *
     * @param defaultPieceFreightPo
     * @return 操作成功与否
     */
    public int updateDefaultPieceFreight(DefaultPieceFreightPo defaultPieceFreightPo);

    /**
     * 更新模型运费模板
     *
     * @param defaultFreightPo
     * @return 操作成功与否
     */
    public int updateDefaultFreight(DefaultFreightPo defaultFreightPo);

    /**
     * 计算所需运费
     *
     * @param order
     * @return 操作成功与否
     */
    public double getFreight(Order order);

    /**
     * 通过id寻找默认运费模板
     *
     * @param id
     * @return 特定的默认运费模板
     */
    public DefaultFreight findDefaultFreightsById(Integer id);

    /**
     * 通过id寻找默认运费比率
     *
     * @param id
     * @return 特定默认运费比率
     */
    public DefaultPieceFreightPo findDefaultPieceFreightById(Integer id);

    /**
     * 查看所有特殊运费
     *
     * @param page
     * @param limit
     * @return 特殊运费模板列表
     */

    public List<SpecialFreight> findSpecialFreightList(Integer page,Integer limit);

    /**
     * 通过id查找特殊运费模板
     *
     * @param id
     * @return 特殊运费模板
     */
    public SpecialFreight findSpecialFreightById(Integer id);

    /**
     * 新增特殊运费模板
     *
     * @param specialFreight
     * @return 操作码
     */
    public int addSpecialFreight(SpecialFreight specialFreight);

    /**
     * 删除特殊运费模板
     *
     * @param id
     * @return 操作码
     */
    public int deleteSpecialFreight(Integer id);

    /**
     * 更新特殊运费模板
     *
     * @param specialFreight
     * @return 操作码
     */
    public int updateSpecialFreight(SpecialFreight specialFreight);


}
