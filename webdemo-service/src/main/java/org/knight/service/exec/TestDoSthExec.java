package org.knight.service.exec;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Wayss.
 * @date 2019/4/1.
 */
@Service
public class TestDoSthExec implements InitializingBean {

    @Resource
    private TestDoSthService firstDemoTestDoSthServiceImpl;

    @Resource
    private TestDoSthService secondDemoTestDoSthServiceImpl;

    @Resource
    private TestDoSthService thirdDemoTestDoSthServiceImpl;

    @Resource
    private ThreadPoolTaskExecutor testTaskExecutor;

    public void afterPropertiesSet() throws Exception {
        TestDoSthRunner exchangeWareRunner = new TestDoSthRunner(firstDemoTestDoSthServiceImpl);
        testTaskExecutor.execute(exchangeWareRunner);
        TestDoSthRunner delayDeliverRunner = new TestDoSthRunner(secondDemoTestDoSthServiceImpl);
        testTaskExecutor.execute(delayDeliverRunner);
        TestDoSthRunner repeatDistributionRunner = new TestDoSthRunner(thirdDemoTestDoSthServiceImpl);
        testTaskExecutor.execute(repeatDistributionRunner);
    }
}
