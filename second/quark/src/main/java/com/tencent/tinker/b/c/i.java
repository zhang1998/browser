package com.tencent.tinker.b.c;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.util.LinkedHashMap;
import java.util.zip.ZipException;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class i implements Closeable {
    public final LinkedHashMap<String, f> a;
    public String b;
    private final String c;
    private File d;
    private RandomAccessFile e;

    public i(File file) throws ZipException, IOException {
        this(file, (byte) 0);
    }

    public i(String str) throws IOException {
        this(new File(str), (byte) 0);
    }

    private i(File file, byte b) throws IOException {
        this.a = new LinkedHashMap();
        this.c = file.getPath();
        this.d = null;
        this.e = new RandomAccessFile(this.c, "r");
        b();
    }

    static void a(String str, long j, String str2, long j2, String str3, int i) throws ZipException {
        throw new ZipException("file name:" + str + ", file size" + j + ", entry name:" + str2 + ", entry localHeaderRelOffset:" + j2 + ", " + str3 + " signature not found; was " + Integer.toHexString(i));
    }

    public final void close() throws IOException {
        RandomAccessFile randomAccessFile = this.e;
        if (randomAccessFile != null) {
            synchronized (randomAccessFile) {
                this.e = null;
                randomAccessFile.close();
            }
            if (this.d != null) {
                this.d.delete();
                this.d = null;
            }
        }
    }

    public final void a() {
        if (this.e == null) {
            throw new IllegalStateException("Zip file closed");
        }
    }

    public final f a(String str) {
        a();
        if (str == null) {
            throw new NullPointerException("entryName == null");
        }
        f fVar = (f) this.a.get(str);
        if (fVar == null) {
            return (f) this.a.get(str + "/");
        }
        return fVar;
    }

    public final InputStream a(f fVar) throws IOException {
        f a = a(fVar.a);
        if (a == null) {
            return null;
        }
        InputStream hVar;
        RandomAccessFile randomAccessFile = this.e;
        synchronized (randomAccessFile) {
            hVar = new h(randomAccessFile, a.j);
            DataInputStream dataInputStream = new DataInputStream(hVar);
            int reverseBytes = Integer.reverseBytes(dataInputStream.readInt());
            if (((long) reverseBytes) != 67324752) {
                a(this.c, randomAccessFile.length(), a.a, a.j, "Local File Header", reverseBytes);
            }
            dataInputStream.skipBytes(2);
            int reverseBytes2 = Short.reverseBytes(dataInputStream.readShort()) & 65535;
            if ((reverseBytes2 & 1) != 0) {
                throw new ZipException("Invalid General Purpose Bit Flag: " + reverseBytes2);
            }
            dataInputStream.skipBytes(18);
            reverseBytes2 = Short.reverseBytes(dataInputStream.readShort()) & 65535;
            int reverseBytes3 = Short.reverseBytes(dataInputStream.readShort()) & 65535;
            dataInputStream.close();
            hVar.skip((long) (reverseBytes2 + reverseBytes3));
            if (a.f == 0) {
                hVar.b = hVar.c + a.e;
            } else {
                hVar.b = hVar.c + a.d;
            }
        }
        return hVar;
    }

    private void b() throws IOException {
        long j = 0;
        long length = this.e.length() - 22;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + this.e.length());
        }
        this.e.seek(0);
        if (((long) Integer.reverseBytes(this.e.readInt())) != 67324752) {
            throw new ZipException("Not a zip archive");
        }
        long j2 = length - 65536;
        if (j2 < 0) {
            j2 = length;
        } else {
            j = j2;
            j2 = length;
        }
        do {
            this.e.seek(j2);
            if (((long) Integer.reverseBytes(this.e.readInt())) != 101010256) {
                j2--;
            } else {
                byte[] bArr = new byte[18];
                this.e.readFully(bArr);
                b a = c.a(bArr, 18, ByteOrder.LITTLE_ENDIAN);
                int c = a.c() & 65535;
                int c2 = a.c() & 65535;
                int c3 = a.c() & 65535;
                int c4 = a.c() & 65535;
                a.a();
                long b = ((long) a.b()) & 4294967295L;
                int c5 = a.c() & 65535;
                if (c3 == c4 && c == 0 && c2 == 0) {
                    if (c5 > 0) {
                        bArr = new byte[c5];
                        this.e.readFully(bArr);
                        this.b = new String(bArr, 0, bArr.length, d.a);
                    }
                    InputStream bufferedInputStream = new BufferedInputStream(new h(this.e, b), SpdyProtocol.SLIGHTSSL_0_RTT_MODE);
                    byte[] bArr2 = new byte[46];
                    for (c5 = 0; c5 < c3; c5++) {
                        f fVar = new f(bArr2, bufferedInputStream, d.a);
                        if (fVar.j >= b) {
                            throw new ZipException("Local file header offset is after central directory");
                        }
                        String str = fVar.a;
                        if (this.a.put(str, fVar) != null) {
                            throw new ZipException("Duplicate entry name: " + str);
                        }
                    }
                    return;
                }
                throw new ZipException("Spanned archives not supported");
            }
        } while (j2 >= j);
        throw new ZipException("End Of Central Directory signature not found");
    }
}
