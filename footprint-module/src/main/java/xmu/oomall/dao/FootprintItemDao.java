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

    public List<FootprintItem> userFindFootprintList(Integer userId){
        return footprintItemMapper.userFindFootprintList(userId);
    }

    public List<FootprintItem> adminFindFootprintList(Integer userId,Integer goodsId){
        return footprintItemMapper.adminFindFootprintList(userId,goodsId);
    }

    public FootprintItemPo addFootprint(FootprintItemPo footprintItemPo){
        footprintItemPo.setGmtCreate(LocalDateTime.now());
        int ret=footprintItemMapper.addFootprint(footprintItemPo);
        if(ret==0){
            return null;
        }
        return footprintItemPo;
    }
}
