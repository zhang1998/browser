package com.ucpro.ui.d;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import com.uc.crashsdk.export.LogType;
import com.uc.imagecodec.export.IPictureView;
import com.uc.util.b;
import java.lang.reflect.Array;

/* compiled from: ProGuard */
public final class i {
    public static final c a;
    private static Canvas b = new Canvas();
    private static Paint c = new Paint();
    private static Bitmap d = b.a(1, 1, Config.RGB_565);
    private static Rect e = new Rect();
    private static Rect f = new Rect();

    static {
        c cVar = new c();
        a = cVar;
        cVar.a = g.f;
        a.b = 12.0f;
        a.c = IPictureView.DEFAULT_MAX_SCALE;
        a.d = 2;
    }

    public static Bitmap a(Bitmap bitmap, c cVar) {
        e.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        f.set(0, 0, (int) (((float) bitmap.getWidth()) / cVar.b), (int) (((float) bitmap.getHeight()) / cVar.b));
        if (f.width() == 0 || f.height() == 0) {
            f.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        }
        Bitmap a = b.a(f.width(), f.height(), Config.ARGB_8888);
        if (a != null) {
            Canvas canvas = b;
            canvas.setBitmap(a);
            canvas.drawBitmap(bitmap, e, f, c);
            canvas.setBitmap(d);
        }
        if (a == null) {
            return bitmap;
        }
        try {
            int i;
            int i2;
            int width;
            int height;
            int i3;
            int[] iArr;
            int i4;
            int i5;
            int[][] iArr2;
            int[] iArr3;
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            int i12;
            int i13;
            int i14;
            int i15;
            int i16;
            int[] iArr4;
            int i17;
            int[] iArr5;
            switch (d.a[cVar.a - 1]) {
                case 1:
                    i = (int) cVar.c;
                    i2 = cVar.d;
                    if (i2 <= 0) {
                        i2 = 1;
                    }
                    if (i2 > 3) {
                        i2 = 3;
                    }
                    if (i <= 0) {
                        i = 1;
                    }
                    width = a.getWidth();
                    height = a.getHeight();
                    int i18 = width - 1;
                    int i19 = height - 1;
                    i3 = width * height;
                    int i20 = (i + i) + 1;
                    int[] iArr6 = new int[i3];
                    iArr = new int[i3];
                    int[] iArr7 = new int[i3];
                    int[] iArr8 = new int[Math.max(width, height)];
                    i4 = ((i20 + 1) >> 1) * ((i20 + 1) >> 1);
                    int[] iArr9 = new int[(i4 * LogType.UNEXP)];
                    for (i5 = 0; i5 < i4 * LogType.UNEXP; i5++) {
                        iArr9[i5] = i5 / i4;
                    }
                    iArr2 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i20, 3});
                    int i21 = i + 1;
                    iArr3 = new int[i3];
                    a.getPixels(iArr3, 0, width, 0, 0, width, height);
                    i3 = i2;
                    while (true) {
                        int i22 = i3 - 1;
                        if (i3 <= 0) {
                            a.setPixels(iArr3, 0, width, 0, 0, width, height);
                            break;
                        }
                        int[] iArr10;
                        int i23;
                        i6 = 0;
                        i7 = 0;
                        i8 = 0;
                        while (i7 < height) {
                            i3 = 0;
                            i9 = 0;
                            i10 = 0;
                            i2 = 0;
                            i11 = 0;
                            i12 = 0;
                            i13 = 0;
                            i14 = 0;
                            i4 = 0;
                            for (i15 = -i; i15 <= i; i15++) {
                                i16 = iArr3[Math.min(i18, Math.max(i15, 0)) + i6];
                                iArr10 = iArr2[i15 + i];
                                iArr10[0] = (16711680 & i16) >> 16;
                                iArr10[1] = (65280 & i16) >> 8;
                                iArr10[2] = i16 & 255;
                                i16 = i21 - Math.abs(i15);
                                i13 += iArr10[0] * i16;
                                i12 += iArr10[1] * i16;
                                i11 += i16 * iArr10[2];
                                if (i15 > 0) {
                                    i9 += iArr10[0];
                                    i4 += iArr10[1];
                                    i3 += iArr10[2];
                                } else {
                                    i14 += iArr10[0];
                                    i2 += iArr10[1];
                                    i10 += iArr10[2];
                                }
                            }
                            i16 = i14;
                            i14 = i;
                            for (i15 = 0; i15 < width; i15++) {
                                iArr6[i6] = iArr9[i13];
                                iArr[i6] = iArr9[i12];
                                iArr7[i6] = iArr9[i11];
                                i13 -= i16;
                                i12 -= i2;
                                i11 -= i10;
                                iArr10 = iArr2[((i14 - i) + i20) % i20];
                                i16 -= iArr10[0];
                                i2 -= iArr10[1];
                                i10 -= iArr10[2];
                                if (i7 == 0) {
                                    iArr8[i15] = Math.min((i15 + i) + 1, i18);
                                }
                                i23 = iArr3[iArr8[i15] + i8];
                                iArr10[0] = (16711680 & i23) >> 16;
                                iArr10[1] = (65280 & i23) >> 8;
                                iArr10[2] = i23 & 255;
                                i9 += iArr10[0];
                                i4 += iArr10[1];
                                i3 += iArr10[2];
                                i13 += i9;
                                i12 += i4;
                                i11 += i3;
                                i14 = (i14 + 1) % i20;
                                iArr10 = iArr2[i14 % i20];
                                i16 += iArr10[0];
                                i2 += iArr10[1];
                                i10 += iArr10[2];
                                i9 -= iArr10[0];
                                i4 -= iArr10[1];
                                i3 -= iArr10[2];
                                i6++;
                            }
                            i7++;
                            i8 += width;
                        }
                        for (i15 = 0; i15 < width; i15++) {
                            i4 = 0;
                            i3 = (-i) * width;
                            i10 = 0;
                            i2 = 0;
                            i14 = 0;
                            i16 = -i;
                            i6 = 0;
                            i11 = 0;
                            i12 = 0;
                            i13 = 0;
                            i9 = 0;
                            while (i16 <= i) {
                                i8 = Math.max(0, i3) + i15;
                                iArr10 = iArr2[i16 + i];
                                iArr10[0] = iArr6[i8];
                                iArr10[1] = iArr[i8];
                                iArr10[2] = iArr7[i8];
                                i23 = i21 - Math.abs(i16);
                                i7 = (iArr6[i8] * i23) + i12;
                                i12 = (iArr[i8] * i23) + i11;
                                i11 = (iArr7[i8] * i23) + i6;
                                if (i16 > 0) {
                                    i10 += iArr10[0];
                                    i9 += iArr10[1];
                                    i4 += iArr10[2];
                                } else {
                                    i13 += iArr10[0];
                                    i14 += iArr10[1];
                                    i2 += iArr10[2];
                                }
                                if (i16 < i19) {
                                    i3 += width;
                                }
                                i16++;
                                i6 = i11;
                                i11 = i12;
                                i12 = i7;
                            }
                            i16 = i12;
                            i7 = i13;
                            i12 = i6;
                            i13 = i11;
                            i6 = i15;
                            i3 = i4;
                            i4 = i9;
                            i9 = i10;
                            i10 = i2;
                            i2 = i14;
                            i14 = i;
                            for (i11 = 0; i11 < height; i11++) {
                                iArr3[i6] = (((-16777216 & iArr3[i6]) | (iArr9[i16] << 16)) | (iArr9[i13] << 8)) | iArr9[i12];
                                i16 -= i7;
                                i13 -= i2;
                                i12 -= i10;
                                iArr4 = iArr2[((i14 - i) + i20) % i20];
                                i7 -= iArr4[0];
                                i2 -= iArr4[1];
                                i10 -= iArr4[2];
                                if (i15 == 0) {
                                    iArr8[i11] = Math.min(i11 + i21, i19) * width;
                                }
                                int i24 = iArr8[i11] + i15;
                                iArr4[0] = iArr6[i24];
                                iArr4[1] = iArr[i24];
                                iArr4[2] = iArr7[i24];
                                i9 += iArr4[0];
                                i4 += iArr4[1];
                                i3 += iArr4[2];
                                i16 += i9;
                                i13 += i4;
                                i12 += i3;
                                i14 = (i14 + 1) % i20;
                                iArr4 = iArr2[i14];
                                i7 += iArr4[0];
                                i2 += iArr4[1];
                                i10 += iArr4[2];
                                i9 -= iArr4[0];
                                i4 -= iArr4[1];
                                i3 -= iArr4[2];
                                i6 += width;
                            }
                        }
                        i3 = i22;
                    }
                case 2:
                    i5 = (int) cVar.c;
                    i17 = cVar.d;
                    if (i17 <= 0) {
                        i17 = 1;
                    }
                    if (i17 > 3) {
                        i17 = 3;
                    }
                    if (i5 <= 0) {
                        i12 = 1;
                    } else {
                        i12 = i5;
                    }
                    width = a.getWidth();
                    height = a.getHeight();
                    iArr3 = new int[(width * height)];
                    a.getPixels(iArr3, 0, width, 0, 0, width, height);
                    i3 = i17;
                    while (true) {
                        i11 = i3 - 1;
                        if (i3 <= 0) {
                            a.setPixels(iArr3, 0, width, 0, 0, width, height);
                            break;
                        }
                        long j;
                        long j2;
                        long j3;
                        iArr5 = new int[height];
                        i16 = (-(i12 + 1)) * width;
                        i7 = i12 * width;
                        for (i15 = 0; i15 < width; i15++) {
                            i3 = 0;
                            j = 0;
                            j2 = 0;
                            j3 = 0;
                            i6 = ((-i12) * width) + i15;
                            for (i10 = -i12; i10 < height; i10++) {
                                if ((i10 - i12) - 1 >= 0) {
                                    i8 = iArr3[i6 + i16];
                                    if (i8 != 0) {
                                        j -= (long) Color.red(i8);
                                        j2 -= (long) Color.green(i8);
                                        j3 -= (long) Color.blue(i8);
                                    }
                                    i3--;
                                }
                                if (i10 + i12 < height) {
                                    i8 = iArr3[i6 + i7];
                                    if (i8 != 0) {
                                        j += (long) Color.red(i8);
                                        j2 += (long) Color.green(i8);
                                        j3 += (long) Color.blue(i8);
                                    }
                                    i3++;
                                }
                                if (i10 >= 0) {
                                    iArr5[i10] = Color.argb(255, (int) (j / ((long) i3)), (int) (j2 / ((long) i3)), (int) (j3 / ((long) i3)));
                                }
                                i6 += width;
                            }
                            for (i3 = 0; i3 < height; i3++) {
                                iArr3[(i3 * width) + i15] = iArr5[i3];
                            }
                        }
                        iArr5 = new int[width];
                        i6 = 0;
                        i15 = 0;
                        while (i6 < height) {
                            j = 0;
                            j2 = 0;
                            j3 = 0;
                            i3 = 0;
                            for (i10 = -i12; i10 < width; i10++) {
                                i16 = (i10 - i12) - 1;
                                if (i16 >= 0) {
                                    i16 = iArr3[i16 + i15];
                                    if (i16 != 0) {
                                        j -= (long) Color.red(i16);
                                        j2 -= (long) Color.green(i16);
                                        j3 -= (long) Color.blue(i16);
                                    }
                                    i3--;
                                }
                                i16 = i10 + i12;
                                if (i16 < width) {
                                    i16 = iArr3[i16 + i15];
                                    if (i16 != 0) {
                                        j += (long) Color.red(i16);
                                        j2 += (long) Color.green(i16);
                                        j3 += (long) Color.blue(i16);
                                    }
                                    i3++;
                                }
                                if (i10 >= 0) {
                                    iArr5[i10] = Color.argb(255, (int) (j / ((long) i3)), (int) (j2 / ((long) i3)), (int) (j3 / ((long) i3)));
                                }
                            }
                            for (i3 = 0; i3 < width; i3++) {
                                iArr3[i15 + i3] = iArr5[i3];
                            }
                            i6++;
                            i15 += width;
                        }
                        i3 = i11;
                    }
                case 3:
                    j.a(a, (int) cVar.c, cVar.d);
                    break;
                case 4:
                    i5 = (int) cVar.c;
                    i17 = cVar.d;
                    if (i17 <= 0) {
                        i17 = 1;
                    }
                    if (i17 > 3) {
                        i17 = 3;
                    }
                    if (i5 <= 0) {
                        i2 = 1;
                    } else {
                        i2 = i5;
                    }
                    width = a.getWidth();
                    height = a.getHeight();
                    i14 = width * height;
                    iArr3 = new int[i14];
                    int[] iArr11 = new int[i14];
                    int[] iArr12 = new int[i14];
                    int[] iArr13 = new int[i14];
                    int[] iArr14 = new int[i14];
                    int[] iArr15 = new int[i14];
                    iArr5 = new int[i14];
                    a.getPixels(iArr3, 0, width, 0, 0, width, height);
                    for (i3 = 0; i3 < i14; i3++) {
                        iArr11[i3] = (iArr3[i3] & 16711680) >> 16;
                        iArr12[i3] = (iArr3[i3] & 65280) >> 8;
                        iArr13[i3] = iArr3[i3] & 255;
                    }
                    i3 = i17;
                    while (true) {
                        i4 = i3 - 1;
                        if (i3 <= 0) {
                            for (i3 = 0; i3 < i14; i3++) {
                                iArr3[i3] = Color.argb(255, iArr14[i3], iArr15[i3], iArr5[i3]);
                            }
                            a.setPixels(iArr3, 0, width, 0, 0, width, height);
                            break;
                        }
                        h.a(iArr11, iArr14, width, height, i2);
                        h.a(iArr12, iArr15, width, height, i2);
                        h.a(iArr13, iArr5, width, height, i2);
                        i3 = i4;
                    }
                case 5:
                    f.a(a, (int) cVar.c, cVar.d);
                    break;
                case 6:
                    i5 = (int) cVar.c;
                    i2 = cVar.d;
                    if (i2 <= 0) {
                        i2 = 1;
                    }
                    if (i2 > 3) {
                        i2 = 3;
                    }
                    if (i5 <= 0) {
                        i16 = 1;
                    } else {
                        i16 = i5;
                    }
                    width = a.getWidth();
                    height = a.getHeight();
                    i14 = width * height;
                    iArr3 = new int[i14];
                    int[] iArr16 = new int[i14];
                    iArr4 = new int[i14];
                    int[] iArr17 = new int[i14];
                    int[] iArr18 = new int[i14];
                    int[] iArr19 = new int[i14];
                    int[] iArr20 = new int[i14];
                    int i25 = (i16 * i16) + 1;
                    iArr = new int[i25];
                    iArr2 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i25, LogType.UNEXP});
                    i9 = i16 - 1;
                    for (i4 = 1; i4 < i16; i4++) {
                        i3 = i16 + i4;
                        i10 = i9 * i9;
                        iArr[i9] = i10;
                        iArr[i3] = i10;
                        for (i3 = 0; i3 < LogType.UNEXP; i3++) {
                            int[] iArr21 = iArr2[i16 + i4];
                            i6 = iArr[i9] * i3;
                            iArr2[i9][i3] = i6;
                            iArr21[i3] = i6;
                        }
                    }
                    iArr[i16] = i16 * i16;
                    for (i3 = 0; i3 < LogType.UNEXP; i3++) {
                        iArr2[i16][i3] = iArr[i16] * i3;
                    }
                    a.getPixels(iArr3, 0, width, 0, 0, width, height);
                    for (i3 = 0; i3 < i14; i3++) {
                        iArr16[i3] = (iArr3[i3] & 16711680) >> 16;
                        iArr4[i3] = (iArr3[i3] & 65280) >> 8;
                        iArr17[i3] = iArr3[i3] & 255;
                    }
                    i3 = i2;
                    while (true) {
                        i13 = i3 - 1;
                        if (i3 <= 0) {
                            a.setPixels(iArr3, 0, width, 0, 0, width, height);
                            break;
                        }
                        i = 0;
                        for (i6 = 0; i6 < height; i6++) {
                            for (i14 = 0; i14 < width; i14++) {
                                i4 = 0;
                                i15 = i14 - i16;
                                i9 = 0;
                                i10 = 0;
                                i3 = 0;
                                for (i2 = 0; i2 < i25; i2++) {
                                    i11 = i15 + i2;
                                    if (i11 >= 0 && i11 < width) {
                                        i11 += i;
                                        i9 += iArr2[i2][iArr16[i11]];
                                        i4 += iArr2[i2][iArr4[i11]];
                                        i3 += iArr2[i2][iArr17[i11]];
                                        i10 += iArr[i2];
                                    }
                                }
                                i2 = i + i14;
                                iArr18[i2] = i9 / i10;
                                iArr19[i2] = i4 / i10;
                                iArr20[i2] = i3 / i10;
                            }
                            i += width;
                        }
                        i11 = 0;
                        for (i12 = 0; i12 < height; i12++) {
                            i14 = i12 - i16;
                            int i26 = i14 * width;
                            for (i15 = 0; i15 < width; i15++) {
                                i9 = 0;
                                i2 = i14;
                                i6 = i15 + i26;
                                i10 = 0;
                                i4 = 0;
                                i3 = 0;
                                for (i = 0; i < i25; i++) {
                                    if (i2 < height && i2 >= 0) {
                                        i9 += iArr2[i][iArr18[i6]];
                                        i4 += iArr2[i][iArr19[i6]];
                                        i3 += iArr2[i][iArr20[i6]];
                                        i10 += iArr[i];
                                    }
                                    i2++;
                                    i6 += width;
                                }
                                iArr3[i15 + i11] = Color.rgb(i9 / i10, i4 / i10, i3 / i10);
                            }
                            i11 += width;
                        }
                        i3 = i13;
                    }
                case 7:
                    a.a(a, (int) cVar.c, cVar.d);
                    break;
            }
            return a;
        } catch (Exception e) {
            return bitmap;
        }
    }
}
