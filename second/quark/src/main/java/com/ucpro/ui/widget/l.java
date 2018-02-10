package com.ucpro.ui.widget;

/* compiled from: ProGuard */
public final class l implements Runnable {
    final /* synthetic */ v a;

    public l(v vVar) {
        this.a = vVar;
    }

    public final void run() {
        v vVar = this.a;
        vVar.post(vVar.j);
        vVar.setVisibility(8);
        if (vVar.b != null) {
            vVar.b.a();
        }
    }
}
