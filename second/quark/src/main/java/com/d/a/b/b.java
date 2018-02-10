package com.d.a.b;

import com.UCMobile.Apollo.ApolloMetaData;
import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class b extends c {
    public com.uc.base.b.c.c a;
    public byte[] b;
    public com.uc.base.b.c.c c;
    public com.uc.base.b.c.c d;
    public int e;

    protected final m a() {
        m mVar = new m(i.w ? "Popup" : "", 50);
        mVar.a(1, i.w ? ApolloMetaData.KEY_HEADER : "", 1, 12);
        mVar.a(2, i.w ? "image" : "", 1, 13);
        mVar.a(3, i.w ? "body" : "", 1, 12);
        mVar.a(4, i.w ? "footer" : "", 1, 12);
        mVar.a(5, i.w ? "bgcolor" : "", 1, 1);
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a != null) {
            mVar.b(1, this.a);
        }
        if (this.b != null) {
            mVar.a(2, this.b);
        }
        if (this.c != null) {
            mVar.b(3, this.c);
        }
        if (this.d != null) {
            mVar.b(4, this.d);
        }
        mVar.a(5, this.e);
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = mVar.a(1);
        this.b = mVar.g(2);
        this.c = mVar.a(3);
        this.d = mVar.a(4);
        this.e = mVar.b(5, 0);
        return true;
    }

    protected final i a(int i) {
        return new b();
    }
}
