package com.ucpro.business.c.a;

import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public class a extends com.uc.base.b.c.a {
    protected static final int a = com.uc.base.b.c.a.a(-180327408, a.class);
    private static a d = new a();
    ArrayList<String> b = new ArrayList();
    ArrayList<String> c = new ArrayList();

    public final byte k_() {
        return (byte) 2;
    }

    protected final m a() {
        return new m(i.w ? "KeyValueSSList" : "", a);
    }

    protected boolean a(m mVar) {
        Iterator it;
        if (this.b != null) {
            it = this.b.iterator();
            while (it.hasNext()) {
                mVar.b(1, i.w ? "key" : "", (String) it.next());
            }
        }
        if (this.c != null) {
            it = this.c.iterator();
            while (it.hasNext()) {
                mVar.b(2, i.w ? "value" : "", (String) it.next());
            }
        }
        return true;
    }

    protected boolean b(m mVar) {
        int i = 0;
        if (mVar == null) {
            return true;
        }
        int i2;
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
        for (i2 = 0; i2 < j; i2++) {
            this.b.add((String) mVar.c(1, i2));
        }
        i2 = mVar.j(2);
        this.c = new ArrayList(i2);
        while (i < i2) {
            this.c.add((String) mVar.c(2, i));
            i++;
        }
        return true;
    }

    protected final i a(int i) {
        switch (com.uc.base.b.c.a.b(i)) {
            case 1:
                if (i == a) {
                    return new e();
                }
                break;
        }
        return null;
    }
}
