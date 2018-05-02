package com.ubs.opsit.interviews.impl;

import com.ubs.opsit.interviews.TimeConverter;

import com.ubs.opsit.interviews.TimeConverterFactory;
import com.ubs.opsit.interviews.converter.EvenRowConverter;
import com.ubs.opsit.interviews.converter.OddRowConverter;
import com.ubs.opsit.interviews.impl.support.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by AKUA2P on 2018-05-01.
 */
public class TimeConverterImpl implements TimeConverter {

    private static final Logger LOG = LoggerFactory.getLogger(TimeConverterImpl.class);

    @Override
    public String convertTime(String aTime) {
        LOG.info("Running convertTime() for time : "+ aTime);
        if(isNotValidTime(aTime)) {
            return Constants.ERROR_MSG;
        }
        String[] aTimeArr = aTime.split(":", 3);

        int hour = Integer.parseInt(aTimeArr[0]);
        int minutes = Integer.parseInt(aTimeArr[1]);
        int second = Integer.parseInt(aTimeArr[2]);

        TimeConverterFactory converterFactory = new EvenRowConverter();
        String topRow = converterFactory.getTopRow(second);
        String secondRow = converterFactory.createRow(hour, 4, Constants.R);
        String fourthRow = converterFactory.createRow(minutes, 11, Constants.Y).replaceAll(Constants.YYY, Constants.YYR);

        converterFactory = new OddRowConverter();
        String thirdRow = converterFactory.createRow(hour, 4, Constants.R);
        String fifthRow = converterFactory.createRow(minutes,4 , Constants.Y);
        return topRow +"\r\n"+ secondRow + "\r\n"+ thirdRow + "\r\n" + fourthRow  + "\r\n" + fifthRow;

    }


    private boolean isNotValidTime(String aTime) {
        if(StringUtils.isEmpty(aTime)) {
            return true;
        }
        String[] aTimeArr = aTime.split(":", 3);
        if(aTimeArr.length != 3){
            return true;
        }
        int hour = Integer.parseInt(aTimeArr[0]);
        int minutes = Integer.parseInt(aTimeArr[1]);
        int second = Integer.parseInt(aTimeArr[2]);

        if(hour < 0 || hour >= 24 || minutes < 0 || minutes > 59 || second < 0 || second > 59) {
            if(hour == 24 && minutes == 0 && second == 0) {
                return false;
            }
            return true;
        }
        return false;
    }
}
