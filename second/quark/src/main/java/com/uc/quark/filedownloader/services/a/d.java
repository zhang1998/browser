package com.uc.quark.filedownloader.services.a;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* compiled from: ProGuard */
public final class d extends OutputStream {
    private FileDescriptor a;
    private FileOutputStream b;

    public d(FileDescriptor fileDescriptor) {
        a(fileDescriptor);
    }

    public final d a(FileDescriptor fileDescriptor) {
        this.a = fileDescriptor;
        this.b = new FileOutputStream(this.a);
        return this;
    }

    public final void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        this.b.write(ByteBuffer.wrap(bArr).array(), i, i2);
    }

    public final void close() throws IOException {
        this.b.close();
    }
}
