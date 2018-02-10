package com.c.a.f;

import android.content.Context;
import com.c.a.a.a;
import com.c.a.ac;
import com.c.a.b.c.l;
import com.c.a.c.b;
import com.c.a.d;
import com.c.a.d.c;

/* compiled from: ProGuard */
public final class g extends a {
    private d a;
    private b b;
    private l c;

    public g(a aVar) {
        this.b = aVar.a;
        this.a = new d(aVar.b);
        this.c = aVar.c;
    }

    public final void a(Context context) {
        this.a.a();
        this.b.b();
    }

    public final void a(int i, int i2) {
    }

    public final void a(int i, int i2, int i3, ac acVar) {
        c a = this.c.a();
        if (a != null) {
            acVar.a(i2, i3);
            this.a.b();
            com.c.a.e.d.a("MDPanoramaPlugin mProgram use");
            this.b.a(this.a);
            a.a(this.a, i);
            a.b(this.a, i);
            acVar.a(this.a, this.c.b());
            a.b();
        }
    }

    public final void a() {
        this.b = null;
    }
}
