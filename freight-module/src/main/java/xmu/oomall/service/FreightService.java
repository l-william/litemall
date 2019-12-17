/**
 * @author xingzhou
 * @date 2019/12/8 22:31
 * @version 1.0
 */
package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.DefaultFreight;
import xmu.oomall.domain.DefaultPieceFreight;
import xmu.oomall.domain.Order;
import xmu.oomall.domain.SpecialFreight;

import java.awt.peer.ScrollbarPeer;
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
    public List<DefaultFreight> findDefaultFreightsList(Integer page,Integer limit);

    /**
     * 查找默认运费比率表
     *
     * @return 返回默认运费比率表
     */
    public List<DefaultPieceFreight> findDefaultPieceFreightList();

    /**
     * 添加默认运费模板
     *
     * @param defaultFreight
     * @return 操作成功与否
     */
    public int addDefaultFreights(DefaultFreight defaultFreight);

    /**
     * 添加默认运费比率
     *
     * @param defaultPieceFreight
     * @return 操作成功与否
     */
    public int addDefaultPieceFreights(DefaultPieceFreight defaultPieceFreight);

    /**
     * 删除默认运费模板
     *
     * @param id
     * @return 操作成功与否
     */
    public int deleteDefaultFreight(String id);

    /**
     * 删除默认运费比率
     *
     * @param id
     * @return 操作成功与否
     */
    public int deleteDefaultPieceFreight(String id);


    /**
     * 更新默认运费比率
     *
     * @param defaultPieceFreight
     * @return 操作成功与否
     */
    public int updateDefaultPieceFreight(DefaultPieceFreight defaultPieceFreight);

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
    public DefaultPieceFreight findDefaultPieceFreightById(Integer id);

    public List<SpecialFreight> findSpecialFreightList();

    public int addSpecialFreight(SpecialFreight specialFreight);

    public int deleteSpecialFreight(Integer id);

    public int updateSpecialFreight(SpecialFreight specialFreight);


}
