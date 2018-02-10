package android.support.v4.app;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;

/* compiled from: ProGuard */
final class ck implements OnPreDrawListener {
    final /* synthetic */ View a;
    final /* synthetic */ cb b;
    final /* synthetic */ int c;
    final /* synthetic */ Object d;
    final /* synthetic */ an e;

    ck(an anVar, View view, cb cbVar, int i, Object obj) {
        this.e = anVar;
        this.a = view;
        this.b = cbVar;
        this.c = i;
        this.d = obj;
    }

    public final boolean onPreDraw() {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.e.a(this.b, this.c, this.d);
        return true;
    }
}
