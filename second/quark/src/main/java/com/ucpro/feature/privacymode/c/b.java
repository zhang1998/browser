package com.ucpro.feature.privacymode.c;

import com.uc.base.b.c.a;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public class b extends a {
    protected static final int a = a.a(1658727334, b.class);
    private static b c = new b();
    public String b;

    public final byte k_() {
        return (byte) 2;
    }

    protected final m a() {
        return new m(i.w ? "PrivacyModeData" : "", a);
    }

    protected final boolean a(m mVar) {
        if (this.b != null) {
            mVar.a(1, i.w ? "password" : "", this.b);
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
                    return new b();
                }
                break;
        }
        return null;
    }
}
