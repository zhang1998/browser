package com.ucpro.feature.privacymode.view;

import android.widget.ImageView;

/* compiled from: ProGuard */
final class e implements Runnable {
    final /* synthetic */ b a;

    e(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        for (ImageView imageDrawable : this.a.e) {
            imageDrawable.setImageDrawable(null);
        }
    }
}
