package com.tencent.mm.sdk.b;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Process;

public final class b {
    private static a aG;
    private static a aH;
    private static final String aI;
    private static int level = 6;

    public interface a {
        void f(String str, String str2);

        void g(String str, String str2);

        int getLogLevel();

        void h(String str, String str2);

        void i(String str, String str2);
    }

    static {
        a cVar = new c();
        aG = cVar;
        aH = cVar;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("VERSION.RELEASE:[" + VERSION.RELEASE);
            stringBuilder.append("] VERSION.CODENAME:[" + VERSION.CODENAME);
            stringBuilder.append("] VERSION.INCREMENTAL:[" + VERSION.INCREMENTAL);
            stringBuilder.append("] BOARD:[" + Build.BOARD);
            stringBuilder.append("] DEVICE:[" + Build.DEVICE);
            stringBuilder.append("] DISPLAY:[" + Build.DISPLAY);
            stringBuilder.append("] FINGERPRINT:[" + Build.FINGERPRINT);
            stringBuilder.append("] HOST:[" + Build.HOST);
            stringBuilder.append("] MANUFACTURER:[" + Build.MANUFACTURER);
            stringBuilder.append("] MODEL:[" + Build.MODEL);
            stringBuilder.append("] PRODUCT:[" + Build.PRODUCT);
            stringBuilder.append("] TAGS:[" + Build.TAGS);
            stringBuilder.append("] TYPE:[" + Build.TYPE);
            stringBuilder.append("] USER:[" + Build.USER + "]");
        } catch (Throwable th) {
        }
        aI = stringBuilder.toString();
    }

    public static void a(String str, String str2, Object... objArr) {
        if (aH != null && aH.getLogLevel() <= 4) {
            String format = objArr == null ? str2 : String.format(str2, objArr);
            if (format == null) {
                format = "";
            }
            a aVar = aH;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            aVar.i(str, format);
        }
    }

    public static void b(String str, String str2) {
        a(str, str2, null);
    }

    public static void c(String str, String str2) {
        if (aH != null && aH.getLogLevel() <= 3) {
            a aVar = aH;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            aVar.h(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (aH != null && aH.getLogLevel() <= 2) {
            a aVar = aH;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            aVar.f(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (aH != null && aH.getLogLevel() <= 1) {
            if (str2 == null) {
                str2 = "";
            }
            a aVar = aH;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            aVar.g(str, str2);
        }
    }
}
