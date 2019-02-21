package com.epam.engx.cleancode.functions.task5;

import java.util.Calendar;
import java.util.Date;

class DateUtil {

	Date changeToMidnight(Date date, boolean up) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, getAmount(up));

        return setDate(calendar);
	}

    private int getAmount(boolean up) {
        return up ? 1 : -1;
    }

    private Date setDate(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

}