package com.wufu.music.Domain;

import java.io.Serializable;

/**
 * @author wufu
 * @date 2021/1/19 13:30
 */
public class Singer implements Serializable {
    /**
     * 在这个类中，如果没有进行特殊的配置，必须和数据库中字段保持一致
     */
    private Integer singer_id;
    private String singer_name;
    private int singer_sex;
    private int singer_age;
    private String singer_address;
    private String singer_introduction;

    public Integer getSingerId() {
        return singer_id;
    }

    public String getSingerName() {
        return singer_name;
    }

    public int getSingerSex() {
        return singer_sex;
    }

    public int getSingerAge() {
        return singer_age;
    }

    public String getSingerAddress() {
        return singer_address;
    }

    public String getSingerIntroduction() {
        return singer_introduction;
    }
}
