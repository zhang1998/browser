package android.mini.support.v4.view;

import android.view.View;
import java.util.WeakHashMap;

/* compiled from: ProGuard */
class cm extends ck {
    WeakHashMap<View, Integer> b = null;

    cm() {
    }

    public void a(cs csVar, View view, cx cxVar) {
        view.setTag(2113929216, cxVar);
        view.animate().setListener(new ct(new cl(csVar), view));
    }

    public final void a(View view, long j) {
        view.animate().setDuration(j);
    }

    public final void a(cs csVar, View view, float f) {
        view.animate().alpha(f);
    }

    public final void b(cs csVar, View view, float f) {
        view.animate().translationX(f);
    }

    public final void c(cs csVar, View view, float f) {
        view.animate().translationY(f);
    }

    public final void a(cs csVar, View view) {
        view.animate().cancel();
    }

    public final void b(cs csVar, View view) {
        view.animate().start();
    }
}
