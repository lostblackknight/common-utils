package io.github.lostblackknight.core.date;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author chensixiang (chensixiang1234@gmail.com)
 * @since 2022/8/20 14:40
 */
class BaseUtilsTest {

    @Test
    void toDate() {
        System.out.println(DateUtil.format(BaseUtils.toDate(LocalDate.now()), "yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    void testToDate() {
        System.out.println(DateUtil.format(BaseUtils.toDate(LocalDateTime.now()), "yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    void toLocalDate() {
        System.out.println(BaseUtils.toLocalDate(new Date()));
    }

    @Test
    void testToLocalDate() {
        System.out.println(BaseUtils.toLocalDate(LocalDateTime.now()));
    }

    @Test
    void toLocalDateTime() {
        System.out.println(BaseUtils.toLocalDateTime(new Date()));
    }

    @Test
    void testToLocalDateTime() {
        System.out.println(BaseUtils.toLocalDateTime(LocalDate.now()));
    }

    @Test
    void testToDate1() {
        System.out.println(BaseUtils.toDate(LocalTime.now()));
    }

    @Test
    void testToDate2() {
        System.out.println(BaseUtils.toDate(LocalDate.now()));
    }

    @Test
    void testToLocalDate1() {
        System.out.println(BaseUtils.toLocalDate(new Date()));
    }

    @Test
    void isLeapYear() {
        // given

        // when

        // then
    }

    @Test
    void lengthOfYear() {
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
    void testToLocalDateTime1() {
        System.out.println(BaseUtils.toLocalDateTime(LocalTime.now()));
    }

    @Test
    void toEpochMilli() {
        final Date date = DateUtils.of(System.currentTimeMillis());
        final LocalDateTime localDateTime = LocalDateTimeUtils.toLocalDateTime(date);
        final LocalDate localDate = LocalDateTimeUtils.toLocalDate(date);
        final LocalTime localTime = LocalDateTimeUtils.toLocalTime(date);
        System.out.println(LocalDateTimeUtils.of(BaseUtils.toEpochMilli(date)));
        System.out.println(LocalDateTimeUtils.of(BaseUtils.toEpochMilli(localDate)));
        System.out.println(LocalDateTimeUtils.of(BaseUtils.toEpochMilli(localDateTime)));
        System.out.println(LocalDateTimeUtils.of(BaseUtils.toEpochMilli(localTime)));
        System.out.println(BaseUtils.toLocalTime(LocalDate.now()));
    }

    @Test
    void testToEpochMilli() {
        System.out.println(LocalDateTimeUtils.of(LocalDateTimeUtils.toEpochMilli(LocalTime.now())));
    }

    @Test
    void testToEpochMilli1() {
        // given

        // when

        // then
    }

    @Test
    void testToEpochMilli2() {
        // given

        // when

        // then
    }

    @Test
    void toLocalTime() {
        // given

        // when

        // then
    }

    @Test
    void testToLocalTime() {
        System.out.println(LocalDateTimeUtils.toDate(LocalTime.now()));
        System.out.println(LocalDateTimeUtils.toLocalDate(LocalTime.now()));
        System.out.println(LocalDateTimeUtils.toLocalDateTime(LocalTime.now()));
    }

    @Test
    void testToLocalTime1() {
        final DateTime dateTime = DateUtil.parse("8:00:00", "HH:mm:ss");
        System.out.println(dateTime);
        System.out.println(dateTime.getTime());
    }
}