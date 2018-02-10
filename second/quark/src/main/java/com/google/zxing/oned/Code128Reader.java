package com.google.zxing.oned;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* compiled from: ProGuard */
public final class Code128Reader extends OneDReader {
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    static final int[][] CODE_PATTERNS = new int[][]{new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};
    private static final int CODE_SHIFT = 98;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final float MAX_AVG_VARIANCE = 0.25f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;

    private static int[] findStartPattern(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int i = 0;
        Object obj = new int[6];
        int i2 = 0;
        int i3 = nextSet;
        while (i3 < size) {
            int i4;
            int i5;
            if ((bitArray.get(i3) ^ i2) != 0) {
                obj[i] = obj[i] + 1;
                i4 = i2;
                i5 = i;
            } else {
                int i6;
                if (i == 5) {
                    float f = MAX_AVG_VARIANCE;
                    i6 = -1;
                    i5 = 103;
                    while (i5 <= 105) {
                        float patternMatchVariance = OneDReader.patternMatchVariance(obj, CODE_PATTERNS[i5], MAX_INDIVIDUAL_VARIANCE);
                        if (patternMatchVariance < f) {
                            i6 = i5;
                        } else {
                            patternMatchVariance = f;
                        }
                        i5++;
                        f = patternMatchVariance;
                    }
                    if (i6 < 0 || !bitArray.isRange(Math.max(0, nextSet - ((i3 - nextSet) / 2)), nextSet, false)) {
                        i6 = (obj[0] + obj[1]) + nextSet;
                        System.arraycopy(obj, 2, obj, 0, 4);
                        obj[4] = null;
                        obj[5] = null;
                        i5 = i - 1;
                    } else {
                        return new int[]{nextSet, i3, i6};
                    }
                }
                i5 = i + 1;
                i6 = nextSet;
                obj[i5] = 1;
                i4 = i2 == 0 ? 1 : 0;
                nextSet = i6;
            }
            i2 = i4;
            i = i5;
            i3++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int decodeCode(BitArray bitArray, int[] iArr, int i) throws NotFoundException {
        OneDReader.recordPattern(bitArray, i, iArr);
        float f = MAX_AVG_VARIANCE;
        int i2 = -1;
        for (int i3 = 0; i3 < CODE_PATTERNS.length; i3++) {
            float patternMatchVariance = OneDReader.patternMatchVariance(iArr, CODE_PATTERNS[i3], MAX_INDIVIDUAL_VARIANCE);
            if (patternMatchVariance < f) {
                i2 = i3;
                f = patternMatchVariance;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.zxing.Result decodeRow(int r24, com.google.zxing.common.BitArray r25, java.util.Map<com.google.zxing.DecodeHintType, ?> r26) throws com.google.zxing.NotFoundException, com.google.zxing.FormatException, com.google.zxing.ChecksumException {
        /*
        r23 = this;
        if (r26 == 0) goto L_0x002f;
    L_0x0002:
        r2 = com.google.zxing.DecodeHintType.ASSUME_GS1;
        r0 = r26;
        r2 = r0.containsKey(r2);
        if (r2 == 0) goto L_0x002f;
    L_0x000c:
        r2 = 1;
    L_0x000d:
        r17 = findStartPattern(r25);
        r3 = 2;
        r12 = r17[r3];
        r18 = new java.util.ArrayList;
        r3 = 20;
        r0 = r18;
        r0.<init>(r3);
        r3 = (byte) r12;
        r3 = java.lang.Byte.valueOf(r3);
        r0 = r18;
        r0.add(r3);
        switch(r12) {
            case 103: goto L_0x0031;
            case 104: goto L_0x008d;
            case 105: goto L_0x0090;
            default: goto L_0x002a;
        };
    L_0x002a:
        r2 = com.google.zxing.FormatException.getFormatInstance();
        throw r2;
    L_0x002f:
        r2 = 0;
        goto L_0x000d;
    L_0x0031:
        r3 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
    L_0x0033:
        r11 = 0;
        r10 = 0;
        r19 = new java.lang.StringBuilder;
        r4 = 20;
        r0 = r19;
        r0.<init>(r4);
        r4 = 0;
        r9 = r17[r4];
        r4 = 1;
        r13 = r17[r4];
        r4 = 6;
        r0 = new int[r4];
        r20 = r0;
        r14 = 0;
        r5 = 0;
        r4 = 0;
        r8 = 1;
        r7 = 0;
        r6 = 0;
        r16 = r10;
        r10 = r3;
        r3 = r4;
        r4 = r12;
        r22 = r14;
        r14 = r5;
        r5 = r11;
        r11 = r9;
        r9 = r22;
    L_0x005b:
        if (r5 != 0) goto L_0x026f;
    L_0x005d:
        r9 = 0;
        r0 = r25;
        r1 = r20;
        r15 = decodeCode(r0, r1, r13);
        r11 = (byte) r15;
        r11 = java.lang.Byte.valueOf(r11);
        r0 = r18;
        r0.add(r11);
        r11 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        if (r15 == r11) goto L_0x0075;
    L_0x0074:
        r8 = 1;
    L_0x0075:
        r11 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        if (r15 == r11) goto L_0x007e;
    L_0x0079:
        r3 = r3 + 1;
        r11 = r3 * r15;
        r4 = r4 + r11;
    L_0x007e:
        r11 = 0;
        r12 = r13;
    L_0x0080:
        r21 = 6;
        r0 = r21;
        if (r11 >= r0) goto L_0x0093;
    L_0x0086:
        r21 = r20[r11];
        r12 = r12 + r21;
        r11 = r11 + 1;
        goto L_0x0080;
    L_0x008d:
        r3 = 100;
        goto L_0x0033;
    L_0x0090:
        r3 = 99;
        goto L_0x0033;
    L_0x0093:
        switch(r15) {
            case 103: goto L_0x00b2;
            case 104: goto L_0x00b2;
            case 105: goto L_0x00b2;
            default: goto L_0x0096;
        };
    L_0x0096:
        switch(r10) {
            case 99: goto L_0x0208;
            case 100: goto L_0x016d;
            case 101: goto L_0x00b7;
            default: goto L_0x0099;
        };
    L_0x0099:
        r22 = r5;
        r5 = r10;
        r10 = r22;
    L_0x009e:
        if (r16 == 0) goto L_0x00a6;
    L_0x00a0:
        r11 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r5 != r11) goto L_0x026b;
    L_0x00a4:
        r5 = 100;
    L_0x00a6:
        r11 = r13;
        r16 = r9;
        r13 = r12;
        r9 = r14;
        r14 = r15;
        r22 = r10;
        r10 = r5;
        r5 = r22;
        goto L_0x005b;
    L_0x00b2:
        r2 = com.google.zxing.FormatException.getFormatInstance();
        throw r2;
    L_0x00b7:
        r11 = 64;
        if (r15 >= r11) goto L_0x00d7;
    L_0x00bb:
        if (r6 != r7) goto L_0x00cc;
    L_0x00bd:
        r6 = r15 + 32;
        r6 = (char) r6;
        r0 = r19;
        r0.append(r6);
    L_0x00c5:
        r6 = 0;
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x00cc:
        r6 = r15 + 32;
        r6 = r6 + 128;
        r6 = (char) r6;
        r0 = r19;
        r0.append(r6);
        goto L_0x00c5;
    L_0x00d7:
        r11 = 96;
        if (r15 >= r11) goto L_0x00f5;
    L_0x00db:
        if (r6 != r7) goto L_0x00ec;
    L_0x00dd:
        r6 = r15 + -64;
        r6 = (char) r6;
        r0 = r19;
        r0.append(r6);
    L_0x00e5:
        r6 = 0;
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x00ec:
        r6 = r15 + 64;
        r6 = (char) r6;
        r0 = r19;
        r0.append(r6);
        goto L_0x00e5;
    L_0x00f5:
        r11 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        if (r15 == r11) goto L_0x00fa;
    L_0x00f9:
        r8 = 0;
    L_0x00fa:
        switch(r15) {
            case 96: goto L_0x0126;
            case 97: goto L_0x0126;
            case 98: goto L_0x014f;
            case 99: goto L_0x0162;
            case 100: goto L_0x0159;
            case 101: goto L_0x012d;
            case 102: goto L_0x0103;
            case 103: goto L_0x00fd;
            case 104: goto L_0x00fd;
            case 105: goto L_0x00fd;
            case 106: goto L_0x016b;
            default: goto L_0x00fd;
        };
    L_0x00fd:
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x0103:
        if (r2 == 0) goto L_0x00fd;
    L_0x0105:
        r11 = r19.length();
        if (r11 != 0) goto L_0x0118;
    L_0x010b:
        r11 = "]C1";
        r0 = r19;
        r0.append(r11);
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x0118:
        r11 = 29;
        r0 = r19;
        r0.append(r11);
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x0126:
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x012d:
        if (r7 != 0) goto L_0x013a;
    L_0x012f:
        if (r6 == 0) goto L_0x013a;
    L_0x0131:
        r7 = 1;
        r6 = 0;
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x013a:
        if (r7 == 0) goto L_0x0147;
    L_0x013c:
        if (r6 == 0) goto L_0x0147;
    L_0x013e:
        r7 = 0;
        r6 = 0;
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x0147:
        r6 = 1;
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x014f:
        r9 = 1;
        r10 = 100;
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x0159:
        r10 = 100;
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x0162:
        r10 = 99;
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x016b:
        r5 = 1;
        goto L_0x00fd;
    L_0x016d:
        r11 = 96;
        if (r15 >= r11) goto L_0x018e;
    L_0x0171:
        if (r6 != r7) goto L_0x0183;
    L_0x0173:
        r6 = r15 + 32;
        r6 = (char) r6;
        r0 = r19;
        r0.append(r6);
    L_0x017b:
        r6 = 0;
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x0183:
        r6 = r15 + 32;
        r6 = r6 + 128;
        r6 = (char) r6;
        r0 = r19;
        r0.append(r6);
        goto L_0x017b;
    L_0x018e:
        r11 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        if (r15 == r11) goto L_0x0193;
    L_0x0192:
        r8 = 0;
    L_0x0193:
        switch(r15) {
            case 96: goto L_0x01c1;
            case 97: goto L_0x01c1;
            case 98: goto L_0x01ea;
            case 99: goto L_0x01fd;
            case 100: goto L_0x01c8;
            case 101: goto L_0x01f4;
            case 102: goto L_0x019d;
            case 103: goto L_0x0196;
            case 104: goto L_0x0196;
            case 105: goto L_0x0196;
            case 106: goto L_0x0206;
            default: goto L_0x0196;
        };
    L_0x0196:
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x019d:
        if (r2 == 0) goto L_0x0196;
    L_0x019f:
        r11 = r19.length();
        if (r11 != 0) goto L_0x01b3;
    L_0x01a5:
        r11 = "]C1";
        r0 = r19;
        r0.append(r11);
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x01b3:
        r11 = 29;
        r0 = r19;
        r0.append(r11);
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x01c1:
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x01c8:
        if (r7 != 0) goto L_0x01d5;
    L_0x01ca:
        if (r6 == 0) goto L_0x01d5;
    L_0x01cc:
        r7 = 1;
        r6 = 0;
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x01d5:
        if (r7 == 0) goto L_0x01e2;
    L_0x01d7:
        if (r6 == 0) goto L_0x01e2;
    L_0x01d9:
        r7 = 0;
        r6 = 0;
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x01e2:
        r6 = 1;
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x01ea:
        r9 = 1;
        r10 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x01f4:
        r10 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x01fd:
        r10 = 99;
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x0206:
        r5 = 1;
        goto L_0x0196;
    L_0x0208:
        r11 = 100;
        if (r15 >= r11) goto L_0x0223;
    L_0x020c:
        r11 = 10;
        if (r15 >= r11) goto L_0x0217;
    L_0x0210:
        r11 = 48;
        r0 = r19;
        r0.append(r11);
    L_0x0217:
        r0 = r19;
        r0.append(r15);
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x0223:
        r11 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        if (r15 == r11) goto L_0x0228;
    L_0x0227:
        r8 = 0;
    L_0x0228:
        switch(r15) {
            case 100: goto L_0x022d;
            case 101: goto L_0x025a;
            case 102: goto L_0x0236;
            case 103: goto L_0x022b;
            case 104: goto L_0x022b;
            case 105: goto L_0x022b;
            case 106: goto L_0x0263;
            default: goto L_0x022b;
        };
    L_0x022b:
        goto L_0x0099;
    L_0x022d:
        r10 = 100;
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x0236:
        if (r2 == 0) goto L_0x0099;
    L_0x0238:
        r11 = r19.length();
        if (r11 != 0) goto L_0x024c;
    L_0x023e:
        r11 = "]C1";
        r0 = r19;
        r0.append(r11);
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x024c:
        r11 = 29;
        r0 = r19;
        r0.append(r11);
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x025a:
        r10 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x0263:
        r5 = 1;
        r22 = r5;
        r5 = r10;
        r10 = r22;
        goto L_0x009e;
    L_0x026b:
        r5 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        goto L_0x00a6;
    L_0x026f:
        r2 = r13 - r11;
        r0 = r25;
        r5 = r0.getNextUnset(r13);
        r6 = r25.getSize();
        r7 = r5 - r11;
        r7 = r7 / 2;
        r7 = r7 + r5;
        r6 = java.lang.Math.min(r6, r7);
        r7 = 0;
        r0 = r25;
        r5 = r0.isRange(r5, r6, r7);
        if (r5 != 0) goto L_0x0292;
    L_0x028d:
        r2 = com.google.zxing.NotFoundException.getNotFoundInstance();
        throw r2;
    L_0x0292:
        r3 = r3 * r9;
        r3 = r4 - r3;
        r3 = r3 % 103;
        if (r3 == r9) goto L_0x029e;
    L_0x0299:
        r2 = com.google.zxing.ChecksumException.getChecksumInstance();
        throw r2;
    L_0x029e:
        r3 = r19.length();
        if (r3 != 0) goto L_0x02a9;
    L_0x02a4:
        r2 = com.google.zxing.NotFoundException.getNotFoundInstance();
        throw r2;
    L_0x02a9:
        if (r3 <= 0) goto L_0x02b8;
    L_0x02ab:
        if (r8 == 0) goto L_0x02b8;
    L_0x02ad:
        r4 = 99;
        if (r10 != r4) goto L_0x02e7;
    L_0x02b1:
        r4 = r3 + -2;
        r0 = r19;
        r0.delete(r4, r3);
    L_0x02b8:
        r3 = 1;
        r3 = r17[r3];
        r4 = 0;
        r4 = r17[r4];
        r3 = r3 + r4;
        r3 = (float) r3;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r4 = r3 / r4;
        r3 = (float) r11;
        r2 = (float) r2;
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 / r5;
        r5 = r3 + r2;
        r6 = r18.size();
        r7 = new byte[r6];
        r2 = 0;
        r3 = r2;
    L_0x02d3:
        if (r3 >= r6) goto L_0x02ef;
    L_0x02d5:
        r0 = r18;
        r2 = r0.get(r3);
        r2 = (java.lang.Byte) r2;
        r2 = r2.byteValue();
        r7[r3] = r2;
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x02d3;
    L_0x02e7:
        r4 = r3 + -1;
        r0 = r19;
        r0.delete(r4, r3);
        goto L_0x02b8;
    L_0x02ef:
        r2 = new com.google.zxing.Result;
        r3 = r19.toString();
        r6 = 2;
        r6 = new com.google.zxing.ResultPoint[r6];
        r8 = 0;
        r9 = new com.google.zxing.ResultPoint;
        r0 = r24;
        r10 = (float) r0;
        r9.<init>(r4, r10);
        r6[r8] = r9;
        r4 = 1;
        r8 = new com.google.zxing.ResultPoint;
        r0 = r24;
        r9 = (float) r0;
        r8.<init>(r5, r9);
        r6[r4] = r8;
        r4 = com.google.zxing.BarcodeFormat.CODE_128;
        r2.<init>(r3, r7, r6, r4);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Reader.decodeRow(int, com.google.zxing.common.BitArray, java.util.Map):com.google.zxing.Result");
    }
}
