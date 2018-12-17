package org.knight.service.impl;

import org.knight.dao.UserAuthMapper;
import org.knight.domain.Message;
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
        //TODO 接收插入的主键ID返回值，用来判断是否注册成功
        return true;
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
        if (userAuth != null) {
            isAuth = true;
        }

        return isAuth;
    }

    public Message register(String userName, String passWord) {

        Message message = new Message();

        //判断当前用户名是否已被占用
        Integer id = userAuthMapper.selectIdByUserName(userName);
        if (id != null){
            message.setIsSuccess(false);
            message.setMessage("当前用户名已被注册");
        }else {
            //插入新用户数据
            Boolean result = this.insert(userName, passWord);
            if (result){
                message.setIsSuccess(true);
                message.setMessage("注册成功");
            }else {
                message.setIsSuccess(false);
                message.setMessage("保存用户名密码信息失败，请重试一次");
            }
        }

        return message;

    }
}
