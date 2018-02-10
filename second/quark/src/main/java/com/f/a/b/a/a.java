package com.f.a.b.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

/* compiled from: ProGuard */
public final class a {
    private static ConnectivityManager a = null;
    private static final int[] b = new int[]{4, 7, 2, 1};

    private static String[] b(Context context) {
        String[] strArr = new String[]{"Unknown", "Unknown"};
        try {
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
                strArr[0] = "Unknown";
                return strArr;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                strArr[0] = "Unknown";
                return strArr;
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo == null || networkInfo.getState() != State.CONNECTED) {
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                if (networkInfo2 != null && networkInfo2.getState() == State.CONNECTED) {
                    strArr[0] = "2G/3G";
                    strArr[1] = networkInfo2.getSubtypeName();
                    return strArr;
                }
                return strArr;
            }
            strArr[0] = "Wi-Fi";
            return strArr;
        } catch (Exception e) {
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (b(context)[0].equals("Wi-Fi")) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
