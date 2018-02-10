package com.a.a.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.a.a.b;
import com.a.a.g;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
public final class er {
    eu a;
    private String b;
    private String c = "10.0.0.172";
    private int d = 80;
    private Context e;

    public er(Context context) {
        this.e = context;
        this.b = a(context);
    }

    public final byte[] a(byte[] bArr) {
        ar arVar = bb.a(this.e).c;
        String str = "";
        if (arVar.g != null) {
            str = arVar.g;
        }
        ar arVar2 = bb.a(this.e).c;
        String str2 = "";
        if (arVar2.h != null) {
            str2 = arVar2.h;
        }
        if (!TextUtils.isEmpty(str)) {
            g.c = fg.b(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            g.d = fg.b(str2);
        }
        g.e = new String[]{g.c, g.d};
        int i = ea.a(this.e).b;
        if (i != -1) {
            if (i == 0) {
                g.e = new String[]{g.c, g.d};
            } else if (i == 1) {
                g.e = new String[]{g.d, g.c};
            }
        }
        byte[] bArr2 = null;
        for (String str22 : g.e) {
            bArr2 = a(bArr, str22);
            if (bArr2 != null) {
                if (this.a != null) {
                    this.a.e();
                }
                return bArr2;
            }
            if (this.a != null) {
                this.a.f();
            }
        }
        return bArr2;
    }

    private boolean a() {
        if (this.e.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.e.getPackageName()) != 0) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.e.getSystemService("connectivity");
            if (!ey.a(this.e, "android.permission.ACCESS_NETWORK_STATE")) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (!(activeNetworkInfo == null || activeNetworkInfo.getType() == 1)) {
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (extraInfo != null && (extraInfo.equals("cmwap") || extraInfo.equals("3gwap") || extraInfo.equals("uniwap"))) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
        }
    }

    private byte[] a(byte[] bArr, String str) {
        InputStream inputStream;
        Throwable th;
        HttpURLConnection httpURLConnection;
        try {
            if (this.a != null) {
                this.a.c();
            }
            if (a()) {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection(new Proxy(Type.HTTP, new InetSocketAddress(this.c, this.d)));
            } else {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            }
            try {
                httpURLConnection.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
                httpURLConnection.setRequestProperty("X-Umeng-Sdk", this.b);
                httpURLConnection.setRequestProperty("Msg-Type", "envelope/json");
                httpURLConnection.setRequestProperty("Content-Type", "envelope/json");
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setRequestMethod(SpdyRequest.POST_METHOD);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                if (VERSION.SDK_INT < 8) {
                    System.setProperty("http.keepAlive", "false");
                }
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.flush();
                outputStream.close();
                if (this.a != null) {
                    this.a.d();
                }
                int responseCode = httpURLConnection.getResponseCode();
                Object headerField = httpURLConnection.getHeaderField("Content-Type");
                if (TextUtils.isEmpty(headerField) || !headerField.equalsIgnoreCase("application/thrift")) {
                    headerField = null;
                } else {
                    headerField = 1;
                }
                if (responseCode != 200 || r0 == null) {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                }
                fw.b("Send message to " + str);
                inputStream = httpURLConnection.getInputStream();
                byte[] b = fu.b(inputStream);
                fu.c(inputStream);
                if (httpURLConnection == null) {
                    return b;
                }
                httpURLConnection.disconnect();
                return b;
            } catch (Throwable th2) {
                th = th2;
                try {
                    fw.a("IOException,Failed to send message.", th);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private static String a(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Android");
        stringBuffer.append("/");
        stringBuffer.append("6.1.3");
        stringBuffer.append(" ");
        try {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(ey.r(context));
            stringBuffer2.append("/");
            stringBuffer2.append(ey.b(context));
            stringBuffer2.append(" ");
            stringBuffer2.append(Build.MODEL);
            stringBuffer2.append("/");
            stringBuffer2.append(VERSION.RELEASE);
            stringBuffer2.append(" ");
            stringBuffer2.append(fu.a(b.a(context)));
            stringBuffer.append(URLEncoder.encode(stringBuffer2.toString(), "UTF-8"));
        } catch (Throwable th) {
        }
        return stringBuffer.toString();
    }
}
