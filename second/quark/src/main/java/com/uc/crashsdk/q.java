package com.uc.crashsdk;

import com.uc.crashsdk.a.a;
import com.uc.crashsdk.a.b;
import com.uc.crashsdk.a.c;
import com.uc.crashsdk.a.e;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

/* compiled from: ProGuard */
public final class q {
    public static int a = 5000;

    private static byte[] a(File file) {
        Closeable fileInputStream;
        Throwable e;
        Throwable th;
        byte[] bArr = null;
        if (file.isFile()) {
            Closeable bufferedInputStream;
            try {
                int length = (int) file.length();
                fileInputStream = new FileInputStream(file);
                try {
                    bufferedInputStream = new BufferedInputStream(fileInputStream);
                    try {
                        bArr = new byte[length];
                        int i = 0;
                        while (i < length) {
                            int read = bufferedInputStream.read(bArr, i, length - i);
                            if (-1 == read) {
                                break;
                            }
                            i += read;
                        }
                        b.a(bufferedInputStream);
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            a.a(e, true);
                            b.a(bufferedInputStream);
                            b.a(fileInputStream);
                            return bArr;
                        } catch (Throwable th2) {
                            th = th2;
                            b.a(bufferedInputStream);
                            b.a(fileInputStream);
                            throw th;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    bufferedInputStream = null;
                    a.a(e, true);
                    b.a(bufferedInputStream);
                    b.a(fileInputStream);
                    return bArr;
                } catch (Throwable e4) {
                    bufferedInputStream = null;
                    th = e4;
                    b.a(bufferedInputStream);
                    b.a(fileInputStream);
                    throw th;
                }
            } catch (Exception e5) {
                e4 = e5;
                bufferedInputStream = null;
                fileInputStream = null;
                a.a(e4, true);
                b.a(bufferedInputStream);
                b.a(fileInputStream);
                return bArr;
            } catch (Throwable e42) {
                bufferedInputStream = null;
                fileInputStream = null;
                th = e42;
                b.a(bufferedInputStream);
                b.a(fileInputStream);
                throw th;
            }
            b.a(fileInputStream);
        }
        return bArr;
    }

    public static boolean a(File file, String str, String str2) {
        for (int i = 0; i < 2; i++) {
            if (b(file, str, str2)) {
                return true;
            }
            c.b("upload try again: " + str);
        }
        return false;
    }

    private static boolean b(File file, String str, String str2) {
        boolean z = false;
        try {
            byte[] a = a(file);
            if (!(a == null || a.length == 0)) {
                z = a(a, str, str2);
            }
        } catch (Throwable e) {
            a.a(e, false);
        }
        return z;
    }

    private static boolean a(byte[] bArr, String str, String str2) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    HttpClient defaultHttpClient = new DefaultHttpClient();
                    defaultHttpClient.getParams().setIntParameter("http.connection.timeout", 10000);
                    defaultHttpClient.getParams().setIntParameter("http.socket.timeout", 60000);
                    String a = e.a();
                    if (a != null) {
                        defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(a, e.b()));
                    }
                    if (str2 == null || str2.length() <= 0) {
                        return false;
                    }
                    int indexOf;
                    HttpHost httpHost;
                    c.b("uploadCrashLog get url [" + str2 + "] ...");
                    HttpRequest httpPost = new HttpPost(str2);
                    if (str2.startsWith("http://")) {
                        str2 = str2.substring(7);
                    } else if (str2.startsWith("https://")) {
                        str2 = str2.substring(8);
                    }
                    c.b("uploadCrashLog after substr url [" + str2 + "] ...");
                    if (str2.contains(":")) {
                        String substring = str2.substring(0, str2.indexOf(":"));
                        indexOf = str2.indexOf("/");
                        if (indexOf < 0) {
                            indexOf = str2.length();
                        }
                        httpHost = new HttpHost(substring, Integer.valueOf(str2.substring(str2.indexOf(":") + 1, indexOf)).intValue());
                    } else if (str2.contains("/")) {
                        httpHost = new HttpHost(str2.substring(0, str2.indexOf("/")));
                    } else {
                        httpHost = new HttpHost(str2);
                    }
                    httpPost.setHeader("Content-Type", "multipart/form-data; boundary=----------izQ290kHh6g3Yn2IeyJCoc");
                    httpPost.setHeader("Content-Disposition", "form-data; name=\"file\"; filename=" + str);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("------------izQ290kHh6g3Yn2IeyJCoc\r\n");
                    stringBuffer.append("Content-Disposition: form-data; name=\"file\";");
                    stringBuffer.append(" filename=\"").append(str).append("\"\r\n");
                    stringBuffer.append("Content-Type: application/octet-stream\r\n");
                    stringBuffer.append("\r\n");
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byteArrayOutputStream.write(stringBuffer.toString().getBytes());
                    byteArrayOutputStream.write(bArr);
                    stringBuffer = new StringBuffer();
                    stringBuffer.append("\r\n------------izQ290kHh6g3Yn2IeyJCoc--\r\n");
                    byteArrayOutputStream.write(stringBuffer.toString().getBytes());
                    byteArrayOutputStream.close();
                    httpPost.setEntity(new ByteArrayEntity(byteArrayOutputStream.toByteArray()));
                    try {
                        indexOf = defaultHttpClient.execute(httpHost, httpPost).getStatusLine().getStatusCode();
                        c.a("crashsdk", "StatusLine: " + indexOf);
                    } catch (Throwable th) {
                        a.a(th, true);
                        return false;
                    } finally {
                        defaultHttpClient.getConnectionManager().shutdown();
                    }
                    if (indexOf != 200) {
                        return false;
                    }
                    return true;
                }
            } catch (Throwable th2) {
                a.a(th2, true);
                return false;
            }
        }
        return false;
    }
}
