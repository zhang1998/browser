package com.bumptech.glide.b.b;

import com.bumptech.glide.b.a.b;
import com.bumptech.glide.b.c.ap;
import com.bumptech.glide.b.c.aq;
import com.bumptech.glide.b.i;
import java.io.File;
import java.util.List;

/* compiled from: ProGuard */
final class a implements b<Object>, e {
    private List<i> a;
    private final f<?> b;
    private final d c;
    private int d;
    private i e;
    private List<aq<File, ?>> f;
    private int g;
    private volatile ap<?> h;
    private File i;

    a(f<?> fVar, d dVar) {
        this(fVar.c(), fVar, dVar);
    }

    a(List<i> list, f<?> fVar, d dVar) {
        this.d = -1;
        this.a = list;
        this.b = fVar;
        this.c = dVar;
    }

    public final boolean a() {
        boolean z = false;
        while (true) {
            if (this.f != null && c()) {
                break;
            }
            this.d++;
            if (this.d >= this.a.size()) {
                break;
            }
            i iVar = (i) this.a.get(this.d);
            this.i = this.b.a().a(new b(iVar, this.b.n));
            if (this.i != null) {
                this.e = iVar;
                this.f = this.b.a(this.i);
                this.g = 0;
            }
        }
        this.h = null;
        while (!z && c()) {
            boolean z2;
            List list = this.f;
            int i = this.g;
            this.g = i + 1;
            this.h = ((aq) list.get(i)).a(this.i, this.b.e, this.b.f, this.b.i);
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
        this.c.a(this.e, obj, this.h.c, com.bumptech.glide.b.a.DATA_DISK_CACHE, this.e);
    }

    public final void a(Exception exception) {
        this.c.a(this.e, exception, this.h.c, com.bumptech.glide.b.a.DATA_DISK_CACHE);
    }
}
