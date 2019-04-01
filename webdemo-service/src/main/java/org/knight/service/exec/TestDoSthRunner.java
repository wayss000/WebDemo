package org.knight.service.exec;

import org.springframework.stereotype.Service;

/**
 * @author Wayss.
 * @date 2019/4/1.
 */
@Service
public class TestDoSthRunner implements Runnable {

    private TestDoSthService testDoSthService;

    public TestDoSthRunner(){

    }

    public TestDoSthRunner(TestDoSthService testDoSthService){
        this.testDoSthService = testDoSthService;
    }

    public void run() {
        testDoSthService.doSomething();
    }
}
