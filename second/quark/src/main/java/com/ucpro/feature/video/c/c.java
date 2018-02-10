package com.ucpro.feature.video.c;

import android.os.Handler;
import android.os.Looper;
import com.ucpro.c.b;
import com.ucpro.feature.video.c.c.a;

/* compiled from: ProGuard */
public class c {
    private static final String a = c.class.getSimpleName();

    private c() {
    }

    public static c a() {
        return b.a;
    }

    public static void a(String str, d dVar) {
        com.ucweb.common.util.c.a((CharSequence) str);
        com.ucweb.common.util.c.a((Object) dVar);
        if (com.ucweb.common.util.i.c.a()) {
            new a().a(str, dVar, com.ucpro.feature.video.c.e.a.a(str, "normal"));
            return;
        }
        com.ucpro.feature.video.c.a.a.a(new Handler(Looper.getMainLooper()), str, dVar, com.ucpro.feature.video.c.d.a.VPS_REQUEST_NETWORK_UN_CONNECT_ERROR);
    }

    public static void a(String str, String str2, a aVar) {
        b.b();
        com.ucweb.common.util.c.a((CharSequence) str);
        com.ucweb.common.util.c.a((CharSequence) str2);
        com.ucweb.common.util.c.a((Object) aVar);
        com.ucpro.feature.video.c.e.b.a a = com.ucpro.feature.video.c.e.a.a(str, str2);
        if (com.ucweb.common.util.i.c.a()) {
            new a().a(str, str2, aVar, a);
        } else {
            com.ucpro.feature.video.c.a.a.a(new Handler(Looper.getMainLooper()), str, str2, aVar, com.ucpro.feature.video.c.d.a.VPS_REQUEST_NETWORK_UN_CONNECT_ERROR);
        }
    }
}
