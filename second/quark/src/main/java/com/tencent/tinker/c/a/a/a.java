package com.tencent.tinker.c.a.a;

import com.tencent.tinker.c.a.b.b;
import java.io.ByteArrayOutputStream;

/* compiled from: ProGuard */
final class a implements b {
    final /* synthetic */ ByteArrayOutputStream a;
    final /* synthetic */ b b;

    a(b bVar, ByteArrayOutputStream byteArrayOutputStream) {
        this.b = bVar;
        this.a = byteArrayOutputStream;
    }

    public final void a(int i) {
        this.a.write(i);
    }
}
