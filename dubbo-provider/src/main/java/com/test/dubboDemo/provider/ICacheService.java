package com.test.dubboDemo.provider;



import com.alibaba.fastjson.TypeReference;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 创建 by 草帽boy on 2017/3/31.
 */
public interface ICacheService{

    /**
     * 存入缓存数据
     * @param key 在缓存中的key值
     * @param value 待储存的value值
     * @param liveTime 存活时间 单位是秒
     */
    void set(final String key,final Object value,final long liveTime);

    /**
     * 获取到缓存数据
     * @param key 获取的key值
     * @param type 获取的类型
     * @param <T> 泛型
     * @return 你所需要的类型值
     */
    <T> T get(final String key, final TypeReference<T> type );

    /**
     * 获取剩余存活时间
     * @param key 返回
     * @return
     */
    long getLiveTime(final String key);

    /**
     * 删除缓存中的缓存数据
     * @param key key值
     */
    void del(final String key);
}