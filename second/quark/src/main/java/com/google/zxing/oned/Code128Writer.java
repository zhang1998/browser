package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: ProGuard */
public final class Code128Writer extends OneDimensionalCodeWriter {
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_B = 100;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final char ESCAPE_FNC_1 = 'ñ';
    private static final char ESCAPE_FNC_2 = 'ò';
    private static final char ESCAPE_FNC_3 = 'ó';
    private static final char ESCAPE_FNC_4 = 'ô';

    /* compiled from: ProGuard */
    enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    public final BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.encode(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
    }

    public final boolean[] encode(String str) {
        int i = 0;
        int length = str.length();
        if (length <= 0 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
        }
        int i2;
        for (i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < ' ' || charAt > '~') {
                switch (charAt) {
                    case 'ñ':
                    case 'ò':
                    case 'ó':
                    case 'ô':
                        break;
                    default:
                        throw new IllegalArgumentException("Bad character in input: " + charAt);
                }
            }
        }
        Collection<int[]> arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        int i6 = 0;
        while (i3 < length) {
            int chooseCode = chooseCode(str, i3, i4);
            if (chooseCode == i4) {
                switch (str.charAt(i3)) {
                    case 'ñ':
                        i2 = 102;
                        break;
                    case 'ò':
                        i2 = 97;
                        break;
                    case 'ó':
                        i2 = 96;
                        break;
                    case 'ô':
                        i2 = 100;
                        break;
                    default:
                        if (i4 != 100) {
                            i2 = Integer.parseInt(str.substring(i3, i3 + 2));
                            i3++;
                            break;
                        }
                        i2 = str.charAt(i3) - 32;
                        break;
                }
                i3++;
                chooseCode = i4;
            } else {
                i2 = i4 == 0 ? chooseCode == 100 ? 104 : 105 : chooseCode;
            }
            arrayList.add(Code128Reader.CODE_PATTERNS[i2]);
            i4 = i6 + (i2 * i5);
            if (i3 != 0) {
                i2 = i5 + 1;
            } else {
                i2 = i5;
            }
            i5 = i2;
            i6 = i4;
            i4 = chooseCode;
        }
        arrayList.add(Code128Reader.CODE_PATTERNS[i6 % 103]);
        arrayList.add(Code128Reader.CODE_PATTERNS[106]);
        int i7 = 0;
        for (int[] iArr : arrayList) {
            for (int i52 : (int[]) r3.next()) {
                i7 += i52;
            }
        }
        boolean[] zArr = new boolean[i7];
        for (int[] appendPattern : arrayList) {
            i += OneDimensionalCodeWriter.appendPattern(zArr, i, appendPattern, true);
        }
        return zArr;
    }

    private static CType findCType(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i >= length) {
            return CType.UNCODABLE;
        }
        char charAt = charSequence.charAt(i);
        if (charAt == ESCAPE_FNC_1) {
            return CType.FNC_1;
        }
        if (charAt < '0' || charAt > '9') {
            return CType.UNCODABLE;
        }
        if (i + 1 >= length) {
            return CType.ONE_DIGIT;
        }
        char charAt2 = charSequence.charAt(i + 1);
        if (charAt2 < '0' || charAt2 > '9') {
            return CType.ONE_DIGIT;
        }
        return CType.TWO_DIGITS;
    }

    private static int chooseCode(CharSequence charSequence, int i, int i2) {
        CType findCType = findCType(charSequence, i);
        if (findCType == CType.UNCODABLE || findCType == CType.ONE_DIGIT) {
            return 100;
        }
        if (i2 == 99) {
            return 99;
        }
        if (i2 != 100) {
            if (findCType == CType.FNC_1) {
                findCType = findCType(charSequence, i + 1);
            }
            if (findCType == CType.TWO_DIGITS) {
                return 99;
            }
            return 100;
        } else if (findCType == CType.FNC_1) {
            return 100;
        } else {
            findCType = findCType(charSequence, i + 2);
            if (findCType == CType.UNCODABLE || findCType == CType.ONE_DIGIT) {
                return 100;
            }
            if (findCType != CType.FNC_1) {
                CType findCType2;
                int i3 = i + 4;
                while (true) {
                    findCType2 = findCType(charSequence, i3);
                    if (findCType2 != CType.TWO_DIGITS) {
                        break;
                    }
                    i3 += 2;
                }
                if (findCType2 == CType.ONE_DIGIT) {
                    return 100;
                }
                return 99;
            } else if (findCType(charSequence, i + 3) == CType.TWO_DIGITS) {
                return 99;
            } else {
                return 100;
            }
        }
    }
}
