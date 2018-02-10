package com.alibaba.analytics.core.d;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.alibaba.analytics.a.i;
import com.alibaba.analytics.core.b;

/* compiled from: ProGuard */
public final class e {
    private static String[] a = new String[]{"Unknown", "Unknown"};
    private static d b = new d();
    private static b c = new b();

    public static String a() {
        Context context = b.a().b;
        if (context == null) {
            return "Unknown";
        }
        try {
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
                return "Unknown";
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "Unknown";
            }
            if (activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 1) {
                    return "Wi-Fi";
                }
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return "2G";
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return "3G";
                        case 13:
                            return "4G";
                        default:
                            return "Unknown";
                    }
                }
            }
            return "Unknown";
        } catch (Throwable th) {
        }
    }

    public static boolean a(Context context) {
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        return activeNetworkInfo.isConnected();
                    }
                    return false;
                }
            } catch (Exception e) {
            }
        }
        return true;
    }

    public static String[] b() {
        return a;
    }

    public static String b(Context context) {
        if (context == null) {
            return "00:00:00:00:00:00";
        }
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo == null) {
            return "00:00:00:00:00:00";
        }
        String macAddress = connectionInfo.getMacAddress();
        if (TextUtils.isEmpty(macAddress)) {
            return "00:00:00:00:00:00";
        }
        return macAddress;
    }

    public static void c(Context context) {
        if (context != null) {
            context.registerReceiver(b, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            i.a();
            Runnable runnable = c;
            runnable.a = context;
            i.a(runnable);
        }
    }

    public static void d(Context context) {
        if (context != null && b != null) {
            context.unregisterReceiver(b);
        }
    }

    public static String c() {
        try {
            return a[0];
        } catch (Exception e) {
            return "Unknown";
        }
    }

    public static String d() {
        try {
            String[] strArr = a;
            if (strArr[0].equals("2G/3G")) {
                return strArr[1];
            }
            return "Unknown";
        } catch (Exception e) {
            return "Unknown";
        }
    }
}
