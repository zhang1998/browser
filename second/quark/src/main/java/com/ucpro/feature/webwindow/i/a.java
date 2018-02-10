package com.ucpro.feature.webwindow.i;

import android.graphics.Bitmap;
import com.ucpro.c.c;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.i.f;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProGuard */
public final class a {
    ConcurrentHashMap<String, String> a;

    private a() {
        this.a = new ConcurrentHashMap();
        m.a(0, new d(this));
    }

    static void a() {
        if (com.ucweb.common.util.k.a.g(c())) {
            com.ucweb.common.util.k.a.c(c());
        }
        com.ucweb.common.util.k.a.j(c());
    }

    static String a(String str) {
        if (!com.ucweb.common.util.n.a.a(str)) {
            String c = f.c(str);
            if (!com.ucweb.common.util.n.a.a(c)) {
                return c.toLowerCase();
            }
        }
        return null;
    }

    private static String c() {
        return c.a().getAbsolutePath() + "/favicos";
    }

    static String b() {
        return c() + "/favicons.data";
    }

    public final String b(String str) {
        if (com.ucweb.common.util.n.a.a(str)) {
            return null;
        }
        String a = a(str);
        if (com.ucweb.common.util.n.a.a(a)) {
            return null;
        }
        a = (String) this.a.get(a);
        if (com.ucweb.common.util.k.a.h(a)) {
            return a;
        }
        return null;
    }

    static /* synthetic */ void a(a aVar, String str, Bitmap bitmap, boolean z) {
        if (!com.ucweb.common.util.n.a.a(str) && bitmap != null) {
            if (!(com.ucweb.common.util.k.a.g(c()) && com.ucweb.common.util.k.a.h(b()))) {
                a();
                if (!aVar.a.isEmpty()) {
                    aVar.a.clear();
                }
            }
            String str2 = c() + "/" + str.hashCode() + ".ico";
            if (!com.ucweb.common.util.n.a.a(str2)) {
                if (z) {
                    com.ucweb.common.util.k.a.c(str2);
                }
                String str3 = str + '|' + str2;
                aVar.a.putIfAbsent(str, str2);
                m.a(0, new f(aVar, str2, bitmap, str3));
            }
        }
    }
}
