package android.support.v4.c;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: ProGuard */
final class a {
    private static Method a;
    private static Method b;

    static {
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                a = cls.getMethod("getScript", new Class[]{String.class});
                b = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Throwable e) {
            a = null;
            b = null;
            Log.w("ICUCompatIcs", e);
        }
    }

    public static String a(Locale locale) {
        String b = b(locale);
        if (b != null) {
            return a(b);
        }
        return null;
    }

    private static String a(String str) {
        try {
            if (a != null) {
                return (String) a.invoke(null, new Object[]{str});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return null;
    }

    private static String b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (b != null) {
                return (String) b.invoke(null, new Object[]{locale2});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return locale2;
    }
}
