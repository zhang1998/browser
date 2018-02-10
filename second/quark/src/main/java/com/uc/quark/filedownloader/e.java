package com.uc.quark.filedownloader;

import com.uc.quark.filedownloader.e.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public final class e {
    private final ac a;
    private List<Map<String, Object>> b;

    private e() {
        this.a = new ac();
        this.b = new ArrayList();
    }

    final synchronized void a(o oVar) {
        if (oVar.a.K().M().E() == 0) {
            this.a.a.execute(new k(oVar));
        }
    }

    public final synchronized void a() {
        ac acVar = this.a;
        if (j.a) {
            j.d(acVar, "expire %d tasks", Integer.valueOf(acVar.b.size()));
        }
        acVar.a.shutdownNow();
        acVar.a();
    }

    final synchronized void a(an anVar) {
        this.a.b.remove(anVar);
    }
}
