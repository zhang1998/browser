package com.bumptech.glide.b.a;

import com.bumptech.glide.b.b.a.b;
import com.bumptech.glide.b.d.a.ad;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProGuard */
public final class p implements e<InputStream> {
    private final ad a;

    p(InputStream inputStream, b bVar) {
        this.a = new ad(inputStream, bVar);
        this.a.mark(5242880);
    }

    public final void b() {
        this.a.b();
    }

    public final /* synthetic */ Object a() throws IOException {
        this.a.reset();
        return this.a;
    }
}
