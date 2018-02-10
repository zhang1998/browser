package com.c.a;

import android.content.Context;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.c.a.a.a;
import com.c.a.b.a.j;
import com.c.a.b.b.c;
import com.c.a.b.c.l;
import com.c.a.c.b;
import com.c.a.e.d;
import com.c.a.e.e;
import com.c.a.f.h;
import com.uc.apollo.annotation.KeepForSdk;

@KeepForSdk
/* compiled from: ProGuard */
public final class f {
    public j a;
    public c b;
    public l c;
    h d;
    public n e;
    q f;
    b g;
    public e h;
    private RectF i;
    private r j;

    private f(ad adVar) {
        this.i = new RectF(0.0f, 0.0f, 1024.0f, 1024.0f);
        if (com.c.a.e.b.a == null) {
            com.c.a.e.b.a = new Handler(Looper.getMainLooper());
        }
        this.h = new e();
        com.c.a.b.c.b bVar = new com.c.a.b.c.b();
        bVar.a = this.i;
        bVar.b = adVar.n;
        bVar.d = adVar.r;
        a aVar = new a();
        aVar.b = adVar.e;
        aVar.a = adVar.f;
        bVar.c = aVar;
        this.c = new l(adVar.c, this.h, bVar);
        this.c.a(adVar.d, adVar.g);
        this.b = new c(adVar.a, this.h);
        this.b.c = adVar.k;
        this.b.b = adVar.k.e;
        this.b.a(adVar.d, adVar.g);
        com.c.a.b.a.a aVar2 = new com.c.a.b.a.a();
        aVar2.c = this.c;
        aVar2.a = adVar.o;
        aVar2.b = adVar.p;
        this.a = new j(adVar.b, this.h, aVar2);
        this.a.a(adVar.d, adVar.g);
        this.d = new h();
        Context context = adVar.d;
        n nVar = adVar.q;
        if (d.a(context)) {
            nVar.b();
            v a = p.a(context);
            a.d = this.h;
            a.e = this.d;
            a.c = this.c;
            a.b = this.b;
            nVar.a(new p(a));
            this.e = nVar;
        } else {
            this.e.a().setVisibility(8);
            Toast.makeText(context, "OpenGLES2 not supported.", 0).show();
        }
        this.g = adVar.f;
        this.f = new q(adVar.d);
        this.f.a(adVar.h);
        this.f.f = adVar.i;
        af afVar = new af();
        this.f.a = new w(this, afVar);
        q qVar = this.f;
        com.c.a.a.b bVar2 = adVar.s;
        qVar.g = bVar2.b;
        qVar.h = bVar2.a;
        qVar.i = bVar2.d;
        qVar.j = bVar2.c;
        qVar.j = Math.max(qVar.g, qVar.j);
        qVar.j = Math.min(qVar.h, qVar.j);
        qVar.a(qVar.j);
        this.e.a().setOnTouchListener(new c(this));
        aa aaVar = new aa();
        aaVar.c = this.d;
        aaVar.a = this.b;
        aaVar.b = this.c;
        this.j = new r(aaVar);
        this.j.a = adVar.j;
        this.j.d = adVar.l;
        this.j.e = adVar.m;
        this.f.a(this.j.f);
        h hVar = this.d;
        hVar.a.add(this.j.g);
    }

    public final void a(Context context) {
        this.a.a(context);
        if (this.e != null) {
            this.e.c();
        }
    }
}
