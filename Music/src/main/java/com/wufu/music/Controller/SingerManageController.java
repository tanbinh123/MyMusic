package com.wufu.music.Controller;

import com.alibaba.fastjson.JSONObject;
import com.wufu.music.Domain.Response;
import com.wufu.music.Domain.Singer;
import com.wufu.music.Service.SingerManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;

/**
 * @author wufu
 * @date 2021/1/19 12:32
 */
@Controller
public class SingerManageController extends BaseController{
    @Autowired
    private SingerManageService singerManageService;

    @ApiOperation("歌手管理")
    @RequestMapping("/SingerManage")
    public String goToSingerManagePage(HttpSession session){
        if(checkUser(session)!=null) {
            logger.info("跳转到歌手管理页面");
            return "singerManagePage";
        }
        logger.info("未登录");
        return "loginPage";
    }

    @ApiOperation("歌手信息提交")
    @RequestMapping("/singerSubmit")
    @ResponseBody
    public Object singerInfoSubmit(@NotNull HttpServletRequest request){
        logger.info("正在提交歌手信息...");
        String name = request.getParameter("singerName");
        String sexTemp = request.getParameter("singerSex");
        int age = Integer.parseInt(request.getParameter("singerAge"));
        String address = request.getParameter("singerAddress");
        String intro = request.getParameter("singerIntroduction");
        int sex;
        if("男".equals(sexTemp)){
            sex = 1;
        }else{
            sex = 0;
        }
        logger.info("name:"+name);
        logger.info("age: "+age);
        logger.info("address: "+address);
        JSONObject result = new JSONObject();
        if(singerManageService.insertSingerInfo(name,sex,age,address,intro)){
            logger.info("提交成功!!");
            result.put("statusCode",200);
        }else{
            logger.info("提交失败!!");
            result.put("statusCode",404);
        }

        return result;
    }

    @ApiOperation("删除歌手信息")
    @RequestMapping("/deleteSinger")
    @ResponseBody
    public Object deleteSingerInfo(@NotNull HttpServletRequest request){
        logger.info("正在删除歌手信息...");
        String singerName = request.getParameter("singerName");

        if(singerName == null){
            return Response.makeErrorRsp("参数缺失");
        }

        if(!singerManageService.deleteSingerInfo(singerName)){
            return Response.makeErrorRsp("要删除的歌手不存在");
        }
        return Response.makeOkRsp();
    }

    @RequestMapping("/updateSinger")
    @ResponseBody
    public Object updateSingerInfo(@NotNull HttpServletRequest request){
        logger.info("正在更新歌手信息...");
        String singerName = request.getParameter("singerName");
        int singerSex = "男".equals(request.getParameter("singerSex")) ?1:0;
        int singerAge = Integer.parseInt(request.getParameter("singerAge"));
        String singerAddress = request.getParameter("singerAddress");
        String singerIntroduction = request.getParameter("singerIntroduction");

        JSONObject result = new JSONObject();
        if(singerManageService.updateSingerInfo(singerName,singerSex,singerAge,singerAddress,singerIntroduction)){
            logger.info("更新歌手信息成功");
            result.put("statusCode",200);
        }else{
            logger.info("更新歌手信息失败");
            result.put("statusCode",404);
        }
        return result;
    }

    @RequestMapping("/getAllSinger")
    @ResponseBody
    public Object getAllSinger(@NotNull HttpServletRequest request){
        logger.info("正在获取所有歌手信息...");
        List<Singer> singerList = singerManageService.getAllSinger();
        return Response.makeOkRsp().setData(singerList);
    }

    @RequestMapping("/getSingerBySex")
    @ResponseBody
    public Object getSingerInfoBySex(@NotNull HttpServletRequest request){
        logger.info("正在获取某一性别的歌手信息...");
        int singerSex = "男".equals(request.getParameter("singerSex"))?1:0;
        return singerManageService.getSingerInfoBySex(singerSex);
    }

    @RequestMapping("/getSingerByName")
    @ResponseBody
    public Object getSingerInfoByName(@NotNull HttpServletRequest request){
        logger.info("正在获取某一性别的歌手信息...");
        String singerName = request.getParameter("singerName");
        return singerManageService.getSingerByName(singerName);
    }

}
