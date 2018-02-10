package com.loc;

import android.content.Context;
import java.lang.Thread.UncaughtExceptionHandler;

/* compiled from: ProGuard */
public class es {
    protected static es a;
    protected UncaughtExceptionHandler b;
    protected boolean c = true;

    public static void a(Throwable th, String str, String str2) {
        if (a != null) {
            a.a(th, 1, str, str2);
        }
    }

    protected void a(Context context, ep epVar, boolean z) {
    }

    protected void a(ep epVar, String str, String str2) {
    }

    protected void a(Throwable th, int i, String str, String str2) {
    }
}
