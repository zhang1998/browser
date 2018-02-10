package com.uc.imagecodec.export;

import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: ProGuard */
public abstract class ImageDrawable extends Drawable {
    public static final int DOWN_SAMPLING_LIMIT_SIZE = 1600;
    public Bitmap mBuffer;
    protected Config mConfig = new Config();
    public final Rect mDstRect = new Rect();
    public ImageDecodeListener mListener = null;
    public final Paint mPaint = new Paint(6);
    public int mScaledHeight;
    public int mScaledWidth;
    public Rect mSrcRect = new Rect();

    @Api
    /* compiled from: ProGuard */
    public class Config {
        public int downSamplingLimitSize = 1600;
        public boolean enableDownSampling = true;
        public int specifiedHeight = 0;
        public int specifiedWidth = 0;
        public boolean supportAnimation = true;
    }

    public void setConfig(Config config) {
        if (config != null) {
            this.mConfig.supportAnimation = config.supportAnimation;
            this.mConfig.enableDownSampling = config.enableDownSampling;
            if (this.mConfig.enableDownSampling) {
                this.mConfig.specifiedWidth = config.specifiedWidth;
                this.mConfig.specifiedHeight = config.specifiedHeight;
                this.mConfig.downSamplingLimitSize = config.downSamplingLimitSize;
            }
        }
    }

    public Bitmap getBitmap() {
        if (isRecycled()) {
            return null;
        }
        return this.mBuffer;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBuffer = bitmap;
    }

    public int imageType() {
        return 0;
    }

    public int getAlpha() {
        return this.mPaint.getAlpha();
    }

    public void setFilterBitmap(boolean z) {
        this.mPaint.setFilterBitmap(z);
        invalidateSelf();
    }

    @Deprecated
    public void setDither(boolean z) {
        this.mPaint.setDither(z);
        invalidateSelf();
    }

    public int getIntrinsicHeight() {
        return this.mScaledHeight;
    }

    public int getIntrinsicWidth() {
        return this.mScaledWidth;
    }

    public int setIntrinsicHeight(int i) {
        this.mScaledHeight = i;
        return i;
    }

    public int setIntrinsicWidth(int i) {
        this.mScaledWidth = i;
        return i;
    }

    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    protected void onBoundsChange(Rect rect) {
        this.mDstRect.set(rect);
    }

    public void setSrcRect(Rect rect) {
        if (rect != null && !rect.isEmpty()) {
            this.mSrcRect = rect;
        }
    }

    public boolean isRecycled() {
        return false;
    }

    public void recycle() {
        this.mBuffer.recycle();
    }

    public void notifyDecodeFinished() {
    }

    public void renderFrame(Bitmap bitmap) {
    }

    public boolean hasDecodeListener() {
        return this.mListener != null;
    }

    public boolean hasAnimation() {
        return false;
    }

    @Deprecated
    public boolean hasAnimaton() {
        return hasAnimation();
    }

    public int getNumberOfFrames() {
        return 1;
    }

    public void setAnimationListener(AnimationListener animationListener) {
    }

    public void start() {
    }

    public void stop() {
    }

    public int getSpecifiedWidth() {
        return this.mConfig.specifiedWidth;
    }

    public int getSpecifiedHeight() {
        return this.mConfig.specifiedHeight;
    }

    public int getDownSamplingLimitSize() {
        return this.mConfig.downSamplingLimitSize;
    }

    public boolean supportAnimation() {
        return this.mConfig.supportAnimation;
    }
}
