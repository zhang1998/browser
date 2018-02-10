package com.bumptech.glide.b.b;

import com.bumptech.glide.b.a;
import com.bumptech.glide.b.a.b;
import com.bumptech.glide.b.c.ap;
import com.bumptech.glide.b.c.aq;
import com.bumptech.glide.b.i;
import com.bumptech.glide.e.e;
import com.bumptech.glide.m;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ProGuard */
final class av implements b<Object>, e {
    private final d a;
    private final f<?> b;
    private int c = 0;
    private int d = -1;
    private i e;
    private List<aq<File, ?>> f;
    private int g;
    private volatile ap<?> h;
    private File i;
    private aw j;

    public av(f<?> fVar, d dVar) {
        this.b = fVar;
        this.a = dVar;
    }

    public final boolean a() {
        List c = this.b.c();
        if (c.isEmpty()) {
            return false;
        }
        List list;
        f fVar = this.b;
        m mVar = fVar.c.b;
        Class cls = fVar.d.getClass();
        Class cls2 = fVar.g;
        Class cls3 = fVar.k;
        List a = mVar.h.a(cls, cls2);
        if (a == null) {
            List arrayList = new ArrayList();
            for (Class b : mVar.a.a(cls)) {
                for (Class cls4 : mVar.c.b(b, cls2)) {
                    if (!(mVar.f.b(cls4, cls3).isEmpty() || arrayList.contains(cls4))) {
                        arrayList.add(cls4);
                    }
                }
            }
            e eVar = mVar.h;
            List unmodifiableList = Collections.unmodifiableList(arrayList);
            synchronized (eVar.a) {
                eVar.a.put(new com.bumptech.glide.util.i(cls, cls2), unmodifiableList);
            }
            list = arrayList;
        } else {
            list = a;
        }
        while (true) {
            if (this.f != null && c()) {
                break;
            }
            this.d++;
            if (this.d >= list.size()) {
                this.c++;
                if (this.c >= c.size()) {
                    return false;
                }
                this.d = 0;
            }
            i iVar = (i) c.get(this.c);
            Class cls5 = (Class) list.get(this.d);
            this.j = new aw(iVar, this.b.n, this.b.e, this.b.f, this.b.c(cls5), cls5, this.b.i);
            this.i = this.b.a().a(this.j);
            if (this.i != null) {
                this.e = iVar;
                this.f = this.b.a(this.i);
                this.g = 0;
            }
        }
        this.h = null;
        boolean z = false;
        while (!z && c()) {
            boolean z2;
            a = this.f;
            int i = this.g;
            this.g = i + 1;
            this.h = ((aq) a.get(i)).a(this.i, this.b.e, this.b.f, this.b.i);
            if (this.h == null || !this.b.a(this.h.c.d())) {
                z2 = z;
            } else {
                z2 = true;
                this.h.c.a(this.b.o, this);
            }
            z = z2;
        }
        return z;
    }

    private boolean c() {
        return this.g < this.f.size();
    }

    public final void b() {
        ap apVar = this.h;
        if (apVar != null) {
            apVar.c.b();
        }
    }

    public final void a(Object obj) {
        this.a.a(this.e, obj, this.h.c, a.RESOURCE_DISK_CACHE, this.j);
    }

    public final void a(Exception exception) {
        this.a.a(this.j, exception, this.h.c, a.RESOURCE_DISK_CACHE);
    }
}
