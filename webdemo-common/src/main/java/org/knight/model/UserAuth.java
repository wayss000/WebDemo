package org.knight.model;

import lombok.Data;


/**
 * 用户权限
 */
@Data
public class UserAuth {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String passWord;

}