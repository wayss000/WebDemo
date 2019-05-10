package org.knight.web.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Junit基础测试类，加载Spring配置信息
 *
 * @author Wayss.
 * @date 2019/1/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:BaseTest-context.xml"})
public class BaseTest extends AbstractJUnit4SpringContextTests {
}
