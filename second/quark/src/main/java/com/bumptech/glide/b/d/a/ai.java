package com.bumptech.glide.b.d.a;

import com.bumptech.glide.b.k;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: ProGuard */
final class ai implements k<Long> {
    private final ByteBuffer a = ByteBuffer.allocate(8);

    ai() {
    }

    public final /* synthetic */ void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        Long l = (Long) obj;
        messageDigest.update(bArr);
        synchronized (this.a) {
            this.a.position(0);
            messageDigest.update(this.a.putLong(l.longValue()).array());
        }
    }
}
