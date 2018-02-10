package com.ucpro.business.e.d;

import android.util.Log;
import com.uc.a.b.e;
import com.ucpro.business.d.a;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ e b;
    final /* synthetic */ boolean[] c;
    final /* synthetic */ g d;

    c(g gVar, a aVar, e eVar, boolean[] zArr) {
        this.d = gVar;
        this.a = aVar;
        this.b = eVar;
        this.c = zArr;
    }

    public final void run() {
        if (!this.a.a(com.ucpro.business.e.f.a.b(this.b))) {
            Log.e("hjw-us", "decodeUsItemByNative fail!", new Throwable());
            this.c[0] = false;
        }
    }
}
