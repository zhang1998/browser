package android.mini.support.v4.a;

import android.os.Build.VERSION;
import android.view.View;

/* compiled from: ProGuard */
public final class a {
    private static final b a;

    static {
        if (VERSION.SDK_INT >= 12) {
            a = new d();
        } else {
            a = new c();
        }
    }

    public static void a(View view) {
        a.a(view);
    }
}
