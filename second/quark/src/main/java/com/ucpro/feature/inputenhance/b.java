package com.ucpro.feature.inputenhance;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.uc.imagecodec.export.IPictureView;
import com.ucweb.common.util.h.a;

/* compiled from: ProGuard */
final class b extends a {
    final /* synthetic */ p a;

    b(p pVar) {
        this.a = pVar;
    }

    public final void run() {
        Animation alphaAnimation = new AlphaAnimation(0.0f, IPictureView.DEFAULT_MIN_SCALE);
        alphaAnimation.setDuration(300);
        this.a.a.startAnimation(alphaAnimation);
        this.a.c.add(alphaAnimation);
    }
}
