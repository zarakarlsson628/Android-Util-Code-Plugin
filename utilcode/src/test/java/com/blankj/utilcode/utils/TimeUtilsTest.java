package com.blankj.utilcode.utils;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.google.common.truth.Truth.assertThat;


/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/8/12
 *     desc  : TimeUtils单元测试
 * </pre>
 */
public class TimeUtilsTest {


    SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzzz", Locale.getDefault());
    long milliseconds = 1470991049000L;
    Date timeDate = new Date(milliseconds);
    String timeString = "2016-08-12 16:37:29";
    String myTimeString = "2016-08-12 16:37:29 中国标准时间";
    String timeString0 = "2016-08-12 16:00:00";
    String timeString1 = "2016-08-12 17:10:10";
    String myTimeString0 = "2016-08-12 16:00:00 中国标准时间";
    String myTimeString1 = "2016-08-12 17:10:10 中国标准时间";


    @Test
    public void testMilliseconds2String() throws Exception {
        assertThat(TimeUtils.milliseconds2String(milliseconds)).isEqualTo(timeString);
        assertThat(TimeUtils.milliseconds2String(milliseconds, myFormat)).isEqualTo(myTimeString);
    }

    @Test
    public void testString2Milliseconds() throws Exception {
        assertThat(TimeUtils.string2Milliseconds(timeString)).isEqualTo(milliseconds);
        assertThat(TimeUtils.string2Milliseconds(myTimeString, myFormat)).isEqualTo(milliseconds);
    }

    @Test
    public void testString2Date() throws Exception {
        assertThat(TimeUtils.string2Date(timeString)).isEqualTo(timeDate);
        assertThat(TimeUtils.string2Date(myTimeString, myFormat)).isEqualTo(timeDate);
    }

    @Test
    public void testDate2String() throws Exception {
        assertThat(TimeUtils.date2String(timeDate)).isEqualTo(timeString);
        assertThat(TimeUtils.date2String(timeDate, myFormat)).isEqualTo(myTimeString);
    }

    @Test
    public void testDate2Milliseconds() throws Exception {
        assertThat(TimeUtils.date2Milliseconds(timeDate)).isEqualTo(milliseconds);
    }

    @Test
    public void testMilliseconds2Date() throws Exception {
        assertThat(TimeUtils.milliseconds2Date(milliseconds)).isEqualTo(timeDate);
    }

    @Test
    public void testGetIntervalTime() throws Exception {
        assertThat(TimeUtils.getIntervalTime(timeString0, timeString1, UnitUtils.SEC)).isEqualTo(4210);
        assertThat(TimeUtils.getIntervalTime(myTimeString0, myTimeString1, UnitUtils.SEC, myFormat)).isEqualTo(4210);
        assertThat(TimeUtils.getIntervalTime(new Date(4210000), new Date(0), UnitUtils.SEC)).isEqualTo(4210);
    }

    @Test
    public void testGetCurTimeMills() throws Exception {
        long interval = TimeUtils.getCurTimeMills() - System.currentTimeMillis();
        assertThat(interval).isLessThan(10L);
    }

    @Test
    public void testGetCurTimeString() throws Exception {
        System.out.println(TimeUtils.getCurTimeString());
        System.out.println(TimeUtils.getCurTimeString(myFormat));
    }

    @Test
    public void testGetCurTimeDate() throws Exception {

    }

    @Test
    public void testGetIntervalByNow() throws Exception {

    }

    @Test
    public void testIsLeapYear() throws Exception {
        assertThat(TimeUtils.isLeapYear(2012)).isEqualTo(true);
        assertThat(TimeUtils.isLeapYear(2000)).isEqualTo(true);
        assertThat(TimeUtils.isLeapYear(1900)).isEqualTo(false);
    }
}