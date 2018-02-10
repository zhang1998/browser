package com.bumptech.glide.b.d.e;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bumptech.glide.b.b.a.g;
import com.bumptech.glide.b.b.w;
import com.bumptech.glide.c;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.p;
import com.bumptech.glide.u;
import com.bumptech.glide.util.j;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class n {
    final GifDecoder a;
    final Handler b;
    final List<k> c;
    final u d;
    boolean e;
    boolean f;
    j g;
    boolean h;
    j i;
    Bitmap j;
    private final g k;
    private boolean l;
    private p<Bitmap> m;
    private com.bumptech.glide.b.p<Bitmap> n;

    private n(g gVar, u uVar, GifDecoder gifDecoder, p<Bitmap> pVar, com.bumptech.glide.b.p<Bitmap> pVar2, Bitmap bitmap) {
        this.c = new ArrayList();
        this.e = false;
        this.f = false;
        this.l = false;
        this.d = uVar;
        Handler handler = new Handler(Looper.getMainLooper(), new l(this));
        this.k = gVar;
        this.b = handler;
        this.m = pVar;
        this.a = gifDecoder;
        a(pVar2, bitmap);
    }

    final int a() {
        return this.a.d();
    }

    final Bitmap b() {
        if (this.g != null) {
            return this.g.b;
        }
        return this.j;
    }

    final void c() {
        if (this.e && !this.f) {
            if (this.l) {
                this.a.f();
                this.l = false;
            }
            this.f = true;
            long c = ((long) this.a.c()) + SystemClock.uptimeMillis();
            this.a.b();
            this.i = new j(this.b, this.a.e(), c);
            this.m.b().a(com.bumptech.glide.f.g.a(new m())).a(this.a).a(this.i);
        }
    }

    final void d() {
        if (this.j != null) {
            this.k.a(this.j);
            this.j = null;
        }
    }

    public n(c cVar, GifDecoder gifDecoder, int i, int i2, com.bumptech.glide.b.p<Bitmap> pVar, Bitmap bitmap) {
        this(cVar.b, c.b(cVar.c.getBaseContext()), gifDecoder, c.b(cVar.c.getBaseContext()).e().a(com.bumptech.glide.f.g.a(w.b).a(true).a(i, i2)), (com.bumptech.glide.b.p) pVar, bitmap);
    }

    final void a(com.bumptech.glide.b.p<Bitmap> pVar, Bitmap bitmap) {
        this.n = (com.bumptech.glide.b.p) j.a((Object) pVar, "Argument must not be null");
        this.j = (Bitmap) j.a((Object) bitmap, "Argument must not be null");
        this.m = this.m.a(new com.bumptech.glide.f.g().a((com.bumptech.glide.b.p) pVar));
    }
}
