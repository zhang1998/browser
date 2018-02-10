package com.ucpro.business.e.b.a;

import android.util.Log;
import com.uc.base.b.c.a.b;
import com.uc.base.b.c.a.c;

/* compiled from: ProGuard */
final class a implements b {
    public static final int[] a = new int[]{126, 147, 115, 241, 101, 198, 215, 134};
    public static final int[] b = new int[]{125, 185, 233, 226, 129, 142, 151, 176};
    public static final int[] c = new int[]{238, 185, 233, 179, 129, 142, 151, 167};
    private byte d = (byte) 3;
    private int[] e;

    public a(byte b) {
        int[] iArr;
        this.d = b;
        if (b == (byte) 3 || b == (byte) 0) {
            iArr = a;
        } else if (b == (byte) 2) {
            iArr = b;
        } else if (b == (byte) 1) {
            iArr = c;
        } else {
            iArr = null;
        }
        this.e = iArr;
    }

    private static byte[] a(byte[] bArr, int i, int[] iArr) {
        if (i < 0 || bArr == null || bArr.length - i < 2 || iArr == null || iArr.length != 8) {
            return null;
        }
        int length = (bArr.length - 2) - i;
        try {
            byte[] bArr2 = new byte[length];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                byte b = (byte) (bArr[i3 + i] ^ iArr[i3 % 8]);
                bArr2[i3] = b;
                i2 = (byte) (i2 ^ b);
            }
            if (bArr[length + i] == ((byte) ((iArr[0] ^ i2) & 255)) && bArr[(length + 1) + i] == ((byte) ((iArr[1] ^ i2) & 255))) {
                return bArr2;
            }
            return null;
        } catch (Throwable e) {
            com.uc.base.b.b.a.a((e.toString() + ", stacktrace:\n" + Log.getStackTraceString(e)) + "m8 decode fail, please check if the size of file is too large!");
            return null;
        }
    }

    private static byte[] a(byte[] bArr, int[] iArr) {
        byte[] bArr2 = null;
        if (!(bArr == null || iArr == null || iArr.length != 8)) {
            int length = bArr.length;
            try {
                bArr2 = new byte[(length + 2)];
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    byte b = bArr[i2];
                    bArr2[i2] = (byte) (iArr[i2 % 8] ^ b);
                    i = (byte) (i ^ b);
                }
                bArr2[length] = (byte) (iArr[0] ^ i);
                bArr2[length + 1] = (byte) (iArr[1] ^ i);
            } catch (Throwable e) {
                if (com.uc.base.b.b.a.a()) {
                    com.uc.base.b.b.a.a((e.toString() + ", stacktrace:\n" + Log.getStackTraceString(e)) + "m8 encode fail, please check if the size of file is too large!");
                }
            }
        }
        return bArr2;
    }

    public final byte[] a(byte[] bArr) {
        return a(bArr, this.e);
    }

    public final byte[] a(byte[] bArr, int i) {
        return a(bArr, i, this.e);
    }

    public final byte[] b(byte[] bArr) {
        return a(bArr, 0);
    }

    public final c a(byte[] bArr, byte b) {
        return c.a(a(bArr), b, (byte) 1, this.d);
    }
}
