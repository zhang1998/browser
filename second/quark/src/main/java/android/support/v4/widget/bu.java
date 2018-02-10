package android.support.v4.widget;

import android.support.v4.view.ViewCompat;
import android.view.animation.AnimationUtils;

/* compiled from: ProGuard */
final class bu implements Runnable {
    final /* synthetic */ au a;

    private bu(au auVar) {
        this.a = auVar;
    }

    public final void run() {
        int i = 0;
        if (this.a.o) {
            an d;
            if (this.a.m) {
                this.a.m = false;
                d = this.a.a;
                d.e = AnimationUtils.currentAnimationTimeMillis();
                d.i = -1;
                d.f = d.e;
                d.j = 0.5f;
                d.g = 0;
                d.h = 0;
            }
            d = this.a.a;
            if (d.i > 0 && AnimationUtils.currentAnimationTimeMillis() > d.i + ((long) d.k)) {
                i = 1;
            }
            if (i == 0 && this.a.a()) {
                if (this.a.n) {
                    this.a.n = false;
                    au.i(this.a);
                }
                if (d.f == 0) {
                    throw new RuntimeException("Cannot compute scroll delta before calling start()");
                }
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float a = d.a(currentAnimationTimeMillis);
                a = (a * 4.0f) + ((-4.0f * a) * a);
                long j = currentAnimationTimeMillis - d.f;
                d.f = currentAnimationTimeMillis;
                d.g = (int) ((((float) j) * a) * d.c);
                d.h = (int) ((a * ((float) j)) * d.d);
                this.a.a(d.h);
                ViewCompat.a(this.a.c, (Runnable) this);
                return;
            }
            this.a.o = false;
        }
    }
}
