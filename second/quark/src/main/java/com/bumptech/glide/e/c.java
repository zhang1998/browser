package com.bumptech.glide.e;

import com.bumptech.glide.b.g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class c {
    private final List<g> a = new ArrayList();

    public final synchronized List<g> a() {
        return this.a;
    }

    public final synchronized void a(g gVar) {
        this.a.add(gVar);
    }
}
