package com.bumptech.glide.b.c;

import com.bumptech.glide.b.a;
import com.bumptech.glide.b.a.b;
import com.bumptech.glide.b.a.c;
import com.bumptech.glide.g;
import java.io.IOException;

/* compiled from: ProGuard */
final class q<Data> implements c<Data> {
    private final String a;
    private final p<Data> b;
    private Data c;

    public q(String str, p<Data> pVar) {
        this.a = str;
        this.b = pVar;
    }

    public final void a(g gVar, b<? super Data> bVar) {
        try {
            this.c = this.b.a(this.a);
            bVar.a(this.c);
        } catch (Exception e) {
            bVar.a(e);
        }
    }

    public final void a() {
        try {
            this.b.a(this.c);
        } catch (IOException e) {
        }
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
