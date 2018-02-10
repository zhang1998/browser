package android.mini.support.v7.widget;

import android.mini.support.v4.view.ViewCompat;
import android.mini.support.v4.view.cs;
import android.view.View;

/* compiled from: ProGuard */
final class l extends q {
    final /* synthetic */ bf a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ cs d;
    final /* synthetic */ r e;

    l(r rVar, bf bfVar, int i, int i2, cs csVar) {
        this.e = rVar;
        this.a = bfVar;
        this.b = i;
        this.c = i2;
        this.d = csVar;
        super();
    }

    public final void a(View view) {
    }

    public final void c(View view) {
        if (this.b != 0) {
            ViewCompat.a(view, 0.0f);
        }
        if (this.c != 0) {
            ViewCompat.b(view, 0.0f);
        }
    }

    public final void b(View view) {
        this.d.a(null);
        this.e.f(this.a);
        this.e.e.remove(this.a);
        this.e.c();
    }
}
