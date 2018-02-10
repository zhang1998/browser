package com.bumptech.glide.b.d.e;

import com.bumptech.glide.gifdecoder.c;
import com.bumptech.glide.util.l;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Queue;

/* compiled from: ProGuard */
final class b {
    private final Queue<c> a = l.a(0);

    b() {
    }

    public final synchronized c a(ByteBuffer byteBuffer) {
        c cVar;
        cVar = (c) this.a.poll();
        if (cVar == null) {
            cVar = new c();
        }
        cVar.b = null;
        Arrays.fill(cVar.a, (byte) 0);
        cVar.c = new com.bumptech.glide.gifdecoder.b();
        cVar.d = 0;
        cVar.b = byteBuffer.asReadOnlyBuffer();
        cVar.b.position(0);
        cVar.b.order(ByteOrder.LITTLE_ENDIAN);
        return cVar;
    }

    public final synchronized void a(c cVar) {
        cVar.b = null;
        cVar.c = null;
        this.a.offer(cVar);
    }
}
