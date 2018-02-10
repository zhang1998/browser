package com.ucpro.feature.s.a;

import android.text.TextUtils;
import com.ucweb.common.util.l.d;
import com.ucweb.common.util.n.a;
import java.io.File;
import java.util.List;

/* compiled from: ProGuard */
final class e implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ g b;

    e(g gVar, List list) {
        this.b = gVar;
        this.a = list;
    }

    public final void run() {
        this.b.b = this.a;
        if (this.a.size() > 0) {
            long j = ((a) this.a.get(0)).t;
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            String str = ((a) this.a.get(0)).a;
            if (!a.a(str) && !TextUtils.isEmpty(str)) {
                List d = this.b.d();
                if (currentTimeMillis >= j) {
                    return;
                }
                if (d == null || !new File(this.b.a() + "navi.json").exists() || !a.d(d.a(str, ""), d.a(((a) d.get(0)).a, ""))) {
                    this.b.b(this.a);
                    this.b.a(str, d.a(str, ""));
                }
            }
        }
    }
}
