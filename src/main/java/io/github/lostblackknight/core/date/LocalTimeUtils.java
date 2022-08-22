package io.github.lostblackknight.core.date;

import io.github.lostblackknight.core.date.format.DateFormatter;
import io.github.lostblackknight.core.date.format.DateParser;
import io.github.lostblackknight.core.date.format.DatePattern;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static java.lang.Math.*;
import static java.time.LocalTime.MAX;
import static java.time.LocalTime.MIN;
import static java.time.temporal.ChronoField.*;
import static java.time.temporal.ChronoUnit.*;

/**
 * LocalTime 工具类
 *
 * @author chensixiang (chensixiang1234@gmail.com) 2022/8/22 11:06
 * @version 1.0.0
 */
public class LocalTimeUtils extends BaseUtils {

    //region 创建 LocalTime 对象

    /**
     * 创建 {@link LocalTime} 对象
     *
     * @param epochMilli 毫秒
     * @return {@link LocalTime}
     */
    public static LocalTime of(long epochMilli) {
        return LocalTime.from(LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilli), ZoneId.systemDefault()));
    }

    //endregion

    //region 获取指定日期的基本信息

    /**
     * 获取指定日期的小时数，范围为 [0, 23]
     *
     * @param localTime 日期
     * @return 小时
     */
    public static int hourOf24(LocalTime localTime) {
        return localTime.get(HOUR_OF_DAY);
    }

    /**
     * 获取指定日期的小时数，范围为 [0, 11]
     *
     * @param localTime 日期
     * @return 小时
     */
    public static int hourOf12(LocalTime localTime) {
        return localTime.get(HOUR_OF_AMPM);
    }

    /**
     * 获取指定日期的分钟数，范围为 [0, 59]
     *
     * @param localTime 日期
     * @return 分钟
     */
    public static int minute(LocalTime localTime) {
        return localTime.get(MINUTE_OF_HOUR);
    }

    /**
     * 获取指定日期的秒数，范围为 [0, 59]
     *
     * @param localTime 日期
     * @return 秒
     */
    public static int second(LocalTime localTime) {
        return localTime.get(SECOND_OF_MINUTE);
    }

    /**
     * 获取指定日期的毫秒数，范围为 [0, 999]
     *
     * @param localTime 日期
     * @return 毫秒数
     */
    public static int milli(LocalTime localTime) {
        return localTime.get(MILLI_OF_SECOND);
    }

    /**
     * 判断指定日期是否为上午
     *
     * @param localTime 日期
     * @return 是否为上午
     */
    public static boolean isAM(LocalTime localTime) {
        return isAMOrPM(localTime) == 0;
    }

    /**
     * 判断指定日期是否为下午
     *
     * @param localTime 日期
     * @return 是否为上午
     */
    public static boolean isPM(LocalTime localTime) {
        return isAMOrPM(localTime) == 1;
    }

    private static int isAMOrPM(LocalTime localTime) {
        return localTime.get(AMPM_OF_DAY);
    }

    //endregion

    //region 获取当前日期的基本信息

    /**
     * 获取当前日期
     *
     * @return 当前日期
     */
    public static LocalTime current() {
        return LocalTime.now();
    }

    /**
     * 获取当前日期的小时数，范围为 [0, 23]
     *
     * @return 小时
     */
    public static int currentHourOf24() {
        return hourOf24(current());
    }

    /**
     * 获取当前日期的小时数，范围为 [0, 11]
     *
     * @return 小时
     */
    public static int currentHourOf12() {
        return hourOf12(current());
    }

    /**
     * 获取当前日期的小时数，范围为 [0, 11]
     *
     * @return 小时
     */
    public static int currentMinute() {
        return minute(current());
    }

    /**
     * 获取当前日期的分钟数，范围为 [0, 59]
     *
     * @return 分钟
     */
    public static int currentSecond() {
        return second(current());
    }

    /**
     * 获取当前日期的毫秒数，范围为 [0, 999]
     *
     * @return 毫秒数
     */
    public static int currentMilli() {
        return milli(current());
    }

    /**
     * 判断当前日期是否为上午
     *
     * @return 是否为上午
     */
    public static boolean currentIsAM() {
        return isAM(current());
    }

    /**
     * 判断当前日期是否为下午
     *
     * @return 是否为上午
     */
    public static boolean currentIsPM() {
        return isPM(current());
    }

    //endregion

    //region 对指定日期的偏移操作

    /**
     * 将指定日期加上指定的小时数
     *
     * @param localTime 日期
     * @param hours     小时数
     * @return 修改后的日期
     */
    public static LocalTime plusHours(LocalTime localTime, int hours) {
        return localTime.plus(hours, HOURS);
    }

    /**
     * 将指定日期加上指定的分钟数
     *
     * @param localTime 日期
     * @param minutes   分钟数
     * @return 修改后的日期
     */
    public static LocalTime plusMinutes(LocalTime localTime, int minutes) {
        return localTime.plus(minutes, MINUTES);
    }

    /**
     * 将指定日期加上指定的秒数
     *
     * @param localTime 日期
     * @param seconds   秒数
     * @return 修改后的日期
     */
    public static LocalTime plusSeconds(LocalTime localTime, int seconds) {
        return localTime.plus(seconds, SECONDS);
    }

    /**
     * 将指定日期加上指定的毫秒数
     *
     * @param localTime 日期
     * @param millis    毫秒数
     * @return 修改后的日期
     */
    public static LocalTime plusMillis(LocalTime localTime, int millis) {
        return localTime.plus(millis, MILLIS);
    }

    /**
     * 将指定日期减去指定的小时数
     *
     * @param localTime 日期
     * @param hours     小时数
     * @return 修改后的日期
     */
    public static LocalTime minusHours(LocalTime localTime, int hours) {
        return localTime.minus(hours, HOURS);
    }

    /**
     * 将指定日期减去指定的分钟数
     *
     * @param localTime 日期
     * @param minutes   分钟数
     * @return 修改后的日期
     */
    public static LocalTime minusMinutes(LocalTime localTime, int minutes) {
        return localTime.minus(minutes, MINUTES);
    }

    /**
     * 将指定日期减去指定的秒数
     *
     * @param localTime 日期
     * @param seconds   秒数
     * @return 修改后的日期
     */
    public static LocalTime minusSeconds(LocalTime localTime, int seconds) {
        return localTime.minus(seconds, SECONDS);
    }

    /**
     * 将指定日期减去指定的毫秒数
     *
     * @param localTime 日期
     * @param millis    毫秒数
     * @return 修改后的日期
     */
    public static LocalTime minusMillis(LocalTime localTime, int millis) {
        return localTime.minus(millis, MILLIS);
    }

    /**
     * 获取某一天的开始时间
     *
     * @return 日期
     */
    public static LocalTime beginOfDay() {
        return MIN;
    }

    /**
     * 获取某一天的正午时间
     *
     * @return 日期
     */
    public static LocalTime middleOfDay() {
        return LocalTime.NOON;
    }

    /**
     * 获取某一天的结束时间
     *
     * @return 日期
     */
    public static LocalTime endOfDay() {
        return MAX;
    }

    /**
     * 获取某小时的开始时间
     *
     * @param localTime 日期
     * @return 日期
     */
    public static LocalTime beginOfHour(LocalTime localTime) {
        return localTime
                .with(MINUTE_OF_HOUR, MINUTE_OF_HOUR.range().getMinimum())
                .with(SECOND_OF_MINUTE, SECOND_OF_MINUTE.range().getMinimum())
                .with(MILLI_OF_SECOND, MILLI_OF_SECOND.range().getMinimum());
    }

    /**
     * 获取某小时的结束时间
     *
     * @param localTime 日期
     * @return 日期
     */
    public static LocalTime endOfHour(LocalTime localTime) {
        return localTime
                .with(MINUTE_OF_HOUR, MINUTE_OF_HOUR.range().getMaximum())
                .with(SECOND_OF_MINUTE, SECOND_OF_MINUTE.range().getMaximum())
                .with(MILLI_OF_SECOND, MILLI_OF_SECOND.range().getMaximum());
    }

    /**
     * 获取某分钟的开始时间
     *
     * @param localTime 日期
     * @return 日期
     */
    public static LocalTime beginOfMinute(LocalTime localTime) {
        return localTime
                .with(SECOND_OF_MINUTE, SECOND_OF_MINUTE.range().getMinimum())
                .with(MILLI_OF_SECOND, MILLI_OF_SECOND.range().getMinimum());
    }

    /**
     * 获取某小时的结束时间
     *
     * @param localTime 日期
     * @return 日期
     */
    public static LocalTime endOfMinute(LocalTime localTime) {
        return localTime
                .with(SECOND_OF_MINUTE, SECOND_OF_MINUTE.range().getMaximum())
                .with(MILLI_OF_SECOND, MILLI_OF_SECOND.range().getMaximum());
    }

    /**
     * 获取某秒的开始时间
     *
     * @param localTime 日期
     * @return 日期
     */
    public static LocalTime beginOfSecond(LocalTime localTime) {
        return localTime
                .with(MILLI_OF_SECOND, MILLI_OF_SECOND.range().getMinimum());
    }

    /**
     * 获取某秒的结束时间
     *
     * @param localTime 日期
     * @return 日期
     */
    public static LocalTime endOfSecond(LocalTime localTime) {
        return localTime
                .with(MILLI_OF_SECOND, MILLI_OF_SECOND.range().getMaximum());
    }

    //endregion

    //region 多个日期之间的操作

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @param isAbs 是否是绝对值
     * @return 时间量
     */
    public static long betweenHours(LocalTime begin, LocalTime end, boolean isAbs) {
        return isAbs ? abs(begin.until(end, HOURS)) : begin.until(end, HOURS);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @param isAbs 是否是绝对值
     * @return 时间量
     */
    public static long betweenMinutes(LocalTime begin, LocalTime end, boolean isAbs) {
        return isAbs ? abs(begin.until(end, MINUTES)) : begin.until(end, MINUTES);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @param isAbs 是否是绝对值
     * @return 时间量
     */
    public static long betweenSeconds(LocalTime begin, LocalTime end, boolean isAbs) {
        return isAbs ? abs(begin.until(end, SECONDS)) : begin.until(end, SECONDS);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @param isAbs 是否是绝对值
     * @return 时间量
     */
    public static long betweenMillis(LocalTime begin, LocalTime end, boolean isAbs) {
        return isAbs ? abs(begin.until(end, MILLIS)) : begin.until(end, MILLIS);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量的绝对值 (|end -begin|)
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @return 时间量的绝对值
     */
    public static long betweenHours(LocalTime begin, LocalTime end) {
        return betweenHours(begin, end, true);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量的绝对值 (|end -begin|)
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @return 时间量的绝对值
     */
    public static long betweenMinutes(LocalTime begin, LocalTime end) {
        return betweenMinutes(begin, end, true);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量的绝对值 (|end -begin|)
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @return 时间量的绝对值
     */
    public static long betweenSeconds(LocalTime begin, LocalTime end) {
        return betweenSeconds(begin, end, true);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量的绝对值 (|end -begin|)
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @return 时间量绝对值
     */
    public static long betweenMillis(LocalTime begin, LocalTime end) {
        return betweenMillis(begin, end, true);
    }

    /**
     * 两个日期作比较
     *
     * @param first  第一个
     * @param second 第二个
     * @return 第一个小于第二个，返回 -1；第一个等于第二个返回 0；第一个大于第二个， 返回 1。
     */
    public static int compare(LocalTime first, LocalTime second) {
        return first.compareTo(second);
    }

    /**
     * 判断第一个日期是不是在第二个日期之后
     *
     * @param first  第一个
     * @param second 第二个
     * @return 第一个日期是不是在第二个日期之后
     */
    public static boolean isAfter(LocalTime first, LocalTime second) {
        return first.isAfter(second);
    }

    /**
     * 判断第一个日期是不是在第二个日期之前
     *
     * @param first  第一个
     * @param second 第二个
     * @return 第一个日期是不是在第二个日期之前
     */
    public static boolean isBefore(LocalTime first, LocalTime second) {
        return first.isBefore(second);
    }

    /**
     * 判断第一个日期是不是和第二个日期相等
     *
     * @param first  第一个
     * @param second 第二个
     * @return 第一个日期是不是和第二个日期相等
     */
    public static boolean isEqual(LocalTime first, LocalTime second) {
        return first.equals(second);
    }

    /**
     * 判断两个日期是否是同一小时
     *
     * @param first  第一个
     * @param second 第二个
     * @return 两个日期是否是同一小时
     */
    public static boolean isEqualHour(LocalTime first, LocalTime second) {
        return first.get(HOUR_OF_DAY) == second.get(HOUR_OF_DAY);
    }

    /**
     * 判断两个日期是否是同一分钟
     *
     * @param first  第一个
     * @param second 第二个
     * @return 两个日期是否是同一分钟
     */
    public static boolean isEqualMinute(LocalTime first, LocalTime second) {
        return first.get(MINUTE_OF_HOUR) == second.get(MINUTE_OF_HOUR);
    }

    /**
     * 判断两个日期是否是同一秒
     *
     * @param first  第一个
     * @param second 第二个
     * @return 两个日期是否是同一秒
     */
    public static boolean isEqualSecond(LocalTime first, LocalTime second) {
        return first.get(SECOND_OF_MINUTE) == second.get(SECOND_OF_MINUTE);
    }

    /**
     * 判断两个日期是否是同一毫秒
     *
     * @param first  第一个
     * @param second 第二个
     * @return 两个日期是否是同一毫秒
     */
    public static boolean isEqualMilli(LocalTime first, LocalTime second) {
        return first.get(MILLI_OF_SECOND) == second.get(MILLI_OF_SECOND);
    }

    /**
     * 判断指定日期是否在指定的范围内
     *
     * @param localTime 日期
     * @param begin     开始日期 (包含)
     * @param end       结束日期 (包含)
     * @return 是否在指定的范围内
     */
    public static boolean isIn(LocalTime localTime, LocalTime begin, LocalTime end) {
        final long beginEpochMilli = toEpochMilli(begin);
        final long endEpochMilli = toEpochMilli(end);
        final long epochMilli = toEpochMilli(localTime);
        return epochMilli >= min(beginEpochMilli, endEpochMilli) && epochMilli <= max(beginEpochMilli, endEpochMilli);
    }

    /**
     * 判断两个日期范围是否有交集
     * <pre>
     *                 fb       fe
     *                  ---------
     *                  | first |
     *                  ---------
     *                          sb      se
     *                          --------
     *                          |second|
     *                          --------
     *          sb      se
     *          --------
     *          |second|
     *          --------
     * 无交集：sb > fe || se < fb
     * 有交集：sb <= fe && se >= fb
     *
     * @param firstBegin  第一个开始
     * @param firstEnd    第一个结束
     * @param secondBegin 第二个开始
     * @param secondEnd   第二个结束
     * @return 两个日期范围是否有交集
     */
    public static boolean isOverlap(LocalTime firstBegin, LocalTime firstEnd,
                                    LocalTime secondBegin, LocalTime secondEnd) {
        return (secondBegin.compareTo(firstEnd) <= 0) && (secondEnd.compareTo(firstBegin) >= 0);
    }

    //endregion

    //region 日期格式化

    /**
     * 格式化日期时间
     *
     * @param localTime 日期
     * @param pattern   格式
     * @return 格式化后的字符串
     * @see DatePattern
     */
    public static String format(LocalTime localTime, String pattern) {
        return DateFormatter.ofPattern(pattern).format(localTime);
    }

    /**
     * 格式化日期时间
     *
     * @param localTime   日期
     * @param datePattern 格式
     * @return 格式化后的字符串
     * @see DatePattern
     */
    public static String format(LocalTime localTime, DatePattern datePattern) {
        return DateFormatter.ofDatePattern(datePattern).format(localTime);
    }

    /**
     * 格式化日期时间
     *
     * @param localTime         日期
     * @param dateTimeFormatter {@link DateTimeFormatter}
     * @return 格式化后的字符串
     */
    public static String format(LocalTime localTime, DateTimeFormatter dateTimeFormatter) {
        return dateTimeFormatter.format(localTime);
    }

    /**
     * 格式化时间
     * <p>格式：HH:mm:ss
     *
     * @param localTime 日期
     * @return 格式化后的字符串
     */
    public static String format(LocalTime localTime) {
        return DateFormatter.NORMAL_TIME.format(localTime);
    }

    /**
     * 格式化时间
     * <p>格式：HHmmss
     *
     * @param localTime 日期
     * @return 格式化后的字符串
     */
    public static String formatOfSimple(LocalTime localTime) {
        return DateFormatter.SIMPLE_TIME.format(localTime);
    }

    /**
     * 格式化时间
     * <p>格式：HH时mm分ss秒
     *
     * @param localTime 日期
     * @return 格式化后的字符串
     */
    public static String formatOfChinese(LocalTime localTime) {
        return DateFormatter.CHINESE_TIME.format(localTime);
    }

    //endregion

    //region 日期解析

    /**
     * 解析时间
     *
     * @param text    文本
     * @param pattern 格式
     * @return {@link LocalTime}
     * @see DatePattern
     */
    public static LocalTime parse(CharSequence text, String pattern) {
        return DateParser.parseLocalTime(text, DateFormatter.ofPattern(pattern));
    }

    /**
     * 解析时间
     *
     * @param text        文本
     * @param datePattern 格式
     * @return {@link LocalTime}
     * @see DatePattern
     */
    public static LocalTime parse(CharSequence text, DatePattern datePattern) {
        return DateParser.parseLocalTime(text, DateFormatter.ofDatePattern(datePattern));
    }

    /**
     * 解析时间
     *
     * @param text              文本
     * @param dateTimeFormatter {@link DateTimeFormatter}
     * @return {@link LocalTime}
     */
    public static LocalTime parse(CharSequence text, DateTimeFormatter dateTimeFormatter) {
        return DateParser.parseLocalTime(text, dateTimeFormatter);
    }

    /**
     * 解析时间
     * <p>格式：HH:mm:ss
     *
     * @param text 文本
     * @return {@link LocalTime}
     */
    public static LocalTime parse(CharSequence text) {
        return DateParser.parseLocalTime(text, DateFormatter.NORMAL_TIME);
    }

    /**
     * 解析时间
     * <p>格式：HHmmss
     *
     * @param text 文本
     * @return {@link LocalTime}
     */
    public static LocalTime parseOfSimple(CharSequence text) {
        return DateParser.parseLocalTime(text, DateFormatter.SIMPLE_TIME);
    }

    /**
     * 解析时间
     * <p>格式：HH时mm分ss秒
     *
     * @param text 文本
     * @return {@link LocalTime}
     */
    public static LocalTime parseOfChinese(CharSequence text) {
        return DateParser.parseLocalTime(text, DateFormatter.CHINESE_TIME);
    }

    //endregion
}
