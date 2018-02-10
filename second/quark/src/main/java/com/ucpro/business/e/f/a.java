package com.ucpro.business.e.f;

import com.uc.a.d.e;
import com.ucpro.base.system.b;

/* compiled from: ProGuard */
public final class a extends e {
    public static byte[] b(com.uc.a.b.e eVar) {
        boolean z = true;
        if (eVar == null) {
            return null;
        }
        byte[] d = eVar.d();
        if (d == null || d.length == 0) {
            return null;
        }
        boolean z2;
        if (eVar.c == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (eVar.b != 1) {
            z = false;
        }
        if (z2 || z) {
            return b.a.a(z2, z, d);
        }
        return d;
    }
}
