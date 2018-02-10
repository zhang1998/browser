package com.ucpro.feature.privacymode.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.alibaba.wireless.security.SecExceptionCode;
import com.quark.browser.R;
import com.ucpro.d;

/* compiled from: ProGuard */
public class CircleProgressBar extends View {
    private float a = 0.0f;
    private float b = getResources().getDimension(R.dimen.default_stroke_width);
    private float c = getResources().getDimension(R.dimen.default_background_stroke_width);
    private int d = -16777216;
    private int e = -7829368;
    private int f = -90;
    private RectF g = new RectF();
    private Paint h;
    private Paint i;

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, d.CircleProgressBar, 0, 0);
        try {
            this.a = obtainStyledAttributes.getFloat(0, this.a);
            this.b = obtainStyledAttributes.getDimension(3, this.b);
            this.c = obtainStyledAttributes.getDimension(4, this.c);
            this.d = obtainStyledAttributes.getInt(1, this.d);
            this.e = obtainStyledAttributes.getInt(2, this.e);
            this.h = new Paint(1);
            this.h.setColor(this.e);
            this.h.setStyle(Style.STROKE);
            this.h.setStrokeWidth(this.c);
            this.i = new Paint(1);
            this.i.setColor(this.d);
            this.i.setStyle(Style.STROKE);
            this.i.setStrokeWidth(this.b);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawOval(this.g, this.h);
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.g, (float) this.f, (360.0f * this.a) / 100.0f, false, this.i);
    }

    protected void onMeasure(int i, int i2) {
        int min = Math.min(getDefaultSize(getSuggestedMinimumWidth(), i), getDefaultSize(getSuggestedMinimumHeight(), i2));
        setMeasuredDimension(min, min);
        float f = this.b > this.c ? this.b : this.c;
        this.g.set((f / 2.0f) + 0.0f, (f / 2.0f) + 0.0f, ((float) min) - (f / 2.0f), ((float) min) - (f / 2.0f));
    }

    public float getProgress() {
        return this.a;
    }

    public void setProgress(float f) {
        if (f > 100.0f) {
            f = 100.0f;
        }
        this.a = f;
        invalidate();
    }

    public float getProgressBarWidth() {
        return this.b;
    }

    public void setProgressBarWidth(float f) {
        this.b = f;
        this.i.setStrokeWidth(f);
        requestLayout();
        invalidate();
    }

    public float getBackgroundProgressBarWidth() {
        return this.c;
    }

    public void setBackgroundProgressBarWidth(float f) {
        this.c = f;
        this.h.setStrokeWidth(f);
        requestLayout();
        invalidate();
    }

    public int getColor() {
        return this.d;
    }

    public void setColor(int i) {
        this.d = i;
        this.i.setColor(i);
        invalidate();
        requestLayout();
    }

    public int getBackgroundColor() {
        return this.e;
    }

    public void setBackgroundColor(int i) {
        this.e = i;
        this.h.setColor(i);
        invalidate();
        requestLayout();
    }

    public void setProgressWithAnimation(float f) {
        a(f, SecExceptionCode.SEC_ERROR_SIMULATORDETECT);
    }

    public final void a(float f, int i) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "progress", new float[]{f});
        ofFloat.setDuration((long) i);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.start();
    }
}
