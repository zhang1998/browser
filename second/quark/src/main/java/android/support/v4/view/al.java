package android.support.v4.view;

import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
final class al implements Runnable {
    WeakReference<View> a;
    bo b;
    final /* synthetic */ ay c;

    private al(ay ayVar, bo boVar, View view) {
        this.c = ayVar;
        this.a = new WeakReference(view);
        this.b = boVar;
    }

    public final void run() {
        View view = (View) this.a.get();
        if (view != null) {
            this.c.c(this.b, view);
        }
    }
}
