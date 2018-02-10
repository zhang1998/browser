package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;

/* compiled from: ProGuard */
public class GlobalHistogramBinarizer extends Binarizer {
    private static final byte[] EMPTY = new byte[0];
    private static final int LUMINANCE_BITS = 5;
    private static final int LUMINANCE_BUCKETS = 32;
    private static final int LUMINANCE_SHIFT = 3;
    private final int[] buckets = new int[32];
    private byte[] luminances = EMPTY;

    public GlobalHistogramBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    public BitArray getBlackRow(int i, BitArray bitArray) throws NotFoundException {
        int i2;
        int i3;
        int i4 = 1;
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        if (bitArray == null || bitArray.getSize() < width) {
            bitArray = new BitArray(width);
        } else {
            bitArray.clear();
        }
        initArrays(width);
        byte[] row = luminanceSource.getRow(i, this.luminances);
        int[] iArr = this.buckets;
        for (i2 = 0; i2 < width; i2++) {
            i3 = (row[i2] & 255) >> 3;
            iArr[i3] = iArr[i3] + 1;
        }
        i3 = estimateBlackPoint(iArr);
        if (width < 3) {
            for (i4 = 0; i4 < width; i4++) {
                if ((row[i4] & 255) < i3) {
                    bitArray.set(i4);
                }
            }
        } else {
            int i5 = row[1] & 255;
            int i6 = row[0] & 255;
            while (i4 < width - 1) {
                i2 = row[i4 + 1] & 255;
                if ((((i5 * 4) - i6) - i2) / 2 < i3) {
                    bitArray.set(i4);
                }
                i4++;
                i6 = i5;
                i5 = i2;
            }
        }
        return bitArray;
    }

    public BitMatrix getBlackMatrix() throws NotFoundException {
        int i;
        int i2;
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        BitMatrix bitMatrix = new BitMatrix(width, height);
        initArrays(width);
        int[] iArr = this.buckets;
        for (i = 1; i < 5; i++) {
            byte[] row = luminanceSource.getRow((height * i) / 5, this.luminances);
            int i3 = (width * 4) / 5;
            for (i2 = width / 5; i2 < i3; i2++) {
                int i4 = (row[i2] & 255) >> 3;
                iArr[i4] = iArr[i4] + 1;
            }
        }
        int estimateBlackPoint = estimateBlackPoint(iArr);
        byte[] matrix = luminanceSource.getMatrix();
        for (i = 0; i < height; i++) {
            int i5 = i * width;
            for (i2 = 0; i2 < width; i2++) {
                if ((matrix[i5 + i2] & 255) < estimateBlackPoint) {
                    bitMatrix.set(i2, i);
                }
            }
        }
        return bitMatrix;
    }

    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new GlobalHistogramBinarizer(luminanceSource);
    }

    private void initArrays(int i) {
        if (this.luminances.length < i) {
            this.luminances = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.buckets[i2] = 0;
        }
    }

    private static int estimateBlackPoint(int[] iArr) throws NotFoundException {
        int i;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (i = 0; i < length; i++) {
            if (iArr[i] > i2) {
                i2 = iArr[i];
                i3 = i;
            }
            if (iArr[i] > i4) {
                i4 = iArr[i];
            }
        }
        i = 0;
        i2 = 0;
        int i5 = 0;
        while (i < length) {
            int i6 = i - i3;
            i6 *= iArr[i] * i6;
            if (i6 > i5) {
                i2 = i;
            } else {
                i6 = i5;
            }
            i++;
            i5 = i6;
        }
        if (i3 <= i2) {
            int i7 = i2;
            i2 = i3;
            i3 = i7;
        }
        if (i3 - i2 <= length / 16) {
            throw NotFoundException.getNotFoundInstance();
        }
        length = i3 - 1;
        i6 = -1;
        i5 = i3 - 1;
        while (i5 > i2) {
            i = i5 - i2;
            i = ((i * i) * (i3 - i5)) * (i4 - iArr[i5]);
            if (i > i6) {
                i6 = i5;
            } else {
                i = i6;
                i6 = length;
            }
            i5--;
            length = i6;
            i6 = i;
        }
        return length << 3;
    }
}
