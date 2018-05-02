package com.ubs.opsit.interviews.converter;

import com.ubs.opsit.interviews.impl.support.Constants;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

/**
 * Created by AKUA2P on 2018-05-02.
 */
public class EvenRowConverterTest {


    private EvenRowConverter evenRowConverter = new EvenRowConverter();

    @Test
    public void testInValidInput() {
        assertEquals(Constants.ERROR_MSG,evenRowConverter.createRow(0,0,""));
    }

    @Test
    public void testEvenHourAndMinute() {
        assertEquals("RRRR",evenRowConverter.createRow(24,4,Constants.R));
        assertEquals("YYYYYYYYYYY",evenRowConverter.createRow(59,11,"Y"));
    }

    @Test
    public void testTopRow() {
        assertEquals(Constants.O,evenRowConverter.getTopRow(25));
        assertEquals(Constants.Y,evenRowConverter.getTopRow(24));
    }

}