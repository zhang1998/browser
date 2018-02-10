package com.uc.webview.browser.interfaces;

import android.graphics.Bitmap;
import android.webkit.ValueCallback;
import com.uc.webview.export.annotations.Interface;

@Interface
/* compiled from: ProGuard */
public interface ImageViewer {

    @Interface
    /* compiled from: ProGuard */
    public interface ImageCountListener {
        void onImageCountReached(String str, int i);
    }

    @Interface
    /* compiled from: ProGuard */
    public interface ImageInfoListener {
        public static final int PICTURE_STATUS_LOADED = 1;
        public static final int PICTURE_STATUS_LOADING = 0;
        public static final int PICTURE_STATUS_LOAD_ERROR = 2;

        void onFocusImageUpdated(String str);

        void onImageAdded(String str, String str2, int i, int i2, int i3);

        void onImageDeleted(String str);

        void onImageUpdated(String str, int i);
    }

    @Interface
    /* compiled from: ProGuard */
    public interface ImageViewerListener {
        @Deprecated
        void onEnterImageMode();

        @Deprecated
        void onReportGuidableImageCount(int i, String str);

        @Deprecated
        void onRequestAnimationImageByUrl(byte[] bArr, String str, int i);

        void onRequestImageByUrl(Bitmap bitmap, String str, int i);

        @Deprecated
        void onShowRequestAnimationImage(byte[] bArr, String str, int i, int i2);

        void onShowRequestImage(Bitmap bitmap, String str, int i, int i2);
    }

    void notifyEnterFakeImageMode();

    void notifyExitImageMode();

    void requestImageByUrl(String str);

    void requestImageByUrl(String str, int i);

    void requestShowNextImage(boolean z);

    void requestShowPreviousImage();

    void saveAllImage(String str, ValueCallback<Integer> valueCallback);

    void setImageCountListener(ImageCountListener imageCountListener, int i, int i2, int i3);

    void setImageInfoListener(ImageInfoListener imageInfoListener, int i, int i2);

    void setListener(ImageViewerListener imageViewerListener);
}
