package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.LayoutInflater;

/* compiled from: ProGuard */
public final class dt {
    static final el a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            a = new bt();
        } else if (i >= 11) {
            a = new db();
        } else {
            a = new df();
        }
    }

    public static void a(LayoutInflater layoutInflater, a aVar) {
        a.a(layoutInflater, aVar);
    }

    public static a a(LayoutInflater layoutInflater) {
        return a.a(layoutInflater);
    }
}
