package com.ucpro.feature.video.player.view;

/* compiled from: ProGuard */
public final class x extends e {
    final /* synthetic */ a b;

    public x(a aVar) {
        this.b = aVar;
        super(aVar);
    }

    public final void a() {
        if (this.b.y != null) {
            this.b.y.c();
        }
    }

    public final void a(float f, float f2, float f3, float f4) {
        int b = (int) ((f2 - f4) / ((float) this.b.z));
        if (this.b.y != null) {
            this.b.y.b(b);
        }
    }

    final void b() {
        if (this.b.y != null) {
            this.b.y.d();
        }
    }
}
