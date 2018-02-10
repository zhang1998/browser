package com.ucpro.feature.webwindow;

import android.text.TextUtils;
import com.ucweb.common.util.i.b;

/* compiled from: ProGuard */
public final class ah {
    private static String a;

    public static String a() {
        if (TextUtils.isEmpty(a)) {
            a = new String(b.a("aHR0cDovL3Jlc2NuLnUzLnVjd2ViLmNvbS9odW1tZXIvcmVzL3F1YXJrX2ZvcmJpdF9ob3N0Lmh0bWw=".getBytes()));
        }
        new StringBuilder("getForbiddenUrl is: ").append(a);
        return a;
    }
}
