package com.bumptech.glide.b.b.b;

import com.bumptech.glide.util.a.d;
import java.security.MessageDigest;

/* compiled from: ProGuard */
final class t implements d<u> {
    final /* synthetic */ v a;

    t(v vVar) {
        this.a = vVar;
    }

    public final /* synthetic */ Object a() {
        return b();
    }

    private static u b() {
        try {
            return new u(MessageDigest.getInstance("SHA-256"));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
