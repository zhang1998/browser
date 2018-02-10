package com.bumptech.glide.f;

import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import com.bumptech.glide.b.b.w;
import com.bumptech.glide.b.d.a.aa;
import com.bumptech.glide.b.d.a.c;
import com.bumptech.glide.b.d.a.h;
import com.bumptech.glide.b.d.a.r;
import com.bumptech.glide.b.d.a.z;
import com.bumptech.glide.b.d.e.f;
import com.bumptech.glide.b.i;
import com.bumptech.glide.b.l;
import com.bumptech.glide.b.m;
import com.bumptech.glide.b.p;
import com.bumptech.glide.g.a;
import com.bumptech.glide.util.j;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.uc.crashsdk.export.LogType;
import com.uc.imagecodec.export.IPictureView;
import java.util.HashMap;
import java.util.Map;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public class g implements Cloneable {
    float a = IPictureView.DEFAULT_MIN_SCALE;
    w b = w.e;
    public com.bumptech.glide.g c = com.bumptech.glide.g.NORMAL;
    Drawable d;
    int e;
    Drawable f;
    int g;
    boolean h = true;
    public int i = -1;
    public int j = -1;
    i k = a.a();
    boolean l;
    public boolean m = true;
    Drawable n;
    int o;
    public m p = new m();
    Map<Class<?>, p<?>> q = new HashMap();
    Class<?> r = Object.class;
    public boolean s;
    Theme t;
    boolean u;
    boolean v;
    private int w;
    private boolean x;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    public static g a(@NonNull w wVar) {
        return new g().b(wVar);
    }

    public static g a(@NonNull i iVar) {
        return new g().b(iVar);
    }

    public static g a(@NonNull Class<?> cls) {
        return new g().b((Class) cls);
    }

    private static boolean b(int i, int i2) {
        return (i & i2) != 0;
    }

    public g a(float f) {
        if (this.x) {
            return a().a(f);
        }
        if (f < 0.0f || f > IPictureView.DEFAULT_MIN_SCALE) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.a = f;
        this.w |= 2;
        return h();
    }

    public g b(@NonNull w wVar) {
        if (this.x) {
            return a().b(wVar);
        }
        this.b = (w) j.a((Object) wVar, "Argument must not be null");
        this.w |= 4;
        return h();
    }

    public g a(@NonNull com.bumptech.glide.g gVar) {
        if (this.x) {
            return a().a(gVar);
        }
        this.c = (com.bumptech.glide.g) j.a((Object) gVar, "Argument must not be null");
        this.w |= 8;
        return h();
    }

    public g a(boolean z) {
        boolean z2 = true;
        if (this.x) {
            return a().a(true);
        }
        if (z) {
            z2 = false;
        }
        this.h = z2;
        this.w |= LogType.UNEXP;
        return h();
    }

    public g a(int i, int i2) {
        if (this.x) {
            return a().a(i, i2);
        }
        this.j = i;
        this.i = i2;
        this.w |= 512;
        return h();
    }

    public g b(@NonNull i iVar) {
        if (this.x) {
            return a().b(iVar);
        }
        this.k = (i) j.a((Object) iVar, "Argument must not be null");
        this.w |= 1024;
        return h();
    }

    public g a() {
        try {
            g gVar = (g) super.clone();
            gVar.p = new m();
            gVar.p.a(this.p);
            gVar.q = new HashMap();
            gVar.q.putAll(this.q);
            gVar.s = false;
            gVar.x = false;
            return gVar;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public <T> g a(@NonNull l<T> lVar, @NonNull T t) {
        if (this.x) {
            return a().a((l) lVar, (Object) t);
        }
        j.a((Object) lVar, "Argument must not be null");
        j.a((Object) t, "Argument must not be null");
        this.p.b.put(lVar, t);
        return h();
    }

    public g b(@NonNull Class<?> cls) {
        if (this.x) {
            return a().b((Class) cls);
        }
        this.r = (Class) j.a((Object) cls, "Argument must not be null");
        this.w |= SpdyProtocol.SLIGHTSSL_0_RTT_MODE;
        return h();
    }

    public g a(@NonNull z zVar) {
        return a(r.b, j.a((Object) zVar, "Argument must not be null"));
    }

    public g b() {
        return a(z.b, new h());
    }

    public g c() {
        return a(z.a, new aa());
    }

    public g d() {
        return a(z.e, new com.bumptech.glide.b.d.a.i());
    }

    public g e() {
        z zVar = z.e;
        p jVar = new com.bumptech.glide.b.d.a.j();
        while (this.x) {
            this = a();
        }
        a(zVar);
        return a(jVar);
    }

    private g a(z zVar, p<Bitmap> pVar) {
        while (this.x) {
            this = a();
        }
        a(zVar);
        return b((p) pVar);
    }

    public g a(@NonNull p<Bitmap> pVar) {
        if (this.x) {
            return a().a((p) pVar);
        }
        b((p) pVar);
        this.l = true;
        this.w |= 131072;
        return h();
    }

    public g b(p<Bitmap> pVar) {
        if (this.x) {
            return a().b((p) pVar);
        }
        a(Bitmap.class, (p) pVar);
        a(BitmapDrawable.class, new c(pVar));
        a(f.class, new com.bumptech.glide.b.d.e.i(pVar));
        return h();
    }

    public <T> g a(Class<T> cls, p<T> pVar) {
        if (this.x) {
            return a().a((Class) cls, (p) pVar);
        }
        j.a((Object) cls, "Argument must not be null");
        j.a((Object) pVar, "Argument must not be null");
        this.q.put(cls, pVar);
        this.w |= 2048;
        this.m = true;
        this.w |= 65536;
        return h();
    }

    public g a(g gVar) {
        if (this.x) {
            return a().a(gVar);
        }
        if (b(gVar.w, 2)) {
            this.a = gVar.a;
        }
        if (b(gVar.w, 262144)) {
            this.u = gVar.u;
        }
        if (b(gVar.w, 4)) {
            this.b = gVar.b;
        }
        if (b(gVar.w, 8)) {
            this.c = gVar.c;
        }
        if (b(gVar.w, 16)) {
            this.d = gVar.d;
        }
        if (b(gVar.w, 32)) {
            this.e = gVar.e;
        }
        if (b(gVar.w, 64)) {
            this.f = gVar.f;
        }
        if (b(gVar.w, 128)) {
            this.g = gVar.g;
        }
        if (b(gVar.w, LogType.UNEXP)) {
            this.h = gVar.h;
        }
        if (b(gVar.w, 512)) {
            this.j = gVar.j;
            this.i = gVar.i;
        }
        if (b(gVar.w, 1024)) {
            this.k = gVar.k;
        }
        if (b(gVar.w, SpdyProtocol.SLIGHTSSL_0_RTT_MODE)) {
            this.r = gVar.r;
        }
        if (b(gVar.w, SpdyProtocol.SLIGHTSSL_1_RTT_MODE)) {
            this.n = gVar.n;
        }
        if (b(gVar.w, 16384)) {
            this.o = gVar.o;
        }
        if (b(gVar.w, WXMediaMessage.THUMB_LENGTH_LIMIT)) {
            this.t = gVar.t;
        }
        if (b(gVar.w, 65536)) {
            this.m = gVar.m;
        }
        if (b(gVar.w, 131072)) {
            this.l = gVar.l;
        }
        if (b(gVar.w, 2048)) {
            this.q.putAll(gVar.q);
        }
        if (b(gVar.w, 524288)) {
            this.v = gVar.v;
        }
        if (!this.m) {
            this.q.clear();
            this.w &= -2049;
            this.l = false;
            this.w &= -131073;
        }
        this.w |= gVar.w;
        this.p.a(gVar.p);
        return h();
    }

    public g f() {
        this.s = true;
        return this;
    }

    public g g() {
        if (!this.s || this.x) {
            this.x = true;
            return f();
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    private g h() {
        if (!this.s) {
            return this;
        }
        throw new IllegalStateException("You cannot modify locked RequestOptions, consider clone()");
    }

    public final boolean a(int i) {
        return b(this.w, i);
    }
}
