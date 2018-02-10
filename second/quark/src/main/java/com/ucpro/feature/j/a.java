package com.ucpro.feature.j;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;
import com.ucpro.base.c.b.m;
import com.ucpro.feature.j.b.b;
import com.ucpro.feature.j.b.d;
import com.ucpro.feature.j.b.e;
import com.ucpro.feature.webwindow.bb;
import com.ucpro.ui.animation.g;

/* compiled from: ProGuard */
public final class a {
    public m a;
    public e b;
    public com.ucpro.feature.j.b.a c;
    public int d;
    public Handler e = new Handler(Looper.getMainLooper());
    public Runnable f = new d(this);

    public a(m mVar, e eVar) {
        this.a = mVar;
        this.b = eVar;
        eVar.setPresenter(this);
    }

    public final void a() {
        if (this.c != null && this.c.getParent() != null) {
            com.ucpro.feature.j.b.a aVar = this.c;
            g bVar = new b(this);
            if (aVar.b != null) {
                aVar.b.cancel();
            }
            aVar.b = ValueAnimator.ofFloat(new float[]{aVar.a, 0.0f});
            aVar.b.setDuration((long) (aVar.a * ((float) aVar.c)));
            aVar.b.addUpdateListener(new b(aVar));
            aVar.b.addListener(new d(aVar, bVar));
            aVar.b.start();
        }
    }

    public final bb b() {
        com.ucpro.base.c.b.g a = this.a.a();
        if (a instanceof bb) {
            return (bb) a;
        }
        return null;
    }
}
