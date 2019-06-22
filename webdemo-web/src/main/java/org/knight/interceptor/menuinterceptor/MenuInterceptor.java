package org.knight.interceptor.menuinterceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 菜单权限<code>MenuPower</code>的拦截器
 * @author Wayss
 * @date 2018/8/2
 */
@Component
@Aspect
public class MenuInterceptor {

    @Around("@annotation(MenuPower)")
    public Object beforeCheckAuthoroid(ProceedingJoinPoint pjp){
        //获取方法参数
        Object[] objects = pjp.getArgs();
        //遍历参数
        for (Object object : objects){
            //两种方式都可以判断类型相等
//            if (HttpServletRequest.class.isInstance(object)){
            if (object instanceof HttpServletRequest){

                //获取登录的用户名信息
                HttpSession httpSession = ((HttpServletRequest)object).getSession();
                String userName = (String)httpSession.getAttribute("userName");
                //有权限,执行原方法
                if (MenuAuthorityCheck.checkAuthority(userName)){
                    try {
                        //执行原方法
                        return pjp.proceed();
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
            }
        }
        //返回无权限页面
        return "nopower";
    }
}
