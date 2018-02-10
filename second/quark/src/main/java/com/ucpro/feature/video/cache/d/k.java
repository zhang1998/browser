package com.ucpro.feature.video.cache.d;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class k implements j {
    private final String a = System.getProperty("java.io.tmpdir");
    private final List<s> b = new ArrayList();

    public final s a() throws Exception {
        s aVar = new a(this.a);
        this.b.add(aVar);
        return aVar;
    }

    public final void b() {
        for (s a : this.b) {
            try {
                a.a();
            } catch (Exception e) {
            }
        }
        this.b.clear();
    }
}
