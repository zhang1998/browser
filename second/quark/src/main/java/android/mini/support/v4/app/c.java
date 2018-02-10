package android.mini.support.v4.app;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;

/* compiled from: ProGuard */
final class c implements OnPreDrawListener {
    final /* synthetic */ View a;
    final /* synthetic */ e b;
    final /* synthetic */ int c;
    final /* synthetic */ Object d;
    final /* synthetic */ f e;

    c(f fVar, View view, e eVar, int i, Object obj) {
        this.e = fVar;
        this.a = view;
        this.b = eVar;
        this.c = i;
        this.d = obj;
    }

    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.e.a(this.b, this.c, this.d);
        return true;
    }
}
