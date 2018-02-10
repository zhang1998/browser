package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* compiled from: ProGuard */
public class Code93Writer extends OneDimensionalCodeWriter {
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_93) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_93, but got " + barcodeFormat);
    }

    public boolean[] encode(String str) {
        int i = 0;
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        int[] iArr = new int[9];
        boolean[] zArr = new boolean[((((str.length() + 2) + 2) * 9) + 1)];
        toIntArray(Code93Reader.CHARACTER_ENCODINGS[47], iArr);
        int appendPattern = appendPattern(zArr, 0, iArr, true);
        while (i < length) {
            toIntArray(Code93Reader.CHARACTER_ENCODINGS["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i))], iArr);
            appendPattern += appendPattern(zArr, appendPattern, iArr, true);
            i++;
        }
        i = computeChecksumIndex(str, 20);
        toIntArray(Code93Reader.CHARACTER_ENCODINGS[i], iArr);
        appendPattern += appendPattern(zArr, appendPattern, iArr, true);
        toIntArray(Code93Reader.CHARACTER_ENCODINGS[computeChecksumIndex(str + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(i), 15)], iArr);
        i = appendPattern(zArr, appendPattern, iArr, true) + appendPattern;
        toIntArray(Code93Reader.CHARACTER_ENCODINGS[47], iArr);
        zArr[i + appendPattern(zArr, i, iArr, true)] = true;
        return zArr;
    }

    private static void toIntArray(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3;
            if (((1 << (8 - i2)) & i) == 0) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            iArr[i2] = i3;
        }
    }

    protected static int appendPattern(boolean[] zArr, int i, int[] iArr, boolean z) {
        int length = iArr.length;
        int i2 = 0;
        while (i2 < length) {
            boolean z2;
            int i3 = i + 1;
            if (iArr[i2] != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            zArr[i] = z2;
            i2++;
            i = i3;
        }
        return 9;
    }

    private static int computeChecksumIndex(String str, int i) {
        int i2 = 1;
        int length = str.length() - 1;
        int i3 = 0;
        while (length >= 0) {
            int indexOf = ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i2) + i3;
            i3 = i2 + 1;
            if (i3 > i) {
                i3 = 1;
            }
            length--;
            i2 = i3;
            i3 = indexOf;
        }
        return i3 % 47;
    }
}
