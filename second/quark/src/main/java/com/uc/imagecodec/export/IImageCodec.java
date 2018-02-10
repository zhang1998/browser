package com.uc.imagecodec.export;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: ProGuard */
public interface IImageCodec {
    Bitmap createBitmap(int i, int i2, Config config);

    int getImageType(byte[] bArr);

    boolean isSupportType(String str);

    IImageDecoder load(String str);

    IImageDecoder load(byte[] bArr);

    IImageCodec setExternalLibPath(String str);

    void setListener(ImageDecodeStatListener imageDecodeStatListener);

    void testApi();
}
