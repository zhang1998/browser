package android.mini.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

/* compiled from: ProGuard */
public final class bq {
    static final bp a;

    static {
        if (VERSION.SDK_INT >= 14) {
            a = new bo();
        } else if (VERSION.SDK_INT >= 11) {
            a = new bn();
        } else if (VERSION.SDK_INT >= 8) {
            a = new bm();
        } else {
            a = new bl();
        }
    }

    public static int a(ViewConfiguration viewConfiguration) {
        return a.a(viewConfiguration);
    }
}
