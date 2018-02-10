package com.uc.sync.c;

import android.content.SharedPreferences;
import com.uc.sync.c.b.b;
import com.ucweb.common.util.c;
import okhttp3.OkHttpClient;

/* compiled from: ProGuard */
public final class a implements com.uc.sync.c.c.a {
    private static com.uc.sync.c.c.a a = null;
    private static b b = null;
    private static a c = null;

    public static void a(b bVar) {
        b = bVar;
        c.a((Object) bVar);
    }

    public static void a(com.uc.sync.c.c.a aVar) {
        a = aVar;
        c.a((Object) aVar);
    }

    public static a h() {
        if (c == null) {
            c.a(a);
            c.a(b);
            c = new a();
        }
        return c;
    }

    public final String a() {
        c.a(a);
        return a.a();
    }

    public final String b() {
        c.a(a);
        CharSequence b = a.b();
        c.a(b);
        return b;
    }

    public static String i() {
        c.a(b);
        CharSequence charSequence = b.f;
        c.a(charSequence);
        return charSequence;
    }

    public final String c() {
        c.a(a);
        return a.c();
    }

    public final boolean d() {
        c.a(a);
        return a.d();
    }

    public final boolean e() {
        c.a(a);
        return a.e();
    }

    public final boolean f() {
        c.a(a);
        return a.f();
    }

    public final byte g() {
        c.a(a);
        return a.g();
    }

    public final byte[] a(byte[] bArr) {
        c.a(a);
        return a.a(bArr);
    }

    public final byte[] b(byte[] bArr) {
        c.a(a);
        return a.b(bArr);
    }

    public final void a(String str, String str2, String... strArr) {
        c.a(a);
        a.a(str, str2, strArr);
    }

    public static boolean j() {
        c.a(b);
        return b.b;
    }

    public static String k() {
        c.a(b);
        CharSequence charSequence = b.c;
        c.a(charSequence);
        return charSequence;
    }

    public static String l() {
        c.a(b);
        CharSequence charSequence = b.d;
        c.a(charSequence);
        return charSequence;
    }

    public static String m() {
        c.a(b);
        CharSequence charSequence = b.e;
        c.a(charSequence);
        return charSequence;
    }

    public static OkHttpClient n() {
        c.a(b);
        Object obj = b.g;
        c.a(obj);
        return obj;
    }

    public static SharedPreferences o() {
        c.a(b);
        Object obj = b.h;
        c.a(obj);
        return obj;
    }
}
