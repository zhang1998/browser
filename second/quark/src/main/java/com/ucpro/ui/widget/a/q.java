package com.ucpro.ui.widget.a;

import android.view.animation.AnimationUtils;

/* compiled from: ProGuard */
final class q implements Runnable {
    final /* synthetic */ e a;

    private q(e eVar) {
        this.a = eVar;
    }

    public final void run() {
        int i = 0;
        if (this.a.o) {
            s d;
            if (this.a.m) {
                this.a.m = false;
                d = this.a.a;
                d.d = AnimationUtils.currentAnimationTimeMillis();
                d.h = -1;
                d.e = d.d;
                d.i = 0.5f;
                d.f = 0;
                d.g = 0;
            }
            d = this.a.a;
            if (d.h > 0 && AnimationUtils.currentAnimationTimeMillis() > d.h + ((long) d.j)) {
                i = 1;
            }
            if (i == 0 && this.a.b()) {
                if (this.a.n) {
                    this.a.n = false;
                    e.i(this.a);
                }
                if (d.e == 0) {
                    throw new RuntimeException("Cannot compute scroll delta before calling start()");
                }
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float a = d.a(currentAnimationTimeMillis);
                a = (a * 4.0f) + ((-4.0f * a) * a);
                long j = currentAnimationTimeMillis - d.e;
                d.e = currentAnimationTimeMillis;
                d.f = (int) ((((float) j) * a) * d.b);
                d.g = (int) ((a * ((float) j)) * d.c);
                this.a.a(d.g);
                this.a.a().post(this);
                return;
            }
            this.a.o = false;
        }
    }
}
