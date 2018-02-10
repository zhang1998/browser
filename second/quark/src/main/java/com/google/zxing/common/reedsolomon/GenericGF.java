package com.google.zxing.common.reedsolomon;

import com.alibaba.wireless.security.SecExceptionCode;
import com.uc.crashsdk.export.LogType;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class GenericGF {
    public static final GenericGF AZTEC_DATA_10 = new GenericGF(1033, 1024, 1);
    public static final GenericGF AZTEC_DATA_12 = new GenericGF(4201, SpdyProtocol.SLIGHTSSL_0_RTT_MODE, 1);
    public static final GenericGF AZTEC_DATA_6 = new GenericGF(67, 64, 1);
    public static final GenericGF AZTEC_DATA_8;
    public static final GenericGF AZTEC_PARAM = new GenericGF(19, 16, 1);
    public static final GenericGF DATA_MATRIX_FIELD_256;
    public static final GenericGF MAXICODE_FIELD_64 = AZTEC_DATA_6;
    public static final GenericGF QR_CODE_FIELD_256 = new GenericGF(285, LogType.UNEXP, 0);
    private final int[] expTable;
    private final int generatorBase;
    private final int[] logTable;
    private final GenericGFPoly one;
    private final int primitive;
    private final int size;
    private final GenericGFPoly zero;

    static {
        GenericGF genericGF = new GenericGF(SecExceptionCode.SEC_ERROR_STA_INVALID_PARAM, LogType.UNEXP, 1);
        DATA_MATRIX_FIELD_256 = genericGF;
        AZTEC_DATA_8 = genericGF;
    }

    public GenericGF(int i, int i2, int i3) {
        this.primitive = i;
        this.size = i2;
        this.generatorBase = i3;
        this.expTable = new int[i2];
        this.logTable = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.expTable[i5] = i4;
            i4 *= 2;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (i4 = 0; i4 < i2 - 1; i4++) {
            this.logTable[this.expTable[i4]] = i4;
        }
        this.zero = new GenericGFPoly(this, new int[]{0});
        this.one = new GenericGFPoly(this, new int[]{1});
    }

    final GenericGFPoly getZero() {
        return this.zero;
    }

    final GenericGFPoly getOne() {
        return this.one;
    }

    final GenericGFPoly buildMonomial(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.zero;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new GenericGFPoly(this, iArr);
        }
    }

    static int addOrSubtract(int i, int i2) {
        return i ^ i2;
    }

    final int exp(int i) {
        return this.expTable[i];
    }

    final int log(int i) {
        if (i != 0) {
            return this.logTable[i];
        }
        throw new IllegalArgumentException();
    }

    final int inverse(int i) {
        if (i != 0) {
            return this.expTable[(this.size - this.logTable[i]) - 1];
        }
        throw new ArithmeticException();
    }

    final int multiply(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        return this.expTable[(this.logTable[i] + this.logTable[i2]) % (this.size - 1)];
    }

    public final int getSize() {
        return this.size;
    }

    public final int getGeneratorBase() {
        return this.generatorBase;
    }

    public final String toString() {
        return "GF(0x" + Integer.toHexString(this.primitive) + ',' + this.size + ')';
    }
}
