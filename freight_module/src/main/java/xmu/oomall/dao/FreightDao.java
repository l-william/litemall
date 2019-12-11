/**
 * @author xingzhou
 * @date 2019/12/8 22:34
 * @version 1.0
 */

package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.DefaultFreight;
import xmu.oomall.domain.DefaultPieceFreight;
import xmu.oomall.mapper.FreightMapper;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lianh
 * @date 2019/12/09
 */
@Repository
public class FreightDao {

    @Autowired (required = false)
    private FreightMapper freightMapper;

    /**
     * 根据ID查找默认重量运费模板
     *
     * @param id
     * @return 基于重量的默认运费模板
     */
    public DefaultFreight findDefaultFreightById(Integer id) {
        return freightMapper.findDefaultFreightById(id);
    }

    /**
     * 管理员查看当前定义的所有默认重量运费模板
     *
     * @return 重量模板列表
     */
    public List<DefaultFreight> findDefaultFreightList() {
        return freightMapper.findDefaultFreightList();
    }

    /**
     * 添加默认重量运费模板
     *
     * @param defaultFreight
     * @return 操作状态码
     */
    public int addDefaultFreight(DefaultFreight defaultFreight) {
        defaultFreight.setGmtCreate(LocalDateTime.now());
        defaultFreight.setBeDeleted(false);

        return freightMapper.addDefaultFreight(defaultFreight);
    }

    /**
     * 更新默认重量运费模板
     *
     * @param defaultFreight
     * @return 操作状态码
     */
    public int updateDefaultFreight(DefaultFreight defaultFreight) {
        return freightMapper.updateDefaultFreight(defaultFreight);
    }

    /**
     * 删除默认重量运费模板
     *
     * @param id
     * @return 操作状态码
     */
    public int deleteDefaultFreightById(Integer id) {
        return freightMapper.deleteDefaultFreightById(id);
    }

    /**
     * 根据ID查找默认件数运费模板
     *
     * @param id
     * @return 基于件数的默认运费模板
     */
    public DefaultPieceFreight findDefaultPieceFreightById(Integer id) {
        return freightMapper.findDefaultPieceFreightById(id);
    }

    /**
     * 管理员查看当前定义的所有默认件数运费模板
     *
     * @return 基于重量的默认运费模板
     */
    public  List<DefaultPieceFreight> findDefaultPieceFreightList() {
        return  freightMapper.findDefaultPieceFreightList();
    }

    /**
     * 添加默认件数运费模板
     *
     * @param defaultPieceFreight
     * @return 操作状态码
     */
    public int addDefaultPieceFreight(DefaultPieceFreight defaultPieceFreight) {
        defaultPieceFreight.setGmtCreate(LocalDateTime.now());
        defaultPieceFreight.setBeDeleted(false);

        return freightMapper.addDefaultPieceFreight(defaultPieceFreight);
    }

    /**
     * 更新默认件数运费模板
     *
     * @param defaultPieceFreight
     * @return 操作状态码
     */
    public int updateDefaultPieceFreight(DefaultPieceFreight defaultPieceFreight) {
        return freightMapper.updateDefaultPieceFreight(defaultPieceFreight);
    }

    /**
     * 删除默认件数运费模板
     *
     * @param id
     * @return 操作状态码
     */
    public int deleteDefaultPieceFreightById(Integer id) {
        return freightMapper.deleteDefaultPieceFreightById(id);
    }
}
