package com.uc.imagecodec.export;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView.ScaleType;
import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: ProGuard */
public interface IPictureView {
    public static final float DEFAULT_MAX_SCALE = 3.0f;
    public static final float DEFAULT_MID_SCALE = 1.75f;
    public static final float DEFAULT_MIN_SCALE = 1.0f;
    public static final int DEFAULT_ZOOM_DURATION = 200;

    boolean canZoom();

    Matrix getDisplayMatrix();

    RectF getDisplayRect();

    IPictureView getIPhotoViewImplementation();

    @Deprecated
    float getMaxScale();

    float getMaximumScale();

    float getMediumScale();

    @Deprecated
    float getMidScale();

    @Deprecated
    float getMinScale();

    float getMinimumScale();

    ImageCodecView_OnPhotoTapListener getOnPhotoTapListener();

    ImageCodecView_OnViewTapListener getOnViewTapListener();

    float getScale();

    ScaleType getScaleType();

    Bitmap getVisibleRectangleBitmap();

    void setAllowParentInterceptOnEdge(boolean z);

    boolean setDisplayMatrix(Matrix matrix);

    void setImageScaleType(ScaleType scaleType);

    @Deprecated
    void setMaxScale(float f);

    void setMaximumScale(float f);

    void setMediumScale(float f);

    @Deprecated
    void setMidScale(float f);

    @Deprecated
    void setMinScale(float f);

    void setMinimumScale(float f);

    void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener);

    void setOnLongClickListener(OnLongClickListener onLongClickListener);

    void setOnMatrixChangeListener(ImageCodecView_OnMatrixChangedListener imageCodecView_OnMatrixChangedListener);

    void setOnPhotoTapListener(ImageCodecView_OnPhotoTapListener imageCodecView_OnPhotoTapListener);

    void setOnScaleChangedListener(ImageCodecView_OnScaleChangedListener imageCodecView_OnScaleChangedListener);

    void setOnViewTapListener(ImageCodecView_OnViewTapListener imageCodecView_OnViewTapListener);

    void setPhotoViewRotation(float f);

    void setRotationBy(float f);

    void setRotationTo(float f);

    void setScale(float f);

    void setScale(float f, float f2, float f3, boolean z);

    void setScale(float f, boolean z);

    void setZoomTransitionDuration(int i);

    void setZoomable(boolean z);
}
