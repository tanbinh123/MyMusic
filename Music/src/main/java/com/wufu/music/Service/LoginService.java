package com.wufu.music.Service;

import java.util.Map;

/**
 * @author wufu
 * @date 2021/1/18 22:06
 */
public interface LoginService {
    /**
     * 验证登陆信息
     * @param userName 用户名
     * @param password 密码
     * @return 返回状态码
     */
    public Map<String,Integer> verifyLogin(String userName, String password);
}
