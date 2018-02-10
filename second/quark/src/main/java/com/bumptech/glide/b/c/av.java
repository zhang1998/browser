package com.bumptech.glide.b.c;

import android.support.annotation.Nullable;
import android.support.v4.d.q;
import com.bumptech.glide.b.a;
import com.bumptech.glide.b.a.b;
import com.bumptech.glide.b.a.c;
import com.bumptech.glide.b.b.ap;
import com.bumptech.glide.g;
import com.bumptech.glide.util.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: ProGuard */
final class av<Data> implements b<Data>, c<Data> {
    private final List<c<Data>> a;
    private final q<List<Exception>> b;
    private int c = 0;
    private g d;
    private b<? super Data> e;
    @Nullable
    private List<Exception> f;

    av(List<c<Data>> list, q<List<Exception>> qVar) {
        this.b = qVar;
        j.a((Collection) list);
        this.a = list;
    }

    public final void a(g gVar, b<? super Data> bVar) {
        this.d = gVar;
        this.e = bVar;
        this.f = (List) this.b.a();
        ((c) this.a.get(this.c)).a(gVar, this);
    }

    public final void a() {
        if (this.f != null) {
            this.b.a(this.f);
        }
        this.f = null;
        for (c a : this.a) {
            a.a();
        }
    }

    public final void b() {
        for (c b : this.a) {
            b.b();
        }
    }

    public final Class<Data> d() {
        return ((c) this.a.get(0)).d();
    }

    public final a c() {
        return ((c) this.a.get(0)).c();
    }

    public final void a(Data data) {
        if (data != null) {
            this.e.a((Object) data);
        } else {
            e();
        }
    }

    public final void a(Exception exception) {
        this.f.add(exception);
        e();
    }

    private void e() {
        if (this.c < this.a.size() - 1) {
            this.c++;
            a(this.d, this.e);
            return;
        }
        this.e.a(new ap("Fetch failed", new ArrayList(this.f)));
    }
}
