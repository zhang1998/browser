package com.bumptech.glide.util;

import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProGuard */
public final class h extends FilterInputStream {
    private int a = SectionHeader.SHT_LOUSER;

    public h(InputStream inputStream) {
        super(inputStream);
    }

    public final void mark(int i) {
        super.mark(i);
        this.a = i;
    }

    public final int read() throws IOException {
        if (a(1) == -1) {
            return -1;
        }
        int read = super.read();
        b(1);
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int a = (int) a((long) i2);
        if (a == -1) {
            return -1;
        }
        int read = super.read(bArr, i, a);
        b((long) read);
        return read;
    }

    public final void reset() throws IOException {
        super.reset();
        this.a = SectionHeader.SHT_LOUSER;
    }

    public final long skip(long j) throws IOException {
        long a = a(j);
        if (a == -1) {
            return -1;
        }
        long skip = super.skip(a);
        b(skip);
        return skip;
    }

    public final int available() throws IOException {
        if (this.a == SectionHeader.SHT_LOUSER) {
            return super.available();
        }
        return Math.min(this.a, super.available());
    }

    private long a(long j) {
        if (this.a == 0) {
            return -1;
        }
        if (this.a == SectionHeader.SHT_LOUSER || j <= ((long) this.a)) {
            return j;
        }
        return (long) this.a;
    }

    private void b(long j) {
        if (this.a != SectionHeader.SHT_LOUSER && j != -1) {
            this.a = (int) (((long) this.a) - j);
        }
    }
}
