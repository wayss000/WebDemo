package org.knight.dto;

import lombok.Data;

/**
 * @author Wayss
 * @date 2018/6/14
 */
@Data
public class People {

    private Long id;
    private String name;
    private String sex;
    private Float height;
    private Float weight;
    /**
     * 兴趣爱好
     */
    private String interests;

}
