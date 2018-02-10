package facerecognition.register;

import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class a implements Runnable {
    final /* synthetic */ f a;

    a(f fVar) {
        this.a = fVar;
    }

    public final void run() {
        this.a.c.b = true;
        Runnable fVar = new f(this.a.c);
        fVar.a = d.d;
        m.a(2, fVar);
    }
}
