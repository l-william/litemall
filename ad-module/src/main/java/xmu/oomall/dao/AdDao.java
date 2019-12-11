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

/**
 * @author xyt
 * @date 2019/12/11
 */
@Repository
public class AdDao {

    @Autowired(required = false)
    private AdMapper adMapper;

    /**
     * 通过Id查找
     *
     * @param id
     * @return Ad
     */
    public Ad findAdById(Integer id)
    {
        return adMapper.findAdById(id);
    }

    /**
     * 查找Ad
     *
     * 无参数
     * @return List<Ad>
     */
    public List<Ad> findAdList(){
        return adMapper.findAdList();
    }

    /**
     * 通过名字和内容查找
     *
     * @param name
     * @param content
     * @return List<Ad>
     */
    public List<Ad> findAdListByNameAndContent(String name, String content){
        return adMapper.findAdListByNameAndContent(name, content);
    }

    /**
     * 添加广告
     *
     * @param ad
     * @return 是否成功
     */
    public int addAd(Ad ad)
    {
        ad.setGmtCreate(LocalDateTime.now());
        ad.setGmtModified(LocalDateTime.now());
        ad.setBeDeleted(false);
        return adMapper.addAd(ad);
    }

    /**
     * 更新广告
     *
     * @param ad
     * @return 是否更新成功
     */
    public int updateAd(Ad ad)
    {
        if(adMapper.findAdById(ad.getId())!=null)
        {
            ad.setGmtCreate(adMapper.findAdById(ad.getId()).getGmtCreate());
        }
        ad.setGmtModified(LocalDateTime.now());
        return adMapper.updateAd(ad);
    }

    /**
     * 通过Id删除广告
     *
     * @param id
     * @return 是否删除成功
     */
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
