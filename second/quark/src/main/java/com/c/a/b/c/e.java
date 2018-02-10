package com.c.a.b.c;

import android.app.Activity;
import android.graphics.RectF;
import com.c.a.d.a;
import com.c.a.d.c;
import com.c.a.d.d;
import com.c.a.f.g;

/* compiled from: ProGuard */
public final class e extends h {
    c a;
    private float b;
    private boolean c;
    private RectF d;

    public e(RectF rectF, float f, boolean z) {
        this.d = rectF;
        this.b = f;
        this.c = z;
    }

    public final void a(Activity activity) {
        this.a = new d(this.d, this.b, this.c);
        a.a(activity, this.a);
    }

    public final void b(Activity activity) {
    }

    public final boolean c(Activity activity) {
        return true;
    }

    public final c a() {
        return this.a;
    }

    public final com.c.a.a.c b() {
        return com.c.a.a.c.a;
    }

    public final com.c.a.f.a a(com.c.a.a.a aVar) {
        return new g(aVar);
    }
}
