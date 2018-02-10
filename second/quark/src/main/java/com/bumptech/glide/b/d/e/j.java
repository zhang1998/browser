package com.bumptech.glide.b.d.e;

import android.graphics.Bitmap;
import android.os.Handler;
import com.bumptech.glide.f.a.f;

/* compiled from: ProGuard */
final class j extends f<Bitmap> {
    final int a;
    Bitmap b;
    private final Handler c;
    private final long d;

    public final /* synthetic */ void a(Object obj) {
        this.b = (Bitmap) obj;
        this.c.sendMessageAtTime(this.c.obtainMessage(1, this), this.d);
    }

    j(Handler handler, int i, long j) {
        this.c = handler;
        this.a = i;
        this.d = j;
    }
}
