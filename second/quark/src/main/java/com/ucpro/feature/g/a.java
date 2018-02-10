package com.ucpro.feature.g;

import android.app.Application;
import com.uc.sync.e.f;
import com.uc.sync.e.h;
import com.ucpro.c.b;
import com.ucpro.services.f.g;
import com.ucweb.common.util.c;
import com.ucweb.common.util.d;
import com.ucweb.common.util.d.e;

/* compiled from: ProGuard */
public final class a {
    public static final boolean a = b.b();
    public static boolean b = (!com.ucpro.b.d.a.a());
    public static boolean c = false;
    public static boolean d = false;
    private static boolean e = false;

    public static void a(h hVar) {
        c();
        f.a.a(50011, hVar);
    }

    public static void b(h hVar) {
        c();
        f.a.a(50031, hVar);
    }

    private static synchronized void c() {
        synchronized (a.class) {
            if (!e) {
                b.b();
                e = true;
                com.uc.sync.c.a.a aVar = new com.uc.sync.c.a.a();
                aVar.a = (Application) d.a();
                aVar.d = "180123054500";
                aVar.b = b.b();
                aVar.g = g.a();
                aVar.c = "3300";
                aVar.f = e.d();
                aVar.b = a;
                aVar.e = "2.4.1.985";
                aVar.h = d.a().getSharedPreferences("us_model", 0);
                com.uc.sync.c.b.b bVar = new com.uc.sync.c.b.b();
                c.a(aVar.a);
                bVar.a = aVar.a;
                c.a(aVar.g);
                bVar.g = aVar.g;
                c.a(aVar.h);
                bVar.h = aVar.h;
                c.a(aVar.d);
                bVar.d = aVar.d;
                c.a(aVar.f);
                bVar.f = aVar.f;
                c.a(aVar.e);
                bVar.e = aVar.e;
                c.a(aVar.c);
                bVar.c = aVar.c;
                bVar.b = aVar.b;
                com.uc.sync.c.c.a aVar2 = new com.ucpro.feature.g.h.a();
                f.a;
                c.a((Object) bVar);
                c.a((Object) aVar2);
                com.uc.sync.c.a.a(bVar);
                com.uc.sync.c.a.a(aVar2);
                f.a.a(50011, new com.ucpro.feature.g.d.a.a());
                f.a.a(5001, new com.ucpro.feature.g.f.a());
                f.a.a(50031, new com.ucpro.feature.g.e.e());
            }
        }
    }

    public static void c(h hVar) {
        c();
        f.a.a(5001, hVar);
    }

    public static void a() {
        c();
        com.uc.sync.d.a.a("用户帐户登录:onAccountLogin()");
        com.uc.sync.e.a a = f.a;
        for (int i = 0; i < a.a.size(); i++) {
            ((com.uc.sync.e.g) a.a.get(a.a.keyAt(i))).g();
        }
    }

    public static void b() {
        c();
        com.uc.sync.d.a.a("用户帐户登录:onAccountLogout()");
        com.uc.sync.e.a a = f.a;
        for (int i = 0; i < a.a.size(); i++) {
            ((com.uc.sync.e.g) a.a.get(a.a.keyAt(i))).h();
        }
    }

    public static String a(int i) {
        c();
        com.uc.sync.c.a.h();
        return com.uc.sync.c.a.o().getString("last_sync_time" + i, "");
    }
}
