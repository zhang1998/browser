package com.ucpro.feature.video.cache.d;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: ProGuard */
public final class d {
    b a;
    private g b;
    private String c;
    private InputStream d;
    private Map<String, String> e = new HashMap();
    private boolean f;

    public d(g gVar, String str, String str2) {
        InputStream byteArrayInputStream;
        this.b = gVar;
        this.c = str;
        if (str2 != null) {
            try {
                byteArrayInputStream = new ByteArrayInputStream(str2.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                return;
            }
        }
        byteArrayInputStream = null;
        this.d = byteArrayInputStream;
    }

    public d(g gVar, String str, InputStream inputStream) {
        this.b = gVar;
        this.c = str;
        this.d = inputStream;
    }

    public final void a(String str, String str2) {
        this.e.put(str, str2);
    }

    protected final void a(OutputStream outputStream) {
        String str = this.c;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            if (this.b == null) {
                throw new Error("sendResponse(): Status can't be null.");
            }
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.print("HTTP/1.1 " + this.b.a() + " \r\n");
            if (str != null) {
                printWriter.print("Content-Type: " + str + "\r\n");
            }
            if (this.e == null || this.e.get("Date") == null) {
                printWriter.print("Date: " + simpleDateFormat.format(new Date()) + "\r\n");
            }
            if (this.e != null) {
                for (String str2 : this.e.keySet()) {
                    printWriter.print(str2 + ": " + ((String) this.e.get(str2)) + "\r\n");
                }
            }
            if (!a(this.e, "connection")) {
                printWriter.print("Connection: keep-alive\r\n");
            }
            if (this.a == b.HEAD || !this.f) {
                int available = this.d != null ? this.d.available() : 0;
                if (!a(this.e, "content-length")) {
                    printWriter.print("Content-Length: " + available + "\r\n");
                }
                printWriter.print("\r\n");
                printWriter.flush();
                a(outputStream, available);
            } else {
                a(outputStream, printWriter);
            }
            outputStream.flush();
            c.a(this.d);
        } catch (IOException e) {
        }
    }

    private void a(OutputStream outputStream, PrintWriter printWriter) throws IOException {
        printWriter.print("Transfer-Encoding: chunked\r\n");
        printWriter.print("\r\n");
        printWriter.flush();
        byte[] bytes = "\r\n".getBytes();
        byte[] bArr = new byte[16384];
        while (true) {
            int read = this.d.read(bArr);
            if (read > 0) {
                outputStream.write(String.format("%x\r\n", new Object[]{Integer.valueOf(read)}).getBytes());
                outputStream.write(bArr, 0, read);
                outputStream.write(bytes);
            } else {
                outputStream.write(String.format("0\r\n\r\n", new Object[0]).getBytes());
                return;
            }
        }
    }

    private void a(OutputStream outputStream, int i) throws IOException {
        if (this.a != b.HEAD && this.d != null) {
            byte[] bArr = new byte[16384];
            int i2 = i;
            while (i2 > 0) {
                int read = this.d.read(bArr, 0, i2 > 16384 ? 16384 : i2);
                if (read > 0) {
                    outputStream.write(bArr, 0, read);
                    i2 -= read;
                } else {
                    return;
                }
            }
        }
    }

    private static boolean a(Map<String, String> map, String str) {
        if (map == null) {
            return false;
        }
        boolean z = false;
        for (String equalsIgnoreCase : map.keySet()) {
            z = equalsIgnoreCase.equalsIgnoreCase(str) | z;
        }
        return z;
    }
}
