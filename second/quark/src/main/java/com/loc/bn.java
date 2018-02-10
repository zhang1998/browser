package com.loc;

import android.os.Build.VERSION;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.PushbackInputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
public final class bn {
    static bo a;
    volatile boolean b;
    long c;
    long d;
    private int e;
    private int f;
    private boolean g;
    private SSLContext h;
    private Proxy i;
    private String j;
    private bh k;
    private HostnameVerifier l;

    bn(int i, int i2, Proxy proxy) {
        this(i, i2, proxy, false);
    }

    bn(int i, int i2, Proxy proxy, boolean z) {
        this(i, i2, proxy, z, (byte) 0);
    }

    private bn(int i, int i2, Proxy proxy, boolean z, byte b) {
        this.b = false;
        this.c = -1;
        this.d = 0;
        this.l = new bm(this);
        this.e = i;
        this.f = i2;
        this.i = proxy;
        this.g = z;
        this.k = null;
        try {
            this.j = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            es.a(th, "HttpUrlUtil", "initCSID");
        }
        if (z) {
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init(null, null, null);
                this.h = instance;
            } catch (Throwable th2) {
                es.a(th2, "HttpUtil", "HttpUtil");
            }
        }
    }

    private bq a(HttpURLConnection httpURLConnection) throws dw, IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        IOException e;
        Throwable th;
        InputStream inputStream2;
        PushbackInputStream pushbackInputStream = null;
        InputStream pushbackInputStream2;
        try {
            Map headerFields = httpURLConnection.getHeaderFields();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 200) {
                throw new dw("网络异常原因：" + httpURLConnection.getResponseMessage() + " 网络异常状态码：" + responseCode);
            }
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                inputStream = httpURLConnection.getInputStream();
                try {
                    pushbackInputStream2 = new PushbackInputStream(inputStream, 2);
                } catch (IOException e2) {
                    e = e2;
                    pushbackInputStream2 = null;
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    pushbackInputStream2 = null;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th4) {
                            es.a(th4, "HttpUrlUtil", "parseResult");
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th5) {
                            es.a(th5, "HttpUrlUtil", "parseResult");
                        }
                    }
                    if (pushbackInputStream != null) {
                        try {
                            pushbackInputStream.close();
                        } catch (Throwable th6) {
                            es.a(th6, "HttpUrlUtil", "parseResult");
                        }
                    }
                    if (pushbackInputStream2 != null) {
                        try {
                            pushbackInputStream2.close();
                        } catch (Throwable th62) {
                            es.a(th62, "HttpUrlUtil", "parseResult");
                        }
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable th622) {
                            es.a(th622, "HttpUrlUtil", "parseResult");
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                pushbackInputStream2 = null;
                inputStream = null;
                throw e;
            } catch (Throwable th7) {
                th = th7;
                pushbackInputStream2 = null;
                inputStream = null;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (pushbackInputStream != null) {
                    pushbackInputStream.close();
                }
                if (pushbackInputStream2 != null) {
                    pushbackInputStream2.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
            InputStream gZIPInputStream;
            try {
                byte[] bArr = new byte[2];
                pushbackInputStream2.read(bArr);
                pushbackInputStream2.unread(bArr);
                gZIPInputStream = (bArr[0] == (byte) 31 && bArr[1] == (byte) -117) ? new GZIPInputStream(pushbackInputStream2) : pushbackInputStream2;
                try {
                    bArr = new byte[1024];
                    while (true) {
                        int read = gZIPInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (a != null) {
                        a.a();
                    }
                    bq bqVar = new bq();
                    bqVar.a = byteArrayOutputStream.toByteArray();
                    bqVar.b = headerFields;
                    bqVar.c = this.j;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th42) {
                            es.a(th42, "HttpUrlUtil", "parseResult");
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th52) {
                            es.a(th52, "HttpUrlUtil", "parseResult");
                        }
                    }
                    if (pushbackInputStream2 != null) {
                        try {
                            pushbackInputStream2.close();
                        } catch (Throwable th8) {
                            es.a(th8, "HttpUrlUtil", "parseResult");
                        }
                    }
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (Throwable th6222) {
                            es.a(th6222, "HttpUrlUtil", "parseResult");
                        }
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable th62222) {
                            es.a(th62222, "HttpUrlUtil", "parseResult");
                        }
                    }
                    return bqVar;
                } catch (IOException e4) {
                    e = e4;
                    inputStream2 = pushbackInputStream2;
                    pushbackInputStream2 = gZIPInputStream;
                    gZIPInputStream = inputStream2;
                    throw e;
                } catch (Throwable th9) {
                    th = th9;
                    inputStream2 = pushbackInputStream2;
                    pushbackInputStream2 = gZIPInputStream;
                    gZIPInputStream = inputStream2;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (pushbackInputStream != null) {
                        pushbackInputStream.close();
                    }
                    if (pushbackInputStream2 != null) {
                        pushbackInputStream2.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                inputStream2 = pushbackInputStream2;
                pushbackInputStream2 = null;
                gZIPInputStream = inputStream2;
                throw e;
            } catch (Throwable th10) {
                th = th10;
                inputStream2 = pushbackInputStream2;
                pushbackInputStream2 = null;
                gZIPInputStream = inputStream2;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (pushbackInputStream != null) {
                    pushbackInputStream.close();
                }
                if (pushbackInputStream2 != null) {
                    pushbackInputStream2.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            pushbackInputStream2 = null;
            inputStream = null;
            byteArrayOutputStream = null;
            throw e;
        } catch (Throwable th11) {
            th = th11;
            pushbackInputStream2 = null;
            inputStream = null;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (pushbackInputStream != null) {
                pushbackInputStream.close();
            }
            if (pushbackInputStream2 != null) {
                pushbackInputStream2.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    static String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (str2 == null) {
                str2 = "";
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append(URLEncoder.encode(str));
            stringBuilder.append("=");
            stringBuilder.append(URLEncoder.encode(str2));
        }
        return stringBuilder.toString();
    }

    private void a(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map != null) {
            for (String str : map.keySet()) {
                httpURLConnection.addRequestProperty(str, (String) map.get(str));
            }
        }
        try {
            httpURLConnection.addRequestProperty("csid", this.j);
        } catch (Throwable th) {
            es.a(th, "HttpUrlUtil", "addHeaders");
        }
        httpURLConnection.setConnectTimeout(this.e);
        httpURLConnection.setReadTimeout(this.f);
    }

    final bq a(String str, Map<String, String> map, byte[] bArr) throws dw {
        try {
            HttpURLConnection a = a(str, (Map) map, true);
            if (bArr != null && bArr.length > 0) {
                DataOutputStream dataOutputStream = new DataOutputStream(a.getOutputStream());
                dataOutputStream.write(bArr);
                dataOutputStream.close();
            }
            a.connect();
            return a(a);
        } catch (ConnectException e) {
            throw new dw("http连接失败 - ConnectionException");
        } catch (MalformedURLException e2) {
            throw new dw("url异常 - MalformedURLException");
        } catch (UnknownHostException e3) {
            throw new dw("未知主机 - UnKnowHostException");
        } catch (SocketException e4) {
            throw new dw("socket 连接异常 - SocketException");
        } catch (SocketTimeoutException e5) {
            throw new dw("socket 连接超时 - SocketTimeoutException");
        } catch (InterruptedIOException e6) {
            throw new dw("未知的错误");
        } catch (IOException e7) {
            throw new dw("IO 操作异常 - IOException");
        } catch (Throwable e8) {
            es.a(e8, "HttpUrlUtil", "makePostReqeust");
            throw e8;
        } catch (Throwable e82) {
            es.a(e82, "HttpUrlUtil", "makePostReqeust");
            dw dwVar = new dw("未知的错误");
        }
    }

    final HttpURLConnection a(String str, Map<String, String> map, boolean z) throws IOException {
        HttpURLConnection httpURLConnection;
        ei.a();
        URLConnection uRLConnection = null;
        URL url = new URL(str);
        if (this.k != null) {
            uRLConnection = this.k.a();
        }
        if (uRLConnection == null) {
            uRLConnection = this.i != null ? url.openConnection(this.i) : url.openConnection();
        }
        if (this.g) {
            httpURLConnection = (HttpsURLConnection) uRLConnection;
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.h.getSocketFactory());
            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(this.l);
        } else {
            httpURLConnection = (HttpURLConnection) uRLConnection;
        }
        if (VERSION.SDK != null && VERSION.SDK_INT > 13) {
            httpURLConnection.setRequestProperty("Connection", "close");
        }
        a(map, httpURLConnection);
        if (z) {
            httpURLConnection.setRequestMethod(SpdyRequest.POST_METHOD);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
        } else {
            httpURLConnection.setRequestMethod(SpdyRequest.GET_METHOD);
            httpURLConnection.setDoInput(true);
        }
        return httpURLConnection;
    }
}
