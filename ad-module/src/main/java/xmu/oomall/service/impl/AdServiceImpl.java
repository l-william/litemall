/**
 * @author xingzhou
 * @date 2019/12/7 16:27
 * @version 1.0
 */

package xmu.oomall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmu.oomall.dao.AdDao;
import xmu.oomall.domain.Ad;
import xmu.oomall.service.AdService;
import com.github.pagehelper.PageHelper;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private AdDao adDao;

    @Override
    public Ad findAdById(Integer id) {
        return adDao.findAdById(id);
    }

    @Override
    public int createAd(Ad ad) {
        return adDao.addAd(ad);
    }

    @Override
    public boolean updateAd(Ad ad) {
        return adDao.updateAd(ad) == 1;
    }


    @Override
    public List<Ad> adminFindAdList(Integer page,Integer limit,String name, String content) {
        PageHelper.startPage(page,limit);
        return adDao.findAdListByNameAndContent(name, content);
    }


    @Override
    public int deleteAd(Integer id) {
        return adDao.deleteAdById(id);
    }

    @Override
    public List<Ad> userFindAd() {
        LocalDateTime now=LocalDateTime.now();
        List<Ad> adList=adDao.findAdList();
        List<Ad> adList1=adDao.findAdList();
        Iterator<Ad> iterator = adList.iterator();
        Iterator<Ad> iterator1 =adList1.iterator();
        while (iterator.hasNext()) {
            Ad ad = iterator.next();
            boolean visible=!ad.getBeDefault()&&!ad.getBeDeleted()&&ad.getBeEnabled()&&ad.getStartTime().isBefore(now)&&ad.getEndTime().isAfter(now);
            if (!visible) {
                iterator.remove();
            }
        }
        if(adList.isEmpty())
        {
            while (iterator1.hasNext()){
                Ad ad = iterator.next();
                if(!ad.getBeDefault())
                {
                    iterator1.remove();
                }
            }
        return adList1;
    }
        else {
            return adList;
        }
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
        return null;
    }
}
