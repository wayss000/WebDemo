package org.knight.dao;


import org.knight.model.UserAuth;

public interface UserAuthMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserAuth record);

    int insertSelective(UserAuth record);

    UserAuth selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserAuth record);

    int updateByPrimaryKey(UserAuth record);
}