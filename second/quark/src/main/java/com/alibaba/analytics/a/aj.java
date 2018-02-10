package com.alibaba.analytics.a;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Random;

/* compiled from: ProGuard */
public final class aj {
    private static String a() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nanoTime = (int) System.nanoTime();
        int nextInt = new Random().nextInt();
        int nextInt2 = new Random().nextInt();
        Object a = l.a(currentTimeMillis);
        Object a2 = l.a(nanoTime);
        Object a3 = l.a(nextInt);
        Object a4 = l.a(nextInt2);
        Object obj = new byte[16];
        System.arraycopy(a, 0, obj, 0, 4);
        System.arraycopy(a2, 0, obj, 4, 4);
        System.arraycopy(a3, 0, obj, 8, 4);
        System.arraycopy(a4, 0, obj, 12, 4);
        return q.b(obj);
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
        if (TextUtils.isEmpty(str)) {
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
        if (TextUtils.isEmpty(str)) {
            return a();
        }
        return str;
    }
}
