package io.github.lostblackknight.core.date;

import io.github.lostblackknight.core.date.format.DatePattern;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chensixiang (chensixiang1234@gmail.com) 2022/8/22 13:47
 * @version 1.0.0
 */
class LocalTimeUtilsTest {

    private final LocalTime localTime = LocalTime.now();

    @Test
    void of() {
        System.out.println(LocalTimeUtils.of(System.currentTimeMillis()));
    }

    @Test
    void hourOf24() {
        System.out.println(LocalTimeUtils.hourOf24(localTime));
    }

    @Test
    void hourOf12() {
        System.out.println(LocalTimeUtils.hourOf12(localTime));
    }

    @Test
    void minute() {
        System.out.println(LocalTimeUtils.minute(localTime));
    }

    @Test
    void second() {
        System.out.println(LocalTimeUtils.second(localTime));
    }

    @Test
    void milli() {
        System.out.println(LocalTimeUtils.milli(localTime));
    }

    @Test
    void isAM() {
        System.out.println(LocalTimeUtils.isAM(localTime));
    }

    @Test
    void isPM() {
        System.out.println(LocalTimeUtils.isPM(localTime));
    }

    @Test
    void current() {
        System.out.println(LocalTimeUtils.current());
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
    void beginOfHour() {
        System.out.println(LocalTimeUtils.beginOfHour(localTime));
    }

    @Test
    void endOfHour() {
        System.out.println(LocalTimeUtils.endOfHour(localTime));
    }

    @Test
    void beginOfMinute() {
        System.out.println(LocalTimeUtils.beginOfMinute(localTime));
    }

    @Test
    void endOfMinute() {
        System.out.println(LocalTimeUtils.endOfMinute(localTime));
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
    void betweenHours() {
        System.out.println(LocalTimeUtils.betweenHours(localTime, localTime.plusHours(1)));
    }

    @Test
    void betweenMinutes() {
        System.out.println(LocalTimeUtils.betweenMillis(localTime, localTime.plusMinutes(1)));
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
        System.out.println(LocalTimeUtils.compare(LocalDateTime.now().toLocalTime(), LocalDateTime.now().plusHours(1).toLocalTime()));
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
        System.out.println(LocalTimeUtils.isIn(localTime, localTime.plusHours(1), localTime.plusHours(6)));
    }

    @Test
    void isOverlap() {
        System.out.println(LocalTimeUtils.isOverlap(localTime, localTime.plusHours(1), localTime.plusHours(1),localTime.plusHours(6)));
    }

    @Test
    void format() {
        System.out.println(LocalTimeUtils.format(localTime, "HH-mm-ss"));
    }

    @Test
    void testFormat() {
        System.out.println(LocalTimeUtils.format(localTime, DatePattern.CHINESE_TIME));
    }

    @Test
    void testFormat1() {
        System.out.println(LocalTimeUtils.format(localTime, DateTimeFormatter.ISO_LOCAL_TIME));
    }

    @Test
    void formatTime() {
        System.out.println(LocalTimeUtils.format(localTime));
    }

    @Test
    void formatTimeOfSimple() {
        System.out.println(LocalTimeUtils.formatOfSimple(localTime));
    }

    @Test
    void formatTimeOfChinese() {
        System.out.println(LocalTimeUtils.formatOfChinese(localTime));
    }

    @Test
    void parse() {
        System.out.println(LocalTimeUtils.parse("22:30:59"));
    }

    @Test
    void testParse() {
        System.out.println(LocalTimeUtils.parse("22/04*28","HH/mm*ss"));
    }

    @Test
    void testParse1() {
        System.out.println(LocalTimeUtils.parse("12时06分30秒", DatePattern.CHINESE_TIME));
    }

    @Test
    void parseTime() {
        System.out.println(LocalTimeUtils.parse("12-06&30",DateTimeFormatter.ofPattern("HH-mm&ss")));
    }

    @Test
    void parseTimeOfSimple() {
        System.out.println(LocalTimeUtils.parseOfChinese("16时58分25秒"));
    }

    @Test
    void parseTimeOfChinese() {
        System.out.println(LocalTimeUtils.parseOfSimple("165323"));
    }
}