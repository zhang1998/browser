package com.uc.base.wa.d;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: ProGuard */
final class i extends GZIPOutputStream {
    final /* synthetic */ j a;

    i(j jVar, OutputStream outputStream) {
        this.a = jVar;
        super(outputStream);
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            super.write(bArr, i, i2);
            k kVar = this.a.a;
            kVar.g = ((long) i2) + kVar.g;
        } catch (IOException e) {
            this.a.a.c = true;
            throw e;
        } catch (Throwable th) {
            this.a.a.c = true;
            RuntimeException runtimeException = new RuntimeException(th);
        }
    }
}
