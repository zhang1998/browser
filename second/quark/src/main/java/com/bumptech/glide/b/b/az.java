package com.bumptech.glide.b.b;

import android.util.Log;
import com.bumptech.glide.b.a;
import com.bumptech.glide.b.a.b;
import com.bumptech.glide.b.c;
import com.bumptech.glide.b.c.ap;
import com.bumptech.glide.b.i;
import com.bumptech.glide.l;
import com.bumptech.glide.util.f;
import java.util.Collections;
import java.util.List;

/* compiled from: ProGuard */
final class az implements b<Object>, d, e {
    private final f<?> a;
    private final d b;
    private int c;
    private a d;
    private Object e;
    private volatile ap<?> f;
    private b g;

    public az(f<?> fVar, d dVar) {
        this.a = fVar;
        this.b = dVar;
    }

    public final boolean a() {
        Object obj;
        if (this.e != null) {
            obj = this.e;
            this.e = null;
            long a = f.a();
            try {
                c a2 = this.a.c.b.b.a(obj.getClass());
                if (a2 != null) {
                    com.bumptech.glide.b.b.b.b cVar = new c(a2, obj, this.a.i);
                    this.g = new b(this.f.a, this.a.n);
                    this.a.a().a(this.g, cVar);
                    if (Log.isLoggable("SourceGenerator", 2)) {
                        new StringBuilder("Finished encoding source to cache, key: ").append(this.g).append(", data: ").append(obj).append(", encoder: ").append(a2).append(", duration: ").append(f.a(a));
                    }
                    this.f.c.a();
                    this.d = new a(Collections.singletonList(this.f.a), this.a, this);
                } else {
                    throw new l(obj.getClass());
                }
            } catch (Throwable th) {
                this.f.c.a();
            }
        }
        if (this.d != null && this.d.a()) {
            return true;
        }
        this.d = null;
        this.f = null;
        boolean z = false;
        while (!z) {
            if (this.c < this.a.b().size()) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                break;
            }
            List b = this.a.b();
            int i = this.c;
            this.c = i + 1;
            this.f = (ap) b.get(i);
            if (this.f != null && (this.a.p.a(this.f.c.c()) || this.a.a(this.f.c.d()))) {
                this.f.c.a(this.a.o, this);
                z = true;
            }
        }
        return z;
    }

    public final void b() {
        ap apVar = this.f;
        if (apVar != null) {
            apVar.c.b();
        }
    }

    public final void a(Object obj) {
        w wVar = this.a.p;
        if (obj == null || !wVar.a(this.f.c.c())) {
            this.b.a(this.f.a, obj, this.f.c, this.f.c.c(), this.g);
            return;
        }
        this.e = obj;
        this.b.c();
    }

    public final void a(Exception exception) {
        this.b.a(this.g, exception, this.f.c, this.f.c.c());
    }

    public final void c() {
        throw new UnsupportedOperationException();
    }

    public final void a(i iVar, Object obj, com.bumptech.glide.b.a.c<?> cVar, a aVar, i iVar2) {
        this.b.a(iVar, obj, cVar, this.f.c.c(), iVar);
    }

    public final void a(i iVar, Exception exception, com.bumptech.glide.b.a.c<?> cVar, a aVar) {
        this.b.a(iVar, exception, cVar, this.f.c.c());
    }
}
