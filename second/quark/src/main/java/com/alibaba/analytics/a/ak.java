package com.alibaba.analytics.a;

import android.text.TextUtils;
import com.uc.webview.export.extension.UCCore;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class ak {
    private static int a = 0;
    private static int b = 0;
    private static HashMap<String, String> c = new HashMap();

    public static synchronized byte[] a(String str) throws IOException {
        byte[] a;
        synchronized (ak.class) {
            a = a(str, true);
        }
        return a;
    }

    public static synchronized byte[] b(String str) throws IOException {
        byte[] a;
        synchronized (ak.class) {
            a = a(str, false);
        }
        return a;
    }

    private static synchronized byte[] a(String str, boolean z) throws IOException {
        byte[] toByteArray;
        synchronized (ak.class) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (b(str, z)) {
                int parseInt;
                try {
                    parseInt = Integer.parseInt((String) c.get(str));
                } catch (Exception e) {
                    parseInt = -1;
                }
                if (parseInt >= 0) {
                    byteArrayOutputStream.write(a(1, parseInt));
                } else {
                    c(str);
                    byteArrayOutputStream.write(a(2, str.getBytes().length));
                    byteArrayOutputStream.write(str.getBytes());
                }
            } else if (TextUtils.isEmpty(str)) {
                byteArrayOutputStream.write(a(3, 0));
            } else {
                byteArrayOutputStream.write(a(3, str.getBytes().length));
                byteArrayOutputStream.write(str.getBytes());
            }
            toByteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e2) {
            }
        }
        return toByteArray;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized boolean b(java.lang.String r4, boolean r5) {
        /*
        r0 = 0;
        r1 = com.alibaba.analytics.a.ak.class;
        monitor-enter(r1);
        r2 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x002d }
        if (r2 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r1);
        return r0;
    L_0x000c:
        if (r5 == 0) goto L_0x0024;
    L_0x000e:
        r2 = r4.length();	 Catch:{ all -> 0x002d }
        r3 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        if (r2 > r3) goto L_0x000a;
    L_0x0016:
        r2 = a;	 Catch:{ all -> 0x002d }
        r3 = r4.length();	 Catch:{ all -> 0x002d }
        r2 = r2 + r3;
        r3 = 32768; // 0x8000 float:4.5918E-41 double:1.61895E-319;
        if (r2 > r3) goto L_0x000a;
    L_0x0022:
        r0 = 1;
        goto L_0x000a;
    L_0x0024:
        r2 = r4.length();	 Catch:{ all -> 0x002d }
        r3 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        if (r2 <= r3) goto L_0x0016;
    L_0x002c:
        goto L_0x000a;
    L_0x002d:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.analytics.a.ak.b(java.lang.String, boolean):boolean");
    }

    private static synchronized void c(String str) {
        synchronized (ak.class) {
            c.put(str, b);
            a += str.length();
            b++;
        }
    }

    public static synchronized void a() {
        synchronized (ak.class) {
            c.clear();
            a = 0;
            b = 0;
        }
    }

    private static byte[] a(int i, int i2) {
        int i3 = 1;
        byte b = (byte) (1 << (8 - i));
        int i4 = (1 << (8 - i)) - 1;
        if (i2 < i4) {
            i4 = i2 | b;
            return new byte[]{(byte) (i4 & 255)};
        }
        byte[] bArr = new byte[4];
        bArr[0] = (byte) ((b | i4) & 255);
        int i5 = i2 - i4;
        while (i5 >= 128) {
            bArr[i3] = (byte) (((i5 % 128) | 128) & 255);
            i5 /= 128;
            i3++;
        }
        bArr[i3] = (byte) (i5 & UCCore.SPEEDUP_DEXOPT_POLICY_DAVIK);
        return e.b(bArr, 0, i3 + 1);
    }

    public static byte[] a(int i) {
        return a(0, i);
    }
}
