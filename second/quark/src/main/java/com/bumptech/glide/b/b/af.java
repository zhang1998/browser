package com.bumptech.glide.b.b;

import android.os.Looper;
import com.bumptech.glide.b.b.b.a;
import com.bumptech.glide.b.b.b.n;
import com.bumptech.glide.b.b.b.o;
import com.bumptech.glide.b.b.c.g;
import com.bumptech.glide.b.i;
import com.bumptech.glide.util.f;
import com.bumptech.glide.util.l;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class af implements aj, am, n {
    public final Map<i, ai<?>> a;
    public final o b;
    public final aa c;
    public final Map<i, WeakReference<an<?>>> d;
    public final ab e;
    public final y f;
    private final al g;
    private final ay h;
    private ReferenceQueue<an<?>> i;

    public af(o oVar, a aVar, g gVar, g gVar2, g gVar3) {
        this(oVar, aVar, gVar, gVar2, gVar3, (byte) 0);
    }

    private af(o oVar, a aVar, g gVar, g gVar2, g gVar3, byte b) {
        this.b = oVar;
        this.e = new ab(aVar);
        this.d = new HashMap();
        this.g = new al();
        this.a = new HashMap();
        this.c = new aa(gVar, gVar2, gVar3, this);
        this.f = new y(this.e);
        this.h = new ay();
        oVar.a((n) this);
    }

    public static void a(String str, long j, i iVar) {
        new StringBuilder().append(str).append(" in ").append(f.a(j)).append("ms, key: ").append(iVar);
    }

    public final void a(i iVar, an<?> anVar) {
        l.a();
        if (anVar != null) {
            anVar.c = iVar;
            anVar.b = this;
            if (anVar.a) {
                this.d.put(iVar, new ae(iVar, anVar, a()));
            }
        }
        this.a.remove(iVar);
    }

    public final void a(ai aiVar, i iVar) {
        l.a();
        if (aiVar.equals((ai) this.a.get(iVar))) {
            this.a.remove(iVar);
        }
    }

    public final void a(au<?> auVar) {
        l.a();
        this.h.a(auVar);
    }

    public final void b(i iVar, an anVar) {
        l.a();
        this.d.remove(iVar);
        if (anVar.a) {
            this.b.a(iVar, anVar);
        } else {
            this.h.a(anVar);
        }
    }

    public final ReferenceQueue<an<?>> a() {
        if (this.i == null) {
            this.i = new ReferenceQueue();
            Looper.myQueue().addIdleHandler(new ad(this.d, this.i));
        }
        return this.i;
    }
}
