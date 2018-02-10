package com.f.a.b.a;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.util.Random;

/* compiled from: ProGuard */
public final class b {
    private static String a() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nanoTime = (int) System.nanoTime();
        int nextInt = new Random().nextInt();
        int nextInt2 = new Random().nextInt();
        Object a = e.a(currentTimeMillis);
        Object a2 = e.a(nanoTime);
        Object a3 = e.a(nextInt);
        Object a4 = e.a(nextInt2);
        Object obj = new byte[16];
        System.arraycopy(a, 0, obj, 0, 4);
        System.arraycopy(a2, 0, obj, 4, 4);
        System.arraycopy(a3, 0, obj, 8, 4);
        System.arraycopy(a4, 0, obj, 12, 4);
        return g.a(obj, 2);
    }

    public static String a(Context context) {
        String str = null;
        if (context != null) {
            try {
                String deviceId;
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    deviceId = telephonyManager.getDeviceId();
                } else {
                    deviceId = null;
                }
                str = deviceId;
            } catch (Exception e) {
            }
        }
        if (c.a(str)) {
            return a();
        }
        return str;
    }

    public static String b(Context context) {
        String str = null;
        if (context != null) {
            try {
                String subscriberId;
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    subscriberId = telephonyManager.getSubscriberId();
                } else {
                    subscriberId = null;
                }
                str = subscriberId;
            } catch (Exception e) {
            }
        }
        if (c.a(str)) {
            return a();
        }
        return str;
    }
}
