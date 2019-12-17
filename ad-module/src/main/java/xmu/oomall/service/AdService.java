/**
 * @author xingzhou
 * @date 2019/12/7 16:25
 * @version 1.0
 */
package xmu.oomall.service;

import org.springframework.stereotype.Service;
import xmu.oomall.domain.Ad;

import java.util.List;

@Service
public interface AdService {
    /**
     * 通过id寻找广告
     *
     * @param id
     * @return Ad
     */
    Ad findAdById(Integer id);

    /**
     * 管理员添加广告
     *
     * @param ad
     * @return 是否成功操作
     */
    public int createAd(Ad ad);

    /**
     * 管理员更新广告
     *
     * @param ad 广告
     * @return 更新是否成功
     */
    boolean updateAd(Ad ad);
    /**
     * 管理员查询广告列表
     *
     * @param name 广告名称
     * @param content 广告内容
     * @return 包含相应关键信息的广告列表
     */
    public List<Ad> adminFindAdList(Integer page,Integer limit,String name, String content);

    /**
     * 管理员删除广告
     *
     * @param id 广告ID
     * @return 操是否成功操作
     */

    public int deleteAd(Integer id);

    /**
     * 用户查询广告列表
     *
     * @return 包含相应关键信息的广告列表
     */
    public List<Ad> userFindAd();
}
