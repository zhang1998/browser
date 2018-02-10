package com.a.a.a;

import com.uc.webview.export.extension.UCCore;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: ProGuard */
public class w extends t {
    private static final n e = new n("");
    private static final l f = new l("", (byte) 0, (short) 0);
    private static final byte[] g;
    byte[] b = new byte[5];
    byte[] c = new byte[10];
    byte[] d = new byte[1];
    private ai h = new ai();
    private short i = (short) 0;
    private l j = null;
    private Boolean k = null;
    private final long l;
    private byte[] m = new byte[1];

    static {
        byte[] bArr = new byte[16];
        g = bArr;
        bArr[0] = (byte) 0;
        g[2] = (byte) 1;
        g[3] = (byte) 3;
        g[6] = (byte) 4;
        g[8] = (byte) 5;
        g[10] = (byte) 6;
        g[4] = (byte) 7;
        g[11] = (byte) 8;
        g[15] = (byte) 9;
        g[14] = (byte) 10;
        g[13] = (byte) 11;
        g[12] = (byte) 12;
    }

    public w(k kVar, long j) {
        super(kVar);
        this.l = j;
    }

    public final void s() {
        this.h.a = -1;
        this.i = (short) 0;
    }

    public final void b() throws g {
        this.h.a(this.i);
        this.i = (short) 0;
    }

    public final void c() throws g {
        this.i = this.h.a();
    }

    public final void a(l lVar) throws g {
        if (lVar.b == (byte) 2) {
            this.j = lVar;
            return;
        }
        byte b = g[lVar.b];
        if (lVar.c <= this.i || lVar.c - this.i > 15) {
            a(b);
            a(c(lVar.c));
        } else {
            a((byte) (b | ((lVar.c - this.i) << 4)));
        }
        this.i = lVar.c;
    }

    public final void d() throws g {
        a((byte) 0);
    }

    public final void a(y yVar) throws g {
        if (yVar.c == 0) {
            a((byte) 0);
            return;
        }
        a(yVar.c);
        a((byte) ((g[yVar.a] << 4) | g[yVar.b]));
    }

    public final void a(m mVar) throws g {
        byte b = mVar.a;
        int i = mVar.b;
        if (i <= 14) {
            a((byte) (g[b] | (i << 4)));
            return;
        }
        a((byte) (g[b] | 240));
        a(i);
    }

    public final void b(int i) throws g {
        a(c(i));
    }

    public final void a(long j) throws g {
        long j2 = (j << 1) ^ (j >> 63);
        int i = 0;
        while ((-128 & j2) != 0) {
            int i2 = i + 1;
            this.c[i] = (byte) ((int) ((127 & j2) | 128));
            j2 >>>= 7;
            i = i2;
        }
        int i3 = i + 1;
        this.c[i] = (byte) ((int) j2);
        this.a.b(this.c, 0, i3);
    }

    public final void a(String str) throws g {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new g("UTF-8 not supported!");
        }
    }

    public final void a(ByteBuffer byteBuffer) throws g {
        a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    private void a(byte[] bArr, int i, int i2) throws g {
        a(i2);
        this.a.b(bArr, i, i2);
    }

    private void a(int i) throws g {
        int i2 = 0;
        while ((i & -128) != 0) {
            int i3 = i2 + 1;
            this.b[i2] = (byte) ((i & UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) | 128);
            i >>>= 7;
            i2 = i3;
        }
        int i4 = i2 + 1;
        this.b[i2] = (byte) i;
        this.a.b(this.b, 0, i4);
    }

    private static int c(int i) {
        return (i << 1) ^ (i >> 31);
    }

    final void a(byte b) throws g {
        this.m[0] = b;
        k kVar = this.a;
        byte[] bArr = this.m;
        kVar.b(bArr, 0, bArr.length);
    }

    public final n e() throws g {
        this.h.a(this.i);
        this.i = (short) 0;
        return e;
    }

    public final void f() throws g {
        this.i = this.h.a();
    }

    public final l g() throws g {
        byte l = l();
        if (l == (byte) 0) {
            return f;
        }
        Object obj;
        short s = (short) ((l & 240) >> 4);
        if (s == (short) 0) {
            s = m();
        } else {
            s = (short) (s + this.i);
        }
        l lVar = new l("", b((byte) (l & 15)), s);
        int i = l & 15;
        if (i == 1 || i == 2) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            this.k = ((byte) (l & 15)) == (byte) 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.i = lVar.c;
        return lVar;
    }

    public final y h() throws g {
        int t = t();
        int l = t == 0 ? 0 : l();
        return new y(b((byte) (l >> 4)), b((byte) (l & 15)), t);
    }

    public final m i() throws g {
        byte l = l();
        int i = (l >> 4) & 15;
        if (i == 15) {
            i = t();
        }
        return new m(b(l), i);
    }

    public final o j() throws g {
        return new o(i());
    }

    public final boolean k() throws g {
        if (this.k != null) {
            boolean booleanValue = this.k.booleanValue();
            this.k = null;
            return booleanValue;
        } else if (l() != (byte) 1) {
            return false;
        } else {
            return true;
        }
    }

    public final byte l() throws g {
        if (this.a.c() > 0) {
            byte b = this.a.a()[this.a.b()];
            this.a.a(1);
            return b;
        }
        this.a.a(this.d, 1);
        return this.d[0];
    }

    public final short m() throws g {
        return (short) e(t());
    }

    public final int n() throws g {
        return e(t());
    }

    public final long o() throws g {
        long j = null;
        long j2 = 0;
        if (this.a.c() < 10) {
            while (true) {
                byte l = l();
                j2 |= ((long) (l & UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK)) << j;
                if ((l & 128) != 128) {
                    break;
                }
                j += 7;
            }
        } else {
            int i;
            byte[] a = this.a.a();
            int b = this.a.b();
            long j3 = 0;
            while (true) {
                byte b2 = a[b + i];
                j2 |= ((long) (b2 & UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK)) << j3;
                if ((b2 & 128) != 128) {
                    break;
                }
                j3 += 7;
                i++;
            }
            this.a.a(i + 1);
        }
        return (j2 >>> 1) ^ (-(j2 & 1));
    }

    public final double p() throws g {
        byte[] bArr = new byte[8];
        this.a.a(bArr, 8);
        return Double.longBitsToDouble((((long) bArr[0]) & 255) | ((((((((((long) bArr[7]) & 255) << 56) | ((((long) bArr[6]) & 255) << 48)) | ((((long) bArr[5]) & 255) << 40)) | ((((long) bArr[4]) & 255) << 32)) | ((((long) bArr[3]) & 255) << 24)) | ((((long) bArr[2]) & 255) << 16)) | ((((long) bArr[1]) & 255) << 8)));
    }

    public final String q() throws g {
        int t = t();
        d(t);
        if (t == 0) {
            return "";
        }
        try {
            if (this.a.c() >= t) {
                String str = new String(this.a.a(), this.a.b(), t, "UTF-8");
                this.a.a(t);
                return str;
            }
            byte[] bArr;
            if (t == 0) {
                bArr = new byte[0];
            } else {
                bArr = new byte[t];
                this.a.a(bArr, t);
            }
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new g("UTF-8 not supported!");
        }
    }

    public final ByteBuffer r() throws g {
        int t = t();
        d(t);
        if (t == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[t];
        this.a.a(bArr, t);
        return ByteBuffer.wrap(bArr);
    }

    private void d(int i) throws q {
        if (i < 0) {
            throw new q("Negative length: " + i);
        } else if (this.l != -1 && ((long) i) > this.l) {
            throw new q("Length exceeded max allowed: " + i);
        }
    }

    private int t() throws g {
        int i = 0;
        int i2;
        if (this.a.c() >= 5) {
            byte[] a = this.a.a();
            int b = this.a.b();
            i2 = 0;
            int i3 = 0;
            while (true) {
                byte b2 = a[b + i];
                i3 |= (b2 & UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) << i2;
                if ((b2 & 128) == 128) {
                    i2 += 7;
                    i++;
                } else {
                    this.a.a(i + 1);
                    return i3;
                }
            }
        }
        i2 = 0;
        while (true) {
            byte l = l();
            i2 |= (l & UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK) << i;
            if ((l & 128) != 128) {
                return i2;
            }
            i += 7;
        }
    }

    private static int e(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    private static byte b(byte b) throws q {
        switch ((byte) (b & 15)) {
            case (byte) 0:
                return (byte) 0;
            case (byte) 1:
            case (byte) 2:
                return (byte) 2;
            case (byte) 3:
                return (byte) 3;
            case (byte) 4:
                return (byte) 6;
            case (byte) 5:
                return (byte) 8;
            case (byte) 6:
                return (byte) 10;
            case (byte) 7:
                return (byte) 4;
            case (byte) 8:
                return (byte) 11;
            case (byte) 9:
                return (byte) 15;
            case (byte) 10:
                return (byte) 14;
            case (byte) 11:
                return (byte) 13;
            case (byte) 12:
                return (byte) 12;
            default:
                throw new q("don't know what type: " + ((byte) (b & 15)));
        }
    }
}
