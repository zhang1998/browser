package com.bumptech.glide.b.c;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* compiled from: ProGuard */
final class i implements g<InputStream> {
    final /* synthetic */ j a;

    i(j jVar) {
        this.a = jVar;
    }

    public final Class<InputStream> a() {
        return InputStream.class;
    }

    public final /* synthetic */ Object a(byte[] bArr) {
        return new ByteArrayInputStream(bArr);
    }
}
