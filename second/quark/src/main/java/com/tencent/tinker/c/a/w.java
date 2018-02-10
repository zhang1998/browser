package com.tencent.tinker.c.a;

import com.tencent.tinker.c.a.b.a;

/* compiled from: ProGuard */
final class w implements a {
    final /* synthetic */ x a;
    private int b = 0;

    w(x xVar) {
        this.a = xVar;
    }

    public final byte a() {
        byte[] bArr = this.a.a;
        int i = this.b;
        this.b = i + 1;
        return bArr[i];
    }
}
