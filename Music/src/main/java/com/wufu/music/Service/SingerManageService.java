package com.wufu.music.Service;

import com.wufu.music.Domain.Singer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wufu
 * @date 2021/1/19 13:56
 */
public interface SingerManageService {
    /**
     * 插入歌手信息
     * @param name
     * @param sex
     * @param age
     * @param address
     * @param intro
     * @return 成功或者失败
     */
    boolean insertSingerInfo(String name,int sex,int age,String address,String intro);

    /**
     *  更新歌手信息
     * @param singerName
     * @param singerSex
     * @param singerAge
     * @param singerAddress
     * @param singerIntroduction
     * @param singerId
     * @return
     */
    boolean updateSingerInfo(String singerName,int singerSex,
                         int singerAge,String singerAddress,
                         String singerIntroduction);

    /**
     * 删除歌手
     * @param singerId
     * @return
     */
    boolean deleteSingerInfo(String singerName);
    /**
     * 获取所有歌手
     * @return 歌手信息
     */
    List<Singer> getAllSinger();

    /**
     * 获取所有男歌手或者女歌手
     * @param singerSex
     * @return
     */

    List<Singer> getSingerInfoBySex(int singerSex);

    /**
     * 用歌手姓名模糊搜索
     * @param singerName
     * @return
     */
    List<Singer> getSingerByName(String singerName);

}
