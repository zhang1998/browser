package com.uc.imagecodec.export;

import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: ProGuard */
public interface ImageDecodeStatListener {
    void onNotifyDecodeResult(boolean z, int i);

    void onNotifyDecodeTime(long j, int i, int i2, int i3);
}
