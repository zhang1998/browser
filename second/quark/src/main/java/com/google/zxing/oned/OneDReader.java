package com.google.zxing.oned;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.uc.imagecodec.export.IPictureView;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: ProGuard */
public abstract class OneDReader implements Reader {
    public abstract Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return decode(binaryBitmap, null);
    }

    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        try {
            return doDecode(binaryBitmap, map);
        } catch (NotFoundException e) {
            Object obj = (map == null || !map.containsKey(DecodeHintType.TRY_HARDER)) ? null : 1;
            if (obj == null || !binaryBitmap.isRotateSupported()) {
                throw e;
            }
            BinaryBitmap rotateCounterClockwise = binaryBitmap.rotateCounterClockwise();
            Result doDecode = doDecode(rotateCounterClockwise, map);
            Map resultMetadata = doDecode.getResultMetadata();
            int i = 270;
            if (resultMetadata != null && resultMetadata.containsKey(ResultMetadataType.ORIENTATION)) {
                i = (((Integer) resultMetadata.get(ResultMetadataType.ORIENTATION)).intValue() + 270) % 360;
            }
            doDecode.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(i));
            ResultPoint[] resultPoints = doDecode.getResultPoints();
            if (resultPoints != null) {
                int height = rotateCounterClockwise.getHeight();
                for (i = 0; i < resultPoints.length; i++) {
                    resultPoints[i] = new ResultPoint((((float) height) - resultPoints[i].getY()) - IPictureView.DEFAULT_MIN_SCALE, resultPoints[i].getX());
                }
            }
            return doDecode;
        }
    }

    public void reset() {
    }

    private Result doDecode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        Object obj;
        int max;
        int i;
        BitArray bitArray;
        Map map2;
        int i2;
        int i3;
        int i4;
        Map enumMap;
        Result decodeRow;
        ResultPoint[] resultPoints;
        int width = binaryBitmap.getWidth();
        int height = binaryBitmap.getHeight();
        BitArray bitArray2 = new BitArray(width);
        int i5 = height >> 1;
        if (map != null) {
            if (map.containsKey(DecodeHintType.TRY_HARDER)) {
                obj = 1;
                max = Math.max(1, height >> (obj == null ? 8 : 5));
                if (obj == null) {
                    i = height;
                } else {
                    i = 15;
                }
                bitArray = bitArray2;
                map2 = map;
                for (i2 = 0; i2 < i; i2++) {
                    i3 = (i2 + 1) / 2;
                    if (((i2 & 1) != 0 ? 1 : null) == null) {
                        i3 = -i3;
                    }
                    i4 = i5 + (i3 * max);
                    if (i4 < 0 || i4 >= height) {
                        break;
                    }
                    try {
                        bitArray = binaryBitmap.getBlackRow(i4, bitArray);
                        i3 = 0;
                        while (i3 < 2) {
                            if (i3 == 1) {
                                bitArray.reverse();
                                if (map2 != null && map2.containsKey(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) {
                                    enumMap = new EnumMap(DecodeHintType.class);
                                    enumMap.putAll(map2);
                                    enumMap.remove(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                                    decodeRow = decodeRow(i4, bitArray, enumMap);
                                    if (i3 == 1) {
                                        decodeRow.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(180));
                                        resultPoints = decodeRow.getResultPoints();
                                        if (resultPoints != null) {
                                            resultPoints[0] = new ResultPoint((((float) width) - resultPoints[0].getX()) - IPictureView.DEFAULT_MIN_SCALE, resultPoints[0].getY());
                                            resultPoints[1] = new ResultPoint((((float) width) - resultPoints[1].getX()) - IPictureView.DEFAULT_MIN_SCALE, resultPoints[1].getY());
                                        }
                                    }
                                    return decodeRow;
                                }
                            }
                            enumMap = map2;
                            try {
                                decodeRow = decodeRow(i4, bitArray, enumMap);
                                if (i3 == 1) {
                                    decodeRow.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(180));
                                    resultPoints = decodeRow.getResultPoints();
                                    if (resultPoints != null) {
                                        resultPoints[0] = new ResultPoint((((float) width) - resultPoints[0].getX()) - IPictureView.DEFAULT_MIN_SCALE, resultPoints[0].getY());
                                        resultPoints[1] = new ResultPoint((((float) width) - resultPoints[1].getX()) - IPictureView.DEFAULT_MIN_SCALE, resultPoints[1].getY());
                                    }
                                }
                                return decodeRow;
                            } catch (ReaderException e) {
                                i3++;
                                map2 = enumMap;
                            }
                        }
                        continue;
                    } catch (NotFoundException e2) {
                    }
                }
                throw NotFoundException.getNotFoundInstance();
            }
        }
        obj = null;
        if (obj == null) {
        }
        max = Math.max(1, height >> (obj == null ? 8 : 5));
        if (obj == null) {
            i = 15;
        } else {
            i = height;
        }
        bitArray = bitArray2;
        map2 = map;
        for (i2 = 0; i2 < i; i2++) {
            i3 = (i2 + 1) / 2;
            if ((i2 & 1) != 0) {
            }
            if (((i2 & 1) != 0 ? 1 : null) == null) {
                i3 = -i3;
            }
            i4 = i5 + (i3 * max);
            bitArray = binaryBitmap.getBlackRow(i4, bitArray);
            i3 = 0;
            while (i3 < 2) {
                if (i3 == 1) {
                    bitArray.reverse();
                    enumMap = new EnumMap(DecodeHintType.class);
                    enumMap.putAll(map2);
                    enumMap.remove(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
                    decodeRow = decodeRow(i4, bitArray, enumMap);
                    if (i3 == 1) {
                        decodeRow.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(180));
                        resultPoints = decodeRow.getResultPoints();
                        if (resultPoints != null) {
                            resultPoints[0] = new ResultPoint((((float) width) - resultPoints[0].getX()) - IPictureView.DEFAULT_MIN_SCALE, resultPoints[0].getY());
                            resultPoints[1] = new ResultPoint((((float) width) - resultPoints[1].getX()) - IPictureView.DEFAULT_MIN_SCALE, resultPoints[1].getY());
                        }
                    }
                    return decodeRow;
                }
                enumMap = map2;
                decodeRow = decodeRow(i4, bitArray, enumMap);
                if (i3 == 1) {
                    decodeRow.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(180));
                    resultPoints = decodeRow.getResultPoints();
                    if (resultPoints != null) {
                        resultPoints[0] = new ResultPoint((((float) width) - resultPoints[0].getX()) - IPictureView.DEFAULT_MIN_SCALE, resultPoints[0].getY());
                        resultPoints[1] = new ResultPoint((((float) width) - resultPoints[1].getX()) - IPictureView.DEFAULT_MIN_SCALE, resultPoints[1].getY());
                    }
                }
                return decodeRow;
            }
            continue;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static void recordPattern(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        Arrays.fill(iArr, 0, length, 0);
        int size = bitArray.getSize();
        if (i >= size) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i2;
        int i3 = !bitArray.get(i) ? 1 : 0;
        int i4 = 0;
        while (i < size) {
            if ((bitArray.get(i) ^ i3) == 0) {
                i2 = i4 + 1;
                if (i2 == length) {
                    break;
                }
                iArr[i2] = 1;
                int i5 = i2;
                i2 = i3 == 0 ? 1 : 0;
                i4 = i5;
            } else {
                iArr[i4] = iArr[i4] + 1;
                i2 = i3;
            }
            i++;
            i3 = i2;
        }
        i2 = i4;
        if (i2 == length) {
            return;
        }
        if (i2 != length - 1 || i != size) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public static void recordPatternInReverse(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean z = bitArray.get(i);
        while (i > 0 && length >= 0) {
            i--;
            if (bitArray.get(i) != z) {
                length--;
                z = !z;
            }
        }
        if (length >= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        recordPattern(bitArray, i + 1, iArr);
    }

    public static float patternMatchVariance(int[] iArr, int[] iArr2, float f) {
        int i;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        for (i = 0; i < length; i++) {
            i3 += iArr[i];
            i2 += iArr2[i];
        }
        if (i3 < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = ((float) i3) / ((float) i2);
        float f3 = f * f2;
        float f4 = 0.0f;
        for (i = 0; i < length; i++) {
            int i4 = iArr[i];
            float f5 = ((float) iArr2[i]) * f2;
            float f6 = ((float) i4) > f5 ? ((float) i4) - f5 : f5 - ((float) i4);
            if (f6 > f3) {
                return Float.POSITIVE_INFINITY;
            }
            f4 += f6;
        }
        return f4 / ((float) i3);
    }
}
