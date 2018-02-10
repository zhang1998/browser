package com.google.zxing.qrcode.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.uc.imagecodec.export.IPictureView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class AlignmentPatternFinder {
    private final int[] crossCheckStateCount;
    private final int height;
    private final BitMatrix image;
    private final float moduleSize;
    private final List<AlignmentPattern> possibleCenters = new ArrayList(5);
    private final ResultPointCallback resultPointCallback;
    private final int startX;
    private final int startY;
    private final int width;

    AlignmentPatternFinder(BitMatrix bitMatrix, int i, int i2, int i3, int i4, float f, ResultPointCallback resultPointCallback) {
        this.image = bitMatrix;
        this.startX = i;
        this.startY = i2;
        this.width = i3;
        this.height = i4;
        this.moduleSize = f;
        this.crossCheckStateCount = new int[3];
        this.resultPointCallback = resultPointCallback;
    }

    final AlignmentPattern find() throws NotFoundException {
        int i = this.startX;
        int i2 = this.height;
        int i3 = i + this.width;
        int i4 = this.startY + (i2 / 2);
        int[] iArr = new int[3];
        for (int i5 = 0; i5 < i2; i5++) {
            int i6;
            if ((i5 & 1) == 0) {
                i6 = (i5 + 1) / 2;
            } else {
                i6 = -((i5 + 1) / 2);
            }
            int i7 = i4 + i6;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            i6 = i;
            while (i6 < i3 && !this.image.get(i6, i7)) {
                i6++;
            }
            i6 = 0;
            for (int i8 = i6; i8 < i3; i8++) {
                AlignmentPattern handlePossibleCenter;
                if (!this.image.get(i8, i7)) {
                    if (i6 == 1) {
                        i6++;
                    }
                    iArr[i6] = iArr[i6] + 1;
                } else if (i6 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i6 == 2) {
                    if (foundPatternCross(iArr)) {
                        handlePossibleCenter = handlePossibleCenter(iArr, i7, i8);
                        if (handlePossibleCenter != null) {
                            return handlePossibleCenter;
                        }
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i6 = 1;
                } else {
                    i6++;
                    iArr[i6] = iArr[i6] + 1;
                }
            }
            if (foundPatternCross(iArr)) {
                handlePossibleCenter = handlePossibleCenter(iArr, i7, i3);
                if (handlePossibleCenter != null) {
                    return handlePossibleCenter;
                }
            }
        }
        if (!this.possibleCenters.isEmpty()) {
            return (AlignmentPattern) this.possibleCenters.get(0);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static float centerFromEnd(int[] iArr, int i) {
        return ((float) (i - iArr[2])) - (((float) iArr[1]) / 2.0f);
    }

    private boolean foundPatternCross(int[] iArr) {
        float f = this.moduleSize;
        float f2 = f / 2.0f;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(f - ((float) iArr[i])) >= f2) {
                return false;
            }
        }
        return true;
    }

    private float crossCheckVertical(int i, int i2, int i3, int i4) {
        BitMatrix bitMatrix = this.image;
        int height = bitMatrix.getHeight();
        int[] iArr = this.crossCheckStateCount;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i5 = i;
        while (i5 >= 0 && bitMatrix.get(i2, i5) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i5--;
        }
        if (i5 < 0 || iArr[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bitMatrix.get(i2, i5) && iArr[0] <= i3) {
            iArr[0] = iArr[0] + 1;
            i5--;
        }
        if (iArr[0] > i3) {
            return Float.NaN;
        }
        i5 = i + 1;
        while (i5 < height && bitMatrix.get(i2, i5) && iArr[1] <= i3) {
            iArr[1] = iArr[1] + 1;
            i5++;
        }
        if (i5 == height || iArr[1] > i3) {
            return Float.NaN;
        }
        while (i5 < height && !bitMatrix.get(i2, i5) && iArr[2] <= i3) {
            iArr[2] = iArr[2] + 1;
            i5++;
        }
        if (iArr[2] > i3 || Math.abs(((iArr[0] + iArr[1]) + iArr[2]) - i4) * 5 >= i4 * 2 || !foundPatternCross(iArr)) {
            return Float.NaN;
        }
        return centerFromEnd(iArr, i5);
    }

    private AlignmentPattern handlePossibleCenter(int[] iArr, int i, int i2) {
        int i3 = (iArr[0] + iArr[1]) + iArr[2];
        float centerFromEnd = centerFromEnd(iArr, i2);
        float crossCheckVertical = crossCheckVertical(i, (int) centerFromEnd, iArr[1] * 2, i3);
        if (!Float.isNaN(crossCheckVertical)) {
            float f = ((float) ((iArr[0] + iArr[1]) + iArr[2])) / IPictureView.DEFAULT_MAX_SCALE;
            for (AlignmentPattern alignmentPattern : this.possibleCenters) {
                if (alignmentPattern.aboutEquals(f, crossCheckVertical, centerFromEnd)) {
                    return alignmentPattern.combineEstimate(crossCheckVertical, centerFromEnd, f);
                }
            }
            ResultPoint alignmentPattern2 = new AlignmentPattern(centerFromEnd, crossCheckVertical, f);
            this.possibleCenters.add(alignmentPattern2);
            if (this.resultPointCallback != null) {
                this.resultPointCallback.foundPossibleResultPoint(alignmentPattern2);
            }
        }
        return null;
    }
}
