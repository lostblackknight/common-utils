package io.github.lostblackknight.core.date.format;

import java.time.format.DateTimeFormatter;

import static java.time.ZoneId.systemDefault;
import static java.util.Locale.getDefault;

/**
 * 日期格式化
 *
 * @author chensixiang (chensixiang1234@gmail.com) 2022/8/21 9:43
 * @version 1.0.0
 */
public class DateFormatter {

    public static final DateTimeFormatter NORMAL_YEAR = ofDatePattern(DatePattern.NORMAL_YEAR);

    public static final DateTimeFormatter NORMAL_MONTH = ofDatePattern(DatePattern.NORMAL_MONTH);

    public static final DateTimeFormatter NORMAL_DATE = ofDatePattern(DatePattern.NORMAL_DATE);

    public static final DateTimeFormatter NORMAL_TIME = ofDatePattern(DatePattern.NORMAL_TIME);

    public static final DateTimeFormatter NORMAL_DATE_TIME_MINUTE = ofDatePattern(DatePattern.NORMAL_DATE_TIME_MINUTE);

    public static final DateTimeFormatter NORMAL_DATE_TIME_SECOND = ofDatePattern(DatePattern.NORMAL_DATE_TIME_SECOND);

    public static final DateTimeFormatter NORMAL_DATE_TIME_MILLI = ofDatePattern(DatePattern.NORMAL_DATE_TIME_MILLI);

    public static final DateTimeFormatter SIMPLE_YEAR = ofDatePattern(DatePattern.SIMPLE_YEAR);

    public static final DateTimeFormatter SIMPLE_MONTH = ofDatePattern(DatePattern.SIMPLE_MONTH);

    public static final DateTimeFormatter SIMPLE_DATE = ofDatePattern(DatePattern.SIMPLE_DATE);

    public static final DateTimeFormatter SIMPLE_TIME = ofDatePattern(DatePattern.SIMPLE_TIME);

    public static final DateTimeFormatter SIMPLE_DATE_TIME_MINUTE = ofDatePattern(DatePattern.SIMPLE_DATE_TIME_MINUTE);

    public static final DateTimeFormatter SIMPLE_DATE_TIME_SECOND = ofDatePattern(DatePattern.SIMPLE_DATE_TIME_SECOND);

    public static final DateTimeFormatter SIMPLE_DATE_TIME_MILLI = ofDatePattern(DatePattern.SIMPLE_DATE_TIME_MILLI);

    public static final DateTimeFormatter CHINESE_YEAR = ofDatePattern(DatePattern.CHINESE_YEAR);

    public static final DateTimeFormatter CHINESE_MONTH = ofDatePattern(DatePattern.CHINESE_MONTH);

    public static final DateTimeFormatter CHINESE_DATE = ofDatePattern(DatePattern.CHINESE_DATE);

    public static final DateTimeFormatter CHINESE_TIME = ofDatePattern(DatePattern.CHINESE_TIME);

    public static final DateTimeFormatter CHINESE_DATE_TIME_MINUTE = ofDatePattern(DatePattern.CHINESE_DATE_TIME_MINUTE);

    public static final DateTimeFormatter CHINESE_DATE_TIME_SECOND = ofDatePattern(DatePattern.CHINESE_DATE_TIME_SECOND);

    public static final DateTimeFormatter CHINESE_DATE_TIME_MILLI = ofDatePattern(DatePattern.CHINESE_DATE_TIME_MILLI);

    /**
     * 根据 {@link DatePattern} 创建一个 {@link DateTimeFormatter}
     *
     * @param datePattern 日期格式
     * @return {@link DateTimeFormatter}
     */
    public static DateTimeFormatter ofDatePattern(DatePattern datePattern) {
        return ofPattern(datePattern.pattern());
    }

    /**
     * 根据 pattern 创建一个 {@link DateTimeFormatter}
     *
     * @param pattern 格式
     * @return {@link DateTimeFormatter}
     */
    public static DateTimeFormatter ofPattern(String pattern) {
        return DateTimeFormatter.ofPattern(pattern)
                .withZone(systemDefault())
                .withLocale(getDefault());
    }
}
