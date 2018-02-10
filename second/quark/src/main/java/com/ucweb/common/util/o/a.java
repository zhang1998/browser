package com.ucweb.common.util.o;

import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.ucweb.common.util.c;
import com.ucweb.common.util.o.a.b;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class a {
    public static final char a = File.separatorChar;
    public static final String b;

    static {
        Writer aVar = new com.ucweb.common.util.o.a.a((byte) 0);
        PrintWriter printWriter = new PrintWriter(aVar);
        printWriter.println();
        b = aVar.toString();
        printWriter.close();
    }

    public static void a(InputStream inputStream) {
        b((Closeable) inputStream);
    }

    public static void a(OutputStream outputStream) {
        b((Closeable) outputStream);
    }

    private static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static byte[] b(InputStream inputStream) throws IOException {
        OutputStream bVar = new b();
        byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_0_RTT_MODE];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return bVar.a();
            }
            bVar.write(bArr, 0, read);
        }
    }

    public static byte[] a(InputStream inputStream, long j) throws IOException {
        if (j <= 2147483647L) {
            return a(inputStream, (int) j);
        }
        throw new IllegalArgumentException("Size cannot be greater than Integer max value: " + j);
    }

    private static byte[] a(InputStream inputStream, int i) throws IOException {
        int i2 = 0;
        if (i < 0) {
            throw new IllegalArgumentException("Size must be equal or greater than zero: " + i);
        } else if (i == 0) {
            return new byte[0];
        } else {
            byte[] bArr = new byte[i];
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            }
            if (i2 == i) {
                return bArr;
            }
            throw new IOException("Unexpected readed size. current: " + i2 + ", excepted: " + i);
        }
    }

    public static String c(InputStream inputStream) throws IOException {
        return a(inputStream, Charset.defaultCharset());
    }

    public static String a(InputStream inputStream, Charset charset) throws IOException {
        Writer aVar = new com.ucweb.common.util.o.a.a();
        a(new InputStreamReader(inputStream, b.a(charset)), aVar, new char[SpdyProtocol.SLIGHTSSL_0_RTT_MODE]);
        return aVar.toString();
    }

    public static List<String> d(InputStream inputStream) throws IOException {
        return a(new InputStreamReader(inputStream, b.a(Charset.defaultCharset())));
    }

    public static void a(String str, OutputStream outputStream, Charset charset) throws IOException {
        if (str != null) {
            outputStream.write(d.a(str, b.a(charset)));
        }
    }

    private static long a(Reader reader, Writer writer, char[] cArr) throws IOException {
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return j;
            }
            writer.write(cArr, 0, read);
            j += (long) read;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                c.a(e.toString());
            }
        }
    }

    public static byte[] e(InputStream inputStream) {
        byte[] bArr = null;
        Closeable byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr2 = new byte[SpdyProtocol.SLIGHTSSL_0_RTT_MODE];
            while (true) {
                int read = inputStream.read(bArr2, 0, SpdyProtocol.SLIGHTSSL_0_RTT_MODE);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            bArr = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
        } finally {
            a(byteArrayOutputStream);
        }
        return bArr;
    }

    public static byte[] f(InputStream inputStream) {
        byte[] bArr = null;
        if (inputStream != null) {
            byte[] bArr2 = new byte[WXMediaMessage.THUMB_LENGTH_LIMIT];
            Closeable byteArrayOutputStream = new ByteArrayOutputStream(2048);
            while (true) {
                try {
                    int read = inputStream.read(bArr2, 0, WXMediaMessage.THUMB_LENGTH_LIMIT);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                } catch (Exception e) {
                } finally {
                    a(byteArrayOutputStream);
                }
            }
            bArr = byteArrayOutputStream.toByteArray();
        }
        return bArr;
    }

    public static byte[] g(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[1024];
        int read;
        for (int i = 0; i < 1024; i = read + i) {
            if (1024 - i < 1024) {
                read = inputStream.read(bArr, i, 1024 - i);
            } else {
                read = inputStream.read(bArr, i, 1024);
            }
            if (read == -1) {
                return bArr;
            }
        }
        return bArr;
    }

    private static List<String> a(Reader reader) throws IOException {
        if (reader instanceof BufferedReader) {
            reader = (BufferedReader) reader;
        } else {
            reader = new BufferedReader(reader);
        }
        List<String> arrayList = new ArrayList();
        for (Object readLine = reader.readLine(); readLine != null; readLine = reader.readLine()) {
            arrayList.add(readLine);
        }
        return arrayList;
    }
}
