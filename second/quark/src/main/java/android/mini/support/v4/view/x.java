package android.mini.support.v4.view;

import android.os.Build.VERSION;
import android.view.LayoutInflater;

/* compiled from: ProGuard */
public final class x {
    static final t a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            a = new w();
        } else if (i >= 11) {
            a = new v();
        } else {
            a = new u();
        }
    }

    public static void a(LayoutInflater layoutInflater, ac acVar) {
        a.a(layoutInflater, acVar);
    }
}
