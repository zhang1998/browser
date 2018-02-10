package com.ucpro.feature.lightapp.d.b;

import com.uc.base.b.c.a;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public class h extends a {
    protected static final int a = a.a(-1961777970, h.class);
    private static h c = new h();
    public String b;

    public final byte k_() {
        return (byte) 2;
    }

    protected final m a() {
        return new m(i.w ? "UserToken" : "", a);
    }

    protected final boolean a(m mVar) {
        if (this.b != null) {
            mVar.a(1, i.w ? "userToken" : "", this.b);
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
        switch (a.b(i)) {
            case 1:
                if (i == a) {
                    return new h();
                }
                break;
        }
        return null;
    }
}
