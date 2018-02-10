package com.a.a.a;

import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: ProGuard */
public final class j extends k {
    protected InputStream a = null;
    protected OutputStream b = null;

    protected j() {
    }

    public j(OutputStream outputStream) {
        this.b = outputStream;
    }

    public final int a(byte[] bArr, int i, int i2) throws h {
        if (this.a == null) {
            throw new h("Cannot read from null inputStream");
        }
        try {
            int read = this.a.read(bArr, i, i2);
            if (read >= 0) {
                return read;
            }
            throw new h((byte) 0);
        } catch (Throwable e) {
            throw new h(e);
        }
    }

    public final void b(byte[] bArr, int i, int i2) throws h {
        if (this.b == null) {
            throw new h("Cannot write to null outputStream");
        }
        try {
            this.b.write(bArr, i, i2);
        } catch (Throwable e) {
            throw new h(e);
        }
    }
}
