package com.c.a.b.c;

import android.app.Activity;
import android.graphics.RectF;
import com.c.a.a.c;
import com.c.a.d.a;
import com.c.a.d.g;
import com.c.a.o;

/* compiled from: ProGuard */
public final class f extends h {
    private static final c c;
    private g a;
    private c b;

    static {
        c a = c.a();
        a.b = -2.0f;
        c = a;
    }

    private f(c cVar) {
        this.b = cVar;
    }

    public final void a(Activity activity) {
        this.a = new g(this.b);
        a.a(activity, this.a);
    }

    public final void b(Activity activity) {
    }

    public final boolean c(Activity activity) {
        return true;
    }

    public final com.c.a.d.c a() {
        return this.a;
    }

    public final c b() {
        return c;
    }

    public final com.c.a.f.a a(com.c.a.a.a aVar) {
        return new com.c.a.f.g(aVar);
    }

    protected final o c() {
        return new j();
    }

    public static f a(int i, RectF rectF) {
        return new f(new c(i, rectF));
    }
}
