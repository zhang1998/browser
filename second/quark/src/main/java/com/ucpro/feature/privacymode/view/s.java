package com.ucpro.feature.privacymode.view;

import android.widget.ImageView;

/* compiled from: ProGuard */
final class s implements Runnable {
    final /* synthetic */ b a;

    s(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        for (ImageView imageDrawable : this.a.e) {
            imageDrawable.setImageDrawable(null);
        }
    }
}
