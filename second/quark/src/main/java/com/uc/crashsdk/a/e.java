package com.uc.crashsdk.a;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build.VERSION;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
public class e {
    static final /* synthetic */ boolean a;
    private static String b = "";
    private static a c;

    /* compiled from: ProGuard */
    public final class a {
        public boolean a;
        public String b;
    }

    static {
        boolean z;
        if (e.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        a = z;
    }

    private static boolean d() {
        if (c != null) {
            return c.a;
        }
        Object obj;
        if (c != null) {
            obj = c.b;
        } else {
            NetworkInfo e = e();
            obj = "unknown";
            if (e == null) {
                obj = "no_network";
            } else {
                int type = e.getType();
                if (e.getType() == 1) {
                    obj = "wifi";
                } else {
                    if (e.getExtraInfo() != null) {
                        obj = e.getExtraInfo().toLowerCase();
                    }
                    if (type != 0) {
                        obj = "wifi";
                    } else if (obj.contains("cmwap")) {
                        obj = "cmwap";
                    } else if (obj.contains("cmnet")) {
                        obj = "cmnet";
                    } else if (obj.contains("uniwap")) {
                        obj = "uniwap";
                    } else if (obj.contains("uninet")) {
                        obj = "uninet";
                    } else if (obj.contains("3gwap")) {
                        obj = "3gwap";
                    } else if (obj.contains("3gnet")) {
                        obj = "3gnet";
                    } else if (obj.contains("ctwap")) {
                        obj = "ctwap";
                    } else if (obj.contains("ctnet")) {
                        obj = "ctnet";
                    }
                }
            }
        }
        return "wifi".equals(obj);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.net.NetworkInfo e() {
        /*
        r1 = 0;
        r0 = "connectivity";
        r0 = com.uc.crashsdk.e.a(r0);	 Catch:{ Exception -> 0x003c }
        r0 = (android.net.ConnectivityManager) r0;	 Catch:{ Exception -> 0x003c }
        if (r0 != 0) goto L_0x0012;
    L_0x000b:
        r0 = "ConnectivityStatus, isQuickNet,ConnectivityManager==null";
        com.uc.crashsdk.a.c.c(r0);	 Catch:{ Exception -> 0x003c }
        r0 = r1;
    L_0x0011:
        return r0;
    L_0x0012:
        r1 = r0.getActiveNetworkInfo();	 Catch:{ Exception -> 0x003c }
        if (r1 == 0) goto L_0x001e;
    L_0x0018:
        r2 = r1.isConnected();	 Catch:{ Exception -> 0x0045 }
        if (r2 != 0) goto L_0x003a;
    L_0x001e:
        r2 = r0.getAllNetworkInfo();	 Catch:{ Exception -> 0x0045 }
        if (r2 == 0) goto L_0x003a;
    L_0x0024:
        r0 = 0;
    L_0x0025:
        r3 = r2.length;	 Catch:{ Exception -> 0x0045 }
        if (r0 >= r3) goto L_0x003a;
    L_0x0028:
        r3 = r2[r0];	 Catch:{ Exception -> 0x0045 }
        if (r3 == 0) goto L_0x0037;
    L_0x002c:
        r3 = r2[r0];	 Catch:{ Exception -> 0x0045 }
        r3 = r3.isConnected();	 Catch:{ Exception -> 0x0045 }
        if (r3 == 0) goto L_0x0037;
    L_0x0034:
        r0 = r2[r0];	 Catch:{ Exception -> 0x0045 }
        goto L_0x0011;
    L_0x0037:
        r0 = r0 + 1;
        goto L_0x0025;
    L_0x003a:
        r0 = r1;
        goto L_0x0011;
    L_0x003c:
        r0 = move-exception;
        r4 = r0;
        r0 = r1;
        r1 = r4;
    L_0x0040:
        r2 = 1;
        com.uc.crashsdk.a.a.a(r1, r2);
        goto L_0x0011;
    L_0x0045:
        r0 = move-exception;
        r4 = r0;
        r0 = r1;
        r1 = r4;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.e.e():android.net.NetworkInfo");
    }

    public static String a() {
        if (VERSION.SDK_INT >= 11) {
            return System.getProperty("http.proxyHost");
        }
        Context a = com.uc.crashsdk.e.a();
        if (a == null) {
            return null;
        }
        String host = Proxy.getHost(a);
        if (!d() || host == null || host.indexOf("10.0.0") == -1) {
            return host;
        }
        return "";
    }

    public static int b() {
        if (VERSION.SDK_INT >= 11) {
            String property = System.getProperty("http.proxyPort");
            if (property == null) {
                property = "-1";
            }
            try {
                return Integer.parseInt(property);
            } catch (Exception e) {
                return -1;
            }
        }
        Context a = com.uc.crashsdk.e.a();
        if (a == null) {
            return 80;
        }
        String host = Proxy.getHost(a);
        int port = Proxy.getPort(a);
        if (!d() || host == null || host.indexOf("10.0.0") == -1) {
            return port;
        }
        return -1;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, true, false);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z) {
        return a(bArr, bArr2, z, true);
    }

    private static byte[] a(byte[] bArr, byte[] bArr2, boolean z, boolean z2) {
        AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0});
        Key secretKeySpec = new SecretKeySpec(bArr2, "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(z ? 1 : 2, secretKeySpec, ivParameterSpec);
        if (!z) {
            return instance.doFinal(bArr);
        }
        if (!z2) {
            bArr = a(bArr);
        }
        return instance.doFinal(bArr);
    }

    private static byte[] a(byte[] bArr) {
        Object obj = new byte[(bArr.length + 16)];
        int length = bArr.length;
        obj[0] = (byte) ((length >> 0) & 255);
        obj[1] = (byte) ((length >> 8) & 255);
        obj[2] = (byte) ((length >> 16) & 255);
        obj[3] = (byte) ((length >> 24) & 255);
        for (length = 4; length < 16; length++) {
            obj[length] = null;
        }
        System.arraycopy(bArr, 0, obj, 16, bArr.length);
        return obj;
    }

    public static byte[] c() {
        return new byte[]{(byte) 48, (byte) 25, (byte) 6, (byte) 55};
    }

    public static byte[] a(String str, byte[] bArr) {
        Closeable outputStream;
        Closeable inputStream;
        Closeable closeable;
        Throwable th;
        Closeable closeable2 = null;
        Closeable byteArrayOutputStream;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod(SpdyRequest.POST_METHOD);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bArr.length));
            outputStream = httpURLConnection.getOutputStream();
            try {
                outputStream.write(bArr);
                if (httpURLConnection.getResponseCode() != 200) {
                    b.a(outputStream);
                    b.a(null);
                    b.a(null);
                    return null;
                }
                inputStream = httpURLConnection.getInputStream();
                try {
                    byte[] bArr2 = new byte[1024];
                    byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
                    while (true) {
                        try {
                            int read = inputStream.read(bArr2);
                            if (read != -1) {
                                byteArrayOutputStream.write(bArr2, 0, read);
                            } else {
                                bArr2 = byteArrayOutputStream.toByteArray();
                                b.a(outputStream);
                                b.a(inputStream);
                                b.a(byteArrayOutputStream);
                                return bArr2;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            closeable2 = inputStream;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                    closeable2 = inputStream;
                    b.a(outputStream);
                    b.a(closeable2);
                    b.a(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
                b.a(outputStream);
                b.a(closeable2);
                b.a(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            outputStream = null;
            byteArrayOutputStream = null;
            b.a(outputStream);
            b.a(closeable2);
            b.a(byteArrayOutputStream);
            throw th;
        }
    }

    public static void a(byte[] bArr, int i, byte[] bArr2) {
        if (a || bArr2.length == 4) {
            for (int i2 = 0; i2 < 4; i2++) {
                bArr[i2 + i] = bArr2[i2];
            }
            return;
        }
        throw new AssertionError();
    }
}
