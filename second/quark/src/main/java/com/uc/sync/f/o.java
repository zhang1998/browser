package com.uc.sync.f;

import com.uc.sync.d.a;
import com.uc.sync.e.f;
import com.ucweb.common.util.c;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class o {
    public final int a;
    final int b;
    int c = 0;
    public int d;
    public int e;
    int f = 1;
    int g = 1;
    public int h = 1;
    public int i = 0;
    public String j = "";
    public int k = -1;
    public f l;
    byte[] m;
    ArrayList<String> n;
    long o = 0;
    private ArrayList<l> p = new ArrayList();

    public o(int i, int i2) {
        a.a("创建了一个CloudSyncTask，同步锚为：" + i2);
        this.a = i;
        this.b = i2;
        Object a = f.a.a(this.a);
        c.a(a);
        com.uc.base.b.c.b.c b = a.b(a.f());
        if (b != null) {
            this.m = b.l_();
        }
    }

    final synchronized void a(int i) {
        this.c = i;
    }

    public final void a(l lVar) {
        if (lVar != null) {
            if (a()) {
                a.a("Anchro Error:" + this.b);
                return;
            }
            synchronized (this.p) {
                this.p.add(lVar);
            }
        }
    }

    public final boolean a() {
        return this.b < 0;
    }

    public final ArrayList<l> b() {
        ArrayList<l> arrayList;
        synchronized (this.p) {
            arrayList = (ArrayList) this.p.clone();
        }
        return arrayList;
    }
}
