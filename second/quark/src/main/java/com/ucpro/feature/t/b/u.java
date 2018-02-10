package com.ucpro.feature.t.b;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.LinearInterpolator;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.base.system.b;

/* compiled from: ProGuard */
public final class u {
    boolean a = false;
    VelocityTracker b = VelocityTracker.obtain();
    View c;
    h d;
    float e;
    float f;
    float g;
    int h = 1;
    int i = 150;
    boolean j;
    LinearInterpolator k = new LinearInterpolator();
    s l = null;
    private float m;
    private float n = 0.0f;
    private int o = 75;
    private final int p = 250;

    public u(Context context, h hVar, s sVar) {
        this.m = (float) ViewConfiguration.get(context).getScaledPagingTouchSlop();
        this.d = hVar;
        this.g = b.a.a();
        this.l = sVar;
    }

    public final boolean a(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.a = false;
                this.c = this.d.a(motionEvent);
                this.b.clear();
                if (this.c == null) {
                    this.j = false;
                    break;
                }
                this.b.addMovement(motionEvent);
                this.e = this.h == 0 ? motionEvent.getX() : motionEvent.getY();
                this.f = this.h == 0 ? this.c.getTranslationX() : this.c.getTranslationY();
                this.j = true;
                break;
            case 1:
            case 3:
                this.a = false;
                this.c = null;
                this.l.requestDisallowInterceptTouchEvent(false);
                break;
            case 2:
                if (this.c != null) {
                    this.b.addMovement(motionEvent);
                    if (Math.abs((this.h == 0 ? motionEvent.getX() : motionEvent.getY()) - this.e) > this.m) {
                        this.a = true;
                        this.l.requestDisallowInterceptTouchEvent(true);
                        this.l.invalidate();
                        break;
                    }
                }
                break;
        }
        return this.a;
    }

    static float a(View view) {
        return ((float) view.getMeasuredHeight()) * 1.5f;
    }

    final float b(View view) {
        float a = a(view);
        float f = 0.65f * a;
        float translationX = (this.h == 0 ? view.getTranslationX() : view.getTranslationY()) - this.f;
        if (translationX >= a * 0.15f) {
            translationX = IPictureView.DEFAULT_MIN_SCALE - ((translationX - (a * 0.15f)) / f);
        } else {
            translationX = translationX < 0.85f * a ? ((translationX + (a * 0.15f)) / f) + IPictureView.DEFAULT_MIN_SCALE : IPictureView.DEFAULT_MIN_SCALE;
        }
        return Math.max(this.n, Math.max(Math.min(translationX, IPictureView.DEFAULT_MIN_SCALE), 0.0f));
    }

    final float c(View view) {
        return this.h == 0 ? view.getTranslationX() : view.getTranslationY();
    }

    final ObjectAnimator a(View view, float f) {
        return ObjectAnimator.ofFloat(view, this.h == 0 ? View.TRANSLATION_X : View.TRANSLATION_Y, new float[]{f});
    }
}
