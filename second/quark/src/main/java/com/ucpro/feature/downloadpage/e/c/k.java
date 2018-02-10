package com.ucpro.feature.downloadpage.e.c;

import android.graphics.drawable.Drawable;

/* compiled from: ProGuard */
final class k implements Runnable {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public final void run() {
        if (this.a.a != null) {
            s sVar = this.a.a;
            Drawable drawable = this.a.h;
            if (this.a.c != -3) {
                sVar.l.setImageIcon(drawable);
            }
            this.a.a.a(this.a.c, this.a.d, this.a.e, this.a.f, false, this.a.g);
            this.a.a.c(this.a.c);
        }
    }
}
