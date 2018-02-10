package com.uc.a.d;

import com.uc.a.c;
import com.uc.base.b.c.c.a;

/* compiled from: ProGuard */
public class e {
    public static byte[] a(com.uc.a.b.e eVar) {
        Object obj = 1;
        if (eVar == null) {
            return null;
        }
        byte[] d = eVar.d();
        if (d == null || d.length == 0) {
            return null;
        }
        Object obj2;
        byte[] a;
        if (eVar.c == 1) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (eVar.b != 1) {
            obj = null;
        }
        if (obj2 != null) {
            a = c.a(d, (byte) 2);
            if (a == null) {
                return null;
            }
        }
        a = d;
        if (obj != null) {
            return a.a(a);
        }
        return a;
    }

    public static boolean a(byte[] bArr, com.uc.base.b.c.b.c cVar) {
        if (bArr == null) {
            return false;
        }
        return cVar.a(bArr);
    }
}
