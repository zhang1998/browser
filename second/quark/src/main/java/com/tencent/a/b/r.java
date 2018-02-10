package com.tencent.a.b;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.zip.ZipException;

/* compiled from: ProGuard */
public final class r {
    private static final c a = new c();
    private static final l b = new l();

    private static String a(File file, String str) throws IOException {
        RandomAccessFile randomAccessFile;
        Throwable th;
        String str2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                byte[] a = a(randomAccessFile);
                if (a == null) {
                    randomAccessFile.close();
                } else {
                    q qVar = new q();
                    if (a != null) {
                        ByteBuffer wrap = ByteBuffer.wrap(a);
                        l lVar = b;
                        byte[] bArr = new byte[]{(byte) (lVar.a & 255), (byte) ((lVar.a & 65280) >> 8)};
                        byte[] bArr2 = new byte[2];
                        wrap.get(bArr2);
                        if (!b.equals(new l(bArr2))) {
                            throw new ProtocolException("unknow protocl [" + Arrays.toString(a) + "]");
                        } else if (a.length - 2 > 2) {
                            bArr2 = new byte[2];
                            wrap.get(bArr2);
                            int i = new l(bArr2).a;
                            if ((a.length - 2) - 2 >= i) {
                                bArr = new byte[i];
                                wrap.get(bArr);
                                qVar.a.load(new ByteArrayInputStream(bArr));
                                int length = ((a.length - 2) - i) - 2;
                                if (length > 0) {
                                    qVar.b = new byte[length];
                                    wrap.get(qVar.b);
                                }
                            }
                        }
                    }
                    str2 = qVar.a.getProperty(str);
                    randomAccessFile.close();
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            randomAccessFile = null;
            th = th4;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    public static String a(File file) throws IOException {
        return a(file, "channelNo");
    }

    private static byte[] a(RandomAccessFile randomAccessFile) throws IOException {
        int i = 1;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        c cVar = a;
        byte[] bArr = new byte[]{(byte) ((int) (cVar.a & 255)), (byte) ((int) ((cVar.a & 65280) >> 8)), (byte) ((int) ((cVar.a & 16711680) >> 16)), (byte) ((int) ((cVar.a & 4278190080L) >> 24))};
        byte read = randomAccessFile.read();
        while (read != (byte) -1) {
            if (read == bArr[0] && randomAccessFile.read() == bArr[1] && randomAccessFile.read() == bArr[2] && randomAccessFile.read() == bArr[3]) {
                break;
            }
            length--;
            randomAccessFile.seek(length);
            read = randomAccessFile.read();
        }
        i = 0;
        if (i == 0) {
            throw new ZipException("archive is not a ZIP archive");
        }
        randomAccessFile.seek((16 + length) + 4);
        byte[] bArr2 = new byte[2];
        randomAccessFile.readFully(bArr2);
        i = new l(bArr2).a;
        if (i == 0) {
            return null;
        }
        bArr2 = new byte[i];
        randomAccessFile.read(bArr2);
        return bArr2;
    }
}
