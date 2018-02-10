package com.ucpro.feature.bookmarkhis.bookmark;

import android.app.Activity;
import com.ucpro.base.system.b;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucpro.feature.bookmarkhis.bookmark.a.s;
import com.ucpro.feature.bookmarkhis.bookmark.category.e;
import com.ucpro.feature.bookmarkhis.bookmark.category.f;
import com.ucpro.feature.inputenhance.a.a;
import java.util.List;

/* compiled from: ProGuard */
public final class o implements e {
    Activity a;
    m b;
    List<m> c;
    m d;
    f e;
    int f = -1;
    ad g = null;
    boolean h = false;
    boolean i = false;

    public o(m mVar, Activity activity, m mVar2) {
        this.a = activity;
        this.b = mVar;
        this.d = mVar2;
        mVar.setPresenter(this);
        a();
    }

    final void a() {
        s.a().a(new d(this));
    }

    public final void b() {
        int height = a.a(this.a).height();
        if (((float) height) < ((float) b.a.g()) * 0.8f) {
            this.b.a(height);
            this.b.a();
            this.i = true;
            return;
        }
        this.b.a();
        this.h = true;
    }

    public final void a(int i) {
        if (this.f != i) {
            this.f = i;
        } else {
            this.f = -1;
        }
        b(this.f);
    }

    final void b(int i) {
        this.e.c = this.f;
        this.e.c();
        if (i < 0 || i >= this.c.size()) {
            this.b.a(null);
        } else {
            this.b.a((m) this.c.get(i));
        }
    }
}
