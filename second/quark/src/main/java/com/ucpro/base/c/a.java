package com.ucpro.base.c;

import android.app.Activity;
import com.ucpro.base.c.a.b;
import com.ucpro.base.c.a.c;
import com.ucpro.base.c.b.m;
import com.ucpro.base.c.b.r;

/* compiled from: ProGuard */
public final class a implements b {
    private Activity a;
    private m b;
    private b c;

    public a(Activity activity) {
        this.a = activity;
    }

    public final Activity a() {
        return this.a;
    }

    public final m b() {
        if (this.b == null) {
            this.b = new r(this.a);
        }
        return this.b;
    }

    public final c c() {
        if (this.c == null) {
            this.c = new b(this.a, b());
        }
        return this.c;
    }
}
