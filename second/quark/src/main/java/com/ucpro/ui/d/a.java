package com.ucpro.ui.d;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: ProGuard */
public final class a {
    private static final int a;
    private static final ExecutorService b;
    private static final short[] c = new short[]{(short) 512, (short) 512, (short) 456, (short) 512, (short) 328, (short) 456, (short) 335, (short) 512, (short) 405, (short) 328, (short) 271, (short) 456, (short) 388, (short) 335, (short) 292, (short) 512, (short) 454, (short) 405, (short) 364, (short) 328, (short) 298, (short) 271, (short) 496, (short) 456, (short) 420, (short) 388, (short) 360, (short) 335, (short) 312, (short) 292, (short) 273, (short) 512, (short) 482, (short) 454, (short) 428, (short) 405, (short) 383, (short) 364, (short) 345, (short) 328, (short) 312, (short) 298, (short) 284, (short) 271, (short) 259, (short) 496, (short) 475, (short) 456, (short) 437, (short) 420, (short) 404, (short) 388, (short) 374, (short) 360, (short) 347, (short) 335, (short) 323, (short) 312, (short) 302, (short) 292, (short) 282, (short) 273, (short) 265, (short) 512, (short) 497, (short) 482, (short) 468, (short) 454, (short) 441, (short) 428, (short) 417, (short) 405, (short) 394, (short) 383, (short) 373, (short) 364, (short) 354, (short) 345, (short) 337, (short) 328, (short) 320, (short) 312, (short) 305, (short) 298, (short) 291, (short) 284, (short) 278, (short) 271, (short) 265, (short) 259, (short) 507, (short) 496, (short) 485, (short) 475, (short) 465, (short) 456, (short) 446, (short) 437, (short) 428, (short) 420, (short) 412, (short) 404, (short) 396, (short) 388, (short) 381, (short) 374, (short) 367, (short) 360, (short) 354, (short) 347, (short) 341, (short) 335, (short) 329, (short) 323, (short) 318, (short) 312, (short) 307, (short) 302, (short) 297, (short) 292, (short) 287, (short) 282, (short) 278, (short) 273, (short) 269, (short) 265, (short) 261, (short) 512, (short) 505, (short) 497, (short) 489, (short) 482, (short) 475, (short) 468, (short) 461, (short) 454, (short) 447, (short) 441, (short) 435, (short) 428, (short) 422, (short) 417, (short) 411, (short) 405, (short) 399, (short) 394, (short) 389, (short) 383, (short) 378, (short) 373, (short) 368, (short) 364, (short) 359, (short) 354, (short) 350, (short) 345, (short) 341, (short) 337, (short) 332, (short) 328, (short) 324, (short) 320, (short) 316, (short) 312, (short) 309, (short) 305, (short) 301, (short) 298, (short) 294, (short) 291, (short) 287, (short) 284, (short) 281, (short) 278, (short) 274, (short) 271, (short) 268, (short) 265, (short) 262, (short) 259, (short) 257, (short) 507, (short) 501, (short) 496, (short) 491, (short) 485, (short) 480, (short) 475, (short) 470, (short) 465, (short) 460, (short) 456, (short) 451, (short) 446, (short) 442, (short) 437, (short) 433, (short) 428, (short) 424, (short) 420, (short) 416, (short) 412, (short) 408, (short) 404, (short) 400, (short) 396, (short) 392, (short) 388, (short) 385, (short) 381, (short) 377, (short) 374, (short) 370, (short) 367, (short) 363, (short) 360, (short) 357, (short) 354, (short) 350, (short) 347, (short) 344, (short) 341, (short) 338, (short) 335, (short) 332, (short) 329, (short) 326, (short) 323, (short) 320, (short) 318, (short) 315, (short) 312, (short) 310, (short) 307, (short) 304, (short) 302, (short) 299, (short) 297, (short) 294, (short) 292, (short) 289, (short) 287, (short) 285, (short) 282, (short) 280, (short) 278, (short) 275, (short) 273, (short) 271, (short) 269, (short) 267, (short) 265, (short) 263, (short) 261, (short) 259};
    private static final byte[] d = new byte[]{(byte) 9, (byte) 11, (byte) 12, (byte) 13, (byte) 13, (byte) 14, (byte) 14, (byte) 15, (byte) 15, (byte) 15, (byte) 15, (byte) 16, (byte) 16, (byte) 16, (byte) 16, (byte) 17, (byte) 17, (byte) 17, (byte) 17, (byte) 17, (byte) 17, (byte) 17, (byte) 18, (byte) 18, (byte) 18, (byte) 18, (byte) 18, (byte) 18, (byte) 18, (byte) 18, (byte) 18, (byte) 19, (byte) 19, (byte) 19, (byte) 19, (byte) 19, (byte) 19, (byte) 19, (byte) 19, (byte) 19, (byte) 19, (byte) 19, (byte) 19, (byte) 19, (byte) 19, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 20, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 21, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 22, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 23, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24, (byte) 24};

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        a = availableProcessors;
        b = Executors.newFixedThreadPool(availableProcessors);
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        int i3;
        int i4;
        if (i2 <= 0) {
            i3 = 1;
        } else {
            i3 = i2;
        }
        if (i3 > 3) {
            i3 = 3;
        }
        if (i <= 0) {
            i4 = 1;
        } else {
            i4 = i;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[(width * height)];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i5 = a;
        int i6 = i3;
        while (true) {
            int i7 = i6 - 1;
            if (i6 <= 0) {
                break;
            }
            Collection arrayList = new ArrayList(i5);
            Collection arrayList2 = new ArrayList(i5);
            for (i3 = 0; i3 < i5; i3++) {
                arrayList.add(new e(iArr, width, height, i4, i5, i3, 1));
                arrayList2.add(new e(iArr, width, height, i4, i5, i3, 2));
            }
            try {
                b.invokeAll(arrayList);
                try {
                    b.invokeAll(arrayList2);
                    i6 = i7;
                } catch (InterruptedException e) {
                }
            } catch (InterruptedException e2) {
            }
        }
        bitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmap;
    }

    static /* synthetic */ void a(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i - 1;
        int i8 = i2 - 1;
        int i9 = (i3 * 2) + 1;
        short s = c[i3];
        byte b = d[i3];
        int[] iArr2 = new int[i9];
        int i10;
        int i11;
        long j;
        int i12;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        int i13;
        int i14;
        int i15;
        long j9;
        int i16;
        if (i6 == 1) {
            i10 = ((i5 + 1) * i2) / i4;
            for (i11 = (i5 * i2) / i4; i11 < i10; i11++) {
                j = 0;
                i12 = i * i11;
                j2 = 0;
                j3 = 0;
                j4 = 0;
                j5 = 0;
                j6 = 0;
                long j10 = 0;
                for (int i17 = 0; i17 <= i3; i17++) {
                    iArr2[i17] = iArr[i12];
                    j6 += (long) (((iArr[i12] >>> 16) & 255) * (i17 + 1));
                    j5 += (long) (((iArr[i12] >>> 8) & 255) * (i17 + 1));
                    j4 += (long) ((iArr[i12] & 255) * (i17 + 1));
                    j3 += (long) ((iArr[i12] >>> 16) & 255);
                    j2 += (long) ((iArr[i12] >>> 8) & 255);
                    j10 += (long) (iArr[i12] & 255);
                }
                j7 = 0;
                j8 = 0;
                for (int i18 = 1; i18 <= i3; i18++) {
                    if (i18 <= i7) {
                        i12++;
                    }
                    iArr2[i18 + i3] = iArr[i12];
                    j6 += (long) (((iArr[i12] >>> 16) & 255) * ((i3 + 1) - i18));
                    j5 += (long) (((iArr[i12] >>> 8) & 255) * ((i3 + 1) - i18));
                    j4 += (long) ((iArr[i12] & 255) * ((i3 + 1) - i18));
                    j7 += (long) ((iArr[i12] >>> 16) & 255);
                    j8 += (long) ((iArr[i12] >>> 8) & 255);
                    j += (long) (iArr[i12] & 255);
                }
                if (i3 > i7) {
                    i12 = i7;
                } else {
                    i12 = i3;
                }
                i13 = i3;
                i14 = 0;
                long j11 = j3;
                j3 = j2;
                j2 = j10;
                i8 = i12 + (i11 * i);
                i15 = i12;
                i12 = i11 * i;
                j9 = j6;
                j6 = j5;
                j5 = j4;
                j4 = j7;
                j7 = j8;
                j8 = j;
                j = j11;
                while (i14 < i) {
                    iArr[i12] = (int) (((((long) (iArr[i12] & -16777216)) | ((((((long) s) * j9) >>> b) & 255) << 16)) | ((((((long) s) * j6) >>> b) & 255) << 8)) | (((((long) s) * j5) >>> b) & 255));
                    i16 = i12 + 1;
                    j9 -= j;
                    j6 -= j3;
                    j5 -= j2;
                    i12 = (i13 + i9) - i3;
                    if (i12 >= i9) {
                        i12 -= i9;
                    }
                    j -= (long) ((iArr2[i12] >>> 16) & 255);
                    j3 -= (long) ((iArr2[i12] >>> 8) & 255);
                    j2 -= (long) (iArr2[i12] & 255);
                    if (i15 < i7) {
                        i8++;
                        i15++;
                    }
                    iArr2[i12] = iArr[i8];
                    j4 += (long) ((iArr[i8] >>> 16) & 255);
                    j7 += (long) ((iArr[i8] >>> 8) & 255);
                    j8 += (long) (iArr[i8] & 255);
                    j9 += j4;
                    j6 += j7;
                    j5 += j8;
                    i12 = i13 + 1;
                    if (i12 >= i9) {
                        i12 = 0;
                    }
                    j += (long) ((iArr2[i12] >>> 16) & 255);
                    j3 += (long) ((iArr2[i12] >>> 8) & 255);
                    j2 += (long) (iArr2[i12] & 255);
                    j4 -= (long) ((iArr2[i12] >>> 16) & 255);
                    j7 -= (long) ((iArr2[i12] >>> 8) & 255);
                    j8 -= (long) (iArr2[i12] & 255);
                    i14++;
                    i13 = i12;
                    i12 = i16;
                }
            }
        } else if (i6 == 2) {
            i10 = ((i5 + 1) * i) / i4;
            for (i16 = (i5 * i) / i4; i16 < i10; i16++) {
                j8 = 0;
                j2 = 0;
                j3 = 0;
                j = 0;
                j5 = 0;
                j6 = 0;
                j9 = 0;
                for (i12 = 0; i12 <= i3; i12++) {
                    iArr2[i12] = iArr[i16];
                    j9 += (long) (((iArr[i16] >>> 16) & 255) * (i12 + 1));
                    j6 += (long) (((iArr[i16] >>> 8) & 255) * (i12 + 1));
                    j5 += (long) ((iArr[i16] & 255) * (i12 + 1));
                    j += (long) ((iArr[i16] >>> 16) & 255);
                    j3 += (long) ((iArr[i16] >>> 8) & 255);
                    j2 += (long) (iArr[i16] & 255);
                }
                j7 = 0;
                j4 = 0;
                i12 = i16;
                for (i7 = 1; i7 <= i3; i7++) {
                    if (i7 <= i8) {
                        i12 += i;
                    }
                    iArr2[i7 + i3] = iArr[i12];
                    j9 += (long) (((iArr[i12] >>> 16) & 255) * ((i3 + 1) - i7));
                    j6 += (long) (((iArr[i12] >>> 8) & 255) * ((i3 + 1) - i7));
                    j5 += (long) ((iArr[i12] & 255) * ((i3 + 1) - i7));
                    j4 += (long) ((iArr[i12] >>> 16) & 255);
                    j7 += (long) ((iArr[i12] >>> 8) & 255);
                    j8 += (long) (iArr[i12] & 255);
                }
                if (i3 > i8) {
                    i12 = i8;
                } else {
                    i12 = i3;
                }
                i7 = (i12 * i) + i16;
                i14 = i3;
                i11 = 0;
                i15 = i12;
                i12 = i16;
                while (i11 < i2) {
                    iArr[i12] = (int) (((((long) (iArr[i12] & -16777216)) | ((((((long) s) * j9) >>> b) & 255) << 16)) | ((((((long) s) * j6) >>> b) & 255) << 8)) | (((((long) s) * j5) >>> b) & 255));
                    i13 = i12 + i;
                    j9 -= j;
                    j6 -= j3;
                    j5 -= j2;
                    i12 = (i14 + i9) - i3;
                    if (i12 >= i9) {
                        i12 -= i9;
                    }
                    j -= (long) ((iArr2[i12] >>> 16) & 255);
                    j3 -= (long) ((iArr2[i12] >>> 8) & 255);
                    j2 -= (long) (iArr2[i12] & 255);
                    if (i15 < i8) {
                        i7 += i;
                        i15++;
                    }
                    iArr2[i12] = iArr[i7];
                    j4 += (long) ((iArr[i7] >>> 16) & 255);
                    j7 += (long) ((iArr[i7] >>> 8) & 255);
                    j8 += (long) (iArr[i7] & 255);
                    j9 += j4;
                    j6 += j7;
                    j5 += j8;
                    i12 = i14 + 1;
                    if (i12 >= i9) {
                        i12 = 0;
                    }
                    j += (long) ((iArr2[i12] >>> 16) & 255);
                    j3 += (long) ((iArr2[i12] >>> 8) & 255);
                    j2 += (long) (iArr2[i12] & 255);
                    j4 -= (long) ((iArr2[i12] >>> 16) & 255);
                    j7 -= (long) ((iArr2[i12] >>> 8) & 255);
                    j8 -= (long) (iArr2[i12] & 255);
                    i11++;
                    i14 = i12;
                    i12 = i13;
                }
            }
        }
    }
}
