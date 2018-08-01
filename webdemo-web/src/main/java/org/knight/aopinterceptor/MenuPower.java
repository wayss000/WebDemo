package org.knight.aopinterceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 做个枚举，目的是非侵入式的增加权限控制。
 * @author Wayss
 * @date 2018/8/2
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MenuPower {
    String value() default "";
}
