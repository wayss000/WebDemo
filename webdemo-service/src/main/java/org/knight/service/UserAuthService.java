package org.knight.service;

/**
 * @author Wayss.
 * @date 2018/12/16.
 */
public interface UserAuthService {

    /**
     * 注册新用户
     *
     * @param userName
     * @param passWord
     * @return
     */
    Boolean insert(String userName, String passWord);

    /**
     * 删除用户权限信息
     *
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 修改密码
     *
     * @param userName
     * @param passWord
     */
    void updateUserAuth(String userName, String passWord);

    /**
     * 判断用户名和密码
     *
     * @param userName
     * @param passWord
     * @return
     */
    Boolean checkAuth(String userName, String passWord);
}
