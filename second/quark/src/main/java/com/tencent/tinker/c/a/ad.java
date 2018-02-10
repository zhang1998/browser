package com.tencent.tinker.c.a;

/* compiled from: ProGuard */
public final class ad {
    public static void a(byte[] bArr, int i, String str) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3;
            char charAt = str.charAt(i2);
            if (charAt != '\u0000' && charAt <= '') {
                i3 = i + 1;
                bArr[i] = (byte) charAt;
            } else if (charAt <= '߿') {
                r4 = i + 1;
                bArr[i] = (byte) (((charAt >> 6) & 31) | 192);
                i3 = r4 + 1;
                bArr[r4] = (byte) ((charAt & 63) | 128);
            } else {
                i3 = i + 1;
                bArr[i] = (byte) (((charAt >> 12) & 15) | 224);
                r4 = i3 + 1;
                bArr[i3] = (byte) (((charAt >> 6) & 63) | 128);
                i3 = r4 + 1;
                bArr[r4] = (byte) ((charAt & 63) | 128);
            }
            i2++;
            i = i3;
        }
    }
}
