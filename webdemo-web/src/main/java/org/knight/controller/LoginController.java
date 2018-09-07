package org.knight.controller;

import org.knight.domain.Message;
import org.knight.mvcinterceptor.UserPasswdCheck;
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

    /**
     * 登陆请求
     * (http://localhost/login?userName=zhangsan&passWord=pd:zhangsan)
     * @return 登陆成功返回true,失败返回false;
     */
    @RequestMapping("login")
    @ResponseBody
    public Message login(HttpServletRequest httpServletRequest){
        Message message = new Message();

        //获取前端（包括web、安卓、苹果）传来的用户名密码
        String userName = httpServletRequest.getParameter("userName");
        String passWord = httpServletRequest.getParameter("passWord");

        //权限校验
        boolean havePermission = UserPasswdCheck.checkPermission(userName, passWord);
        //权限校验成功后登陆信息保存到session中，之后就不用每次都登陆了
        if (havePermission){
            HttpSession httpSession = httpServletRequest.getSession();
            httpSession.setAttribute("userName", userName);
            message.setIsSuccess(true);
            message.setMessage("登陆成功");
        }else {
            message.setIsSuccess(false);
            message.setMessage("登陆失败");
        }
        return message;
    }

    /**
     * 注册请求
     * (http://localhost/register?userName=zhangsan&passWord=pd:zhangsan)
     * @return 注册成功返回true,失败返回false;
     */
    @RequestMapping("register")
    @ResponseBody
    public Message register(HttpServletRequest httpServletRequest){

        Message message = new Message();

        String userName = httpServletRequest.getParameter("userName");
        String passWord = httpServletRequest.getParameter("passWord");

        boolean isRegisterOK = UserPasswdCheck.setUserAndPassWD(userName, passWord);
        if (isRegisterOK){
            HttpSession httpSession = httpServletRequest.getSession();
            httpSession.setAttribute("userName", userName);
            message.setIsSuccess(true);
            message.setMessage("登陆成功");
        }else {
            message.setIsSuccess(false);
            message.setMessage("登陆失败");
        }
        return message;

    }

    @RequestMapping("pleaselogin")
    public String pleaseLogin(){
        return "loginpage";
    }

}
