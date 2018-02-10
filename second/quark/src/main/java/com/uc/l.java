package com.uc;

import android.content.Context;

/* compiled from: ProGuard */
public final class l {
    public static String a(String str) {
        String str2 = "";
        try {
            str2 = n.a.d(str);
        } catch (Exception e) {
        }
        return str2;
    }

    public static void a(Context context, String str, String str2, Runnable runnable) {
        if (n.a.a()) {
            n.a.a(str);
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        n.a.a(context, new i(str2, str, runnable));
    }
}
