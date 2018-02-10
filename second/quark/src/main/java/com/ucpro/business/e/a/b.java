package com.ucpro.business.e.a;

import android.text.TextUtils;
import android.util.Log;
import com.uc.a.d.c;
import com.uc.a.d.g;
import com.uc.a.d.p;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ a b;

    b(a aVar, boolean z) {
        this.b = aVar;
        this.a = z;
    }

    public final void run() {
        p a = this.b.b;
        boolean z = this.a;
        c.a();
        g b = c.b();
        if (b == null) {
            Log.e("us", "[us] main server is null");
            return;
        }
        String str = b.c;
        int i = b.d;
        new StringBuilder("[us] try to request us (").append(str).append(", ").append(i / 60).append("min)");
        if (TextUtils.isEmpty(str)) {
            Log.w("us", "[us] empty serverUrl");
            return;
        }
        if (i < 0) {
            i = 0;
        }
        c.a();
        c.a(str, i);
        if (!z) {
            c.a();
            if (!c.a(c.b())) {
                return;
            }
        }
        a.a.a();
        new StringBuilder("[us] start to request us (").append(str).append(", ").append(i / 60).append("min)");
    }
}
