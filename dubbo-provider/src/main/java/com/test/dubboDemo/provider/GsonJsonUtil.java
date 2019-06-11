package com.test.dubboDemo.provider;

import com.google.gson.Gson;

/**
 * 对象和Json字符串转换工具类
 * <p>
 * 1、java对象转换成json字符串
 * 2、json字符串转成java对象
 * </p>
 * @author 张勤华
 * @author Suqiang Chen
 * @author tiger
 * @version 1.0.0 createTime: 2015/4/27 20:21
 * @since 1.6
 */
public class GsonJsonUtil {

    private GsonJsonUtil() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * java对象转换成json字符串
     *
     * @param obj Object 对象
     * @return json 字符串
     */
    public static String toJson(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    /**
     * json字符串转成java对象
     *
     * @param str 字符串
     * @param type class 对象
     * @return class 对象
     */
    public static <T> T fromJson(String str, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(str, type);
    }
}
