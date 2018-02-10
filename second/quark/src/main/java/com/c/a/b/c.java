package com.c.a.b;

import android.app.Activity;
import com.c.a.e.b;
import com.c.a.e.e;
import com.c.a.t;

/* compiled from: ProGuard */
public abstract class c<T extends b> {
    int d;
    public T e;
    t f;
    public e g;

    public abstract T a(int i);

    public c(int i, e eVar) {
        this.g = eVar;
        this.d = i;
    }

    public final void a(Activity activity, t tVar) {
        this.f = tVar;
        a(activity, this.d);
    }

    final void a(Activity activity, int i) {
        if (this.e != null && this.e.c(activity)) {
            this.e.b(activity);
        }
        this.e = a(i);
        if (this.e.c(activity)) {
            a(activity);
        } else {
            b.a.post(new a(this, i));
        }
    }

    public void b(Activity activity, int i) {
        this.g.a(new d(this, i, activity));
    }

    public void a(Activity activity) {
        if (this.e.c(activity)) {
            this.e.a(activity);
        }
    }
}
