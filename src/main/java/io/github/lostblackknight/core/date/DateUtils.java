package io.github.lostblackknight.core.date;

import io.github.lostblackknight.core.date.format.DatePattern;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Date 工具类
 *
 * @author chensixiang (chensixiang1234@gmail.com) 2022/8/19 21:44
 * @version 1.0.0
 */
public abstract class DateUtils extends BaseUtils {

    //region 创建 Date 对象

    /**
     * 创建 {@link Date} 对象
     *
     * @param epochMilli 毫秒
     * @return {@link Date}
     */
    public static Date of(long epochMilli) {
        return Date.from(Instant.ofEpochMilli(epochMilli));
    }

    /**
     * 创建 {@link Date} 对象
     *
     * @param year       年
     * @param month      月
     * @param dayOfMonth 日
     * @return {@link Date}
     */
    public static Date of(int year, int month, int dayOfMonth) {
        return toDate(LocalDate.of(year, month, dayOfMonth));
    }

    /**
     * 创建 {@link Date} 对象
     *
     * @param year       年
     * @param month      月
     * @param dayOfMonth 日
     * @param hour       时
     * @param minute     分
     * @return {@link Date}
     */
    public static Date of(int year, int month, int dayOfMonth, int hour, int minute) {
        return toDate(LocalDateTime.of(year, month, dayOfMonth, hour, minute));
    }

    /**
     * 创建 {@link Date} 对象
     *
     * @param year       年
     * @param month      月
     * @param dayOfMonth 日
     * @param hour       时
     * @param minute     分
     * @param second     秒
     * @return {@link Date}
     */
    public static Date of(int year, int month, int dayOfMonth, int hour, int minute, int second) {
        return toDate(LocalDateTime.of(year, month, dayOfMonth, hour, minute, second));
    }

    //endregion

    //region 获取指定日期的基本信息

    /**
     * 获取指定日期所在的年份
     *
     * @param date 日期
     * @return 年份
     */
    public static int year(Date date) {
        return LocalDateTimeUtils.year(toLocalDateTime(date));
    }

    /**
     * 获取指定日期所在的月份，范围为 [1, 12]
     *
     * @param date 日期
     * @return 月份
     */
    public static int month(Date date) {
        return LocalDateTimeUtils.month(toLocalDateTime(date));
    }

    /**
     * 获取指定日期是所在年份的第几周，范围为 [1, 53]
     *
     * @param date 日期
     * @return 周
     */
    public static int weekOfYear(Date date) {
        return LocalDateTimeUtils.weekOfYear(toLocalDateTime(date));
    }

    /**
     * 获取指定日期是所在年份的第几天，范围为 [1, 366]
     *
     * @param date 日期
     * @return 天
     */
    public static int dayOfYear(Date date) {
        return LocalDateTimeUtils.dayOfYear(toLocalDateTime(date));
    }

    /**
     * 获取指定日期是所在月份的第几周，范围为 [1, 5]
     *
     * @param date 日期
     * @return 周
     */
    public static int weekOfMonth(Date date) {
        return LocalDateTimeUtils.weekOfMonth(toLocalDateTime(date));
    }

    /**
     * 获取指定日期是所在月份的第几天，范围为 [1, 31]
     *
     * @param date 日期
     * @return 天
     */
    public static int dayOfMonth(Date date) {
        return LocalDateTimeUtils.dayOfMonth(toLocalDateTime(date));
    }

    /**
     * 获取指定日期是所在星期的第几天，范围为 [1, 7]
     *
     * @param date 日期
     * @return 天
     */
    public static int dayOfWeek(Date date) {
        return LocalDateTimeUtils.dayOfWeek(toLocalDateTime(date));
    }

    /**
     * 获取指定日期的小时数，范围为 [0, 23]
     *
     * @param date 日期
     * @return 小时
     */
    public static int hourOf24(Date date) {
        return LocalDateTimeUtils.hourOf24(toLocalDateTime(date));
    }

    /**
     * 获取指定日期的小时数，范围为 [0, 11]
     *
     * @param date 日期
     * @return 小时
     */
    public static int hourOf12(Date date) {
        return LocalDateTimeUtils.hourOf12(toLocalDateTime(date));
    }

    /**
     * 获取指定日期的分钟数，范围为 [0, 59]
     *
     * @param date 日期
     * @return 分钟
     */
    public static int minute(Date date) {
        return LocalDateTimeUtils.minute(toLocalDateTime(date));
    }

    /**
     * 获取指定日期的秒数，范围为 [0, 59]
     *
     * @param date 日期
     * @return 秒
     */
    public static int second(Date date) {
        return LocalDateTimeUtils.second(toLocalDateTime(date));
    }

    /**
     * 获取指定日期的毫秒数，范围为 [0, 999]
     *
     * @param date 日期
     * @return 毫秒数
     */
    public static int milli(Date date) {
        return LocalDateTimeUtils.milli(toLocalDateTime(date));
    }

    /**
     * 判断指定日期是否为闰年
     *
     * @param date 日期
     * @return 是否为闰年
     */
    public static boolean isLeapYear(Date date) {
        return isLeapYear(year(date));
    }

    /**
     * 判断指定日期是否为周末
     *
     * @param date 日期
     * @return 是否为周末 (周六、 周日)
     */
    public static boolean isWeekend(Date date) {
        return LocalDateTimeUtils.isWeekend(toLocalDateTime(date));
    }

    /**
     * 判断指定日期是否为上午
     *
     * @param date 日期
     * @return 是否为上午
     */
    public static boolean isAM(Date date) {
        return LocalDateTimeUtils.isAM(toLocalDateTime(date));
    }

    /**
     * 判断指定日期是否为下午
     *
     * @param date 日期
     * @return 是否为上午
     */
    public static boolean isPM(Date date) {
        return LocalDateTimeUtils.isPM(toLocalDateTime(date));
    }

    /**
     * 获取指定日期的年的总天数
     *
     * @param date 日期
     * @return 天
     */
    public static int lengthOfYear(Date date) {
        return lengthOfYear(year(date));
    }

    /**
     * 获取指定日期的月的总天数
     *
     * @param date 日期
     * @return 天
     */
    public static int lengthOfMonth(Date date) {
        return lengthOfMonth(month(date), isLeapYear(date));
    }

    //endregion

    //region 获取当前日期的基本信息

    /**
     * 获取当前日期
     *
     * @return 当前日期
     */
    public static Date current() {
        return Date.from(Instant.now());
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
     * @param date  日期
     * @param years 年数
     * @return 修改后的日期
     */
    public static Date plusYears(Date date, int years) {
        return toDate(LocalDateTimeUtils.plusYears(toLocalDateTime(date), years));
    }

    /**
     * 将指定日期加上指定的月数
     *
     * @param date   日期
     * @param months 月数
     * @return 修改后的日期
     */
    public static Date plusMonths(Date date, int months) {
        return toDate(LocalDateTimeUtils.plusMonths(toLocalDateTime(date), months));
    }

    /**
     * 将指定日期加上指定的星期数
     *
     * @param date  日期
     * @param weeks 星期数
     * @return 修改后的日期
     */
    public static Date plusWeeks(Date date, int weeks) {
        return toDate(LocalDateTimeUtils.plusWeeks(toLocalDateTime(date), weeks));
    }

    /**
     * 将指定日期加上指定的天数
     *
     * @param date 日期
     * @param days 天数
     * @return 修改后的日期
     */
    public static Date plusDays(Date date, int days) {
        return toDate(LocalDateTimeUtils.plusDays(toLocalDateTime(date), days));
    }

    /**
     * 将指定日期加上指定的小时数
     *
     * @param date  日期
     * @param hours 小时数
     * @return 修改后的日期
     */
    public static Date plusHours(Date date, int hours) {
        return toDate(LocalDateTimeUtils.plusHours(toLocalDateTime(date), hours));
    }

    /**
     * 将指定日期加上指定的分钟数
     *
     * @param date    日期
     * @param minutes 分钟数
     * @return 修改后的日期
     */
    public static Date plusMinutes(Date date, int minutes) {
        return toDate(LocalDateTimeUtils.plusMinutes(toLocalDateTime(date), minutes));
    }

    /**
     * 将指定日期加上指定的秒数
     *
     * @param date    日期
     * @param seconds 秒数
     * @return 修改后的日期
     */
    public static Date plusSeconds(Date date, int seconds) {
        return toDate(LocalDateTimeUtils.plusSeconds(toLocalDateTime(date), seconds));
    }

    /**
     * 将指定日期加上指定的毫秒数
     *
     * @param date   日期
     * @param millis 毫秒数
     * @return 修改后的日期
     */
    public static Date plusMillis(Date date, int millis) {
        return toDate(LocalDateTimeUtils.plusMillis(toLocalDateTime(date), millis));
    }

    /**
     * 将指定日期减去指定的年数
     *
     * @param date  日期
     * @param years 年数
     * @return 修改后的日期
     */
    public static Date minusYears(Date date, int years) {
        return toDate(LocalDateTimeUtils.minusYears(toLocalDateTime(date), years));
    }

    /**
     * 将指定日期减去指定的月数
     *
     * @param date   日期
     * @param months 月数
     * @return 修改后的日期
     */
    public static Date minusMonths(Date date, int months) {
        return toDate(LocalDateTimeUtils.minusMonths(toLocalDateTime(date), months));
    }

    /**
     * 将指定日期减去指定的星期数
     *
     * @param date  日期
     * @param weeks 星期数
     * @return 修改后的日期
     */
    public static Date minusWeeks(Date date, int weeks) {
        return toDate(LocalDateTimeUtils.minusWeeks(toLocalDateTime(date), weeks));
    }

    /**
     * 将指定日期减去指定的天数
     *
     * @param date 日期
     * @param days 天数
     * @return 修改后的日期
     */
    public static Date minusDays(Date date, int days) {
        return toDate(LocalDateTimeUtils.minusDays(toLocalDateTime(date), days));
    }

    /**
     * 将指定日期减去指定的小时数
     *
     * @param date  日期
     * @param hours 小时数
     * @return 修改后的日期
     */
    public static Date minusHours(Date date, int hours) {
        return toDate(LocalDateTimeUtils.minusHours(toLocalDateTime(date), hours));
    }

    /**
     * 将指定日期减去指定的分钟数
     *
     * @param date    日期
     * @param minutes 分钟数
     * @return 修改后的日期
     */
    public static Date minusMinutes(Date date, int minutes) {
        return toDate(LocalDateTimeUtils.minusMinutes(toLocalDateTime(date), minutes));
    }

    /**
     * 将指定日期减去指定的秒数
     *
     * @param date    日期
     * @param seconds 秒数
     * @return 修改后的日期
     */
    public static Date minusSeconds(Date date, int seconds) {
        return toDate(LocalDateTimeUtils.minusSeconds(toLocalDateTime(date), seconds));
    }

    /**
     * 将指定日期减去指定的毫秒数
     *
     * @param date   日期
     * @param millis 毫秒数
     * @return 修改后的日期
     */
    public static Date minusMillis(Date date, int millis) {
        return toDate(LocalDateTimeUtils.minusMillis(toLocalDateTime(date), millis));
    }

    /**
     * 获取某年的第一天
     *
     * @param date 日期
     * @return 日期
     */
    public static Date beginOfYear(Date date) {
        return toDate(LocalDateTimeUtils.beginOfYear(toLocalDateTime(date)));
    }

    /**
     * 获取某年的最后一天
     *
     * @param date 日期
     * @return 日期
     */
    public static Date endOfYear(Date date) {
        return toDate(LocalDateTimeUtils.endOfYear(toLocalDateTime(date)));
    }

    /**
     * 获取下一年的第一天
     *
     * @param date 日期
     * @return 日期
     */
    public static Date beginOfNextYear(Date date) {
        return toDate(LocalDateTimeUtils.beginOfNextYear(toLocalDateTime(date)));
    }

    /**
     * 获取下一年的最后一天
     *
     * @param date 日期
     * @return 日期
     */
    public static Date endOfNextYear(Date date) {
        return toDate(LocalDateTimeUtils.endOfNextYear(toLocalDateTime(date)));
    }

    /**
     * 获取上一年的第一天
     *
     * @param date 日期
     * @return 日期
     */
    public static Date beginOfPrevYear(Date date) {
        return toDate(LocalDateTimeUtils.beginOfPrevYear(toLocalDateTime(date)));
    }

    /**
     * 获取上一年的最后一天
     *
     * @param date 日期
     * @return 日期
     */
    public static Date endOfPrevYear(Date date) {
        return toDate(LocalDateTimeUtils.endOfPrevYear(toLocalDateTime(date)));
    }

    /**
     * 获取某月的第一天
     *
     * @param date 日期
     * @return 日期
     */
    public static Date beginOfMonth(Date date) {
        return toDate(LocalDateTimeUtils.beginOfMonth(toLocalDateTime(date)));
    }

    /**
     * 获取某月的最后一天
     *
     * @param date 日期
     * @return 日期
     */
    public static Date endOfMonth(Date date) {
        return toDate(LocalDateTimeUtils.endOfMonth(toLocalDateTime(date)));
    }

    /**
     * 获取下个月的第一天
     *
     * @param date 日期
     * @return 日期
     */
    public static Date beginOfNextMonth(Date date) {
        return toDate(LocalDateTimeUtils.beginOfNextMonth(toLocalDateTime(date)));
    }

    /**
     * 获取下个月的最后一天
     *
     * @param date 日期
     * @return 日期
     */
    public static Date endOfNextMonth(Date date) {
        return toDate(LocalDateTimeUtils.endOfNextMonth(toLocalDateTime(date)));
    }

    /**
     * 获取上个月的第一天
     *
     * @param date 日期
     * @return 日期
     */
    public static Date beginOfPrevMonth(Date date) {
        return toDate(LocalDateTimeUtils.beginOfPrevMonth(toLocalDateTime(date)));
    }

    /**
     * 获取上个月的最后一天
     *
     * @param date 日期
     * @return 日期
     */
    public static Date endOfPrevMonth(Date date) {
        return toDate(LocalDateTimeUtils.endOfPrevMonth(toLocalDateTime(date)));
    }

    /**
     * 获取某周的第一天，默认第一天为周一
     *
     * @param date 日期
     * @return 日期
     */
    public static Date beginOfWeek(Date date) {
        return toDate(LocalDateTimeUtils.beginOfWeek(toLocalDateTime(date)));
    }

    /**
     * 获取某周的最后一天，默认最后一天为周日
     *
     * @param date 日期
     * @return 日期
     */
    public static Date endOfWeek(Date date) {
        return toDate(LocalDateTimeUtils.endOfWeek(toLocalDateTime(date)));
    }

    /**
     * 获取下一周的第一天，默认第一天为周一
     *
     * @param date 日期
     * @return 日期
     */
    public static Date beginOfNextWeek(Date date) {
        return toDate(LocalDateTimeUtils.beginOfNextWeek(toLocalDateTime(date)));
    }

    /**
     * 获取下一周的最后一天，默认最后一天为周日
     *
     * @param date 日期
     * @return 日期
     */
    public static Date endOfNextWeek(Date date) {
        return toDate(LocalDateTimeUtils.endOfNextWeek(toLocalDateTime(date)));
    }

    /**
     * 获取上一周的第一天，默认第一天为周一
     *
     * @param date 日期
     * @return 日期
     */
    public static Date beginOfPrevWeek(Date date) {
        return toDate(LocalDateTimeUtils.beginOfPrevWeek(toLocalDateTime(date)));
    }

    /**
     * 获取上一周的最后一天，默认最后一天为周日
     *
     * @param date 日期
     * @return 日期
     */
    public static Date endOfPrevWeek(Date date) {
        return toDate(LocalDateTimeUtils.endOfPrevWeek(toLocalDateTime(date)));
    }

    /**
     * 获取某一天的开始时间
     *
     * @param date 日期
     * @return 日期
     */
    public static Date beginOfDay(Date date) {
        return toDate(LocalDateTimeUtils.beginOfDay(toLocalDateTime(date)));
    }

    /**
     * 获取某一天的结束时间
     *
     * @param date 日期
     * @return 日期
     */
    public static Date endOfDay(Date date) {
        return toDate(LocalDateTimeUtils.endOfDay(toLocalDateTime(date)));
    }

    /**
     * 获取下一天的开始时间
     *
     * @param date 日期
     * @return 日期
     */
    public static Date beginOfNextDay(Date date) {
        return toDate(LocalDateTimeUtils.beginOfNextDay(toLocalDateTime(date)));
    }

    /**
     * 获取下一天的结束时间
     *
     * @param date 日期
     * @return 日期
     */
    public static Date endOfNextDay(Date date) {
        return toDate(LocalDateTimeUtils.endOfNextDay(toLocalDateTime(date)));
    }

    /**
     * 获取上一天的开始时间
     *
     * @param date 日期
     * @return 日期
     */
    public static Date beginOfPrevDay(Date date) {
        return toDate(LocalDateTimeUtils.beginOfPrevDay(toLocalDateTime(date)));
    }

    /**
     * 获取上一天的结束时间
     *
     * @param date 日期
     * @return 日期
     */
    public static Date endOfPrevDay(Date date) {
        return toDate(LocalDateTimeUtils.endOfPrevDay(toLocalDateTime(date)));
    }

    /**
     * 获取某小时的开始时间
     *
     * @param date 日期
     * @return 日期
     */
    public static Date beginOfHour(Date date) {
        return toDate(LocalDateTimeUtils.beginOfHour(toLocalDateTime(date)));
    }

    /**
     * 获取某小时的结束时间
     *
     * @param date 日期
     * @return 日期
     */
    public static Date endOfHour(Date date) {
        return toDate(LocalDateTimeUtils.endOfHour(toLocalDateTime(date)));
    }

    /**
     * 获取某分钟的开始时间
     *
     * @param date 日期
     * @return 日期
     */
    public static Date beginOfMinute(Date date) {
        return toDate(LocalDateTimeUtils.beginOfMinute(toLocalDateTime(date)));
    }

    /**
     * 获取某小时的结束时间
     *
     * @param date 日期
     * @return 日期
     */
    public static Date endOfMinute(Date date) {
        return toDate(LocalDateTimeUtils.endOfMinute(toLocalDateTime(date)));
    }

    /**
     * 获取某秒的开始时间
     *
     * @param date 日期
     * @return 日期
     */
    public static Date beginOfSecond(Date date) {
        return toDate(LocalDateTimeUtils.beginOfSecond(toLocalDateTime(date)));
    }

    /**
     * 获取某秒的结束时间
     *
     * @param date 日期
     * @return 日期
     */
    public static Date endOfSecond(Date date) {
        return toDate(LocalDateTimeUtils.endOfSecond(toLocalDateTime(date)));
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
    public static long betweenYears(Date begin, Date end, boolean isAbs) {
        return LocalDateTimeUtils.betweenYears(toLocalDateTime(begin), toLocalDateTime(end), isAbs);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @param isAbs 是否是绝对值
     * @return 时间量
     */
    public static long betweenMonths(Date begin, Date end, boolean isAbs) {
        return LocalDateTimeUtils.betweenMonths(toLocalDateTime(begin), toLocalDateTime(end), isAbs);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @param isAbs 是否是绝对值
     * @return 时间量
     */
    public static long betweenWeeks(Date begin, Date end, boolean isAbs) {
        return LocalDateTimeUtils.betweenWeeks(toLocalDateTime(begin), toLocalDateTime(end), isAbs);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @param isAbs 是否是绝对值
     * @return 时间量
     */
    public static long betweenDays(Date begin, Date end, boolean isAbs) {
        return LocalDateTimeUtils.betweenDays(toLocalDateTime(begin), toLocalDateTime(end), isAbs);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @param isAbs 是否是绝对值
     * @return 时间量
     */
    public static long betweenHours(Date begin, Date end, boolean isAbs) {
        return LocalDateTimeUtils.betweenHours(toLocalDateTime(begin), toLocalDateTime(end), isAbs);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @param isAbs 是否是绝对值
     * @return 时间量
     */
    public static long betweenMinutes(Date begin, Date end, boolean isAbs) {
        return LocalDateTimeUtils.betweenMinutes(toLocalDateTime(begin), toLocalDateTime(end), isAbs);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @param isAbs 是否是绝对值
     * @return 时间量
     */
    public static long betweenSeconds(Date begin, Date end, boolean isAbs) {
        return LocalDateTimeUtils.betweenSeconds(toLocalDateTime(begin), toLocalDateTime(end), isAbs);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @param isAbs 是否是绝对值
     * @return 时间量
     */
    public static long betweenMillis(Date begin, Date end, boolean isAbs) {
        return LocalDateTimeUtils.betweenMillis(toLocalDateTime(begin), toLocalDateTime(end), isAbs);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量的绝对值 (|end -begin|)
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @return 时间量的绝对值
     */
    public static long betweenYears(Date begin, Date end) {
        return betweenYears(begin, end, true);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量的绝对值 (|end -begin|)
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @return 时间量的绝对值
     */
    public static long betweenMonths(Date begin, Date end) {
        return betweenMonths(begin, end, true);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量的绝对值 (|end -begin|)
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @return 时间量的绝对值
     */
    public static long betweenWeeks(Date begin, Date end) {
        return betweenWeeks(begin, end, true);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量的绝对值 (|end -begin|)
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @return 时间量的绝对值
     */
    public static long betweenDays(Date begin, Date end) {
        return betweenDays(begin, end, true);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量的绝对值 (|end -begin|)
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @return 时间量的绝对值
     */
    public static long betweenHours(Date begin, Date end) {
        return betweenHours(begin, end, true);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量的绝对值 (|end -begin|)
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @return 时间量的绝对值
     */
    public static long betweenMinutes(Date begin, Date end) {
        return betweenMinutes(begin, end, true);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量的绝对值 (|end -begin|)
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @return 时间量的绝对值
     */
    public static long betweenSeconds(Date begin, Date end) {
        return betweenSeconds(begin, end, true);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量的绝对值 (|end -begin|)
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @return 时间量绝对值
     */
    public static long betweenMillis(Date begin, Date end) {
        return betweenMillis(begin, end, true);
    }

    /**
     * 两个日期作比较
     *
     * @param first  第一个
     * @param second 第二个
     * @return 第一个小于第二个，返回 -1；第一个等于第二个返回 0；第一个大于第二个， 返回 1。
     */
    public static int compare(Date first, Date second) {
        return LocalDateTimeUtils.compare(toLocalDateTime(first), toLocalDateTime(second));
    }

    /**
     * 判断第一个日期是不是在第二个日期之后
     *
     * @param first  第一个
     * @param second 第二个
     * @return 第一个日期是不是在第二个日期之后
     */
    public static boolean isAfter(Date first, Date second) {
        return LocalDateTimeUtils.isAfter(toLocalDateTime(first), toLocalDateTime(second));
    }

    /**
     * 判断第一个日期是不是在第二个日期之前
     *
     * @param first  第一个
     * @param second 第二个
     * @return 第一个日期是不是在第二个日期之前
     */
    public static boolean isBefore(Date first, Date second) {
        return LocalDateTimeUtils.isBefore(toLocalDateTime(first), toLocalDateTime(second));
    }

    /**
     * 判断第一个日期是不是和第二个日期相等
     *
     * @param first  第一个
     * @param second 第二个
     * @return 第一个日期是不是和第二个日期相等
     */
    public static boolean isEqual(Date first, Date second) {
        return LocalDateTimeUtils.isEqual(toLocalDateTime(first), toLocalDateTime(second));
    }

    /**
     * 判断两个日期是否是同一年
     *
     * @param first  第一个
     * @param second 第二个
     * @return 两个日期是否是同一年
     */
    public static boolean isEqualYear(Date first, Date second) {
        return LocalDateTimeUtils.isEqualYear(toLocalDateTime(first), toLocalDateTime(second));
    }

    /**
     * 判断两个日期是否是同一个月
     *
     * @param first  第一个
     * @param second 第二个
     * @return 两个日期是否是同一个月
     */
    public static boolean isEqualMonth(Date first, Date second) {
        return LocalDateTimeUtils.isEqualMonth(toLocalDateTime(first), toLocalDateTime(second));
    }

    /**
     * 判断两个日期是否是同一个星期
     *
     * @param first  第一个
     * @param second 第二个
     * @return 两个日期是否是同一个星期
     */
    public static boolean isEqualWeek(Date first, Date second) {
        return LocalDateTimeUtils.isEqualWeek(toLocalDateTime(first), toLocalDateTime(second));
    }

    /**
     * 判断两个日期是否是同一天
     *
     * @param first  第一个
     * @param second 第二个
     * @return 两个日期是否是同一天
     */
    public static boolean isEqualDay(Date first, Date second) {
        return LocalDateTimeUtils.isEqualDay(toLocalDateTime(first), toLocalDateTime(second));
    }

    /**
     * 判断两个日期是否是同一小时
     *
     * @param first  第一个
     * @param second 第二个
     * @return 两个日期是否是同一小时
     */
    public static boolean isEqualHour(Date first, Date second) {
        return LocalDateTimeUtils.isEqualHour(toLocalDateTime(first), toLocalDateTime(second));
    }

    /**
     * 判断两个日期是否是同一分钟
     *
     * @param first  第一个
     * @param second 第二个
     * @return 两个日期是否是同一分钟
     */
    public static boolean isEqualMinute(Date first, Date second) {
        return LocalDateTimeUtils.isEqualMinute(toLocalDateTime(first), toLocalDateTime(second));
    }

    /**
     * 判断两个日期是否是同一秒
     *
     * @param first  第一个
     * @param second 第二个
     * @return 两个日期是否是同一秒
     */
    public static boolean isEqualSecond(Date first, Date second) {
        return LocalDateTimeUtils.isEqualSecond(toLocalDateTime(first), toLocalDateTime(second));
    }

    /**
     * 判断两个日期是否是同一毫秒
     *
     * @param first  第一个
     * @param second 第二个
     * @return 两个日期是否是同一毫秒
     */
    public static boolean isEqualMilli(Date first, Date second) {
        return LocalDateTimeUtils.isEqualMilli(toLocalDateTime(first), toLocalDateTime(second));
    }

    /**
     * 判断指定日期是否在指定的范围内
     *
     * @param date  日期
     * @param begin 开始日期 (包含)
     * @param end   结束日期 (包含)
     * @return 是否在指定的范围内
     */
    public static boolean isIn(Date date, Date begin, Date end) {
        return LocalDateTimeUtils.isIn(toLocalDateTime(date), toLocalDateTime(begin), toLocalDateTime(end));
    }

    /**
     * 判断两个日期范围是否有交集
     *
     * @param firstBegin  第一个开始
     * @param firstEnd    第一个结束
     * @param secondBegin 第二个开始
     * @param secondEnd   第二个结束
     * @return 两个日期范围是否有交集
     */
    public static boolean isOverlap(Date firstBegin, Date firstEnd,
                                    Date secondBegin, Date secondEnd) {
        return LocalDateTimeUtils.isOverlap(toLocalDateTime(firstBegin), toLocalDateTime(firstEnd),
                toLocalDateTime(secondBegin), toLocalDateTime(secondEnd));
    }

    //endregion

    //region 日期格式化

    /**
     * 格式化日期时间
     *
     * @param date    日期
     * @param pattern 格式
     * @return 格式化后的字符串
     * @see DatePattern
     */
    public static String format(Date date, String pattern) {
        return LocalDateTimeUtils.format(toLocalDateTime(date), pattern);
    }

    /**
     * 格式化日期时间
     *
     * @param date        日期
     * @param datePattern 格式
     * @return 格式化后的字符串
     * @see DatePattern
     */
    public static String format(Date date, DatePattern datePattern) {
        return LocalDateTimeUtils.format(toLocalDateTime(date), datePattern);
    }

    /**
     * 格式化日期时间
     *
     * @param date              日期
     * @param dateTimeFormatter {@link DateTimeFormatter}
     * @return 格式化后的字符串
     */
    public static String format(Date date, DateTimeFormatter dateTimeFormatter) {
        return LocalDateTimeUtils.format(toLocalDateTime(date), dateTimeFormatter);
    }

    /**
     * 格式化日期时间
     * <p>格式：yyyy-MM-dd HH:mm:ss
     *
     * @param date 日期
     * @return 格式化后的字符串
     */
    public static String format(Date date) {
        return LocalDateTimeUtils.format(toLocalDateTime(date));
    }

    /**
     * 格式化日期部分
     * <p>格式：yyyy-MM-dd
     *
     * @param date 日期
     * @return 格式化后的字符串
     */
    public static String formatDate(Date date) {
        return LocalDateTimeUtils.formatDate(toLocalDateTime(date));
    }

    /**
     * 格式化时间部分
     * <p>格式：HH:mm:ss
     *
     * @param date 日期
     * @return 格式化后的字符串
     */
    public static String formatTime(Date date) {
        return LocalDateTimeUtils.formatTime(toLocalDateTime(date));
    }

    /**
     * 格式化日期时间
     * <p>格式：yyyyMMddHHmmss
     *
     * @param date 日期
     * @return 格式化后的字符串
     */
    public static String formatOfSimple(Date date) {
        return LocalDateTimeUtils.formatOfSimple(toLocalDateTime(date));
    }

    /**
     * 格式化日期部分
     * <p>格式：yyyyMMdd
     *
     * @param date 日期
     * @return 格式化后的字符串
     */
    public static String formatDateOfSimple(Date date) {
        return LocalDateTimeUtils.formatDateOfSimple(toLocalDateTime(date));
    }

    /**
     * 格式化时间部分
     * <p>格式：HHmmss
     *
     * @param date 日期
     * @return 格式化后的字符串
     */
    public static String formatTimeOfSimple(Date date) {
        return LocalDateTimeUtils.formatTimeOfSimple(toLocalDateTime(date));
    }

    /**
     * 格式化日期时间
     * <p>格式：yyyy年MM月dd日HH时mm分ss秒
     *
     * @param date 日期
     * @return 格式化后的字符串
     */
    public static String formatOfChinese(Date date) {
        return LocalDateTimeUtils.formatOfChinese(toLocalDateTime(date));
    }

    /**
     * 格式化日期部分
     * <p>格式：yyyy年MM月dd日
     *
     * @param date 日期
     * @return 格式化后的字符串
     */
    public static String formatDateOfChinese(Date date) {
        return LocalDateTimeUtils.formatDateOfChinese(toLocalDateTime(date));
    }

    /**
     * 格式化时间部分
     * <p>格式：HH时mm分ss秒
     *
     * @param date 日期
     * @return 格式化后的字符串
     */
    public static String formatTimeOfChinese(Date date) {
        return LocalDateTimeUtils.formatTimeOfChinese(toLocalDateTime(date));
    }

    //endregion

    //region 日期解析

    /**
     * 解析日期时间
     *
     * @param text    文本
     * @param pattern 格式
     * @return {@link Date}
     * @see DatePattern
     */
    public static Date parse(CharSequence text, String pattern) {
        return toDate(LocalDateTimeUtils.parse(text, pattern));
    }

    /**
     * 解析日期时间
     *
     * @param text        文本
     * @param datePattern 格式
     * @return {@link Date}
     * @see DatePattern
     */
    public static Date parse(CharSequence text, DatePattern datePattern) {
        return toDate(LocalDateTimeUtils.parse(text, datePattern));
    }

    /**
     * 解析日期时间
     *
     * @param text              文本
     * @param dateTimeFormatter {@link DateTimeFormatter}
     * @return {@link Date}
     */
    public static Date parse(CharSequence text, DateTimeFormatter dateTimeFormatter) {
        return toDate(LocalDateTimeUtils.parse(text, dateTimeFormatter));
    }

    /**
     * 解析日期时间
     * <p>格式：yyyy-MM-dd HH:mm:ss
     *
     * @param text 文本
     * @return {@link Date}
     */
    public static Date parse(CharSequence text) {
        return toDate(LocalDateTimeUtils.parse(text));
    }

    /**
     * 解析日期部分
     * <p>格式：yyyy-MM-dd
     *
     * @param text 文本
     * @return {@link Date}
     */
    public static Date parseDate(CharSequence text) {
        return toDate(LocalDateTimeUtils.parseDate(text));
    }

    /**
     * 解析时间部分
     * <p>格式：HH:mm:ss
     *
     * @param text 文本
     * @return {@link Date}
     */
    public static Date parseTime(CharSequence text) {
        return toDate(LocalDateTimeUtils.parseTime(text));
    }

    /**
     * 解析日期时间
     * <p>格式：yyyyMMddHHmmss
     *
     * @param text 文本
     * @return {@link Date}
     */
    public static Date parseOfSimple(CharSequence text) {
        return toDate(LocalDateTimeUtils.parseOfSimple(text));
    }

    /**
     * 解析日期部分
     * <p>格式：yyyyMMdd
     *
     * @param text 文本
     * @return {@link Date}
     */
    public static Date parseDateOfSimple(CharSequence text) {
        return toDate(LocalDateTimeUtils.parseDateOfSimple(text));
    }

    /**
     * 解析时间部分
     * <p>格式：HHmmss
     *
     * @param text 文本
     * @return {@link Date}
     */
    public static Date parseTimeOfSimple(CharSequence text) {
        return toDate(LocalDateTimeUtils.parseTimeOfSimple(text));
    }

    /**
     * 解析日期时间
     * <p>格式：yyyy年MM月dd日HH时mm分ss秒
     *
     * @param text 文本
     * @return {@link Date}
     */
    public static Date parseOfChinese(CharSequence text) {
        return toDate(LocalDateTimeUtils.parseOfChinese(text));
    }

    /**
     * 解析日期部分
     * <p>格式：yyyy年MM月dd日
     *
     * @param text 文本
     * @return {@link Date}
     */
    public static Date parseDateOfChinese(CharSequence text) {
        return toDate(LocalDateTimeUtils.parseDateOfChinese(text));
    }

    /**
     * 解析时间部分
     * <p>格式：HH时mm分ss秒
     *
     * @param text 文本
     * @return {@link Date}
     */
    public static Date parseTimeOfChinese(CharSequence text) {
        return toDate(LocalDateTimeUtils.parseTimeOfChinese(text));
    }

    //endregion
}
