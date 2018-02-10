package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* compiled from: ProGuard */
public final class Code39Writer extends OneDimensionalCodeWriter {
    public final BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_39) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got " + barcodeFormat);
    }

    public final boolean[] encode(String str) {
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        int[] iArr = new int[9];
        int i = length + 25;
        int i2 = 0;
        while (i2 < length) {
            int indexOf = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(i2));
            if (indexOf < 0) {
                throw new IllegalArgumentException("Bad contents: " + str);
            }
            toIntArray(Code39Reader.CHARACTER_ENCODINGS[indexOf], iArr);
            indexOf = i;
            for (i = 0; i < 9; i++) {
                indexOf += iArr[i];
            }
            i2++;
            i = indexOf;
        }
        boolean[] zArr = new boolean[i];
        toIntArray(Code39Reader.ASTERISK_ENCODING, iArr);
        i = OneDimensionalCodeWriter.appendPattern(zArr, 0, iArr, true);
        int[] iArr2 = new int[]{1};
        i += OneDimensionalCodeWriter.appendPattern(zArr, i, iArr2, false);
        for (indexOf = 0; indexOf < length; indexOf++) {
            toIntArray(Code39Reader.CHARACTER_ENCODINGS["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(str.charAt(indexOf))], iArr);
            i += OneDimensionalCodeWriter.appendPattern(zArr, i, iArr, true);
            i += OneDimensionalCodeWriter.appendPattern(zArr, i, iArr2, false);
        }
        toIntArray(Code39Reader.ASTERISK_ENCODING, iArr);
        OneDimensionalCodeWriter.appendPattern(zArr, i, iArr, true);
        return zArr;
    }

    private static void toIntArray(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            iArr[i2] = ((1 << (8 - i2)) & i) == 0 ? 1 : 2;
        }
    }
}
