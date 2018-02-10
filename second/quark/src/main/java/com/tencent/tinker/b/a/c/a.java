package com.tencent.tinker.b.a.c;

import java.io.ByteArrayInputStream;

/* compiled from: ProGuard */
public final class a implements com.tencent.tinker.c.a.b.a {
    final /* synthetic */ ByteArrayInputStream a;
    final /* synthetic */ f b;

    public a(f fVar, ByteArrayInputStream byteArrayInputStream) {
        this.b = fVar;
        this.a = byteArrayInputStream;
    }

    public final byte a() {
        return (byte) (this.a.read() & 255);
    }
}
