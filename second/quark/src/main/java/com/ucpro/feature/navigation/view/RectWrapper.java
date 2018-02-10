package com.ucpro.feature.navigation.view;

import android.graphics.Rect;

/* compiled from: ProGuard */
public class RectWrapper {
    public static final String SCALE = "scale";
    public static final int SCALE_TYPE_CENTER = 0;
    public static final int SCALE_TYPE_LEFT_TOP = 1;
    private Rect mOriginalRect = new Rect();
    private Rect mRect;
    private float mScale = 0.0f;
    private int mScaleType = 0;

    public RectWrapper(Rect rect) {
        setRect(rect);
    }

    public void setRect(Rect rect) {
        this.mRect = rect;
        this.mOriginalRect.set(this.mRect);
    }

    public void setLeft(int i) {
        if (this.mRect != null) {
            this.mRect.offsetTo(i, this.mRect.top);
        }
    }

    public void setTop(int i) {
        if (this.mRect != null) {
            this.mRect.offsetTo(this.mRect.left, i);
        }
    }

    public float getScale() {
        return this.mScale;
    }

    public void setScale(float f) {
        this.mScale = f;
        if (this.mRect != null) {
            int width = this.mOriginalRect.width();
            int height = this.mOriginalRect.height();
            int round = Math.round(((float) width) * f);
            int round2 = Math.round(((float) height) * f);
            int i = this.mOriginalRect.left;
            int i2 = this.mOriginalRect.top;
            int i3 = this.mOriginalRect.right;
            int i4 = this.mOriginalRect.bottom;
            switch (this.mScaleType) {
                case 0:
                    i = this.mOriginalRect.left - ((round - width) / 2);
                    i2 = this.mOriginalRect.top - ((round2 - height) / 2);
                    break;
                case 1:
                    break;
                default:
                    int i5 = i4;
                    i4 = i2;
                    i2 = i5;
                    int i6 = i3;
                    i3 = i;
                    i = i6;
                    break;
            }
            i4 = i2;
            i2 += round2;
            i3 = i;
            i += round;
            this.mRect.set(i3, i4, i, i2);
        }
    }

    public void setScaleType(int i) {
        this.mScaleType = i;
    }
}
