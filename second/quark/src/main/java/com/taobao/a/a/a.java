package com.taobao.a.a;

import com.taobao.tao.log.ITLogController;
import com.taobao.tao.log.LogLevel;
import com.taobao.tao.log.TLog;
import com.taobao.tao.log.TLogInitializer;

/* compiled from: ProGuard */
public final class a {
    private static boolean a;

    static {
        a = false;
        try {
            Class.forName("com.taobao.tao.log.TLog");
            a = true;
        } catch (ClassNotFoundException e) {
            a = false;
        }
    }

    public static boolean a() {
        return a;
    }

    public static void a(String str, String str2) {
        if (a) {
            TLog.logd(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (a) {
            TLog.logi(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (a) {
            TLog.logw(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (a) {
            TLog.loge(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (a) {
            TLog.logw(str, str2, th);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (a) {
            TLog.loge(str, str2, th);
        }
    }

    public static String a(String str) {
        if (!a) {
            return "L";
        }
        ITLogController tLogControler = TLogInitializer.getTLogControler();
        if (tLogControler == null) {
            return LogLevel.L.toString();
        }
        LogLevel logLevel = tLogControler.getLogLevel(str);
        if (logLevel != null) {
            return logLevel.toString();
        }
        return LogLevel.L.toString();
    }
}
