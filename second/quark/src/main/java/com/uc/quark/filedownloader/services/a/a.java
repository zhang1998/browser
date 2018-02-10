package com.uc.quark.filedownloader.services.a;

import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/* compiled from: ProGuard */
public final class a extends OutputStream {
    public RandomAccessFile a;

    public a(RandomAccessFile randomAccessFile) {
        this.a = randomAccessFile;
    }

    public final void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        this.a.write(bArr, i, i2);
    }

    public final void close() throws IOException {
        this.a.close();
    }
}
