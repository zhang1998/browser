package android.support.v4.a;

import android.os.Build.VERSION;
import android.view.View;

/* compiled from: ProGuard */
public final class d {
    private static final b a;

    static {
        if (VERSION.SDK_INT >= 12) {
            a = new c();
        } else {
            a = new a();
        }
    }

    public static void a(View view) {
        a.a(view);
    }
}
