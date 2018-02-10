package com.bumptech.glide.b.b.b;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.format.Formatter;
import android.util.Log;

/* compiled from: ProGuard */
public final class s {
    public final int a;
    public final int b;
    public final int c;
    private final Context d;

    public s(Context context, ActivityManager activityManager, r rVar, float f, float f2, int i, float f3, float f4) {
        this.d = context;
        if (a(activityManager)) {
            i /= 2;
        }
        this.c = i;
        float memoryClass = (float) ((activityManager.getMemoryClass() * 1024) * 1024);
        if (!a(activityManager)) {
            f4 = f3;
        }
        int round = Math.round(memoryClass * f4);
        int a = (rVar.a() * rVar.b()) * 4;
        int round2 = Math.round(((float) a) * f2);
        a = Math.round(((float) a) * f);
        int i2 = round - this.c;
        if (a + round2 <= i2) {
            this.b = a;
            this.a = round2;
        } else {
            float f5 = ((float) i2) / (f2 + f);
            this.b = Math.round(f5 * f);
            this.a = Math.round(f5 * f2);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            new StringBuilder("Calculation complete, Calculated memory cache size: ").append(a(this.b)).append(", pool size: ").append(a(this.a)).append(", byte array size: ").append(a(this.c)).append(", memory class limited? ").append(a + round2 > round).append(", max size: ").append(a(round)).append(", memoryClass: ").append(activityManager.getMemoryClass()).append(", isLowMemoryDevice: ").append(a(activityManager));
        }
    }

    private String a(int i) {
        return Formatter.formatFileSize(this.d, (long) i);
    }

    private static boolean a(ActivityManager activityManager) {
        if (VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return false;
    }
}
