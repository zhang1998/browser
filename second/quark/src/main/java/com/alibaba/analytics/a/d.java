package com.alibaba.analytics.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.alibaba.analytics.b.a;
import com.alibaba.analytics.core.b;
import com.alibaba.analytics.core.c.g;
import com.alibaba.analytics.core.c.i;
import com.alibaba.analytics.core.model.LogField;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.android.spdy.SpdyErrorException;
import org.android.spdy.SpdySession;
import org.android.spdy.TnetStatusCode;

/* compiled from: ProGuard */
public final class d {
    private static ByteArrayOutputStream A = null;
    private static boolean B = true;
    public static final g a = new g();
    public static int b = 0;
    private static final Object c = new Object();
    private static final Object d = new Object();
    private static int e = -1;
    private static int f = 0;
    private static byte g = (byte) 1;
    private static byte h = (byte) 2;
    private static byte i = (byte) 8;
    private static byte j = (byte) 16;
    private static byte k = (byte) 32;
    private static boolean l = true;
    private static boolean m = true;
    private static String n = null;
    private static SpdySession o = null;
    private static ByteArrayOutputStream p = null;
    private static long q = 0;
    private static long r = 0;
    private static byte[] s = null;
    private static int t = 0;
    private static boolean u = false;
    private static Class v = null;
    private static String w = null;
    private static boolean x = false;
    private static final String y = "\u0001";
    private static GZIPOutputStream z = null;

    static /* synthetic */ long b(long j) {
        long j2 = q + j;
        q = j2;
        return j2;
    }

    public static byte[] a(Map<String, String> map) throws Exception {
        byte[] a;
        int i;
        if (b.a().s) {
            a = p.a(b((Map) map));
            int i2 = g;
            i = 1;
        } else {
            byte[] toByteArray;
            byte b;
            synchronized (d) {
                if (o == null) {
                    ak.a();
                    if (VERSION.SDK_INT >= 19) {
                        a(z);
                        z = null;
                        a(A);
                        A = null;
                        A = new ByteArrayOutputStream();
                        z = new GZIPOutputStream(A, true);
                    }
                    B = true;
                } else {
                    B = false;
                }
            }
            if (z != null) {
                z.write(c((Map) map));
                z.flush();
                toByteArray = A.toByteArray();
                A.reset();
                b = h;
            } else {
                toByteArray = p.a(c((Map) map));
                b = g;
            }
            a = toByteArray;
            byte b2 = b;
            i = 2;
        }
        if (a == null) {
            return null;
        }
        if (a.length >= 16777216) {
            if (b.a().t) {
                a.a(i.a(i.k, String.valueOf(a.length), Double.valueOf(1.0d)));
            }
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(i);
        i = a.length;
        byteArrayOutputStream.write(new byte[]{(byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)});
        byteArrayOutputStream.write(1);
        i = (byte) (i | i2);
        if (b.a().h()) {
            i = (byte) (i | j);
        }
        if (l) {
            i = (byte) (i | k);
        }
        byteArrayOutputStream.write(i);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(a);
        byte[] toByteArray2 = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
            return toByteArray2;
        } catch (Throwable e) {
            af.b(null, e, new Object[0]);
            return toByteArray2;
        }
    }

    private static byte[] b(Map<String, String> map) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String j = j();
        if (j == null || j.length() <= 0) {
            byteArrayOutputStream.write(e.a(0));
        } else {
            byteArrayOutputStream.write(e.a(j.length()));
            byteArrayOutputStream.write(j.getBytes());
        }
        if (map != null && map.size() > 0) {
            for (String j2 : map.keySet()) {
                byteArrayOutputStream.write(e.b(Integer.valueOf(j2).intValue()));
                j2 = (String) map.get(j2);
                if (j2 != null) {
                    byteArrayOutputStream.write(e.b(j2.getBytes().length));
                    byteArrayOutputStream.write(j2.getBytes());
                } else {
                    byteArrayOutputStream.write(e.b(0));
                }
            }
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
        }
        return toByteArray;
    }

    private static byte[] c(Map<String, String> map) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(ak.a(j()));
        if (map != null && map.size() > 0) {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            for (String str : map.keySet()) {
                byteArrayOutputStream.write(ak.a(Integer.valueOf(str).intValue()));
                String str2 = (String) map.get(str2);
                if (str2 != null) {
                    for (String str22 : str22.split(y)) {
                        if (!TextUtils.isEmpty(str22)) {
                            String[] a = a(str22);
                            for (int i = 0; i < 34; i++) {
                                byteArrayOutputStream2.write(ak.b(a[i]));
                            }
                            byteArrayOutputStream2.write(0);
                        }
                    }
                    byteArrayOutputStream.write(ak.a(byteArrayOutputStream2.size()));
                    byteArrayOutputStream.write(byteArrayOutputStream2.toByteArray());
                    byteArrayOutputStream2.reset();
                } else {
                    byteArrayOutputStream.write(0);
                }
            }
            try {
                byteArrayOutputStream2.close();
            } catch (IOException e) {
            }
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e2) {
        }
        return toByteArray;
    }

    private static String j() {
        Object obj;
        Object obj2;
        String b;
        StringBuilder stringBuilder;
        String b2 = r.b();
        Context context = b.a().b;
        String d = b.a().d();
        if (d == null) {
            Object obj3 = "";
        } else {
            String str = d;
        }
        d = "";
        Map a = j.a(context);
        if (a != null) {
            d = (String) a.get(LogField.APPVERSION.toString());
            if (d == null) {
                obj = "";
                d = r.a();
                if (d != null) {
                    obj2 = "";
                } else {
                    String str2 = d;
                }
                d = "";
                if (a != null) {
                    d = (String) a.get(LogField.UTDID.toString());
                }
                a.a();
                b = a.b();
                if (b.a().h()) {
                    d = String.format("ak=%s&av=%s&avsys=%s&c=%s&d=%s&sv=%s", new Object[]{b2, obj3, obj, obj2, d, b});
                } else {
                    d = String.format("ak=%s&av=%s&avsys=%s&c=%s&d=%s&sv=%s&dk=%s", new Object[]{b2, obj3, obj, obj2, d, b, b.a().g()});
                }
                if (l || m) {
                    stringBuilder = new StringBuilder(d);
                    if (m) {
                        if (o == null) {
                            w = an.a();
                            x = true;
                            af.a("", "GetWua before createSession:" + w);
                        }
                        if (!TextUtils.isEmpty(w)) {
                            stringBuilder.append("&wua=").append(w);
                        }
                    }
                    if (l) {
                        StringBuilder append = stringBuilder.append("&_ut_sample=");
                        com.alibaba.analytics.core.h.a.a.a();
                        append.append(com.alibaba.analytics.core.h.a.a.a("ut_sample"));
                        append = stringBuilder.append("&_utap_system=");
                        com.alibaba.analytics.core.h.a.a.a();
                        append.append(com.alibaba.analytics.core.h.a.a.a("utap_system"));
                        append = stringBuilder.append("&_ap_stat=");
                        com.alibaba.analytics.core.h.a.a.a();
                        append.append(com.alibaba.analytics.core.h.a.a.a("ap_stat"));
                        append = stringBuilder.append("&_ap_alarm=");
                        com.alibaba.analytics.core.h.a.a.a();
                        append.append(com.alibaba.analytics.core.h.a.a.a("ap_alarm"));
                        append = stringBuilder.append("&_ap_counter=");
                        com.alibaba.analytics.core.h.a.a.a();
                        append.append(com.alibaba.analytics.core.h.a.a.a("ap_counter"));
                        append = stringBuilder.append("&_ut_bussiness=");
                        com.alibaba.analytics.core.h.a.a.a();
                        append.append(com.alibaba.analytics.core.h.a.a.a("ut_bussiness"));
                    }
                    d = stringBuilder.toString();
                }
                af.b("PostData", "send url :" + d);
                return d;
            }
        }
        String str3 = d;
        d = r.a();
        if (d != null) {
            String str22 = d;
        } else {
            obj2 = "";
        }
        d = "";
        if (a != null) {
            d = (String) a.get(LogField.UTDID.toString());
        }
        a.a();
        b = a.b();
        if (b.a().h()) {
            d = String.format("ak=%s&av=%s&avsys=%s&c=%s&d=%s&sv=%s", new Object[]{b2, obj3, obj, obj2, d, b});
        } else {
            d = String.format("ak=%s&av=%s&avsys=%s&c=%s&d=%s&sv=%s&dk=%s", new Object[]{b2, obj3, obj, obj2, d, b, b.a().g()});
        }
        stringBuilder = new StringBuilder(d);
        if (m) {
            if (o == null) {
                w = an.a();
                x = true;
                af.a("", "GetWua before createSession:" + w);
            }
            if (TextUtils.isEmpty(w)) {
                stringBuilder.append("&wua=").append(w);
            }
        }
        if (l) {
            StringBuilder append2 = stringBuilder.append("&_ut_sample=");
            com.alibaba.analytics.core.h.a.a.a();
            append2.append(com.alibaba.analytics.core.h.a.a.a("ut_sample"));
            append2 = stringBuilder.append("&_utap_system=");
            com.alibaba.analytics.core.h.a.a.a();
            append2.append(com.alibaba.analytics.core.h.a.a.a("utap_system"));
            append2 = stringBuilder.append("&_ap_stat=");
            com.alibaba.analytics.core.h.a.a.a();
            append2.append(com.alibaba.analytics.core.h.a.a.a("ap_stat"));
            append2 = stringBuilder.append("&_ap_alarm=");
            com.alibaba.analytics.core.h.a.a.a();
            append2.append(com.alibaba.analytics.core.h.a.a.a("ap_alarm"));
            append2 = stringBuilder.append("&_ap_counter=");
            com.alibaba.analytics.core.h.a.a.a();
            append2.append(com.alibaba.analytics.core.h.a.a.a("ap_counter"));
            append2 = stringBuilder.append("&_ut_bussiness=");
            com.alibaba.analytics.core.h.a.a.a();
            append2.append(com.alibaba.analytics.core.h.a.a.a("ut_bussiness"));
        }
        d = stringBuilder.toString();
        af.b("PostData", "send url :" + d);
        return d;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.alibaba.analytics.a.ag a(byte[] r14) {
        /*
        com.alibaba.analytics.a.af.b();
        r0 = a;
        r1 = com.alibaba.analytics.core.c.i.g;
        r2 = 0;
        r4 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r3 = java.lang.Double.valueOf(r4);
        r1 = com.alibaba.analytics.core.c.i.a(r1, r2, r3);
        r0.a(r1);
        r9 = new com.alibaba.analytics.a.ag;
        r9.<init>();
        r1 = d;
        monitor-enter(r1);
        s = r14;	 Catch:{ all -> 0x022e }
        r0 = 0;
        f = r0;	 Catch:{ all -> 0x022e }
        monitor-exit(r1);	 Catch:{ all -> 0x022e }
        r10 = c;
        monitor-enter(r10);
        r0 = p;	 Catch:{ all -> 0x024e }
        if (r0 == 0) goto L_0x002f;
    L_0x002a:
        r0 = p;	 Catch:{ IOException -> 0x0286 }
        r0.close();	 Catch:{ IOException -> 0x0286 }
    L_0x002f:
        r0 = 0;
        p = r0;	 Catch:{ all -> 0x024e }
        r0 = 0;
        q = r0;	 Catch:{ all -> 0x024e }
        r0 = 0;
        r = r0;	 Catch:{ all -> 0x024e }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x024e }
        r0 = -1;
        e = r0;	 Catch:{ all -> 0x024e }
        r0 = o;	 Catch:{ Exception -> 0x0238 }
        if (r0 != 0) goto L_0x0254;
    L_0x0045:
        r0 = B;	 Catch:{ Exception -> 0x0238 }
        if (r0 != 0) goto L_0x0051;
    L_0x0049:
        r0 = com.alibaba.analytics.core.b.a();	 Catch:{ Exception -> 0x0238 }
        r0 = r0.s;	 Catch:{ Exception -> 0x0238 }
        if (r0 == 0) goto L_0x0254;
    L_0x0051:
        r0 = com.alibaba.analytics.core.b.a();	 Catch:{ Exception -> 0x0238 }
        r0 = r0.t;	 Catch:{ Exception -> 0x0238 }
        if (r0 == 0) goto L_0x006b;
    L_0x0059:
        r0 = a;	 Catch:{ Exception -> 0x0238 }
        r1 = com.alibaba.analytics.core.c.i.h;	 Catch:{ Exception -> 0x0238 }
        r2 = 0;
        r4 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r3 = java.lang.Double.valueOf(r4);	 Catch:{ Exception -> 0x0238 }
        r1 = com.alibaba.analytics.core.c.i.a(r1, r2, r3);	 Catch:{ Exception -> 0x0238 }
        r0.a(r1);	 Catch:{ Exception -> 0x0238 }
    L_0x006b:
        r0 = com.alibaba.analytics.core.b.a();	 Catch:{ Exception -> 0x0238 }
        r0 = r0.b;	 Catch:{ Exception -> 0x0238 }
        r1 = org.android.spdy.SpdyVersion.SPDY3;	 Catch:{ Exception -> 0x0238 }
        r2 = org.android.spdy.SpdySessionKind.NONE_SESSION;	 Catch:{ Exception -> 0x0238 }
        r11 = org.android.spdy.SpdyAgent.getInstance(r0, r1, r2);	 Catch:{ Exception -> 0x0238 }
        r0 = com.alibaba.analytics.core.g.a.a();	 Catch:{ Exception -> 0x0238 }
        r0 = r0.a;	 Catch:{ Exception -> 0x0238 }
        if (r0 == 0) goto L_0x0089;
    L_0x0081:
        r0 = new com.alibaba.analytics.a.h;	 Catch:{ Exception -> 0x0238 }
        r0.<init>();	 Catch:{ Exception -> 0x0238 }
        r11.setAccsSslCallback(r0);	 Catch:{ Exception -> 0x0238 }
    L_0x0089:
        r7 = new com.alibaba.analytics.a.ao;	 Catch:{ Exception -> 0x0238 }
        r0 = 0;
        r7.<init>();	 Catch:{ Exception -> 0x0238 }
        r0 = com.alibaba.analytics.core.a.b.a();	 Catch:{ Exception -> 0x0238 }
        r0 = r0.b;	 Catch:{ Exception -> 0x0238 }
        r1 = r0.a;	 Catch:{ Exception -> 0x0238 }
        r2 = r0.b;	 Catch:{ Exception -> 0x0238 }
        r0 = 0;
        r3 = 4;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0238 }
        r4 = 0;
        r5 = "host";
        r3[r4] = r5;	 Catch:{ Exception -> 0x0238 }
        r4 = 1;
        r3[r4] = r1;	 Catch:{ Exception -> 0x0238 }
        r4 = 2;
        r5 = "port";
        r3[r4] = r5;	 Catch:{ Exception -> 0x0238 }
        r4 = 3;
        r5 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x0238 }
        r3[r4] = r5;	 Catch:{ Exception -> 0x0238 }
        com.alibaba.analytics.a.af.a(r0, r3);	 Catch:{ Exception -> 0x0238 }
        r0 = new org.android.spdy.SessionInfo;	 Catch:{ Exception -> 0x0238 }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r8 = 4240; // 0x1090 float:5.942E-42 double:2.095E-320;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x0238 }
        r1 = com.alibaba.analytics.core.g.a.a();	 Catch:{ Exception -> 0x0238 }
        r1 = r1.a;	 Catch:{ Exception -> 0x0238 }
        if (r1 == 0) goto L_0x0231;
    L_0x00c7:
        r1 = 8;
        r0.setPubKeySeqNum(r1);	 Catch:{ Exception -> 0x0238 }
    L_0x00cc:
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0.setConnectionTimeoutMs(r1);	 Catch:{ Exception -> 0x0238 }
        r1 = d;	 Catch:{ Exception -> 0x0238 }
        monitor-enter(r1);	 Catch:{ Exception -> 0x0238 }
        r0 = r11.createSession(r0);	 Catch:{ all -> 0x0251 }
        o = r0;	 Catch:{ all -> 0x0251 }
        r0 = x;	 Catch:{ all -> 0x0251 }
        if (r0 != 0) goto L_0x0100;
    L_0x00de:
        r0 = com.alibaba.analytics.a.an.a();	 Catch:{ all -> 0x0251 }
        w = r0;	 Catch:{ all -> 0x0251 }
        r0 = "";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0251 }
        r3 = 0;
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0251 }
        r5 = "GetWua by createSession:";
        r4.<init>(r5);	 Catch:{ all -> 0x0251 }
        r5 = w;	 Catch:{ all -> 0x0251 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0251 }
        r4 = r4.toString();	 Catch:{ all -> 0x0251 }
        r2[r3] = r4;	 Catch:{ all -> 0x0251 }
        com.alibaba.analytics.a.af.a(r0, r2);	 Catch:{ all -> 0x0251 }
    L_0x0100:
        r0 = 0;
        x = r0;	 Catch:{ all -> 0x0251 }
        monitor-exit(r1);	 Catch:{ all -> 0x0251 }
        r0 = "";
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x0238 }
        r2 = 0;
        r3 = "createSession";
        r1[r2] = r3;	 Catch:{ Exception -> 0x0238 }
        com.alibaba.analytics.a.af.a(r0, r1);	 Catch:{ Exception -> 0x0238 }
        r0 = c;	 Catch:{ Exception -> 0x0238 }
        r2 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r0.wait(r2);	 Catch:{ Exception -> 0x0238 }
    L_0x0119:
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x024e }
        r0 = r0 - r12;
        r2 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x014e;
    L_0x0125:
        r2 = com.alibaba.analytics.core.b.a();	 Catch:{ all -> 0x024e }
        r2 = r2.t;	 Catch:{ all -> 0x024e }
        if (r2 == 0) goto L_0x013f;
    L_0x012d:
        r2 = a;	 Catch:{ all -> 0x024e }
        r3 = com.alibaba.analytics.core.c.i.i;	 Catch:{ all -> 0x024e }
        r4 = 0;
        r6 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r5 = java.lang.Double.valueOf(r6);	 Catch:{ all -> 0x024e }
        r3 = com.alibaba.analytics.core.c.i.a(r3, r4, r5);	 Catch:{ all -> 0x024e }
        r2.a(r3);	 Catch:{ all -> 0x024e }
    L_0x013f:
        k();	 Catch:{ all -> 0x024e }
        r2 = 0;
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x024e }
        r4 = 0;
        r5 = "WAIT_TIMEOUT";
        r3[r4] = r5;	 Catch:{ all -> 0x024e }
        com.alibaba.analytics.a.af.c(r2, r3);	 Catch:{ all -> 0x024e }
    L_0x014e:
        monitor-exit(r10);	 Catch:{ all -> 0x024e }
        r2 = com.alibaba.analytics.core.b.a();	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        r2 = r2.b;	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        if (r2 == 0) goto L_0x01ca;
    L_0x0157:
        r3 = u;	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        if (r3 != 0) goto L_0x016a;
    L_0x015b:
        r3 = v;	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        if (r3 == 0) goto L_0x016a;
    L_0x015f:
        r3 = "com.taobao.analysis.FlowCenter";
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        v = r3;	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        r3 = 1;
        u = r3;	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
    L_0x016a:
        r3 = v;	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        if (r3 == 0) goto L_0x01ca;
    L_0x016e:
        r3 = v;	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        r4 = "getInstance";
        r3 = com.alibaba.analytics.a.u.a(r3, r4);	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        if (r3 == 0) goto L_0x01ca;
    L_0x0178:
        r4 = "commitFlow";
        r5 = 6;
        r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        r6 = 0;
        r5[r6] = r2;	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        r2 = 1;
        r6 = "ut";
        r5[r2] = r6;	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        r2 = 2;
        r6 = 1;
        r6 = java.lang.Boolean.valueOf(r6);	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        r5[r2] = r6;	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        r2 = 3;
        r6 = "ut";
        r5[r2] = r6;	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        r2 = 4;
        r6 = f;	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        r6 = (long) r6;	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        r5[r2] = r6;	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        r2 = 5;
        r6 = t;	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        r6 = (long) r6;	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        r5[r2] = r6;	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        r2 = 6;
        r2 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        r6 = 0;
        r7 = android.content.Context.class;
        r2[r6] = r7;	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        r6 = 1;
        r7 = java.lang.String.class;
        r2[r6] = r7;	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        r6 = 2;
        r7 = java.lang.Boolean.TYPE;	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        r2[r6] = r7;	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        r6 = 3;
        r7 = java.lang.String.class;
        r2[r6] = r7;	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        r6 = 4;
        r7 = java.lang.Long.TYPE;	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        r2[r6] = r7;	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        r6 = 5;
        r7 = java.lang.Long.TYPE;	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        r2[r6] = r7;	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
        com.alibaba.analytics.a.u.a(r3, r4, r5, r2);	 Catch:{ Throwable -> 0x0278, all -> 0x027e }
    L_0x01ca:
        r2 = 0;
        t = r2;
    L_0x01cd:
        r2 = d;
        monitor-enter(r2);
        r3 = 0;
        s = r3;	 Catch:{ all -> 0x0283 }
        r3 = 0;
        f = r3;	 Catch:{ all -> 0x0283 }
        monitor-exit(r2);	 Catch:{ all -> 0x0283 }
        r2 = e;
        r9.a = r2;
        r9.b = r0;
        r0 = n;
        r9.c = r0;
        r0 = 0;
        n = r0;
        r0 = e;
        b = r0;
        r0 = "PostData";
        r1 = 8;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = "isSuccess";
        r1[r2] = r3;
        r2 = 1;
        r3 = r9.a();
        r3 = java.lang.Boolean.valueOf(r3);
        r1[r2] = r3;
        r2 = 2;
        r3 = "isDenyByServer";
        r1[r2] = r3;
        r2 = 3;
        r3 = r9.b();
        r3 = java.lang.Boolean.valueOf(r3);
        r1[r2] = r3;
        r2 = 4;
        r3 = "errCode";
        r1[r2] = r3;
        r2 = 5;
        r3 = r9.a;
        r3 = java.lang.Integer.valueOf(r3);
        r1[r2] = r3;
        r2 = 6;
        r3 = "rt";
        r1[r2] = r3;
        r2 = 7;
        r4 = r9.b;
        r3 = java.lang.Long.valueOf(r4);
        r1[r2] = r3;
        com.alibaba.analytics.a.af.a(r0, r1);
        return r9;
    L_0x022e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x022e }
        throw r0;
    L_0x0231:
        r1 = 9;
        r0.setPubKeySeqNum(r1);	 Catch:{ Exception -> 0x0238 }
        goto L_0x00cc;
    L_0x0238:
        r0 = move-exception;
        k();	 Catch:{ all -> 0x024e }
        r1 = "";
        r2 = 2;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x024e }
        r3 = 0;
        r4 = "CreateSession Exception";
        r2[r3] = r4;	 Catch:{ all -> 0x024e }
        r3 = 1;
        r2[r3] = r0;	 Catch:{ all -> 0x024e }
        com.alibaba.analytics.a.af.d(r1, r2);	 Catch:{ all -> 0x024e }
        goto L_0x0119;
    L_0x024e:
        r0 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x024e }
        throw r0;
    L_0x0251:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0251 }
        throw r0;	 Catch:{ Exception -> 0x0238 }
    L_0x0254:
        r0 = o;	 Catch:{ Exception -> 0x0238 }
        if (r0 == 0) goto L_0x0273;
    L_0x0258:
        r0 = B;	 Catch:{ Exception -> 0x0238 }
        if (r0 == 0) goto L_0x0264;
    L_0x025c:
        r0 = com.alibaba.analytics.core.b.a();	 Catch:{ Exception -> 0x0238 }
        r0 = r0.s;	 Catch:{ Exception -> 0x0238 }
        if (r0 == 0) goto L_0x0273;
    L_0x0264:
        r0 = o;	 Catch:{ Exception -> 0x0238 }
        b(r0);	 Catch:{ Exception -> 0x0238 }
        r0 = c;	 Catch:{ Exception -> 0x0238 }
        r2 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r0.wait(r2);	 Catch:{ Exception -> 0x0238 }
        goto L_0x0119;
    L_0x0273:
        k();	 Catch:{ Exception -> 0x0238 }
        goto L_0x0119;
    L_0x0278:
        r2 = move-exception;
        r2 = 0;
        t = r2;
        goto L_0x01cd;
    L_0x027e:
        r0 = move-exception;
        r1 = 0;
        t = r1;
        throw r0;
    L_0x0283:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0283 }
        throw r0;
    L_0x0286:
        r0 = move-exception;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.analytics.a.d.a(byte[]):com.alibaba.analytics.a.ag");
    }

    private static void b(SpdySession spdySession) {
        synchronized (d) {
            while (spdySession == o && o != null && s != null && s.length > f) {
                try {
                    if (s.length - f > 131072) {
                        spdySession.sendCustomControlFrame(-1, -1, -1, 131072, e.b(s, f, 131072));
                        f += 131072;
                    } else {
                        int length = s.length - f;
                        if (length > 0) {
                            spdySession.sendCustomControlFrame(-1, -1, -1, length, e.b(s, f, length));
                            f += length;
                        }
                    }
                } catch (SpdyErrorException e) {
                    af.d("", "SpdyErrorException", e);
                    if (e.SpdyErrorGetCode() != TnetStatusCode.EASY_EAGAIN) {
                        e = e.SpdyErrorGetCode();
                        k();
                    }
                    return;
                }
            }
        }
    }

    private static void k() {
        af.b();
        synchronized (d) {
            if (o != null) {
                o.closeSession();
            }
            o = null;
            a(z);
            z = null;
            a(A);
            A = null;
            ak.a();
        }
        l();
    }

    private static void l() {
        synchronized (c) {
            c.notifyAll();
        }
    }

    private static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
            }
        }
    }

    private static String[] a(String str) {
        int i = 0;
        String[] strArr = new String[34];
        int i2 = 0;
        while (i < 33) {
            int indexOf = str.indexOf("||", i2);
            if (indexOf == -1) {
                strArr[i] = str.substring(i2);
                break;
            }
            strArr[i] = str.substring(i2, indexOf);
            i2 = indexOf + 2;
            i++;
        }
        strArr[33] = str.substring(i2);
        return strArr;
    }

    static /* synthetic */ long b(byte[] bArr) {
        if (bArr == null || bArr.length < 12) {
            return -1;
        }
        return (long) e.a(bArr, 1, 3);
    }

    static /* synthetic */ int c(byte[] bArr) {
        int i = -1;
        if (bArr == null || bArr.length < 12) {
            af.d("TnetUtil", "recv errCode UNKNOWN_ERROR");
        } else {
            t = bArr.length;
            if (e.a(bArr, 1, 3) + 8 != bArr.length) {
                af.d("TnetUtil", "recv len error");
            } else {
                boolean z;
                if (g == (bArr[5] & g)) {
                    z = true;
                } else {
                    z = false;
                }
                int a = e.a(bArr, 8, 4);
                int length = bArr.length + -12 >= 0 ? bArr.length - 12 : 0;
                if (length <= 0) {
                    n = null;
                    i = a;
                } else if (z) {
                    Object obj = new byte[length];
                    System.arraycopy(bArr, 12, obj, 0, length);
                    byte[] b = p.b(obj);
                    n = new String(b, 0, b.length);
                    i = a;
                } else {
                    n = new String(bArr, 12, length);
                    i = a;
                }
            }
        }
        if (109 == i) {
            b.a().s = true;
        }
        return i;
    }

    static /* synthetic */ int d(byte[] bArr) {
        if (bArr == null || com.alibaba.analytics.core.g.a.a().b("accs_ssl_key2_adashx.m.taobao.com", bArr) == 0) {
            return -1;
        }
        return 0;
    }
}
