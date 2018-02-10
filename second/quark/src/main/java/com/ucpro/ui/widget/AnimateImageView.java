package com.ucpro.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.view.a.b;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public class AnimateImageView extends ImageView {
    private Drawable a;
    private Drawable b;
    private AnimatorSet c;
    private float d;
    private float e;
    private ValueAnimator f;
    private Float g;

    public AnimateImageView(Context context) {
        this(context, null, 0);
    }

    public AnimateImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AnimateImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void a(Drawable drawable, boolean z) {
        if (this.a != drawable && getWidth() > 0) {
            if (this.c != null && this.c.isRunning()) {
                this.c.cancel();
            }
            this.b = this.a;
            this.e = (float) (z ? -getWidth() : getWidth());
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) r0, 0.0f});
            ofFloat.setDuration(300);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.addUpdateListener(new ae(this));
            int height = z ? getHeight() : -getHeight();
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, (float) height});
            ofFloat2.setDuration(300);
            ofFloat2.setInterpolator(new DecelerateInterpolator());
            ofFloat2.addUpdateListener(new ab(this));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofFloat2, ofFloat});
            this.c = animatorSet;
            animatorSet.start();
        }
        setImageDrawable(drawable);
    }

    public void setImageDrawableWithClipAnimation(Drawable drawable) {
        setImageDrawable(drawable);
        if (!a()) {
            if (this.f == null) {
                this.f = ValueAnimator.ofFloat(new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE});
                this.f.setDuration(500);
                this.f.setInterpolator(new b());
                this.f.addUpdateListener(new p(this));
            }
            this.f.start();
        }
    }

    private boolean a() {
        return this.f != null && this.f.isRunning();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.a = drawable;
    }

    public void draw(Canvas canvas) {
        int i;
        if (this.c == null || !this.c.isRunning()) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            if (this.b != null) {
                canvas.save();
                canvas.translate(this.d, 0.0f);
                this.b.draw(canvas);
                canvas.restore();
            }
            canvas.save();
            canvas.translate(this.e, 0.0f);
            super.draw(canvas);
            canvas.restore();
        } else if (a()) {
            i = (int) (((float) getWidth()) * this.g.floatValue());
            int height = getHeight();
            canvas.save();
            canvas.clipRect(0, 0, i, height);
            super.draw(canvas);
            canvas.restore();
        } else {
            super.draw(canvas);
        }
    }
}
