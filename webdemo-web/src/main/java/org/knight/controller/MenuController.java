package org.knight.controller;

import org.knight.aopinterceptor.MenuAuthorityCheck;
import org.knight.aopinterceptor.MenuPower;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用于测试菜单权限功能
 * @author Wayss
 * @date 2018/8/2
 */
@Controller
public class MenuController {

    @RequestMapping("page1")
    public String page1(HttpServletRequest httpServletRequest){
        //获取登录的用户名信息
        HttpSession httpSession = httpServletRequest.getSession();
        String userName = (String)httpSession.getAttribute("userName");

        if (MenuAuthorityCheck.checkAuthority(userName)){
            return "menu/page1";
        }else {
            return "nopower";
        }
    }

    @MenuPower
    @RequestMapping("page2")
    public String page2(HttpServletRequest httpServletRequest){
        return "menu/page2";
    }

}
