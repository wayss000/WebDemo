package org.knight.cache;

import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;

/**
 * @author Wayss.
 * @date 2019/1/20.
 */
public class TestJedis {

    private static String redisAdd = "192.168.199.183";

    public static void main(String[] args) {
        Jedis jedis = new Jedis(redisAdd);
        jedis.set("aaa", "aaa-value");

        String result = jedis.get("aaa");
        System.out.println(result);
    }
}
