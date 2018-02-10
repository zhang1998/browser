package com.uc.base.b.c.b;

import android.util.Log;
import com.uc.base.b.b.a;
import com.uc.base.b.c.d;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public abstract class c extends i {
    public abstract i a(int i);

    public abstract m a();

    public abstract boolean a(m mVar);

    public abstract boolean b(m mVar);

    public final byte[] l_() {
        m a = a();
        a(a);
        return b.a(a);
    }

    public final boolean a(d dVar) {
        if (dVar == null) {
            return false;
        }
        return a(dVar.b);
    }

    public final boolean a(byte[] bArr) {
        boolean z = false;
        if (bArr != null) {
            m a = a();
            if (d.a(bArr, a)) {
                try {
                    z = b(a);
                } catch (Throwable e) {
                    Log.e("Bean", "parse struct exception", e);
                    a.a("parse struct exception" + e.getMessage());
                }
            }
        }
        return z;
    }
}
