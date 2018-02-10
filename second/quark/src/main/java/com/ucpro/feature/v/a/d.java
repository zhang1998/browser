package com.ucpro.feature.v.a;

import com.uc.translate.a.e;
import com.uc.translate.n;
import com.ucweb.common.util.n.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
public final class d implements n {
    private static boolean a = true;
    private static boolean b = true;

    public final String a(URL url, byte[] bArr, Map<String, String> map) throws IOException {
        HttpURLConnection a;
        Throwable th;
        OutputStream outputStream = null;
        try {
            a = a(url, SpdyRequest.POST_METHOD, (Map) map);
            try {
                a.setConnectTimeout(30000);
                a.setReadTimeout(30000);
                outputStream = a.getOutputStream();
                outputStream.write(bArr);
                String contentType = a.getContentType();
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
                if (a.getResponseCode() < 400) {
                    if ("gzip".equalsIgnoreCase(a.getContentEncoding())) {
                        str = a(new GZIPInputStream(a.getInputStream()), str);
                    } else {
                        str = a(a.getInputStream(), str);
                    }
                } else {
                    if (a.getResponseCode() == 400) {
                        InputStream errorStream = a.getErrorStream();
                        if (errorStream != null) {
                            str = a(errorStream, str);
                        }
                    }
                    throw new IOException(a.getResponseCode() + " " + a.getResponseMessage());
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (a != null) {
                    a.disconnect();
                }
                return str;
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

    private static HttpURLConnection a(URL url, String str, Map<String, String> map) throws IOException {
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
                httpURLConnection2.setHostnameVerifier(new a());
            }
            httpURLConnection = httpURLConnection2;
        } else {
            httpURLConnection = httpURLConnection2;
        }
        httpURLConnection.setRequestMethod(str);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                if (!"TOP_HTTP_DNS_HOST".equals(entry.getKey())) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        return httpURLConnection;
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
}
