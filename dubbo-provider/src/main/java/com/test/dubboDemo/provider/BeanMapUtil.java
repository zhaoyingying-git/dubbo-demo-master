package com.test.dubboDemo.provider;


import org.springframework.cglib.beans.BeanMap;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaoyingying
 * @create 2019/3/29
 * @company 甜橙信息
 */

public class BeanMapUtil {

    private BeanMapUtil(){
        throw new IllegalStateException("Utility class");
    }

    /***
     * 通过反射将class 转成 map
     *
     * @param t
     * @return
     */
    public static<T>  Map<String,String> coverClassToMap(T t){
        Map<String,String> result = new HashMap<>();
        Class cl = t.getClass();
        Field[] fields = cl.getDeclaredFields();
        Field[] superFields = cl.getSuperclass().getDeclaredFields();
        fillField(result,fields,t);
        fillField(result,superFields,t);
        return result;
    }
    private static<T> void fillField(Map<String, String> result, Field[] fields, T t) {
        String val = null;
        Object o = null;
        for(Field item : fields){
            try {
                item.setAccessible(true);
                o = item.get(t);
                if(o == null){
                    continue;
                }
                if(o instanceof Date){
//                    val = DateUtil.format((Date) o,"yyyyMMddHHmmss");
                }else {
                    val = String.valueOf(o);
                }
                result.put(item.getName(),val);
            } catch (IllegalAccessException e) {
//                log.error("error transform to mapper");
            }
        }
    }

    /**
     * 将map集合中的数据转化为指定对象的同名属性中
     */
    public static <T> T mapToBean(Map<String, String> map,Class<T> clazz){
        T bean = null;
        try {
            bean = clazz.newInstance();
        } catch (InstantiationException e) {
//            log.info("InstantiationException", e);
        } catch (IllegalAccessException e) {
//            log.info("IllegalAccessException", e);
        }
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }


}
