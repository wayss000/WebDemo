package org.knight.controller;

import org.apache.commons.lang.StringUtils;
import org.knight.domain.Message;
import org.knight.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登陆注册Controller.
 * @author Wayss.
 * @date 2018/7/21.
 */
@Controller
public class LoginController {

    @Autowired
    private UserAuthService userAuthService;

    /**
     * 登陆请求
     * (http://localhost/login/login?userName=zhangsan&passWord=pd:zhangsan)
     * @return 登陆成功返回true,失败返回false;
     */
    @RequestMapping("/login/login")
    @ResponseBody
    public Message login(HttpServletRequest httpServletRequest){

        //获取前端（包括web、安卓、苹果）传来的用户名密码
        String userName = httpServletRequest.getParameter("userName");
        String passWord = httpServletRequest.getParameter("passWord");

        //权限校验
        boolean isAuth = userAuthService.checkAuth(userName, passWord);

        //权限校验成功后登陆信息保存到session中，之后就不用每次都登陆了
        Message message = checkAuth(isAuth);
        //登陆成功则更新session
        if (message.getIsSuccess()){
            /*
            注意：这里把登陆or注册成功后用户信息保存到session中，
            如果Web程序部署在集群中就不行了，因为，session只保存在单台机器中，
            那么，分布式部署该怎么办呢？答案是，可以保存在一个所有机器都能访问的redis中，单点登录也就是这个原理。
             */
            HttpSession httpSession = httpServletRequest.getSession();
            httpSession.setAttribute("userName", userName);
        }
        return message;
    }

    /**
     * 注册请求
     * (http://localhost/login/register?userName=zhangsan&passWord=pd:zhangsan)
     * @return 注册成功返回true,失败返回false;
     */
    @RequestMapping("/login/register")
    @ResponseBody
    public Message register(HttpServletRequest httpServletRequest){

        Message message;

        String userName = httpServletRequest.getParameter("userName");
        String passWord = httpServletRequest.getParameter("passWord");

        if (StringUtils.isBlank(userName) || StringUtils.isBlank(passWord)){
            message = new Message();
            message.setIsSuccess(false);
            message.setMessage("用户名和密码均不能为空");
            return message;
        }

        message = userAuthService.register(userName, passWord);

        //登陆成功则更新session
        if (message.getIsSuccess()){
            /*
            注意：这里把登陆or注册成功后用户信息保存到session中，
            如果Web程序部署在集群中就不行了，因为，session只保存在单台机器中，
            那么，分布式部署该怎么办呢？答案是，可以保存在一个所有机器都能访问的redis中，单点登录也就是这个原理。
             */
            HttpSession httpSession = httpServletRequest.getSession();
            httpSession.setAttribute("userName", userName);
        }
        return message;

    }

    private Message checkAuth(boolean isAuth) {
        Message message = new Message();
        if (isAuth){
            message.setIsSuccess(true);
            message.setMessage("登陆成功");
        }else {
            message.setIsSuccess(false);
            message.setMessage("登陆失败，请检查用户名密码是否正确");
        }
        return message;
    }

    @RequestMapping("/login/pleaselogin")
    public String pleaseLogin(){
        return "loginpage";
    }

    @RequestMapping("/login/login_page")
    public String login() {
        //跳转到登录页面
        return "login/login";
    }

    @RequestMapping("/login/register_page")
    public String register(){
        //跳转到注册页面
        return "login/register";
    }

}
