package com.ucpro.base.e;

import android.app.Activity;
import android.os.Message;
import com.ucpro.base.c.b;
import com.ucpro.base.c.b.m;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public abstract class e {
    public b a;
    public Activity b;

    public abstract void a(int i, Message message);

    public abstract void b(int i, Message message);

    public void a(b bVar) {
        c.a((Object) bVar);
        this.a = bVar;
        this.b = this.a.a();
    }

    public final m s_() {
        return this.a.b();
    }

    public final com.ucpro.base.c.a.c t_() {
        return this.a.c();
    }

    public void g() {
    }

    public void v_() {
    }

    public void q_() {
    }

    public void h() {
    }
}
