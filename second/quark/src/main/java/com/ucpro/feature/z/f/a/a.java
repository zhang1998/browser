package com.ucpro.feature.z.f.a;

import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public class a extends com.uc.base.b.c.a {
    protected static final int a = com.uc.base.b.c.a.a(2077622666, a.class);
    private static a c = new a();
    public ArrayList<f> b = new ArrayList();

    public final byte k_() {
        return (byte) 2;
    }

    protected final m a() {
        return new m(i.w ? "InputHistory" : "", a);
    }

    protected final boolean a(m mVar) {
        if (this.b != null) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                mVar.b(1, i.w ? "inputHistoryList" : "", (f) it.next());
            }
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
        int j = mVar.j(1);
        this.b = new ArrayList(j);
        for (int i = 0; i < j; i++) {
            this.b.add((f) mVar.a(1, i, f.c()));
        }
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
