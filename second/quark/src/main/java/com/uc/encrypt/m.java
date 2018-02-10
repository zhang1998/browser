package com.uc.encrypt;

/* compiled from: ProGuard */
final class m extends g {
    public static final int[] b = new int[]{126, 147, 115, 241, 101, 198, 215, 134};
    public static final int[] c = new int[]{125, 185, 233, 226, 129, 142, 151, 176};
    public static final int[] d = new int[]{238, 185, 233, 179, 129, 142, 151, 167};

    public static byte[] a(byte[] bArr, int[] iArr) {
        return c(bArr, iArr);
    }

    private static byte[] c(byte[] bArr, int[] iArr) {
        if (bArr == null || bArr.length + 0 < 2 || iArr == null || iArr.length != 8) {
            return null;
        }
        int length = (bArr.length - 2) + 0;
        try {
            byte[] bArr2 = new byte[length];
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                byte b = (byte) (bArr[i2 + 0] ^ iArr[i2 % 8]);
                bArr2[i2] = b;
                i = (byte) (i ^ b);
            }
            if (bArr[length + 0] == ((byte) ((iArr[0] ^ i) & 255)) && bArr[(length + 1) + 0] == ((byte) ((iArr[1] ^ i) & 255))) {
                return bArr2;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] b(byte[] bArr, int[] iArr) {
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
            } catch (Exception e) {
            }
        }
        return bArr2;
    }
}
