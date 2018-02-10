package com.ucpro.feature.video.player.view;

import android.content.Context;
import android.widget.FrameLayout;

/* compiled from: ProGuard */
final class as extends FrameLayout {
    final /* synthetic */ ah a;

    as(ah ahVar, Context context) {
        this.a = ahVar;
        super(context);
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        post(new p(this));
    }
}
