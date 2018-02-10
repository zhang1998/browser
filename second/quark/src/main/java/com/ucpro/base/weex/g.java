package com.ucpro.base.weex;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

/* compiled from: ProGuard */
final class g implements Runnable {
    final /* synthetic */ Bitmap a;
    final /* synthetic */ i b;

    g(i iVar, Bitmap bitmap) {
        this.b = iVar;
        this.a = bitmap;
    }

    public final void run() {
        try {
            if (this.a != null && !this.a.isRecycled()) {
                Drawable gVar = new com.ucpro.ui.widget.g(this.a);
                gVar.setBounds(0, 0, this.b.b.getWidth(), this.b.b.getHeight());
                this.b.b.setImageDrawable(gVar);
            }
        } catch (Exception e) {
        }
    }
}
