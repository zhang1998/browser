package com.uc.imagecodec.export;

import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: ProGuard */
public interface ImageDecodeListener {
    void onDecodeFailed();

    void onDecodeFinished(ImageDrawable imageDrawable);

    void onDecodeStarted();
}
