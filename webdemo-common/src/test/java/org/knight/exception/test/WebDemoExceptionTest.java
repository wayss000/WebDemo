package org.knight.exception.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.knight.exception.ParamWDException;
import org.knight.exception.WebDemoException;

/**
 * @author Wayss.
 * @date 2019/1/7.
 */
@Slf4j
public class WebDemoExceptionTest {

    @Test
    public void testWDException(){
//        WebDemoException webDemoException = new WebDemoException();
        ParamWDException webDemoException = new ParamWDException();
        System.out.println("Before");
        log.info("test",webDemoException);
        System.out.println("After");
    }
}
