package com.google.zxing.common;

import com.google.zxing.NotFoundException;

/* compiled from: ProGuard */
public final class DefaultGridSampler extends GridSampler {
    public final BitMatrix sampleGrid(BitMatrix bitMatrix, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) throws NotFoundException {
        return sampleGrid(bitMatrix, i, i2, PerspectiveTransform.quadrilateralToQuadrilateral(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16));
    }

    public final BitMatrix sampleGrid(BitMatrix bitMatrix, int i, int i2, PerspectiveTransform perspectiveTransform) throws NotFoundException {
        if (i <= 0 || i2 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        BitMatrix bitMatrix2 = new BitMatrix(i, i2);
        float[] fArr = new float[(i * 2)];
        for (int i3 = 0; i3 < i2; i3++) {
            int i4;
            int length = fArr.length;
            float f = ((float) i3) + 0.5f;
            for (i4 = 0; i4 < length; i4 += 2) {
                fArr[i4] = (((float) i4) / 2.0f) + 0.5f;
                fArr[i4 + 1] = f;
            }
            perspectiveTransform.transformPoints(fArr);
            GridSampler.checkAndNudgePoints(bitMatrix, fArr);
            i4 = 0;
            while (i4 < length) {
                try {
                    if (bitMatrix.get((int) fArr[i4], (int) fArr[i4 + 1])) {
                        bitMatrix2.set(i4 / 2, i3);
                    }
                    i4 += 2;
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
        }
        return bitMatrix2;
    }
}
