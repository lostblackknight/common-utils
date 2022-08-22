package io.github.lostblackknight.core.date;

import cn.hutool.core.date.DateUtil;
import io.github.lostblackknight.core.date.format.DatePattern;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author chensixiang (chensixiang1234@gmail.com) 2022/8/22 9:36
 * @version 1.0.0
 */
class LocalDateUtilsTest {

    private final LocalDate localDate = LocalDate.now();

    @Test
    void of() {
        System.out.println(LocalDateUtils.of(System.currentTimeMillis()));
    }

    @Test
    void year() {
        System.out.println(LocalDateUtils.year(localDate));
    }

    @Test
    void month() {
        System.out.println(LocalDateUtils.month(localDate));
    }

    @Test
    void weekOfYear() {
        System.out.println(LocalDateUtils.weekOfYear(localDate));
        System.out.println(DateUtil.weekOfYear(new Date()));
    }

    @Test
    void dayOfYear() {
        System.out.println(LocalDateUtils.dayOfYear(localDate));
        System.out.println(DateUtil.dayOfYear(new Date()));
    }

    @Test
    void weekOfMonth() {
        System.out.println(LocalDateUtils.weekOfMonth(localDate));
        System.out.println(DateUtil.weekOfMonth(new Date()));
    }

    @Test
    void dayOfMonth() {
        System.out.println(LocalDateUtils.dayOfMonth(localDate));
    }

    @Test
    void dayOfWeek() {
        System.out.println(LocalDateUtils.dayOfWeek(localDate));
    }

    @Test
    void isLeapYear() {
        System.out.println(LocalDateUtils.isLeapYear(localDate));
    }

    @Test
    void isWeekend() {
        System.out.println(LocalDateUtils.isWeekend(localDate));
    }

    @Test
    void lengthOfYear() {
        System.out.println(LocalDateUtils.lengthOfYear(localDate));
    }

    @Test
    void lengthOfMonth() {
        System.out.println(LocalDateUtils.lengthOfMonth(localDate));
    }

    @Test
    void current() {
        System.out.println(LocalDateUtils.current());
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
        System.out.println(LocalDateUtils.plusYears(localDate, 1));
    }

    @Test
    void plusMonths() {
        System.out.println(LocalDateUtils.plusMonths(localDate, 1));
    }

    @Test
    void plusWeeks() {
        System.out.println(LocalDateUtils.plusWeeks(localDate, 1));
    }

    @Test
    void plusDays() {
        System.out.println(LocalDateUtils.plusYears(localDate, 1));
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
    void beginOfYear() {
        System.out.println(LocalDateUtils.beginOfYear(localDate));
    }

    @Test
    void endOfYear() {
        System.out.println(LocalDateUtils.endOfYear(localDate));
    }

    @Test
    void beginOfNextYear() {
        System.out.println(LocalDateUtils.beginOfNextYear(localDate));
    }

    @Test
    void endOfNextYear() {
        System.out.println(LocalDateUtils.endOfNextYear(localDate));
    }

    @Test
    void beginOfPrevYear() {
        System.out.println(LocalDateUtils.beginOfPrevYear(localDate));
    }

    @Test
    void endOfPrevYear() {
        System.out.println(LocalDateUtils.endOfPrevYear(localDate));
    }

    @Test
    void beginOfMonth() {
        System.out.println(LocalDateUtils.beginOfMonth(localDate));
    }

    @Test
    void endOfMonth() {
        System.out.println(LocalDateUtils.endOfMonth(localDate));
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
        System.out.println(LocalDateUtils.beginOfWeek(localDate));
    }

    @Test
    void endOfWeek() {
        System.out.println(LocalDateUtils.endOfWeek(localDate));
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
    void betweenYears() {
        System.out.println(LocalDateUtils.betweenYears(localDate.plusYears(1), localDate.plusYears(-1)));
    }

    @Test
    void betweenMonths() {
        System.out.println(LocalDateUtils.betweenMonths(localDate.plusMonths(1), localDate.plusMonths(-1)));
    }

    @Test
    void betweenWeeks() {
        System.out.println(LocalDateUtils.betweenWeeks(localDate.plusWeeks(1), localDate.plusWeeks(-1)));
    }

    @Test
    void betweenDays() {
        System.out.println(LocalDateUtils.betweenDays(localDate.plusDays(1), localDate.plusDays(-1)));
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
    void compare() {
        System.out.println(LocalDateUtils.compare(localDate, localDate));
        System.out.println(LocalDateUtils.compare(localDate, localDate.plusDays(1)));
        System.out.println(LocalDateUtils.compare(localDate, localDate.plusDays(-1)));
    }

    @Test
    void isAfter() {
        System.out.println(LocalDateUtils.isAfter(localDate.plusDays(1), localDate));
    }

    @Test
    void isBefore() {
        System.out.println(LocalDateUtils.isBefore(localDate.plusDays(-1), localDate));
    }

    @Test
    void isEqual() {
        System.out.println(LocalDateUtils.isEqual(localDate, localDate));
    }

    @Test
    void isEqualYear() {
        System.out.println(LocalDateUtils.isEqual(localDate, localDate.plusYears(1)));
        System.out.println(LocalDateUtils.isEqual(localDate, localDate));
    }

    @Test
    void isEqualMonth() {
        System.out.println(LocalDateUtils.isEqualMonth(localDate, localDate.plusYears(1)));
        System.out.println(LocalDateUtils.isEqualMonth(localDate, localDate));
    }

    @Test
    void isEqualWeek() {
        System.out.println(LocalDateUtils.isEqualWeek(localDate, localDate.plusWeeks(1)));
        System.out.println(LocalDateUtils.isEqualWeek(localDate, localDate));
    }

    @Test
    void isIn() {
        System.out.println(LocalDateUtils.isIn(localDate, localDate.plusDays(1), localDate.plusDays(1)));
    }

    @Test
    void isOverlap() {
        System.out.println(LocalDateUtils.isOverlap(localDate, localDate.plusDays(1), localDate.plusDays(2), localDate.plusDays(3)));
    }

    @Test
    void format() {
        System.out.println(LocalDateUtils.format(localDate, "yyyy=MM=dd"));
    }

    @Test
    void testFormat() {
        System.out.println(LocalDateUtils.format(localDate, DatePattern.CHINESE_DATE));
    }

    @Test
    void testFormat1() {
        System.out.println(LocalDateUtils.format(localDate, DatePattern.NORMAL_MONTH));
    }

    @Test
    void formatDate() {
        System.out.println(LocalDateUtils.format(localDate, DateTimeFormatter.ISO_DATE));
    }

    @Test
    void formatDateOfSimple() {
        System.out.println(LocalDateUtils.formatDate(localDate));
        System.out.println(LocalDateUtils.formatDateOfSimple(localDate));
    }

    @Test
    void formatDateOfChinese() {
        System.out.println(LocalDateUtils.formatDateOfChinese(localDate));
    }

    @Test
    void parse() {
        System.out.println(LocalDateUtils.parse("2018", "yyyy"));
    }

    @Test
    void testParse() {
        System.out.println(LocalDateUtils.parse("2018年", DatePattern.CHINESE_YEAR));
    }

    @Test
    void testParse1() {
        System.out.println(LocalDateUtils.parse("2018/12", DateTimeFormatter.ofPattern("yyyy/MM")));
    }

    @Test
    void parseDate() {
        System.out.println(LocalDateUtils.parseDate("2018-12-25"));
    }

    @Test
    void parseDateOfSimple() {
        System.out.println(LocalDateUtils.parseDateOfSimple("20181225"));
    }

    @Test
    void parseDateOfChinese() {
        System.out.println(LocalDateUtils.parseDateOfChinese("2018年12月25日"));
    }

    @Test
    void isEqualDay() {
        System.out.println(LocalDateUtils.isEqualDay(localDate, localDate.plusDays(1)));
    }
}