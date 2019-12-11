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
    public List<Ad> adminFindAdList(String name, String content) {
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
        Iterator<Ad> iterator = adList.iterator();
        while (iterator.hasNext()) {
            Ad ad = iterator.next();
            boolean visible=!ad.getBeDeleted()&&ad.getBeEnable()&&ad.getStartTime().isBefore(now)&&ad.getEndTime().isAfter(now);
            if (!visible) {
                iterator.remove();
            }
        }
        return adList;
    }
}
