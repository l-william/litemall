/**
 * @author xingzhou
 * @date 2019/12/8 22:34
 * @version 1.0
 */

package xmu.oomall.dao;

import com.mysql.cj.x.protobuf.MysqlxResultset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.*;
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
    public List<DefaultFreightPo> findDefaultFreightList() {
        return freightMapper.findDefaultFreightList();
    }

    /**
     * 添加默认重量运费模板
     *
     * @param defaultFreightPo
     * @return 操作状态码
     */
    public int addDefaultFreight(DefaultFreightPo defaultFreightPo) {
        defaultFreightPo.setGmtCreate(LocalDateTime.now());
        defaultFreightPo.setGmtModified(LocalDateTime.now());
        defaultFreightPo.setBeDeleted(false);

        return freightMapper.addDefaultFreight(defaultFreightPo);
    }

    /**
     * 更新默认重量运费模板
     *
     * @param defaultFreightPo
     * @return 操作状态码
     */
    public int updateDefaultFreight(DefaultFreightPo defaultFreightPo) {
        if(freightMapper.findDefaultFreightById(defaultFreightPo.getId())!=null)
        {
            defaultFreightPo.setGmtCreate(freightMapper.findDefaultFreightById(defaultFreightPo.getId()).getGmtCreate());
            defaultFreightPo.setBeDeleted(freightMapper.findDefaultFreightById(defaultFreightPo.getId()).getBeDeleted());
        }
        defaultFreightPo.setGmtModified(LocalDateTime.now());
        return freightMapper.updateDefaultFreight(defaultFreightPo);
    }

    /**
     * 删除默认重量运费模板
     *
     * @param id
     * @return 操作状态码
     */
    public int deleteDefaultFreightById(Integer id) {
        DefaultFreight defaultFreight=freightMapper.findDefaultFreightById(id);
        if(defaultFreight!=null)
        {
            defaultFreight.setGmtModified(LocalDateTime.now());
            freightMapper.updateDefaultFreight(defaultFreight);
        }
        return freightMapper.deleteDefaultFreightById(id);
    }

    /**
     * 根据ID查找默认件数运费模板
     *
     * @param id
     * @return 基于件数的默认运费模板
     */
    public DefaultPieceFreightPo findDefaultPieceFreightById(Integer id) {
        return freightMapper.findDefaultPieceFreightById(id);
    }

    /**
     * 管理员查看当前定义的所有默认件数运费模板
     *
     * @return 基于重量的默认运费模板
     */
    public  List<DefaultPieceFreightPo> findDefaultPieceFreightList() {
        return  freightMapper.findDefaultPieceFreightList();
    }

    /**
     * 添加默认件数运费模板
     *
     * @param defaultPieceFreightPo
     * @return 操作状态码
     */
    public int addDefaultPieceFreight(DefaultPieceFreightPo defaultPieceFreightPo) {
        defaultPieceFreightPo.setGmtCreate(LocalDateTime.now());
        defaultPieceFreightPo.setGmtModified(LocalDateTime.now());
        defaultPieceFreightPo.setBeDeleted(false);

        return freightMapper.addDefaultPieceFreight(defaultPieceFreightPo);
    }

    /**
     * 更新默认件数运费模板
     *
     * @param defaultPieceFreightPo
     * @return 操作状态码
     */
    public int updateDefaultPieceFreight(DefaultPieceFreightPo defaultPieceFreightPo) {
        if(freightMapper.findDefaultPieceFreightById(defaultPieceFreightPo.getId())!=null)
        {
            defaultPieceFreightPo.setGmtCreate(freightMapper.findDefaultPieceFreightById(defaultPieceFreightPo.getId()).getGmtCreate());
            defaultPieceFreightPo.setBeDeleted(freightMapper.findDefaultPieceFreightById(defaultPieceFreightPo.getId()).getBeDeleted());
        }
        defaultPieceFreightPo.setGmtModified(LocalDateTime.now());
        return freightMapper.updateDefaultPieceFreight(defaultPieceFreightPo);
    }

    /**
     * 删除默认件数运费模板
     *
     * @param id
     * @return 操作状态码
     */
    public int deleteDefaultPieceFreightById(Integer id) {
        DefaultPieceFreightPo defaultPieceFreightPo=freightMapper.findDefaultPieceFreightById(id);
        if(defaultPieceFreightPo!=null)
        {
            defaultPieceFreightPo.setGmtModified(LocalDateTime.now());
            freightMapper.updateDefaultPieceFreight(defaultPieceFreightPo);
        }
        return freightMapper.deleteDefaultPieceFreightById(id);
    }

    /**
     * 查看特殊运费列表
     *
     * @return 特殊运费模板列表
     */
    public List<SpecialFreight> findSpecialFreightList()
    {
        return freightMapper.findSpecialFreightList();
    }

    /**
     * 通过id查看特殊运费模板
     *
     * @param id
     * @return 特殊运费模板
     */
    public SpecialFreight findSpecialFreightById(Integer id)
    {
        return freightMapper.findSpecialFreightById(id);
    }

    /**
     * 增加特殊运费模板
     *
     * @param specialFreight
     * @return 操作码
     */
    public int addSpecialFreight(SpecialFreight specialFreight)
    {
        specialFreight.setBeDeleted(false);
        specialFreight.setGmtCreate(LocalDateTime.now());
        specialFreight.setGmtModified(LocalDateTime.now());
        return freightMapper.addSpecialFreight(specialFreight);
    }

    /**
     * 删除特殊运费模板
     *
     * @param id
     * @return 操作码
     */
    public int deleteSpecialFreight(Integer id) {
        SpecialFreight specialFreight=freightMapper.findSpecialFreightById(id);
        if(specialFreight!=null)
        {
            specialFreight.setGmtModified(LocalDateTime.now());
            freightMapper.updateSpecialFreight(specialFreight);
        }
        return freightMapper.deleteSpecialFreight(id);
    }

    /**
     * 更新特殊运费模板
     *
     * @param specialFreight
     * @return 操作码
     */
    public int updateSpecialFreight(SpecialFreight specialFreight) {
        if(freightMapper.findSpecialFreightById(specialFreight.getId())!=null)
        {
            specialFreight.setGmtCreate(freightMapper.findSpecialFreightById(specialFreight.getId()).getGmtCreate());
            specialFreight.setBeDeleted(freightMapper.findSpecialFreightById(specialFreight.getId()).getBeDeleted());
        }
        specialFreight.setGmtModified(LocalDateTime.now());
        return freightMapper.updateSpecialFreight(specialFreight);
    }

    /**
     * 寻找地址信息对应的id码
     *
     * @param info
     * @return id
     */
    public List<Integer> findIdFromRegion(String info)
    {
        return freightMapper.findIdFromRegion(info);
    }

    /**
     * 寻找地址信息对应的id码
     *
     * @param info
     * @param idlist
     * @return
     */
    public Integer findIdFromRegion1(String info,List<Integer> idlist)
    {
        for(Integer id:idlist)
        {
            if(freightMapper.findIdFromRegion1(info,id)!=null) {
                return freightMapper.findIdFromRegion1(info,id);
            }
        }
        return null;
    }
}
