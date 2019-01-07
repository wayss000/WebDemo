package org.knight.exception;

import java.util.UUID;

/**
 * WebDemo统一异常，该项目的异常基类<br>
 * 测试类{@link org.knight.exception.test.WebDemoExceptionTest}
 *
 * @author Wayss.
 * @date 2019/1/6.
 */
public class WebDemoException extends Exception{

    private UUID uuid;

    public WebDemoException(){
        super();
        uuid = UUID.randomUUID();
    }

    public WebDemoException(WebDemoException e){
        super();
        uuid = e.uuid;
    }

    @Override
    public String toString(){
        return uuid.toString() + "\n" + super.toString();
    }

}
