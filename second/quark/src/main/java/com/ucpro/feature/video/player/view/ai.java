package com.ucpro.feature.video.player.view;

import com.ucpro.feature.video.player.a.b;

/* compiled from: ProGuard */
final class ai implements n {
    final /* synthetic */ au a;
    private int b = 0;

    ai(au auVar) {
        this.a = auVar;
    }

    public final void a(int i, boolean z) {
        if (z) {
            b a = b.a().a(7, Boolean.valueOf(i >= this.b)).a(8, Float.valueOf(((float) i) / 1000.0f));
            this.a.p.a(10003, a, null);
            a.b();
        }
    }

    public final void a() {
        this.b = this.a.b.getProgress();
        this.a.p.a(10004, null, null);
    }

    public final void b() {
        this.a.p.a(10005, null, null);
    }
}
