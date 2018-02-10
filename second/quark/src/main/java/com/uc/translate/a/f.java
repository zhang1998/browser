package com.uc.translate.a;

import com.ucweb.common.util.n.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
public final class f {
    private static boolean a = true;
    private static boolean b = true;

    private static HttpURLConnection a(URL url, String str, String str2, Map<String, String> map, Proxy proxy) throws IOException {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
        if (httpURLConnection2 instanceof HttpsURLConnection) {
            httpURLConnection2 = (HttpsURLConnection) httpURLConnection2;
            if (a) {
                try {
                    SSLContext instance = SSLContext.getInstance("TLS");
                    instance.init(null, new TrustManager[]{new e()}, new SecureRandom());
                    httpURLConnection2.setSSLSocketFactory(instance.getSocketFactory());
                    httpURLConnection2.setHostnameVerifier(new c());
                } catch (Exception e) {
                    throw new IOException(e.toString());
                }
            } else if (b) {
                httpURLConnection2.setHostnameVerifier(new d());
            }
            httpURLConnection = httpURLConnection2;
        } else {
            httpURLConnection = httpURLConnection2;
        }
        httpURLConnection.setRequestMethod(str);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        if (map == null || map.get("TOP_HTTP_DNS_HOST") == null) {
            httpURLConnection.setRequestProperty("Host", url.getHost());
        } else {
            httpURLConnection.setRequestProperty("Host", (String) map.get("TOP_HTTP_DNS_HOST"));
        }
        httpURLConnection.setRequestProperty("Accept", "text/xml,text/javascript");
        httpURLConnection.setRequestProperty("User-Agent", "top-sdk-java");
        httpURLConnection.setRequestProperty("Content-Type", str2);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                if (!"TOP_HTTP_DNS_HOST".equals(entry.getKey())) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        return httpURLConnection;
    }

    private static String a(HttpURLConnection httpURLConnection) throws IOException {
        String contentType = httpURLConnection.getContentType();
        String str = "UTF-8";
        if (!a.a(contentType)) {
            String[] split = contentType.split(";");
            int length = split.length;
            int i = 0;
            while (i < length) {
                String trim = split[i].trim();
                if (trim.startsWith("charset")) {
                    String[] split2 = trim.split("=", 2);
                    if (split2.length == 2 && !a.a(split2[1])) {
                        str = split2[1].trim();
                    }
                } else {
                    i++;
                }
            }
        }
        if (httpURLConnection.getResponseCode() < 400) {
            if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                return a(new GZIPInputStream(httpURLConnection.getInputStream()), str);
            }
            return a(httpURLConnection.getInputStream(), str);
        }
        if (httpURLConnection.getResponseCode() == 400) {
            InputStream errorStream = httpURLConnection.getErrorStream();
            if (errorStream != null) {
                return a(errorStream, str);
            }
        }
        throw new IOException(httpURLConnection.getResponseCode() + " " + httpURLConnection.getResponseMessage());
    }

    private static String a(InputStream inputStream, String str) throws IOException {
        try {
            Reader inputStreamReader = new InputStreamReader(inputStream, str);
            StringBuilder stringBuilder = new StringBuilder();
            char[] cArr = new char[1024];
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read <= 0) {
                    break;
                }
                stringBuilder.append(cArr, 0, read);
            }
            String stringBuilder2 = stringBuilder.toString();
            return stringBuilder2;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static String a(String str, Map<String, String> map, String str2, int i, int i2, Map<String, String> map2) throws IOException {
        String str3 = "application/x-www-form-urlencoded;charset=" + str2;
        String a = a((Map) map, str2);
        byte[] bArr = new byte[0];
        if (a != null) {
            bArr = a.getBytes(str2);
        }
        return a(str, str3, bArr, i, i2, (Map) map2);
    }

    private static String a(String str, String str2, byte[] bArr, int i, int i2, Map<String, String> map) throws IOException {
        HttpURLConnection a;
        Throwable th;
        OutputStream outputStream = null;
        try {
            a = a(new URL(str), SpdyRequest.POST_METHOD, str2, map, null);
            try {
                a.setConnectTimeout(i);
                a.setReadTimeout(i2);
                outputStream = a.getOutputStream();
                outputStream.write(bArr);
                String a2 = a(a);
                if (outputStream != null) {
                    outputStream.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                return a2;
            } catch (Throwable th2) {
                th = th2;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            a = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (a != null) {
                a.disconnect();
            }
            throw th;
        }
    }

    public static String a(Map<String, String> map, String str) throws IOException {
        if (map == null || map.isEmpty()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (Entry entry : map.entrySet()) {
            if (a.a((String) entry.getKey(), (String) entry.getValue())) {
                if (i != 0) {
                    stringBuilder.append("&");
                } else {
                    i = 1;
                }
                stringBuilder.append(r1).append("=").append(URLEncoder.encode(r0, str));
            }
            i = i;
        }
        return stringBuilder.toString();
    }

    public static String a(String str, String... strArr) {
        Object obj;
        StringBuilder stringBuilder = new StringBuilder(str);
        boolean contains = str.contains("?");
        if (str.endsWith("?") || str.endsWith("&")) {
            obj = 1;
        } else {
            obj = null;
        }
        boolean z = contains;
        Object obj2 = obj;
        boolean z2 = z;
        for (int i = 0; i < 2; i++) {
            String str2 = strArr[i];
            if (!a.a(str2)) {
                if (obj2 == null) {
                    if (z2) {
                        stringBuilder.append("&");
                    } else {
                        stringBuilder.append("?");
                        z2 = true;
                    }
                }
                stringBuilder.append(str2);
                obj2 = null;
            }
        }
        return stringBuilder.toString();
    }
}
