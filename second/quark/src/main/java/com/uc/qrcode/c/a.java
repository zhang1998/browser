package com.uc.qrcode.c;

import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.Result;

/* compiled from: ProGuard */
public interface a {
    PlanarYUVLuminanceSource a(byte[] bArr, int i);

    void a();

    void a(Result result, Bitmap bitmap, float f);

    Handler getScanHandler();

    View getViewfinderView();
}
