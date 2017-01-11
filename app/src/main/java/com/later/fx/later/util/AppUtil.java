package com.later.fx.later.util;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Created by fx on 2017/1/11 0011.
 */

public class AppUtil {


    public static String getDeviceId(Context context){
        TelephonyManager telephonyManager= (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getDeviceId();
    }
}
