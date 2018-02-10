package com.tencent.tinker.c.a;

import com.alibaba.wireless.security.SecExceptionCode;
import com.tencent.tinker.c.a.a.b;
import com.tencent.tinker.c.a.b.d;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.zip.Adler32;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class u {
    static final short[] a = new short[0];
    public final ai b = new ai();
    public ByteBuffer c;
    private final r d = new r();
    private final s e = new s();
    private final t f = new t();
    private final p g = new p();
    private final n h = new n();
    private final o i = new o();
    private final m j = new m();
    private int k = 0;
    private byte[] l = null;

    public u(int i) {
        this.c = ByteBuffer.wrap(new byte[i]);
        this.c.order(ByteOrder.LITTLE_ENDIAN);
        this.b.v = i;
    }

    public u(InputStream inputStream) throws IOException {
        Object obj = -1;
        this.c = ByteBuffer.wrap(d.a(inputStream, 0));
        this.c.order(ByteOrder.LITTLE_ENDIAN);
        ai aiVar = this.b;
        b a = a(aiVar.a);
        byte[] c = a.c(8);
        if (c.length == 8 && c[0] == (byte) 100 && c[1] == (byte) 101 && c[2] == (byte) 120 && c[3] == (byte) 10 && c[7] == (byte) 0) {
            String str = ((char) c[4]) + ((char) c[5]) + ((char) c[6]);
            if (str.equals("036")) {
                obj = 14;
            } else if (str.equals("035")) {
                int i = 13;
            }
        }
        if (obj != 13) {
            throw new v("Unexpected magic: " + Arrays.toString(c));
        }
        aiVar.t = a.b.getInt();
        aiVar.u = a.c(20);
        aiVar.v = a.b.getInt();
        i = a.b.getInt();
        if (i != SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED) {
            throw new v("Unexpected header: 0x" + Integer.toHexString(i));
        }
        i = a.b.getInt();
        if (i != 305419896) {
            throw new v("Unexpected endian tag: 0x" + Integer.toHexString(i));
        }
        aiVar.w = a.b.getInt();
        aiVar.x = a.b.getInt();
        aiVar.h.d = a.b.getInt();
        if (aiVar.h.d == 0) {
            throw new v("Cannot merge dex files that do not contain a map");
        }
        aiVar.b.c = a.b.getInt();
        aiVar.b.d = a.b.getInt();
        aiVar.c.c = a.b.getInt();
        aiVar.c.d = a.b.getInt();
        aiVar.d.c = a.b.getInt();
        aiVar.d.d = a.b.getInt();
        aiVar.e.c = a.b.getInt();
        aiVar.e.d = a.b.getInt();
        aiVar.f.c = a.b.getInt();
        aiVar.f.d = a.b.getInt();
        aiVar.g.c = a.b.getInt();
        aiVar.g.d = a.b.getInt();
        aiVar.y = a.b.getInt();
        aiVar.z = a.b.getInt();
        aiVar.a(a(aiVar.h.d));
        aiVar.a();
    }

    private static void b(int i, int i2) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException("index:" + i + ", length=" + i2);
        }
    }

    public final q a(int i) {
        if (i < 0 || i >= this.c.capacity()) {
            throw new IllegalArgumentException("position=" + i + " length=" + this.c.capacity());
        }
        ByteBuffer duplicate = this.c.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        duplicate.position(i);
        duplicate.limit(this.c.capacity());
        return new q(this, "temp-section", duplicate);
    }

    public final q a(ah ahVar) {
        int i = ahVar.d;
        if (i < 0 || i >= this.c.capacity()) {
            throw new IllegalArgumentException("position=" + i + " length=" + this.c.capacity());
        }
        ByteBuffer duplicate = this.c.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        duplicate.position(i);
        duplicate.limit(i + ahVar.e);
        return new q(this, "section", duplicate);
    }

    public final byte[] a(boolean z) {
        if (this.l != null && !z) {
            return this.l;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_1_RTT_MODE];
            ByteBuffer duplicate = this.c.duplicate();
            duplicate.limit(duplicate.capacity());
            duplicate.position(32);
            while (duplicate.hasRemaining()) {
                int min = Math.min(SpdyProtocol.SLIGHTSSL_1_RTT_MODE, duplicate.remaining());
                duplicate.get(bArr, 0, min);
                instance.update(bArr, 0, min);
            }
            byte[] digest = instance.digest();
            this.l = digest;
            return digest;
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError();
        }
    }

    public final int a() throws IOException {
        Adler32 adler32 = new Adler32();
        byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_1_RTT_MODE];
        ByteBuffer duplicate = this.c.duplicate();
        duplicate.limit(duplicate.capacity());
        duplicate.position(12);
        while (duplicate.hasRemaining()) {
            int min = Math.min(SpdyProtocol.SLIGHTSSL_1_RTT_MODE, duplicate.remaining());
            duplicate.get(bArr, 0, min);
            adler32.update(bArr, 0, min);
        }
        return (int) adler32.getValue();
    }

    public final int b(int i) {
        b(i, this.b.c.c);
        return this.c.getInt(this.b.c.d + (i * 4));
    }
}
