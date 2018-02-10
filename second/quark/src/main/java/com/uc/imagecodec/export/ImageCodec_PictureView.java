package com.uc.imagecodec.export;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: ProGuard */
public abstract class ImageCodec_PictureView extends ImageView implements IPictureView {

    @Api
    /* compiled from: ProGuard */
    public class Config {
        public boolean canZoom = true;
        public int downSamplingLimitSize = 1600;
        public boolean enableDownSampling = true;
        public ScaleType scaleType = ScaleType.CENTER;
        public int specifiedHeight = 0;
        public int specifiedWidth = 0;
        public boolean supportAnimation = true;
    }

    public ImageCodec_PictureView(Context context) {
        super(context);
    }

    public void setImageData(byte[] bArr, ImageDecodeListener imageDecodeListener) {
    }

    public ImageDrawable getDrawable() {
        return null;
    }

    public void setBitmap(Bitmap bitmap) {
    }

    public Bitmap getBitmap() {
        return null;
    }

    public boolean isReachLeftEdge() {
        return true;
    }

    public boolean isReachTopEdge() {
        return true;
    }

    public void setPhotoViewRotation(float f) {
    }

    public void setRotationTo(float f) {
    }

    public void setRotationBy(float f) {
    }

    public boolean canZoom() {
        return false;
    }

    public RectF getDisplayRect() {
        return new RectF();
    }

    public Matrix getDisplayMatrix() {
        return new Matrix();
    }

    public boolean setDisplayMatrix(Matrix matrix) {
        return false;
    }

    public float getMinScale() {
        return IPictureView.DEFAULT_MIN_SCALE;
    }

    public float getMinimumScale() {
        return IPictureView.DEFAULT_MIN_SCALE;
    }

    public float getMidScale() {
        return IPictureView.DEFAULT_MIN_SCALE;
    }

    public float getMediumScale() {
        return IPictureView.DEFAULT_MIN_SCALE;
    }

    public float getMaxScale() {
        return IPictureView.DEFAULT_MIN_SCALE;
    }

    public float getMaximumScale() {
        return IPictureView.DEFAULT_MIN_SCALE;
    }

    public float getScale() {
        return IPictureView.DEFAULT_MIN_SCALE;
    }

    public ScaleType getScaleType() {
        return ScaleType.CENTER;
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
    }

    public void setMinScale(float f) {
    }

    public void setMinimumScale(float f) {
    }

    public void setMidScale(float f) {
    }

    public void setMediumScale(float f) {
    }

    public void setMaxScale(float f) {
    }

    public void setMaximumScale(float f) {
    }

    public void setOnMatrixChangeListener(ImageCodecView_OnMatrixChangedListener imageCodecView_OnMatrixChangedListener) {
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
    }

    public void setOnScaleChangedListener(ImageCodecView_OnScaleChangedListener imageCodecView_OnScaleChangedListener) {
    }

    public void setOnPhotoTapListener(ImageCodecView_OnPhotoTapListener imageCodecView_OnPhotoTapListener) {
    }

    public ImageCodecView_OnPhotoTapListener getOnPhotoTapListener() {
        return null;
    }

    public void setOnViewTapListener(ImageCodecView_OnViewTapListener imageCodecView_OnViewTapListener) {
    }

    public ImageCodecView_OnViewTapListener getOnViewTapListener() {
        return null;
    }

    public void setScale(float f) {
    }

    public void setScale(float f, boolean z) {
    }

    public void setScale(float f, float f2, float f3, boolean z) {
    }

    public void setImageScaleType(ScaleType scaleType) {
    }

    public void setZoomable(boolean z) {
    }

    public Bitmap getVisibleRectangleBitmap() {
        return null;
    }

    public void setZoomTransitionDuration(int i) {
    }

    public IPictureView getIPhotoViewImplementation() {
        return null;
    }

    public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
    }

    public void onDetachedFromWindow() {
    }

    public void update() {
    }

    public void startSensor() {
    }

    public void stopSensor() {
    }

    public void setInitScale(float f, float f2, float f3) {
    }
}
