package com.ucpro.business.a.b.a;

import com.uc.quark.s;
import com.ucweb.common.util.f.a;
import java.io.File;
import java.util.List;

/* compiled from: ProGuard */
final class g implements Runnable {
    final /* synthetic */ s a;
    final /* synthetic */ i b;

    g(i iVar, s sVar) {
        this.b = iVar;
        this.a = sVar;
    }

    public final void run() {
        if (this.b.b != null && !this.b.b.isEmpty() && this.b.b.get(0) != null) {
            String h = this.a.h();
            ((d) this.b.b.get(0)).d = h;
            try {
                List a = a.a(h, false);
                if (!a.isEmpty()) {
                    for (int i = 0; i < a.size(); i++) {
                        File file = (File) a.get(i);
                        if (file.getName().contains("-night")) {
                            ((d) this.b.b.get(0)).f = this.b.a() + file.getName();
                        } else {
                            ((d) this.b.b.get(0)).e = this.b.a() + file.getName();
                        }
                    }
                    a.a(h, this.b.a());
                    this.b.b(this.b.b);
                }
            } catch (Throwable th) {
            }
        }
    }
}
