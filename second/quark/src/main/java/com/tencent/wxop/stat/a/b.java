package com.tencent.wxop.stat.a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.wxop.stat.i;
import java.util.Locale;
import java.util.TimeZone;

final class b {
    String a;
    String b;
    DisplayMetrics c;
    int d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    int l;
    String m;
    String n;
    Context o;
    String p;
    String q;
    String r;
    String s;

    private b(Context context) {
        this.b = "2.0.3";
        this.d = VERSION.SDK_INT;
        this.e = Build.MODEL;
        this.f = Build.MANUFACTURER;
        this.g = Locale.getDefault().getLanguage();
        this.l = 0;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.o = context.getApplicationContext();
        this.c = n.d(this.o);
        this.a = n.j(this.o);
        this.h = i.b(this.o);
        this.i = n.i(this.o);
        this.j = TimeZone.getDefault().getID();
        this.l = n.b();
        this.k = n.n(this.o);
        this.m = this.o.getPackageName();
        if (this.d >= 14) {
            this.p = n.s(this.o);
        }
        this.q = n.g().toString();
        this.r = n.r(this.o);
        this.s = n.f();
        this.n = n.x(this.o);
    }
}
