package com.ucpro.feature.z.h.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class a extends AnimatorListenerAdapter {
    final /* synthetic */ float a;
    final /* synthetic */ h b;

    a(h hVar, float f) {
        this.b = hVar;
        this.a = f;
    }

    public final void onAnimationStart(Animator animator) {
        this.b.q = 1;
    }

    public final void onAnimationEnd(Animator animator) {
        if (this.b.q == 1) {
            this.b.c.setVisibility(8);
            this.b.c.setY((float) (-this.b.b.getMeasuredHeight()));
            this.b.b.setVisibility(0);
            this.b.b.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
            this.b.b.setY(this.a);
            this.b.q = 0;
        }
        if (this.b.d != null) {
            this.b.d.setVisibility(8);
        }
        if (this.b.w != null) {
            this.b.w.a();
            this.b.w = null;
        }
    }
}
