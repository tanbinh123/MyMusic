package com.wufu.music.Service.Impl;

import com.wufu.music.Dao.SingerManageMapper;
import com.wufu.music.Domain.Singer;
import com.wufu.music.Service.SingerManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wufu
 * @date 2021/1/19 13:57
 */
@Service
public class SingerManageServiceImpl implements SingerManageService {
    @Autowired
    private SingerManageMapper singerManageMapper;
    /**
     * 插入歌手信息
     * @param name
     * @param sex
     * @param age
     * @param address
     * @param intro
     * @return 成功或者失败
     */
    @Override
    public boolean insertSingerInfo(String name, int sex, int age, String address, String intro) {
        System.out.println("sex"+sex);
        System.out.println("age: "+age);
        System.out.println("intro: "+intro);
        int result = singerManageMapper.insertSingerInfo(name,sex,age,address,intro);
        System.out.println("result: "+result);
        return result>0;
    }

    /**
     * 更新歌手信息
     *
     * @param singerName
     * @param singerSex
     * @param singerAge
     * @param singerAddress
     * @param singerIntroduction
     * @return
     */
    @Override
    public boolean updateSingerInfo(String singerName, int singerSex, int singerAge, String singerAddress, String singerIntroduction) {
        int singerId = singerManageMapper.getSingerIdByName(singerName);
        return singerManageMapper.updateSingerInfo(singerName,singerSex,singerAge,singerAddress,singerIntroduction,singerId)>0;
    }

    /**
     * 删除歌手
     *
     * @param singerName@return
     */
    @Override
    public boolean deleteSingerInfo(String singerName) {
        try{
            int singerId = singerManageMapper.getSingerIdByName(singerName);
            singerManageMapper.deleteSingerInfo(singerId);
            return true;
        }catch(Exception e){
            // e.printStackTrace();
            return false;
        }

    }

    /**
     * 获取所有歌手
     *
     * @return 歌手信息
     */
    @Override
    public List<Singer> getAllSinger() {
        return singerManageMapper.getAllSinger();
    }

    /**
     * 获取所有男歌手或者女歌手
     *
     * @param singerSex
     * @return
     */
    @Override
    public List<Singer> getSingerInfoBySex(int singerSex) {
        return singerManageMapper.getSingerInfoBySex(singerSex);
    }

    /**
     * 用歌手姓名模糊搜索
     *
     * @param singerName
     * @return
     */
    @Override
    public List<Singer> getSingerByName(String singerName) {
        return singerManageMapper.getSingerByName(singerName);
    }
}
