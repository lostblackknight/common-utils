package io.github.lostblackknight;

import io.github.lostblackknight.core.date.LocalDateTimeUtils;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    public void shouldAnswerWithTrue() {
        System.out.println(LocalDateTimeUtils.isLeapYear(2020));
    }
}
