/**
 * @author xingzhou
 * @date 2019/12/8 22:31
 * @version 1.0
 */
package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.DefaultFreight;
import xmu.oomall.domain.DefaultPieceFreight;

import java.util.List;

/**
 * 运费的service接口
 */
@Service
public interface FreightService {
    /**
     * 查找默认运费模板
     *
     * @return 默认运费模板
     */
    public List<DefaultFreight> findDefaultFreightsList();

    /**
     * 查找特殊运费模板
     *
     * @return 返回特殊运费模板
     */
    public List<DefaultPieceFreight> findgetSpecialFreightList();

    /**
     * 添加默认运费模板
     *
     * @param defaultFreight
     * @return 操作成功与否
     */
    public int addDefaultFreights(DefaultFreight defaultFreight);

    /**
     * 添加特殊运费模板
     *
     * @param defaultPieceFreight
     * @return 操作成功与否
     */
    public int addSpecialFreight(DefaultPieceFreight defaultPieceFreight);

    /**
     * 删除默认运费模板
     *
     * @param id
     * @return 操作成功与否
     */
    public int deleteDefaultFreight(String id);

    /**
     * 删除特殊运费模板
     *
     * @param id
     * @return 操作成功与否
     */
    public int deleteSpecialFreight(String id);


    /**
     * 更新特殊运费模板
     *
     * @param defaultPieceFreight
     * @return 操作成功与否
     */
    public int updateSpecialFreight(DefaultPieceFreight defaultPieceFreight);

    /**
     * 更新模型运费模板
     *
     * @param defaultFreight
     * @return 操作成功与否
     */
    public int updateDefaultFreight(DefaultFreight defaultFreight);

    /**
     * 计算所需运费
     *
     * @param OrderId
     * @return 操作成功与否
     */
    public double getFreight(Integer OrderId);

    /**
     * 通过id寻找默认运费模板
     *
     * @param id
     * @return 特定的默认运费模板
     */
    public DefaultFreight findDefaultFreightsById(Integer id);

    /**
     * 通过id寻找特殊运费模板
     *
     * @param id
     * @return 特定的特殊运费模板
     */
    public DefaultPieceFreight findSpecialFreightById(Integer id);


}
