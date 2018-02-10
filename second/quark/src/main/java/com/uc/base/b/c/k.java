package com.uc.base.b.c;

import java.io.DataOutput;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.UTFDataFormatException;

/* compiled from: ProGuard */
public final class k extends FilterOutputStream implements DataOutput {
    protected int a;
    private byte[] b;
    private byte[] c;

    public k() {
        super(new j());
        this.b = null;
        this.c = new byte[8];
    }

    public k(byte[] bArr) {
        super(new j(bArr));
        this.b = null;
        this.c = new byte[8];
    }

    public final void close() throws IOException {
        super.close();
    }

    private void a(int i) {
        int i2 = this.a + i;
        if (i2 < 0) {
            i2 = Integer.MAX_VALUE;
        }
        this.a = i2;
    }

    public final synchronized void write(int i) throws IOException {
        this.out.write(i);
        a(1);
    }

    public final synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
        a(i2);
    }

    public final void flush() throws IOException {
        this.out.flush();
    }

    public final void writeBoolean(boolean z) throws IOException {
        this.out.write(z ? 1 : 0);
        a(1);
    }

    public final void writeByte(int i) throws IOException {
        this.out.write(i);
        a(1);
    }

    public final void writeShort(int i) throws IOException {
        this.out.write((i >>> 8) & 255);
        this.out.write((i >>> 0) & 255);
        a(2);
    }

    public final void writeChar(int i) throws IOException {
        this.out.write((i >>> 8) & 255);
        this.out.write((i >>> 0) & 255);
        a(2);
    }

    public final void writeInt(int i) throws IOException {
        this.out.write((i >>> 24) & 255);
        this.out.write((i >>> 16) & 255);
        this.out.write((i >>> 8) & 255);
        this.out.write((i >>> 0) & 255);
        a(4);
    }

    public final void writeLong(long j) throws IOException {
        this.c[0] = (byte) ((int) (j >>> 56));
        this.c[1] = (byte) ((int) (j >>> 48));
        this.c[2] = (byte) ((int) (j >>> 40));
        this.c[3] = (byte) ((int) (j >>> 32));
        this.c[4] = (byte) ((int) (j >>> 24));
        this.c[5] = (byte) ((int) (j >>> 16));
        this.c[6] = (byte) ((int) (j >>> 8));
        this.c[7] = (byte) ((int) (j >>> 0));
        this.out.write(this.c, 0, 8);
        a(8);
    }

    public final void writeFloat(float f) throws IOException {
        writeInt(Float.floatToIntBits(f));
    }

    public final void writeDouble(double d) throws IOException {
        writeLong(Double.doubleToLongBits(d));
    }

    public final void writeBytes(String str) throws IOException {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            this.out.write((byte) str.charAt(i));
        }
        a(length);
    }

    public final void writeChars(String str) throws IOException {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            this.out.write((charAt >>> 8) & 255);
            this.out.write((charAt >>> 0) & 255);
        }
        a(length * 2);
    }

    public final void writeUTF(String str) throws IOException {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            char charAt = str.charAt(i);
            if (charAt > '\u0000' && charAt <= '') {
                i3 = i2 + 1;
            } else if (charAt > '߿') {
                i3 = i2 + 3;
            } else {
                i3 = i2 + 2;
            }
            i++;
            i2 = i3;
        }
        if (i2 > 65535) {
            throw new UTFDataFormatException("encoded string too long: " + i2 + " bytes");
        }
        byte[] bArr;
        int i4;
        if (this instanceof k) {
            k kVar = this;
            if (kVar.b == null || kVar.b.length < i2 + 2) {
                kVar.b = new byte[((i2 * 2) + 2)];
            }
            bArr = kVar.b;
        } else {
            bArr = new byte[(i2 + 2)];
        }
        bArr[0] = (byte) ((i2 >>> 8) & 255);
        int i5 = 2;
        bArr[1] = (byte) ((i2 >>> 0) & 255);
        i = 0;
        while (i < length) {
            char charAt2 = str.charAt(i);
            if (charAt2 <= '\u0000' || charAt2 > '') {
                break;
            }
            i4 = i5 + 1;
            bArr[i5] = (byte) charAt2;
            i++;
            i5 = i4;
        }
        i4 = i5;
        i5 = i;
        while (i5 < length) {
            charAt2 = str.charAt(i5);
            if (charAt2 > '\u0000' && charAt2 <= '') {
                i = i4 + 1;
                bArr[i4] = (byte) charAt2;
            } else if (charAt2 > '߿') {
                i = i4 + 1;
                bArr[i4] = (byte) (((charAt2 >> 12) & 15) | 224);
                i4 = i + 1;
                bArr[i] = (byte) (((charAt2 >> 6) & 63) | 128);
                i = i4 + 1;
                bArr[i4] = (byte) (((charAt2 >> 0) & 63) | 128);
            } else {
                int i6 = i4 + 1;
                bArr[i4] = (byte) (((charAt2 >> 6) & 31) | 192);
                i = i6 + 1;
                bArr[i6] = (byte) (((charAt2 >> 0) & 63) | 128);
            }
            i5++;
            i4 = i;
        }
        write(bArr, 0, i2 + 2);
    }

    public final synchronized byte[] a(byte[] bArr) {
        Object obj;
        int length = bArr.length;
        Object b = ((j) this.out).b();
        int c = ((j) this.out).c();
        obj = new byte[(length + c)];
        System.arraycopy(bArr, 0, obj, 0, length);
        System.arraycopy(b, 0, obj, length, c);
        return obj;
    }

    public final synchronized byte[] a() {
        return ((j) this.out).a();
    }
}
