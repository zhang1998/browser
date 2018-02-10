package android.support.v7.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.bo;
import android.view.View;

/* compiled from: ProGuard */
final class bg extends r {
    final /* synthetic */ bh a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ bo d;
    final /* synthetic */ ab e;

    bg(ab abVar, bh bhVar, int i, int i2, bo boVar) {
        this.e = abVar;
        this.a = bhVar;
        this.b = i;
        this.c = i2;
        this.d = boVar;
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
        this.e.g(this.a);
        this.e.k.remove(this.a);
        this.e.e();
    }
}
