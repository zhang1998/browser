package com.uc.apollo.util;

import android.content.Context;
import android.os.Process;
import com.uc.apollo.android.privy.AndroidSystemProperties;
import com.uc.apollo.annotation.KeepForSdk;
import com.uc.apollo.base.Config;
import com.uc.crashsdk.export.LogType;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

@KeepForSdk
/* compiled from: ProGuard */
public class Log {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    private static final String TAG = "ucmedia.log";
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static String sPid = Integer.valueOf(Process.myPid()).toString();
    private static final String[] sPrioritys = new String[]{null, null, "V", "D", "I", "W", "E", "A"};
    private static SimpleDateFormat sTimeFmt = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
    private static Writer sWriter;

    private Log() {
    }

    public static int v(String str, String str2) {
        return printlns(2, str, str2);
    }

    public static int v(String str, String str2, Throwable th) {
        return printlns(2, str, str2 + '\n' + getStackTraceString(th));
    }

    public static int d(String str, String str2) {
        return printlns(3, str, str2);
    }

    public static int d(String str, String str2, Throwable th) {
        return printlns(3, str, str2 + '\n' + getStackTraceString(th));
    }

    public static int i(String str, String str2) {
        return printlns(4, str, str2);
    }

    public static int i(String str, String str2, Throwable th) {
        return printlns(4, str, str2 + '\n' + getStackTraceString(th));
    }

    public static int w(String str, String str2) {
        return printlns(5, str, str2);
    }

    public static int w(String str, String str2, Throwable th) {
        return printlns(5, str, str2 + '\n' + getStackTraceString(th));
    }

    public static int w(String str, Throwable th) {
        return printlns(5, str, getStackTraceString(th));
    }

    public static int e(String str, String str2) {
        return printlns(6, str, str2);
    }

    public static int e(String str, String str2, Throwable th) {
        return printlns(6, str, str2 + '\n' + getStackTraceString(th));
    }

    public static void dumpStack(String str) {
        dumpStack(str, 20, 4);
    }

    public static void dumpStack(String str, int i) {
        dumpStack(str, i, 4);
    }

    private static void dumpStack(String str, int i, int i2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (i <= 0 || i + i2 > stackTrace.length) {
            i = stackTrace.length - i2;
        }
        if (i > 0) {
            String trim;
            int i3 = i + i2;
            StringBuilder stringBuilder = new StringBuilder(i * 48);
            stringBuilder.append("stack trace:\n");
            while (i2 < i3) {
                stringBuilder.append("  ").append(stackTrace[i2].toString()).append('\n');
                i2++;
            }
            if (i3 != stackTrace.length) {
                stringBuilder.append(" ignore ").append(stackTrace.length - i3).append(" call trace.");
            } else {
                stringBuilder.setLength(stringBuilder.length() - 1);
            }
            if (str != null) {
                trim = str.trim();
            } else {
                trim = str;
            }
            if (trim == null || trim.length() == 0) {
                trim = "CallStack";
            }
            v(trim, stringBuilder.toString());
        }
    }

    public static void trace(String str) {
        traceImpl(str, null, 4);
    }

    public static void trace(String str, String str2) {
        traceImpl(str, str2, 4);
    }

    public static void trace(String str, int i) {
        traceImpl(str, null, i + 4);
    }

    public static void trace(String str, String str2, int i) {
        traceImpl(str, str2, i + 4);
    }

    private static void traceImpl(String str, String str2, int i) {
        String trim;
        if (str != null) {
            trim = str.trim();
        } else {
            trim = str;
        }
        if (trim == null || trim.length() == 0) {
            trim = "Tracer";
        }
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("-- ").append(Thread.currentThread().getStackTrace()[i].toString());
        if (str2 != null) {
            stringBuilder.append(" - ").append(str2);
        }
        stringBuilder.append(" --");
        v(trim, stringBuilder.toString());
    }

    static {
        if (AndroidSystemProperties.get("debug.uc.apollo.media.lt", 0) == 1) {
            String[] strArr = new String[]{"/sdcard/tmp/"};
            try {
                new File("/sdcard/tmp").mkdir();
            } catch (Throwable th) {
            }
            int i = 0;
            while (i <= 0) {
                String str = strArr[0];
                Context context = Config.getContext();
                str = str + (context != null ? context.getPackageName() : "ucmedia") + "_" + sPid + ".log";
                try {
                    writeToFile(str);
                    return;
                } catch (Throwable th2) {
                    android.util.Log.e(TAG, "log to " + str + " failure.");
                    i++;
                }
            }
        }
    }

    public static int printlns(int i, String str, String str2) {
        int println = android.util.Log.println(i, str, str2);
        if (sWriter == null) {
            return println;
        }
        synchronized (Log.class) {
            try {
                sWriter.write(sTimeFmt.format(new Date()));
                sWriter.write(32);
                sWriter.write(sPid);
                sWriter.write(32);
                sWriter.write(Integer.valueOf(Process.myTid()).toString());
                sWriter.write(32);
                sWriter.write(sPrioritys[i]);
                sWriter.write(32);
                sWriter.write(str);
                sWriter.write(": ");
                sWriter.write(str2);
                sWriter.write(10);
                sWriter.flush();
                println = ((str.length() + 33) + 2) + str2.length();
            } catch (IOException e) {
                return 0;
            }
        }
        return println;
    }

    public static String getStackTraceString(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
        }
        Writer stringWriter = new StringWriter();
        PrintWriter fastPrintWriter = new FastPrintWriter(stringWriter, false, (int) LogType.UNEXP);
        th.printStackTrace(fastPrintWriter);
        fastPrintWriter.flush();
        return stringWriter.toString();
    }

    private static void writeToFile(String str) throws IOException {
        synchronized (Log.class) {
            if (sWriter instanceof FileWriter) {
                return;
            }
            sWriter = new FileWriter(str);
        }
    }
}
