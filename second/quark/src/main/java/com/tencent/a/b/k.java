package com.tencent.a.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.util.zip.GZIPInputStream;
import org.android.spdy.SpdyRequest;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

/* compiled from: ProGuard */
public final class k {
    private static int a(Context context) {
        int i = -1;
        if (VERSION.SDK_INT >= 11) {
            Object property = System.getProperty("http.proxyPort");
            if (TextUtils.isEmpty(property)) {
                return i;
            }
            try {
                return Integer.parseInt(property);
            } catch (NumberFormatException e) {
                return i;
            }
        } else if (context == null) {
            return Proxy.getDefaultPort();
        } else {
            i = Proxy.getPort(context);
            if (i < 0) {
                return Proxy.getDefaultPort();
            }
            return i;
        }
    }

    private static HttpClient a(Context context, String str) {
        b a;
        int a2;
        int a3;
        i iVar;
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        if (VERSION.SDK_INT < 16) {
            try {
                KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
                instance.load(null, null);
                SocketFactory fVar = new f(instance);
                fVar.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                schemeRegistry.register(new Scheme("https", fVar, 443));
            } catch (Exception e) {
                schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
            }
        } else {
            schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        }
        HttpParams basicHttpParams = new BasicHttpParams();
        if (context != null) {
            a = b.a(context, str);
        } else {
            a = null;
        }
        if (a != null) {
            a2 = a.a("Common_HttpConnectionTimeout");
            a3 = a.a("Common_SocketConnectionTimeout");
        } else {
            a3 = 0;
            a2 = 0;
        }
        if (a2 == 0) {
            a2 = 15000;
        }
        if (a3 == 0) {
            a3 = 30000;
        }
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, a2);
        HttpConnectionParams.setSoTimeout(basicHttpParams, a3);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
        HttpProtocolParams.setUserAgent(basicHttpParams, "AndroidSDK_" + VERSION.SDK + "_" + Build.DEVICE + "_" + VERSION.RELEASE);
        HttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        if (context != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
                    Object property;
                    if (VERSION.SDK_INT >= 11) {
                        property = System.getProperty("http.proxyHost");
                    } else if (context != null) {
                        property = Proxy.getHost(context);
                        if (TextUtils.isEmpty(property)) {
                            property = Proxy.getDefaultHost();
                        }
                    } else {
                        property = Proxy.getDefaultHost();
                    }
                    int a4 = a(context);
                    if (!TextUtils.isEmpty(property) && a4 >= 0) {
                        iVar = new i(property, a4);
                        if (iVar != null) {
                            defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(iVar.a, iVar.b));
                        }
                        return defaultHttpClient;
                    }
                }
            }
        }
        iVar = null;
        if (iVar != null) {
            defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(iVar.a, iVar.b));
        }
        return defaultHttpClient;
    }

    private static String a(Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = bundle.size();
        int i = -1;
        for (String str2 : bundle.keySet()) {
            int i2 = i + 1;
            Object obj = bundle.get(str2);
            if (obj instanceof String) {
                stringBuilder.append("Content-Disposition: form-data; name=\"" + str2 + "\"\r\n\r\n" + ((String) obj));
                if (i2 < size - 1) {
                    stringBuilder.append("\r\n--" + str + "\r\n");
                }
            }
            i = i2;
        }
        return stringBuilder.toString();
    }

    private static String a(Bundle bundle) {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (String str : bundle.keySet()) {
            Object obj2 = bundle.get(str);
            if ((obj2 instanceof String) || (obj2 instanceof String[])) {
                if (obj2 instanceof String[]) {
                    if (obj != null) {
                        obj = null;
                    } else {
                        stringBuilder.append("&");
                    }
                    stringBuilder.append(URLEncoder.encode(str) + "=");
                    String[] stringArray = bundle.getStringArray(str);
                    if (stringArray != null) {
                        for (int i = 0; i < stringArray.length; i++) {
                            if (i == 0) {
                                stringBuilder.append(URLEncoder.encode(stringArray[i]));
                            } else {
                                stringBuilder.append(URLEncoder.encode("," + stringArray[i]));
                            }
                        }
                    }
                } else {
                    if (obj != null) {
                        obj = null;
                    } else {
                        stringBuilder.append("&");
                    }
                    stringBuilder.append(URLEncoder.encode(str) + "=" + URLEncoder.encode(bundle.getString(str)));
                }
            }
        }
        return stringBuilder.toString();
    }

    private static String a(HttpResponse httpResponse) throws IllegalStateException, IOException {
        InputStream content = httpResponse.getEntity().getContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Header firstHeader = httpResponse.getFirstHeader("Content-Encoding");
        if (firstHeader == null || firstHeader.getValue().toLowerCase().indexOf("gzip") < 0) {
            InputStream inputStream = content;
        } else {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(content);
        }
        byte[] bArr = new byte[512];
        while (true) {
            int read = gZIPInputStream.read(bArr);
            if (read == -1) {
                String str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                gZIPInputStream.close();
                return str;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static o a(Context context, String str, String str2, Bundle bundle) throws MalformedURLException, IOException, j, g {
        Bundle bundle2;
        int length;
        HttpGet httpGet;
        int i;
        if (context != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                    throw new j("network unavailable");
                }
            }
        }
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        String string = bundle2.getString("appid_for_getting_config");
        bundle2.remove("appid_for_getting_config");
        HttpClient a = a(context, string);
        if (str2.equals(SpdyRequest.GET_METHOD)) {
            String a2 = a(bundle2);
            length = a2.length() + 0;
            if (str.indexOf("?") == -1) {
                string = new StringBuilder(String.valueOf(str)).append("?").toString();
            } else {
                string = new StringBuilder(String.valueOf(str)).append("&").toString();
            }
            new StringBuilder("-->openUrl2 encodedParam =").append(a2).append(" -- url = ").append(string);
            HttpGet httpGet2 = new HttpGet(new StringBuilder(String.valueOf(string)).append(a2).toString());
            httpGet2.addHeader("Accept-Encoding", "gzip");
            httpGet = httpGet2;
            i = length;
        } else if (str2.equals(SpdyRequest.POST_METHOD)) {
            HttpRequestBase httpPost = new HttpPost(str);
            httpPost.addHeader("Accept-Encoding", "gzip");
            Bundle bundle3 = new Bundle();
            for (String string2 : bundle2.keySet()) {
                Object obj = bundle2.get(string2);
                if (obj instanceof byte[]) {
                    bundle3.putByteArray(string2, (byte[]) obj);
                }
            }
            if (!bundle2.containsKey("method")) {
                bundle2.putString("method", str2);
            }
            httpPost.setHeader("Content-Type", "multipart/form-data; boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
            httpPost.setHeader("Connection", "Keep-Alive");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(p.b("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
            byteArrayOutputStream.write(p.b(a(bundle2, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f")));
            if (!bundle3.isEmpty()) {
                length = bundle3.size();
                byteArrayOutputStream.write(p.b("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                i = -1;
                for (String string22 : bundle3.keySet()) {
                    i++;
                    byteArrayOutputStream.write(p.b("Content-Disposition: form-data; name=\"" + string22 + "\"; filename=\"" + string22 + "\"\r\n"));
                    byteArrayOutputStream.write(p.b("Content-Type: content/unknown\r\n\r\n"));
                    byte[] byteArray = bundle3.getByteArray(string22);
                    if (byteArray != null) {
                        byteArrayOutputStream.write(byteArray);
                    }
                    if (i < length - 1) {
                        byteArrayOutputStream.write(p.b("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                    }
                }
            }
            byteArrayOutputStream.write(p.b("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n"));
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            int length2 = toByteArray.length + 0;
            byteArrayOutputStream.close();
            httpPost.setEntity(new ByteArrayEntity(toByteArray));
            i = length2;
            HttpRequestBase httpRequestBase = httpPost;
        } else {
            httpGet = null;
            i = 0;
        }
        HttpResponse execute = a.execute(httpGet);
        length = execute.getStatusLine().getStatusCode();
        if (length == 200) {
            return new o(a(execute), i);
        }
        throw new g("http status code error:" + length);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject a(com.tencent.connect.b.h r7, android.content.Context r8, java.lang.String r9, android.os.Bundle r10, java.lang.String r11) throws java.io.IOException, org.json.JSONException, com.tencent.a.b.j, com.tencent.a.b.g {
        /*
        r0 = r9.toLowerCase();
        r1 = "http";
        r0 = r0.startsWith(r1);
        if (r0 != 0) goto L_0x00df;
    L_0x000c:
        r0 = new java.lang.StringBuilder;
        r1 = com.tencent.a.b.m.a();
        r2 = "https://openmobile.qq.com/";
        r1 = r1.a(r8, r2);
        r1 = java.lang.String.valueOf(r1);
        r0.<init>(r1);
        r0 = r0.append(r9);
        r0 = r0.toString();
        r1 = new java.lang.StringBuilder;
        r2 = com.tencent.a.b.m.a();
        r3 = "https://openmobile.qq.com/";
        r2 = r2.a(r8, r3);
        r2 = java.lang.String.valueOf(r2);
        r1.<init>(r2);
        r1 = r1.append(r9);
        r9 = r1.toString();
    L_0x0042:
        r3 = 0;
        android.os.SystemClock.elapsedRealtime();
        r2 = 0;
        r1 = r7.a;
        r1 = com.tencent.a.b.b.a(r8, r1);
        r4 = "Common_HttpRetryCount";
        r1 = r1.a(r4);
        r4 = new java.lang.StringBuilder;
        r5 = "config 1:Common_HttpRetryCount            config_value:";
        r4.<init>(r5);
        r4 = r4.append(r1);
        r5 = "   appid:";
        r4 = r4.append(r5);
        r5 = r7.a;
        r4 = r4.append(r5);
        r5 = "     url:";
        r4 = r4.append(r5);
        r4.append(r9);
        if (r1 != 0) goto L_0x0076;
    L_0x0075:
        r1 = 3;
    L_0x0076:
        r4 = new java.lang.StringBuilder;
        r5 = "config 1:Common_HttpRetryCount            result_value:";
        r4.<init>(r5);
        r4 = r4.append(r1);
        r5 = "   appid:";
        r4 = r4.append(r5);
        r5 = r7.a;
        r4 = r4.append(r5);
        r5 = "     url:";
        r4 = r4.append(r5);
        r4.append(r9);
    L_0x0096:
        r2 = r2 + 1;
        r4 = a(r8, r0, r11, r10);	 Catch:{ ConnectTimeoutException -> 0x00a8, SocketTimeoutException -> 0x00b6, g -> 0x00c2, j -> 0x00d3, MalformedURLException -> 0x00d5, IOException -> 0x00d7, JSONException -> 0x00d9 }
        r4 = r4.a;	 Catch:{ ConnectTimeoutException -> 0x00a8, SocketTimeoutException -> 0x00b6, g -> 0x00c2, j -> 0x00d3, MalformedURLException -> 0x00d5, IOException -> 0x00d7, JSONException -> 0x00d9 }
        r3 = com.tencent.a.b.p.c(r4);	 Catch:{ ConnectTimeoutException -> 0x00a8, SocketTimeoutException -> 0x00b6, g -> 0x00c2, j -> 0x00d3, MalformedURLException -> 0x00d5, IOException -> 0x00d7, JSONException -> 0x00d9 }
        r4 = "ret";
        r3.getInt(r4);	 Catch:{ JSONException -> 0x00dd, ConnectTimeoutException -> 0x00a8, SocketTimeoutException -> 0x00b6, g -> 0x00c2, j -> 0x00d3, MalformedURLException -> 0x00d5, IOException -> 0x00d7 }
    L_0x00a7:
        return r3;
    L_0x00a8:
        r4 = move-exception;
        r6 = r4;
        r4 = r3;
        r3 = r6;
        if (r2 < r1) goto L_0x00af;
    L_0x00ae:
        throw r3;
    L_0x00af:
        android.os.SystemClock.elapsedRealtime();
        r3 = r4;
    L_0x00b3:
        if (r2 < r1) goto L_0x0096;
    L_0x00b5:
        goto L_0x00a7;
    L_0x00b6:
        r4 = move-exception;
        r6 = r4;
        r4 = r3;
        r3 = r6;
        if (r2 < r1) goto L_0x00bd;
    L_0x00bc:
        throw r3;
    L_0x00bd:
        android.os.SystemClock.elapsedRealtime();
        r3 = r4;
        goto L_0x00b3;
    L_0x00c2:
        r0 = move-exception;
        r1 = r0.getMessage();
        r2 = "http status code error:";
        r3 = "";
        r1 = r1.replace(r2, r3);	 Catch:{ Exception -> 0x00db }
        java.lang.Integer.parseInt(r1);	 Catch:{ Exception -> 0x00db }
    L_0x00d2:
        throw r0;
    L_0x00d3:
        r0 = move-exception;
        throw r0;
    L_0x00d5:
        r0 = move-exception;
        throw r0;
    L_0x00d7:
        r0 = move-exception;
        throw r0;
    L_0x00d9:
        r0 = move-exception;
        throw r0;
    L_0x00db:
        r1 = move-exception;
        goto L_0x00d2;
    L_0x00dd:
        r0 = move-exception;
        goto L_0x00a7;
    L_0x00df:
        r0 = r9;
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.a.b.k.a(com.tencent.connect.b.h, android.content.Context, java.lang.String, android.os.Bundle, java.lang.String):org.json.JSONObject");
    }
}
