package com.loc;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class bf implements Closeable {
    final Charset a;
    private final InputStream b;
    private byte[] c;
    private int d;
    private int e;

    public bf(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    private bf(InputStream inputStream, Charset charset, byte b) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (charset.equals(bg.a)) {
            this.b = inputStream;
            this.a = charset;
            this.c = new byte[SpdyProtocol.SLIGHTSSL_1_RTT_MODE];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    private void b() throws IOException {
        int read = this.b.read(this.c, 0, this.c.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.d = 0;
        this.e = read;
    }

    public final String a() throws IOException {
        String str;
        synchronized (this.b) {
            if (this.c == null) {
                throw new IOException("LineReader is closed");
            }
            int i;
            if (this.d >= this.e) {
                b();
            }
            int i2 = this.d;
            while (i2 != this.e) {
                if (this.c[i2] == (byte) 10) {
                    int i3 = (i2 == this.d || this.c[i2 - 1] != (byte) 13) ? i2 : i2 - 1;
                    str = new String(this.c, this.d, i3 - this.d, this.a.name());
                    this.d = i2 + 1;
                } else {
                    i2++;
                }
            }
            ByteArrayOutputStream beVar = new be(this, (this.e - this.d) + 80);
            loop1:
            while (true) {
                beVar.write(this.c, this.d, this.e - this.d);
                this.e = -1;
                b();
                i = this.d;
                while (i != this.e) {
                    if (this.c[i] == (byte) 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.d) {
                beVar.write(this.c, this.d, i - this.d);
            }
            this.d = i + 1;
            str = beVar.toString();
        }
        return str;
    }

    public final void close() throws IOException {
        synchronized (this.b) {
            if (this.c != null) {
                this.c = null;
                this.b.close();
            }
        }
    }
}
