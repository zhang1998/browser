package com.ucpro.ui.widget.ripple;

import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.animation.LinearInterpolator;

/* compiled from: ProGuard */
class Ripple {
    private static final TimeInterpolator DECEL_INTERPOLATOR = new j();
    private static final float GLOBAL_SPEED = 1.0f;
    private static final TimeInterpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final int MAX_OPACITY_DURATION = 300;
    private static final int MAX_RADIUS_DURATION = 355;
    private static final long RIPPLE_ENTER_DELAY = 80;
    private static final float WAVE_OPACITY_DECAY_VELOCITY = 3.0f;
    private static final float WAVE_TOUCH_DOWN_ACCELERATION = 1024.0f;
    private static final float WAVE_TOUCH_UP_ACCELERATION = 3400.0f;
    private ObjectAnimator mAnimOpacity;
    private ObjectAnimator mAnimRadius;
    private ObjectAnimator mAnimX;
    private ObjectAnimator mAnimY;
    private final AnimatorListenerAdapter mAnimationListener = new b(this);
    private final Rect mBounds;
    private boolean mCanceled;
    private float mClampedStartingX;
    private float mClampedStartingY;
    private float mDensity;
    private boolean mHasMaxRadius;
    private float mOpacity = 1.0f;
    private float mOuterRadius;
    private float mOuterX;
    private float mOuterY;
    private final h mOwner;
    private float mStartingX;
    private float mStartingY;
    private Paint mTempPaint;
    private float mTweenRadius = 0.0f;
    private float mTweenX = 0.0f;
    private float mTweenY = 0.0f;

    public Ripple(h hVar, Rect rect, float f, float f2) {
        this.mOwner = hVar;
        this.mBounds = rect;
        this.mStartingX = f;
        this.mStartingY = f2;
    }

    public void setup(int i, float f) {
        if (i != -1) {
            this.mHasMaxRadius = true;
            this.mOuterRadius = (float) i;
        } else {
            float width = ((float) this.mBounds.width()) / 2.0f;
            float height = ((float) this.mBounds.height()) / 2.0f;
            this.mOuterRadius = (float) Math.sqrt((double) ((width * width) + (height * height)));
        }
        this.mOuterX = 0.0f;
        this.mOuterY = 0.0f;
        this.mDensity = f;
        clampStartingPosition();
    }

    private void clampStartingPosition() {
        float exactCenterX = this.mBounds.exactCenterX();
        float exactCenterY = this.mBounds.exactCenterY();
        float f = this.mStartingX - exactCenterX;
        float f2 = this.mStartingY - exactCenterY;
        float f3 = this.mOuterRadius;
        if ((f * f) + (f2 * f2) > f3 * f3) {
            double atan2 = Math.atan2((double) f2, (double) f);
            this.mClampedStartingX = exactCenterX + ((float) (Math.cos(atan2) * ((double) f3)));
            this.mClampedStartingY = ((float) (Math.sin(atan2) * ((double) f3))) + exactCenterY;
            return;
        }
        this.mClampedStartingX = this.mStartingX;
        this.mClampedStartingY = this.mStartingY;
    }

    public void onHotspotBoundsChanged() {
        if (!this.mHasMaxRadius) {
            float width = ((float) this.mBounds.width()) / 2.0f;
            float height = ((float) this.mBounds.height()) / 2.0f;
            this.mOuterRadius = (float) Math.sqrt((double) ((width * width) + (height * height)));
            clampStartingPosition();
        }
    }

    public void setOpacity(float f) {
        this.mOpacity = f;
        invalidateSelf();
    }

    public float getOpacity() {
        return this.mOpacity;
    }

    public void setRadiusGravity(float f) {
        this.mTweenRadius = f;
        invalidateSelf();
    }

    public float getRadiusGravity() {
        return this.mTweenRadius;
    }

    public void setXGravity(float f) {
        this.mTweenX = f;
        invalidateSelf();
    }

    public float getXGravity() {
        return this.mTweenX;
    }

    public void setYGravity(float f) {
        this.mTweenY = f;
        invalidateSelf();
    }

    public float getYGravity() {
        return this.mTweenY;
    }

    public boolean draw(Canvas canvas, Paint paint) {
        int alpha = paint.getAlpha();
        int i = (int) ((((float) alpha) * this.mOpacity) + 0.5f);
        float a = a.a(0.0f, this.mOuterRadius, this.mTweenRadius);
        if (i <= 0 || a <= 0.0f) {
            return false;
        }
        float a2 = a.a(this.mClampedStartingX - this.mBounds.exactCenterX(), this.mOuterX, this.mTweenX);
        float a3 = a.a(this.mClampedStartingY - this.mBounds.exactCenterY(), this.mOuterY, this.mTweenY);
        paint.setAlpha(i);
        canvas.drawCircle(a2, a3, a, paint);
        paint.setAlpha(alpha);
        return true;
    }

    public void getBounds(Rect rect) {
        int i = (int) this.mOuterX;
        int i2 = (int) this.mOuterY;
        int i3 = ((int) this.mOuterRadius) + 1;
        rect.set(i - i3, i2 - i3, i + i3, i2 + i3);
    }

    public void move(float f, float f2) {
        this.mStartingX = f;
        this.mStartingY = f2;
        clampStartingPosition();
    }

    public void enter() {
        cancel();
        int sqrt = (int) ((1000.0d * Math.sqrt((double) ((this.mOuterRadius / WAVE_TOUCH_DOWN_ACCELERATION) * this.mDensity))) + 0.5d);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "radiusGravity", new float[]{1.0f});
        ofFloat.setDuration((long) sqrt);
        ofFloat.setInterpolator(LINEAR_INTERPOLATOR);
        ofFloat.setStartDelay(RIPPLE_ENTER_DELAY);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "xGravity", new float[]{1.0f});
        ofFloat2.setDuration((long) sqrt);
        ofFloat2.setInterpolator(LINEAR_INTERPOLATOR);
        ofFloat2.setStartDelay(RIPPLE_ENTER_DELAY);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, "yGravity", new float[]{1.0f});
        ofFloat3.setDuration((long) sqrt);
        ofFloat3.setInterpolator(LINEAR_INTERPOLATOR);
        ofFloat3.setStartDelay(RIPPLE_ENTER_DELAY);
        this.mAnimRadius = ofFloat;
        this.mAnimX = ofFloat2;
        this.mAnimY = ofFloat3;
        ofFloat.start();
        ofFloat2.start();
        ofFloat3.start();
        k.a(ofFloat);
        k.a(ofFloat2);
        k.a(ofFloat3);
    }

    public void exit() {
        float a = a.a(0.0f, this.mOuterRadius, this.mTweenRadius);
        if (this.mAnimRadius == null || !this.mAnimRadius.isRunning()) {
            a = this.mOuterRadius;
        } else {
            a = this.mOuterRadius - a;
        }
        cancel();
        exitSoftware(Math.min(MAX_RADIUS_DURATION, (int) ((Math.sqrt((double) ((a / 4424.0f) * this.mDensity)) * 1000.0d) + 0.5d)), Math.min(300, (int) (((1000.0f * this.mOpacity) / 3.0f) + 0.5f)));
    }

    public void jump() {
        this.mCanceled = true;
        endSoftwareAnimations();
        this.mCanceled = false;
    }

    private void endSoftwareAnimations() {
        if (this.mAnimRadius != null) {
            this.mAnimRadius.end();
            this.mAnimRadius = null;
        }
        if (this.mAnimOpacity != null) {
            this.mAnimOpacity.end();
            this.mAnimOpacity = null;
        }
        if (this.mAnimX != null) {
            this.mAnimX.end();
            this.mAnimX = null;
        }
        if (this.mAnimY != null) {
            this.mAnimY.end();
            this.mAnimY = null;
        }
    }

    private Paint getTempPaint(Paint paint) {
        if (this.mTempPaint == null) {
            this.mTempPaint = new Paint();
        }
        this.mTempPaint.set(paint);
        return this.mTempPaint;
    }

    private void exitSoftware(int i, int i2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "radiusGravity", new float[]{1.0f});
        ofFloat.setDuration((long) i);
        ofFloat.setInterpolator(DECEL_INTERPOLATOR);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "xGravity", new float[]{1.0f});
        ofFloat2.setDuration((long) i);
        ofFloat2.setInterpolator(DECEL_INTERPOLATOR);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, "yGravity", new float[]{1.0f});
        ofFloat3.setDuration((long) i);
        ofFloat3.setInterpolator(DECEL_INTERPOLATOR);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this, "opacity", new float[]{0.0f});
        ofFloat4.setDuration((long) i2);
        ofFloat4.setInterpolator(LINEAR_INTERPOLATOR);
        ofFloat4.addListener(this.mAnimationListener);
        this.mAnimRadius = ofFloat;
        this.mAnimOpacity = ofFloat4;
        this.mAnimX = ofFloat2;
        this.mAnimY = ofFloat3;
        k.a(ofFloat);
        k.a(ofFloat4);
        k.a(ofFloat2);
        k.a(ofFloat3);
    }

    public void cancel() {
        this.mCanceled = true;
        cancelSoftwareAnimations();
        this.mCanceled = false;
    }

    private void cancelSoftwareAnimations() {
        if (this.mAnimRadius != null) {
            this.mAnimRadius.cancel();
            this.mAnimRadius = null;
        }
        if (this.mAnimOpacity != null) {
            this.mAnimOpacity.cancel();
            this.mAnimOpacity = null;
        }
        if (this.mAnimX != null) {
            this.mAnimX.cancel();
            this.mAnimX = null;
        }
        if (this.mAnimY != null) {
            this.mAnimY.cancel();
            this.mAnimY = null;
        }
    }

    private void removeSelf() {
        if (!this.mCanceled) {
            h hVar = this.mOwner;
            Object obj = hVar.c;
            int i = hVar.d;
            Ripple[] rippleArr = hVar.c;
            int i2 = hVar.d;
            int i3 = 0;
            while (i3 < i2) {
                if (rippleArr[i3] == this) {
                    break;
                }
                i3++;
            }
            i3 = -1;
            if (i3 >= 0) {
                System.arraycopy(obj, i3 + 1, obj, i3, i - (i3 + 1));
                obj[i - 1] = null;
                hVar.d--;
                hVar.invalidateSelf();
            }
        }
    }

    private void invalidateSelf() {
        this.mOwner.invalidateSelf();
    }
}
