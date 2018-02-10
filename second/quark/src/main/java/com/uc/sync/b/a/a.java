package com.uc.sync.b.a;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class a extends c {
    public int a;
    public int b;
    public byte[] c;
    public b d;

    protected final m a() {
        m mVar = new m("Command", 50);
        mVar.a(1, "cmd_id", 2, 1);
        mVar.a(2, "cmd_type", 2, 1);
        mVar.a(3, "meta_flag", 1, 13);
        mVar.a(4, "data_item", 1, new b());
        return mVar;
    }

    protected final boolean a(m mVar) {
        mVar.a(1, this.a);
        mVar.a(2, this.b);
        if (this.c != null) {
            mVar.a(3, this.c);
        }
        if (this.d != null) {
            mVar.a(4, "data_item", this.d);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = mVar.b(1, 0);
        this.b = mVar.b(2, 0);
        this.c = mVar.g(3);
        this.d = (b) new b().a(mVar, 4);
        return true;
    }

    protected final i a(int i) {
        return new a();
    }
}
