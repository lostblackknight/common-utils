package io.github.lostblackknight.core.date;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Date;

import static cn.hutool.core.date.DateField.WEEK_OF_MONTH;
import static java.time.LocalDateTime.now;

/**
 * @author chensixiang (chensixiang1234@gmail.com)
 * @since 2022/8/19 21:59
 */
class LocalDateTimeUtilsTest {

    private final LocalDateTime localDateTime = now();

    private final LocalDateTime customLocalDateTime = LocalDateTime.of(2020, 2, 28, 12, 5, 30);

    private final LocalDateTime firstDayOfYear = LocalDateTime.of(2022, 8, 31, 0, 0, 0);

    private final Date date = new Date();

    private final Date customDate = LocalDateTimeUtils.toDate(customLocalDateTime);

    private final Date firstDayOfYearForDate = LocalDateTimeUtils.toDate(firstDayOfYear);

    @Test
    void year() {
        System.out.println(LocalDateTimeUtils.year(localDateTime));
        System.out.println(DateUtil.year(date));
//        DateUtil.isOverlap()
    }

    @Test
    void month() {
        System.out.println(LocalDateTimeUtils.month(localDateTime));
        System.out.println(DateUtil.month(date) + 1);
    }

    @Test
    void weekOfYear() {
        System.out.println(LocalDateTimeUtils.weekOfYear(firstDayOfYear));
        System.out.println(DateUtil.weekOfYear(firstDayOfYearForDate));
    }

    @Test
    void dayOfYear() {
        System.out.println(LocalDateTimeUtils.dayOfYear(localDateTime));
        System.out.println(DateUtil.dayOfYear(date));
    }

    @Test
    void weekOfMonth() {
        System.out.println(LocalDateTimeUtils.weekOfMonth(firstDayOfYear));
        System.out.println(DateUtil.weekOfMonth(firstDayOfYearForDate));
    }

    @Test
    void dayOfMonth() {
        System.out.println(LocalDateTimeUtils.dayOfMonth(localDateTime));
        System.out.println(DateUtil.dayOfMonth(date));
    }

    @Test
    void dayOfWeek() {
        System.out.println(LocalDateTimeUtils.dayOfWeek(localDateTime));
        System.out.println(DateUtil.dayOfWeek(date) - 1);
    }

    @Test
    void hourOf24() {
        System.out.println(LocalDateTimeUtils.hourOf24(localDateTime));
        System.out.println(DateUtil.hour(date, true));
    }

    @Test
    void hourOf12() {
        System.out.println(LocalDateTimeUtils.hourOf12(localDateTime));
        System.out.println(DateUtil.hour(date, false));
    }

    @Test
    void minute() {
        System.out.println(LocalDateTimeUtils.minute(localDateTime));
        System.out.println(DateUtil.minute(date));
    }

    @Test
    void second() {
        System.out.println(LocalDateTimeUtils.second(localDateTime));
        System.out.println(DateUtil.second(date));
    }

    @Test
    void millisecond() {
        System.out.println(LocalDateTimeUtils.milli(localDateTime));
        System.out.println(DateUtil.millisecond(date));
    }

    @Test
    void isAM() {
        System.out.println(LocalDateTimeUtils.isAM(localDateTime));
        System.out.println(DateUtil.isAM(date));
    }

    @Test
    void isPM() {
        System.out.println(LocalDateTimeUtils.isPM(localDateTime));
        System.out.println(DateUtil.isPM(date));
    }

    @Test
    void plusYears() {
        System.out.println(DateUtil.isLeapYear(DateUtil.offset(customDate, DateField.YEAR, 4).year()));
        System.out.println(LocalDateTimeUtils.isLeapYear(LocalDateTimeUtils.plusYears(customLocalDateTime, 4)));
    }

    @Test
    void plusMonths() {
        System.out.println(LocalDateTimeUtils.plusMonths(firstDayOfYear, 1));
        DateUtil.offsetMonth(date, 1);
    }

    @Test
    void current() {
        // given

        // when

        // then
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
    void plusDays() {
        System.out.println(DateUtil.offsetDay(date, 2));
        System.out.println(LocalDateTimeUtils.plusDays(localDateTime, 2));
    }

    @Test
    void firstDayOfYear() {
        // given
        // when

        // then
    }

    @Test
    void lastDayOfYear() {
        // given

        // when

        // then
    }

    @Test
    void firstDayOfNextYear() {
        // given

        // when

        // then
    }

    @Test
    void lastDayOfNextYear() {
        // given

        // when

        // then
    }

    @Test
    void firstDayOfPrevYear() {
        // given

        // when

        // then
    }

    @Test
    void lastDayOfPrevYear() {
        // given

        // when

        // then
    }

    @Test
    void isLeapYear() {
        System.out.println(DateUtil.isLeapYear(2022));
    }

    @Test
    void lengthOfYear() {
        // given

        // when

        // then
    }

    @Test
    void firstDayOfMonth() {
        // given

        // when

        // then
    }

    @Test
    void lastDayOfMonth() {
        // given

        // when

        // then
    }

    @Test
    void firstDayOfNextMonth() {
        // given

        // when

        // then
    }

    @Test
    void lastDayOfNextMonth() {
        // given

        // when

        // then
    }

    @Test
    void firstDayOfPrevMonth() {
        // given

        // when

        // then
    }

    @Test
    void lastDayOfPrevMonth() {
        // given

        // when

        // then
    }

    @Test
    void lengthOfMonth() {
        // given

        // when

        // then
    }

    @Test
    void toDate() {
        // given

        // when

        // then
    }

    @Test
    void testToDate() {
        // given

        // when

        // then
    }

    @Test
    void toLocalDate() {
        // given

        // when

        // then
    }

    @Test
    void testToLocalDate() {
        // given

        // when

        // then
    }

    @Test
    void toLocalDateTime() {
        // given

        // when

        // then
    }

    @Test
    void testToLocalDateTime() {
        // given
        // when

        // then
    }

    @Test
    void compare() {
        System.out.println(LocalDateTimeUtils.compare(localDateTime, localDateTime));
        System.out.println(LocalDateTimeUtils.compare(LocalDateTimeUtils.plusMillis(localDateTime, 2), localDateTime));
    }

    @Test
    void milli() {
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
    void plusWeeks() {
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
    void testBetweenYears() {
        // given

        // when

        // then
    }

    @Test
    void testBetweenMonths() {
        // given
        System.out.println(LocalDateTimeUtils.betweenMonths(localDateTime, LocalDateTimeUtils.plusYears(localDateTime, 1)));
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
        System.out.println(LocalDateTimeUtils.betweenHours(now().plusDays(2), now()));
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
    void betweenYearsAbs() {
        // given

        // when

        // then
    }

    @Test
    void betweenMonthsAbs() {
        // given

        // when

        // then
    }

    @Test
    void betweenWeeksAbs() {
        // given

        // when

        // then
    }

    @Test
    void betweenDaysAbs() {
        // given

        // when

        // then
    }

    @Test
    void betweenHoursAbs() {
        // given

        // when

        // then
    }

    @Test
    void betweenMinutesAbs() {
        // given

        // when

        // then
    }

    @Test
    void betweenSecondsAbs() {
        // given

        // when

        // then
    }

    @Test
    void betweenMillisAbs() {
        // given

        // when

        // then
    }

    @Test
    void isWeekend() {
        System.out.println(LocalDateTimeUtils.isWeekend(localDateTime.plusDays(2)));
    }

    @Test
    void currentIsLeapYear() {
        // given

        // when

        // then
    }

    @Test
    void currentIsWeekend() {
        // given

        // when

        // then
    }

    @Test
    void testFirstDayOfYear() {
        System.out.println(LocalDateTimeUtils.beginOfYear(customLocalDateTime));
        System.out.println(DateUtil.beginOfYear(customDate));
    }

    @Test
    void testLastDayOfYear() {
        System.out.println(LocalDateTimeUtils.endOfYear(customLocalDateTime));
        System.out.println(DateUtil.endOfYear(customDate));
    }

    @Test
    void testFirstDayOfNextYear() {
        System.out.println(LocalDateTimeUtils.beginOfNextYear(customLocalDateTime));
    }

    @Test
    void testLastDayOfNextYear() {
        System.out.println(LocalDateTimeUtils.endOfNextYear(customLocalDateTime));
    }

    @Test
    void testFirstDayOfPrevYear() {
        System.out.println(LocalDateTimeUtils.beginOfPrevYear(customLocalDateTime));
    }

    @Test
    void testLastDayOfPrevYear() {
        System.out.println(LocalDateTimeUtils.endOfPrevYear(customLocalDateTime));
    }

    @Test
    void testFirstDayOfMonth() {
        System.out.println(LocalDateTimeUtils.beginOfMonth(customLocalDateTime));
    }

    @Test
    void testLastDayOfMonth() {
        System.out.println(LocalDateTimeUtils.endOfMonth(customLocalDateTime));
    }

    @Test
    void testFirstDayOfNextMonth() {
        System.out.println(LocalDateTimeUtils.beginOfNextMonth(customLocalDateTime));
    }

    @Test
    void testLastDayOfNextMonth() {
        System.out.println(LocalDateTimeUtils.endOfNextMonth(customLocalDateTime));
    }

    @Test
    void testFirstDayOfPrevMonth() {
        System.out.println(LocalDateTimeUtils.beginOfPrevMonth(customLocalDateTime));
    }

    @Test
    void testLastDayOfPrevMonth() {
        System.out.println(LocalDateTimeUtils.endOfPrevMonth(customLocalDateTime));
    }

    @Test
    void firstDayOfWeek() {
        System.out.println(LocalDateTimeUtils.beginOfWeek(customLocalDateTime));
        System.out.println(DateUtil.beginOfWeek(customDate));
    }

    @Test
    void lastDayOfWeek() {
        System.out.println(LocalDateTimeUtils.endOfWeek(customLocalDateTime));
        System.out.println(DateUtil.endOfWeek(customDate));
    }

    @Test
    void firstDayOfNextWeek() {
        System.out.println(LocalDateTimeUtils.beginOfNextWeek(customLocalDateTime));
        System.out.println(DateUtil.beginOfWeek(DateUtil.offset(customDate, WEEK_OF_MONTH, 1)));
    }

    @Test
    void lastDayOfNextWeek() {
        System.out.println(LocalDateTimeUtils.endOfNextWeek(customLocalDateTime));
        System.out.println(DateUtil.endOfWeek(DateUtil.offset(customDate, WEEK_OF_MONTH, 1)));
    }

    @Test
    void firstDayOfPrevWeek() {
        System.out.println(LocalDateTimeUtils.beginOfPrevWeek(customLocalDateTime));
        System.out.println(DateUtil.beginOfWeek(DateUtil.offset(customDate, WEEK_OF_MONTH, -1)));
    }

    @Test
    void lastDayOfPrevWeek() {
        System.out.println(LocalDateTimeUtils.endOfPrevWeek(customLocalDateTime));
        System.out.println(DateUtil.endOfWeek(DateUtil.offset(customDate, WEEK_OF_MONTH, -1)));
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
        // given

        // when

        // then
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
        // given

        // when

        // then
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
        System.out.println(LocalDateTimeUtils.beginOfDay(customLocalDateTime));
        System.out.println(DateUtil.beginOfDay(customDate));
    }

    @Test
    void endOfDay() {
        System.out.println(LocalDateTimeUtils.endOfDay(customLocalDateTime));
        System.out.println(DateUtil.endOfDay(customDate));
    }

    @Test
    void beginOfNextDay() {
        System.out.println(LocalDateTimeUtils.beginOfNextDay(localDateTime));
    }

    @Test
    void endOfNextDay() {
        System.out.println(LocalDateTimeUtils.endOfNextDay(localDateTime));
    }

    @Test
    void beginOfPrevDay() {
        System.out.println(LocalDateTimeUtils.beginOfPrevDay(localDateTime));
    }

    @Test
    void endOfPrevDay() {
        System.out.println(LocalDateTimeUtils.endOfPrevDay(localDateTime));
    }

    @Test
    void beginOfHour() {
        System.out.println(LocalDateTimeUtils.beginOfHour(localDateTime));
        System.out.println(DateUtil.beginOfHour(date));
    }

    @Test
    void endOfHour() {
        System.out.println(LocalDateTimeUtils.endOfHour(localDateTime));
        System.out.println(DateUtil.endOfHour(date));
    }

    @Test
    void beginOfMinute() {
        System.out.println(LocalDateTimeUtils.beginOfMinute(localDateTime));
        System.out.println(DateUtil.beginOfMinute(date));
    }

    @Test
    void endOfMinute() {
        System.out.println(LocalDateTimeUtils.endOfMinute(localDateTime));
        System.out.println(DateUtil.endOfMinute(date));
    }

    @Test
    void beginOfSecond() {
        System.out.println(DateUtil.beginOfSecond(date));
        System.out.println(LocalDateTimeUtils.beginOfSecond(localDateTime));
    }

    @Test
    void endOfSecond() {
        System.out.println(DateUtil.endOfSecond(date));
        System.out.println(LocalDateTimeUtils.endOfSecond(localDateTime));
    }

    @Test
    void currentLengthOfYear() {
        System.out.println(LocalDateTimeUtils.currentLengthOfYear());
    }

    @Test
    void currentLengthOfMonth() {
        System.out.println(LocalDateTimeUtils.currentLengthOfMonth());
    }

    @Test
    void isIn() {
        System.out.println(LocalDateTimeUtils.isIn(localDateTime, localDateTime.plusSeconds(1), localDateTime.plusSeconds(1)));
        DateUtil.beginOfSecond(date);
    }

    @Test
    void isAfter() {
        System.out.println(LocalDateTimeUtils.isAfter(localDateTime, localDateTime.plusSeconds(-1)));
    }

    @Test
    void isBefore() {
        System.out.println(LocalDateTimeUtils.isBefore(localDateTime, localDateTime.plusSeconds(-1)));
    }

    @Test
    void isEqual() {
        System.out.println(LocalDateTimeUtils.isEqual(localDateTime, localDateTime.plusSeconds(-1)));
    }

    @Test
    void isEqualYear() {
        System.out.println(LocalDateTimeUtils.isEqualYear(localDateTime, localDateTime.plusYears(1)));
    }

    @Test
    void isEqualMonth() {
        System.out.println(LocalDateTimeUtils.isEqualMonth(localDateTime, localDateTime.plusMonths(1)));
    }

    @Test
    void isEqualWeek() {
        System.out.println(LocalDateTimeUtils.isEqualWeek(localDateTime, localDateTime.plusDays(7)));
    }

    @Test
    void isEqualDay() {
        System.out.println(LocalDateTimeUtils.isEqualDay(localDateTime, localDateTime.plusHours(1)));
    }

    @Test
    void isEqualHour() {
        System.out.println(LocalDateTimeUtils.isEqualHour(localDateTime, localDateTime.plusSeconds(1)));
    }

    @Test
    void isEqualMinute() {
        System.out.println(LocalDateTimeUtils.isEqualMinute(localDateTime, localDateTime.plusDays(1)));
    }

    @Test
    void isEqualSecond() {
        System.out.println(LocalDateTimeUtils.isEqualSecond(localDateTime, localDateTime.plusYears(1)));
    }

    @Test
    void isEqualMilli() {
        System.out.println(LocalDateTimeUtils.isEqualMilli(localDateTime, LocalDateTimeUtils.plusMillis(localDateTime, 1)));
    }

    @Test
    void isOverlap() {
        final LocalDateTime localDateTime1 = localDateTime.plusDays(1);
        System.out.println(LocalDateTimeUtils.isOverlap(localDateTime, localDateTime1, localDateTime1, localDateTime.plusDays(2)));
        System.out.println(DateUtil.isOverlap(LocalDateTimeUtils.toDate(localDateTime),
                LocalDateTimeUtils.toDate(localDateTime1),
                LocalDateTimeUtils.toDate(localDateTime1),
                LocalDateTimeUtils.toDate(localDateTime.plusDays(2))
        ));
    }

    @Test
    void format() {
        System.out.println(LocalDateTimeUtils.format(localDateTime));
    }

    @Test
    void parse() {
        System.out.println(LocalDateTimeUtils.parse("2022-12-30 13:26:30"));
    }

    @Test
    void formatDate() {
        System.out.println(LocalDateTimeUtils.formatDate(localDateTime));
    }

    @Test
    void formatTime() {
        System.out.println(LocalDateTimeUtils.formatTime(localDateTime));
    }

    @Test
    void formatOfSimple() {
        System.out.println(LocalDateTimeUtils.formatOfSimple(localDateTime));
    }

    @Test
    void formatDateOfSimple() {
        System.out.println(LocalDateTimeUtils.formatDateOfSimple(localDateTime));
    }

    @Test
    void formatTimeOfSimple() {
        System.out.println(LocalDateTimeUtils.formatTimeOfSimple(localDateTime));
    }

    @Test
    void formatOfChinese() {
        System.out.println(LocalDateTimeUtils.formatOfChinese(localDateTime));
    }

    @Test
    void formatDateOfChinese() {
        System.out.println(LocalDateTimeUtils.formatDateOfChinese(localDateTime));
    }

    @Test
    void formatTimeOfChinese() {
        System.out.println(LocalDateTimeUtils.formatTimeOfChinese(localDateTime));
    }

    @Test
    void parseDate() {
        System.out.println(LocalDateTimeUtils.parseDate("2022-04-30"));
    }

    @Test
    void parseTime() {
        System.out.println(LocalDateTimeUtils.parseTime("12:30:59"));
    }

    @Test
    void parseOfSimple() {
        System.out.println(LocalDateTimeUtils.parseOfSimple(LocalDateTimeUtils.formatOfSimple(localDateTime)));
    }

    @Test
    void parseDateOfSimple() {
        System.out.println(LocalDateTimeUtils.parseDateOfSimple(LocalDateTimeUtils.formatDateOfSimple(localDateTime)));
    }

    @Test
    void parseTimeOfSimple() {
        System.out.println(LocalDateTimeUtils.parseTimeOfSimple(LocalDateTimeUtils.formatTimeOfSimple(localDateTime)));
    }

    @Test
    void parseOfChinese() {
        System.out.println(LocalDateTimeUtils.parseOfChinese(LocalDateTimeUtils.formatOfChinese(localDateTime)));
    }

    @Test
    void parseDateOfChinese() {
        System.out.println(LocalDateTimeUtils.parseDateOfChinese(LocalDateTimeUtils.formatDateOfChinese(localDateTime)));
    }

    @Test
    void parseTimeOfChinese() {
        System.out.println(LocalDateTimeUtils.parseTimeOfChinese(LocalDateTimeUtils.formatTimeOfChinese(localDateTime)));
    }

    @Test
    void of() {
        System.out.println(LocalDateTimeUtils.of(Clock.systemDefaultZone().millis()));
    }
}