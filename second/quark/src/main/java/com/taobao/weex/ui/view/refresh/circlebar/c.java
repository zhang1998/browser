package com.taobao.weex.ui.view.refresh.circlebar;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class c implements AnimationListener {
    final /* synthetic */ e a;
    final /* synthetic */ MaterialProgressDrawable b;

    c(MaterialProgressDrawable materialProgressDrawable, e eVar) {
        this.b = materialProgressDrawable;
        this.a = eVar;
    }

    public final void onAnimationStart(Animation animation) {
        this.b.k = 0.0f;
    }

    public final void onAnimationEnd(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
        this.a.b();
        e eVar = this.a;
        eVar.a(eVar.a());
        this.a.a(this.a.e);
        if (this.b.b) {
            this.b.b = false;
            animation.setDuration(1332);
            this.a.a(false);
            return;
        }
        this.b.k = (this.b.k + IPictureView.DEFAULT_MIN_SCALE) % 5.0f;
    }
}
