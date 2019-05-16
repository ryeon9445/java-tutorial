package com.cbr.java.calendar;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

public class CalendarTest {

    @Test
    public void testAdd() {
        Calendar time = Calendar.getInstance();
        System.out.println(time.getTime());

        time.add(Calendar.MINUTE, 5);
        System.out.println(time.getTime());
    }

    @Test
    public void testBeforeAfter() {
        Calendar time1 = Calendar.getInstance();
        Calendar time2 = Calendar.getInstance();
        time2.set(1970, Calendar.JANUARY, 1);
        Calendar time3 = Calendar.getInstance();
        time3.set(2070, Calendar.JANUARY, 1);

        Assert.assertTrue(time1.after(time2));
        Assert.assertTrue(time1.before(time3));
    }

    @Test
    public void testGet() {
        Calendar time = Calendar.getInstance();

        System.out.println(time.getTime());
        System.out.println("YEAR : " + time.get(Calendar.YEAR));
        System.out.println("WEEK : " + time.get(Calendar.DAY_OF_WEEK));
        System.out.println("MONTH : " + time.get(Calendar.MONTH) + 1);
        System.out.println("DAY_OF_MONTH : " + time.get(Calendar.DAY_OF_MONTH));
        System.out.println("HOUR_OF_DAY : " + time.get(Calendar.HOUR_OF_DAY));
        System.out.println("MINUTE : " + time.get(Calendar.MINUTE));
        System.out.println("SECOND : " + time.get(Calendar.SECOND));
    }

    @Test
    public void testRoll() {
        Calendar time = Calendar.getInstance();
        Calendar time2 = Calendar.getInstance();
        time2.roll(Calendar.SECOND, 60);
        Assert.assertEquals(time.get(Calendar.MINUTE), time2.get(Calendar.MINUTE));
    }

    @Test
    public void testSet() {
        Calendar time = Calendar.getInstance();
        Calendar time2 = Calendar.getInstance();
        time2.set(Calendar.SECOND, 60);
        Assert.assertNotEquals(time.get(Calendar.MINUTE), time2.get(Calendar.MINUTE));
    }
}