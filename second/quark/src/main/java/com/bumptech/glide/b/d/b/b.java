package com.bumptech.glide.b.d.b;

import com.bumptech.glide.b.a.e;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ProGuard */
public final class b implements e<ByteBuffer> {
    private final ByteBuffer a;

    public b(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    public final void b() {
    }

    public final /* synthetic */ Object a() throws IOException {
        this.a.position(0);
        return this.a;
    }
}
