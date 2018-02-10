package com.tencent.tinker.b.c;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.zip.ZipException;

/* compiled from: ProGuard */
public final class j extends FilterOutputStream {
    public static final byte[] a = new byte[0];
    private static final byte[] c = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1};
    public byte[] b;
    private final HashSet<String> d;
    private final boolean e;
    private int f;
    private ByteArrayOutputStream g;
    private f h;
    private long i;
    private byte[] j;
    private byte[] k;
    private boolean l;

    public j(OutputStream outputStream) {
        this(outputStream, (byte) 0);
    }

    private j(OutputStream outputStream, byte b) {
        super(outputStream);
        this.d = new HashSet();
        this.b = a;
        this.f = 8;
        this.g = new ByteArrayOutputStream();
        this.i = 0;
        this.e = false;
    }

    private static long a(OutputStream outputStream, long j) throws IOException {
        outputStream.write((int) (255 & j));
        outputStream.write(((int) (j >> 8)) & 255);
        outputStream.write(((int) (j >> 16)) & 255);
        outputStream.write(((int) (j >> 24)) & 255);
        return j;
    }

    private static int a(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        return i;
    }

    public final void close() throws IOException {
        if (this.out == null) {
            return;
        }
        if (this.out == null) {
            throw new IOException("Stream is closed");
        }
        if (this.g != null) {
            if (this.d.isEmpty()) {
                throw new ZipException("No entries");
            }
            if (this.h != null) {
                a();
            }
            int size = this.g.size();
            a(this.g, 101010256);
            a(this.g, 0);
            a(this.g, 0);
            if (this.l) {
                a(this.g, 65535);
                a(this.g, 65535);
                a(this.g, -1);
                a(this.g, -1);
            } else {
                a(this.g, this.d.size());
                a(this.g, this.d.size());
                a(this.g, (long) size);
                a(this.g, this.i);
            }
            a(this.g, this.b.length);
            if (this.b.length > 0) {
                this.g.write(this.b);
            }
            this.g.writeTo(this.out);
            this.g = null;
        }
        this.out.close();
        this.out = null;
    }

    public final void a() throws IOException {
        b();
        if (this.h != null) {
            long j = 30;
            if (this.h.f != 0) {
                j = 46;
                a(this.out, 134695760);
                a(this.out, this.h.c);
                a(this.out, this.h.d);
                a(this.out, this.h.e);
            }
            int i = (this.h.f == 0 ? 0 : 8) | 2048;
            a(this.g, 33639248);
            a(this.g, 20);
            a(this.g, 20);
            a(this.g, i);
            a(this.g, this.h.f);
            a(this.g, this.h.g);
            a(this.g, this.h.h);
            a(this.g, this.h.c);
            if (this.h.f == 8) {
                j += this.h.d;
            } else {
                j += this.h.e;
            }
            a(this.g, this.h.d);
            a(this.g, this.h.e);
            j += (long) a(this.g, this.j.length);
            if (this.h.i != null) {
                j += (long) a(this.g, this.h.i.length);
            } else {
                a(this.g, 0);
            }
            a(this.g, this.k.length);
            a(this.g, 0);
            a(this.g, 0);
            a(this.g, 0);
            a(this.g, this.h.j);
            this.g.write(this.j);
            this.j = null;
            if (this.h.i != null) {
                this.g.write(this.h.i);
            }
            this.i = j + this.i;
            if (this.k.length > 0) {
                this.g.write(this.k);
                this.k = a;
            }
            this.h = null;
        }
    }

    public final void a(f fVar) throws IOException {
        int i;
        if (this.h != null) {
            a();
        }
        int i2 = fVar.f;
        if (i2 == -1) {
            i = this.f;
        } else {
            i = i2;
        }
        if (i == 0) {
            if (fVar.d == -1) {
                fVar.d = fVar.e;
            } else if (fVar.e == -1) {
                fVar.a(fVar.d);
            }
            if (fVar.c == -1) {
                throw new ZipException("STORED entry missing CRC");
            } else if (fVar.e == -1) {
                throw new ZipException("STORED entry missing size");
            } else if (fVar.e != fVar.d) {
                throw new ZipException("STORED entry size/compressed size mismatch");
            }
        }
        b();
        fVar.b = null;
        fVar.i = null;
        fVar.g = 40691;
        fVar.h = 18698;
        this.j = fVar.a.getBytes(d.a);
        a("Name", this.j);
        this.k = a;
        if (fVar.b != null) {
            this.k = fVar.b.getBytes(d.a);
            a("Comment", this.k);
        }
        fVar.a(i);
        this.h = fVar;
        this.h.j = this.i;
        this.d.add(this.h.a);
        i2 = (i == 0 ? 0 : 8) | 2048;
        a(this.out, 67324752);
        a(this.out, 20);
        a(this.out, i2);
        a(this.out, i);
        a(this.out, this.h.g);
        a(this.out, this.h.h);
        if (i == 0) {
            a(this.out, this.h.c);
            a(this.out, this.h.e);
            a(this.out, this.h.e);
        } else {
            a(this.out, 0);
            a(this.out, 0);
            a(this.out, 0);
        }
        a(this.out, this.j.length);
        if (this.h.i != null) {
            a(this.out, this.h.i.length);
        } else {
            a(this.out, 0);
        }
        this.out.write(this.j);
        if (this.h.i != null) {
            this.out.write(this.h.i);
        }
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        a.a(bArr.length, i, i2);
        if (this.h == null) {
            throw new ZipException("No active entry");
        }
        this.out.write(bArr, i, i2);
    }

    private void b() throws IOException {
        if (this.g == null) {
            throw new IOException("Stream is closed");
        }
    }

    public static void a(String str, byte[] bArr) {
        if (bArr.length > 65535) {
            throw new IllegalArgumentException(str + " too long in UTF-8:" + bArr.length + " bytes");
        }
    }
}
