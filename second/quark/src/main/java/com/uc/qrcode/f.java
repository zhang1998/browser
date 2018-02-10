package com.uc.qrcode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.Result;
import com.uc.imagecodec.export.IPictureView;
import com.uc.qrcode.a.c;
import com.uc.qrcode.c.a;
import com.ucweb.common.util.h.m;
import java.util.Collection;
import java.util.Map;

/* compiled from: ProGuard */
public final class f extends Handler {
    private static final String d = f.class.getSimpleName();
    final i a;
    int b = e.b;
    final c c;
    private final a e;

    f(a aVar, Collection<BarcodeFormat> collection, Map<DecodeHintType, ?> map, String str, c cVar) {
        this.e = aVar;
        this.a = new i(aVar, collection, map, str, new u((ViewfinderView) this.e.getViewfinderView()));
        this.a.start();
        this.c = cVar;
        m.a(0, new c(this), new d(this));
    }

    public final void handleMessage(Message message) {
        Options options = null;
        switch (message.what) {
            case 17:
                a();
                return;
            case 18:
                Bitmap bitmap;
                this.b = e.b;
                Bundle data = message.getData();
                float f = IPictureView.DEFAULT_MIN_SCALE;
                if (data != null) {
                    byte[] byteArray = data.getByteArray("barcode_bitmap");
                    if (byteArray != null) {
                        options = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, null).copy(Config.ARGB_8888, true);
                    }
                    f = data.getFloat("barcode_scaled_factor");
                    bitmap = options;
                } else {
                    bitmap = null;
                }
                this.e.a((Result) message.obj, bitmap, f);
                return;
            case 19:
                this.b = e.a;
                this.c.a(this.a.a());
                return;
            case 23:
                if (this.b == e.a) {
                    this.c.b(this);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void a() {
        if (this.b == e.b) {
            this.b = e.a;
            this.c.b(this);
            this.c.a(this.a.a());
            this.e.a();
        }
    }
}
