package com.ucpro.base.b;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import com.bumptech.glide.c;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.r;
import com.bumptech.glide.f.g;
import com.bumptech.glide.p;
import com.bumptech.glide.u;

/* compiled from: ProGuard */
public final class b extends u {
    public final /* synthetic */ p a(Object obj) {
        return b(obj);
    }

    public b(c cVar, j jVar, r rVar) {
        super(cVar, jVar, rVar);
    }

    public final c<Drawable> b(Object obj) {
        return (c) super.a(obj);
    }

    protected final void a(@NonNull g gVar) {
        if (gVar instanceof e) {
            super.a(gVar);
        } else {
            super.a(new e().b(gVar));
        }
    }

    public final /* synthetic */ p a(Class cls) {
        return new c(this.a, this, cls);
    }

    public final /* bridge */ /* synthetic */ p f() {
        return (c) super.f();
    }

    public final /* bridge */ /* synthetic */ p e() {
        return (c) super.e();
    }
}
