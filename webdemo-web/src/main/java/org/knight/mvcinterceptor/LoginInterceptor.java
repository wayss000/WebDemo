package org.knight.mvcinterceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登陆拦截器
 * @author Wayss.
 * @date 2018/7/21.
 */
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String url = httpServletRequest.getRequestURI();
        //登陆请求不拦截
        if (url.indexOf("login") > 0){
            return true;
        }
        //注册请求不拦截
        if (url.indexOf("register") > 0){
            return true;
        }

        //验证session中是否有登陆信息
        HttpSession httpSession = httpServletRequest.getSession();
        String userName = (String)httpSession.getAttribute("userName");
        if (userName != null){
            return true;
        }

        //下面的代码都是登录权限校验失败后做的
        //跳转到指定页面（适合页面随web时用）
//        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/pleaselogin");
        //返回http状态码（适合前后端分离用）
        httpServletResponse.setStatus(401);
        //返回false后，下面的postHandle,afterCompletion就都不执行了
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

/*

preHandle方法：进入Handler方法之前执行。可以用于身份认证、身份授权。比如如果认证没有通过表示用户没有登陆，需要此方法拦截不再往下执行（return false），否则就放行（return true）。

postHandle方法：进入Handler方法之后，返回ModelAndView之前执行。可以看到该方法中有个modelAndView的形参。应用场景：从modelAndView出发：将公用的模型数据（比如菜单导航之类的）在这里传到视图，也可以在这里同一指定视图。

afterCompletion方法：执行Handler完成之后执行。应用场景：统一异常处理，统一日志处理等。

 */