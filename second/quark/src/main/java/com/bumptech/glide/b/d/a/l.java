package com.bumptech.glide.b.d.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: ProGuard */
final class l {
    final ByteBuffer a;

    l(byte[] bArr, int i) {
        this.a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
    }

    final int a(int i) {
        return a(i, 4) ? this.a.getInt(i) : -1;
    }

    final short b(int i) {
        return a(i, 2) ? this.a.getShort(i) : (short) -1;
    }

    private boolean a(int i, int i2) {
        return this.a.remaining() - i >= i2;
    }
}
