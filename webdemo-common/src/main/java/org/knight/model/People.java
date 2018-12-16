package org.knight.model;

import lombok.Data;

/**
 * People实体类
 *
 * @author Wayss.
 * @date 2018/7/31.
 */
@Data
public class People {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 身高
     */
    private Float height;

    /**
     * 体重
     */
    private Float weight;

    /**
     * 兴趣
     */
    private String interests;
}
