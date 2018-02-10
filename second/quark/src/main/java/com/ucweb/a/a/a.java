package com.ucweb.a.a;

import com.ucweb.a.b.d;
import com.ucweb.a.l;
import com.ucweb.a.r;
import com.ucweb.a.s;
import java.io.File;

/* compiled from: ProGuard */
final class a implements Runnable {
    final /* synthetic */ d a;
    final /* synthetic */ boolean b;

    a(d dVar, boolean z) {
        this.a = dVar;
        this.b = z;
    }

    public final void run() {
        c.b;
        l lVar = new l();
        lVar.c = this.a;
        boolean z = this.b;
        new StringBuilder("[").append(c.c().r()).append("]").append(c.c().r()).append("启动完成,准备检查更新.");
        lVar.a = false;
        s sVar = new s();
        sVar.a = c.c().r();
        sVar.b = 1;
        sVar.f = z;
        sVar.g = 0;
        if (lVar.b == null) {
            try {
                lVar.b = c.b().b(new File(c.d().getApplicationInfo().sourceDir));
                if (!lVar.a) {
                    sVar.c = lVar.b;
                    r.a().a(sVar);
                    return;
                }
                return;
            } catch (Exception e) {
                return;
            }
        }
        sVar.c = lVar.b;
        r.a().a(sVar);
    }
}
