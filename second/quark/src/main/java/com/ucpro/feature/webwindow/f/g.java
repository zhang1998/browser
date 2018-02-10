package com.ucpro.feature.webwindow.f;

import android.text.TextUtils;
import com.uc.base.b.c.b.c;
import com.ucpro.business.d.e;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProGuard */
final class g implements Runnable {
    final /* synthetic */ byte[] a;
    final /* synthetic */ String b;
    final /* synthetic */ c c;

    g(c cVar, byte[] bArr, String str) {
        this.c = cVar;
        this.a = bArr;
        this.b = str;
    }

    public final void run() {
        if (this.a != null && this.a.length > 0) {
            c eVar = new e();
            if (com.uc.a.d.e.a(this.a, eVar)) {
                Object c = eVar.c();
                if (!TextUtils.isEmpty(c)) {
                    CharSequence d = c.d(c);
                    if (!TextUtils.isEmpty(d)) {
                        synchronized ("java_script_map") {
                            if (this.c.b == null) {
                                this.c.b = new ConcurrentHashMap();
                            }
                            this.c.b.putIfAbsent(this.b, d);
                        }
                    }
                }
            }
        }
    }
}
