package com.google.zxing.common;

import com.google.zxing.NotFoundException;

/* compiled from: ProGuard */
public abstract class GridSampler {
    private static GridSampler gridSampler = new DefaultGridSampler();

    public abstract BitMatrix sampleGrid(BitMatrix bitMatrix, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) throws NotFoundException;

    public abstract BitMatrix sampleGrid(BitMatrix bitMatrix, int i, int i2, PerspectiveTransform perspectiveTransform) throws NotFoundException;

    public static void setGridSampler(GridSampler gridSampler) {
        gridSampler = gridSampler;
    }

    public static GridSampler getInstance() {
        return gridSampler;
    }

    protected static void checkAndNudgePoints(BitMatrix bitMatrix, float[] fArr) throws NotFoundException {
        int i;
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        Object obj = 1;
        for (i = 0; i < fArr.length && r2 != null; i += 2) {
            int i2 = (int) fArr[i];
            int i3 = (int) fArr[i + 1];
            if (i2 < -1 || i2 > width || i3 < -1 || i3 > height) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i2 == -1) {
                fArr[i] = 0.0f;
                obj = 1;
            } else if (i2 == width) {
                fArr[i] = (float) (width - 1);
                i2 = 1;
            } else {
                obj = null;
            }
            if (i3 == -1) {
                fArr[i + 1] = 0.0f;
                obj = 1;
            } else if (i3 == height) {
                fArr[i + 1] = (float) (height - 1);
                i2 = 1;
            }
        }
        Object obj2 = 1;
        for (i2 = fArr.length - 2; i2 >= 0 && r0 != null; i2 -= 2) {
            i = (int) fArr[i2];
            i3 = (int) fArr[i2 + 1];
            if (i < -1 || i > width || i3 < -1 || i3 > height) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i == -1) {
                fArr[i2] = 0.0f;
                obj2 = 1;
            } else if (i == width) {
                fArr[i2] = (float) (width - 1);
                i = 1;
            } else {
                obj2 = null;
            }
            if (i3 == -1) {
                fArr[i2 + 1] = 0.0f;
                obj2 = 1;
            } else if (i3 == height) {
                fArr[i2 + 1] = (float) (height - 1);
                i = 1;
            }
        }
    }
}
