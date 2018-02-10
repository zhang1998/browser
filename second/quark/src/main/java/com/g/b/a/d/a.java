package com.g.b.a.d;

import android.util.Log;

/* compiled from: ProGuard */
public final class a {
    private static boolean a = true;

    public static void a(String str) {
        if (a) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            new StringBuilder(String.valueOf(stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName())).append(": ").append(str);
        }
    }

    public static void a(String str, String str2) {
        if (a) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.e(str, new StringBuilder(String.valueOf(stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName())).append(": ").append(str2).toString());
        }
    }
}
