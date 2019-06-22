package org.knight.interceptor.mvcinterceptor;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户名密码校验类：用户名密码均在内存中保存。
 * @author Wayss.
 * @date 2018/7/21.
 */
public class UserPasswdCheck {
    private static Map<String, String> userPasswd = new HashMap();

    /**
     * 初始化用户信息(实际场景中，用户名密码存入数据库中)
     */
    static {
        userPasswd.put("zhangsan","pd:zhangsan");
        userPasswd.put("lisi", "pd:lisi");
        userPasswd.put("wangwu", "pd:wangsu");
    }

    /**
     * 检查传入的用户名是否有权限
     * @param userName
     * @return 有权限返回true.否则返回false.
     */
    public static boolean checkPermission(String userName, String passWord){
        if (userName == null || passWord == null){
            return false;
        }

        String passwd = userPasswd.get(userName);
        if (passWord.equals(passwd)){
            return true;
        }
        return false;
    }

    /**
     * 注册用户名密码
     * @param userName
     * @param passWord
     * @return
     */
    public static boolean setUserAndPassWD(String userName, String passWord) {
        if ("".equals(userName) || "".equals(passWord)){
            return false;
        }
        userPasswd.put(userName, passWord);
        return true;
    }
}
