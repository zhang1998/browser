package com.bumptech.glide.b.d.b;

import com.bumptech.glide.b.b.au;
import com.bumptech.glide.util.j;

/* compiled from: ProGuard */
public final class c implements au<byte[]> {
    private final byte[] a;

    public c(byte[] bArr) {
        this.a = (byte[]) j.a((Object) bArr, "Argument must not be null");
    }

    public final Class<byte[]> a() {
        return byte[].class;
    }

    public final int c() {
        return this.a.length;
    }

    public final void d() {
    }

    public final /* bridge */ /* synthetic */ Object b() {
        return this.a;
    }
}
