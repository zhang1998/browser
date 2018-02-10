package com.ucpro.feature.p;

import android.text.TextUtils;
import com.ucpro.ui.c.a;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public final class b {
    int a;
    int b;
    String c;
    int d;
    String e;
    boolean f;
    boolean g;
    Object h;
    boolean i;
    String j;
    String k;
    String l;
    private String m;

    public b(int i, String str, String str2, int i2, Object obj) {
        this(i, str, str2, i2, obj, (byte) 0);
    }

    private b(int i, String str, String str2, int i2, Object obj, byte b) {
        c.a((CharSequence) str);
        c.a((CharSequence) str2);
        this.a = i;
        this.e = str;
        this.m = str2;
        this.b = i2;
        this.f = true;
        this.g = false;
        this.h = obj;
    }

    public final String a() {
        if (TextUtils.isEmpty(this.c)) {
            return a.d(this.b);
        }
        return this.c;
    }
}
