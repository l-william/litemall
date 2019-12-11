/**
 * @author xingzhou
 * @date 2019/12/6 14:55
 * @version 1.0
 */

package xmu.oomall.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import xmu.oomall.domain.Ad;
import xmu.oomall.mapper.AdMapper;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class AdDao {

    @Autowired(required = false)
    private AdMapper adMapper;

    public Ad findAdById(Integer id)
    {
        return adMapper.findAdById(id);
    }
    public List<Ad> findAdList(){
        return adMapper.findAdList();
    }

    public List<Ad> findAdListByNameAndContent(String name, String content){
        return adMapper.findAdListByNameAndContent(name, content);
    }

    public int addAd(Ad ad)
    {
        ad.setGmtCreate(LocalDateTime.now());
        ad.setGmtModified(LocalDateTime.now());
        ad.setBeDeleted(false);
        return adMapper.addAd(ad);
    }

    public int updateAd(Ad ad)
    {
        if(adMapper.findAdById(ad.getId())!=null)
        {
            ad.setGmtCreate(adMapper.findAdById(ad.getId()).getGmtCreate());
        }
        ad.setGmtModified(LocalDateTime.now());
        return adMapper.updateAd(ad);
    }

    public int deleteAdById(Integer id)
    {
        Ad ad=adMapper.findAdById(id);
        if(ad!=null)
        {
            ad.setGmtModified(LocalDateTime.now());
            adMapper.updateAd(ad);
        }
        return adMapper.deleteAdById(id);
    }
}
