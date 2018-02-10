package com.uc.a.d;

import com.uc.base.b.c.a;
import com.uc.base.b.c.e;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public class g extends a {
    protected static final int a = a.a(1806517821, g.class);
    private static g h = new g();
    byte b = (byte) 0;
    public String c;
    public int d = 604800;
    String e;
    int f;
    ArrayList<ah> g = new ArrayList();

    public final byte k_() {
        return (byte) 2;
    }

    public static g c() {
        return h;
    }

    protected final m a() {
        return new m(i.w ? "ServerRes" : "", a);
    }

    protected final boolean a(m mVar) {
        String str;
        if (i.w) {
            str = "serverType";
        } else {
            str = "";
        }
        mVar.a(1, str, 1, 17, new Byte(this.b));
        if (this.c != null) {
            mVar.a(2, i.w ? "serverUrl" : "", this.c);
        }
        mVar.a(3, i.w ? "recycle" : "", this.d);
        if (this.e != null) {
            mVar.a(4, i.w ? "uploadList" : "", this.e);
        }
        mVar.a(5, i.w ? "lastUpdateTime" : "", this.f);
        if (this.g != null) {
            Iterator it = ((ArrayList) this.g.clone()).iterator();
            while (it.hasNext()) {
                i iVar = (ah) it.next();
                if (i.w) {
                    str = "itemsList";
                } else {
                    str = "";
                }
                mVar.b(6, str, iVar);
            }
        }
        return true;
    }

    protected final boolean b(m mVar) {
        int i = 0;
        if (mVar == null) {
            return true;
        }
        byte i2;
        if (mVar.b > a) {
            do {
                mVar = mVar.g;
                if (mVar == null) {
                    return false;
                }
            } while (mVar.b != a);
        }
        e i3 = mVar.i(1);
        if (i3 != null) {
            i2 = i3.i();
        } else {
            i2 = (byte) 0;
        }
        this.b = i2;
        this.c = mVar.b(2);
        this.d = mVar.b(3, 0);
        this.e = mVar.b(4);
        this.f = mVar.b(5, 0);
        int j = mVar.j(6);
        this.g = new ArrayList(j);
        while (i < j) {
            this.g.add((ah) mVar.a(6, i, ah.c()));
            i++;
        }
        return true;
    }

    protected final i a(int i) {
        switch (a.b(i)) {
            case 1:
                if (i == a) {
                    return new g();
                }
                break;
        }
        return null;
    }
}
