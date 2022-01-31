package com.orange.drug.controller;

import com.orange.drug.common.ResultMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    /**
     * 转向登录页面
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "/login";
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/toLogin")
    @ResponseBody
    public Object toLogin(String username,String password){
        if(username==null || password==null){
            return ResultMap.getLoginResultMap("用户名或密码不能为空","2");
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            return ResultMap.getLoginResultMap("用户名不存在","2");
        } catch (IncorrectCredentialsException e){
            return ResultMap.getLoginResultMap("密码错误","2");
        }
        return ResultMap.getLoginResultMap("登录成功","1");
    }

    /**
     * 转向后台首页
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        return "/index";
    }

    /**
     * 退出登录
     * @return
     */
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }
}
