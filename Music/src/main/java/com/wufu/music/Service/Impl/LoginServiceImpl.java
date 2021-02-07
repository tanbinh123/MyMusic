package com.wufu.music.Service.Impl;

import com.wufu.music.Dao.LoginMapper;
import com.wufu.music.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wufu
 * @date 2021/1/18 22:07
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    /**
     * 验证登陆信息
     *
     * @param userName 用户名
     * @param password 密码
     * @return 返回状态码
     */
    @Override
    public Map<String, Integer> verifyLogin(String userName, String password) {
        int status = loginMapper.verifyLogin(userName,password);
        Map<String,Integer> result = new HashMap<>();
        if(status == 1){
            result.put("statusCode",200);
            int userId = loginMapper.getUserId(userName,password);
            result.put("userId",userId);
        }else{
            result.put("statusCode",404);
        }
        return result;
    }
}
