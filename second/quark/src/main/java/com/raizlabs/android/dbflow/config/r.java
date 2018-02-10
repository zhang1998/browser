package com.raizlabs.android.dbflow.config;

import android.os.Build.VERSION;
import android.util.Log;

/* compiled from: ProGuard */
enum r extends s {
    r(String str) {
        super(str, 5);
    }

    final void a(String str, String str2, Throwable th) {
        if (VERSION.SDK_INT >= 8) {
            Log.wtf(str, str2, th);
        } else {
            Log.e(str, "!!!!!!!!*******" + str2 + "********!!!!!!", th);
        }
    }
}
