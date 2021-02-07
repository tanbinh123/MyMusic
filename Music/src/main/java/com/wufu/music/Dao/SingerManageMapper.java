package com.wufu.music.Dao;

import com.wufu.music.Domain.Singer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wufu
 * @date 2021/1/19 13:45
 */
@Mapper
public interface SingerManageMapper {
    /**
     * 通过 singer name 获取 id
     * @param singerName
     * @return
     */
    int getSingerIdByName(@Param("singer_name")String singerName);
    /**
     * 插入用户信息
     * @param singerName 姓名
     * @param singerSex 性别
     * @param singerAge 年龄
     * @param singerAddress 地址
     * @param singerIntroduction 简介
     * @return int
     */
    int insertSingerInfo(@Param("singer_name")String singerName,@Param("singer_sex")int singerSex,
                            @Param("singer_age")int singerAge,@Param("singer_address")String singerAddress,
                          @Param("singer_introduction")String singerIntroduction);

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
    int updateSingerInfo(@Param("singer_name")String singerName,@Param("singer_sex")int singerSex,
                         @Param("singer_age")int singerAge,@Param("singer_address")String singerAddress,
                         @Param("singer_introduction")String singerIntroduction,@Param("singer_id")int singerId);

    /**
     * 删除歌手
     * @param singerId
     * @return
     */
    int deleteSingerInfo(@Param("singer_id")int singerId);
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

    List<Singer> getSingerInfoBySex(@Param("singer_sex") int singerSex);

    /**
     * 用歌手姓名模糊搜索
     * @param singerName
     * @return
     */
    List<Singer> getSingerByName(@Param("singer_name") String singerName);
}
