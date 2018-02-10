package com.alibaba.analytics.a;

/* compiled from: ProGuard */
public final class e {
    public static int a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        if (bArr == null || i < 0 || i2 < 0 || bArr.length < i + i2) {
            return 0;
        }
        int i4;
        byte[] bArr2 = new byte[i2];
        for (i4 = 0; i4 < i2; i4++) {
            bArr2[i4] = bArr[i];
            i++;
        }
        if (bArr2.length > 4) {
            return 0;
        }
        i4 = 0;
        while (i3 < bArr2.length) {
            i4 |= (bArr2[i3] & 255) << (((bArr2.length - i3) - 1) * 8);
            i3++;
        }
        return i4;
    }

    public static byte[] a(int i) {
        return new byte[]{(byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte[] b(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte[] b(byte[] bArr, int i, int i2) {
        if (bArr == null || i < 0 || i2 < 0 || bArr.length < i + i2) {
            return null;
        }
        byte[] bArr2 = new byte[i2];
        for (int i3 = i; i3 < i + i2; i3++) {
            bArr2[i3 - i] = bArr[i3];
        }
        return bArr2;
    }
}
