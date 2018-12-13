package org.knight.domain;

import lombok.Data;

/**
 * @author Wayss.
 * @date 2018/12/14.
 */
@Data
public class UserAuth {
    private Integer id;

    private String userName;

    private String passWord;
}
