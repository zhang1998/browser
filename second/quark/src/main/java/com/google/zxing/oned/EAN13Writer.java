package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* compiled from: ProGuard */
public final class EAN13Writer extends UPCEANWriter {
    private static final int CODE_WIDTH = 95;

    public final BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_13) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got " + barcodeFormat);
    }

    public final boolean[] encode(String str) {
        int i;
        int length = str.length();
        switch (length) {
            case 12:
                try {
                    str = str + UPCEANReader.getStandardUPCEANChecksum(str);
                    break;
                } catch (Throwable e) {
                    throw new IllegalArgumentException(e);
                }
            case 13:
                try {
                    if (!UPCEANReader.checkStandardUPCEANChecksum(str)) {
                        throw new IllegalArgumentException("Contents do not pass checksum");
                    }
                } catch (FormatException e2) {
                    throw new IllegalArgumentException("Illegal contents");
                }
                break;
            default:
                throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got " + length);
        }
        int i2 = EAN13Reader.FIRST_DIGIT_ENCODINGS[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int appendPattern = OneDimensionalCodeWriter.appendPattern(zArr, 0, UPCEANReader.START_END_PATTERN, true) + 0;
        for (i = 1; i <= 6; i++) {
            length = Character.digit(str.charAt(i), 10);
            if (((i2 >> (6 - i)) & 1) == 1) {
                length += 10;
            }
            appendPattern += OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, UPCEANReader.L_AND_G_PATTERNS[length], false);
        }
        i = appendPattern + OneDimensionalCodeWriter.appendPattern(zArr, appendPattern, UPCEANReader.MIDDLE_PATTERN, false);
        for (length = 7; length <= 12; length++) {
            i += OneDimensionalCodeWriter.appendPattern(zArr, i, UPCEANReader.L_PATTERNS[Character.digit(str.charAt(length), 10)], true);
        }
        OneDimensionalCodeWriter.appendPattern(zArr, i, UPCEANReader.START_END_PATTERN, true);
        return zArr;
    }
}
