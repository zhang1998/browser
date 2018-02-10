package android.mini.support.v4.view;

import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
final class cj implements Runnable {
    WeakReference<View> a;
    cs b;
    final /* synthetic */ ck c;

    private cj(ck ckVar, cs csVar, View view) {
        this.c = ckVar;
        this.a = new WeakReference(view);
        this.b = csVar;
    }

    public final void run() {
        View view = (View) this.a.get();
        if (view != null) {
            this.c.c(this.b, view);
        }
    }
}
