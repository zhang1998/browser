package com.ucpro.feature.webwindow.k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.webkit.ValueCallback;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public final class e extends AnimatorListenerAdapter {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ a b;

    public e(a aVar, ValueCallback valueCallback) {
        this.b = aVar;
        this.a = valueCallback;
    }

    public final void onAnimationEnd(Animator animator) {
        this.b.setTranslationY((float) (-this.b.getMeasuredHeight()));
        this.b.setScaleX(IPictureView.DEFAULT_MIN_SCALE);
        this.b.setScaleY(IPictureView.DEFAULT_MIN_SCALE);
        this.b.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
        this.b.e.setRotation(0.0f);
        d b = this.b.f;
        b.b = 0.0f;
        b.c = -90.0f;
        b.d = true;
        this.b.f.invalidate();
        this.a.onReceiveValue(Boolean.valueOf(true));
    }
}
