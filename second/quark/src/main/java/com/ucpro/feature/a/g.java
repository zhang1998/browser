package com.ucpro.feature.a;

import android.widget.ImageView;
import com.bumptech.glide.c;

/* compiled from: ProGuard */
final class g implements Runnable {
    final /* synthetic */ ImageView a;
    final /* synthetic */ String b;
    final /* synthetic */ r c;

    g(r rVar, ImageView imageView, String str) {
        this.c = rVar;
        this.a = imageView;
        this.b = str;
    }

    public final void run() {
        c.b(this.a.getContext()).a(this.b).a(this.a);
    }
}
