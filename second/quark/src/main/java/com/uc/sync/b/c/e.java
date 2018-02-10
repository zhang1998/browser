package com.uc.sync.b.c;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import com.uc.sync.b.b.f;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class e extends c {
    public int a;
    public ArrayList<f> b = new ArrayList();
    private byte[] c;
    private byte[] d;

    protected final m a() {
        m mVar = new m("SyncResHead", 50);
        mVar.a(1, "ret_code", 2, 1);
        mVar.a(2, "ret_msg", 1, 13);
        mVar.a(3, "device_list", 3, new f());
        mVar.a(4, "ext", 1, 13);
        return mVar;
    }

    protected final boolean a(m mVar) {
        mVar.a(1, this.a);
        if (this.c != null) {
            mVar.a(2, this.c);
        }
        if (this.b != null) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                mVar.a(3, (f) it.next());
            }
        }
        if (this.d != null) {
            mVar.a(4, this.d);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = mVar.b(1, 0);
        this.c = mVar.g(2);
        this.b.clear();
        int j = mVar.j(3);
        for (int i = 0; i < j; i++) {
            this.b.add((f) mVar.a(3, i, new f()));
        }
        this.d = mVar.g(4);
        return true;
    }

    protected final i a(int i) {
        return new e();
    }
}
