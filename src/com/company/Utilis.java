package com.company;

import java.util.Calendar;
import java.util.Date;

class Utils {

    public static Date getTime(int year, int month, int date, int hourOfDay, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, date, hourOfDay, minute);
        return calendar.getTime();
    }

    public static Date getTime(int year, int month, int date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, date);
        return calendar.getTime();
    }
}


