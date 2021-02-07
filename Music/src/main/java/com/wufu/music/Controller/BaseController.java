package com.wufu.music.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;


/**
 * @author wufu
 */
public class BaseController {
    protected Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    /**
     * 检查用户是否登陆
     * @param session 会话
     * @return userId
     */
    protected Object checkUser(HttpSession session){
        logger.info("检验用户登陆状态");
        Object userId = session.getAttribute("userId");

        if(userId == null){
            logger.info("用户未登陆");
            return null;
        }
        logger.info("用户已经登陆，用户ID：{}",userId);
        return userId;
    }
}
