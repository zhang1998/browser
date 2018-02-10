package com.ucpro.base.b;

import com.bumptech.glide.f.f;
import com.bumptech.glide.f.g;
import com.bumptech.glide.p;
import com.bumptech.glide.u;
import java.io.File;

/* compiled from: ProGuard */
public final class c<TranscodeType> extends p<TranscodeType> {
    public final /* synthetic */ p a(f fVar) {
        return b(fVar);
    }

    public final /* synthetic */ p a(g gVar) {
        return b(gVar);
    }

    public final /* synthetic */ p a(p pVar) {
        return b(pVar);
    }

    private c(Class<TranscodeType> cls, p<?> pVar) {
        super(cls, pVar);
    }

    c(com.bumptech.glide.c cVar, u uVar, Class<TranscodeType> cls) {
        super(cVar, uVar, cls);
    }

    public final c<TranscodeType> d() {
        if (a() instanceof e) {
            this.c = ((e) a()).h();
        } else {
            this.c = new e().b(this.c).h();
        }
        return this;
    }

    private c<TranscodeType> b(g gVar) {
        return (c) super.a(gVar);
    }

    public final c<TranscodeType> b(f<TranscodeType> fVar) {
        return (c) super.a((f) fVar);
    }

    public final c<TranscodeType> b(p<TranscodeType> pVar) {
        return (c) super.a((p) pVar);
    }

    protected final /* synthetic */ p c() {
        return new c(File.class, this).b(a);
    }

    public final /* bridge */ /* synthetic */ p b() {
        return (c) super.b();
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return (c) super.b();
    }
}
