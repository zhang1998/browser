package com.alibaba.analytics.core.c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ProGuard */
public final class g {
    private static d b;
    private List<d> a = Collections.synchronizedList(new ArrayList());

    public final void a(d dVar) {
        this.a.add(dVar);
    }

    public final void a(i iVar) {
        if (b != null) {
            b.a(iVar);
        }
        for (int i = 0; i < this.a.size(); i++) {
            ((d) this.a.get(i)).a(iVar);
        }
    }
}
