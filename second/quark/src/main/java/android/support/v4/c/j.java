package android.support.v4.c;

import android.os.Build.VERSION;
import java.util.Locale;

/* compiled from: ProGuard */
public final class j {
    private static final e a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            a = new g();
        } else if (i >= 14) {
            a = new h();
        } else {
            a = new f();
        }
    }

    public static String a(Locale locale) {
        return a.a(locale);
    }
}
