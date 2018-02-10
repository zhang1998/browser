package com.taobao.weex.ui.view.refresh.circlebar;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: ProGuard */
final class b extends Animation {
    final /* synthetic */ e a;
    final /* synthetic */ MaterialProgressDrawable b;

    b(MaterialProgressDrawable materialProgressDrawable, e eVar) {
        this.b = materialProgressDrawable;
        this.a = eVar;
    }

    public final void applyTransformation(float f, Transformation transformation) {
        if (this.b.b) {
            MaterialProgressDrawable.a(f, this.a);
            return;
        }
        float a = MaterialProgressDrawable.b(this.a);
        float f2 = this.a.l;
        float f3 = this.a.k;
        float f4 = this.a.m;
        MaterialProgressDrawable.c(f, this.a);
        if (f <= 0.5f) {
            float f5 = 0.8f - a;
            this.a.a(f3 + (MaterialProgressDrawable.d.getInterpolation(f / 0.5f) * f5));
        }
        if (f > 0.5f) {
            this.a.b(((0.8f - a) * MaterialProgressDrawable.d.getInterpolation((f - 0.5f) / 0.5f)) + f2);
        }
        this.a.c((0.25f * f) + f4);
        this.b.a((216.0f * f) + (1080.0f * (this.b.k / 5.0f)));
    }
}
