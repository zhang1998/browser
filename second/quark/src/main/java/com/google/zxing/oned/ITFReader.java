package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Map;

/* compiled from: ProGuard */
public final class ITFReader extends OneDReader {
    private static final int[] DEFAULT_ALLOWED_LENGTHS = new int[]{6, 8, 10, 12, 14};
    private static final int[] END_PATTERN_REVERSED = new int[]{1, 1, 3};
    private static final float MAX_AVG_VARIANCE = 0.38f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.78f;
    private static final int N = 1;
    static final int[][] PATTERNS = new int[][]{new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};
    private static final int[] START_PATTERN = new int[]{1, 1, 1, 1};
    private static final int W = 3;
    private int narrowLineWidth = -1;

    public final Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws FormatException, NotFoundException {
        int[] iArr;
        int i2;
        int[] decodeStart = decodeStart(bitArray);
        int[] decodeEnd = decodeEnd(bitArray);
        StringBuilder stringBuilder = new StringBuilder(20);
        decodeMiddle(bitArray, decodeStart[1], decodeEnd[0], stringBuilder);
        String stringBuilder2 = stringBuilder.toString();
        if (map != null) {
            iArr = (int[]) map.get(DecodeHintType.ALLOWED_LENGTHS);
        } else {
            iArr = null;
        }
        if (iArr == null) {
            iArr = DEFAULT_ALLOWED_LENGTHS;
        }
        int length = stringBuilder2.length();
        int length2 = iArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length2) {
            int i5 = iArr[i3];
            if (length == i5) {
                i2 = 1;
                break;
            }
            if (i5 <= i4) {
                i5 = i4;
            }
            i3++;
            i4 = i5;
        }
        i2 = 0;
        if (i2 == 0 && length > i4) {
            i2 = 1;
        }
        if (i2 == 0) {
            throw FormatException.getFormatInstance();
        }
        return new Result(stringBuilder2, null, new ResultPoint[]{new ResultPoint((float) decodeStart[1], (float) i), new ResultPoint((float) decodeEnd[0], (float) i)}, BarcodeFormat.ITF);
    }

    private static void decodeMiddle(BitArray bitArray, int i, int i2, StringBuilder stringBuilder) throws NotFoundException {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        int i3 = i;
        while (i3 < i2) {
            int i4;
            OneDReader.recordPattern(bitArray, i3, iArr);
            for (i4 = 0; i4 < 5; i4++) {
                int i5 = i4 * 2;
                iArr2[i4] = iArr[i5];
                iArr3[i4] = iArr[i5 + 1];
            }
            stringBuilder.append((char) (decodeDigit(iArr2) + 48));
            stringBuilder.append((char) (decodeDigit(iArr3) + 48));
            i4 = i3;
            for (i3 = 0; i3 < 10; i3++) {
                i4 += iArr[i3];
            }
            i3 = i4;
        }
    }

    private int[] decodeStart(BitArray bitArray) throws NotFoundException {
        int[] findGuardPattern = findGuardPattern(bitArray, skipWhiteSpace(bitArray), START_PATTERN);
        this.narrowLineWidth = (findGuardPattern[1] - findGuardPattern[0]) / 4;
        validateQuietZone(bitArray, findGuardPattern[0]);
        return findGuardPattern;
    }

    private void validateQuietZone(BitArray bitArray, int i) throws NotFoundException {
        int i2 = this.narrowLineWidth * 10;
        if (i2 >= i) {
            i2 = i;
        }
        int i3 = i - 1;
        while (i2 > 0 && i3 >= 0 && !bitArray.get(i3)) {
            i2--;
            i3--;
        }
        if (i2 != 0) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private static int skipWhiteSpace(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        if (nextSet != size) {
            return nextSet;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private int[] decodeEnd(BitArray bitArray) throws NotFoundException {
        bitArray.reverse();
        try {
            int[] findGuardPattern = findGuardPattern(bitArray, skipWhiteSpace(bitArray), END_PATTERN_REVERSED);
            validateQuietZone(bitArray, findGuardPattern[0]);
            int i = findGuardPattern[0];
            findGuardPattern[0] = bitArray.getSize() - findGuardPattern[1];
            findGuardPattern[1] = bitArray.getSize() - i;
            return findGuardPattern;
        } finally {
            bitArray.reverse();
        }
    }

    private static int[] findGuardPattern(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        Object obj = new int[length];
        int size = bitArray.getSize();
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        while (i < size) {
            if ((bitArray.get(i) ^ i4) != 0) {
                obj[i3] = obj[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else if (OneDReader.patternMatchVariance(obj, iArr, MAX_INDIVIDUAL_VARIANCE) < MAX_AVG_VARIANCE) {
                    return new int[]{i2, i};
                } else {
                    i2 += obj[0] + obj[1];
                    System.arraycopy(obj, 2, obj, 0, length - 2);
                    obj[length - 2] = null;
                    obj[length - 1] = null;
                    i3--;
                }
                obj[i3] = 1;
                if (i4 == 0) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int decodeDigit(int[] iArr) throws NotFoundException {
        float f = MAX_AVG_VARIANCE;
        int i = -1;
        int length = PATTERNS.length;
        int i2 = 0;
        while (i2 < length) {
            float patternMatchVariance = OneDReader.patternMatchVariance(iArr, PATTERNS[i2], MAX_INDIVIDUAL_VARIANCE);
            if (patternMatchVariance < f) {
                i = i2;
            } else {
                patternMatchVariance = f;
            }
            i2++;
            f = patternMatchVariance;
        }
        if (i >= 0) {
            return i;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
