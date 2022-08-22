package io.github.lostblackknight.core.date;

import java.time.*;
import java.util.Date;

import static java.time.Instant.EPOCH;

/**
 * 日期基本工具类
 *
 * @author chensixiang (chensixiang1234@gmail.com) 2022/8/20 9:46
 * @version 1.0.0
 */
abstract class BaseUtils {

    //region 获取基本信息

    /**
     * 判断指定年份是否为闰年
     *
     * @param year 年份
     * @return 是否为闰年
     */
    public static boolean isLeapYear(int year) {
        return Year.isLeap(year);
    }

    /**
     * 获取年份的总天数
     *
     * @param year 年
     * @return 总天数
     */
    public static int lengthOfYear(int year) {
        return Year.of(year).length();
    }

    /**
     * 获取月份的总天数
     *
     * @param month        月
     * @param isLeaperYear 是否为闰年
     * @return 总天数
     */
    public static int lengthOfMonth(int month, boolean isLeaperYear) {
        return Month.of(month).length(isLeaperYear);
    }

    //endregion

    //region 日期之间的转化

    /**
     * 转换成 {@link Date} 类型
     *
     * @param localDate {@link LocalDate}
     * @return {@link Date}
     */
    public static Date toDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 转换成 {@link Date} 类型
     *
     * @param localTime {@link LocalTime}
     * @return {@link Date}
     */
    public static Date toDate(LocalTime localTime) {
        return Date.from(localTime.atDate(EPOCH.atZone(ZoneId.systemDefault()).toLocalDate()).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 转换成 {@link Date} 类型
     *
     * @param localDateTime {@link LocalDateTime}
     * @return {@link Date}
     */
    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 转换成 {@link LocalDate} 类型
     *
     * @param date {@link Date}
     * @return {@link LocalDate}
     */
    public static LocalDate toLocalDate(Date date) {
        return LocalDate.from(date.toInstant().atZone(ZoneId.systemDefault()));
    }

    /**
     * 转换成 {@link LocalDate} 类型
     *
     * @param localTime {@link LocalTime}
     * @return {@link LocalDate}
     */
    public static LocalDate toLocalDate(LocalTime localTime) {
        return LocalDate.from(localTime.atDate(EPOCH.atZone(ZoneId.systemDefault()).toLocalDate()));
    }

    /**
     * 转换成 {@link LocalDate} 类型
     *
     * @param localDateTime {@link LocalDateTime}
     * @return {@link LocalDate}
     */
    public static LocalDate toLocalDate(LocalDateTime localDateTime) {
        return LocalDate.from(localDateTime);
    }

    /**
     * 转换成 {@link LocalTime} 类型
     *
     * @param date {@link Date}
     * @return {@link LocalTime}
     */
    public static LocalTime toLocalTime(Date date) {
        return LocalTime.from(date.toInstant().atZone(ZoneId.systemDefault()));
    }

    /**
     * 转换成 {@link LocalTime} 类型
     *
     * @param localDate {@link LocalDate}
     * @return {@link LocalTime}
     */
    public static LocalTime toLocalTime(LocalDate localDate) {
        return localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toLocalTime();
    }

    /**
     * 转换成 {@link LocalTime} 类型
     *
     * @param localDateTime {@link LocalDateTime}
     * @return {@link LocalTime}
     */
    public static LocalTime toLocalTime(LocalDateTime localDateTime) {
        return localDateTime.toLocalTime();
    }

    /**
     * 转换成 {@link LocalDateTime} 类型
     *
     * @param date {@link Date}
     * @return {@link LocalDateTime}
     */
    public static LocalDateTime toLocalDateTime(Date date) {
        return LocalDateTime.from(date.toInstant().atZone(ZoneId.systemDefault()));
    }

    /**
     * 转换成 {@link LocalDateTime} 类型
     *
     * @param localDate {@link LocalDate}
     * @return {@link LocalDateTime}
     */
    public static LocalDateTime toLocalDateTime(LocalDate localDate) {
        return LocalDateTime.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()));
    }

    /**
     * 转换成 {@link LocalDateTime} 类型
     *
     * @param localTime {@link LocalTime}
     * @return {@link LocalDateTime}
     */
    public static LocalDateTime toLocalDateTime(LocalTime localTime) {
        return LocalDateTime.from(localTime.atDate(EPOCH.atZone(ZoneId.systemDefault()).toLocalDate()));
    }

    /**
     * 转换成毫秒
     *
     * @param date {@link Date}
     * @return 毫秒
     */
    public static long toEpochMilli(Date date) {
        return date.toInstant().toEpochMilli();
    }

    /**
     * 转换成毫秒
     *
     * @param localDate {@link LocalDate}
     * @return 毫秒
     */
    public static long toEpochMilli(LocalDate localDate) {
        return localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 转换成毫秒
     *
     * @param localTime {@link LocalTime}
     * @return 毫秒
     */
    public static long toEpochMilli(LocalTime localTime) {
        return localTime.atDate(EPOCH.atZone(ZoneId.systemDefault()).toLocalDate()).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 转换成毫秒
     *
     * @param localDateTime {@link LocalDateTime}
     * @return 毫秒
     */
    public static long toEpochMilli(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    //endregion
}
