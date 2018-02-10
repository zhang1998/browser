package com.uc.a;

import com.uc.base.b.b.a;
import com.uc.base.b.c.a.b;
import java.io.ByteArrayOutputStream;

/* compiled from: ProGuard */
public final class c {
    public static byte[] a(byte[] bArr, byte b) {
        b a = a.a(b, (byte) 0);
        if (a != null) {
            return a.b(bArr);
        }
        throw new RuntimeException("can not get decrypt handler for type: " + b);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] toByteArray;
        Throwable th;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(bArr);
            if (bArr2 != null) {
                byteArrayOutputStream.write(bArr2);
            }
            toByteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th = th2;
                a.a(th);
                return toByteArray;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            toByteArray = null;
            th = th4;
            a.a(th);
            return toByteArray;
        }
        return toByteArray;
    }
}
