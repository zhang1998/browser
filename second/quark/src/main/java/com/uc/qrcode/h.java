package com.uc.qrcode;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.ReaderException;
import com.google.zxing.common.HybridBinarizer;
import com.uc.qrcode.c.a;
import java.util.Map;

/* compiled from: ProGuard */
final class h extends Handler {
    private static final String a = h.class.getSimpleName();
    private final a b;
    private final MultiFormatReader c = new MultiFormatReader();
    private boolean d = true;

    h(a aVar, Map<DecodeHintType, Object> map) {
        this.c.setHints(map);
        this.b = aVar;
    }

    public final void handleMessage(Message message) {
        if (this.d) {
            switch (message.what) {
                case 21:
                    Object decodeWithState;
                    byte[] bArr = (byte[]) message.obj;
                    int i = message.arg1;
                    int i2 = message.arg2;
                    long currentTimeMillis = System.currentTimeMillis();
                    Handler scanHandler = this.b.getScanHandler();
                    try {
                        LuminanceSource a = this.b.a(bArr, i);
                        if (a != null) {
                            decodeWithState = this.c.decodeWithState(new BinaryBitmap(new HybridBinarizer(a)));
                            this.c.reset();
                        } else {
                            decodeWithState = null;
                        }
                    } catch (ReaderException e) {
                        this.c.reset();
                        decodeWithState = null;
                    } catch (ArrayIndexOutOfBoundsException e2) {
                        if (scanHandler != null) {
                            Message.obtain(scanHandler, 19).sendToTarget();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        this.c.reset();
                    }
                    if (decodeWithState != null) {
                        new StringBuilder("Found barcode in ").append(System.currentTimeMillis() - currentTimeMillis).append(" ms");
                        if (scanHandler != null) {
                            Message.obtain(scanHandler, 18, decodeWithState).sendToTarget();
                            return;
                        }
                        return;
                    } else if (scanHandler != null) {
                        Message.obtain(scanHandler, 19).sendToTarget();
                        return;
                    } else {
                        return;
                    }
                case 22:
                    this.d = false;
                    Looper.myLooper().quit();
                    return;
                default:
                    return;
            }
        }
    }
}
