package com.uc.a.b;

import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class f extends c {
    public com.uc.base.b.c.c a;
    public com.uc.base.b.c.c b;
    private com.uc.base.b.c.c c;

    public final String b() {
        if (this.c == null) {
            return null;
        }
        return this.c.toString();
    }

    protected final m a() {
        m mVar = new m(i.w ? "UrlCmd" : "", 50);
        mVar.a(1, i.w ? "method" : "", 2, 12);
        mVar.a(2, i.w ? "para1" : "", 1, 12);
        mVar.a(3, i.w ? "upload_url" : "", 1, 12);
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.c != null) {
            mVar.b(1, this.c);
        }
        if (this.a != null) {
            mVar.b(2, this.a);
        }
        if (this.b != null) {
            mVar.b(3, this.b);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.c = mVar.a(1);
        this.a = mVar.a(2);
        this.b = mVar.a(3);
        return true;
    }

    protected final i a(int i) {
        return new f();
    }
}
