package com.fang.wxcloudrun.utils;

import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author FPH
 * @since 2022年8月25日17:33:47
 */
@RequiredArgsConstructor
@Component
public class RedisUtil {

    /**
     * 默认过期时长，单位：秒
     */
    public final static long DEFAULT_EXPIRE = 60 * 60 * 8;
    /**
     * 不设置过期时长
     */
    public final static long NOT_EXPIRE = -1;
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Resource
    private ValueOperations<String, String> valueOperations;

    /**
     * 插入缓存默认时间
     *
     * @param key   键
     * @param value 值
     * @author zmr
     */
    public void set(String key, String value) {
        set(key, value, DEFAULT_EXPIRE);
    }

    public void set(String key, Object value) {
        set(key, value, DEFAULT_EXPIRE);
    }

    /**
     * 插入缓存
     *
     * @param key    键
     * @param value  值
     * @param expire 过期时间(s)
     * @author zmr
     */
    public void set(String key, String value, long expire) {
        valueOperations.set(key, value, expire, TimeUnit.SECONDS);
    }

    public void set(String key, Object value, long expire) {
        redisTemplate.opsForValue().set(key, value, expire, TimeUnit.SECONDS);
    }

    /**
     * 插入缓存
     *
     * @param key    键
     * @param value  值
     * @param expire 过期时间(s)
     * @author zmr
     */
    public void set(String key, Object value, long expire, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, expire, unit);
    }

    /**
     * 返回字符串结果
     *
     * @param key 键
     * @return
     * @author zmr
     */
    public String get(String key) {
        return valueOperations.get(key);
    }

    public Object getObj(String key){
        return redisTemplate.opsForValue().get(key);
    }

    public boolean exists(String key){
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }


    /**
     * 根据命名空间模糊查询后删除
     *
     * @param namespace
     * @return
     */
    public void deleteByNamespace(String namespace) {
        Set<String> keys = redisTemplate.keys(namespace);
        if (CollectionUtils.isNotEmpty(keys)) {
            redisTemplate.delete(keys);
        }
    }

    /**
     * 返回指定类型结果
     *
     * @param key   键
     * @param clazz 类型class
     * @return
     * @author zmr
     */
    public <T> T get(String key, Class<T> clazz) {
        return (T) redisTemplate.opsForValue().get(key);
    }

    /**
     * 删除缓存
     *
     * @param key 键
     * @author zmr
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    public void leftPush(String key, Object value) {
        redisTemplate.opsForList().leftPush(key, value);
    }

}
