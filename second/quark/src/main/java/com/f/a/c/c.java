package com.f.a.c;

import android.content.Context;
import android.provider.Settings.System;
import com.f.a.a.a.a;
import com.f.a.b.a.b;
import com.f.a.b.a.e;
import com.f.a.b.a.g;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: ProGuard */
public final class c {
    private static final Object b = new Object();
    private static c c = null;
    private static final String j = (".UTSystemConfig" + File.separator + "Global");
    private Context a = null;
    private String d = null;
    private b e = null;
    private String f = "xx_utdid_key";
    private String g = "xx_utdid_domain";
    private a h = null;
    private a i = null;
    private Pattern k = Pattern.compile("[^0-9a-zA-Z=/+]+");

    private c(Context context) {
        this.a = context;
        this.i = new a(context, j, "Alvin2");
        this.h = new a(context, ".DataStorage", "ContextData");
        this.e = new b();
        this.f = String.format("K_%d", new Object[]{Integer.valueOf(com.f.a.b.a.c.b(this.f))});
        this.g = String.format("D_%d", new Object[]{Integer.valueOf(com.f.a.b.a.c.b(this.g))});
    }

    public static c a(Context context) {
        Object obj = 1;
        if (context != null && c == null) {
            synchronized (b) {
                if (c == null) {
                    c cVar = new c(context);
                    c = cVar;
                    if (cVar.i != null) {
                        if (com.f.a.b.a.c.a(cVar.i.b("UTDID2"))) {
                            String b = cVar.i.b("UTDID");
                            if (!com.f.a.b.a.c.a(b)) {
                                cVar.a(b);
                            }
                        }
                        Object obj2 = null;
                        if (!com.f.a.b.a.c.a(cVar.i.b("DID"))) {
                            cVar.i.a("DID");
                            obj2 = 1;
                        }
                        if (!com.f.a.b.a.c.a(cVar.i.b("EI"))) {
                            cVar.i.a("EI");
                            obj2 = 1;
                        }
                        if (com.f.a.b.a.c.a(cVar.i.b("SI"))) {
                            obj = obj2;
                        } else {
                            cVar.i.a("SI");
                        }
                        if (obj != null) {
                            cVar.i.a();
                        }
                    }
                }
            }
        }
        return c;
    }

    private void a(String str) {
        if (e(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() == 24 && this.i != null) {
                this.i.a("UTDID2", str);
                this.i.a();
            }
        }
    }

    private void b(String str) {
        if (str != null && this.h != null && !str.equals(this.h.b(this.f))) {
            this.h.a(this.f, str);
            this.h.a();
        }
    }

    private void c(String str) {
        if (this.a.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0 && e(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length() && !e(System.getString(this.a.getContentResolver(), "mqBRboGZkQPcAkyk"))) {
                try {
                    System.putString(this.a.getContentResolver(), "mqBRboGZkQPcAkyk", str);
                } catch (Exception e) {
                }
            }
        }
    }

    private void d(String str) {
        if (this.a.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0 && str != null && !str.equals(System.getString(this.a.getContentResolver(), "dxCRMxhQkdGePGnp"))) {
            try {
                System.putString(this.a.getContentResolver(), "dxCRMxhQkdGePGnp", str);
            } catch (Exception e) {
            }
        }
    }

    private boolean e(String str) {
        if (str == null) {
            return false;
        }
        if (str.endsWith("\n")) {
            str = str.substring(0, str.length() - 1);
        }
        if (24 != str.length() || this.k.matcher(str).find()) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String a() {
        /*
        r6 = this;
        r1 = 0;
        monitor-enter(r6);
        r0 = r6.d;	 Catch:{ all -> 0x0044 }
        if (r0 == 0) goto L_0x000a;
    L_0x0006:
        r0 = r6.d;	 Catch:{ all -> 0x0044 }
    L_0x0008:
        monitor-exit(r6);
        return r0;
    L_0x000a:
        r0 = "";
        r2 = r6.a;	 Catch:{ Exception -> 0x0132 }
        r2 = r2.getContentResolver();	 Catch:{ Exception -> 0x0132 }
        r3 = "mqBRboGZkQPcAkyk";
        r0 = android.provider.Settings.System.getString(r2, r3);	 Catch:{ Exception -> 0x0132 }
    L_0x0018:
        r2 = r6.e(r0);	 Catch:{ all -> 0x0044 }
        if (r2 != 0) goto L_0x0008;
    L_0x001e:
        r4 = new com.f.a.c.f;	 Catch:{ all -> 0x0044 }
        r4.<init>();	 Catch:{ all -> 0x0044 }
        r2 = 0;
        r0 = r6.a;	 Catch:{ all -> 0x0044 }
        r0 = r0.getContentResolver();	 Catch:{ all -> 0x0044 }
        r3 = "dxCRMxhQkdGePGnp";
        r3 = android.provider.Settings.System.getString(r0, r3);	 Catch:{ all -> 0x0044 }
        r0 = com.f.a.b.a.c.a(r3);	 Catch:{ all -> 0x0044 }
        if (r0 != 0) goto L_0x0088;
    L_0x0036:
        r0 = r4.b(r3);	 Catch:{ all -> 0x0044 }
        r5 = r6.e(r0);	 Catch:{ all -> 0x0044 }
        if (r5 == 0) goto L_0x0047;
    L_0x0040:
        r6.c(r0);	 Catch:{ all -> 0x0044 }
        goto L_0x0008;
    L_0x0044:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
    L_0x0047:
        r0 = r4.a(r3);	 Catch:{ all -> 0x0044 }
        r5 = r6.e(r0);	 Catch:{ all -> 0x0044 }
        if (r5 == 0) goto L_0x0135;
    L_0x0051:
        r5 = r6.e;	 Catch:{ all -> 0x0044 }
        r0 = r5.a(r0);	 Catch:{ all -> 0x0044 }
        r5 = com.f.a.b.a.c.a(r0);	 Catch:{ all -> 0x0044 }
        if (r5 != 0) goto L_0x0135;
    L_0x005d:
        r6.d(r0);	 Catch:{ all -> 0x0044 }
        r0 = r6.a;	 Catch:{ all -> 0x0044 }
        r0 = r0.getContentResolver();	 Catch:{ all -> 0x0044 }
        r3 = "dxCRMxhQkdGePGnp";
        r0 = android.provider.Settings.System.getString(r0, r3);	 Catch:{ all -> 0x0044 }
    L_0x006c:
        r3 = r6.e;	 Catch:{ all -> 0x0044 }
        r3 = r3.b(r0);	 Catch:{ all -> 0x0044 }
        r5 = r6.e(r3);	 Catch:{ all -> 0x0044 }
        if (r5 == 0) goto L_0x008a;
    L_0x0078:
        r6.d = r3;	 Catch:{ all -> 0x0044 }
        r6.a(r3);	 Catch:{ all -> 0x0044 }
        r6.b(r0);	 Catch:{ all -> 0x0044 }
        r0 = r6.d;	 Catch:{ all -> 0x0044 }
        r6.c(r0);	 Catch:{ all -> 0x0044 }
        r0 = r6.d;	 Catch:{ all -> 0x0044 }
        goto L_0x0008;
    L_0x0088:
        r0 = 1;
        r2 = r0;
    L_0x008a:
        r0 = r6.i;	 Catch:{ all -> 0x0044 }
        if (r0 == 0) goto L_0x00bf;
    L_0x008e:
        r0 = r6.i;	 Catch:{ all -> 0x0044 }
        r3 = "UTDID2";
        r0 = r0.b(r3);	 Catch:{ all -> 0x0044 }
        r3 = com.f.a.b.a.c.a(r0);	 Catch:{ all -> 0x0044 }
        if (r3 != 0) goto L_0x00bf;
    L_0x009c:
        r3 = r6.e;	 Catch:{ all -> 0x0044 }
        r3 = r3.a(r0);	 Catch:{ all -> 0x0044 }
        if (r3 == 0) goto L_0x00bf;
    L_0x00a4:
        r3 = r6.e(r0);	 Catch:{ all -> 0x0044 }
        if (r3 == 0) goto L_0x00c1;
    L_0x00aa:
        r1 = r6.e;	 Catch:{ all -> 0x0044 }
        r1 = r1.a(r0);	 Catch:{ all -> 0x0044 }
        if (r2 == 0) goto L_0x00b5;
    L_0x00b2:
        r6.d(r1);	 Catch:{ all -> 0x0044 }
    L_0x00b5:
        r6.c(r0);	 Catch:{ all -> 0x0044 }
        r6.b(r1);	 Catch:{ all -> 0x0044 }
        r6.d = r0;	 Catch:{ all -> 0x0044 }
        goto L_0x0008;
    L_0x00bf:
        r0 = r1;
        goto L_0x00a4;
    L_0x00c1:
        r0 = r6.h;	 Catch:{ all -> 0x0044 }
        r3 = r6.f;	 Catch:{ all -> 0x0044 }
        r3 = r0.b(r3);	 Catch:{ all -> 0x0044 }
        r0 = com.f.a.b.a.c.a(r3);	 Catch:{ all -> 0x0044 }
        if (r0 != 0) goto L_0x0101;
    L_0x00cf:
        r0 = r4.a(r3);	 Catch:{ all -> 0x0044 }
        r4 = r6.e(r0);	 Catch:{ all -> 0x0044 }
        if (r4 != 0) goto L_0x00df;
    L_0x00d9:
        r0 = r6.e;	 Catch:{ all -> 0x0044 }
        r0 = r0.b(r3);	 Catch:{ all -> 0x0044 }
    L_0x00df:
        r3 = r6.e(r0);	 Catch:{ all -> 0x0044 }
        if (r3 == 0) goto L_0x0101;
    L_0x00e5:
        r3 = r6.e;	 Catch:{ all -> 0x0044 }
        r3 = r3.a(r0);	 Catch:{ all -> 0x0044 }
        r4 = com.f.a.b.a.c.a(r0);	 Catch:{ all -> 0x0044 }
        if (r4 != 0) goto L_0x0101;
    L_0x00f1:
        r6.d = r0;	 Catch:{ all -> 0x0044 }
        if (r2 == 0) goto L_0x00f8;
    L_0x00f5:
        r6.d(r3);	 Catch:{ all -> 0x0044 }
    L_0x00f8:
        r0 = r6.d;	 Catch:{ all -> 0x0044 }
        r6.a(r0);	 Catch:{ all -> 0x0044 }
        r0 = r6.d;	 Catch:{ all -> 0x0044 }
        goto L_0x0008;
    L_0x0101:
        r0 = r6.b();	 Catch:{ Exception -> 0x012e }
        if (r0 == 0) goto L_0x012f;
    L_0x0107:
        r3 = 2;
        r3 = com.f.a.b.a.g.a(r0, r3);	 Catch:{ Exception -> 0x012e }
        r6.d = r3;	 Catch:{ Exception -> 0x012e }
        r3 = r6.d;	 Catch:{ Exception -> 0x012e }
        r6.a(r3);	 Catch:{ Exception -> 0x012e }
        r3 = r6.e;	 Catch:{ Exception -> 0x012e }
        r4 = 2;
        r0 = com.f.a.b.a.g.a(r0, r4);	 Catch:{ Exception -> 0x012e }
        r3 = r3.a;	 Catch:{ Exception -> 0x012e }
        r0 = com.f.a.b.a.d.a(r3, r0);	 Catch:{ Exception -> 0x012e }
        if (r0 == 0) goto L_0x012a;
    L_0x0122:
        if (r2 == 0) goto L_0x0127;
    L_0x0124:
        r6.d(r0);	 Catch:{ Exception -> 0x012e }
    L_0x0127:
        r6.b(r0);	 Catch:{ Exception -> 0x012e }
    L_0x012a:
        r0 = r6.d;	 Catch:{ Exception -> 0x012e }
        goto L_0x0008;
    L_0x012e:
        r0 = move-exception;
    L_0x012f:
        r0 = r1;
        goto L_0x0008;
    L_0x0132:
        r2 = move-exception;
        goto L_0x0018;
    L_0x0135:
        r0 = r3;
        goto L_0x006c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.f.a.c.c.a():java.lang.String");
    }

    private final byte[] b() throws Exception {
        String a;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nextInt = new Random().nextInt();
        byte[] a2 = e.a(currentTimeMillis);
        byte[] a3 = e.a(nextInt);
        byteArrayOutputStream.write(a2, 0, 4);
        byteArrayOutputStream.write(a3, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            a = b.a(this.a);
        } catch (Exception e) {
            a = new Random().nextInt();
        }
        byteArrayOutputStream.write(e.a(com.f.a.b.a.c.b(a)), 0, 4);
        a2 = byteArrayOutputStream.toByteArray();
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(new SecretKeySpec("d6fc3a4a06adbde89223bvefedc24fecde188aaa9161".getBytes(), instance.getAlgorithm()));
        byteArrayOutputStream.write(e.a(com.f.a.b.a.c.b(g.a(instance.doFinal(a2), 2))));
        return byteArrayOutputStream.toByteArray();
    }
}
