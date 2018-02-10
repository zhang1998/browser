package com.ucpro.feature.webwindow.a;

import android.view.ViewGroup;

/* compiled from: ProGuard */
public final class g {
    public c a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public f g;

    public final void a() {
        if (this.g != null) {
            f fVar = this.g;
            fVar.animate().alpha(0.0f).setDuration(300).setListener(new h(fVar, new a(this))).start();
        }
    }

    public final void b() {
        if (this.g != null && this.g.getParent() != null) {
            ((ViewGroup) this.g.getParent()).removeView(this.g);
            this.g = null;
        }
    }
}
