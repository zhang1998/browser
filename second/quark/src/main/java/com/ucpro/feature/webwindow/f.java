package com.ucpro.feature.webwindow;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

/* compiled from: ProGuard */
final class f extends FrameLayout {
    final View a;
    final View b = new ImageView(getContext());
    ObjectAnimator c;
    ObjectAnimator d;
    private final long e = 350;
    private final ImageView f;

    public f(Context context) {
        super(context);
        addView(this.b, -1, -1);
        this.a = new ImageView(getContext());
        this.a.setAlpha(0.0f);
        addView(this.a, -1, -1);
        this.f = new ImageView(getContext());
        this.f.setScaleType(ScaleType.CENTER);
        addView(this.f, -1, -1);
    }
}
