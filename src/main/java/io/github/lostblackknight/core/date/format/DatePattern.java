package io.github.lostblackknight.core.date.format;

import java.util.Arrays;

/**
 * 日期格式
 *
 * @author chensixiang (chensixiang1234@gmail.com) 2022/8/20 23:48
 * @version 1.0.0
 */
public enum DatePattern {

    NORMAL_YEAR("yyyy", "Normal"),

    NORMAL_MONTH("yyyy-MM", "Normal"),

    NORMAL_DATE("yyyy-MM-dd", "Normal"),

    NORMAL_TIME("HH:mm:ss", "Normal"),

    NORMAL_DATE_TIME_MINUTE("yyyy-MM-dd HH:mm", "Normal"),

    NORMAL_DATE_TIME_SECOND("yyyy-MM-dd HH:mm:ss", "Normal"),

    NORMAL_DATE_TIME_MILLI("yyyy-MM-dd HH:mm:ss.SSS", "Normal"),

    SIMPLE_YEAR("yyyy", "Simple"),

    SIMPLE_MONTH("yyyyMM", "Simple"),

    SIMPLE_DATE("yyyyMMdd", "Simple"),

    SIMPLE_TIME("HHmmss", "Simple"),

    SIMPLE_DATE_TIME_MINUTE("yyyyMMddHHmm", "Simple"),

    SIMPLE_DATE_TIME_SECOND("yyyyMMddHHmmss", "Simple"),

    SIMPLE_DATE_TIME_MILLI("yyyyMMddHHmmssSSS", "Simple"),

    CHINESE_YEAR("yyyy年", "Chinese"),

    CHINESE_MONTH("yyyy年MM月", "Chinese"),

    CHINESE_DATE("yyyy年MM月dd日", "Chinese"),

    CHINESE_TIME("HH时mm分ss秒", "Chinese"),

    CHINESE_DATE_TIME_MINUTE("yyyy年MM月dd日HH时mm分", "Chinese"),

    CHINESE_DATE_TIME_SECOND("yyyy年MM月dd日HH时mm分ss秒", "Chinese"),

    CHINESE_DATE_TIME_MILLI("yyyy年MM月dd日HH时mm分ss秒SSS毫秒", "Chinese");

    /**
     * 根据传入的格式，获取 {@link DatePattern} 的实例。如果没有匹配的实例，将返回 {@link DatePattern#NORMAL_DATE_TIME_SECOND}
     *
     * @param pattern 格式
     * @return DatePattern
     */
    public static DatePattern of(String pattern) {
        return Arrays.stream(ENUMS)
                .filter(datePattern -> datePattern.toString().equals(pattern))
                .findFirst()
                .orElse(DatePattern.NORMAL_DATE_TIME_SECOND);
    }

    private static final DatePattern[] ENUMS = DatePattern.values();

    private final String pattern;

    private final String type;

    DatePattern(String pattern, String type) {
        this.pattern = pattern;
        this.type = type;
    }

    public final String pattern() {
        return pattern;
    }

    public final String type() {
        return type;
    }

    @Override
    public String toString() {
        return pattern;
    }
}
