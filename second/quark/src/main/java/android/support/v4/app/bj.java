package android.support.v4.app;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;

/* compiled from: ProGuard */
public final class bj {
    private static final bo a;

    static {
        if (VERSION.SDK_INT >= 23) {
            a = new bw();
        } else {
            a = new bo();
        }
    }

    public static String a(@NonNull String str) {
        return a.a(str);
    }

    public static int a(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        return a.a(context, str, str2);
    }
}
