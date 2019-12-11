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

@Service
public interface FreightService {
    /**
     * @return 默认运费模板
     */
    public List<DefaultFreight> findDefaultFreightsList();

    /**
     * @return 返回特殊运费模板
     */
    public List<DefaultPieceFreight> findgetSpecialFreightList();

    /**
     * @param defaultFreight
     * @return 操作成功与否
     */
    public int addDefaultFreights(DefaultFreight defaultFreight);

    /**
     * @param defaultPieceFreight
     * @return 操作成功与否
     */
    public int addSpecialFreight(DefaultPieceFreight defaultPieceFreight);

    /**
     * @param id
     * @return 操作成功与否
     */
    public int deleteDefaultFreight(String id);

    /**
     * @param id
     * @return 操作成功与否
     */
    public int deleteSpecialFreight(String id);


    /**
     * @param defaultPieceFreight
     * @return 操作成功与否
     */
    public int updateSpecialFreight(DefaultPieceFreight defaultPieceFreight);

    /**
     * @param defaultFreight
     * @return 操作成功与否
     */
    public int updateDefaultFreight(DefaultFreight defaultFreight);

    /**
     * @param OrderId
     * @return 操作成功与否
     */
    public double getFreight(Integer OrderId);

    /**
     * @param id
     * @return 特定的默认运费模板
     */
    public DefaultFreight findDefaultFreightsById(Integer id);

    /**
     * @param id
     * @return 特定的特殊运费模板
     */
    public DefaultPieceFreight findSpecialFreightById(Integer id);


}
