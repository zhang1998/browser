package com.ucpro.feature.video.player.view;

import android.widget.FrameLayout.LayoutParams;

/* compiled from: ProGuard */
final class p implements Runnable {
    final /* synthetic */ as a;

    p(as asVar) {
        this.a = asVar;
    }

    public final void run() {
        if (this.a.a.b != null) {
            LayoutParams layoutParams = (LayoutParams) this.a.a.b.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = this.a.getMeasuredWidth() / 2;
                layoutParams.gravity = 5;
            }
            this.a.a.b.forceLayout();
            this.a.a.b.setLayoutParams(layoutParams);
        }
    }
}
