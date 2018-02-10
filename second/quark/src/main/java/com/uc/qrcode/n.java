package com.uc.qrcode;

import android.graphics.Bitmap;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

/* compiled from: ProGuard */
public final class n {
    Result a;
    Bitmap b;
    public m c;

    static Result a(Bitmap bitmap) {
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        Map enumMap = new EnumMap(DecodeHintType.class);
        Collection noneOf = EnumSet.noneOf(BarcodeFormat.class);
        noneOf.addAll(g.a);
        noneOf.addAll(g.b);
        noneOf.addAll(g.d);
        noneOf.addAll(g.e);
        noneOf.addAll(g.f);
        noneOf.addAll(g.g);
        enumMap.put(DecodeHintType.POSSIBLE_FORMATS, noneOf);
        multiFormatReader.setHints(enumMap);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[(width * height)];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        byte[] bArr = new byte[((width * height) * 2)];
        a(bArr, iArr, width, height);
        Result decodeWithState;
        try {
            decodeWithState = multiFormatReader.decodeWithState(new BinaryBitmap(new HybridBinarizer(new PlanarYUVLuminanceSource(bArr, width, height, 0, 0, width, height, true))));
            return decodeWithState;
        } catch (Exception e) {
            decodeWithState = e;
            return null;
        } finally {
            bitmap.recycle();
        }
    }

    private static void a(byte[] bArr, int[] iArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i6 < i2) {
            int i7 = 0;
            int i8 = i5;
            while (i7 < i) {
                i5 = (iArr[i8] & 16711680) >> 16;
                int i9 = (iArr[i8] & 65280) >> 8;
                int i10 = (iArr[i8] & 255) >> 0;
                int i11 = (((((i5 * 66) + (i9 * 129)) + (i10 * 25)) + 128) >> 8) + 16;
                int i12 = (((((i5 * -38) - (i9 * 74)) + (i10 * SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED)) + 128) >> 8) + 128;
                i9 = (((((i5 * SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED) - (i9 * 94)) - (i10 * 18)) + 128) >> 8) + 128;
                if (i4 < bArr.length) {
                    i5 = i4 + 1;
                    if (i11 < 0) {
                        i11 = 0;
                    } else if (i11 > 255) {
                        i11 = 255;
                    }
                    bArr[i4] = (byte) i11;
                    i11 = i5;
                } else {
                    i11 = i4;
                }
                if (i6 % 2 == 0 && i8 % 2 == 0) {
                    if (i3 < bArr.length - 1) {
                        i4 = i3 + 1;
                        i5 = i9 < 0 ? 0 : i9 > 255 ? 255 : i9;
                        bArr[i3] = (byte) i5;
                        i5 = i4;
                    } else {
                        i5 = i3;
                    }
                    if (i5 < bArr.length) {
                        i3 = i5 + 1;
                        i4 = i12 < 0 ? 0 : i12 > 255 ? 255 : i12;
                        bArr[i5] = (byte) i4;
                    } else {
                        i3 = i5;
                    }
                }
                i7++;
                i8++;
                i4 = i11;
            }
            i6++;
            i5 = i8;
        }
    }
}
