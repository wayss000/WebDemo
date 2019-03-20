package org.knight.web.test;

import org.junit.Test;
import org.knight.cache.CacheKey;
import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Redis测试类，主要为对Redis的5种基本类型读写操作。
 *
 * @author Wayss.
 * @date 2019/1/22.
 */

public class TestRedis extends BaseTest {

    @Value("${redis.service.ip}")
    private String redisAdd;

    /**
     * String类型<br>
     * 测试存储String类型
     */
    @Test
    public void testString() {
        System.out.println(redisAdd);
        Jedis jedis = new Jedis(redisAdd);
        String key = CacheKey.TEST_ONE.getKey() + "aaa";
        System.out.println(key);
        jedis.set(key, "aaa-value-aaa");

        String result = jedis.get("aaa");
        System.out.println(result);
    }

    /**
     * list类型<br>
     * 用list类型实现阻塞队列
     */
    @Test
    public void testBlockQueue(){
        String key = CacheKey.TEST_ONE.getKey();
        System.out.println(key);
        Jedis jedis = new Jedis(redisAdd);
        while (true){
            List<String> valueLst = jedis.brpop(0, key);
            System.out.println(valueLst);
        }
    }


}
