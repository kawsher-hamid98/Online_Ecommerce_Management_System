package com.onlineApp.Util;

import java.util.Calendar;

public class DateUtil {
    public static long getCurrentTimeInMillis() {
        Calendar date = Calendar.getInstance();
        return date.getTimeInMillis();
    }
}
