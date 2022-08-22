package io.github.lostblackknight.core.date;

import io.github.lostblackknight.core.date.format.DateFormatter;
import io.github.lostblackknight.core.date.format.DateParser;
import io.github.lostblackknight.core.date.format.DatePattern;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.time.DayOfWeek.*;
import static java.time.temporal.ChronoField.*;
import static java.time.temporal.ChronoUnit.*;
import static java.time.temporal.TemporalAdjusters.*;

/**
 * LocalDate 工具类
 *
 * @author chensixiang (chensixiang1234@gmail.com) 2022/8/19 21:45
 * @version 1.0.0
 */
public abstract class LocalDateUtils extends BaseUtils {

    //region 创建 LocalDate 对象

    /**
     * 创建 {@link LocalDate} 对象
     *
     * @param epochMilli 毫秒
     * @return {@link LocalDate}
     */
    public static LocalDate of(long epochMilli) {
        return LocalDate.from(LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilli), ZoneId.systemDefault()));
    }

    //endregion

    //region 获取指定日期的基本信息

    /**
     * 获取指定日期所在的年份
     *
     * @param localDate 日期
     * @return 年份
     */
    public static int year(LocalDate localDate) {
        return localDate.get(YEAR);
    }

    /**
     * 获取指定日期所在的月份，范围为 [1, 12]
     *
     * @param localDate 日期
     * @return 月份
     */
    public static int month(LocalDate localDate) {
        return localDate.get(MONTH_OF_YEAR);
    }

    /**
     * 获取指定日期是所在年份的第几周，范围为 [1, 53]
     *
     * @param localDate 日期
     * @return 周
     */
    public static int weekOfYear(LocalDate localDate) {
        return localDate.get(WeekFields.of(MONDAY, 1).weekOfYear());
    }

    /**
     * 获取指定日期是所在年份的第几天，范围为 [1, 366]
     *
     * @param localDate 日期
     * @return 天
     */
    public static int dayOfYear(LocalDate localDate) {
        return localDate.get(DAY_OF_YEAR);
    }

    /**
     * 获取指定日期是所在月份的第几周，范围为 [1, 5]
     *
     * @param localDate 日期
     * @return 周
     */
    public static int weekOfMonth(LocalDate localDate) {
        return localDate.get(WeekFields.of(MONDAY, 1).weekOfMonth());
    }

    /**
     * 获取指定日期是所在月份的第几天，范围为 [1, 31]
     *
     * @param localDate 日期
     * @return 天
     */
    public static int dayOfMonth(LocalDate localDate) {
        return localDate.get(DAY_OF_MONTH);
    }

    /**
     * 获取指定日期是所在星期的第几天，范围为 [1, 7]
     *
     * @param localDate 日期
     * @return 天
     */
    public static int dayOfWeek(LocalDate localDate) {
        return localDate.get(DAY_OF_WEEK);
    }

    /**
     * 判断指定日期是否为闰年
     *
     * @param localDate 日期
     * @return 是否为闰年
     */
    public static boolean isLeapYear(LocalDate localDate) {
        return isLeapYear(year(localDate));
    }

    /**
     * 判断指定日期是否为周末
     *
     * @param localDate 日期
     * @return 是否为周末 (周六、 周日)
     */
    public static boolean isWeekend(LocalDate localDate) {
        return localDate.getDayOfWeek().equals(SATURDAY)
                || localDate.getDayOfWeek().equals(SUNDAY);
    }

    /**
     * 获取指定日期的年的总天数
     *
     * @param localDate 日期
     * @return 天
     */
    public static int lengthOfYear(LocalDate localDate) {
        return lengthOfYear(year(localDate));
    }

    /**
     * 获取指定日期的月的总天数
     *
     * @param localDate 日期
     * @return 天
     */
    public static int lengthOfMonth(LocalDate localDate) {
        return lengthOfMonth(month(localDate), isLeapYear(localDate));
    }

    //endregion

    //region 获取当前日期的基本信息

    /**
     * 获取当前日期
     *
     * @return 当前日期
     */
    public static LocalDate current() {
        return LocalDate.now();
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
     * @param localDate 日期
     * @param years     年数
     * @return 修改后的日期
     */
    public static LocalDate plusYears(LocalDate localDate, int years) {
        return localDate.plus(years, YEARS);
    }

    /**
     * 将指定日期加上指定的月数
     *
     * @param localDate 日期
     * @param months    月数
     * @return 修改后的日期
     */
    public static LocalDate plusMonths(LocalDate localDate, int months) {
        return localDate.plus(months, MONTHS);
    }

    /**
     * 将指定日期加上指定的星期数
     *
     * @param localDate 日期
     * @param weeks     星期数
     * @return 修改后的日期
     */
    public static LocalDate plusWeeks(LocalDate localDate, int weeks) {
        return localDate.plus(weeks, WEEKS);
    }

    /**
     * 将指定日期加上指定的天数
     *
     * @param localDate 日期
     * @param days      天数
     * @return 修改后的日期
     */
    public static LocalDate plusDays(LocalDate localDate, int days) {
        return localDate.plus(days, DAYS);
    }

    /**
     * 将指定日期减去指定的年数
     *
     * @param localDate 日期
     * @param years     年数
     * @return 修改后的日期
     */
    public static LocalDate minusYears(LocalDate localDate, int years) {
        return localDate.minus(years, YEARS);
    }

    /**
     * 将指定日期减去指定的月数
     *
     * @param localDate 日期
     * @param months    月数
     * @return 修改后的日期
     */
    public static LocalDate minusMonths(LocalDate localDate, int months) {
        return localDate.minus(months, MONTHS);
    }

    /**
     * 将指定日期减去指定的星期数
     *
     * @param localDate 日期
     * @param weeks     星期数
     * @return 修改后的日期
     */
    public static LocalDate minusWeeks(LocalDate localDate, int weeks) {
        return localDate.minus(weeks, WEEKS);
    }

    /**
     * 将指定日期减去指定的天数
     *
     * @param localDate 日期
     * @param days      天数
     * @return 修改后的日期
     */
    public static LocalDate minusDays(LocalDate localDate, int days) {
        return localDate.minus(days, DAYS);
    }

    /**
     * 获取某年的第一天
     *
     * @param localDate 日期
     * @return 日期
     */
    public static LocalDate beginOfYear(LocalDate localDate) {
        return localDate.with(firstDayOfYear());
    }

    /**
     * 获取某年的最后一天
     *
     * @param localDate 日期
     * @return 日期
     */
    public static LocalDate endOfYear(LocalDate localDate) {
        return localDate.with(lastDayOfYear());
    }

    /**
     * 获取下一年的第一天
     *
     * @param localDate 日期
     * @return 日期
     */
    public static LocalDate beginOfNextYear(LocalDate localDate) {
        return localDate.plus(1, YEARS).with(firstDayOfYear());
    }

    /**
     * 获取下一年的最后一天
     *
     * @param localDate 日期
     * @return 日期
     */
    public static LocalDate endOfNextYear(LocalDate localDate) {
        return localDate.plus(1, YEARS).with(lastDayOfYear());
    }

    /**
     * 获取上一年的第一天
     *
     * @param localDate 日期
     * @return 日期
     */
    public static LocalDate beginOfPrevYear(LocalDate localDate) {
        return localDate.minus(1, YEARS).with(firstDayOfYear());
    }

    /**
     * 获取上一年的最后一天
     *
     * @param localDate 日期
     * @return 日期
     */
    public static LocalDate endOfPrevYear(LocalDate localDate) {
        return localDate.minus(1, YEARS).with(lastDayOfYear());
    }

    /**
     * 获取某月的第一天
     *
     * @param localDate 日期
     * @return 日期
     */
    public static LocalDate beginOfMonth(LocalDate localDate) {
        return localDate.with(firstDayOfMonth());
    }

    /**
     * 获取某月的最后一天
     *
     * @param localDate 日期
     * @return 日期
     */
    public static LocalDate endOfMonth(LocalDate localDate) {
        return localDate.with(lastDayOfMonth());
    }

    /**
     * 获取下个月的第一天
     *
     * @param localDate 日期
     * @return 日期
     */
    public static LocalDate beginOfNextMonth(LocalDate localDate) {
        return localDate.plus(1, MONTHS).with(firstDayOfMonth());
    }

    /**
     * 获取下个月的最后一天
     *
     * @param localDate 日期
     * @return 日期
     */
    public static LocalDate endOfNextMonth(LocalDate localDate) {
        return localDate.plus(1, MONTHS).with(lastDayOfMonth());
    }

    /**
     * 获取上个月的第一天
     *
     * @param localDate 日期
     * @return 日期
     */
    public static LocalDate beginOfPrevMonth(LocalDate localDate) {
        return localDate.minus(1, MONTHS).with(firstDayOfMonth());
    }

    /**
     * 获取上个月的最后一天
     *
     * @param localDate 日期
     * @return 日期
     */
    public static LocalDate endOfPrevMonth(LocalDate localDate) {
        return localDate.minus(1, MONTHS).with(lastDayOfMonth());
    }

    /**
     * 获取某周的第一天，默认第一天为周一
     *
     * @param localDate 日期
     * @return 日期
     */
    public static LocalDate beginOfWeek(LocalDate localDate) {
        return localDate.with(MONDAY);
    }

    /**
     * 获取某周的最后一天，默认最后一天为周日
     *
     * @param localDate 日期
     * @return 日期
     */
    public static LocalDate endOfWeek(LocalDate localDate) {
        return localDate.with(SUNDAY);
    }

    /**
     * 获取下一周的第一天，默认第一天为周一
     *
     * @param localDate 日期
     * @return 日期
     */
    public static LocalDate beginOfNextWeek(LocalDate localDate) {
        return localDate.plus(1, WEEKS).with(MONDAY);
    }

    /**
     * 获取下一周的最后一天，默认最后一天为周日
     *
     * @param localDate 日期
     * @return 日期
     */
    public static LocalDate endOfNextWeek(LocalDate localDate) {
        return localDate.plus(1, WEEKS).with(SUNDAY);
    }

    /**
     * 获取上一周的第一天，默认第一天为周一
     *
     * @param localDate 日期
     * @return 日期
     */
    public static LocalDate beginOfPrevWeek(LocalDate localDate) {
        return localDate.minus(1, WEEKS).with(MONDAY);
    }

    /**
     * 获取上一周的最后一天，默认最后一天为周日
     *
     * @param localDate 日期
     * @return 日期
     */
    public static LocalDate endOfPrevWeek(LocalDate localDate) {
        return localDate.minus(1, WEEKS).with(SUNDAY);
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
    public static long betweenYears(LocalDate begin, LocalDate end, boolean isAbs) {
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
    public static long betweenMonths(LocalDate begin, LocalDate end, boolean isAbs) {
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
    public static long betweenWeeks(LocalDate begin, LocalDate end, boolean isAbs) {
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
    public static long betweenDays(LocalDate begin, LocalDate end, boolean isAbs) {
        return LocalDateTimeUtils.betweenDays(toLocalDateTime(begin), toLocalDateTime(end), isAbs);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量的绝对值 (|end -begin|)
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @return 时间量的绝对值
     */
    public static long betweenYears(LocalDate begin, LocalDate end) {
        return betweenYears(begin, end, true);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量的绝对值 (|end -begin|)
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @return 时间量的绝对值
     */
    public static long betweenMonths(LocalDate begin, LocalDate end) {
        return betweenMonths(begin, end, true);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量的绝对值 (|end -begin|)
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @return 时间量的绝对值
     */
    public static long betweenWeeks(LocalDate begin, LocalDate end) {
        return betweenWeeks(begin, end, true);
    }

    /**
     * 根据指定的单位计算从开始日期到结束日期之间的时间量的绝对值 (|end -begin|)
     *
     * @param begin 开始日期
     * @param end   结束日期
     * @return 时间量的绝对值
     */
    public static long betweenDays(LocalDate begin, LocalDate end) {
        return betweenDays(begin, end, true);
    }

    /**
     * 两个日期作比较
     *
     * @param first  第一个
     * @param second 第二个
     * @return 第一个小于第二个，返回 -1；第一个等于第二个返回 0；第一个大于第二个， 返回 1。
     */
    public static int compare(LocalDate first, LocalDate second) {
        return first.compareTo(second);
    }

    /**
     * 判断第一个日期是不是在第二个日期之后
     *
     * @param first  第一个
     * @param second 第二个
     * @return 第一个日期是不是在第二个日期之后
     */
    public static boolean isAfter(LocalDate first, LocalDate second) {
        return first.isAfter(second);
    }

    /**
     * 判断第一个日期是不是在第二个日期之前
     *
     * @param first  第一个
     * @param second 第二个
     * @return 第一个日期是不是在第二个日期之前
     */
    public static boolean isBefore(LocalDate first, LocalDate second) {
        return first.isBefore(second);
    }

    /**
     * 判断第一个日期是不是和第二个日期相等
     *
     * @param first  第一个
     * @param second 第二个
     * @return 第一个日期是不是和第二个日期相等
     */
    public static boolean isEqual(LocalDate first, LocalDate second) {
        return first.isEqual(second);
    }

    /**
     * 判断两个日期是否是同一年
     *
     * @param first  第一个
     * @param second 第二个
     * @return 两个日期是否是同一年
     */
    public static boolean isEqualYear(LocalDate first, LocalDate second) {
        return Year.from(first).equals(Year.from(second));
    }

    /**
     * 判断两个日期是否是同一个月
     *
     * @param first  第一个
     * @param second 第二个
     * @return 两个日期是否是同一个月
     */
    public static boolean isEqualMonth(LocalDate first, LocalDate second) {
        return Month.from(first).equals(Month.from(second));
    }

    /**
     * 判断两个日期是否是同一个星期
     *
     * @param first  第一个
     * @param second 第二个
     * @return 两个日期是否是同一个星期
     */
    public static boolean isEqualWeek(LocalDate first, LocalDate second) {
        return DayOfWeek.from(first).equals(DayOfWeek.from(second));
    }

    /**
     * 判断两个日期是否是同一天
     *
     * @param first  第一个
     * @param second 第二个
     * @return 两个日期是否是同一天
     */
    public static boolean isEqualDay(LocalDate first, LocalDate second) {
        return first.get(DAY_OF_MONTH) == second.get(DAY_OF_MONTH) && isEqualMonth(first, second);
    }

    /**
     * 判断指定日期是否在指定的范围内
     *
     * @param localDate 日期
     * @param begin     开始日期 (包含)
     * @param end       结束日期 (包含)
     * @return 是否在指定的范围内
     */
    public static boolean isIn(LocalDate localDate, LocalDate begin, LocalDate end) {
        final long beginEpochMilli = toEpochMilli(begin);
        final long endEpochMilli = toEpochMilli(end);
        final long epochMilli = toEpochMilli(localDate);
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
    public static boolean isOverlap(LocalDate firstBegin, LocalDate firstEnd,
                                    LocalDate secondBegin, LocalDate secondEnd) {
        return (secondBegin.compareTo(firstEnd) <= 0) && (secondEnd.compareTo(firstBegin) >= 0);
    }

    //endregion

    //region 日期格式化

    /**
     * 格式化日期
     *
     * @param localDate 日期
     * @param pattern   格式
     * @return 格式化后的字符串
     * @see DatePattern
     */
    public static String format(LocalDate localDate, String pattern) {
        return DateFormatter.ofPattern(pattern).format(localDate);
    }

    /**
     * 格式化日期
     *
     * @param localDate   日期
     * @param datePattern 格式
     * @return 格式化后的字符串
     * @see DatePattern
     */
    public static String format(LocalDate localDate, DatePattern datePattern) {
        return DateFormatter.ofDatePattern(datePattern).format(localDate);
    }

    /**
     * 格式化日期
     *
     * @param localDate         日期
     * @param dateTimeFormatter {@link DateTimeFormatter}
     * @return 格式化后的字符串
     */
    public static String format(LocalDate localDate, DateTimeFormatter dateTimeFormatter) {
        return dateTimeFormatter.format(localDate);
    }

    /**
     * 格式化日期
     * <p>格式：yyyy-MM-dd
     *
     * @param localDate 日期
     * @return 格式化后的字符串
     */
    public static String format(LocalDate localDate) {
        return DateFormatter.NORMAL_DATE.format(localDate);
    }

    /**
     * 格式化日期
     * <p>格式：yyyyMMdd
     *
     * @param localDate 日期
     * @return 格式化后的字符串
     */
    public static String formatOfSimple(LocalDate localDate) {
        return DateFormatter.SIMPLE_DATE.format(localDate);
    }

    /**
     * 格式化日期
     * <p>格式：yyyy年MM月dd日
     *
     * @param localDate 日期
     * @return 格式化后的字符串
     */
    public static String formatOfChinese(LocalDate localDate) {
        return DateFormatter.CHINESE_DATE.format(localDate);
    }

    //endregion

    //region 日期解析

    /**
     * 解析日期
     *
     * @param text    文本
     * @param pattern 格式
     * @return {@link LocalDate}
     * @see DatePattern
     */
    public static LocalDate parse(CharSequence text, String pattern) {
        return DateParser.parseLocalDate(text, DateFormatter.ofPattern(pattern));
    }

    /**
     * 解析日期
     *
     * @param text        文本
     * @param datePattern 格式
     * @return {@link LocalDate}
     * @see DatePattern
     */
    public static LocalDate parse(CharSequence text, DatePattern datePattern) {
        return DateParser.parseLocalDate(text, DateFormatter.ofDatePattern(datePattern));
    }

    /**
     * 解析日期
     *
     * @param text              文本
     * @param dateTimeFormatter {@link DateTimeFormatter}
     * @return {@link LocalDate}
     */
    public static LocalDate parse(CharSequence text, DateTimeFormatter dateTimeFormatter) {
        return DateParser.parseLocalDate(text, dateTimeFormatter);
    }

    /**
     * 解析日期
     * <p>格式：yyyy-MM-dd
     *
     * @param text 文本
     * @return {@link LocalDate}
     */
    public static LocalDate parse(CharSequence text) {
        return DateParser.parseLocalDate(text, DateFormatter.NORMAL_DATE);
    }

    /**
     * 解析日期
     * <p>格式：yyyyMMdd
     *
     * @param text 文本
     * @return {@link LocalDate}
     */
    public static LocalDate parseOfSimple(CharSequence text) {
        return DateParser.parseLocalDate(text, DateFormatter.SIMPLE_DATE);
    }

    /**
     * 解析日期部分
     * <p>格式：yyyy年MM月dd日
     *
     * @param text 文本
     * @return {@link LocalDate}
     */
    public static LocalDate parseOfChinese(CharSequence text) {
        return DateParser.parseLocalDate(text, DateFormatter.CHINESE_DATE);
    }

    //endregion
}
