package android.support.v7.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: ProGuard */
final class bz extends Animation {
    final float a;
    final float b;
    final float c;
    final /* synthetic */ SwitchCompat d;

    private bz(SwitchCompat switchCompat, float f, float f2) {
        this.d = switchCompat;
        this.a = f;
        this.b = f2;
        this.c = f2 - f;
    }

    protected final void applyTransformation(float f, Transformation transformation) {
        this.d.setThumbPosition(this.a + (this.c * f));
    }
}
