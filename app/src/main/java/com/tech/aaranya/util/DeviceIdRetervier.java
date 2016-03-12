package com.tech.aaranya.util;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;

/**
 * Created by narenbutola on 3/4/16.
 */
public class DeviceIdRetervier {

    public static String getDeviceIdTm(Context context) {
        System.out.println("Retrieving the hardware id");
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getDeviceId();
    }

    public static String getDeviceIdAndroid(Context context) {
        System.out.println("Retrieving the andriod id");
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public static String getDeviceIdPseudo(Context context) {
        System.out.println("Retrieving the device psuedocode id");
        String tstr = "";
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.FROYO) {
            tstr += Build.SERIAL;
            tstr += "::" + (Build.PRODUCT.length() % 10) + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10);
        }
        return tstr;
    }

    public static String getDeviceIdUnique(Context context) {
        try {
            String deviceid = getDeviceIdTm(context);

            if (deviceid != null && deviceid.length() > 0 && deviceid.replace("0", "").length() > 0) {
                return deviceid;
            }

            String deviceIdAndroid = getDeviceIdAndroid(context);

            if (deviceIdAndroid != null && deviceIdAndroid.length() > 0 && deviceIdAndroid.equals("9774d56d682e549c") == false)
                return deviceIdAndroid;

            String deviceIdPseudo = getDeviceIdPseudo(context);

            if (deviceIdPseudo != null && deviceIdPseudo.length() > 0)
                return deviceIdPseudo;

            return "";
        } catch (Exception ex) {
            return "";
        }
    }
}
