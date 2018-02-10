package android.support.v7.app;

import android.view.View;

/* compiled from: ProGuard */
final class al implements Runnable {
    final /* synthetic */ View a;
    final /* synthetic */ View b;
    final /* synthetic */ aa c;

    al(aa aaVar, View view, View view2) {
        this.c = aaVar;
        this.a = view;
        this.b = view2;
    }

    public final void run() {
        aa.a(this.c.f, this.a, this.b);
    }
}
