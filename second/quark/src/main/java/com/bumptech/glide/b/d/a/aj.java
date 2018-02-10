package com.bumptech.glide.b.d.a;

import com.bumptech.glide.b.k;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: ProGuard */
final class aj implements k<Integer> {
    private final ByteBuffer a = ByteBuffer.allocate(4);

    aj() {
    }

    public final /* synthetic */ void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        Integer num = (Integer) obj;
        if (num != null) {
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putInt(num.intValue()).array());
            }
        }
    }
}
