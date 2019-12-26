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
     * 用户浏览自己的足迹
     *
     * @param userId 用户ID
     * @param page 分页页号
     * @param limit 分页大小
     * @return 用户的足迹列表
     */
    List<FootprintItem> userFindFootprintList(Integer userId,Integer page,Integer limit);

    /**
     * 管理员根据条件查询足迹列表
     *
     * @param userId 用户ID
     * @param goodsId 商品ID
     * @param page 分页页号
     * @param limit 分页大小
     * @return 足迹列表
     */
    List<FootprintItem> adminFindFootprintList(Integer userId,Integer goodsId,Integer page,Integer limit);

    /**
     * 添加足迹
     *
     * @param footprintItemPo 待添加的足迹信息
     * @return 新增的足迹
     */
    FootprintItemPo addFootprint(FootprintItemPo footprintItemPo);
}
