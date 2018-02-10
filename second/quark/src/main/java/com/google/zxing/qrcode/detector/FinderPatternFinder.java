package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.uc.imagecodec.export.IPictureView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public class FinderPatternFinder {
    private static final int CENTER_QUORUM = 2;
    protected static final int MAX_MODULES = 57;
    protected static final int MIN_SKIP = 3;
    private final int[] crossCheckStateCount;
    private boolean hasSkipped;
    private final BitMatrix image;
    private final List<FinderPattern> possibleCenters;
    private final ResultPointCallback resultPointCallback;

    /* compiled from: ProGuard */
    final class CenterComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        private CenterComparator(float f) {
            this.average = f;
        }

        public final int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            if (finderPattern2.getCount() != finderPattern.getCount()) {
                return finderPattern2.getCount() - finderPattern.getCount();
            }
            float abs = Math.abs(finderPattern2.getEstimatedModuleSize() - this.average);
            float abs2 = Math.abs(finderPattern.getEstimatedModuleSize() - this.average);
            if (abs < abs2) {
                return 1;
            }
            return abs == abs2 ? 0 : -1;
        }
    }

    /* compiled from: ProGuard */
    final class FurthestFromAverageComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        private FurthestFromAverageComparator(float f) {
            this.average = f;
        }

        public final int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            float abs = Math.abs(finderPattern2.getEstimatedModuleSize() - this.average);
            float abs2 = Math.abs(finderPattern.getEstimatedModuleSize() - this.average);
            if (abs < abs2) {
                return -1;
            }
            return abs == abs2 ? 0 : 1;
        }
    }

    public FinderPatternFinder(BitMatrix bitMatrix) {
        this(bitMatrix, null);
    }

    public FinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback) {
        this.image = bitMatrix;
        this.possibleCenters = new ArrayList();
        this.crossCheckStateCount = new int[5];
        this.resultPointCallback = resultPointCallback;
    }

    public final BitMatrix getImage() {
        return this.image;
    }

    public final List<FinderPattern> getPossibleCenters() {
        return this.possibleCenters;
    }

    final FinderPatternInfo find(Map<DecodeHintType, ?> map) throws NotFoundException {
        Object obj = (map == null || !map.containsKey(DecodeHintType.TRY_HARDER)) ? null : 1;
        boolean z = map != null && map.containsKey(DecodeHintType.PURE_BARCODE);
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i = (height * 3) / 228;
        if (i < 3 || obj != null) {
            i = 3;
        }
        boolean z2 = false;
        int[] iArr = new int[5];
        int i2 = i - 1;
        int i3 = i;
        while (i2 < height && !r4) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            i = 0;
            int i4 = 0;
            while (i4 < width) {
                int i5;
                boolean z3;
                int i6;
                if (this.image.get(i4, i2)) {
                    if ((i & 1) == 1) {
                        i++;
                    }
                    iArr[i] = iArr[i] + 1;
                    i5 = i3;
                    z3 = z2;
                    i6 = i5;
                } else if ((i & 1) != 0) {
                    iArr[i] = iArr[i] + 1;
                    i5 = i3;
                    z3 = z2;
                    i6 = i5;
                } else if (i != 4) {
                    i++;
                    iArr[i] = iArr[i] + 1;
                    i5 = i3;
                    z3 = z2;
                    i6 = i5;
                } else if (!foundPatternCross(iArr)) {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i = 3;
                    i5 = i3;
                    z3 = z2;
                    i6 = i5;
                } else if (handlePossibleCenter(iArr, i2, i4, z)) {
                    boolean haveMultiplyConfirmedCenters;
                    if (this.hasSkipped) {
                        haveMultiplyConfirmedCenters = haveMultiplyConfirmedCenters();
                    } else {
                        i = findRowSkip();
                        if (i > iArr[2]) {
                            i4 = i2 + ((i - iArr[2]) - 2);
                            i = width - 1;
                        } else {
                            i = i4;
                            i4 = i2;
                        }
                        i2 = i4;
                        i4 = i;
                        haveMultiplyConfirmedCenters = z2;
                    }
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    iArr[3] = 0;
                    iArr[4] = 0;
                    i6 = 2;
                    z3 = haveMultiplyConfirmedCenters;
                    i = 0;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i = 3;
                    i5 = i3;
                    z3 = z2;
                    i6 = i5;
                }
                i4++;
                i5 = i6;
                z2 = z3;
                i3 = i5;
            }
            if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i2, width, z)) {
                i3 = iArr[0];
                if (this.hasSkipped) {
                    z2 = haveMultiplyConfirmedCenters();
                }
            }
            i2 += i3;
        }
        ResultPoint[] selectBestPatterns = selectBestPatterns();
        ResultPoint.orderBestPatterns(selectBestPatterns);
        return new FinderPatternInfo(selectBestPatterns);
    }

    private static float centerFromEnd(int[] iArr, int i) {
        return ((float) ((i - iArr[4]) - iArr[3])) - (((float) iArr[2]) / 2.0f);
    }

    public static boolean foundPatternCross(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = ((float) i) / 7.0f;
        float f2 = f / 2.0f;
        if (Math.abs(f - ((float) iArr[0])) >= f2 || Math.abs(f - ((float) iArr[1])) >= f2 || Math.abs((IPictureView.DEFAULT_MAX_SCALE * f) - ((float) iArr[2])) >= IPictureView.DEFAULT_MAX_SCALE * f2 || Math.abs(f - ((float) iArr[3])) >= f2 || Math.abs(f - ((float) iArr[4])) >= f2) {
            return false;
        }
        return true;
    }

    private int[] getCrossCheckStateCount() {
        this.crossCheckStateCount[0] = 0;
        this.crossCheckStateCount[1] = 0;
        this.crossCheckStateCount[2] = 0;
        this.crossCheckStateCount[3] = 0;
        this.crossCheckStateCount[4] = 0;
        return this.crossCheckStateCount;
    }

    private boolean crossCheckDiagonal(int i, int i2, int i3, int i4) {
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i5 = 0;
        while (i >= i5 && i2 >= i5 && this.image.get(i2 - i5, i - i5)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i5++;
        }
        if (i < i5 || i2 < i5) {
            return false;
        }
        while (i >= i5 && i2 >= i5 && !this.image.get(i2 - i5, i - i5) && crossCheckStateCount[1] <= i3) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i5++;
        }
        if (i < i5 || i2 < i5 || crossCheckStateCount[1] > i3) {
            return false;
        }
        while (i >= i5 && i2 >= i5 && this.image.get(i2 - i5, i - i5) && crossCheckStateCount[0] <= i3) {
            crossCheckStateCount[0] = crossCheckStateCount[0] + 1;
            i5++;
        }
        if (crossCheckStateCount[0] > i3) {
            return false;
        }
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        i5 = 1;
        while (i + i5 < height && i2 + i5 < width && this.image.get(i2 + i5, i + i5)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i5++;
        }
        if (i + i5 >= height || i2 + i5 >= width) {
            return false;
        }
        while (i + i5 < height && i2 + i5 < width && !this.image.get(i2 + i5, i + i5) && crossCheckStateCount[3] < i3) {
            crossCheckStateCount[3] = crossCheckStateCount[3] + 1;
            i5++;
        }
        if (i + i5 >= height || i2 + i5 >= width || crossCheckStateCount[3] >= i3) {
            return false;
        }
        while (i + i5 < height && i2 + i5 < width && this.image.get(i2 + i5, i + i5) && crossCheckStateCount[4] < i3) {
            crossCheckStateCount[4] = crossCheckStateCount[4] + 1;
            i5++;
        }
        if (crossCheckStateCount[4] >= i3) {
            return false;
        }
        return Math.abs(((((crossCheckStateCount[0] + crossCheckStateCount[1]) + crossCheckStateCount[2]) + crossCheckStateCount[3]) + crossCheckStateCount[4]) - i4) < i4 * 2 && foundPatternCross(crossCheckStateCount);
    }

    private float crossCheckVertical(int i, int i2, int i3, int i4) {
        BitMatrix bitMatrix = this.image;
        int height = bitMatrix.getHeight();
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i5 = i;
        while (i5 >= 0 && bitMatrix.get(i2, i5)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bitMatrix.get(i2, i5) && crossCheckStateCount[1] <= i3) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i5--;
        }
        if (i5 < 0 || crossCheckStateCount[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && bitMatrix.get(i2, i5) && crossCheckStateCount[0] <= i3) {
            crossCheckStateCount[0] = crossCheckStateCount[0] + 1;
            i5--;
        }
        if (crossCheckStateCount[0] > i3) {
            return Float.NaN;
        }
        i5 = i + 1;
        while (i5 < height && bitMatrix.get(i2, i5)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i5++;
        }
        if (i5 == height) {
            return Float.NaN;
        }
        while (i5 < height && !bitMatrix.get(i2, i5) && crossCheckStateCount[3] < i3) {
            crossCheckStateCount[3] = crossCheckStateCount[3] + 1;
            i5++;
        }
        if (i5 == height || crossCheckStateCount[3] >= i3) {
            return Float.NaN;
        }
        while (i5 < height && bitMatrix.get(i2, i5) && crossCheckStateCount[4] < i3) {
            crossCheckStateCount[4] = crossCheckStateCount[4] + 1;
            i5++;
        }
        if (crossCheckStateCount[4] >= i3 || Math.abs(((((crossCheckStateCount[0] + crossCheckStateCount[1]) + crossCheckStateCount[2]) + crossCheckStateCount[3]) + crossCheckStateCount[4]) - i4) * 5 >= i4 * 2 || !foundPatternCross(crossCheckStateCount)) {
            return Float.NaN;
        }
        return centerFromEnd(crossCheckStateCount, i5);
    }

    private float crossCheckHorizontal(int i, int i2, int i3, int i4) {
        BitMatrix bitMatrix = this.image;
        int width = bitMatrix.getWidth();
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i5 = i;
        while (i5 >= 0 && bitMatrix.get(i5, i2)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i5--;
        }
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bitMatrix.get(i5, i2) && crossCheckStateCount[1] <= i3) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i5--;
        }
        if (i5 < 0 || crossCheckStateCount[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && bitMatrix.get(i5, i2) && crossCheckStateCount[0] <= i3) {
            crossCheckStateCount[0] = crossCheckStateCount[0] + 1;
            i5--;
        }
        if (crossCheckStateCount[0] > i3) {
            return Float.NaN;
        }
        i5 = i + 1;
        while (i5 < width && bitMatrix.get(i5, i2)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i5++;
        }
        if (i5 == width) {
            return Float.NaN;
        }
        while (i5 < width && !bitMatrix.get(i5, i2) && crossCheckStateCount[3] < i3) {
            crossCheckStateCount[3] = crossCheckStateCount[3] + 1;
            i5++;
        }
        if (i5 == width || crossCheckStateCount[3] >= i3) {
            return Float.NaN;
        }
        while (i5 < width && bitMatrix.get(i5, i2) && crossCheckStateCount[4] < i3) {
            crossCheckStateCount[4] = crossCheckStateCount[4] + 1;
            i5++;
        }
        if (crossCheckStateCount[4] >= i3 || Math.abs(((((crossCheckStateCount[0] + crossCheckStateCount[1]) + crossCheckStateCount[2]) + crossCheckStateCount[3]) + crossCheckStateCount[4]) - i4) * 5 >= i4 || !foundPatternCross(crossCheckStateCount)) {
            return Float.NaN;
        }
        return centerFromEnd(crossCheckStateCount, i5);
    }

    public final boolean handlePossibleCenter(int[] iArr, int i, int i2, boolean z) {
        boolean z2 = false;
        int i3 = (((iArr[0] + iArr[1]) + iArr[2]) + iArr[3]) + iArr[4];
        float centerFromEnd = centerFromEnd(iArr, i2);
        float crossCheckVertical = crossCheckVertical(i, (int) centerFromEnd, iArr[2], i3);
        if (Float.isNaN(crossCheckVertical)) {
            return false;
        }
        float crossCheckHorizontal = crossCheckHorizontal((int) centerFromEnd, (int) crossCheckVertical, iArr[2], i3);
        if (Float.isNaN(crossCheckHorizontal)) {
            return false;
        }
        if (z && !crossCheckDiagonal((int) crossCheckVertical, (int) crossCheckHorizontal, iArr[2], i3)) {
            return false;
        }
        float f = ((float) i3) / 7.0f;
        for (int i4 = 0; i4 < this.possibleCenters.size(); i4++) {
            FinderPattern finderPattern = (FinderPattern) this.possibleCenters.get(i4);
            if (finderPattern.aboutEquals(f, crossCheckVertical, crossCheckHorizontal)) {
                this.possibleCenters.set(i4, finderPattern.combineEstimate(crossCheckVertical, crossCheckHorizontal, f));
                z2 = true;
                break;
            }
        }
        if (!z2) {
            ResultPoint finderPattern2 = new FinderPattern(crossCheckHorizontal, crossCheckVertical, f);
            this.possibleCenters.add(finderPattern2);
            if (this.resultPointCallback != null) {
                this.resultPointCallback.foundPossibleResultPoint(finderPattern2);
            }
        }
        return true;
    }

    private int findRowSkip() {
        if (this.possibleCenters.size() <= 1) {
            return 0;
        }
        ResultPoint resultPoint = null;
        for (ResultPoint resultPoint2 : this.possibleCenters) {
            if (resultPoint2.getCount() >= 2) {
                if (resultPoint == null) {
                    resultPoint = resultPoint2;
                } else {
                    this.hasSkipped = true;
                    return ((int) (Math.abs(resultPoint.getX() - resultPoint2.getX()) - Math.abs(resultPoint.getY() - resultPoint2.getY()))) / 2;
                }
            }
        }
        return 0;
    }

    private boolean haveMultiplyConfirmedCenters() {
        float f = 0.0f;
        int size = this.possibleCenters.size();
        float f2 = 0.0f;
        int i = 0;
        for (FinderPattern finderPattern : this.possibleCenters) {
            float estimatedModuleSize;
            int i2;
            if (finderPattern.getCount() >= 2) {
                estimatedModuleSize = finderPattern.getEstimatedModuleSize() + f2;
                i2 = i + 1;
            } else {
                estimatedModuleSize = f2;
                i2 = i;
            }
            i = i2;
            f2 = estimatedModuleSize;
        }
        if (i < 3) {
            return false;
        }
        float f3 = f2 / ((float) size);
        for (FinderPattern finderPattern2 : this.possibleCenters) {
            f += Math.abs(finderPattern2.getEstimatedModuleSize() - f3);
        }
        if (f <= 0.05f * f2) {
            return true;
        }
        return false;
    }

    private FinderPattern[] selectBestPatterns() throws NotFoundException {
        float f = 0.0f;
        int size = this.possibleCenters.size();
        if (size < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (size > 3) {
            float estimatedModuleSize;
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (FinderPattern estimatedModuleSize2 : this.possibleCenters) {
                estimatedModuleSize = estimatedModuleSize2.getEstimatedModuleSize();
                f3 += estimatedModuleSize;
                f2 = (estimatedModuleSize * estimatedModuleSize) + f2;
            }
            f3 /= (float) size;
            estimatedModuleSize = (float) Math.sqrt((double) ((f2 / ((float) size)) - (f3 * f3)));
            Collections.sort(this.possibleCenters, new FurthestFromAverageComparator(f3));
            float max = Math.max(0.2f * f3, estimatedModuleSize);
            int i = 0;
            while (i < this.possibleCenters.size() && this.possibleCenters.size() > 3) {
                if (Math.abs(((FinderPattern) this.possibleCenters.get(i)).getEstimatedModuleSize() - f3) > max) {
                    this.possibleCenters.remove(i);
                    i--;
                }
                i++;
            }
        }
        if (this.possibleCenters.size() > 3) {
            for (FinderPattern estimatedModuleSize22 : this.possibleCenters) {
                f += estimatedModuleSize22.getEstimatedModuleSize();
            }
            Collections.sort(this.possibleCenters, new CenterComparator(f / ((float) this.possibleCenters.size())));
            this.possibleCenters.subList(3, this.possibleCenters.size()).clear();
        }
        return new FinderPattern[]{(FinderPattern) this.possibleCenters.get(0), (FinderPattern) this.possibleCenters.get(1), (FinderPattern) this.possibleCenters.get(2)};
    }
}
