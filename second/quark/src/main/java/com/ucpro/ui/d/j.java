package com.ucpro.ui.d;

import android.graphics.Bitmap;
import com.uc.crashsdk.export.LogType;

/* compiled from: ProGuard */
public final class j {
    private static int a = 0;
    private static int[] b;

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        int i3;
        int i4;
        int[] iArr;
        if (i2 <= 0) {
            i3 = 1;
        } else {
            i3 = i2;
        }
        if (i3 > 3) {
            i3 = 3;
        }
        if (i <= 0) {
            i = 1;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i5 = width - 1;
        int i6 = height - 1;
        int i7 = width * height;
        int i8 = (i + i) + 1;
        int[] iArr2 = new int[i7];
        int[] iArr3 = new int[i7];
        int[] iArr4 = new int[i7];
        int[] iArr5 = new int[Math.max(width, height)];
        int[] iArr6 = new int[Math.max(width, height)];
        int[] iArr7 = new int[(width * height)];
        bitmap.getPixels(iArr7, 0, width, 0, 0, width, height);
        if (a != i) {
            a = i;
            int[] iArr8 = new int[(i8 * LogType.UNEXP)];
            for (i4 = 0; i4 < i8 * LogType.UNEXP; i4++) {
                iArr8[i4] = i4 / i8;
            }
            b = iArr8;
            iArr = iArr8;
            i7 = i3;
        } else {
            iArr = b;
            i7 = i3;
        }
        while (true) {
            int i9 = i7 - 1;
            if (i7 > 0) {
                int i10;
                int i11;
                int i12;
                int i13;
                i7 = 0;
                i3 = 0;
                for (i8 = 0; i8 < height; i8++) {
                    i10 = 0;
                    i11 = 0;
                    i12 = 0;
                    for (i4 = -i; i4 <= i; i4++) {
                        i13 = iArr7[Math.min(i5, Math.max(i4, 0)) + i7];
                        i12 += (16711680 & i13) >> 16;
                        i11 += (65280 & i13) >> 8;
                        i10 += i13 & 255;
                    }
                    for (i4 = 0; i4 < width; i4++) {
                        iArr2[i7] = iArr[i12];
                        iArr3[i7] = iArr[i11];
                        iArr4[i7] = iArr[i10];
                        if (i8 == 0) {
                            iArr5[i4] = Math.min((i4 + i) + 1, i5);
                            iArr6[i4] = Math.max(i4 - i, 0);
                        }
                        i13 = iArr7[iArr5[i4] + i3];
                        int i14 = iArr7[iArr6[i4] + i3];
                        i12 += ((16711680 & i13) - (16711680 & i14)) >> 16;
                        i11 += ((65280 & i13) - (65280 & i14)) >> 8;
                        i10 += (i13 & 255) - (i14 & 255);
                        i7++;
                    }
                    i3 += width;
                }
                for (i4 = 0; i4 < width; i4++) {
                    i11 = 0;
                    i7 = -i;
                    i3 = (-i) * width;
                    i12 = 0;
                    i10 = 0;
                    while (i7 <= i) {
                        i13 = Math.max(0, i3) + i4;
                        i8 = iArr2[i13] + i12;
                        i12 = iArr3[i13] + i11;
                        i7++;
                        i3 += width;
                        i10 = iArr4[i13] + i10;
                        i11 = i12;
                        i12 = i8;
                    }
                    i3 = i12;
                    i12 = i11;
                    i11 = i10;
                    i7 = i4;
                    for (i10 = 0; i10 < height; i10++) {
                        iArr7[i7] = ((-16777216 | (iArr[i3] << 16)) | (iArr[i12] << 8)) | iArr[i11];
                        if (i4 == 0) {
                            iArr5[i10] = Math.min((i10 + i) + 1, i6) * width;
                            iArr6[i10] = Math.max(i10 - i, 0) * width;
                        }
                        i8 = iArr5[i10] + i4;
                        i13 = iArr6[i10] + i4;
                        i3 += iArr2[i8] - iArr2[i13];
                        i12 += iArr3[i8] - iArr3[i13];
                        i11 += iArr4[i8] - iArr4[i13];
                        i7 += width;
                    }
                }
                i7 = i9;
            } else {
                bitmap.setPixels(iArr7, 0, width, 0, 0, width, height);
                return bitmap;
            }
        }
    }
}
