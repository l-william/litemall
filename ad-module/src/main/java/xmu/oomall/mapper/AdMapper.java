package xmu.oomall.mapper;


import org.apache.ibatis.annotations.Mapper;
import xmu.oomall.domain.Ad;

import java.util.List;

/**
 * @author lianh
 */
@Mapper
public interface AdMapper {
    /**
     * 根据广告ID查找广告
     *
     * @param id
     * @return Ad
     */
    Ad findAdById(Integer id);

    /**
     * 查询所有广告
     *
     * @return 所有广告列表
     */
    List<Ad> findAdList();

    /**
     * 根据广告ID和广告名称模糊查询广告
     *
     * @param name
     * @param content
     * @return 包含关键字的广告列表
     */
    List<Ad> findAdListByNameAndContent(String name, String content);

    /**
     * 添加广告
     *
     * @param ad
     * @return status
     */
    int addAd(Ad ad);

    /**
     * 根据广告ID删除广告
     *
     * @param id
     * @return status
     */
    int deleteAdById(Integer id);

    /**
     * 更新广告
     *
     * @param ad
     * @return status
     */
    int updateAd(Ad ad);

}