package com.wufu.music.Domain;

import java.io.Serializable;

/**
 * @author wufu
 * @date 2021/1/18 22:01
 */
public class User implements Serializable {
    private Integer userId;
    private String userName;
    private String password;

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
