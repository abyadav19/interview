package com.ubs.opsit.interviews.converter;

import com.ubs.opsit.interviews.impl.support.Constants;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by AKUA2P on 2018-05-02.
 */
public class OddRowConverterTest {

    OddRowConverter oddRowConverter = new OddRowConverter();

    @Test
    public void createRow() throws Exception {
        assertEquals("RRRR",oddRowConverter.createRow(24,4,Constants.R));
        assertEquals("YYYY",oddRowConverter.createRow(59,4,Constants.Y));
        assertEquals("YYYO",oddRowConverter.createRow(13,4,Constants.Y));
        assertEquals("OOOO",oddRowConverter.createRow(00,4,Constants.Y));
    }

    @Test
    public void isValidInput() throws Exception {
        assertEquals(Constants.ERROR_MSG,oddRowConverter.createRow(0,0,""));
    }

    @Test
    public void getTopRow() throws Exception {
        assertEquals(Constants.O,oddRowConverter.getTopRow(51));
        assertEquals(Constants.Y,oddRowConverter.getTopRow(38));
        assertEquals(Constants.Y,oddRowConverter.getTopRow(0));
    }

}