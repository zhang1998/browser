package com.uc.base.wa.d;

import java.io.ByteArrayOutputStream;

/* compiled from: ProGuard */
final class h extends ByteArrayOutputStream {
    final /* synthetic */ j a;

    h(j jVar) {
        this.a = jVar;
    }

    public final void write(byte[] bArr, int i, int i2) {
        try {
            super.write(bArr, i, i2);
            k kVar = this.a.a;
            kVar.i = ((long) i2) + kVar.i;
        } catch (Throwable th) {
            this.a.a.c = true;
            RuntimeException runtimeException = new RuntimeException(th);
        }
    }
}
