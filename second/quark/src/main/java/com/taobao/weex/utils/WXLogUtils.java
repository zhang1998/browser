package com.taobao.weex.utils;

import android.mini.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.weex.i;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;

/* compiled from: ProGuard */
public class WXLogUtils {
    private static final String CLAZZ_NAME_DEBUG_TOOL = "com.taobao.weex.WXDebugTool";
    private static final String CLAZZ_NAME_LOG_UTIL = "com.taobao.weex.devtools.common.LogUtil";
    public static final String WEEX_PERF_TAG = "weex_perf";
    public static final String WEEX_TAG = "weex";
    private static StringBuilder builder = new StringBuilder(50);
    private static HashMap<String, Class> clazzMaps;
    public static boolean isShowLineNumber = false;

    static {
        HashMap hashMap = new HashMap(2);
        clazzMaps = hashMap;
        hashMap.put(CLAZZ_NAME_DEBUG_TOOL, loadClass(CLAZZ_NAME_DEBUG_TOOL));
        clazzMaps.put(CLAZZ_NAME_LOG_UTIL, loadClass(CLAZZ_NAME_LOG_UTIL));
    }

    private static Class loadClass(String str) {
        Class cls = null;
        try {
            cls = Class.forName(str);
            if (cls != null) {
                clazzMaps.put(str, cls);
            }
        } catch (ClassNotFoundException e) {
        }
        return cls;
    }

    public static void renderPerformanceLog(String str, long j) {
        if (i.c() || i.d()) {
            builder.setLength(0);
            builder.append("[render time]").append(str).append(":").append(j);
            new StringBuilder().append(getLineNumber()).append(builder.substring(0));
            writeConsoleLog("debug", builder.substring(0));
        }
    }

    private static void log(String str, String str2, k kVar) {
        if (i.c() && str2 != null && i.v.a(kVar) >= 0) {
            String str3 = getLineNumber() + str2;
            Log.println(kVar.j, str, str3);
            writeConsoleLog(kVar.h, str3);
            sendLog(kVar, str3);
        }
    }

    public static void d(String str) {
        d(WEEX_TAG, str);
    }

    public static void i(String str) {
        i(WEEX_TAG, str);
    }

    public static void info(String str) {
        i(WEEX_TAG, str);
    }

    public static void v(String str) {
        v(WEEX_TAG, str);
    }

    public static void w(String str) {
        w(WEEX_TAG, str);
    }

    public static void e(String str) {
        e(WEEX_TAG, str);
    }

    public static void d(String str, byte[] bArr) {
        d(str, new String(bArr));
    }

    public static void d(String str, String str2) {
        if (i.c() && !TextUtils.isEmpty(str2) && i.v.a(k.DEBUG) >= 0) {
            String str3 = getLineNumber() + str2;
            writeConsoleLog("debug", str + ":" + str3);
            if (str3.contains(" | __")) {
                String[] split = str3.split(" | __");
                if (!(split == null || split.length != 4 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[2]))) {
                    sendLog(getLogLevel(split[2]), split[0]);
                    return;
                }
            }
            sendLog(k.DEBUG, str + ":" + str3);
        }
    }

    private static k getLogLevel(String str) {
        String trim = str.trim();
        Object obj = -1;
        switch (trim.hashCode()) {
            case -1485211506:
                if (trim.equals("__INFO")) {
                    obj = 2;
                    break;
                }
                break;
            case -1484806554:
                if (trim.equals("__WARN")) {
                    obj = 1;
                    break;
                }
                break;
            case 90640196:
                if (trim.equals("__LOG")) {
                    obj = 3;
                    break;
                }
                break;
            case 1198194259:
                if (trim.equals("__DEBUG")) {
                    obj = 4;
                    break;
                }
                break;
            case 1199520264:
                if (trim.equals("__ERROR")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return k.ERROR;
            case 1:
                return k.WARN;
            case 2:
                return k.INFO;
            case 3:
                return k.INFO;
            case 4:
                return k.DEBUG;
            default:
                return k.DEBUG;
        }
    }

    public static void i(String str, String str2) {
        log(str, str2, k.INFO);
    }

    public static void v(String str, String str2) {
        log(str, str2, k.VERBOSE);
    }

    public static void w(String str, String str2) {
        log(str, str2, k.WARN);
    }

    public static void e(String str, String str2) {
        log(str, str2, k.ERROR);
    }

    public static void p(String str) {
        d(WEEX_PERF_TAG, str);
    }

    public static void d(String str, Throwable th) {
        if (i.c()) {
            d(str + getStackTrace(th));
        }
    }

    public static void i(String str, Throwable th) {
        if (i.c()) {
            info(str + getStackTrace(th));
        }
    }

    public static void v(String str, Throwable th) {
        if (i.c()) {
            v(str + getStackTrace(th));
        }
    }

    public static void w(String str, Throwable th) {
        if (i.c()) {
            w(str + getStackTrace(th));
        }
    }

    public static void e(String str, Throwable th) {
        if (i.c()) {
            e(str + getStackTrace(th));
        }
    }

    public static void p(String str, Throwable th) {
        if (i.c()) {
            p(str + getStackTrace(th));
        }
    }

    public static void eTag(String str, Throwable th) {
        if (i.c()) {
            e(str, getStackTrace(th));
        }
    }

    public static String getStackTrace(@Nullable Throwable th) {
        Throwable th2;
        Writer writer;
        StringWriter stringWriter = null;
        if (th == null) {
            return "";
        }
        PrintWriter printWriter;
        try {
            Writer stringWriter2 = new StringWriter();
            try {
                printWriter = new PrintWriter(stringWriter2);
            } catch (Throwable th3) {
                th2 = th3;
                printWriter = null;
                writer = stringWriter2;
                if (stringWriter != null) {
                    try {
                        stringWriter.close();
                    } catch (IOException e) {
                    }
                }
                if (printWriter != null) {
                    printWriter.close();
                }
                throw th2;
            }
            try {
                th.printStackTrace(printWriter);
                printWriter.flush();
                stringWriter2.flush();
                try {
                    stringWriter2.close();
                } catch (IOException e2) {
                }
                printWriter.close();
                return stringWriter2.toString();
            } catch (Throwable th4) {
                th2 = th4;
                writer = stringWriter2;
                if (stringWriter != null) {
                    stringWriter.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
                throw th2;
            }
        } catch (Throwable th5) {
            th2 = th5;
            printWriter = null;
            if (stringWriter != null) {
                stringWriter.close();
            }
            if (printWriter != null) {
                printWriter.close();
            }
            throw th2;
        }
    }

    private static void writeConsoleLog(String str, String str2) {
        if (i.c()) {
            try {
                Class cls = (Class) clazzMaps.get(CLAZZ_NAME_LOG_UTIL);
                if (cls != null) {
                    cls.getMethod("log", new Class[]{String.class, String.class}).invoke(cls, new Object[]{str, str2});
                }
            } catch (Exception e) {
            }
        }
    }

    private static void sendLog(k kVar, String str) {
        if (i.c()) {
            try {
                Class cls = (Class) clazzMaps.get(CLAZZ_NAME_DEBUG_TOOL);
                if (cls != null) {
                    cls.getMethod("sendLog", new Class[]{k.class, String.class}).invoke(cls, new Object[]{kVar, str});
                }
            } catch (Exception e) {
            }
        }
    }

    private static String getLineNumber() {
        if (!isShowLineNumber) {
            return "";
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String fileName = stackTrace[2].getFileName();
        return "(" + fileName + ":" + stackTrace[2].getLineNumber() + ") ";
    }
}
