package android.support.v4.view;

import android.os.Build.VERSION;

/* compiled from: ProGuard */
public final class ca {
    static final dm a;

    static {
        if (VERSION.SDK_INT >= 17) {
            a = new bn();
        } else {
            a = new bx();
        }
    }

    public static int a(int i, int i2) {
        return a.a(i, i2);
    }
}
