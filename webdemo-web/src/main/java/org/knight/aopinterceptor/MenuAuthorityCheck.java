package org.knight.aopinterceptor;

import java.util.HashMap;
import java.util.Map;

/**
 * 校验菜单（页面）权限。（这个类不该在这个包下，应该在Service层或者util包里，这里测试用）
 * @author Wayss
 * @date 2018/8/2
 */
public class MenuAuthorityCheck {

    /**
     * 用map保存用户是否拥有页面权限.实际中用户权限也在数据库中存放。
     */
    private static Map<String,Boolean> userAuthority = new HashMap<String, Boolean>();

    /**
     * 初始化用户对应的权限信息
     */
    static {
        userAuthority.put("zhangsan",true);
        userAuthority.put("lisi",false);
    }

    public static boolean checkAuthority(String userName){
        return userAuthority.get(userName);
    }
}
