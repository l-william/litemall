package xmu.oomall.mapper;

import org.apache.ibatis.annotations.Mapper;
import xmu.oomall.domain.FootprintItem;
import xmu.oomall.domain.FootprintItemPo;

import java.util.List;

/**
 * @author CFH 12/23
 */
@Mapper
public interface FootprintItemMapper {

    /**
     * 用户浏览自己的足迹
     *
     * @param userId 用户ID
     * @return 用户的足迹列表
     */
    List<FootprintItem> userFindFootprintList(Integer userId);

    /**
     * 管理员根据条件查询足迹列表
     *
     * @param userId 用户ID
     * @param goodsId 商品ID
     * @return 足迹列表
     */
    List<FootprintItem> adminFindFootprintList(Integer userId, Integer goodsId);

    /**
     * 添加足迹
     *
     * @param footprintItemPo 待添加的足迹信息
     * @return 操作码
     */
    int addFootprint(FootprintItemPo footprintItemPo);

}
