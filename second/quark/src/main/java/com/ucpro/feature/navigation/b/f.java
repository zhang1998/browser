package com.ucpro.feature.navigation.b;

import android.graphics.Bitmap;

/* compiled from: ProGuard */
final class f implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Bitmap b;
    final /* synthetic */ b c;

    f(b bVar, String str, Bitmap bitmap) {
        this.c = bVar;
        this.a = str;
        this.b = bitmap;
    }

    public final void run() {
        b.a(this.a, this.b);
    }
}
