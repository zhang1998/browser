package com.ucpro.feature.z.g.b;

import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public class a extends com.uc.base.b.c.a {
    protected static final int a = com.uc.base.b.c.a.a(-1535407011, a.class);
    private static a g = new a();
    public String b;
    public String c;
    public String d;
    public String e;
    public int f;

    public final byte k_() {
        return (byte) 2;
    }

    protected final m a() {
        return new m(i.w ? "SearchEngineItem" : "", a);
    }

    protected final boolean a(m mVar) {
        if (this.b != null) {
            mVar.a(1, i.w ? "lkname" : "", this.b);
        }
        if (this.c != null) {
            mVar.a(2, i.w ? "lkurl" : "", this.c);
        }
        if (this.d != null) {
            mVar.a(3, i.w ? "iconPath" : "", this.d);
        }
        if (this.e != null) {
            mVar.a(4, i.w ? "lkid" : "", this.e);
        }
        mVar.a(5, i.w ? "lkflag" : "", this.f);
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
        this.d = mVar.b(3);
        this.e = mVar.b(4);
        this.f = mVar.c(5);
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
