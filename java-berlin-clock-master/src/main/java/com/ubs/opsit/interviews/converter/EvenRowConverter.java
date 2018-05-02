package com.ubs.opsit.interviews.converter;

import com.ubs.opsit.interviews.TimeConverterFactory;
import com.ubs.opsit.interviews.impl.support.Constants;

/**
 * Created by AKUA2P on 2018-05-02.
 */
public class EvenRowConverter extends TimeConverterFactory{
    @Override
    public String createRow(int evenRowTime, int columnCount, String symbol) {

        if (!isValidInput(evenRowTime,columnCount,symbol)) {
            return Constants.ERROR_MSG;
        }
        int powerOn = evenRowTime / 5;
        String columnWithSymbol = getColumn(powerOn, symbol);
        String blankColumn = getColumn( columnCount - powerOn, Constants.O);
        return columnWithSymbol + blankColumn;
    }
}
