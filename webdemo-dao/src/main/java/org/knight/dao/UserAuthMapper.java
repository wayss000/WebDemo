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
    int insert(UserAuth record);

    /**
     * 删除用户授权信息
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 修改密码
     *
     * @param userName
     * @param passWord
     * @return
     */
    int updatePassWord(@Param("userName") String userName, @Param("passWord") String passWord);

    /**
     * 通过用户名密码查询
     *
     * @param userName
     * @param passWord
     * @return
     */
    UserAuth checkAuth(@Param("userName") String userName, @Param("passWord") String passWord);

}