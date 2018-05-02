package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.impl.support.Constants;
import org.apache.commons.lang.StringUtils;

/**
 * Created by AKUA2P on 2018-05-02.
 */
public abstract class TimeConverterFactory {

    public abstract String createRow(int powerOn, int columnCount, String symbol);

    public String getColumn(int occupiedColumn, String symbol) {
        String column = "";
        for(int count = 0; count < occupiedColumn ; count++) {
            column += symbol;
        }
        return column;
    }

    public boolean isValidInput(int rowTime, int columnCount, String symbol) {
        if(rowTime < 0 || columnCount < 0 || columnCount > 11 || StringUtils.isEmpty(symbol)) {
            return false;
        }
        return true;
    }

    public String getTopRow(int second) {
        return (second % 2 == 0) ? Constants.Y : Constants.O;
    }
}
