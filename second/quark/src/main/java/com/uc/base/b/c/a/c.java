package com.uc.base.b.c.a;

/* compiled from: ProGuard */
public final class c {
    public static final byte[] a = new byte[]{(byte) 117, (byte) 99, (byte) 109, (byte) 100};
    public byte b = (byte) 1;
    public byte c = (byte) 0;
    public byte d = (byte) 0;
    public byte e = (byte) 0;
    public byte[] f = null;

    public static c a(byte[] bArr, byte b, byte b2, byte b3) {
        c cVar = new c();
        cVar.b = b;
        if (b2 >= (byte) 0) {
            cVar.d = b2;
        }
        cVar.e = b3;
        cVar.f = bArr;
        return cVar;
    }

    public static boolean a(byte[] bArr) {
        if (bArr.length > 16 && bArr[0] == a[0] && bArr[1] == a[1] && bArr[2] == a[2] && bArr[3] == a[3]) {
            return true;
        }
        return false;
    }

    public static byte b(byte[] bArr) {
        if (bArr == null || bArr.length <= 16) {
            return (byte) 1;
        }
        return bArr[4];
    }

    public static byte c(byte[] bArr) {
        if (bArr.length <= 16) {
            return (byte) 0;
        }
        switch (bArr[6]) {
            case (byte) 0:
                return (byte) 0;
            case (byte) 1:
                return (byte) 1;
            case (byte) 2:
                return (byte) 2;
            case (byte) 3:
                return (byte) 3;
            default:
                return (byte) -1;
        }
    }

    public static byte d(byte[] bArr) {
        if (bArr.length <= 16) {
            return (byte) -1;
        }
        return bArr[7];
    }
}
