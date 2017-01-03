package com.later.fx.later.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Title:
 * Description:
 * Created by Administrator on 2017/1/3.
 * 作者：fx on 2017/1/3 21:03
 */

public class TimeUtil {
    public static long getCurrentSeconds() {
        long ls = System.currentTimeMillis() / 1000;
        return ls;
    }

    public static String[] getCalendarShowTime(long paramlong) {
        String[] localObject;
        String str = new SimpleDateFormat("yyyy:MMM:d", Locale.ENGLISH).format(new Date(paramlong));
        try {
            String[] arrayOfString = str.split(":");
            localObject = arrayOfString;
            return localObject;
        } catch (Exception e) {
            while (true) {
                e.printStackTrace();
            }
        }
    }

    public static String[] getCalendarShowTime(String paramString) {
        try {
            long l = Long.valueOf(paramString);
            Calendar localCalendar = Calendar.getInstance();
            localCalendar.setTimeInMillis(1000L * l);
            return getCalendarShowTime(localCalendar.getTimeInMillis());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getDate(String formate) {
        String str = new SimpleDateFormat(formate, Locale.ENGLISH).format(new Date());
        return str;
    }

}
