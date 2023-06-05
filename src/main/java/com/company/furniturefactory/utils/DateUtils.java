package com.company.furniturefactory.utils;

import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class DateUtils {
    public static LocalDateTime resolveStart(String code) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime start;
        if (code.equals("monthly")) {
            start = now.withDayOfMonth(1)
                    .withHour(0)
                    .withMinute(0)
                    .withSecond(0);
        } else if (code.equals("weekly")) {
            start = now.toLocalDate()
                    .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).atStartOfDay();
        } else {
            start = now.withHour(0).withMinute(0).withSecond(0);
        }
        return start;
    }

    public static LocalDateTime resolveEnd(String code) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime end;

        if (code.equals("monthly")) {
            end = now.withDayOfMonth(1).plusMonths(1)
                    .withHour(0)
                    .withMinute(0)
                    .withSecond(0);
        } else if (code.equals("weekly")) {
            end = now.toLocalDate()
                    .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).plusWeeks(1).atStartOfDay();
        } else {
            end = now.plusDays(1).withHour(0).withMinute(0).withSecond(0);
        }
        return end;
    }
}
