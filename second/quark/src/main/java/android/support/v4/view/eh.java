package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

/* compiled from: ProGuard */
public final class eh {
    static final ee a;

    static {
        if (VERSION.SDK_INT >= 14) {
            a = new bu();
        } else if (VERSION.SDK_INT >= 11) {
            a = new bq();
        } else if (VERSION.SDK_INT >= 8) {
            a = new ar();
        } else {
            a = new em();
        }
    }

    public static int a(ViewConfiguration viewConfiguration) {
        return a.a(viewConfiguration);
    }

    public static boolean b(ViewConfiguration viewConfiguration) {
        return a.b(viewConfiguration);
    }
}
