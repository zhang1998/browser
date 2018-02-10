package com.ucpro.b.d.a;

import android.content.SharedPreferences;
import com.ucweb.common.util.c;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
public final class b {
    private static b l = new b();
    public SharedPreferences a;
    public String b = "2.4.1.985";
    public String c = "release";
    public String d = "180123054500";
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public int k = 0;

    public static b a() {
        return l;
    }

    private b() {
        c.a((CharSequence) "2.4.1.985");
        c.a((CharSequence) "release");
        c.a((CharSequence) "180123054500");
        this.a = d.a().getSharedPreferences("__vm", 0);
    }

    public final boolean b() {
        return this.k == 1;
    }
}
