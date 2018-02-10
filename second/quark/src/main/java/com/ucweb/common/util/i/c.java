package com.ucweb.common.util.i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.uc.apollo.impl.SettingsConst;
import com.ucweb.common.util.d;
import java.util.HashMap;

@SuppressLint({"DefaultLocale"})
/* compiled from: ProGuard */
public class c {
    private static boolean a = false;
    private static NetworkInfo b = null;
    private static HashMap<String, String> c = null;
    private static Object d = new byte[0];
    private static d e;

    private static ConnectivityManager c(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    public static boolean a() {
        try {
            NetworkInfo activeNetworkInfo = c(d.a()).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean b() {
        NetworkInfo activeNetworkInfo = c(d.a()).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1 && activeNetworkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo = c(context).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 0 && activeNetworkInfo.isConnected();
    }

    private static int d(Context context) {
        try {
            NetworkInfo activeNetworkInfo = c(context).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return -1;
            }
            new StringBuilder("NetworkInfo: ").append(activeNetworkInfo.toString());
            return activeNetworkInfo.getType();
        } catch (Exception e) {
            return -1;
        }
    }

    public static a b(Context context) {
        switch (d(context)) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 1:
                        return a.Net2_5G;
                    case 2:
                    case 7:
                        return a.Net2_75G;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return a.Net3G;
                    case 4:
                    case 11:
                        return a.Net2G;
                    case 13:
                        return a.Net4G;
                    default:
                        return a.UnKnown;
                }
            case 1:
                return a.Wifi;
            default:
                return a.UnKnown;
        }
    }

    public static boolean d() {
        return h();
    }

    private static boolean h() {
        if (e != null) {
            synchronized (c.class) {
                if (e != null) {
                    boolean z = e.b;
                    return z;
                }
            }
        }
        return "wifi".equals(i());
    }

    public static boolean g() {
        if (e != null) {
            synchronized (c.class) {
                if (e != null) {
                    boolean z = e.c;
                    return z;
                }
            }
        }
        NetworkInfo a = a(false);
        if (a == null || !a.isConnected()) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.net.NetworkInfo a(boolean r5) {
        /*
        r1 = 0;
        r2 = 0;
        r0 = e;
        if (r0 == 0) goto L_0x0014;
    L_0x0006:
        r3 = com.ucweb.common.util.i.c.class;
        monitor-enter(r3);
        r0 = e;	 Catch:{ all -> 0x002b }
        if (r0 == 0) goto L_0x0013;
    L_0x000d:
        r0 = e;	 Catch:{ all -> 0x002b }
        r0 = r0.a;	 Catch:{ all -> 0x002b }
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
    L_0x0012:
        return r0;
    L_0x0013:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
    L_0x0014:
        r0 = "connectivity";
        r0 = com.ucweb.common.util.d.a(r0);	 Catch:{ Exception -> 0x005a, all -> 0x0061 }
        r0 = (android.net.ConnectivityManager) r0;	 Catch:{ Exception -> 0x005a, all -> 0x0061 }
        if (r0 != 0) goto L_0x002e;
    L_0x001e:
        r0 = "ConnectivityStatus";
        r3 = "isQuickNet,ConnectivityManager==null";
        android.util.Log.w(r0, r3);	 Catch:{ Exception -> 0x005a, all -> 0x0061 }
        b = r1;
        a = r2;
        r0 = r1;
        goto L_0x0012;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        throw r0;
    L_0x002e:
        r1 = r0.getActiveNetworkInfo();	 Catch:{ Exception -> 0x005a, all -> 0x0061 }
        if (r1 == 0) goto L_0x003a;
    L_0x0034:
        r3 = r1.isConnected();	 Catch:{ Exception -> 0x0067, all -> 0x0061 }
        if (r3 != 0) goto L_0x006a;
    L_0x003a:
        r3 = r0.getAllNetworkInfo();	 Catch:{ Exception -> 0x0067, all -> 0x0061 }
        if (r3 == 0) goto L_0x006a;
    L_0x0040:
        r0 = r2;
    L_0x0041:
        r4 = r3.length;	 Catch:{ Exception -> 0x0067, all -> 0x0061 }
        if (r0 >= r4) goto L_0x006a;
    L_0x0044:
        r4 = r3[r0];	 Catch:{ Exception -> 0x0067, all -> 0x0061 }
        if (r4 == 0) goto L_0x0057;
    L_0x0048:
        r4 = r3[r0];	 Catch:{ Exception -> 0x0067, all -> 0x0061 }
        r4 = r4.isConnected();	 Catch:{ Exception -> 0x0067, all -> 0x0061 }
        if (r4 == 0) goto L_0x0057;
    L_0x0050:
        r0 = r3[r0];	 Catch:{ Exception -> 0x0067, all -> 0x0061 }
    L_0x0052:
        b = r0;
        a = r2;
        goto L_0x0012;
    L_0x0057:
        r0 = r0 + 1;
        goto L_0x0041;
    L_0x005a:
        r0 = move-exception;
        r0 = r1;
    L_0x005c:
        b = r0;
        a = r2;
        goto L_0x0012;
    L_0x0061:
        r0 = move-exception;
        b = r1;
        a = r2;
        throw r0;
    L_0x0067:
        r0 = move-exception;
        r0 = r1;
        goto L_0x005c;
    L_0x006a:
        r0 = r1;
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucweb.common.util.i.c.a(boolean):android.net.NetworkInfo");
    }

    private static String i() {
        String str;
        if (e != null) {
            synchronized (c.class) {
                if (e != null) {
                    str = e.d;
                    return str;
                }
            }
        }
        NetworkInfo a = a(false);
        str = "unknown";
        if (a == null) {
            return "no_network";
        }
        int type = a.getType();
        if (a.getType() == 1) {
            return "wifi";
        }
        if (a.getExtraInfo() != null) {
            str = a.getExtraInfo().toLowerCase();
        }
        if (type != 0) {
            return "wifi";
        }
        if (str.contains("cmwap")) {
            return "cmwap";
        }
        if (str.contains("cmnet")) {
            return "cmnet";
        }
        if (str.contains("uniwap")) {
            return "uniwap";
        }
        if (str.contains("uninet")) {
            return "uninet";
        }
        if (str.contains("3gwap")) {
            return "3gwap";
        }
        if (str.contains("3gnet")) {
            return "3gnet";
        }
        if (str.contains("ctwap")) {
            return "ctwap";
        }
        if (str.contains("ctnet")) {
            return "ctnet";
        }
        return str;
    }

    public static String c() {
        NetworkInfo a = a(false);
        if (a == null) {
            return "-1";
        }
        switch (a.getSubtype()) {
            case 1:
                return "2.5G";
            case 2:
            case 7:
                return "2.75G";
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
            case 4:
            case 11:
                return "2G";
            case 13:
                return "4G";
            default:
                return SettingsConst.FALSE;
        }
    }

    public static int e() {
        NetworkInfo a = a(false);
        if (a == null) {
            return -1;
        }
        return a.getType();
    }

    public static String f() {
        NetworkInfo a = a(false);
        String str = null;
        if (a != null) {
            str = a.getTypeName();
        }
        if (str == null) {
            return "";
        }
        return str;
    }
}
