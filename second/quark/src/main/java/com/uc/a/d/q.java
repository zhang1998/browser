package com.uc.a.d;

import com.uc.base.b.c.a;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public class q extends a {
    protected static final int a = a.a(-1424604281, q.class);
    private static q c = new q();
    ArrayList<g> b = new ArrayList();

    public final byte k_() {
        return (byte) 2;
    }

    protected final m a() {
        return new m(i.w ? "ServerResData" : "", a);
    }

    protected final boolean a(m mVar) {
        if (this.b != null) {
            Iterator it = ((ArrayList) this.b.clone()).iterator();
            while (it.hasNext()) {
                mVar.b(1, i.w ? "serverResList" : "", (g) it.next());
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
            this.b.add((g) mVar.a(1, i, g.c()));
        }
        return true;
    }

    protected final i a(int i) {
        switch (a.b(i)) {
            case 1:
                if (i == a) {
                    return new q();
                }
                break;
        }
        return null;
    }
}
