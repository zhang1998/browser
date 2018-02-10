package com.ucpro.feature.webwindow;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v4.view.a.b;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class bi extends RelativeLayout {
    ImageView a = new ImageView(getContext());
    ImageView b;
    int c;
    int d;
    private boolean e = true;
    private float f;

    public bi(Context context) {
        super(context);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        addView(this.a, layoutParams);
        this.b = new ImageView(getContext());
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.b, layoutParams);
        a();
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.e) {
            this.e = false;
            this.c = -this.a.getWidth();
            this.d = this.b.getWidth();
            setLeftIndicatorProgress(0.0f);
            setRightIndicatorProgress(0.0f);
        }
    }

    public final void setDragProgress(float f) {
        this.f = f;
        if (!this.e) {
            if (this.f == 0.0f) {
                setLeftIndicatorProgress(0.0f);
                setRightIndicatorProgress(0.0f);
            } else if (this.f > 0.0f) {
                this.b.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
                this.a.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
                setRightIndicatorProgress(0.0f);
                setLeftIndicatorProgress(this.f);
            } else if (this.f < 0.0f) {
                this.b.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
                this.a.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
                setRightIndicatorProgress(this.f);
                setLeftIndicatorProgress(0.0f);
            }
        }
    }

    private void setRightIndicatorProgress(float f) {
        this.b.setTranslationX((float) (Math.round(((float) this.b.getWidth()) * f) + this.d));
    }

    private void setLeftIndicatorProgress(float f) {
        this.a.setTranslationX((float) (Math.round(((float) this.a.getWidth()) * f) + this.c));
    }

    public final void a() {
        this.a.setImageDrawable(a.a("left_indicator.svg"));
        a.a(this.a);
        this.b.setImageDrawable(a.a("right_indicator.svg"));
        a.a(this.b);
    }

    public final void b() {
        if (this.a.getAlpha() != 0.0f) {
            a(this.a);
        }
        if (this.b.getAlpha() != 0.0f) {
            a(this.b);
        }
    }

    static void a(View view, float f, float f2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", new float[]{f, f2});
        ofFloat.setDuration(250);
        ofFloat.setInterpolator(new b());
        ofFloat.start();
    }

    private static void a(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{IPictureView.DEFAULT_MIN_SCALE, 0.0f});
        ofFloat.setDuration(250);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.start();
    }

    public final void setLeftIndicatorVisible(boolean z) {
        if (z) {
            this.a.setVisibility(0);
        } else {
            this.a.setVisibility(4);
        }
    }

    public final void setRightIndicatorVisible(boolean z) {
        if (z) {
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(4);
        }
    }
}
