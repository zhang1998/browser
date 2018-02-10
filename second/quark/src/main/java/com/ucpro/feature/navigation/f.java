package com.ucpro.feature.navigation;

import android.view.View;
import com.ucpro.feature.y.b;

/* compiled from: ProGuard */
public final class f implements d {
    final a a;
    final l b;
    final b c;
    boolean d;

    public f(a aVar, l lVar, b bVar) {
        this.a = aVar;
        this.b = lVar;
        this.c = bVar;
    }

    public final void a() {
        c();
    }

    public final void b() {
        c();
    }

    private void c() {
        if (!this.d) {
            this.d = true;
            this.c.setEnableGesture(true);
            this.a.c.a.a();
            this.a.a.b().b((View) this.b);
            this.a.e();
        }
    }
}
