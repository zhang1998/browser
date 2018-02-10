package com.tencent.tinker.b.c;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.zip.ZipException;

/* compiled from: ProGuard */
public final class f implements Cloneable {
    public String a;
    String b;
    public long c = -1;
    public long d = -1;
    long e = -1;
    int f = -1;
    int g = -1;
    int h = -1;
    byte[] i;
    long j = -1;
    long k = -1;

    public f(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        String str2 = "Name";
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        if (bytes.length > 65535) {
            throw new IllegalArgumentException(str2 + " too long: " + bytes.length);
        }
        this.a = str;
    }

    public f(f fVar) {
        this.a = fVar.a;
        this.b = fVar.b;
        this.g = fVar.g;
        this.e = fVar.e;
        this.d = fVar.d;
        this.c = fVar.c;
        this.f = fVar.f;
        this.h = fVar.h;
        this.i = fVar.i;
        this.j = fVar.j;
        this.k = fVar.k;
    }

    public f(f fVar, String str) {
        this.a = str;
        this.b = fVar.b;
        this.g = fVar.g;
        this.e = fVar.e;
        this.d = fVar.d;
        this.c = fVar.c;
        this.f = fVar.f;
        this.h = fVar.h;
        this.i = fVar.i;
        this.j = fVar.j;
        this.k = fVar.k;
    }

    f(byte[] bArr, InputStream inputStream, Charset charset) throws IOException {
        e.a(inputStream, bArr, 0, 46);
        b a = c.a(bArr, 46, ByteOrder.LITTLE_ENDIAN);
        int b = a.b();
        if (((long) b) != 33639248) {
            i.a("unknown", (long) inputStream.available(), "unknown", 0, "Central Directory Entry", b);
        }
        a.a(8);
        int c = a.c() & 65535;
        if ((c & 1) != 0) {
            throw new ZipException("Invalid General Purpose Bit Flag: " + c);
        }
        if ((c & 2048) != 0) {
            charset = Charset.forName("UTF-8");
        }
        this.f = a.c() & 65535;
        this.g = a.c() & 65535;
        this.h = a.c() & 65535;
        this.c = ((long) a.b()) & 4294967295L;
        this.d = ((long) a.b()) & 4294967295L;
        this.e = ((long) a.b()) & 4294967295L;
        c = a.c() & 65535;
        int c2 = a.c() & 65535;
        int c3 = a.c() & 65535;
        a.a(42);
        this.j = ((long) a.b()) & 4294967295L;
        byte[] bArr2 = new byte[c];
        e.a(inputStream, bArr2, 0, bArr2.length);
        if (a(bArr2)) {
            throw new ZipException("Filename contains NUL byte: " + Arrays.toString(bArr2));
        }
        this.a = new String(bArr2, 0, bArr2.length, charset);
        if (c2 > 0) {
            this.i = new byte[c2];
            e.a(inputStream, this.i, 0, c2);
        }
        if (c3 > 0) {
            bArr2 = new byte[c3];
            e.a(inputStream, bArr2, 0, c3);
            this.b = new String(bArr2, 0, bArr2.length, charset);
        }
    }

    private static boolean a(byte[] bArr) {
        for (byte b : bArr) {
            if (b == (byte) 0) {
                return true;
            }
        }
        return false;
    }

    public final void a(int i) {
        if (i == 0 || i == 8) {
            this.f = i;
            return;
        }
        throw new IllegalArgumentException("Bad method: " + i);
    }

    public final void a(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Bad size: " + j);
        }
        this.e = j;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("name:" + this.a);
        stringBuffer.append("\ncomment:" + this.b);
        stringBuffer.append("\ntime:" + this.g);
        stringBuffer.append("\nsize:" + this.e);
        stringBuffer.append("\ncompressedSize:" + this.d);
        stringBuffer.append("\ncrc:" + this.c);
        stringBuffer.append("\ncompressionMethod:" + this.f);
        stringBuffer.append("\nmodDate:" + this.h);
        stringBuffer.append("\nextra length:" + this.i.length);
        stringBuffer.append("\nlocalHeaderRelOffset:" + this.j);
        stringBuffer.append("\ndataOffset:" + this.k);
        return stringBuffer.toString();
    }

    public final Object clone() {
        try {
            f fVar = (f) super.clone();
            fVar.i = this.i != null ? (byte[]) this.i.clone() : null;
            return fVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
