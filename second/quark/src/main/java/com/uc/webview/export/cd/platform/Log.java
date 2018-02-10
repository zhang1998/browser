package com.uc.webview.export.cd.platform;

import java.lang.reflect.Method;

/* compiled from: ProGuard */
public class Log {
    private static final String TAG = "CDLog";
    private static boolean sEnablePrintLog = false;
    private static Level sLevel = Level.RELEASE;
    private static Class<?> sLogClass;
    private static Method sLogDebugMethod;
    private static Method sLogErrorMethod;
    private static Method sLogGetStackTraceStringMethod;

    /* compiled from: ProGuard */
    enum Level {
        DEBUG,
        RELEASE
    }

    static {
        try {
            Class cls = Class.forName("android.util.Log");
            sLogClass = cls;
            if (cls != null) {
                Method declaredMethod = sLogClass.getDeclaredMethod("d", new Class[]{String.class, String.class});
                sLogDebugMethod = declaredMethod;
                declaredMethod.setAccessible(true);
                declaredMethod = sLogClass.getDeclaredMethod("e", new Class[]{String.class, String.class});
                sLogErrorMethod = declaredMethod;
                declaredMethod.setAccessible(true);
                declaredMethod = sLogClass.getDeclaredMethod("getStackTraceString", new Class[]{Throwable.class});
                sLogGetStackTraceStringMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            }
        } catch (Throwable th) {
            new StringBuilder("init exception: ").append(android.util.Log.getStackTraceString(th));
        }
    }

    public static void setEnable(boolean z) {
        sEnablePrintLog = z;
    }

    public static void d(String str, String str2) {
        if (sLevel == Level.DEBUG && sEnablePrintLog && sLogClass != null && sLogDebugMethod != null) {
            try {
                sLogDebugMethod.invoke(sLogClass, new Object[]{str, str2});
            } catch (Throwable e) {
                new StringBuilder("-d exception : ").append(android.util.Log.getStackTraceString(e));
            } catch (Throwable e2) {
                new StringBuilder("-d exception: ").append(android.util.Log.getStackTraceString(e2));
            }
        }
    }

    public static void e(String str, String str2) {
        if (sLevel == Level.DEBUG && sEnablePrintLog && sLogClass != null && sLogErrorMethod != null) {
            try {
                sLogErrorMethod.invoke(sLogClass, new Object[]{str, str2});
            } catch (Throwable e) {
                new StringBuilder("-e exception : ").append(android.util.Log.getStackTraceString(e));
            } catch (Throwable e2) {
                new StringBuilder("-e exception: ").append(android.util.Log.getStackTraceString(e2));
            }
        }
    }

    public static String getStackTraceString(Throwable th) {
        if (sLevel == Level.DEBUG && sEnablePrintLog && sLogClass != null && sLogGetStackTraceStringMethod != null) {
            try {
                return (String) sLogGetStackTraceStringMethod.invoke(sLogClass, new Object[]{th});
            } catch (Throwable e) {
                new StringBuilder("-getStackTraceString : ").append(android.util.Log.getStackTraceString(e));
            } catch (Throwable e2) {
                new StringBuilder("-getStackTraceString: ").append(android.util.Log.getStackTraceString(e2));
            }
        }
        return String.valueOf(th);
    }

    public static void printStackTraceString(String str, Throwable th) {
        d(str, getStackTraceString(th));
    }
}
