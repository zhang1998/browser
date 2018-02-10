package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: ProGuard */
public final class dx {
    static final cf a;

    static {
        if (VERSION.SDK_INT >= 17) {
            a = new dk();
        } else {
            a = new bw();
        }
    }

    public static int a(MarginLayoutParams marginLayoutParams) {
        return a.a(marginLayoutParams);
    }

    public static int b(MarginLayoutParams marginLayoutParams) {
        return a.b(marginLayoutParams);
    }
}
