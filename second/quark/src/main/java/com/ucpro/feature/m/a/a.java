package com.ucpro.feature.m.a;

import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public class a extends com.uc.base.b.c.a {
    protected static final int a = com.uc.base.b.c.a.a(-1899656478, a.class);
    private static a c = new a();
    public String b;

    public final byte k_() {
        return (byte) 2;
    }

    public static a c() {
        return c;
    }

    protected final m a() {
        return new m(i.w ? "RecoverInfoBean" : "", a);
    }

    protected final boolean a(m mVar) {
        if (this.b != null) {
            mVar.a(1, i.w ? "url" : "", this.b);
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
        return true;
    }

    protected final i a(int i) {
        switch (com.uc.base.b.c.a.b(i)) {
            case 1:
                if (i == a) {
                    return new a();
                }
                break;
        }
        return null;
    }
}
