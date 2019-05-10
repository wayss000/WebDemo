package org.knight.web.test;

import org.junit.Test;
import org.knight.cache.CacheKey;
import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Redis测试类，主要为对Redis的5种基本类型读写操作。<br>
 * 注意：运行此测试用例前，需要先安装好Redis.
 *
 * @author Wayss.
 * @date 2019/1/22.
 */

public class TestRedis extends BaseTest {

//    @Value("${redis.service.ip}")
//    private String redisAdd;

    @Resource
    private Jedis redisClient;

    @Test
    public void testJedis() {
        String redisAdd = "192.168.125.129";
        Jedis jedis = new Jedis(redisAdd);
        jedis.set("test-key", "test-value");
        String result = jedis.get("test-key");
        System.out.println(result);
    }

    /**
     * String类型<br>
     * String类型的基本用法
     */
    @Test
    public void testString() {
        String key = CacheKey.TEST_STRING.getKey() + "aaa";
        System.out.println(key);

        redisClient.set(key, "aaa-value-aaa");

        String result = redisClient.get(key);
        System.out.println(result);
/*
程序输出：
WEB-DEMO_TEST_STRING_aaa
aaa-value-aaa
*/
    }

    /**
     * list类型<br>
     * Redis中list类型的基本用法
     */
    @Test
    public void testList() {
        String key = CacheKey.TEST_LIST.getKey() + "list";
        System.out.println(key);

        for (int i = 0; i < 5; i++) {
            redisClient.lpush(key, String.valueOf(i));
        }
        //参数0表示下标从0，参数-1表示取全部的list值
        List<String> result = redisClient.lrange(key, 0, -1);
        System.out.println(result);
/*
程序输出：
WEB-DEMO_TEST_LIST_list
[0, 1, 2, 3, 4]
*/
    }

    /**
     * list类型<br>
     * 用list类型实现阻塞队列
     */
//    @Test
    public void testBlockQueue() {
        String key = CacheKey.TEST_LIST.getKey() + "BLOCK";
        System.out.println(key);

        while (true) {
            //timeout为0时，一直阻塞
            List<String> valueLst = redisClient.brpop(0, key);
            System.out.println(valueLst);
        }
    }

    @Test
    public void testSet() {
        String key = CacheKey.TEST_SET.getKey();
        System.out.println(key);

        for (int i = 0; i < 5; i++) {
            redisClient.sadd(key, "one", "two", "three", String.valueOf(i));
        }
        Set<String> result = redisClient.smembers(key);
        System.out.println(result);
/*
程序输出：
WEB-DEMO_TEST_SET_
[1, 4, three, 0, one, two, 3, 2]
*/
    }

    @Test
    public void testHash() {
        String key = CacheKey.TEST_HASH.getKey();
        System.out.println(key);

        redisClient.hset(key, "hset-key1", "hset-value1");
        redisClient.hset(key, "hset-key2", "hset-value2");

        String resultValue1 = redisClient.hget(key, "hset-key1");
        System.out.println(resultValue1);

        Map<String, String> resultMap = redisClient.hgetAll(key);
        for (Map.Entry entry : resultMap.entrySet()) {
            System.out.println("map-key:" + entry.getKey() + "\t" + "map-value" + entry.getValue());
        }

/*
程序输出：
WEB-DEMO_TEST_HASH_
hset-value1
map-key:hset-key1	map-valuehset-value1
map-key:hset-key2	map-valuehset-value2
*/
    }

    @Test
    public void testZSet() {
        String key = CacheKey.TEST_ZSET.getKey();
        System.out.println(key);

        redisClient.zadd(key, 5.4, "value1");
        redisClient.zadd(key, 3, "value2");
        redisClient.zadd(key, 7.9, "value3");

        Set<String> result = redisClient.zrange(key, 0, -1);
        System.out.println(result);

        Set<String> result1 = redisClient.zrangeByScore(key, 4, 6);
        System.out.println(result1);
/*
程序输出：
WEB-DEMO_TEST_ZSET_
[value2, value1, value3]
[value1]
*/
    }


}
