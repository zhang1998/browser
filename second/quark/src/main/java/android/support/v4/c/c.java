package android.support.v4.c;

import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import java.util.Locale;

/* compiled from: ProGuard */
public final class c {
    public static final Locale a = new Locale("", "");
    private static final d b;
    private static String c = "Arab";
    private static String d = "Hebr";

    static {
        if (VERSION.SDK_INT >= 17) {
            b = new i();
        } else {
            b = new d();
        }
    }

    public static int a(@Nullable Locale locale) {
        return b.a(locale);
    }
}
