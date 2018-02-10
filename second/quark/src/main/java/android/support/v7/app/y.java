package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.cy;
import android.view.View;

/* compiled from: ProGuard */
final class y extends cy {
    final /* synthetic */ d a;

    y(d dVar) {
        this.a = dVar;
    }

    public final void b(View view) {
        this.a.a.b.setVisibility(8);
        if (this.a.a.c != null) {
            this.a.a.c.dismiss();
        } else if (this.a.a.b.getParent() instanceof View) {
            ViewCompat.u((View) this.a.a.b.getParent());
        }
        this.a.a.b.removeAllViews();
        this.a.a.e.a(null);
        this.a.a.e = null;
    }
}
