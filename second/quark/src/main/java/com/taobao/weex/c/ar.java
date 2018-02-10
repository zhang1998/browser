package com.taobao.weex.c;

import android.mini.support.annotation.NonNull;
import com.taobao.weex.c.b.c;
import com.taobao.weex.c.b.j;
import com.taobao.weex.c.b.k;
import com.taobao.weex.c.b.q;

/* compiled from: ProGuard */
final class ar implements j {
    ar() {
    }

    public final void a(k kVar, float f, @NonNull q qVar) {
        at atVar = (at) kVar;
        if (c.a(f)) {
            f = kVar.a_.q;
        }
        if (atVar.a(atVar.N, f, false) > 0.0f) {
            atVar.P = atVar.a(f, false, null);
            atVar.A = true;
            atVar.H = (float) atVar.P.getWidth();
            qVar.b = (float) atVar.P.getHeight();
            qVar.a = atVar.H;
            return;
        }
        qVar.b = 0.0f;
        qVar.a = 0.0f;
    }
}
