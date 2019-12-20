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
import java.time.ZoneId;
import java.util.List;

/**
 * @author linlianhui
 * @date 2019/12/12
 */
@Repository
public class AdDao {

    @Autowired(required = false)
    private AdMapper adMapper;

    /**
     * 通过id查看广告的详细信息
     *
     * @param id
     * @return 广告
     */
    public Ad findAdById(Integer id)
    {
        return adMapper.findAdById(id);
    }

    /**
     * 管理员查看当前所有广告
     *
     * @return 广告列表
     */
    public List<Ad> findAdList(){
        return adMapper.findAdList();
    }

    /**
     * 管理员通过名字或内容搜索广告
     *
     * @param name
     * @param content
     * @return 包含关键词的广告列表
     */
    public List<Ad> findAdListByNameAndContent(String name, String content){
        return adMapper.findAdListByNameAndContent(name, content);
    }

    /**
     * 管理员添加广告
     *
     * @param ad
     * @return 状态操作码
     */
    public int addAd(Ad ad)
    {
        //ZoneId.of("UTC-8")
        ad.setGmtCreate(LocalDateTime.now());
        ad.setBeDeleted(false);
        ad.setGmtModified(LocalDateTime.now());
        return adMapper.addAd(ad);
    }

    /**
     * 管理员更新广告
     *
     * @param ad
     * @return 状态操作码
     */
    public int updateAd(Ad ad)
    {
        Ad ad1=adMapper.findAdById(ad.getId());
        if(ad1!=null)
        {
            ad.setGmtCreate(ad1.getGmtCreate());
            ad.setBeDeleted(ad1.getBeDeleted());
        }
        ad.setGmtModified(LocalDateTime.now());
        return adMapper.updateAd(ad);
    }

    /**
     * 管理员删除广告
     *
     * @param id
     * @return 状态操作码
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
