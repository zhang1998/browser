package com.uc.base.wa.a;

import android.content.Context;
import android.os.Looper;
import com.uc.base.wa.component.WaStatService;
import com.uc.base.wa.component.g;
import com.uc.base.wa.component.h;
import com.uc.base.wa.config.m;
import com.uc.base.wa.e.i;
import com.uc.base.wa.f.e;
import java.io.File;
import java.util.HashMap;
import java.util.Timer;

/* compiled from: ProGuard */
public abstract class c {
    public static c a = null;
    private static Context b = null;
    private static boolean c = false;
    private static int d;
    private static String e;
    private static long f = 0;
    private static Timer g;

    public abstract b a(String str, byte[] bArr);

    public abstract boolean a(byte[] bArr, File file);

    public abstract byte[] a(File file);

    public abstract byte[] a(byte[] bArr);

    public abstract void b(String str);

    public abstract byte[] b(byte[] bArr);

    public abstract void c();

    public abstract byte[] c(byte[] bArr);

    public abstract String h();

    public abstract boolean i();

    public abstract boolean j();

    public abstract String k();

    public abstract String l();

    public abstract String[] m();

    public abstract HashMap<String, String> n();

    public abstract Class<? extends WaStatService> o();

    public static c a() {
        return a;
    }

    public static Context b() {
        return b;
    }

    public static void d() {
        if (a != null && !c) {
            synchronized (c.class) {
                if (!(a == null || c)) {
                    a.c();
                    i.a();
                    if (f > 0) {
                        if (g == null) {
                            g = new Timer();
                        }
                        g.schedule(new a(), f);
                    }
                }
            }
        }
    }

    public static void e() {
        c = true;
    }

    public static int f() {
        if (e.a() != Looper.myLooper()) {
            a.b("");
        }
        return d;
    }

    public static void a(String str) {
        e = str;
    }

    public static String g() {
        return e;
    }

    public static void a(Context context, c cVar) {
        b = context;
        a = cVar;
        h hVar = com.uc.base.wa.component.e.a;
        if (hVar.a == null) {
            hVar.a = new g(hVar, context);
        }
        m.r();
    }
}
