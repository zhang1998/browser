package com.a.a.a;

import java.io.ByteArrayOutputStream;

/* compiled from: ProGuard */
public final class e {
    private final ByteArrayOutputStream a;
    private final j b;
    private t c;

    public e() {
        this(new v());
    }

    private e(x xVar) {
        this.a = new ByteArrayOutputStream();
        this.b = new j(this.a);
        this.c = xVar.a(this.b);
    }

    public final byte[] a(c cVar) throws g {
        this.a.reset();
        cVar.b(this.c);
        return this.a.toByteArray();
    }
}
