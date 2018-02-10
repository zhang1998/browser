package com.ucpro.feature.webwindow;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: ProGuard */
public final class ad implements bp {
    private final x a;
    private final bb b;

    public ad(x xVar, bb bbVar) {
        this.a = xVar;
        this.b = bbVar;
    }

    public final View a() {
        return this.a.getContentView();
    }

    public final View b() {
        return this.a.getBottomBarView();
    }

    public final boolean c() {
        return false;
    }

    public final boolean d() {
        return false;
    }

    public final boolean e() {
        return this.b.b();
    }

    public final boolean f() {
        return this.b.c();
    }

    public final void a(MotionEvent motionEvent) {
        this.a.a(motionEvent);
    }

    public final void a(View view) {
        x xVar = this.a;
        xVar.getLayerViews().add(view);
        xVar.addView(view);
    }
}
