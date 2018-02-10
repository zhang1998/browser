package com.bumptech.glide.b.b.b;

import java.io.File;

/* compiled from: ProGuard */
public class i implements a {
    private final int a;
    private final h b;

    public i(h hVar, int i) {
        this.a = i;
        this.b = hVar;
    }

    public final c a() {
        File a = this.b.a();
        if (a == null) {
            return null;
        }
        if (a.mkdirs() || (a.exists() && a.isDirectory())) {
            return j.a(a, this.a);
        }
        return null;
    }
}
