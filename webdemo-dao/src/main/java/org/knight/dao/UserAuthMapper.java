package org.knight.dao;


import org.apache.ibatis.annotations.Param;
import org.knight.model.UserAuth;

public interface UserAuthMapper {

    /**
     * 注册用户信息
     *
     * @param record
     * @return
     */
    Integer insert(UserAuth record);

    /**
     * 删除用户授权信息
     *
     * @param id
     * @return
     */
    Integer deleteByPrimaryKey(Integer id);

    /**
     * 修改密码
     *
     * @param userName
     * @param passWord
     * @return
     */
    Integer updatePassWord(@Param("userName") String userName, @Param("passWord") String passWord);

    /**
     * 通过用户名密码查询
     *
     * @param userName
     * @param passWord
     * @return
     */
    UserAuth checkAuth(@Param("userName") String userName, @Param("passWord") String passWord);

    /**
     * 查询是否存在当前用户
     *
     * @param userName
     * @return
     */
    Integer selectIdByUserName(@Param("userName") String userName);

}