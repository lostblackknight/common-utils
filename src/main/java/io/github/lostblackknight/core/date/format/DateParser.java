package io.github.lostblackknight.core.date.format;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;

import static java.lang.Math.toIntExact;
import static java.time.Instant.EPOCH;
import static java.time.ZoneId.systemDefault;
import static java.time.temporal.ChronoField.*;

/**
 * 日期解析
 *
 * @author chensixiang (chensixiang1234@gmail.com) 2022/8/21 16:54
 * @version 1.0.0
 */
public class DateParser {

    /**
     * 解析 {@link LocalDate}
     *
     * @param text      文本
     * @param formatter {@link DateTimeFormatter}
     * @return {@link LocalDate}
     */
    public static LocalDate parseLocalDate(CharSequence text, DateTimeFormatter formatter) {
        int year = new ParseHandler(formatter.parse(text), YEAR).handle();
        int month = new ParseHandler(formatter.parse(text), MONTH_OF_YEAR).handle();
        int dayOfMonth = new ParseHandler(formatter.parse(text), DAY_OF_MONTH).handle();
        return LocalDate.of(year, month, dayOfMonth);
    }

    /**
     * 解析 {@link LocalTime}
     *
     * @param text      文本
     * @param formatter {@link DateTimeFormatter}
     * @return {@link LocalTime}
     */
    public static LocalTime parseLocalTime(CharSequence text, DateTimeFormatter formatter) {
        int hour = new ParseHandler(formatter.parse(text), HOUR_OF_DAY).handle();
        int minute = new ParseHandler(formatter.parse(text), MINUTE_OF_HOUR).handle();
        int second = new ParseHandler(formatter.parse(text), SECOND_OF_MINUTE).handle();
        int nanoOfSecond = new ParseHandler(formatter.parse(text), NANO_OF_SECOND).handle();
        return LocalTime.of(hour, minute, second, nanoOfSecond);
    }

    /**
     * 解析 {@link LocalDateTime}
     *
     * @param text      文本
     * @param formatter {@link DateTimeFormatter}
     * @return {@link LocalDateTime}
     */
    public static LocalDateTime parseLocalDateTime(CharSequence text, DateTimeFormatter formatter) {
        return LocalDateTime.of(parseLocalDate(text, formatter), parseLocalTime(text, formatter));
    }

    public static class ParseHandler {

        private final TemporalAccessor parsed;

        private final TemporalField field;

        public ParseHandler(TemporalAccessor parsed, TemporalField field) {
            this.parsed = parsed;
            this.field = field;
        }

        public int handle() {
            if (parsed.isSupported(field)) {
                return parsed.get(field);
            } else {
                if (field.equals(YEAR)) {
                    return EPOCH.atZone(systemDefault()).getYear();
                }
                return toIntExact(field.range().getMinimum());
            }
        }
    }
}
