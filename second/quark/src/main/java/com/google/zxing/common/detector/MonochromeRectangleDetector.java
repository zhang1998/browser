package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.uc.crashsdk.export.LogType;

@Deprecated
/* compiled from: ProGuard */
public final class MonochromeRectangleDetector {
    private static final int MAX_MODULES = 32;
    private final BitMatrix image;

    public MonochromeRectangleDetector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    public final ResultPoint[] detect() throws NotFoundException {
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i = height / 2;
        int i2 = width / 2;
        int max = Math.max(1, height / LogType.UNEXP);
        int max2 = Math.max(1, width / LogType.UNEXP);
        int y = ((int) findCornerFromCenter(i2, 0, 0, width, i, -max, 0, height, i2 / 2).getY()) - 1;
        int x = ((int) findCornerFromCenter(i2, -max2, 0, width, i, 0, y, height, i / 2).getX()) - 1;
        width = ((int) findCornerFromCenter(i2, max2, x, width, i, 0, y, height, i / 2).getX()) + 1;
        ResultPoint findCornerFromCenter = findCornerFromCenter(i2, 0, x, width, i, max, y, height, i2 / 2);
        ResultPoint findCornerFromCenter2 = findCornerFromCenter(i2, 0, x, width, i, -max, y, ((int) findCornerFromCenter.getY()) + 1, i2 / 4);
        return new ResultPoint[]{findCornerFromCenter2, r12, r11, findCornerFromCenter};
    }

    private ResultPoint findCornerFromCenter(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) throws NotFoundException {
        int i10 = i;
        int i11 = i5;
        int[] iArr = null;
        while (i11 < i8 && i11 >= i7 && i10 < i4 && i10 >= i3) {
            int[] blackWhiteRange;
            if (i2 == 0) {
                blackWhiteRange = blackWhiteRange(i11, i9, i3, i4, true);
            } else {
                blackWhiteRange = blackWhiteRange(i10, i9, i7, i8, false);
            }
            if (blackWhiteRange != null) {
                i10 += i2;
                iArr = blackWhiteRange;
                i11 += i6;
            } else if (iArr == null) {
                throw NotFoundException.getNotFoundInstance();
            } else if (i2 == 0) {
                r3 = i11 - i6;
                if (iArr[0] >= i) {
                    return new ResultPoint((float) iArr[1], (float) r3);
                }
                if (iArr[1] <= i) {
                    return new ResultPoint((float) iArr[0], (float) r3);
                }
                int i12;
                if (i6 > 0) {
                    i12 = 0;
                } else {
                    i12 = 1;
                }
                return new ResultPoint((float) iArr[i12], (float) r3);
            } else {
                r3 = i10 - i2;
                if (iArr[0] >= i5) {
                    return new ResultPoint((float) r3, (float) iArr[1]);
                }
                if (iArr[1] <= i5) {
                    return new ResultPoint((float) r3, (float) iArr[0]);
                }
                return new ResultPoint((float) r3, (float) iArr[i2 < 0 ? 0 : 1]);
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int[] blackWhiteRange(int r5, int r6, int r7, int r8, boolean r9) {
        /*
        r4 = this;
        r0 = r7 + r8;
        r1 = r0 / 2;
        r0 = r1;
    L_0x0005:
        if (r0 < r7) goto L_0x0031;
    L_0x0007:
        if (r9 == 0) goto L_0x0014;
    L_0x0009:
        r2 = r4.image;
        r2 = r2.get(r0, r5);
        if (r2 == 0) goto L_0x001c;
    L_0x0011:
        r0 = r0 + -1;
        goto L_0x0005;
    L_0x0014:
        r2 = r4.image;
        r2 = r2.get(r5, r0);
        if (r2 != 0) goto L_0x0011;
    L_0x001c:
        r2 = r0;
    L_0x001d:
        r2 = r2 + -1;
        if (r2 < r7) goto L_0x002b;
    L_0x0021:
        if (r9 == 0) goto L_0x0043;
    L_0x0023:
        r3 = r4.image;
        r3 = r3.get(r2, r5);
        if (r3 == 0) goto L_0x001d;
    L_0x002b:
        r3 = r0 - r2;
        if (r2 < r7) goto L_0x0031;
    L_0x002f:
        if (r3 <= r6) goto L_0x004c;
    L_0x0031:
        r2 = r0 + 1;
        r0 = r1;
    L_0x0034:
        if (r0 >= r8) goto L_0x006b;
    L_0x0036:
        if (r9 == 0) goto L_0x004e;
    L_0x0038:
        r1 = r4.image;
        r1 = r1.get(r0, r5);
        if (r1 == 0) goto L_0x0056;
    L_0x0040:
        r0 = r0 + 1;
        goto L_0x0034;
    L_0x0043:
        r3 = r4.image;
        r3 = r3.get(r5, r2);
        if (r3 == 0) goto L_0x001d;
    L_0x004b:
        goto L_0x002b;
    L_0x004c:
        r0 = r2;
        goto L_0x0005;
    L_0x004e:
        r1 = r4.image;
        r1 = r1.get(r5, r0);
        if (r1 != 0) goto L_0x0040;
    L_0x0056:
        r1 = r0;
    L_0x0057:
        r1 = r1 + 1;
        if (r1 >= r8) goto L_0x0065;
    L_0x005b:
        if (r9 == 0) goto L_0x0079;
    L_0x005d:
        r3 = r4.image;
        r3 = r3.get(r1, r5);
        if (r3 == 0) goto L_0x0057;
    L_0x0065:
        r3 = r1 - r0;
        if (r1 >= r8) goto L_0x006b;
    L_0x0069:
        if (r3 <= r6) goto L_0x0082;
    L_0x006b:
        r1 = r0 + -1;
        if (r1 <= r2) goto L_0x0084;
    L_0x006f:
        r0 = 2;
        r0 = new int[r0];
        r3 = 0;
        r0[r3] = r2;
        r2 = 1;
        r0[r2] = r1;
    L_0x0078:
        return r0;
    L_0x0079:
        r3 = r4.image;
        r3 = r3.get(r5, r1);
        if (r3 == 0) goto L_0x0057;
    L_0x0081:
        goto L_0x0065;
    L_0x0082:
        r0 = r1;
        goto L_0x0034;
    L_0x0084:
        r0 = 0;
        goto L_0x0078;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.common.detector.MonochromeRectangleDetector.blackWhiteRange(int, int, int, int, boolean):int[]");
    }
}
