package com.uc.quark.filedownloader.d;

import com.uc.quark.g;
import com.uc.quark.w;
import java.io.IOException;

/* compiled from: ProGuard */
public final class c implements w {
    private final a a;

    public c() {
        this((byte) 0);
    }

    private c(byte b) {
        this.a = null;
    }

    public final g a(String str) throws IOException {
        return new b(str, this.a);
    }
}
