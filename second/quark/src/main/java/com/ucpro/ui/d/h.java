package com.ucpro.ui.d;

import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public final class h {
    static void a(int[] iArr, int[] iArr2, int i, int i2, int i3) {
        float f = (float) i3;
        int floor = (int) Math.floor(Math.sqrt((double) ((((12.0f * f) * f) / IPictureView.DEFAULT_MAX_SCALE) + IPictureView.DEFAULT_MIN_SCALE)));
        if (floor % 2 == 0) {
            floor--;
        }
        int i4 = floor + 2;
        int round = (int) Math.round((double) (((((f * (12.0f * f)) - ((float) ((floor * 3) * floor))) - ((float) (floor * 12))) - 9.0f) / ((float) ((floor * -4) - 4))));
        int[] iArr3 = new int[3];
        for (int i5 = 0; i5 < 3; i5++) {
            int i6;
            if (i5 < round) {
                i6 = floor;
            } else {
                i6 = i4;
            }
            iArr3[i5] = i6;
        }
        b(iArr, iArr2, i, i2, (iArr3[0] - 1) / 2);
        b(iArr2, iArr, i, i2, (iArr3[1] - 1) / 2);
        b(iArr, iArr2, i, i2, (iArr3[2] - 1) / 2);
    }

    private static void b(int[] iArr, int[] iArr2, int i, int i2, int i3) {
        int i4;
        for (i4 = 0; i4 < iArr.length; i4++) {
            iArr2[i4] = iArr[i4];
        }
        float f = IPictureView.DEFAULT_MIN_SCALE / (((float) (i3 + i3)) + IPictureView.DEFAULT_MIN_SCALE);
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i5 * i;
            int i7 = i6 + i3;
            int i8 = iArr2[i6];
            int i9 = iArr2[(i6 + i) - 1];
            int i10 = (i3 + 1) * i8;
            for (i4 = 0; i4 < i3; i4++) {
                i10 += iArr2[i6 + i4];
            }
            i4 = 0;
            int i11 = i6;
            while (i4 <= i3) {
                int i12 = i7 + 1;
                i10 += iArr2[i7] - i8;
                i7 = i11 + 1;
                iArr[i11] = Math.round(((float) i10) * f);
                i4++;
                i11 = i7;
                i7 = i12;
            }
            i4 = i3 + 1;
            int i13 = i7;
            i7 = i6;
            i6 = i11;
            i11 = i13;
            while (i4 < i - i3) {
                i12 = i11 + 1;
                i8 = iArr2[i11];
                i11 = i7 + 1;
                i10 += i8 - iArr2[i7];
                i7 = i6 + 1;
                iArr[i6] = Math.round(((float) i10) * f);
                i4++;
                i6 = i7;
                i7 = i11;
                i11 = i12;
            }
            i4 = i - i3;
            i11 = i6;
            while (i4 < i) {
                i6 = i7 + 1;
                i10 += i9 - iArr2[i7];
                i7 = i11 + 1;
                iArr[i11] = Math.round(((float) i10) * f);
                i4++;
                i11 = i7;
                i7 = i6;
            }
        }
        f = IPictureView.DEFAULT_MIN_SCALE / (((float) (i3 + i3)) + IPictureView.DEFAULT_MIN_SCALE);
        for (i12 = 0; i12 < i; i12++) {
            i7 = i12 + (i3 * i);
            i11 = iArr[i12];
            i8 = iArr[((i2 - 1) * i) + i12];
            i10 = (i3 + 1) * i11;
            for (i4 = 0; i4 < i3; i4++) {
                i10 += iArr[(i4 * i) + i12];
            }
            i6 = i12;
            for (i4 = 0; i4 <= i3; i4++) {
                i10 += iArr[i7] - i11;
                iArr2[i6] = Math.round(((float) i10) * f);
                i7 += i;
                i6 += i;
            }
            i4 = i3 + 1;
            i11 = i7;
            i7 = i12;
            while (i4 < i2 - i3) {
                i10 += iArr[i11] - iArr[i7];
                iArr2[i6] = Math.round(((float) i10) * f);
                i6 += i;
                i4++;
                i11 += i;
                i7 += i;
            }
            for (i4 = i2 - i3; i4 < i2; i4++) {
                i10 += i8 - iArr[i7];
                iArr2[i6] = Math.round(((float) i10) * f);
                i7 += i;
                i6 += i;
            }
        }
    }
}
