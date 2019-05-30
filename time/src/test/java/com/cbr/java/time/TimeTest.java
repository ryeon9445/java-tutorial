package com.cbr.java.time;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class TimeTest {

    @Test
    public void testTime() {
        LocalDate today = LocalDate.now();
        LocalTime present = LocalTime.now();
        System.out.println(today + " " + present);

        LocalDate birthDay = LocalDate.of(1982, 02, 19);
        LocalTime birthTime = LocalTime.of(02, 02, 00, 100000000);
        System.out.println(birthDay + " " + birthTime);
    }

    @Test
    public void testTime2() {
        LocalDate today = LocalDate.now();

        System.out.println(today.getYear());
        System.out.println(today.getMonthValue());
        System.out.println(today.getDayOfWeek());
        System.out.println(today.get(ChronoField.DAY_OF_YEAR));
    }

    @Test
    public void testTime3() {
        LocalTime present = LocalTime.now();

        System.out.println(present.getHour());
        System.out.println(present.getMinute());
    }

    @Test
    public void testTime4() {
        LocalTime present = LocalTime.now();
        String ampm;

        if (present.get(ChronoField.AMPM_OF_DAY) == 0) {
            ampm = "AM";
        } else {
            ampm = "PM";
        }

        System.out.println(ampm + " " + present.get(ChronoField.HOUR_OF_AMPM));
    }

    @Test
    public void testTime5() {
        LocalDate today = LocalDate.now();
        System.out.println(today.getYear());
        LocalDate otherDay = today.withYear(1982);
        Assert.assertEquals(1982, otherDay.getYear());

        LocalTime present = LocalTime.now();
        System.out.println(present.getHour());
        LocalTime otherTime = present.withHour(8);
        Assert.assertEquals(8, otherTime.getHour());
    }

    @Test
    public void testTime6() {
        LocalTime present = LocalTime.now();
        System.out.println(present.get(ChronoField.HOUR_OF_DAY));

        LocalTime otherTime = present.plus(2, ChronoUnit.HOURS);
        System.out.println(otherTime.getHour());

        LocalTime anotherTime = present.minus(6, ChronoUnit.HOURS);
        System.out.println(anotherTime.getHour());
    }

    @Test
    public void testTime7() {
        LocalDate today = LocalDate.now();
        LocalDate otherDay = LocalDate.of(1982, 02, 19);

        System.out.println(today.compareTo(otherDay));
        Assert.assertEquals(false, today.isBefore(otherDay));
        Assert.assertEquals(true, today.isAfter(otherDay));
    }
}