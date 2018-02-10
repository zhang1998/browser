package com.ucpro.base.system;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.webkit.ValueCallback;
import com.ucweb.common.util.d;
import com.ucweb.common.util.d.e;
import com.ucweb.common.util.h;
import com.ucweb.common.util.i.c;
import java.util.HashSet;

/* compiled from: ProGuard */
enum a extends c {
    private boolean b;

    a(String str) {
        super(str);
    }

    public final void a(Context context) {
        e.a(context);
    }

    public final String e() {
        return e.d();
    }

    public final String h() {
        return e.e();
    }

    public final String i() {
        return g.c();
    }

    public final String j() {
        return e.b();
    }

    public final String k() {
        return g.b();
    }

    public final String l() {
        return e.h();
    }

    public final String m() {
        return e.j();
    }

    public final int n() {
        return c.b(d.a()).h;
    }

    public final String o() {
        return e.i();
    }

    public final int p() {
        return e.g();
    }

    public final String q() {
        return e.k();
    }

    public final String r() {
        return e.a();
    }

    public final long s() {
        return (long) e.m();
    }

    public final long t() {
        return e.l();
    }

    public final String u() {
        g.a();
        return g.d();
    }

    public final String v() {
        return e.a();
    }

    public final String w() {
        return "release";
    }

    public final Drawable a(String str) {
        return e.c(str);
    }

    public final String b(String str) {
        return e.d(str);
    }

    public final String a(long j) {
        return e.a(j);
    }

    public final boolean c(String str) {
        return e.e(str);
    }

    public final void d(String str) {
        e.f(str);
    }

    public final boolean a(String str, String str2) {
        return e.a(str, str2);
    }

    public final void b(String str, String str2) {
        e.b(str, str2);
    }

    public final String x() {
        return "android";
    }

    public final String y() {
        return "2.4.1.985";
    }

    public final String z() {
        return com.ucpro.c.a.a();
    }

    public final String A() {
        return "3300";
    }

    public final String B() {
        return "180123054500";
    }

    public final String C() {
        return "ucpro";
    }

    public final String D() {
        return "";
    }

    public final String E() {
        return "";
    }

    public final String F() {
        return "3.1";
    }

    public final String G() {
        return "";
    }

    public final String H() {
        return "release";
    }

    public final String I() {
        return c.c();
    }

    public final boolean J() {
        return c.b();
    }

    public final boolean a(Activity activity) {
        return e.a(activity);
    }

    public final boolean e(String str) {
        return e.g(str);
    }

    public final boolean f(String str) {
        return e.h(str);
    }

    public final Intent g(String str) {
        return e.b(str);
    }

    public final boolean a(Context context, String str) {
        return e.a(context, str);
    }

    public final String h(String str) {
        return e.a(str);
    }

    public final byte[] a(boolean z, boolean z2, byte[] bArr) {
        return e.a(z, z2, bArr);
    }

    public final void b(Context context, String str) {
        e.b(context, str);
    }

    public final void a(Context context, ValueCallback<HashSet<String>> valueCallback) {
        e.a(context, (ValueCallback) valueCallback);
    }

    public final boolean K() {
        return this.b;
    }

    public final void a(boolean z) {
        this.b = z;
    }

    public final float a() {
        return h.a.density;
    }

    public final int b() {
        return h.a.densityDpi;
    }

    public final int c() {
        if (h.a.widthPixels < h.a.heightPixels) {
            return h.a.widthPixels;
        }
        return h.a.heightPixels;
    }

    public final int d() {
        if (h.a.heightPixels > h.a.widthPixels) {
            return h.a.heightPixels;
        }
        return h.a.widthPixels;
    }

    public final int f() {
        return h.a.widthPixels;
    }

    public final int g() {
        return h.a.heightPixels;
    }
}
