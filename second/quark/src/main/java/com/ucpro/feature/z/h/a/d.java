package com.ucpro.feature.z.h.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class d extends AnimatorListenerAdapter {
    final /* synthetic */ boolean a;
    final /* synthetic */ int b;
    final /* synthetic */ i c;

    d(i iVar, boolean z, int i) {
        this.c = iVar;
        this.a = z;
        this.b = i;
    }

    public final void onAnimationStart(Animator animator) {
        this.c.b.setVisibility(4);
        this.c.b.setY((float) (-this.c.b.getMeasuredHeight()));
        this.c.c.setVisibility(0);
        this.c.c.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
        if (this.a) {
            this.c.e.setVisibility(0);
            this.c.b.requestFocus();
        } else {
            this.c.e.setVisibility(8);
            this.c.b.clearFocus();
        }
        this.c.q = 2;
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.c.q == 2) {
            this.c.c.setVisibility(8);
            this.c.b.setVisibility(0);
            this.c.b.setY((float) this.b);
            this.c.b.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
            this.c.q = 0;
        }
    }
}
