package com.loc;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: ProGuard */
final class ay extends FilterOutputStream {
    final /* synthetic */ az a;

    private ay(az azVar, OutputStream outputStream) {
        this.a = azVar;
        super(outputStream);
    }

    public final void close() {
        try {
            this.out.close();
        } catch (IOException e) {
            this.a.c = true;
        }
    }

    public final void flush() {
        try {
            this.out.flush();
        } catch (IOException e) {
            this.a.c = true;
        }
    }

    public final void write(int i) {
        try {
            this.out.write(i);
        } catch (IOException e) {
            this.a.c = true;
        }
    }

    public final void write(byte[] bArr, int i, int i2) {
        try {
            this.out.write(bArr, i, i2);
        } catch (IOException e) {
            this.a.c = true;
        }
    }
}
