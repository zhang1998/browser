package com.ucpro.feature.bookmarkhis.bookmark.a;

import com.raizlabs.android.dbflow.a.b.u;
import com.raizlabs.android.dbflow.a.b.z;
import com.raizlabs.android.dbflow.structure.database.b;
import com.raizlabs.android.dbflow.structure.database.transaction.a;
import com.ucweb.common.util.c;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ProGuard */
public final class ai implements a {
    final /* synthetic */ String a;
    final /* synthetic */ boolean b = false;
    final /* synthetic */ AtomicBoolean c;
    final /* synthetic */ s d;

    public ai(s sVar, String str, AtomicBoolean atomicBoolean) {
        this.d = sVar;
        this.a = str;
        this.c = atomicBoolean;
    }

    public final void a(b bVar) {
        u a = z.a(new com.raizlabs.android.dbflow.a.b.a.b[0]).a(m.class).a(y.j.a(this.a));
        if (!this.b) {
            a.a(y.m.b(Integer.valueOf(5)));
        }
        Object<m> c = a.c();
        c.a((Object) c);
        if (c != null) {
            for (m a2 : c) {
                boolean a3 = this.d.e(a2);
                AtomicBoolean atomicBoolean = this.c;
                a3 = this.c.get() || a3;
                atomicBoolean.set(a3);
            }
        }
    }
}
