package org.knight.service.exec;

import org.springframework.stereotype.Service;

/**
 * @author Wayss.
 * @date 2019/4/1.
 */
@Service
public class FirstDemoTestDoSthServiceImpl implements TestDoSthService {
    public Boolean doSomething() {
        System.out.println("FirstDemoTestDoSthServiceImpl");
        return null;
    }
}
