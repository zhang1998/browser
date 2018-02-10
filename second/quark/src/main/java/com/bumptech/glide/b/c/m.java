package com.bumptech.glide.b.c;

import android.util.Log;
import com.bumptech.glide.b.a;
import com.bumptech.glide.b.a.b;
import com.bumptech.glide.b.a.c;
import com.bumptech.glide.g;
import java.io.File;
import java.nio.ByteBuffer;

/* compiled from: ProGuard */
final class m implements c<ByteBuffer> {
    private final File a;

    public m(File file) {
        this.a = file;
    }

    public final void a(g gVar, b<? super ByteBuffer> bVar) {
        try {
            bVar.a(com.bumptech.glide.util.c.a(this.a));
        } catch (Exception e) {
            Log.isLoggable("ByteBufferFileLoader", 3);
            bVar.a(e);
        }
    }

    public final void a() {
    }

    public final void b() {
    }

    public final Class<ByteBuffer> d() {
        return ByteBuffer.class;
    }

    public final a c() {
        return a.LOCAL;
    }
}
