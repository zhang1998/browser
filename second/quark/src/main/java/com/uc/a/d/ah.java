package com.uc.a.d;

import com.uc.base.b.c.a;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public class ah extends a {
    protected static final int a = a.a(-1534070861, ah.class);
    private static ah f = new ah();
    String b;
    String c;
    int d = 604800;
    int e;

    public final byte k_() {
        return (byte) 2;
    }

    public static ah c() {
        return f;
    }

    protected final m a() {
        return new m(i.w ? "ResItem" : "", a);
    }

    protected final boolean a(m mVar) {
        if (this.b != null) {
            mVar.a(1, i.w ? "resCode" : "", this.b);
        }
        if (this.c != null) {
            mVar.a(2, i.w ? "sumInfo" : "", this.c);
        }
        mVar.a(3, i.w ? "recycle" : "", this.d);
        mVar.a(4, i.w ? "lastUpdateTime" : "", this.e);
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
        this.d = mVar.b(3, 0);
        this.e = mVar.b(4, 0);
        return true;
    }

    protected final i a(int i) {
        switch (a.b(i)) {
            case 1:
                if (i == a) {
                    return new ah();
                }
                break;
        }
        return null;
    }
}
