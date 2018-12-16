package org.knight.service.impl;

import org.knight.dao.UserAuthMapper;
import org.knight.model.UserAuth;
import org.knight.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wayss.
 * @date 2018/12/16.
 */
@Service
public class UserAuthServiceImpl implements UserAuthService {

    @Autowired
    private UserAuthMapper userAuthMapper;

    public Boolean insert(String userName, String passWord) {
        UserAuth userAuth = new UserAuth();
        userAuth.setUserName(userName);
        userAuth.setPassWord(passWord);

        userAuthMapper.insert(userAuth);
        return true;
        //TODO 接收插入返回值，判断是否注册成功
    }

    public void deleteById(Integer id) {
        userAuthMapper.deleteByPrimaryKey(id);
    }

    public void updateUserAuth(String userName, String passWord) {
        userAuthMapper.updatePassWord(userName, passWord);
    }

    public Boolean checkAuth(String userName, String passWord) {

        Boolean isAuth = false;

        UserAuth userAuth = userAuthMapper.checkAuth(userName, passWord);
        if (userAuth.getId() != null) {
            isAuth = true;
        }

        return isAuth;
    }
}
