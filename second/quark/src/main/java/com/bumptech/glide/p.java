package com.bumptech.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.bumptech.glide.b.b.w;
import com.bumptech.glide.c.s;
import com.bumptech.glide.f.a.c;
import com.bumptech.glide.f.a.h;
import com.bumptech.glide.f.b;
import com.bumptech.glide.f.f;
import com.bumptech.glide.f.g;
import com.bumptech.glide.f.k;
import com.bumptech.glide.util.j;
import com.bumptech.glide.util.l;
import java.io.File;

/* compiled from: ProGuard */
public class p<TranscodeType> implements Cloneable {
    public static final g a = new g().b(w.c).a(g.LOW).a(true);
    private static final v<?, ?> d = new b();
    public final e b;
    @NonNull
    public g c;
    private final u e;
    private final Class<TranscodeType> f;
    private final g g;
    private final c h;
    private v<?, ? super TranscodeType> i;
    @Nullable
    private Object j;
    @Nullable
    private f<TranscodeType> k;
    @Nullable
    private p<TranscodeType> l;
    @Nullable
    private Float m;
    private boolean n;
    private boolean o;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return b();
    }

    public p(c cVar, u uVar, Class<TranscodeType> cls) {
        this.i = d;
        this.h = cVar;
        this.e = uVar;
        this.b = cVar.c;
        this.f = cls;
        this.g = uVar.e;
        this.c = this.g;
    }

    public p(Class<TranscodeType> cls, p<?> pVar) {
        this(pVar.h, pVar.e, cls);
        this.j = pVar.j;
        this.n = pVar.n;
        this.c = pVar.c;
    }

    public final g a() {
        return this.g == this.c ? this.c.a() : this.c;
    }

    public p<TranscodeType> a(@Nullable f<TranscodeType> fVar) {
        this.k = fVar;
        return this;
    }

    public p<TranscodeType> a(@Nullable p<TranscodeType> pVar) {
        this.l = pVar;
        return this;
    }

    public p<TranscodeType> b() {
        try {
            p<TranscodeType> pVar = (p) super.clone();
            pVar.c = pVar.c.a();
            pVar.i = pVar.i.a();
            return pVar;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final <Y extends h<TranscodeType>> Y a(@NonNull Y y) {
        l.a();
        j.a((Object) y, "Argument must not be null");
        if (this.n) {
            if (y.d() != null) {
                this.e.a((h) y);
            }
            this.c.f();
            b a = a(y, null, this.i, this.c.c, this.c.j, this.c.i);
            y.a(a);
            u uVar = this.e;
            uVar.d.a.add(y);
            s sVar = uVar.c;
            sVar.a.add(a);
            if (sVar.c) {
                sVar.b.add(a);
            } else {
                a.b();
            }
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    public final h<TranscodeType> a(ImageView imageView) {
        h bVar;
        l.a();
        j.a((Object) imageView, "Argument must not be null");
        if (!(this.c.a(2048) || !this.c.m || imageView.getScaleType() == null)) {
            if (this.c.s) {
                this.c = this.c.a();
            }
            switch (o.a[imageView.getScaleType().ordinal()]) {
                case 1:
                    this.c.b();
                    break;
                case 2:
                    this.c.d();
                    break;
                case 3:
                case 4:
                case 5:
                    this.c.c();
                    break;
                case 6:
                    this.c.d();
                    break;
            }
        }
        Class cls = this.f;
        if (Bitmap.class.equals(cls)) {
            bVar = new com.bumptech.glide.f.a.b(imageView);
        } else if (Drawable.class.isAssignableFrom(cls)) {
            bVar = new c(imageView);
        } else {
            throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
        }
        return a(bVar);
    }

    public p<File> c() {
        return new p(File.class, this).a(a);
    }

    private g a(g gVar) {
        switch (o.b[gVar.ordinal()]) {
            case 1:
                return g.NORMAL;
            case 2:
                return g.HIGH;
            case 3:
            case 4:
                return g.IMMEDIATE;
            default:
                throw new IllegalArgumentException("unknown priority: " + this.c.c);
        }
    }

    private b a(h<TranscodeType> hVar, @Nullable com.bumptech.glide.f.l lVar, v<?, ? super TranscodeType> vVar, g gVar, int i, int i2) {
        b lVar2;
        if (this.l != null) {
            if (this.o) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            v<?, ? super TranscodeType> vVar2;
            g gVar2;
            int i3;
            int i4;
            b a;
            b a2;
            v<?, ? super TranscodeType> vVar3 = this.l.i;
            if (d.equals(vVar3)) {
                vVar2 = vVar;
            } else {
                vVar2 = vVar3;
            }
            if (this.l.c.a(8)) {
                gVar2 = this.l.c.c;
            } else {
                gVar2 = a(gVar);
            }
            int i5 = this.l.c.j;
            int i6 = this.l.c.i;
            if (l.a(i, i2)) {
                g gVar3 = this.l.c;
                if (!l.a(gVar3.j, gVar3.i)) {
                    i5 = this.c.j;
                    i3 = this.c.i;
                    i4 = i5;
                    lVar2 = new com.bumptech.glide.f.l(lVar);
                    a = a(hVar, this.c, lVar2, vVar, gVar, i, i2);
                    this.o = true;
                    a2 = this.l.a(hVar, lVar2, vVar2, gVar2, i4, i3);
                    this.o = false;
                    lVar2.a(a, a2);
                    return lVar2;
                }
            }
            i3 = i6;
            i4 = i5;
            lVar2 = new com.bumptech.glide.f.l(lVar);
            a = a(hVar, this.c, lVar2, vVar, gVar, i, i2);
            this.o = true;
            a2 = this.l.a(hVar, lVar2, vVar2, gVar2, i4, i3);
            this.o = false;
            lVar2.a(a, a2);
            return lVar2;
        } else if (this.m != null) {
            lVar2 = new com.bumptech.glide.f.l(lVar);
            lVar2.a(a(hVar, this.c, lVar2, vVar, gVar, i, i2), a(hVar, this.c.a().a(this.m.floatValue()), lVar2, vVar, a(gVar), i, i2));
            return lVar2;
        } else {
            return a(hVar, this.c, lVar, vVar, gVar, i, i2);
        }
    }

    private b a(h<TranscodeType> hVar, g gVar, com.bumptech.glide.f.c cVar, v<?, ? super TranscodeType> vVar, g gVar2, int i, int i2) {
        gVar.f();
        return k.a(this.b, this.j, this.f, gVar, i, i2, gVar2, hVar, this.k, cVar, this.b.d, vVar.a);
    }

    public p<TranscodeType> a(@NonNull g gVar) {
        j.a((Object) gVar, "Argument must not be null");
        this.c = a().a(gVar);
        return this;
    }

    public p<TranscodeType> a(@NonNull v<?, ? super TranscodeType> vVar) {
        this.i = (v) j.a((Object) vVar, "Argument must not be null");
        return this;
    }

    public p<TranscodeType> a(@Nullable Object obj) {
        this.j = obj;
        this.n = true;
        return this;
    }
}
