package com.ucpro.feature.z.g.a;

import com.uc.apollo.android.GuideDialog;
import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;

/* compiled from: ProGuard */
public final class b extends c {
    public int a;
    com.uc.base.b.c.c b;
    public com.uc.base.b.c.c c;
    private int d;
    private com.uc.base.b.c.c e;
    private int f;
    private int g;
    private com.uc.base.b.c.c h;

    public final String c() {
        if (this.b == null) {
            return null;
        }
        return this.b.toString();
    }

    public final String e() {
        if (this.e == null) {
            return null;
        }
        return this.e.toString();
    }

    protected final m a() {
        m mVar = new m("CloudAssociateItem", 50);
        mVar.a(1, "type", 2, 1);
        mVar.a(2, "sub_type", 2, 1);
        mVar.a(3, GuideDialog.TITLE, 2, 12);
        mVar.a(4, "url", 2, 12);
        mVar.a(5, "content", 2, 12);
        mVar.a(6, "label", 2, 1);
        mVar.a(7, "boost_top", 2, 1);
        mVar.a(8, "doc_id", 2, 12);
        return mVar;
    }

    protected final boolean a(m mVar) {
        mVar.a(1, this.a);
        mVar.a(2, this.d);
        if (this.b != null) {
            mVar.a(3, this.b);
        }
        if (this.e != null) {
            mVar.a(4, this.e);
        }
        if (this.c != null) {
            mVar.a(5, this.c);
        }
        mVar.a(6, this.f);
        mVar.a(7, this.g);
        if (this.h != null) {
            mVar.a(8, this.h);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = mVar.c(1);
        this.d = mVar.c(2);
        this.b = mVar.a(3);
        this.e = mVar.a(4);
        this.c = mVar.a(5);
        this.f = mVar.c(6);
        this.g = mVar.c(7);
        this.h = mVar.a(8);
        return true;
    }

    protected final i a(int i) {
        return new b();
    }

    public final String toString() {
        return ("url: " + this.e) + (" title: " + this.b) + (" content: " + this.c) + (" type: " + this.a) + (" label: " + this.f);
    }
}
