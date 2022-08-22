package io.github.lostblackknight.core.date;

import io.github.lostblackknight.core.date.format.DateFormatter;
import io.github.lostblackknight.core.date.format.DateParser;
import io.github.lostblackknight.core.date.format.DatePattern;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;

import static java.lang.Math.*;
import static java.time.DayOfWeek.*;
import static java.time.LocalTime.MAX;
import static java.time.LocalTime.MIN;
import static java.time.temporal.ChronoField.*;
import static java.time.temporal.ChronoUnit.*;
import static java.time.temporal.TemporalAdjusters.*;

/**
 * LocalDateTime 工具类
 *
 * @author chensixiang (chensixiang1234@gmail.com) 2022/8/19 21:45
 * @version 1.0.0
 */
public abstract class LocalDateTimeUtils extends BaseUtils {

    //region 创建 LocalDateTime 对象

    /**
     * 创建 {@link LocalDateTime} 对象
     *
     * @param epochMilli 毫秒
     * @return {@link LocalDateTime}
     */
    public static LocalDateTime of(long epochMilli) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilli), ZoneId.systemDefault());
    }

    //endregion

    //region 获取指定日期的基本信息

    /**
     * 获取指定日期所在的年份
     *
     * @param localDateTime 日期
     * @return 年份
     */
    public static int year(LocalDateTime localDateTime) {
        return localDateTime.get(YEAR);
    }

    /**
     * 获取指定日期所在的月份，范围为 [1, 12]
     *
     * @param localDateTime 日期
     * @return 月份
     */
    public static int month(LocalDateTime localDateTime) {
        return localDateTime.get(MONTH_OF_YEAR);
    }

    /**
     * 获取指定日期是所在年份的第几周，范围为 [1, 53]
     *
     * @param localDateTime 日期
     * @return 周
     */
    public static int weekOfYear(LocalDateTime localDateTime) {
        return localDateTime.get(WeekFields.of(MONDAY, 1).weekOfYear());
    }

    /**
     * 获取指定日期是所在年份的第几天，范围为 [1, 366]
     *
     * @param localDateTime 日期
     * @return 天
     */
    public static int dayOfYear(LocalDateTime localDateTime) {
        return localDateTime.get(DAY_OF_YEAR);
    }

    /**
     * 获取指定日期是所在月份的第几周，范围为 [1, 5]
     *
     * @param localDateTime 日期
     * @return 周
     */
    public static int weekOfMonth(LocalDateTime localDateTime) {
        return localDateTime.get(WeekFields.of(MONDAY, 1).weekOfMonth());
    }

    /**
     * 获取指定日期是所在月份的第几天，范围为 [1, 31]
     *
     * @param localDateTime 日期
     * @return 天
     */
    public static int dayOfMonth(LocalDateTime localDateTime) {
        return localDateTime.get(DAY_OF_MONTH);
    }

    /**
     * 获取指定日期是所在星期的第几天，范围为 [1, 7]
     *
     * @param localDateTime 日期
     * @return 天
     */
    public static int dayOfWeek(LocalDateTime localDateTime) {
        return localDateTime.get(DAY_OF_WEEK);
    }

    /**
     * 获取指定日期的小时数，范围为 [0, 23]
     *
     * @param localDateTime 日期
     * @return 小时
     */
    public static int hourOf24(LocalDateTime localDateTime) {
        return localDateTime.get(HOUR_OF_DAY);
    }

    /**
     * 获取指定日期的小时数，范围为 [0, 11]
     *
     * @param localDateTime 日期
     * @return 小时
     */
    public static int hourOf12(LocalDateTime localDateTime) {
        return localDateTime.get(HOUR_OF_AMPM);
    }

    /**
     * 获取指定日期的分钟数，范围为 [0, 59]
     *
     * @param localDateTime 日期
     * @return 分钟
     */
    public static int minute(LocalDateTime localDateTime) {
        return localDateTime.get(MINUTE_OF_HOUR);
    }

    /**
     * 获取指定日期的秒数，范围为 [0, 59]
     *
     * @param localDateTime 日期
     * @return 秒
     */
    public static int second(LocalDateTime localDateTime) {
        return localDateTime.get(SECOND_OF_MINUTE);
    }

    /**
     * 获取指定日期的毫秒数，范围为 [0, 999]
     *
     * @param localDateTime 日期
     * @return 毫秒数
     */
    public static int milli(LocalDateTime localDateTime) {
        return localDateTime.get(MILLI_OF_SECOND);
    }

    /**
     * 判断指定日期是否为闰年
     *
     * @param localDateTime 日期
     * @return 是否为闰年
     */
    public static boolean isLeapYear(LocalDateTime localDateTime) {
        return isLeapYear(year(localDateTime));
    }

    /**
     * 判断指定日期是否为周末
     *
     * @param localDateTime 日期
     * @return 是否为周末 (周六、 周日)
     */
    public static boolean isWeekend(LocalDateTime localDateTime) {
        return localDateTime.getDayOfWeek().equals(SATURDAY)
                || localDateTime.getDayOfWeek().equals(SUNDAY);
    }

    /**
     * 判断指定日期是否为上午
     *
     * @param localDateTime 日期
     * @return 是否为上午
     */
    public static boolean isAM(LocalDateTime localDateTime) {
        return isAMOrPM(localDateTime) == 0;
    }

    /**
     * 判断指定日期是否为下午
     *
     * @param localDateTime 日期
     * @return 是否为上午
     */
    public static boolean isPM(LocalDateTime localDateTime) {
        return isAMOrPM(localDateTime) == 1;
    }

    private static int isAMOrPM(LocalDateTime localDateTime) {
        return localDateTime.get(AMPM_OF_DAY);
    }

    /**
     * 获取指定日期的年的总天数
     *
     * @param localDateTime 日期
     * @return 天
     */
    public static int lengthOfYear(LocalDateTime localDateTime) {
        return lengthOfYear(year(localDateTime));
    }

    /**
     * 获取指定日期的月的总天数
     *
     * @param localDateTime 日期
     * @return 天
     */
    public static int lengthOfMonth(LocalDateTime localDateTime) {
        return lengthOfMonth(month(localDateTime), isLeapYear(localDateTime));
    }

    //endregion

    //region 获取当前日期的基本信息

    /**
     * 获取当前日期
     *
     * @return 当前日期
     */
    public static LocalDateTime current() {
        return LocalDateTime.now();
    }

    /**
     * 获取当前日期所在的年份
     *
     * @return 年份
     */
    public static int currentYear() {
        return year(current());
    }

    /**
     * 获取当前日期所在的月份，范围为 [1, 12]
     *
     * @return 月份
     */
    public static int currentMonth() {
        return month(current());
    }

    /**
     * 获取当前日期是所在年份的第几周，范围为 [1, 53]
     *
     * @return 周
     */
    public static int currentWeekOfYear() {
        return weekOfYear(current());
    }

    /**
     * 获取当前日期是所在年份的第几天，范围为 [1, 366]
     *
     * @return 天
     */
    public static int currentDayOfYear() {
        return dayOfYear(current());
    }

    /**
     * 获取当前日期是所在月份的第几周，范围为 [1, 5]
     *
     * @return 周
     */
    public static int currentWeekOfMonth() {
        return weekOfMonth(current());
    }

    /**
     * 获取当前日期是所在月份的第几天，范围为 [1, 31]
     *
     * @return 天
     */
    public static int currentDayOfMonth() {
        return dayOfMonth(current());
    }

    /**
     * 获取当前日期是所在星期的第几天，范围为 [1, 7]
     *
     * @return 天
     */
    public static int currentDayOfWeek() {
        return dayOfWeek(current());
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
     * 判断当前日期是否为闰年
     *
     * @return 是否为闰年
     */
    public static boolean currentIsLeapYear() {
        return isLeapYear(current());
    }

    /**
     * 判断当前日期是否为周末
     *
     * @return 是否为周末 (周六、 周日)
     */
    public static boolean currentIsWeekend() {
        return isWeekend(current());
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

    /**
     * 获取当前年的总天数
     *
     * @return 天
     */
    public static int currentLengthOfYear() {
        return lengthOfYear(currentYear());
    }

    /**
     * 获取当前月的总天数
     *
     * @return 天
     */
    public static int currentLengthOfMonth() {
        return lengthOfMonth(currentMonth(), isLeapYear(current()));
    }

    //endregion

    //region 对指定日期的偏移操作

    /**
     * 将指定日期加上指定的年数
     *
     * @param localDateTime 日期
     * @param years         年数
     * @return 修改后的日期
     */
    public static LocalDateTime plusYears(LocalDateTime localDateTime, int years) {
        return localDateTime.plus(years, YEARS);
    }

    /**
     * 将指定日期加上指定的月数
     *
     * @param localDateTime 日期
     * @param months        月数
     * @return 修改后的日期
     */
    public static LocalDateTime plusMonths(LocalDateTime localDateTime, int months) {
        return localDateTime.plus(months, MONTHS);
    }

    /**
     * 将指定日期加上指定的星期数
     *
     * @param localDateTime 日期
     * @param weeks         星期数
     * @return 修改后的日期
     */
    public static LocalDateTime plusWeeks(LocalDateTime localDateTime, int weeks) {
        return localDateTime.plus(weeks, WEEKS);
    }

    /**
     * 将指定日期加上指定的天数
     *
     * @param localDateTime 日期
     * @param days          天数
     * @return 修改后的日期
     */
    public static LocalDateTime plusDays(LocalDateTime localDateTime, int days) {
        return localDateTime.plus(days, DAYS);
    }

    /**
     * 将指定日期加上指定的小时数
     *
     * @param localDateTime 日期
     * @param hours         小时数
     * @return 修改后的日期
     */
    public static LocalDateTime plusHours(LocalDateTime localDateTime, int hours) {
        return localDateTime.plus(hours, HOURS);
    }

    /**
     * 将指定日期加上指定的分钟数
     *
     * @param localDateTime 日期
     * @param minutes       分钟数
     * @return 修改后的日期
     */
    public static LocalDateTime plusMinutes(LocalDateTime localDateTime, int minutes) {
        return localDateTime.plus(minutes, MINUTES);
    }

    /**
     * 将指定日期加上指定的秒数
     *
     * @param localDateTime 日期
     * @param seconds       秒数
     * @return 修改后的日期
     */
    public static LocalDateTime plusSeconds(LocalDateTime localDateTime, int seconds) {
        return localDateTime.plus(seconds, SECONDS);
    }

    /**
     * 将指定日期加上指定的毫秒数
     *
     * @param localDateTime 日期
     * @param millis        毫秒数
     * @return 修改后的日期
     */
    public static LocalDateTime plusMillis(LocalDateTime localDateTime, int millis) {
        return localDateTime.plus(millis, MILLIS);
    }

    /**
     * 将指定日期减去指定的年数
     *
     * @param localDateTime 日期
     * @param years         年数
     * @return 修改后的日期
     */
    public static LocalDateTime minusYears(LocalDateTime localDateTime, int years) {
        return localDateTime.minus(years, YEARS);
    }

    /**
     * 将指定日期减去指定的月数
     *
     * @param localDateTime 日期
     * @param months        月数
     * @return 修改后的日期
     */
    public static LocalDateTime minusMonths(LocalDateTime localDateTime, int months) {
        return localDateTime.minus(months, MONTHS);
    }

    /**
     * 将指定日期减去指定的星期数
     *
     * @param localDateTime 日期
     * @param weeks         星期数
     * @return 修改后的日期
     */
    public static LocalDateTime minusWeeks(LocalDateTime localDateTime, int weeks) {
        return localDateTime.minus(weeks, WEEKS);
    }

    /**
     * 将指定日期减去指定的天数
     *
     * @param localDateTime 日期
     * @param days          天数
     * @return 修改后的日期
     */
    public static LocalDateTime minusDays(LocalDateTime localDateTime, int days) {
        return localDateTime.minus(days, DAYS);
    }

    /**
     * 将指定日期减去指定的小时数
     *
     * @param localDateTime 日期
     * @param hours         小时数
     * @return 修改后的日期
     */
    public static LocalDateTime minusHours(LocalDateTime localDateTime, int hours) {
        return localDateTime.minus(hours, HOURS);
    }

    /**
     * 将指定日期减去指定的分钟数
     *
     * @param localDateTime 日期
     * @param minutes       分钟数
     * @return 修改后的日期
     */
    public static LocalDateTime minusMinutes(LocalDateTime localDateTime, int minutes) {
        return localDateTime.minus(minutes, MINUTES);
    }

    /**
     * 将指定日期减去指定的秒数
     *
     * @param localDateTime 日期
     * @param seconds       秒数
     * @return 修改后的日期
     */
    public static LocalDateTime minusSeconds(LocalDateTime localDateTime, int seconds) {
        return localDateTime.minus(seconds, SECONDS);
    }

    /**
     * 将指定日期减去指定的毫秒数
     *
     * @param localDateTime 日期
     * @param millis        毫秒数
     * @return 修改后的日期
     */
    public static LocalDateTime minusMillis(LocalDateTime localDateTime, int millis) {
        return localDateTime.minus(millis, MILLIS);
    }

    /**
     * 获取某年的第一天
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime beginOfYear(LocalDateTime localDateTime) {
        return localDateTime.with(firstDayOfYear());
    }

    /**
     * 获取某年的最后一天
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime endOfYear(LocalDateTime localDateTime) {
        return localDateTime.with(lastDayOfYear());
    }

    /**
     * 获取下一年的第一天
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime beginOfNextYear(LocalDateTime localDateTime) {
        return localDateTime.plus(1, YEARS).with(firstDayOfYear());
    }

    /**
     * 获取下一年的最后一天
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime endOfNextYear(LocalDateTime localDateTime) {
        return localDateTime.plus(1, YEARS).with(lastDayOfYear());
    }

    /**
     * 获取上一年的第一天
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime beginOfPrevYear(LocalDateTime localDateTime) {
        return localDateTime.minus(1, YEARS).with(firstDayOfYear());
    }

    /**
     * 获取上一年的最后一天
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime endOfPrevYear(LocalDateTime localDateTime) {
        return localDateTime.minus(1, YEARS).with(lastDayOfYear());
    }

    /**
     * 获取某月的第一天
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime beginOfMonth(LocalDateTime localDateTime) {
        return localDateTime.with(firstDayOfMonth());
    }

    /**
     * 获取某月的最后一天
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime endOfMonth(LocalDateTime localDateTime) {
        return localDateTime.with(lastDayOfMonth());
    }

    /**
     * 获取下个月的第一天
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime beginOfNextMonth(LocalDateTime localDateTime) {
        return localDateTime.plus(1, MONTHS).with(firstDayOfMonth());
    }

    /**
     * 获取下个月的最后一天
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime endOfNextMonth(LocalDateTime localDateTime) {
        return localDateTime.plus(1, MONTHS).with(lastDayOfMonth());
    }

    /**
     * 获取上个月的第一天
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime beginOfPrevMonth(LocalDateTime localDateTime) {
        return localDateTime.minus(1, MONTHS).with(firstDayOfMonth());
    }

    /**
     * 获取上个月的最后一天
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime endOfPrevMonth(LocalDateTime localDateTime) {
        return localDateTime.minus(1, MONTHS).with(lastDayOfMonth());
    }

    /**
     * 获取某周的第一天，默认第一天为周一
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime beginOfWeek(LocalDateTime localDateTime) {
        return localDateTime.with(MONDAY);
    }

    /**
     * 获取某周的最后一天，默认最后一天为周日
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime endOfWeek(LocalDateTime localDateTime) {
        return localDateTime.with(SUNDAY);
    }

    /**
     * 获取下一周的第一天，默认第一天为周一
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime beginOfNextWeek(LocalDateTime localDateTime) {
        return localDateTime.plus(1, WEEKS).with(MONDAY);
    }

    /**
     * 获取下一周的最后一天，默认最后一天为周日
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime endOfNextWeek(LocalDateTime localDateTime) {
        return localDateTime.plus(1, WEEKS).with(SUNDAY);
    }

    /**
     * 获取上一周的第一天，默认第一天为周一
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime beginOfPrevWeek(LocalDateTime localDateTime) {
        return localDateTime.minus(1, WEEKS).with(MONDAY);
    }

    /**
     * 获取上一周的最后一天，默认最后一天为周日
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime endOfPrevWeek(LocalDateTime localDateTime) {
        return localDateTime.minus(1, WEEKS).with(SUNDAY);
    }

    /**
     * 获取某一天的开始时间
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime beginOfDay(LocalDateTime localDateTime) {
        return LocalDateTime.of(localDateTime.toLocalDate(), MIN);
    }

    /**
     * 获取某一天的结束时间
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime endOfDay(LocalDateTime localDateTime) {
        return LocalDateTime.of(localDateTime.toLocalDate(), MAX);
    }

    /**
     * 获取下一天的开始时间
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime beginOfNextDay(LocalDateTime localDateTime) {
        return LocalDateTime.of(localDateTime.toLocalDate().plus(1, DAYS), MIN);
    }

    /**
     * 获取下一天的结束时间
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime endOfNextDay(LocalDateTime localDateTime) {
        return LocalDateTime.of(localDateTime.toLocalDate().plus(1, DAYS), MAX);
    }

    /**
     * 获取上一天的开始时间
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime beginOfPrevDay(LocalDateTime localDateTime) {
        return LocalDateTime.of(localDateTime.toLocalDate().minus(1, DAYS), MIN);
    }

    /**
     * 获取上一天的结束时间
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime endOfPrevDay(LocalDateTime localDateTime) {
        return LocalDateTime.of(localDateTime.toLocalDate().minus(1, DAYS), MAX);
    }

    /**
     * 获取某小时的开始时间
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime beginOfHour(LocalDateTime localDateTime) {
        return LocalDateTime.of(localDateTime.toLocalDate(), localDateTime.toLocalTime()
                .with(MINUTE_OF_HOUR, MINUTE_OF_HOUR.range().getMinimum())
                .with(SECOND_OF_MINUTE, SECOND_OF_MINUTE.range().getMinimum())
                .with(MILLI_OF_SECOND, MILLI_OF_SECOND.range().getMinimum()));
    }

    /**
     * 获取某小时的结束时间
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime endOfHour(LocalDateTime localDateTime) {
        return LocalDateTime.of(localDateTime.toLocalDate(), localDateTime.toLocalTime()
                .with(MINUTE_OF_HOUR, MINUTE_OF_HOUR.range().getMaximum())
                .with(SECOND_OF_MINUTE, SECOND_OF_MINUTE.range().getMaximum())
                .with(MILLI_OF_SECOND, MILLI_OF_SECOND.range().getMaximum()));
    }

    /**
     * 获取某分钟的开始时间
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime beginOfMinute(LocalDateTime localDateTime) {
        return LocalDateTime.of(localDateTime.toLocalDate(), localDateTime.toLocalTime()
                .with(SECOND_OF_MINUTE, SECOND_OF_MINUTE.range().getMinimum())
                .with(MILLI_OF_SECOND, MILLI_OF_SECOND.range().getMinimum()));
    }

    /**
     * 获取某小时的结束时间
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime endOfMinute(LocalDateTime localDateTime) {
        return LocalDateTime.of(localDateTime.toLocalDate(), localDateTime.toLocalTime()
                .with(SECOND_OF_MINUTE, SECOND_OF_MINUTE.range().getMaximum())
                .with(MILLI_OF_SECOND, MILLI_OF_SECOND.range().getMaximum()));
    }

    /**
     * 获取某秒的开始时间
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime beginOfSecond(LocalDateTime localDateTime) {
        return LocalDateTime.of(localDateTime.toLocalDate(), localDateTime.toLocalTime()
                .with(MILLI_OF_SECOND, MILLI_OF_SECOND.range().getMinimum()));
    }

    /**
     * 获取某秒的结束时间
     *
     * @param localDateTime 日期
     * @return 日期
     */
    public static LocalDateTime endOfSecond(LocalDateTime localDateTime) {
        return LocalDateTime.of(localDateTime.toLocalDate(), localDateTime.toLocalTime()
                .with(MILLI_OF_SECOND, MILLI_OF_SECOND.range().getMaximum()));
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
    public static long betweenYears(LocalDateTime begin, LocalDateTime end, boolean isAbs) {
        return isAbs ? abs(begin.until(end, YEARS)) : begin.until(end, YEARS);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @param isAbs 是否是绝对值
     * @return 时间量
     */
    public static long betweenMonths(LocalDateTime begin, LocalDateTime end, boolean isAbs) {
        return isAbs ? abs(begin.until(end, MONTHS)) : begin.until(end, MONTHS);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @param isAbs 是否是绝对值
     * @return 时间量
     */
    public static long betweenWeeks(LocalDateTime begin, LocalDateTime end, boolean isAbs) {
        return isAbs ? abs(begin.until(end, WEEKS)) : begin.until(end, WEEKS);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @param isAbs 是否是绝对值
     * @return 时间量
     */
    public static long betweenDays(LocalDateTime begin, LocalDateTime end, boolean isAbs) {
        return isAbs ? abs(begin.until(end, DAYS)) : begin.until(end, DAYS);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @param isAbs 是否是绝对值
     * @return 时间量
     */
    public static long betweenHours(LocalDateTime begin, LocalDateTime end, boolean isAbs) {
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
    public static long betweenMinutes(LocalDateTime begin, LocalDateTime end, boolean isAbs) {
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
    public static long betweenSeconds(LocalDateTime begin, LocalDateTime end, boolean isAbs) {
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
    public static long betweenMillis(LocalDateTime begin, LocalDateTime end, boolean isAbs) {
        return isAbs ? abs(begin.until(end, MILLIS)) : begin.until(end, MILLIS);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量的绝对值 (|end -begin|)
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @return 时间量的绝对值
     */
    public static long betweenYears(LocalDateTime begin, LocalDateTime end) {
        return betweenYears(begin, end, true);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量的绝对值 (|end -begin|)
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @return 时间量的绝对值
     */
    public static long betweenMonths(LocalDateTime begin, LocalDateTime end) {
        return betweenMonths(begin, end, true);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量的绝对值 (|end -begin|)
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @return 时间量的绝对值
     */
    public static long betweenWeeks(LocalDateTime begin, LocalDateTime end) {
        return betweenWeeks(begin, end, true);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量的绝对值 (|end -begin|)
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @return 时间量的绝对值
     */
    public static long betweenDays(LocalDateTime begin, LocalDateTime end) {
        return betweenDays(begin, end, true);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量的绝对值 (|end -begin|)
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @return 时间量的绝对值
     */
    public static long betweenHours(LocalDateTime begin, LocalDateTime end) {
        return betweenHours(begin, end, true);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量的绝对值 (|end -begin|)
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @return 时间量的绝对值
     */
    public static long betweenMinutes(LocalDateTime begin, LocalDateTime end) {
        return betweenMinutes(begin, end, true);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量的绝对值 (|end -begin|)
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @return 时间量的绝对值
     */
    public static long betweenSeconds(LocalDateTime begin, LocalDateTime end) {
        return betweenSeconds(begin, end, true);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量的绝对值 (|end -begin|)
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @return 时间量绝对值
     */
    public static long betweenMillis(LocalDateTime begin, LocalDateTime end) {
        return betweenMillis(begin, end, true);
    }

    /**
     * 两个日期作比较
     *
     * @param first  第一个
     * @param second 第二个
     * @return 第一个小于第二个，返回 -1；第一个等于第二个返回 0；第一个大于第二个， 返回 1。
     */
    public static int compare(LocalDateTime first, LocalDateTime second) {
        return first.compareTo(second);
    }

    /**
     * 判断第一个日期是不是在第二个日期之后
     *
     * @param first  第一个
     * @param second 第二个
     * @return 第一个日期是不是在第二个日期之后
     */
    public static boolean isAfter(LocalDateTime first, LocalDateTime second) {
        return first.isAfter(second);
    }

    /**
     * 判断第一个日期是不是在第二个日期之前
     *
     * @param first  第一个
     * @param second 第二个
     * @return 第一个日期是不是在第二个日期之前
     */
    public static boolean isBefore(LocalDateTime first, LocalDateTime second) {
        return first.isBefore(second);
    }

    /**
     * 判断第一个日期是不是和第二个日期相等
     *
     * @param first  第一个
     * @param second 第二个
     * @return 第一个日期是不是和第二个日期相等
     */
    public static boolean isEqual(LocalDateTime first, LocalDateTime second) {
        return first.isEqual(second);
    }

    /**
     * 判断两个日期是否是同一年
     *
     * @param first  第一个
     * @param second 第二个
     * @return 两个日期是否是同一年
     */
    public static boolean isEqualYear(LocalDateTime first, LocalDateTime second) {
        return Year.from(first).equals(Year.from(second));
    }

    /**
     * 判断两个日期是否是同一个月
     *
     * @param first  第一个
     * @param second 第二个
     * @return 两个日期是否是同一个月
     */
    public static boolean isEqualMonth(LocalDateTime first, LocalDateTime second) {
        return Month.from(first).equals(Month.from(second));
    }

    /**
     * 判断两个日期是否是同一个星期
     *
     * @param first  第一个
     * @param second 第二个
     * @return 两个日期是否是同一个星期
     */
    public static boolean isEqualWeek(LocalDateTime first, LocalDateTime second) {
        return DayOfWeek.from(first).equals(DayOfWeek.from(second));
    }

    /**
     * 判断两个日期是否是同一天
     *
     * @param first  第一个
     * @param second 第二个
     * @return 两个日期是否是同一天
     */
    public static boolean isEqualDay(LocalDateTime first, LocalDateTime second) {
        return LocalDate.from(first).equals(LocalDate.from(second));
    }

    /**
     * 判断两个日期是否是同一小时
     *
     * @param first  第一个
     * @param second 第二个
     * @return 两个日期是否是同一小时
     */
    public static boolean isEqualHour(LocalDateTime first, LocalDateTime second) {
        return first.get(HOUR_OF_DAY) == second.get(HOUR_OF_DAY);
    }

    /**
     * 判断两个日期是否是同一分钟
     *
     * @param first  第一个
     * @param second 第二个
     * @return 两个日期是否是同一分钟
     */
    public static boolean isEqualMinute(LocalDateTime first, LocalDateTime second) {
        return first.get(MINUTE_OF_HOUR) == second.get(MINUTE_OF_HOUR);
    }

    /**
     * 判断两个日期是否是同一秒
     *
     * @param first  第一个
     * @param second 第二个
     * @return 两个日期是否是同一秒
     */
    public static boolean isEqualSecond(LocalDateTime first, LocalDateTime second) {
        return first.get(SECOND_OF_MINUTE) == second.get(SECOND_OF_MINUTE);
    }

    /**
     * 判断两个日期是否是同一毫秒
     *
     * @param first  第一个
     * @param second 第二个
     * @return 两个日期是否是同一毫秒
     */
    public static boolean isEqualMilli(LocalDateTime first, LocalDateTime second) {
        return first.get(MILLI_OF_SECOND) == second.get(MILLI_OF_SECOND);
    }

    /**
     * 判断指定日期是否在指定的范围内
     *
     * @param localDateTime 日期
     * @param begin         开始日期 (包含)
     * @param end           结束日期 (包含)
     * @return 是否在指定的范围内
     */
    public static boolean isIn(LocalDateTime localDateTime, LocalDateTime begin, LocalDateTime end) {
        final long beginEpochMilli = toEpochMilli(begin);
        final long endEpochMilli = toEpochMilli(end);
        final long epochMilli = toEpochMilli(localDateTime);
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
    public static boolean isOverlap(LocalDateTime firstBegin, LocalDateTime firstEnd,
                                    LocalDateTime secondBegin, LocalDateTime secondEnd) {
        return (secondBegin.compareTo(firstEnd) <= 0) && (secondEnd.compareTo(firstBegin) >= 0);
    }

    //endregion

    //region 日期格式化

    /**
     * 格式化日期时间
     *
     * @param localDateTime 日期
     * @param pattern       格式
     * @return 格式化后的字符串
     * @see DatePattern
     */
    public static String format(LocalDateTime localDateTime, String pattern) {
        return DateFormatter.ofPattern(pattern).format(localDateTime);
    }

    /**
     * 格式化日期时间
     *
     * @param localDateTime 日期
     * @param datePattern   格式
     * @return 格式化后的字符串
     * @see DatePattern
     */
    public static String format(LocalDateTime localDateTime, DatePattern datePattern) {
        return DateFormatter.ofDatePattern(datePattern).format(localDateTime);
    }

    /**
     * 格式化日期时间
     *
     * @param localDateTime     日期
     * @param dateTimeFormatter {@link DateTimeFormatter}
     * @return 格式化后的字符串
     */
    public static String format(LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        return dateTimeFormatter.format(localDateTime);
    }

    /**
     * 格式化日期时间
     * <p>格式：yyyy-MM-dd HH:mm:ss
     *
     * @param localDateTime 日期
     * @return 格式化后的字符串
     */
    public static String format(LocalDateTime localDateTime) {
        return DateFormatter.NORMAL_DATE_TIME_SECOND.format(localDateTime);
    }

    /**
     * 格式化日期部分
     * <p>格式：yyyy-MM-dd
     *
     * @param localDateTime 日期
     * @return 格式化后的字符串
     */
    public static String formatDate(LocalDateTime localDateTime) {
        return DateFormatter.NORMAL_DATE.format(localDateTime);
    }

    /**
     * 格式化时间部分
     * <p>格式：HH:mm:ss
     *
     * @param localDateTime 日期
     * @return 格式化后的字符串
     */
    public static String formatTime(LocalDateTime localDateTime) {
        return DateFormatter.NORMAL_TIME.format(localDateTime);
    }

    /**
     * 格式化日期时间
     * <p>格式：yyyyMMddHHmmss
     *
     * @param localDateTime 日期
     * @return 格式化后的字符串
     */
    public static String formatOfSimple(LocalDateTime localDateTime) {
        return DateFormatter.SIMPLE_DATE_TIME_SECOND.format(localDateTime);
    }

    /**
     * 格式化日期部分
     * <p>格式：yyyyMMdd
     *
     * @param localDateTime 日期
     * @return 格式化后的字符串
     */
    public static String formatDateOfSimple(LocalDateTime localDateTime) {
        return DateFormatter.SIMPLE_DATE.format(localDateTime);
    }

    /**
     * 格式化时间部分
     * <p>格式：HHmmss
     *
     * @param localDateTime 日期
     * @return 格式化后的字符串
     */
    public static String formatTimeOfSimple(LocalDateTime localDateTime) {
        return DateFormatter.SIMPLE_TIME.format(localDateTime);
    }

    /**
     * 格式化日期时间
     * <p>格式：yyyy年MM月dd日HH时mm分ss秒
     *
     * @param localDateTime 日期
     * @return 格式化后的字符串
     */
    public static String formatOfChinese(LocalDateTime localDateTime) {
        return DateFormatter.CHINESE_DATE_TIME_SECOND.format(localDateTime);
    }

    /**
     * 格式化日期部分
     * <p>格式：yyyy年MM月dd日
     *
     * @param localDateTime 日期
     * @return 格式化后的字符串
     */
    public static String formatDateOfChinese(LocalDateTime localDateTime) {
        return DateFormatter.CHINESE_DATE.format(localDateTime);
    }

    /**
     * 格式化时间部分
     * <p>格式：HH时mm分ss秒
     *
     * @param localDateTime 日期
     * @return 格式化后的字符串
     */
    public static String formatTimeOfChinese(LocalDateTime localDateTime) {
        return DateFormatter.CHINESE_TIME.format(localDateTime);
    }

    //endregion

    //region 日期解析

    /**
     * 解析日期时间
     *
     * @param text    文本
     * @param pattern 格式
     * @return {@link LocalDateTime}
     * @see DatePattern
     */
    public static LocalDateTime parse(CharSequence text, String pattern) {
        return DateParser.parseLocalDateTime(text, DateFormatter.ofPattern(pattern));
    }

    /**
     * 解析日期时间
     *
     * @param text        文本
     * @param datePattern 格式
     * @return {@link LocalDateTime}
     * @see DatePattern
     */
    public static LocalDateTime parse(CharSequence text, DatePattern datePattern) {
        return DateParser.parseLocalDateTime(text, DateFormatter.ofDatePattern(datePattern));
    }

    /**
     * 解析日期时间
     *
     * @param text              文本
     * @param dateTimeFormatter {@link DateTimeFormatter}
     * @return {@link LocalDateTime}
     */
    public static LocalDateTime parse(CharSequence text, DateTimeFormatter dateTimeFormatter) {
        return DateParser.parseLocalDateTime(text, dateTimeFormatter);
    }

    /**
     * 解析日期时间
     * <p>格式：yyyy-MM-dd HH:mm:ss
     *
     * @param text 文本
     * @return {@link LocalDateTime}
     */
    public static LocalDateTime parse(CharSequence text) {
        return DateParser.parseLocalDateTime(text, DateFormatter.NORMAL_DATE_TIME_SECOND);
    }

    /**
     * 解析日期部分
     * <p>格式：yyyy-MM-dd
     *
     * @param text 文本
     * @return {@link LocalDate}
     */
    public static LocalDate parseDate(CharSequence text) {
        return DateParser.parseLocalDate(text, DateFormatter.NORMAL_DATE);
    }

    /**
     * 解析时间部分
     * <p>格式：HH:mm:ss
     *
     * @param text 文本
     * @return {@link LocalTime}
     */
    public static LocalTime parseTime(CharSequence text) {
        return DateParser.parseLocalTime(text, DateFormatter.NORMAL_TIME);
    }

    /**
     * 解析日期时间
     * <p>格式：yyyyMMddHHmmss
     *
     * @param text 文本
     * @return {@link LocalDateTime}
     */
    public static LocalDateTime parseOfSimple(CharSequence text) {
        return DateParser.parseLocalDateTime(text, DateFormatter.SIMPLE_DATE_TIME_SECOND);
    }

    /**
     * 解析日期部分
     * <p>格式：yyyyMMdd
     *
     * @param text 文本
     * @return {@link LocalDate}
     */
    public static LocalDate parseDateOfSimple(CharSequence text) {
        return DateParser.parseLocalDate(text, DateFormatter.SIMPLE_DATE);
    }

    /**
     * 解析时间部分
     * <p>格式：HHmmss
     *
     * @param text 文本
     * @return {@link LocalTime}
     */
    public static LocalTime parseTimeOfSimple(CharSequence text) {
        return DateParser.parseLocalTime(text, DateFormatter.SIMPLE_TIME);
    }

    /**
     * 解析日期时间
     * <p>格式：yyyy年MM月dd日HH时mm分ss秒
     *
     * @param text 文本
     * @return {@link LocalDateTime}
     */
    public static LocalDateTime parseOfChinese(CharSequence text) {
        return DateParser.parseLocalDateTime(text, DateFormatter.CHINESE_DATE_TIME_SECOND);
    }

    /**
     * 解析日期部分
     * <p>格式：yyyy年MM月dd日
     *
     * @param text 文本
     * @return {@link LocalDate}
     */
    public static LocalDate parseDateOfChinese(CharSequence text) {
        return DateParser.parseLocalDate(text, DateFormatter.CHINESE_DATE);
    }

    /**
     * 解析时间部分
     * <p>格式：HH时mm分ss秒
     *
     * @param text 文本
     * @return {@link LocalTime}
     */
    public static LocalTime parseTimeOfChinese(CharSequence text) {
        return DateParser.parseLocalTime(text, DateFormatter.CHINESE_TIME);
    }

    //endregion
}
