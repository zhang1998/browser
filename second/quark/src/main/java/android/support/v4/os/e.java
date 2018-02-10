package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Trace;

/* compiled from: ProGuard */
public final class e {
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
