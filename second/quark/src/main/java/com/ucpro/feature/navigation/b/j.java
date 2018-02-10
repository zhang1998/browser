package com.ucpro.feature.navigation.b;

import com.uc.base.b.c.a;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public class j extends a {
    protected static final int a = a.a(1685772334, j.class);
    private static j d = new j();
    public ArrayList<g> b = new ArrayList();
    public boolean c;

    public final byte k_() {
        return (byte) 2;
    }

    protected final m a() {
        return new m(i.w ? "WidgetData" : "", a);
    }

    protected final boolean a(m mVar) {
        if (this.b != null) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                mVar.b(1, i.w ? "widgetInfoBeanList" : "", (g) it.next());
            }
        }
        mVar.a(i.w ? "isEmpty" : "", this.c);
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
        this.c = mVar.e(2);
        return true;
    }

    protected final i a(int i) {
        switch (a.b(i)) {
            case 1:
                if (i == a) {
                    return new j();
                }
                break;
        }
        return null;
    }
}
