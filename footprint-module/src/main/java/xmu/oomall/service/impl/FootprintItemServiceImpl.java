package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.FootprintItemDao;
import xmu.oomall.domain.FootprintItem;
import xmu.oomall.domain.FootprintItemPo;
import xmu.oomall.service.FootprintItemService;

import java.util.List;


/**
 * @author CFH 12/23
 */
@Service
public class FootprintItemServiceImpl implements FootprintItemService {
    @Autowired
    private FootprintItemDao footprintItemDao;

    @Override
    public List<FootprintItem> userFindFootprintList(Integer userId, Integer page, Integer limit) {
        List<FootprintItem> footprintList=footprintItemDao.userFindFootprintList(userId);
        return divideByPage(footprintList,page,limit);
    }

    @Override
    public List<FootprintItem> adminFindFootprintList(Integer userId, Integer goodsId, Integer page, Integer limit) {
        List<FootprintItem> footprintList=footprintItemDao.adminFindFootprintList(userId,goodsId);
        return divideByPage(footprintList,page,limit);
    }

    @Override
    public FootprintItemPo addFootprint(FootprintItemPo footprintItemPo) {
        return footprintItemDao.addFootprint(footprintItemPo);
    }

    /**
     * 分页功能
     *
     * @param list 父列表
     * @param page 分页页数
     * @param limit 分页大小
     * @param <T> 列表元素类型
     * @return 子列表
     */
    private <T> List<T> divideByPage(List<T> list,Integer page,Integer limit){
        int maxPages=(list.size()-1)/limit+1;
        if(page<maxPages){
            return list.subList((page-1)*limit,page*limit);
        }
        if(page==maxPages){
            return list.subList((page-1)*limit,list.size());
        }
        //page>maxPages
        return list.subList(0,0);
    }

}
