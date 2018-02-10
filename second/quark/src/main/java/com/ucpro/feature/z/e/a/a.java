package com.ucpro.feature.z.e.a;

import android.text.TextUtils;
import com.ucweb.common.util.l.d;
import java.util.List;

/* compiled from: ProGuard */
final class a implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ f b;

    a(f fVar, List list) {
        this.b = fVar;
        this.a = list;
    }

    public final void run() {
        this.b.b = this.a;
        if (this.a.size() > 0) {
            String str = ((b) this.a.get(0)).a;
            if (!com.ucweb.common.util.n.a.a(str)) {
                List d = this.b.d();
                if (d == null || d.isEmpty() || d.get(0) == null || TextUtils.isEmpty(((b) d.get(0)).a) || !((b) d.get(0)).a.equals(str) || !com.ucweb.common.util.k.a.h(this.b.a() + "data")) {
                    this.b.b(this.a);
                    this.b.a(str, d.a(str, ""));
                }
            }
        }
    }
}
