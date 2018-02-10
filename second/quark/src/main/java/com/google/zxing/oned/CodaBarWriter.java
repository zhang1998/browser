package com.google.zxing.oned;

/* compiled from: ProGuard */
public final class CodaBarWriter extends OneDimensionalCodeWriter {
    private static final char[] ALT_START_END_CHARS = new char[]{'T', 'N', '*', 'E'};
    private static final char[] CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED = new char[]{'/', ':', '+', '.'};
    private static final char DEFAULT_GUARD = START_END_CHARS[0];
    private static final char[] START_END_CHARS = new char[]{'A', 'B', 'C', 'D'};

    public final boolean[] encode(String str) {
        if (str.length() < 2) {
            str = DEFAULT_GUARD + str + DEFAULT_GUARD;
        } else {
            char toUpperCase = Character.toUpperCase(str.charAt(0));
            char toUpperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            boolean arrayContains = CodaBarReader.arrayContains(START_END_CHARS, toUpperCase);
            boolean arrayContains2 = CodaBarReader.arrayContains(START_END_CHARS, toUpperCase2);
            boolean arrayContains3 = CodaBarReader.arrayContains(ALT_START_END_CHARS, toUpperCase);
            boolean arrayContains4 = CodaBarReader.arrayContains(ALT_START_END_CHARS, toUpperCase2);
            if (arrayContains) {
                if (!arrayContains2) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
            } else if (arrayContains3) {
                if (!arrayContains4) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
            } else if (arrayContains2 || arrayContains4) {
                throw new IllegalArgumentException("Invalid start/end guards: " + str);
            } else {
                str = DEFAULT_GUARD + str + DEFAULT_GUARD;
            }
        }
        int i = 20;
        int i2 = 1;
        while (i2 < str.length() - 1) {
            if (Character.isDigit(str.charAt(i2)) || str.charAt(i2) == '-' || str.charAt(i2) == '$') {
                i += 9;
            } else if (CodaBarReader.arrayContains(CHARS_WHICH_ARE_TEN_LENGTH_EACH_AFTER_DECODED, str.charAt(i2))) {
                i += 10;
            } else {
                throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i2) + '\'');
            }
            i2++;
        }
        boolean[] zArr = new boolean[((str.length() - 1) + i)];
        i2 = 0;
        i = 0;
        while (i2 < str.length()) {
            int i3;
            boolean z;
            int i4;
            char toUpperCase3 = Character.toUpperCase(str.charAt(i2));
            if (i2 == 0 || i2 == str.length() - 1) {
                switch (toUpperCase3) {
                    case '*':
                        toUpperCase3 = 'C';
                        break;
                    case 'E':
                        toUpperCase3 = 'D';
                        break;
                    case 'N':
                        toUpperCase3 = 'B';
                        break;
                    case 'T':
                        toUpperCase3 = 'A';
                        break;
                }
            }
            int i5 = 0;
            while (i5 < CodaBarReader.ALPHABET.length) {
                int i6;
                if (toUpperCase3 == CodaBarReader.ALPHABET[i5]) {
                    i3 = CodaBarReader.CHARACTER_ENCODINGS[i5];
                    i5 = 0;
                    z = true;
                    i4 = 0;
                    while (i5 < 7) {
                        zArr[i] = z;
                        i6 = i + 1;
                        if (((i3 >> (6 - i5)) & 1) != 0 || i4 == 1) {
                            i5++;
                            z = z;
                            i4 = 0;
                            i = i6;
                        } else {
                            i4++;
                            i = i6;
                        }
                    }
                    if (i2 < str.length() - 1) {
                        zArr[i] = false;
                        i++;
                    }
                    i2++;
                } else {
                    i5++;
                }
            }
            i3 = 0;
            i5 = 0;
            z = true;
            i4 = 0;
            while (i5 < 7) {
                zArr[i] = z;
                i6 = i + 1;
                if (((i3 >> (6 - i5)) & 1) != 0) {
                }
                if (z) {
                }
                i5++;
                z = z;
                i4 = 0;
                i = i6;
            }
            if (i2 < str.length() - 1) {
                zArr[i] = false;
                i++;
            }
            i2++;
        }
        return zArr;
    }
}
