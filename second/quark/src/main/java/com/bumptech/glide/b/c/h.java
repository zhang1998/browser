package com.bumptech.glide.b.c;

import com.bumptech.glide.b.a;
import com.bumptech.glide.b.a.b;
import com.bumptech.glide.b.a.c;
import com.bumptech.glide.g;

/* compiled from: ProGuard */
final class h<Data> implements c<Data> {
    private final byte[] a;
    private final g<Data> b;

    public h(byte[] bArr, g<Data> gVar) {
        this.a = bArr;
        this.b = gVar;
    }

    public final void a(g gVar, b<? super Data> bVar) {
        bVar.a(this.b.a(this.a));
    }

    public final void a() {
    }

    public final void b() {
    }

    public final Class<Data> d() {
        return this.b.a();
    }

    public final a c() {
        return a.LOCAL;
    }
}
