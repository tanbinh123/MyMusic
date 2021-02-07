package com.wufu.music.Controller;

import com.alibaba.fastjson.JSONObject;
import com.wufu.music.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author wufu
 * @date 2021/1/18 22:09
 */
@Controller
public class LoginController extends BaseController{

    @Autowired
    private LoginService loginService;

    @RequestMapping("/Login")
    public String goToLoginPage(){
        logger.info("转到登陆页");
        return "loginPage";
    }

    /**
     *  重写父类的 checkLogin 方法
     * @param request 请求
     * @param session 会话
     * @return 登陆状态
     */
    @RequestMapping("/doLogin")
    @ResponseBody
    public Object checkLogin(HttpServletRequest request, HttpSession session){
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        Map<String,Integer> status =  loginService.verifyLogin(userName,password);
        JSONObject object = new JSONObject();
        if(status.get("statusCode").equals(200)){
            logger.info("登陆成功！");
            session.setAttribute("userId",status.get("userId"));
            object.put("statusCode",200);
        }else{
            logger.info("账号或者密码错误，请重新输入");
            object.put("statusCode",404);
        }
        return object;
    }

}
