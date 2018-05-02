package com.ubs.opsit.interviews.impl;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.impl.support.Constants;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by AKUA2P on 2018-05-02.
 */
public class TimeConverterImplTest {

    TimeConverter timeConverter = new TimeConverterImpl();
    @Test
    public void testInvalidTime()  {

        assertEquals(Constants.ERROR_MSG, timeConverter.convertTime(""));
        assertEquals(Constants.ERROR_MSG, timeConverter.convertTime("25:10:00"));
        assertEquals(Constants.ERROR_MSG, timeConverter.convertTime("25:00:00"));
        assertEquals(Constants.ERROR_MSG, timeConverter.convertTime("24:01:00"));
        assertEquals(Constants.ERROR_MSG, timeConverter.convertTime("-1:10:00"));
        assertEquals(Constants.ERROR_MSG, timeConverter.convertTime("00:10:60"));
        assertEquals(Constants.ERROR_MSG, timeConverter.convertTime("00:-1:00"));

    }

    @Test
    public void testConvertTime()  {

        assertEquals("Y\r\nRRRR\r\nRRRR\r\nOOOOOOOOOOO\r\nOOOO", timeConverter.convertTime("24:00:00"));
        assertEquals("Y\r\nRRRR\r\nROOO\r\nYYRYYRYYRYY\r\nYYYY", timeConverter.convertTime("21:59:02"));
        assertEquals("O\r\nOOOO\r\nOOOO\r\nOOOOOOOOOOO\r\nYOOO", timeConverter.convertTime("00:01:01"));
        assertEquals("Y\r\nRROO\r\nOOOO\r\nYYOOOOOOOOO\r\nOOOO", timeConverter.convertTime("10:10:10"));
        assertEquals("O\r\nOOOO\r\nOOOO\r\nYYRYYOOOOOO\r\nYYYY", timeConverter.convertTime("00:29:59"));
    }

}