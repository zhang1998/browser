package com.ucpro.feature.t;

import android.graphics.Bitmap;

/* compiled from: ProGuard */
final class i implements Runnable {
    final /* synthetic */ c a;

    i(c cVar) {
        this.a = cVar;
    }

    public final void run() {
        c cVar = this.a;
        for (int i = 0; i < cVar.a.size(); i++) {
            Bitmap bitmap = (Bitmap) cVar.a.get(cVar.a.keyAt(i));
            if (!(bitmap == null || bitmap.isRecycled())) {
                bitmap.recycle();
            }
        }
        cVar.a.clear();
    }
}
