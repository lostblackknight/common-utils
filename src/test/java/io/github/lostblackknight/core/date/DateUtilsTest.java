package io.github.lostblackknight.core.date;

import cn.hutool.core.date.DateUtil;
import io.github.lostblackknight.core.date.format.DateFormatter;
import io.github.lostblackknight.core.date.format.DatePattern;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author chensixiang (chensixiang1234@gmail.com) 2022/8/21 10:26
 * @version 1.0.0
 */
class DateUtilsTest {

    private final Date date = DateUtils.current();

    @Test
    void current() {
        System.out.println(DateUtils.current());
    }

    @Test
    void currentIsWeekend() {
        System.out.println(DateUtils.currentIsWeekend());
    }

    @Test
    void of() {
        System.out.println(DateUtils.of(System.currentTimeMillis()));
    }

    @Test
    void testOf() {
        System.out.println(DateUtils.of(2022, 8, 21));
    }

    @Test
    void testOf1() {
        System.out.println(DateUtils.of(2022, 8, 21, 14, 24));
    }

    @Test
    void testOf2() {
        System.out.println(DateUtils.of(2022, 8, 21, 14, 24, 32));
    }

    @Test
    void year() {
        System.out.println(DateUtils.year(date));
    }

    @Test
    void month() {
        System.out.println(DateUtils.month(date));
    }

    @Test
    void weekOfYear() {
        System.out.println(DateUtils.weekOfYear(date));
        System.out.println(DateUtil.weekOfYear(date));
    }

    @Test
    void dayOfYear() {
        System.out.println(DateUtils.dayOfYear(date));
        System.out.println(DateUtil.dayOfYear(date));
    }

    @Test
    void weekOfMonth() {
        System.out.println(DateUtils.weekOfMonth(date));
        System.out.println(DateUtil.weekOfMonth(date));
    }

    @Test
    void dayOfMonth() {
        System.out.println(DateUtils.dayOfMonth(date));
        System.out.println(DateUtil.dayOfMonth(date));
    }

    @Test
    void dayOfWeek() {
        System.out.println(DateUtils.dayOfWeek(date));
        System.out.println(DateUtil.dayOfWeek(date));
    }

    @Test
    void hourOf24() {
        System.out.println(DateUtils.hourOf24(date));
        System.out.println(DateUtil.hour(date, true));
    }

    @Test
    void hourOf12() {
        System.out.println(DateUtils.hourOf12(date));
        System.out.println(DateUtil.hour(date, false));
    }

    @Test
    void minute() {
        System.out.println(DateUtils.minute(date));
        System.out.println(DateUtil.minute(date));
    }

    @Test
    void second() {
        System.out.println(DateUtils.second(date));
        System.out.println(DateUtil.second(date));
    }

    @Test
    void milli() {
        System.out.println(DateUtils.milli(date));
        System.out.println(DateUtil.millisecond(date));
    }

    @Test
    void isLeapYear() {
        System.out.println(DateUtils.isLeapYear(date));
        System.out.println(DateUtil.isLeapYear(DateUtil.year(date)));
    }

    @Test
    void isWeekend() {
        System.out.println(DateUtils.isWeekend(date));
        System.out.println(DateUtil.isWeekend(date));
    }

    @Test
    void isAM() {
        System.out.println(DateUtils.isAM(date));
        System.out.println(DateUtil.isAM(date));
    }

    @Test
    void isPM() {
        System.out.println(DateUtils.isPM(date));
        System.out.println(DateUtil.isPM(date));
    }

    @Test
    void lengthOfYear() {
        System.out.println(DateUtils.lengthOfYear(date));
        System.out.println(DateUtil.lengthOfYear(DateUtil.year(date)));
    }

    @Test
    void lengthOfMonth() {
        System.out.println(DateUtils.lengthOfMonth(date));
        System.out.println(DateUtil.lengthOfMonth(DateUtil.month(date), DateUtils.isLeapYear(DateUtils.year(date))));
    }

    @Test
    void currentYear() {
        // given

        // when

        // then
    }

    @Test
    void currentMonth() {
        // given

        // when

        // then
    }

    @Test
    void currentWeekOfYear() {
        // given

        // when

        // then
    }

    @Test
    void currentDayOfYear() {
        // given

        // when

        // then
    }

    @Test
    void currentWeekOfMonth() {
        // given

        // when

        // then
    }

    @Test
    void currentDayOfMonth() {
        // given

        // when

        // then
    }

    @Test
    void currentDayOfWeek() {
        // given

        // when

        // then
    }

    @Test
    void currentHourOf24() {
        // given

        // when

        // then
    }

    @Test
    void currentHourOf12() {
        // given

        // when

        // then
    }

    @Test
    void currentMinute() {
        // given

        // when

        // then
    }

    @Test
    void currentSecond() {
        // given

        // when

        // then
    }

    @Test
    void currentMilli() {
        // given

        // when

        // then
    }

    @Test
    void currentIsLeapYear() {
        // given

        // when

        // then
    }

    @Test
    void currentIsAM() {
        // given

        // when

        // then
    }

    @Test
    void currentIsPM() {
        // given

        // when

        // then
    }

    @Test
    void currentLengthOfYear() {
        // given

        // when

        // then
    }

    @Test
    void currentLengthOfMonth() {
        // given

        // when

        // then
    }

    @Test
    void plusYears() {
        System.out.println(DateUtils.plusYears(date, 1));
    }

    @Test
    void plusMonths() {
        System.out.println(DateUtils.plusMonths(date, 1));
    }

    @Test
    void plusWeeks() {
        // given

        // when

        // then
    }

    @Test
    void plusDays() {
        // given

        // when

        // then
    }

    @Test
    void plusHours() {
        // given

        // when

        // then
    }

    @Test
    void plusMinutes() {
        // given

        // when

        // then
    }

    @Test
    void plusSeconds() {
        // given

        // when

        // then
    }

    @Test
    void plusMillis() {
        // given

        // when

        // then
    }

    @Test
    void minusYears() {
        // given

        // when

        // then
    }

    @Test
    void minusMonths() {
        // given

        // when

        // then
    }

    @Test
    void minusWeeks() {
        // given

        // when

        // then
    }

    @Test
    void minusDays() {
        // given

        // when

        // then
    }

    @Test
    void minusHours() {
        // given

        // when

        // then
    }

    @Test
    void minusMinutes() {
        // given

        // when

        // then
    }

    @Test
    void minusSeconds() {
        // given

        // when

        // then
    }

    @Test
    void minusMillis() {
        // given

        // when

        // then
    }

    @Test
    void beginOfYear() {
        // given

        // when

        // then
    }

    @Test
    void endOfYear() {
        // given

        // when

        // then
    }

    @Test
    void beginOfNextYear() {
        // given

        // when

        // then
    }

    @Test
    void endOfNextYear() {
        // given

        // when

        // then
    }

    @Test
    void beginOfPrevYear() {
        // given

        // when

        // then
    }

    @Test
    void endOfPrevYear() {
        // given

        // when

        // then
    }

    @Test
    void beginOfMonth() {
        System.out.println(DateUtils.beginOfMonth(date));
    }

    @Test
    void endOfMonth() {
        // given

        // when

        // then
    }

    @Test
    void beginOfNextMonth() {
        // given

        // when

        // then
    }

    @Test
    void endOfNextMonth() {
        System.out.println(DateUtils.endOfNextMonth(date));
    }

    @Test
    void beginOfPrevMonth() {
        // given

        // when

        // then
    }

    @Test
    void endOfPrevMonth() {
        // given

        // when

        // then
    }

    @Test
    void beginOfWeek() {
        // given

        // when

        // then
    }

    @Test
    void endOfWeek() {
        // given

        // when

        // then
    }

    @Test
    void beginOfNextWeek() {
        // given

        // when

        // then
    }

    @Test
    void endOfNextWeek() {
        // given

        // when

        // then
    }

    @Test
    void beginOfPrevWeek() {
        // given

        // when

        // then
    }

    @Test
    void endOfPrevWeek() {
        // given

        // when

        // then
    }

    @Test
    void beginOfDay() {
        // given

        // when

        // then
    }

    @Test
    void endOfDay() {
        // given

        // when

        // then
    }

    @Test
    void beginOfNextDay() {
        // given

        // when

        // then
    }

    @Test
    void endOfNextDay() {
        // given

        // when

        // then
    }

    @Test
    void beginOfPrevDay() {
        // given

        // when

        // then
    }

    @Test
    void endOfPrevDay() {
        // given

        // when

        // then
    }

    @Test
    void beginOfHour() {
        // given

        // when

        // then
    }

    @Test
    void endOfHour() {
        // given

        // when

        // then
    }

    @Test
    void beginOfMinute() {
        // given

        // when

        // then
    }

    @Test
    void endOfMinute() {
        // given

        // when

        // then
    }

    @Test
    void beginOfSecond() {
        // given

        // when

        // then
    }

    @Test
    void endOfSecond() {
        // given

        // when

        // then
    }

    @Test
    void betweenYears() {
        // given

        // when

        // then
    }

    @Test
    void betweenMonths() {
        // given

        // when

        // then
    }

    @Test
    void betweenWeeks() {
        // given

        // when

        // then
    }

    @Test
    void betweenDays() {
        // given

        // when

        // then
    }

    @Test
    void betweenHours() {
        // given

        // when

        // then
    }

    @Test
    void betweenMinutes() {
        // given

        // when

        // then
    }

    @Test
    void betweenSeconds() {
        // given

        // when

        // then
    }

    @Test
    void betweenMillis() {
        // given

        // when

        // then
    }

    @Test
    void testBetweenYears() {
        // given

        // when

        // then
    }

    @Test
    void testBetweenMonths() {
        // given

        // when

        // then
    }

    @Test
    void testBetweenWeeks() {
        // given

        // when

        // then
    }

    @Test
    void testBetweenDays() {
        // given

        // when

        // then
    }

    @Test
    void testBetweenHours() {
        // given

        // when

        // then
    }

    @Test
    void testBetweenMinutes() {
        // given

        // when

        // then
    }

    @Test
    void testBetweenSeconds() {
        // given

        // when

        // then
    }

    @Test
    void testBetweenMillis() {
        // given

        // when

        // then
    }

    @Test
    void compare() {
        // given

        // when

        // then
    }

    @Test
    void isAfter() {
        // given

        // when

        // then
    }

    @Test
    void isBefore() {
        // given

        // when

        // then
    }

    @Test
    void isEqual() {
        // given

        // when

        // then
    }

    @Test
    void isEqualYear() {
        // given

        // when

        // then
    }

    @Test
    void isEqualMonth() {
        // given

        // when

        // then
    }

    @Test
    void isEqualWeek() {
        // given

        // when

        // then
    }

    @Test
    void isEqualDay() {
        // given

        // when

        // then
    }

    @Test
    void isEqualHour() {
        // given

        // when

        // then
    }

    @Test
    void isEqualMinute() {
        // given

        // when

        // then
    }

    @Test
    void isEqualSecond() {
        // given

        // when

        // then
    }

    @Test
    void isEqualMilli() {
        // given

        // when

        // then
    }

    @Test
    void isIn() {
        // given

        // when

        // then
    }

    @Test
    void isOverlap() {
        // given

        // when

        // then
    }

    @Test
    void format() {
        System.out.println(DateUtils.format(date, DatePattern.NORMAL_DATE));
    }

    @Test
    void testFormat() {
        System.out.println(DateUtils.format(date, "yyyy/MM/dd HH/mm/ss"));
    }

    @Test
    void testFormat1() {
    }

    @Test
    void testFormat2() {
        System.out.println(DateUtils.format(date));
    }

    @Test
    void formatDate() {
        System.out.println(DateUtils.formatDate(date));
    }

    @Test
    void formatTime() {
        System.out.println(DateUtils.formatTime(date));
    }

    @Test
    void formatOfSimple() {
        System.out.println(DateUtils.formatOfSimple(date));
    }

    @Test
    void formatDateOfSimple() {
        System.out.println(DateUtils.formatDateOfSimple(date));
    }

    @Test
    void formatTimeOfSimple() {
        System.out.println(DateUtils.formatTimeOfSimple(date));
    }

    @Test
    void formatOfChinese() {
        System.out.println(DateUtils.formatOfChinese(date));
    }

    @Test
    void formatDateOfChinese() {
        System.out.println(DateUtils.formatDateOfChinese(date));
    }

    @Test
    void formatTimeOfChinese() {
        System.out.println(DateUtils.formatTimeOfChinese(date));
    }

    @Test
    void parse() throws ParseException {
        final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        final Date date1 = format.parse("11:30:20");
        System.out.println(date1);

        final Date date2 = DateUtils.toDate(LocalDate.parse("20220625", DateFormatter.ofPattern("yyyyMMdd")));
        System.out.println(date2);

        System.out.println(DateUtils.parse("2022", DatePattern.NORMAL_YEAR));
        System.out.println(DateUtils.parse("2022-04", DatePattern.NORMAL_MONTH));
        System.out.println(DateUtils.parse("2022-04-30", DatePattern.NORMAL_DATE));
        System.out.println(DateUtils.parse("11:30:20", DatePattern.NORMAL_TIME));
    }

    @Test
    void testParse() {
        // given

        // when

        // then
    }

    @Test
    void testParse1() {
        System.out.println(DateUtils.parse("2022", DateFormatter.ofPattern("yyyy")));
    }

    @Test
    void testParse2() {
        System.out.println(DateUtils.parse("2022-04-30 12:30:06"));
    }

    @Test
    void parseDate() {
        System.out.println(DateUtils.parseDate("2022-04-30"));
    }

    @Test
    void parseTime() {
        System.out.println(DateUtils.parseTime("12:50:06"));
    }

    @Test
    void parseOfSimple() {
        // given

        // when

        // then
    }

    @Test
    void parseDateOfSimple() {
        // given

        // when

        // then
    }

    @Test
    void parseTimeOfSimple() {
        // given

        // when

        // then
    }

    @Test
    void parseOfChinese() {
        // given

        // when

        // then
    }

    @Test
    void parseDateOfChinese() {
        // given

        // when

        // then
    }

    @Test
    void parseTimeOfChinese() {
        // given

        // when

        // then
    }

    @Test
    void testParse3() {
        System.out.println(DateUtil.format(DateUtils.parse("2022", "yyyy"), cn.hutool.core.date.DatePattern.NORM_DATETIME_PATTERN));
        System.out.println(DateUtil.parse("2022", "yyyy"));
        System.out.println(DateUtil.format(DateUtils.parse("2022-08-21 22:02:30", "yyyy-MM-dd HH:mm:ss"), cn.hutool.core.date.DatePattern.NORM_DATETIME_PATTERN));
        System.out.println(DateUtil.parse("2022-08-21 22:02:30", "yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateUtil.format(DateUtils.parse("2022-08", "yyyy-MM"), cn.hutool.core.date.DatePattern.NORM_DATETIME_PATTERN));
        System.out.println(DateUtil.parse("2022-08-21", "yyyy-MM"));
        System.out.println(DateUtil.format(DateUtils.parse("22:02:30.666", "mm:HH:ss.SSS"), cn.hutool.core.date.DatePattern.NORM_DATETIME_MS_PATTERN));
        System.out.println(DateUtil.format(DateUtil.parse("22:02:30.666", "mm:HH:ss.SSS"), cn.hutool.core.date.DatePattern.NORM_DATETIME_MS_PATTERN));
    }

    @Test
    void testParse4() {
        System.out.println(DateUtils.parse("2022-08-21", DatePattern.NORMAL_DATE));
        System.out.println(DateUtils.parse("20220821", DatePattern.SIMPLE_DATE));
        System.out.println(DateUtils.parse("2022年08月21日", DatePattern.CHINESE_DATE));
        System.out.println(DateUtils.parse("22:02:30", DatePattern.NORMAL_TIME));
        System.out.println(DateUtils.parse("220230", DatePattern.SIMPLE_TIME));
        System.out.println(DateUtils.parse("22时02分30秒", DatePattern.CHINESE_TIME));
        System.out.println(DateUtils.parse("2022-08-21 22:02:30", DatePattern.NORMAL_DATE_TIME_SECOND));
        System.out.println(DateUtils.parse("20220821220230", DatePattern.SIMPLE_DATE_TIME_SECOND));
        System.out.println(DateUtils.parse("2022年08月21日22时02分30秒", DatePattern.CHINESE_DATE_TIME_SECOND));
        System.out.println(DateUtils.parse("2022/04/30", "yyyy/MM/dd"));
    }

    @Test
    void testParse5() {
        System.out.println(DateUtils.parse("2022-04-30 12:30:59"));
        System.out.println(DateUtils.parseDate("2022-04-30"));
        System.out.println(DateUtils.parseTime("12:30:59"));
    }
}