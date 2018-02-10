package com.uc.imagecodec.export;

import android.graphics.Bitmap;
import com.uc.imagecodec.export.ImageDrawable.Config;
import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: ProGuard */
public interface IImageDecoder {
    ImageDrawable createDrawable(ImageDecodeListener imageDecodeListener);

    Bitmap decodeBitmap();

    String getError();

    IImageDecoder setConfig(Config config);
}
