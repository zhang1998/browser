package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.cy;
import android.view.View;

/* compiled from: ProGuard */
final class h extends cy {
    final /* synthetic */ ao a;

    h(ao aoVar) {
        this.a = aoVar;
    }

    public final void b(View view) {
        if (this.a.C && this.a.t != null) {
            ViewCompat.b(this.a.t, 0.0f);
            ViewCompat.b(this.a.q, 0.0f);
        }
        this.a.q.setVisibility(8);
        this.a.q.setTransitioning(false);
        this.a.H = null;
        ao aoVar = this.a;
        if (aoVar.c != null) {
            aoVar.c.a(aoVar.b);
            aoVar.b = null;
            aoVar.c = null;
        }
        if (this.a.p != null) {
            ViewCompat.u(this.a.p);
        }
    }
}
