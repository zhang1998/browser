package com.bumptech.glide.b.d.a;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: ProGuard */
final class k implements m {
    private final ByteBuffer a;

    k(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
    }

    public final int a() throws IOException {
        return ((c() << 8) & 65280) | (c() & 255);
    }

    public final short b() throws IOException {
        return (short) (c() & 255);
    }

    public final long a(long j) throws IOException {
        int min = (int) Math.min((long) this.a.remaining(), j);
        this.a.position(this.a.position() + min);
        return (long) min;
    }

    public final int a(byte[] bArr, int i) throws IOException {
        int min = Math.min(i, this.a.remaining());
        if (min == 0) {
            return -1;
        }
        this.a.get(bArr, 0, min);
        return min;
    }

    public final int c() throws IOException {
        if (this.a.remaining() <= 0) {
            return -1;
        }
        return this.a.get();
    }
}
