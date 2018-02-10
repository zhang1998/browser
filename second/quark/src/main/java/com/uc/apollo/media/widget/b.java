package com.uc.apollo.media.widget;

import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

/* compiled from: ProGuard */
public final class b extends ImageView {
    private RotateAnimation a;

    public b(Context context) {
        super(context);
    }

    public final void a() {
        if (this.a == null) {
            this.a = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            this.a.setInterpolator(new LinearInterpolator());
            this.a.setDuration(1500);
            this.a.setRepeatMode(-1);
            this.a.setRepeatCount(-1);
        }
        if (getAnimation() == null) {
            startAnimation(this.a);
        }
    }
}
