package com.ucpro.feature.video.player.view;

/* compiled from: ProGuard */
public final class ac extends e {
    final /* synthetic */ a b;

    public ac(a aVar) {
        this.b = aVar;
        super(aVar);
    }

    public final void a() {
        if (this.b.y != null) {
            this.b.y.e();
        }
    }

    public final void a(float f, float f2, float f3, float f4) {
        int c = (int) ((f3 - f) / ((float) this.b.A));
        if (this.b.y != null) {
            this.b.y.c(c);
        }
    }

    final void b() {
        if (this.b.y != null) {
            this.b.y.f();
        }
    }
}
