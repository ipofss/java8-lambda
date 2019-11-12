package com.wbs.java8lambda.chapter12;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-11-12 16:54
 **/
public class DateTimeExample {

    private static final ThreadLocal<DateFormat> formatters = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("dd-MMM-yyyy");
        }
    };

    public static void main(String[] args) {
//        useOldDate();
//        useLocalDate();
//        useTemporalAdjuster();
        useDateFormatter();
    }

    private static void useOldDate() {
        Date date = new Date(119, 10, 18);
        System.out.println(date);

        System.out.println(formatters.get().format(date));

        Calendar instance = Calendar.getInstance();
        instance.set(2019, Calendar.FEBRUARY, 18);
        System.out.println(instance);
    }

    private static void useLocalDate() {
        LocalDate date = LocalDate.of(2019, 11, 18);
//        System.out.println(date.getYear());
//        System.out.println(date.getMonth());
//        System.out.println(date.getDayOfMonth());
//        System.out.println(date.getDayOfWeek());
//        System.out.println(date.lengthOfMonth());
//        System.out.println(date.isLeapYear());
        System.out.println(date);

//        System.out.println(date.get(ChronoField.YEAR));
//        System.out.println(date.get(ChronoField.MONTH_OF_YEAR));
//        System.out.println(date.get(ChronoField.DAY_OF_MONTH));

        LocalTime time = LocalTime.of(12, 34, 56);
//        System.out.println(time.getHour());
//        System.out.println(time.getMinute());
//        System.out.println(time.getSecond());
        System.out.println(time);

        LocalDateTime dt1 = LocalDateTime.of(2019, Month.DECEMBER, 18, 12, 34, 56);
//        System.out.println(LocalDateTime.of(date, time));
//        System.out.println(date.atTime(12, 34, 56));
//        System.out.println(date.atTime(time));
//        System.out.println(time.atDate(date));
        System.out.println(dt1);

        LocalDate date1 = dt1.toLocalDate();
        System.out.println(date1);
        LocalTime time1 = dt1.toLocalTime();
        System.out.println(time1);

        Instant instant = Instant.ofEpochSecond(60 * 60 * 24 * 365 * 44);
        Instant now = Instant.now();

        Duration d1 = Duration.between(LocalTime.of(12, 34, 21), time);
        Duration d2 = Duration.between(instant, now);
        System.out.println(d1.getSeconds());
        System.out.println(d2.getSeconds());

        Duration threeMinutes = Duration.of(3, ChronoUnit.MINUTES);
        System.out.println(threeMinutes);

        JapaneseDate japaneseDate = JapaneseDate.from(date);
        System.out.println(japaneseDate);
    }

    private static void useTemporalAdjuster() {
        LocalDate date = LocalDate.of(2019, 11, 18);
        date = date.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        System.out.println(date);
        date = date.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(date);

        date = date.with(new NextWorkingDay());
        System.out.println(date);
        date = date.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
        System.out.println(date);
        date = date.with(new NextWorkingDay());
        System.out.println(date);

        date = date.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
        System.out.println(date);
        date = date.with(temporal -> {
            DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY) {
                dayToAdd = 3;
            }
            if (dow == DayOfWeek.SATURDAY) {
                dayToAdd = 2;
            }
            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        });
        System.out.println(date);
    }

    private static class NextWorkingDay implements TemporalAdjuster {
        @Override
        public Temporal adjustInto(Temporal temporal) {
            DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY) {
                dayToAdd = 3;
            }
            if (dow == DayOfWeek.SATURDAY) {
                dayToAdd = 2;
            }
            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        }
    }

    private static void useDateFormatter() {
        LocalDate date = LocalDate.of(2019, 11, 18);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter chinaFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.CHINESE);

        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(date.format(formatter));
        System.out.println(date.format(chinaFormatter));

        DateTimeFormatter complexFormatter = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.CHINESE);
        System.out.println(date.format(complexFormatter));
    }
}
