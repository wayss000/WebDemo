package org.knight.cache;

/**
 * 缓存Key的设计
 *
 * @author Wayss.
 * @date 2019/1/20.
 */
public enum CacheKey {

    /**
     * 测试String类型的Key
     */
    TEST_STRING,
    /**
     * 测试List类型的Key
     */
    TEST_LIST,

    /**
     * 测试Set类型的Key
     */
    TEST_SET,

    /**
     * 测试Hase类型的Key
     */
    TEST_HASH,

    /**
     * 测试ZSet类型的Key
     */
    TEST_ZSET,
    ;

    /**
     * 所有Key加入APPName前缀，若多个应用使用同一个缓存时可以区分
     */
    private static final String APP_NAME = "WEB-DEMO_";

    private static final String END = "_";

    private String key;

    CacheKey() {
        this.key = APP_NAME + this.name();
    }

    /**
     * 每个Key在使用时加入下划线后缀，根据业务不同选择不同的使用<br>
     * 举例：CacheKey.TEST_STRING.getKey()的值为"WEB-DEMO_TEST_STRING_"
     *
     * @return
     */
    public String getKey() {
        return this.key + END;
    }

}
