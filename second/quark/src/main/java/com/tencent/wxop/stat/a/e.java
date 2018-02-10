package com.tencent.wxop.stat.a;

import android.util.Base64;
import com.uc.crashsdk.export.LogType;

public final class e {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        int i = 0;
        int[] iArr = new int[LogType.UNEXP];
        int[] iArr2 = new int[LogType.UNEXP];
        int length = bArr2.length;
        if (length <= 0 || length > LogType.UNEXP) {
            throw new IllegalArgumentException("key must be between 1 and 256 bytes");
        }
        int i2;
        for (i2 = 0; i2 < LogType.UNEXP; i2++) {
            iArr[i2] = i2;
            iArr2[i2] = bArr2[i2 % length];
        }
        i2 = 0;
        for (length = 0; length < LogType.UNEXP; length++) {
            i2 = ((i2 + iArr[length]) + iArr2[length]) & 255;
            int i3 = iArr[length];
            iArr[length] = iArr[i2];
            iArr[i2] = i3;
        }
        byte[] bArr3 = new byte[bArr.length];
        i2 = 0;
        length = 0;
        while (i < bArr.length) {
            i2 = (i2 + 1) & 255;
            length = (length + iArr[i2]) & 255;
            i3 = iArr[i2];
            iArr[i2] = iArr[length];
            iArr[length] = i3;
            bArr3[i] = (byte) (iArr[(iArr[i2] + iArr[length]) & 255] ^ bArr[i]);
            i++;
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr) {
        return a(bArr, Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0));
    }

    public static byte[] b(byte[] bArr) {
        return a(bArr, Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0));
    }
}
