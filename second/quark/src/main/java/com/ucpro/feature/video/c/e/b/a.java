package com.ucpro.feature.video.c.e.b;

import com.uc.a.b.k;
import com.uc.base.b.c.b.c;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class a extends c {
    public com.uc.base.b.c.c a;
    public com.uc.base.b.c.c b;
    public k c;
    public com.uc.a.b.a d;
    public int e;
    public int f;
    public ArrayList<com.ucpro.feature.video.c.e.a.a> g = new ArrayList();
    private com.uc.base.b.c.c h;
    private com.uc.base.b.c.c i;
    private com.uc.base.b.c.c j;
    private com.uc.base.b.c.c k;
    private int l;
    private com.uc.base.b.c.c m;

    public final String c() {
        if (this.a == null) {
            return null;
        }
        return this.a.toString();
    }

    protected final m a() {
        m mVar = new m(i.w ? "FLVRequestPb" : "", 50);
        mVar.a(1, i.w ? "page_url" : "", 2, 12);
        mVar.a(2, i.w ? "resolution" : "", 1, 12);
        mVar.a(3, i.w ? "pack_info" : "", 2, new k());
        mVar.a(4, i.w ? "mobile_info" : "", 2, new com.uc.a.b.a());
        mVar.a(5, i.w ? "lang_code" : "", 1, 12);
        mVar.a(6, i.w ? "action" : "", 1, 1);
        mVar.a(7, i.w ? "format" : "", 1, 12);
        mVar.a(8, i.w ? "referer_url" : "", 1, 12);
        mVar.a(9, i.w ? "flash_url" : "", 1, 12);
        mVar.a(10, i.w ? "reparse_support" : "", 1, 1);
        mVar.a(11, i.w ? "page_info_list" : "", 3, new com.ucpro.feature.video.c.e.a.a());
        mVar.a(12, i.w ? "ever_fail" : "", 1, 1);
        mVar.a(13, i.w ? "lang_name" : "", 1, 12);
        return mVar;
    }

    protected final boolean a(m mVar) {
        if (this.a != null) {
            mVar.a(1, this.a);
        }
        if (this.b != null) {
            mVar.a(2, this.b);
        }
        if (this.c != null) {
            mVar.a(3, i.w ? "pack_info" : "", this.c);
        }
        if (this.d != null) {
            mVar.a(4, i.w ? "mobile_info" : "", this.d);
        }
        if (this.h != null) {
            mVar.a(5, this.h);
        }
        mVar.a(6, this.e);
        if (this.i != null) {
            mVar.a(7, this.i);
        }
        if (this.j != null) {
            mVar.a(8, this.j);
        }
        if (this.k != null) {
            mVar.a(9, this.k);
        }
        mVar.a(10, this.f);
        if (this.g != null) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                mVar.a(11, (com.ucpro.feature.video.c.e.a.a) it.next());
            }
        }
        mVar.a(12, this.l);
        if (this.m != null) {
            mVar.a(13, this.m);
        }
        return true;
    }

    protected final boolean b(m mVar) {
        this.a = mVar.a(1);
        this.b = mVar.a(2);
        this.c = (k) new k().a(mVar, 3);
        this.d = (com.uc.a.b.a) new com.uc.a.b.a().a(mVar, 4);
        this.h = mVar.a(5);
        this.e = mVar.c(6);
        this.i = mVar.a(7);
        this.j = mVar.a(8);
        this.k = mVar.a(9);
        this.f = mVar.c(10);
        this.g.clear();
        int j = mVar.j(11);
        for (int i = 0; i < j; i++) {
            this.g.add((com.ucpro.feature.video.c.e.a.a) mVar.a(11, i, new com.ucpro.feature.video.c.e.a.a()));
        }
        this.l = mVar.c(12);
        this.m = mVar.a(13);
        return true;
    }

    protected final i a(int i) {
        return new a();
    }
}
