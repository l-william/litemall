package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.FootprintItem;
import xmu.oomall.domain.FootprintItemPo;
import xmu.oomall.mapper.FootprintItemMapper;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author CFH 12/23
 */
@Repository
public class FootprintItemDao {
    @Autowired(required = false)
    FootprintItemMapper footprintItemMapper;

    /**
     * 用户浏览自己的足迹
     *
     * @param userId 用户ID
     * @return 用户的足迹列表
     */
    public List<FootprintItem> userFindFootprintList(Integer userId){
        return footprintItemMapper.userFindFootprintList(userId);
    }

    /**
     * 管理员根据条件查询足迹列表
     *
     * @param userId 用户ID
     * @param goodsId 商品ID
     * @return 足迹列表
     */
    public List<FootprintItem> adminFindFootprintList(Integer userId,Integer goodsId){
        return footprintItemMapper.adminFindFootprintList(userId,goodsId);
    }

    /**
     * 添加足迹
     *
     * @param footprintItemPo 待添加的足迹信息
     * @return 新增的足迹
     */
    public FootprintItemPo addFootprint(FootprintItemPo footprintItemPo){
        footprintItemPo.setGmtCreate(LocalDateTime.now());
        int ret=footprintItemMapper.addFootprint(footprintItemPo);
        if(ret==0){
            return null;
        }
        return footprintItemPo;
    }
}
