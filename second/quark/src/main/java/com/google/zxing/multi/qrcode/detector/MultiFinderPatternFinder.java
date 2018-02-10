package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.detector.FinderPattern;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
import com.google.zxing.qrcode.detector.FinderPatternInfo;
import com.uc.imagecodec.export.IPictureView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
final class MultiFinderPatternFinder extends FinderPatternFinder {
    private static final float DIFF_MODSIZE_CUTOFF = 0.5f;
    private static final float DIFF_MODSIZE_CUTOFF_PERCENT = 0.05f;
    private static final FinderPatternInfo[] EMPTY_RESULT_ARRAY = new FinderPatternInfo[0];
    private static final float MAX_MODULE_COUNT_PER_EDGE = 180.0f;
    private static final float MIN_MODULE_COUNT_PER_EDGE = 9.0f;

    /* compiled from: ProGuard */
    final class ModuleSizeComparator implements Serializable, Comparator<FinderPattern> {
        private ModuleSizeComparator() {
        }

        public final int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            float estimatedModuleSize = finderPattern2.getEstimatedModuleSize() - finderPattern.getEstimatedModuleSize();
            if (((double) estimatedModuleSize) < 0.0d) {
                return -1;
            }
            return ((double) estimatedModuleSize) > 0.0d ? 1 : 0;
        }
    }

    MultiFinderPatternFinder(BitMatrix bitMatrix) {
        super(bitMatrix);
    }

    MultiFinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback) {
        super(bitMatrix, resultPointCallback);
    }

    private FinderPattern[][] selectMutipleBestPatterns() throws NotFoundException {
        List possibleCenters = getPossibleCenters();
        int size = possibleCenters.size();
        if (size < 3) {
            throw NotFoundException.getNotFoundInstance();
        } else if (size == 3) {
            FinderPattern[][] finderPatternArr = new FinderPattern[1][];
            finderPatternArr[0] = new FinderPattern[]{(FinderPattern) possibleCenters.get(0), (FinderPattern) possibleCenters.get(1), (FinderPattern) possibleCenters.get(2)};
            return finderPatternArr;
        } else {
            Collections.sort(possibleCenters, new ModuleSizeComparator());
            List arrayList = new ArrayList();
            for (int i = 0; i < size - 2; i++) {
                FinderPattern finderPattern = (FinderPattern) possibleCenters.get(i);
                if (finderPattern != null) {
                    for (int i2 = i + 1; i2 < size - 1; i2++) {
                        FinderPattern finderPattern2 = (FinderPattern) possibleCenters.get(i2);
                        if (finderPattern2 != null) {
                            float estimatedModuleSize = (finderPattern.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize()) / Math.min(finderPattern.getEstimatedModuleSize(), finderPattern2.getEstimatedModuleSize());
                            if (Math.abs(finderPattern.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize()) > DIFF_MODSIZE_CUTOFF && estimatedModuleSize >= DIFF_MODSIZE_CUTOFF_PERCENT) {
                                break;
                            }
                            for (int i3 = i2 + 1; i3 < size; i3++) {
                                FinderPattern finderPattern3 = (FinderPattern) possibleCenters.get(i3);
                                if (finderPattern3 != null) {
                                    float estimatedModuleSize2 = (finderPattern2.getEstimatedModuleSize() - finderPattern3.getEstimatedModuleSize()) / Math.min(finderPattern2.getEstimatedModuleSize(), finderPattern3.getEstimatedModuleSize());
                                    if (Math.abs(finderPattern2.getEstimatedModuleSize() - finderPattern3.getEstimatedModuleSize()) > DIFF_MODSIZE_CUTOFF && estimatedModuleSize2 >= DIFF_MODSIZE_CUTOFF_PERCENT) {
                                        break;
                                    }
                                    Object obj = new FinderPattern[]{finderPattern, finderPattern2, finderPattern3};
                                    ResultPoint.orderBestPatterns(obj);
                                    FinderPatternInfo finderPatternInfo = new FinderPatternInfo(obj);
                                    float distance = ResultPoint.distance(finderPatternInfo.getTopLeft(), finderPatternInfo.getBottomLeft());
                                    float distance2 = ResultPoint.distance(finderPatternInfo.getTopRight(), finderPatternInfo.getBottomLeft());
                                    estimatedModuleSize = ResultPoint.distance(finderPatternInfo.getTopLeft(), finderPatternInfo.getTopRight());
                                    float estimatedModuleSize3 = (distance + estimatedModuleSize) / (finderPattern.getEstimatedModuleSize() * 2.0f);
                                    if (estimatedModuleSize3 <= MAX_MODULE_COUNT_PER_EDGE && estimatedModuleSize3 >= MIN_MODULE_COUNT_PER_EDGE && Math.abs((distance - estimatedModuleSize) / Math.min(distance, estimatedModuleSize)) < 0.1f) {
                                        estimatedModuleSize = (float) Math.sqrt((double) ((estimatedModuleSize * estimatedModuleSize) + (distance * distance)));
                                        if (Math.abs((distance2 - estimatedModuleSize) / Math.min(distance2, estimatedModuleSize)) < 0.1f) {
                                            arrayList.add(obj);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                return (FinderPattern[][]) arrayList.toArray(new FinderPattern[arrayList.size()][]);
            }
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public final FinderPatternInfo[] findMulti(Map<DecodeHintType, ?> map) throws NotFoundException {
        Object obj = (map == null || !map.containsKey(DecodeHintType.TRY_HARDER)) ? null : 1;
        boolean z = map != null && map.containsKey(DecodeHintType.PURE_BARCODE);
        BitMatrix image = getImage();
        int height = image.getHeight();
        int width = image.getWidth();
        int i = (int) ((((float) height) / 228.0f) * IPictureView.DEFAULT_MAX_SCALE);
        if (i < 3 || obj != null) {
            i = 3;
        }
        int[] iArr = new int[5];
        int i2 = i - 1;
        while (i2 < height) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            int i3 = 0;
            int i4 = 0;
            while (i4 < width) {
                if (image.get(i4, i2)) {
                    if ((i3 & 1) == 1) {
                        i3++;
                    }
                    iArr[i3] = iArr[i3] + 1;
                } else if ((i3 & 1) != 0) {
                    iArr[i3] = iArr[i3] + 1;
                } else if (i3 != 4) {
                    i3++;
                    iArr[i3] = iArr[i3] + 1;
                } else if (FinderPatternFinder.foundPatternCross(iArr) && handlePossibleCenter(iArr, i2, i4, z)) {
                    i3 = 0;
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    iArr[3] = 0;
                    iArr[4] = 0;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i3 = 3;
                }
                i4++;
            }
            if (FinderPatternFinder.foundPatternCross(iArr)) {
                handlePossibleCenter(iArr, i2, width, z);
            }
            i2 += i;
        }
        FinderPattern[][] selectMutipleBestPatterns = selectMutipleBestPatterns();
        List arrayList = new ArrayList();
        for (ResultPoint[] resultPointArr : selectMutipleBestPatterns) {
            ResultPoint.orderBestPatterns(resultPointArr);
            arrayList.add(new FinderPatternInfo(resultPointArr));
        }
        if (arrayList.isEmpty()) {
            return EMPTY_RESULT_ARRAY;
        }
        return (FinderPatternInfo[]) arrayList.toArray(new FinderPatternInfo[arrayList.size()]);
    }
}
