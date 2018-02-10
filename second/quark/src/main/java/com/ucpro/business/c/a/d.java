package com.ucpro.business.c.a;

import com.uc.base.b.c.a;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public class d extends a {
    protected static final int a = a.a(-1077546843, d.class);
    private static d d = new d();
    public String b;
    public String c;

    public final byte k_() {
        return (byte) 2;
    }

    public static d c() {
        return d;
    }

    protected final m a() {
        return new m(i.w ? "KeyValueItem" : "", a);
    }

    protected final boolean a(m mVar) {
        if (this.b != null) {
            mVar.a(1, i.w ? "key" : "", this.b);
        }
        if (this.c != null) {
            mVar.a(2, i.w ? "value" : "", this.c);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        if (mVar == null) {
            return true;
        }
        if (mVar.b > a) {
            do {
                mVar = mVar.g;
                if (mVar == null) {
                    return false;
                }
            } while (mVar.b != a);
        }
        this.b = mVar.b(1);
        this.c = mVar.b(2);
        return true;
    }

    protected final i a(int i) {
        switch (a.b(i)) {
            case 1:
                if (i == a) {
                    return new d();
                }
                break;
        }
        return null;
    }
}
