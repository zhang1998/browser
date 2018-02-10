package com.uc.qrcode;

import android.os.Handler;
import android.os.Looper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ResultPointCallback;
import com.uc.qrcode.c.a;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* compiled from: ProGuard */
final class i extends Thread {
    private final a a;
    private final Map<DecodeHintType, Object> b = new EnumMap(DecodeHintType.class);
    private Handler c;
    private final CountDownLatch d = new CountDownLatch(1);

    i(a aVar, Collection<BarcodeFormat> collection, Map<DecodeHintType, ?> map, String str, ResultPointCallback resultPointCallback) {
        this.a = aVar;
        if (map != null) {
            this.b.putAll(map);
        }
        if (collection == null || collection.isEmpty()) {
            collection = EnumSet.noneOf(BarcodeFormat.class);
            if (com.uc.qrcode.b.a.KEY_DECODE_1D_PRODUCT.r) {
                collection.addAll(g.a);
            }
            if (com.uc.qrcode.b.a.KEY_DECODE_1D_INDUSTRIAL.r) {
                collection.addAll(g.b);
            }
            if (com.uc.qrcode.b.a.KEY_DECODE_QR.r) {
                collection.addAll(g.d);
            }
            if (com.uc.qrcode.b.a.KEY_DECODE_DATA_MATRIX.r) {
                collection.addAll(g.e);
            }
            if (com.uc.qrcode.b.a.KEY_DECODE_AZTEC.r) {
                collection.addAll(g.f);
            }
            if (com.uc.qrcode.b.a.KEY_DECODE_PDF417.r) {
                collection.addAll(g.g);
            }
        }
        this.b.put(DecodeHintType.POSSIBLE_FORMATS, collection);
        if (str != null) {
            this.b.put(DecodeHintType.CHARACTER_SET, str);
        }
        this.b.put(DecodeHintType.NEED_RESULT_POINT_CALLBACK, resultPointCallback);
        new StringBuilder("Hints: ").append(this.b);
    }

    final Handler a() {
        try {
            this.d.await();
        } catch (InterruptedException e) {
        }
        return this.c;
    }

    public final void run() {
        Looper.prepare();
        this.c = new h(this.a, this.b);
        this.d.countDown();
        Looper.loop();
    }
}
