package com.tencent.tinker.b.a.c;

import com.tencent.tinker.c.a.b.b;
import java.io.ByteArrayOutputStream;

/* compiled from: ProGuard */
public final class c implements b {
    final /* synthetic */ ByteArrayOutputStream a;
    final /* synthetic */ f b;

    public c(f fVar, ByteArrayOutputStream byteArrayOutputStream) {
        this.b = fVar;
        this.a = byteArrayOutputStream;
    }

    public final void a(int i) {
        this.a.write(i);
    }
}
