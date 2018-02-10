package com.ucpro.business.e.b.a;

import com.uc.base.b.c.a.b;
import com.uc.encrypt.a;
import com.uc.encrypt.f;

/* compiled from: ProGuard */
final class c implements b {
    byte a;

    public c(byte b) {
        this.a = b;
    }

    public final byte[] a(byte[] bArr) {
        return f.a(bArr, a.b);
    }

    public final byte[] b(byte[] bArr) {
        return f.b(bArr, a.b);
    }

    public final byte[] a(byte[] bArr, int i) {
        if (i >= bArr.length) {
            return null;
        }
        if (i > 0) {
            Object obj = new byte[(bArr.length - i)];
            System.arraycopy(bArr, i, obj, 0, obj.length);
            bArr = obj;
        }
        return f.b(bArr, a.b);
    }

    public final com.uc.base.b.c.a.c a(byte[] bArr, byte b) {
        return com.uc.base.b.c.a.c.a(f.a(bArr, a.b), b, (byte) 2, this.a);
    }
}
