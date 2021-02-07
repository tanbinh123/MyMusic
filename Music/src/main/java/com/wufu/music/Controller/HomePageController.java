package com.wufu.music.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author wufu
 * @date 2021/1/18 23:38
 */
@Controller
public class HomePageController extends BaseController{

    @RequestMapping("/Home")
    public String goToHomePage(HttpSession session){
        if(checkUser(session)!=null) {
            logger.info("转到首页！");
            return "homePage";
        }
        logger.info("未登录");
        return "loginPage";
    }
}
