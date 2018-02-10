package com.ucpro.feature.x;

import android.graphics.Bitmap;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ Bitmap a;
    final /* synthetic */ int b;
    final /* synthetic */ h c;

    c(h hVar, Bitmap bitmap, int i) {
        this.c = hVar;
        this.a = bitmap;
        this.b = i;
    }

    public final void run() {
        h.a(this.c, this.a, this.b);
    }
}
