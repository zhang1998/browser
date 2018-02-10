package com.ucpro.feature.video.player.view;

/* compiled from: ProGuard */
public final class l extends e {
    final /* synthetic */ a b;

    public l(a aVar) {
        this.b = aVar;
        super(aVar);
    }

    public final void a() {
        if (this.b.y != null) {
            this.b.y.a();
        }
    }

    public final void a(float f, float f2, float f3, float f4) {
        int b = (int) ((f2 - f4) / ((float) this.b.z));
        if (this.b.y != null) {
            this.b.y.a(b);
        }
    }

    final void b() {
        if (this.b.y != null) {
            this.b.y.b();
        }
    }
}
