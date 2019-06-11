package com.test.dubboDemo.provider;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;

/**
 * 创建 by 草帽boy on 2017/3/31.
 */
@Transactional
public class IRedisCacheServiceImpl implements ICacheService{

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    //是否缓存。默认是不缓存
    private static boolean enableCache = false;

    private static RedisTemplate redisTemplate;

    public  boolean isEnableCache() {
        return enableCache;
    }

    public  void setEnableCache(boolean enableCache) {
        IRedisCacheServiceImpl.enableCache = enableCache;
    }

    public  RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    public  void setRedisTemplate(RedisTemplate redisTemplate) {
        IRedisCacheServiceImpl.redisTemplate = redisTemplate;
    }



    private void set(final byte[] key, final byte[] value, final long ttl) {
        if (enableCache == false) {
            return;
        }
        redisTemplate.execute(new RedisCallback<Void>() {
            @Override
            public Void doInRedis(RedisConnection con) {
                try {
                    con.set(key, value);
                    if (ttl != 0) con.expire(key, ttl);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return null;
            }
        });
    }

    protected byte[] get(final byte[] key) {
        if (enableCache == false) {
            return null;
        }
        try {
            return (byte[]) redisTemplate.execute(new RedisCallback<byte[]>() {
                @Override
                public byte[] doInRedis(RedisConnection con) {

                    return con.get(key);

                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private long ttl(final byte[] key) {
        if (enableCache == false) {
            return 0;
        }
        try {
            Long t = (Long) redisTemplate.execute(new RedisCallback<Long>() {
                @Override
                public Long doInRedis(RedisConnection con) {
                    return con.ttl(key);
                }
            });

            return t.longValue();

        }catch (Exception ex){
            logger.error(ex.getMessage(), ex);
            return 0;
        }
    }

    protected void del(final byte[]... key) {
        if (enableCache == false || key == null) {
            return;
        }
        try {
            redisTemplate.execute(new RedisCallback<Void>() {
                @Override
                public Void doInRedis(RedisConnection con) {
                    con.del(key);
                    return null;
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void set(String key, Object value, long liveTime) {
        byte[] keys = key.getBytes();
        String valString = JSON.toJSONString(value);
        byte[] values = valString.getBytes();
        set(keys,values,liveTime);
    }

    @Override
    public <T> T get(String key, TypeReference<T> type) {
        byte[] valueData = get(key.getBytes());
        if(valueData==null||valueData.length<0){
            return null;
        }
        String valString = "";
        try {
            valString = new String(valueData,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        T data = JSON.parseObject(valString,type);
        return data;
    }

    @Override
    public long getLiveTime(String key) {
        return ttl(key.getBytes());
    }

    @Override
    public void del(String key) {
        del(key.getBytes());
    }


}