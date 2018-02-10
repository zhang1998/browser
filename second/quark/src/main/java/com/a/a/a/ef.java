package com.a.a.a;

import android.content.Context;

/* compiled from: ProGuard */
public final class ef implements ee {
    private static ef c;
    ee a = new eg(this.b);
    private Context b;

    private ef(Context context) {
        this.b = context;
    }

    public final synchronized eg c() {
        return (eg) this.a;
    }

    public static synchronized ef a(Context context) {
        ef efVar;
        synchronized (ef.class) {
            if (c == null && context != null) {
                c = new ef(context);
            }
            efVar = c;
        }
        return efVar;
    }

    public final void a(Object obj) {
        fj.b(new eq(this, obj));
    }

    public final void a() {
        fj.b(new en(this));
    }

    public final void b() {
        fj.c(new ep(this));
    }
}
