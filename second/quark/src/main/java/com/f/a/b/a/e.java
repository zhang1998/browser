package com.f.a.b.a;

import com.uc.crashsdk.export.LogType;

/* compiled from: ProGuard */
public final class e {
    public static byte[] a(int i) {
        byte[] bArr = new byte[4];
        bArr[3] = (byte) (i % LogType.UNEXP);
        int i2 = i >> 8;
        bArr[2] = (byte) (i2 % LogType.UNEXP);
        i2 >>= 8;
        bArr[1] = (byte) (i2 % LogType.UNEXP);
        bArr[0] = (byte) ((i2 >> 8) % LogType.UNEXP);
        return bArr;
    }
}
