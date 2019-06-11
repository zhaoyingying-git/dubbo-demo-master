package com.test.dubboDemo.provider;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 时间工具类
 *
 * @author jumping
 * @version 1.0.0
 * @time 2015/07/02
 */
public class DateUtil {

    /**
     * 锁对象
     */
    private static final Object lockObj = new Object();
    /**
     * 存放不同的日期模板格式的sdf的Map
     */
    private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<String, ThreadLocal<SimpleDateFormat>>();
    /**
     * 日期时间格式
     **/
    public static final String TIME_PATTERN = "HHmmss";
    public static final String TIMES_PATTERN = "yyyy/MM/ddHH:mm:ss";
    public static final String DATE_PATTERN = "yyyyMMdd";
    public static final String SHORT_DATE_PATTERN = "yyMMdd";
    public static final String FULL_PATTERN = "yyyyMMddHHmmss";
    public static final String FULL_PATTERNS = "yyyyMMddHHmmssSSS";
    public static final String PART_PATTERN = "yyMMddHHmmss";
    public static final String TICKET_PATTERN = "yyyy.MM.dd HH:mm:ss";
    public static final String SETTLE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String HOUR_OF_MINUTE = "HHmm";
    public static final String TIME_COL_PATTERN = "HH:mm:ss";
    public static final String DATEFULL_PATTERN = "yyyyMMdd HH:mm:ss";
    public static final String YEAR_OF_MINUTE = "yyyyMMddHHmm";
    public static final String YEAR_DATE = "yyyy-MM-dd HH:mm";
    public static final String SHOT_PATTERN = "yyyy-MM-dd";
    public static final String DATE_time_PATTERN = "yyyy/MM/dd";


    private DateUtil() {
        throw new IllegalStateException("Utility class");
    }

    /***
     * 时间格式转换
     * @param date  时间字符串
     * @param originPattern 原时间格式
     * @param targetPattern 新的时间格式
     * @return
     * @throws ParseException
     */
    public static String convert(String date, String originPattern, String targetPattern) throws ParseException {
        Date originDate = parse(date, originPattern);
        return format(originDate, targetPattern);
    }

    /**
     * 源日期和（目标日期加上毫秒数）比较大小， 大则返回false ，小返回true
     *
     * @param src    源日期
     * @param target 目的日期
     * @param second 秒数
     * @return 成功，失败
     */
    public static boolean compareDateForSecond(Date src, Date target, int second) {
        Calendar targetTime = Calendar.getInstance();
        targetTime.setTime(target);
        targetTime.add(Calendar.SECOND, second);
        Calendar srcTime = Calendar.getInstance();
        srcTime.setTime(src);
        return srcTime.compareTo(targetTime) <= 0;
    }

    public static String getCurrentAfter(int minute) {
        Calendar targetTime = Calendar.getInstance();
        targetTime.setTime(new Date());
        targetTime.add(Calendar.MINUTE, minute);
        return format(targetTime.getTime(), DateUtil.FULL_PATTERN);
    }

    /***
     * 获取当前时间
     * @return
     */
    public static String getCurrent() {
        return format(new Date(), DateUtil.SETTLE_PATTERN);
    }

    /**
     * 返回一个ThreadLocal的sdf,每个线程只会new一次sdf
     *
     * @param pattern
     * @return
     */
    private static SimpleDateFormat getSdf(final String pattern) {
        ThreadLocal<SimpleDateFormat> tl = sdfMap.get(pattern);
        // 此处的双重判断和同步是为了防止sdfMap这个单例被多次put重复的sdf
        if (tl == null) {
            synchronized (lockObj) {
                tl = sdfMap.get(pattern);
                if (tl == null) {
                    // 使用ThreadLocal<SimpleDateFormat>替代原来直接new SimpleDateFormat
                    tl = new ThreadLocal<SimpleDateFormat>() {
                        @Override
                        protected SimpleDateFormat initialValue() {
                            return new SimpleDateFormat(pattern);
                        }
                    };
                    sdfMap.put(pattern, tl);
                }
            }
        }

        return tl.get();
    }

    /**
     * 使用线程容器来获取SimpleDateFormat
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        return getSdf(pattern).format(date);
    }

    public static Date parse(String dateStr, String pattern) throws ParseException {
        if (dateStr == null || StringUtils.isEmpty(dateStr) || StringUtils.isBlank(dateStr)) {
            return null;
        }
        return getSdf(pattern).parse(dateStr);
    }

    public static int getNetAge(Date date) {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.setTime(date);
        end.setTime(new Date());
        int result = end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
        int month = (end.get(Calendar.YEAR) - start.get(Calendar.YEAR)) * 12;
        return (Math.abs(month + result) / 12) + 1;
    }
}
