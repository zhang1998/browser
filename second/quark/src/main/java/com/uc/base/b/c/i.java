package com.uc.base.b.c;

import com.uc.base.b.b.a;
import com.uc.base.b.b.b;

/* compiled from: ProGuard */
public abstract class i {
    public static final boolean w;

    public abstract i a(int i);

    public abstract m a();

    public abstract boolean a(d dVar);

    public abstract boolean a(m mVar);

    public abstract boolean b(m mVar);

    public abstract byte[] l_();

    public byte k_() {
        return (byte) 1;
    }

    public String toString() {
        if (!w) {
            return getClass().getName() + "@" + Integer.toHexString(hashCode());
        }
        m a = a();
        a(a);
        return a.toString();
    }

    public final i a(m mVar, int i) {
        if (mVar != null) {
            m mVar2 = (m) mVar.h(i);
            if (mVar2 != null && mVar2.o()) {
                i a = a(mVar2.b);
                if (a != null) {
                    a.b(mVar2);
                }
                return a;
            }
        }
        return null;
    }

    static {
        int c;
        boolean z;
        if (a.a != null) {
            c = b.c();
        } else {
            c = 4;
        }
        if (c == 0) {
            z = true;
        } else {
            z = false;
        }
        w = z;
    }
}
