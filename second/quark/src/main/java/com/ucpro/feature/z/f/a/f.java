package com.ucpro.feature.z.f.a;

import com.uc.base.b.c.a;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public class f extends a {
    protected static final int a = a.a(-1230431299, f.class);
    private static f f = new f();
    public int b;
    public String c;
    long d;
    int e;

    public final byte k_() {
        return (byte) 2;
    }

    public static f c() {
        return f;
    }

    protected final m a() {
        return new m(i.w ? "InputHistoryItem" : "", a);
    }

    protected final boolean a(m mVar) {
        mVar.a(1, i.w ? "id" : "", this.b);
        if (this.c != null) {
            mVar.a(2, i.w ? "content" : "", this.c);
        }
        mVar.a(3, i.w ? "visitedTime" : "", this.d);
        mVar.a(4, i.w ? "visitedCount" : "", this.e);
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
        this.b = mVar.c(1);
        this.c = mVar.b(2);
        this.d = mVar.d(3);
        this.e = mVar.c(4);
        return true;
    }

    protected final i a(int i) {
        switch (a.b(i)) {
            case 1:
                if (i == a) {
                    return new f();
                }
                break;
        }
        return null;
    }
}
