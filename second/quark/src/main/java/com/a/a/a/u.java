package com.a.a.a;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: ProGuard */
public final class u extends t {
    private static final n f = new n();
    protected boolean b = false;
    protected boolean c = true;
    protected int d;
    protected boolean e = false;
    private byte[] g = new byte[1];
    private byte[] h = new byte[2];
    private byte[] i = new byte[4];
    private byte[] j = new byte[8];
    private byte[] k = new byte[1];
    private byte[] l = new byte[2];
    private byte[] m = new byte[4];
    private byte[] n = new byte[8];

    public u(k kVar, boolean z, boolean z2) {
        super(kVar);
        this.b = z;
        this.c = z2;
    }

    public final void b() {
    }

    public final void c() {
    }

    public final void a(l lVar) throws g {
        a(lVar.b);
        short s = lVar.c;
        this.h[0] = (byte) ((s >> 8) & 255);
        this.h[1] = (byte) (s & 255);
        this.a.b(this.h, 0, 2);
    }

    public final void d() throws g {
        a((byte) 0);
    }

    public final void a(y yVar) throws g {
        a(yVar.a);
        a(yVar.b);
        b(yVar.c);
    }

    public final void a(m mVar) throws g {
        a(mVar.a);
        b(mVar.b);
    }

    private void a(byte b) throws g {
        this.g[0] = b;
        this.a.b(this.g, 0, 1);
    }

    public final void b(int i) throws g {
        this.i[0] = (byte) ((i >> 24) & 255);
        this.i[1] = (byte) ((i >> 16) & 255);
        this.i[2] = (byte) ((i >> 8) & 255);
        this.i[3] = (byte) (i & 255);
        this.a.b(this.i, 0, 4);
    }

    public final void a(long j) throws g {
        this.j[0] = (byte) ((int) ((j >> 56) & 255));
        this.j[1] = (byte) ((int) ((j >> 48) & 255));
        this.j[2] = (byte) ((int) ((j >> 40) & 255));
        this.j[3] = (byte) ((int) ((j >> 32) & 255));
        this.j[4] = (byte) ((int) ((j >> 24) & 255));
        this.j[5] = (byte) ((int) ((j >> 16) & 255));
        this.j[6] = (byte) ((int) ((j >> 8) & 255));
        this.j[7] = (byte) ((int) (255 & j));
        this.a.b(this.j, 0, 8);
    }

    public final void a(String str) throws g {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            b(bytes.length);
            this.a.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new g("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public final void a(ByteBuffer byteBuffer) throws g {
        int limit = byteBuffer.limit() - byteBuffer.position();
        b(limit);
        this.a.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    public final n e() {
        return f;
    }

    public final void f() {
    }

    public final l g() throws g {
        byte l = l();
        return new l("", l, l == (byte) 0 ? (short) 0 : m());
    }

    public final y h() throws g {
        return new y(l(), l(), n());
    }

    public final m i() throws g {
        return new m(l(), n());
    }

    public final o j() throws g {
        return new o(l(), n());
    }

    public final boolean k() throws g {
        return l() == (byte) 1;
    }

    public final byte l() throws g {
        if (this.a.c() > 0) {
            byte b = this.a.a()[this.a.b()];
            this.a.a(1);
            return b;
        }
        a(this.k, 1);
        return this.k[0];
    }

    public final short m() throws g {
        byte[] bArr = this.l;
        int i = 0;
        if (this.a.c() >= 2) {
            bArr = this.a.a();
            i = this.a.b();
            this.a.a(2);
        } else {
            a(this.l, 2);
        }
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public final int n() throws g {
        byte[] bArr = this.m;
        int i = 0;
        if (this.a.c() >= 4) {
            bArr = this.a.a();
            i = this.a.b();
            this.a.a(4);
        } else {
            a(this.m, 4);
        }
        return (bArr[i + 3] & 255) | ((((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16)) | ((bArr[i + 2] & 255) << 8));
    }

    public final long o() throws g {
        byte[] bArr = this.n;
        int i = 0;
        if (this.a.c() >= 8) {
            bArr = this.a.a();
            i = this.a.b();
            this.a.a(8);
        } else {
            a(this.n, 8);
        }
        return ((long) (bArr[i + 7] & 255)) | (((((((((long) (bArr[i] & 255)) << 56) | (((long) (bArr[i + 1] & 255)) << 48)) | (((long) (bArr[i + 2] & 255)) << 40)) | (((long) (bArr[i + 3] & 255)) << 32)) | (((long) (bArr[i + 4] & 255)) << 24)) | (((long) (bArr[i + 5] & 255)) << 16)) | (((long) (bArr[i + 6] & 255)) << 8));
    }

    public final double p() throws g {
        return Double.longBitsToDouble(o());
    }

    public final String q() throws g {
        int n = n();
        if (this.a.c() < n) {
            return c(n);
        }
        try {
            String str = new String(this.a.a(), this.a.b(), n, "UTF-8");
            this.a.a(n);
            return str;
        } catch (UnsupportedEncodingException e) {
            throw new g("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    private String c(int i) throws g {
        try {
            d(i);
            byte[] bArr = new byte[i];
            this.a.a(bArr, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new g("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public final ByteBuffer r() throws g {
        int n = n();
        d(n);
        if (this.a.c() >= n) {
            ByteBuffer wrap = ByteBuffer.wrap(this.a.a(), this.a.b(), n);
            this.a.a(n);
            return wrap;
        }
        byte[] bArr = new byte[n];
        this.a.a(bArr, n);
        return ByteBuffer.wrap(bArr);
    }

    private int a(byte[] bArr, int i) throws g {
        d(i);
        return this.a.a(bArr, i);
    }

    public final void a(int i) {
        this.d = i;
        this.e = true;
    }

    private void d(int i) throws g {
        if (i < 0) {
            throw new q("Negative length: " + i);
        } else if (this.e) {
            this.d -= i;
            if (this.d < 0) {
                throw new q("Message length exceeded: " + i);
            }
        }
    }
}
