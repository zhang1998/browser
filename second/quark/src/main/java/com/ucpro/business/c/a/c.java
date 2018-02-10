package com.ucpro.business.c.a;

import com.uc.base.b.c.a;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public class c extends a {
    protected static final int a = a.a(-1077467600, c.class);
    private static c c = new c();
    public ArrayList<d> b = new ArrayList();

    public final byte k_() {
        return (byte) 2;
    }

    protected final m a() {
        return new m(i.w ? "KeyValueList" : "", a);
    }

    protected final boolean a(m mVar) {
        if (this.b != null) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                mVar.b(1, i.w ? "items" : "", (d) it.next());
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
            this.b.add((d) mVar.a(1, i, d.c()));
        }
        return true;
    }

    protected final i a(int i) {
        switch (a.b(i)) {
            case 1:
                if (i == a) {
                    return new c();
                }
                break;
        }
        return null;
    }
}
