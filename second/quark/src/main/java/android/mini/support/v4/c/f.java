package android.mini.support.v4.c;

import android.os.Build.VERSION;
import android.os.Trace;

/* compiled from: ProGuard */
public final class f {
    public static void a(String str) {
        if (VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void a() {
        if (VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
