package com.ucpro.feature.video.cache.d;

import com.ucweb.common.util.n.a;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class l implements i {
    final /* synthetic */ c a;
    private final j b;
    private final OutputStream c;
    private PushbackInputStream d;
    private int e;
    private int f;
    private String g;
    private b h;
    private Map<String, String> i;
    private Map<String, String> j;
    private t k;
    private String l;

    public l(c cVar, j jVar, InputStream inputStream, OutputStream outputStream, InetAddress inetAddress) {
        Object obj;
        this.a = cVar;
        this.b = jVar;
        this.d = new PushbackInputStream(inputStream, SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
        this.c = outputStream;
        if (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) {
            obj = "127.0.0.1";
        } else {
            obj = inetAddress.getHostAddress().toString();
        }
        this.j = new HashMap();
        this.j.put("remote-addr", obj);
        this.j.put("http-client-ip", obj);
    }

    public final void f() throws IOException {
        try {
            byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_1_RTT_MODE];
            this.e = 0;
            this.f = 0;
            int read = this.d.read(bArr, 0, SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
            if (read == -1) {
                c.a(this.d);
                c.a(this.c);
                throw new SocketException("NanoHttpd Shutdown");
            }
            while (read > 0) {
                this.f = read + this.f;
                this.e = a(bArr, this.f);
                if (this.e > 0) {
                    break;
                }
                read = this.d.read(bArr, this.f, 8192 - this.f);
            }
            if (this.e < this.f) {
                this.d.unread(bArr, this.e, this.f - this.e);
            }
            this.i = new HashMap();
            if (this.j == null) {
                this.j = new HashMap();
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, 0, this.f)));
            Map hashMap = new HashMap();
            a(bufferedReader, hashMap, this.i, this.j);
            this.h = b.a((String) hashMap.get("method"));
            if (this.h == null) {
                throw new m(q.BAD_REQUEST, "BAD REQUEST: Syntax error.");
            }
            this.g = (String) hashMap.get("uri");
            this.k = new t(this.a, this.j);
            d a = this.a.a((i) this);
            if (a == null) {
                throw new m(q.INTERNAL_ERROR, "SERVER INTERNAL ERROR: Serve() returned a null response.");
            }
            this.k.a(a);
            a.a = this.h;
            a.a(this.c);
            this.b.b();
        } catch (Exception e) {
            c.a(this.d);
            c.a(this.c);
            throw new SocketException("NanoHttpd Shutdown");
        } catch (SocketException e2) {
            throw e2;
        } catch (SocketTimeoutException e3) {
            throw e3;
        } catch (IOException e4) {
            new d(q.INTERNAL_ERROR, "text/plain", "SERVER INTERNAL ERROR: IOException: " + e4.getMessage()).a(this.c);
            c.a(this.c);
            this.b.b();
        } catch (m e5) {
            new d(e5.a, "text/plain", e5.getMessage()).a(this.c);
            c.a(this.c);
            this.b.b();
        } catch (Exception e6) {
            this.b.b();
        } catch (Throwable th) {
            this.b.b();
        }
    }

    private static int a(byte[] bArr, int i) {
        int i2 = 0;
        while (i2 + 3 < i) {
            if (bArr[i2] == (byte) 13 && bArr[i2 + 1] == (byte) 10 && bArr[i2 + 2] == (byte) 13 && bArr[i2 + 3] == (byte) 10) {
                return i2 + 4;
            }
            i2++;
        }
        return 0;
    }

    private void a(BufferedReader bufferedReader, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) throws m {
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                if (stringTokenizer.hasMoreTokens()) {
                    map.put("method", stringTokenizer.nextToken());
                    if (stringTokenizer.hasMoreTokens()) {
                        Object a;
                        readLine = stringTokenizer.nextToken();
                        int indexOf = readLine.indexOf(63);
                        if (indexOf >= 0) {
                            a(readLine.substring(indexOf + 1), (Map) map2);
                            a = c.a(readLine.substring(0, indexOf));
                        } else {
                            String a2 = c.a(readLine);
                        }
                        if (stringTokenizer.hasMoreTokens()) {
                            readLine = bufferedReader.readLine();
                            while (readLine != null && readLine.trim().length() > 0) {
                                int indexOf2 = readLine.indexOf(58);
                                if (indexOf2 >= 0) {
                                    map3.put(readLine.substring(0, indexOf2).trim().toLowerCase(Locale.US), readLine.substring(indexOf2 + 1).trim());
                                }
                                readLine = bufferedReader.readLine();
                            }
                        }
                        map.put("uri", a);
                        return;
                    }
                    throw new m(q.BAD_REQUEST, "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
                }
                throw new m(q.BAD_REQUEST, "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
            }
        } catch (Exception e) {
            throw new m(q.INTERNAL_ERROR, "SERVER INTERNAL ERROR: IOException: " + e.getMessage(), e);
        }
    }

    private void a(String str, Map<String, String> map) {
        if (str == null) {
            this.l = "";
            return;
        }
        this.l = str;
        StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf(61);
            String a;
            if (indexOf >= 0) {
                a = c.a(nextToken.substring(0, indexOf));
                map.put(a.b(a) ? a.trim() : "", c.a(nextToken.substring(indexOf + 1)));
            } else {
                a = c.a(nextToken);
                map.put(a.b(a) ? a.trim() : "", "");
            }
        }
    }

    public final Map<String, String> a() {
        return this.i;
    }

    public final Map<String, String> b() {
        return this.j;
    }

    public final String c() {
        return this.g;
    }

    public final String d() {
        return this.l;
    }

    public final b e() {
        return this.h;
    }

    public final void a(Map<String, String> map) throws IOException, m {
        Throwable th;
        Closeable closeable;
        StringTokenizer stringTokenizer = null;
        Closeable bufferedReader;
        try {
            ByteBuffer map2;
            Closeable g = g();
            try {
                long parseInt = this.j.containsKey("content-length") ? (long) Integer.parseInt((String) this.j.get("content-length")) : this.e < this.f ? (long) (this.f - this.e) : 0;
                byte[] bArr = new byte[512];
                while (this.f >= 0 && parseInt > 0) {
                    this.f = this.d.read(bArr, 0, (int) Math.min(parseInt, 512));
                    parseInt -= (long) this.f;
                    if (this.f > 0) {
                        g.write(bArr, 0, this.f);
                    }
                }
                map2 = g.getChannel().map(MapMode.READ_ONLY, 0, g.length());
                g.seek(0);
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(g.getFD())));
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                closeable = g;
                c.a(closeable);
                c.a(bufferedReader);
                throw th;
            }
            try {
                if (b.c.equals(this.h)) {
                    String nextToken;
                    StringBuilder stringBuilder;
                    char[] cArr;
                    int read;
                    String str = "";
                    String str2 = (String) this.j.get("content-type");
                    if (str2 != null) {
                        stringTokenizer = new StringTokenizer(str2, ",; ");
                        if (stringTokenizer.hasMoreTokens()) {
                            nextToken = stringTokenizer.nextToken();
                            if ("multipart/form-data".equalsIgnoreCase(nextToken)) {
                                str2 = "";
                                stringBuilder = new StringBuilder();
                                cArr = new char[512];
                                for (read = bufferedReader.read(cArr); read >= 0 && !r0.endsWith("\r\n"); read = bufferedReader.read(cArr)) {
                                    str2 = String.valueOf(cArr, 0, read);
                                    stringBuilder.append(str2);
                                }
                                str2 = stringBuilder.toString().trim();
                                if ("application/x-www-form-urlencoded".equalsIgnoreCase(nextToken)) {
                                    a(str2, this.i);
                                } else if (str2.length() != 0) {
                                    map.put("postData", str2);
                                }
                            } else if (stringTokenizer.hasMoreTokens()) {
                                throw new m(q.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html");
                            } else {
                                str = "boundary=";
                                str = str2.substring(str.length() + str2.indexOf(str), str2.length());
                                if (str.startsWith("\"") && str.endsWith("\"")) {
                                    str = str.substring(1, str.length() - 1);
                                }
                                a(str, map2, bufferedReader, this.i, map);
                            }
                        }
                    }
                    nextToken = str;
                    if ("multipart/form-data".equalsIgnoreCase(nextToken)) {
                        str2 = "";
                        stringBuilder = new StringBuilder();
                        cArr = new char[512];
                        for (read = bufferedReader.read(cArr); read >= 0; read = bufferedReader.read(cArr)) {
                            str2 = String.valueOf(cArr, 0, read);
                            stringBuilder.append(str2);
                        }
                        str2 = stringBuilder.toString().trim();
                        if ("application/x-www-form-urlencoded".equalsIgnoreCase(nextToken)) {
                            a(str2, this.i);
                        } else if (str2.length() != 0) {
                            map.put("postData", str2);
                        }
                    } else if (stringTokenizer.hasMoreTokens()) {
                        str = "boundary=";
                        str = str2.substring(str.length() + str2.indexOf(str), str2.length());
                        str = str.substring(1, str.length() - 1);
                        a(str, map2, bufferedReader, this.i, map);
                    } else {
                        throw new m(q.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html");
                    }
                } else if (b.PUT.equals(this.h)) {
                    map.put("content", a(map2, 0, map2.limit()));
                }
                c.a(g);
                c.a(bufferedReader);
            } catch (Throwable th3) {
                th = th3;
                closeable = g;
                c.a(closeable);
                c.a(bufferedReader);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            c.a(closeable);
            c.a(bufferedReader);
            throw th;
        }
    }

    private RandomAccessFile g() {
        try {
            return new RandomAccessFile(this.b.a().b(), "rw");
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    private void a(String str, ByteBuffer byteBuffer, BufferedReader bufferedReader, Map<String, String> map, Map<String, String> map2) throws m {
        try {
            byte[] bytes = str.getBytes();
            int i = 0;
            int i2 = -1;
            List arrayList = new ArrayList();
            int i3 = 0;
            while (i3 < byteBuffer.limit()) {
                if (byteBuffer.get(i3) == bytes[i]) {
                    if (i == 0) {
                        i2 = i3;
                    }
                    i++;
                    if (i == bytes.length) {
                        arrayList.add(Integer.valueOf(i2));
                        i = 0;
                        i2 = -1;
                    }
                } else {
                    i3 -= i;
                    i = 0;
                    i2 = -1;
                }
                i3++;
            }
            int[] iArr = new int[arrayList.size()];
            for (i2 = 0; i2 < iArr.length; i2++) {
                iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
            }
            i2 = 1;
            String readLine = bufferedReader.readLine();
            while (readLine != null) {
                if (readLine.contains(str)) {
                    i = i2 + 1;
                    Map hashMap = new HashMap();
                    String readLine2 = bufferedReader.readLine();
                    while (readLine2 != null && readLine2.trim().length() > 0) {
                        i3 = readLine2.indexOf(58);
                        if (i3 != -1) {
                            hashMap.put(readLine2.substring(0, i3).trim().toLowerCase(Locale.US), readLine2.substring(i3 + 1).trim());
                        }
                        readLine2 = bufferedReader.readLine();
                    }
                    if (readLine2 != null) {
                        readLine = (String) hashMap.get("content-disposition");
                        if (readLine == null) {
                            throw new m(q.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but no content-disposition info found. Usage: GET /example/file.html");
                        }
                        Object obj;
                        StringTokenizer stringTokenizer = new StringTokenizer(readLine, ";");
                        Map hashMap2 = new HashMap();
                        while (stringTokenizer.hasMoreTokens()) {
                            readLine = stringTokenizer.nextToken().trim();
                            int indexOf = readLine.indexOf(61);
                            if (indexOf != -1) {
                                hashMap2.put(readLine.substring(0, indexOf).trim().toLowerCase(Locale.US), readLine.substring(indexOf + 1).trim());
                            }
                        }
                        readLine = (String) hashMap2.get("name");
                        String substring = readLine.substring(1, readLine.length() - 1);
                        String stringBuilder;
                        if (hashMap.get("content-type") == null) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            while (readLine2 != null && !readLine2.contains(str)) {
                                readLine2 = bufferedReader.readLine();
                                if (readLine2 != null) {
                                    int indexOf2 = readLine2.indexOf(str);
                                    if (indexOf2 == -1) {
                                        stringBuilder2.append(readLine2);
                                    } else {
                                        stringBuilder2.append(readLine2.substring(0, indexOf2 - 2));
                                    }
                                }
                            }
                            stringBuilder = stringBuilder2.toString();
                            readLine = readLine2;
                            obj = stringBuilder;
                        } else if (i > iArr.length) {
                            throw new m(q.INTERNAL_ERROR, "Error processing request");
                        } else {
                            i3 = a(byteBuffer, iArr[i - 2]);
                            map2.put(substring, a(byteBuffer, i3, (iArr[i - 1] - i3) - 4));
                            readLine = (String) hashMap2.get("filename");
                            readLine = readLine.substring(1, readLine.length() - 1);
                            do {
                                readLine2 = bufferedReader.readLine();
                                if (readLine2 == null) {
                                    break;
                                }
                            } while (!readLine2.contains(str));
                            stringBuilder = readLine;
                            readLine = readLine2;
                            readLine2 = stringBuilder;
                        }
                        map.put(substring, obj);
                    } else {
                        readLine = readLine2;
                    }
                    i2 = i;
                } else {
                    throw new m(q.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but next chunk does not start with boundary. Usage: GET /example/file.html");
                }
            }
        } catch (Exception e) {
            throw new m(q.INTERNAL_ERROR, "SERVER INTERNAL ERROR: IOException: " + e.getMessage(), e);
        }
    }

    private String a(ByteBuffer byteBuffer, int i, int i2) {
        Closeable fileOutputStream;
        Throwable e;
        String str = "";
        if (i2 > 0) {
            try {
                s a = this.b.a();
                ByteBuffer duplicate = byteBuffer.duplicate();
                fileOutputStream = new FileOutputStream(a.b());
                try {
                    FileChannel channel = fileOutputStream.getChannel();
                    duplicate.position(i).limit(i + i2);
                    channel.write(duplicate.slice());
                    str = a.b();
                    c.a(fileOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        throw new Error(e);
                    } catch (Throwable th) {
                        e = th;
                        c.a(fileOutputStream);
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                throw new Error(e);
            } catch (Throwable th2) {
                e = th2;
                fileOutputStream = null;
                c.a(fileOutputStream);
                throw e;
            }
        }
        return str;
    }

    private static int a(ByteBuffer byteBuffer, int i) {
        while (i < byteBuffer.limit()) {
            if (byteBuffer.get(i) == (byte) 13) {
                i++;
                if (byteBuffer.get(i) == (byte) 10) {
                    i++;
                    if (byteBuffer.get(i) == (byte) 13) {
                        i++;
                        if (byteBuffer.get(i) == (byte) 10) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            i++;
        }
        return i + 1;
    }
}
