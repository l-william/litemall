package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.FootprintItem;
import xmu.oomall.domain.FootprintItemPo;

import java.util.List;

/**
 * @author CFH 12/23
 */
@Service
public interface FootprintItemService {

    /**
     * @param userId
     * @param page
     * @param limit
     * @return
     */
    List<FootprintItem> userFindFootprintList(Integer userId,Integer page,Integer limit);

    /**
     * @param userId
     * @param goodsId
     * @param page
     * @param limit
     * @return
     */
    List<FootprintItem> adminFindFootprintList(Integer userId,Integer goodsId,Integer page,Integer limit);

    /**
     * @param footprintItemPo
     * @return
     */
    FootprintItemPo addFootprint(FootprintItemPo footprintItemPo);
}
