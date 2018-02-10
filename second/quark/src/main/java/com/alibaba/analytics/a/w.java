package com.alibaba.analytics.a;

import com.uc.crashsdk.export.LogType;

/* compiled from: ProGuard */
public final class w {
    public static byte[] a(byte[] bArr, String str) {
        if (bArr != null) {
            ai a = a(str);
            if (a != null) {
                if (bArr == null || a == null) {
                    return null;
                }
                int i = a.b;
                int i2 = a.c;
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    i = (i + 1) % LogType.UNEXP;
                    i2 = (i2 + a.a[i]) % LogType.UNEXP;
                    int i4 = a.a[i];
                    a.a[i] = a.a[i2];
                    a.a[i2] = i4;
                    i4 = (a.a[i] + a.a[i2]) % LogType.UNEXP;
                    bArr[i3] = (byte) (a.a[i4] ^ bArr[i3]);
                }
                a.b = i;
                a.c = i2;
                return bArr;
            }
        }
        return null;
    }

    private static ai a(String str) {
        int i = 0;
        if (str == null) {
            return null;
        }
        int i2;
        ai aiVar = new ai();
        for (i2 = 0; i2 < LogType.UNEXP; i2++) {
            aiVar.a[i2] = i2;
        }
        aiVar.b = 0;
        aiVar.c = 0;
        i2 = 0;
        int i3 = 0;
        while (i < LogType.UNEXP) {
            try {
                i2 = (i2 + (str.charAt(i3) + aiVar.a[i])) % LogType.UNEXP;
                int i4 = aiVar.a[i];
                aiVar.a[i] = aiVar.a[i2];
                aiVar.a[i2] = i4;
                i3 = (i3 + 1) % str.length();
                i++;
            } catch (Exception e) {
                return null;
            }
        }
        return aiVar;
    }
}
