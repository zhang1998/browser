package com.uc.weex.component.c.a;

import android.view.MotionEvent;

/* compiled from: ProGuard */
public final class m implements l {
    final n a;
    final /* synthetic */ q b;

    public m(q qVar) {
        this.b = qVar;
        this.a = qVar.a();
    }

    public final int a() {
        return 0;
    }

    public final boolean a(MotionEvent motionEvent) {
        if (!this.a.a(this.b.b.a(), motionEvent)) {
            return false;
        }
        if ((!this.b.b.b() || !this.a.c) && (!this.b.b.c() || this.a.c)) {
            return false;
        }
        this.b.a.a = motionEvent.getPointerId(0);
        this.b.a.b = this.a.a;
        this.b.a.c = this.a.c;
        this.b.a(this.b.d);
        return this.b.d.a(motionEvent);
    }

    public final boolean b() {
        return false;
    }

    public final void a(l lVar) {
        this.b.g.a(lVar.a(), 0, this.b.c() - this.b.k);
    }
}
