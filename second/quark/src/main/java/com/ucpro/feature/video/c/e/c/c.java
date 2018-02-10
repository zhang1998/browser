package com.ucpro.feature.video.c.e.c;

import com.uc.apollo.android.GuideDialog;
import com.uc.base.b.c.i;
import com.uc.base.b.c.m;
import com.ucpro.feature.video.c.e.a.a;
import com.ucpro.feature.video.c.e.a.b;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class c extends com.uc.base.b.c.b.c {
    public int a;
    public ArrayList<com.uc.base.b.c.c> b = new ArrayList();
    public ArrayList<b> c = new ArrayList();
    public ArrayList<a> d = new ArrayList();
    private com.uc.base.b.c.c e;
    private com.uc.base.b.c.c f;
    private com.uc.base.b.c.c g;
    private ArrayList<a> h = new ArrayList();
    private ArrayList<b> i = new ArrayList();

    public final String c() {
        if (this.f == null) {
            return null;
        }
        return this.f.toString();
    }

    protected final m a() {
        m mVar = new m(i.w ? "FLVResponsePb" : "", 50);
        mVar.a(1, i.w ? "code" : "", 2, 1);
        mVar.a(2, i.w ? "source" : "", 1, 12);
        mVar.a(3, i.w ? "page_url" : "", 1, 12);
        mVar.a(4, i.w ? GuideDialog.TITLE : "", 1, 12);
        mVar.a(5, i.w ? "resolution_list" : "", 3, 12);
        mVar.a(6, i.w ? "video_list" : "", 3, new b());
        mVar.a(7, i.w ? "lang_list" : "", 3, new a());
        mVar.a(8, i.w ? "page_info_list" : "", 3, new a());
        mVar.a(9, i.w ? "vps_log" : "", 3, new b());
        return mVar;
    }

    protected final boolean a(m mVar) {
        Iterator it;
        mVar.a(1, this.a);
        if (this.e != null) {
            mVar.a(2, this.e);
        }
        if (this.f != null) {
            mVar.a(3, this.f);
        }
        if (this.g != null) {
            mVar.a(4, this.g);
        }
        if (this.b != null) {
            it = this.b.iterator();
            while (it.hasNext()) {
                mVar.b(5, (com.uc.base.b.c.c) it.next());
            }
        }
        if (this.c != null) {
            it = this.c.iterator();
            while (it.hasNext()) {
                mVar.a(6, (b) it.next());
            }
        }
        if (this.h != null) {
            it = this.h.iterator();
            while (it.hasNext()) {
                mVar.a(7, (a) it.next());
            }
        }
        if (this.d != null) {
            it = this.d.iterator();
            while (it.hasNext()) {
                mVar.a(8, (a) it.next());
            }
        }
        if (this.i != null) {
            it = this.i.iterator();
            while (it.hasNext()) {
                mVar.a(9, (b) it.next());
            }
        }
        return true;
    }

    protected final boolean b(m mVar) {
        int i;
        int i2 = 0;
        this.a = mVar.c(1);
        this.e = mVar.a(2);
        this.f = mVar.a(3);
        this.g = mVar.a(4);
        this.b.clear();
        int j = mVar.j(5);
        for (i = 0; i < j; i++) {
            this.b.add((com.uc.base.b.c.c) mVar.c(5, i));
        }
        this.c.clear();
        j = mVar.j(6);
        for (i = 0; i < j; i++) {
            this.c.add((b) mVar.a(6, i, new b()));
        }
        this.h.clear();
        j = mVar.j(7);
        for (i = 0; i < j; i++) {
            this.h.add((a) mVar.a(7, i, new a()));
        }
        this.d.clear();
        j = mVar.j(8);
        for (i = 0; i < j; i++) {
            this.d.add((a) mVar.a(8, i, new a()));
        }
        this.i.clear();
        i = mVar.j(9);
        while (i2 < i) {
            this.i.add((b) mVar.a(9, i2, new b()));
            i2++;
        }
        return true;
    }

    protected final i a(int i) {
        return new c();
    }
}
