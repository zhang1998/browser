package com.alibaba.analytics.core.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.UCMobile.Apollo.Global;
import com.alibaba.analytics.a.aa;
import com.alibaba.analytics.a.ad;
import com.alibaba.analytics.a.af;
import com.alibaba.analytics.a.ag;
import com.alibaba.analytics.a.am;
import com.alibaba.analytics.a.d;
import com.alibaba.analytics.a.o;
import com.alibaba.analytics.core.b;
import com.alibaba.analytics.core.c.g;
import com.alibaba.analytics.core.d.e;
import com.alibaba.analytics.core.f.f;
import com.alibaba.analytics.core.h.i;
import com.alibaba.fastjson.a;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: ProGuard */
public abstract class h implements Runnable {
    public static final g b = new g();
    public static String c = "";
    private static volatile boolean e = false;
    private static boolean f = false;
    private static int h = 0;
    private static boolean l = false;
    private static int m = 0;
    private static int n = 0;
    private static boolean q = false;
    private static Class r = null;
    private int a;
    c d;
    private int g;
    private float i;
    private int j;
    private long k;
    private int o;
    private int p;

    public abstract void a(long j);

    public static boolean a() {
        return l;
    }

    public h(c cVar) {
        this.a = 3;
        this.g = -1;
        this.i = 200.0f;
        this.j = 0;
        this.k = 0;
        this.o = 5242880;
        this.p = 0;
        this.d = c.ALL;
        this.a = 3;
        this.d = cVar;
    }

    public void run() {
        try {
            if (b.a().c()) {
                a(false);
            } else {
                a(true);
            }
        } catch (Throwable th) {
        }
        try {
            a(this.k);
        } catch (Throwable th2) {
        }
    }

    private void a(boolean z) {
        af.b();
        if (!e.a(b.a().b) || f) {
            return;
        }
        if (c.ALL != this.d && this.d != b()) {
            af.c("network not match,return", "current networkstatus", b(), "mAllowedNetworkStatus", this.d);
            return;
        } else if (!e) {
            e = true;
            try {
                this.k = 0;
                int i = 0;
                loop0:
                while (i < this.a) {
                    if (!o.a(b.a().b)) {
                        af.a("Upload", "Other Process is Uploading, break");
                        break loop0;
                    }
                    f a = f.a();
                    if (this.g == -1) {
                        String a2 = e.a();
                        if ("Wi-Fi".equalsIgnoreCase(a2)) {
                            this.g = 20;
                        } else if ("4G".equalsIgnoreCase(a2)) {
                            this.g = 16;
                        } else if ("3G".equalsIgnoreCase(a2)) {
                            this.g = 12;
                        } else {
                            this.g = 8;
                        }
                    }
                    List a3 = a.a.a(this.g);
                    af.a("LogStoreMgr", "[get]", a3);
                    if (a3 != null && a3.size() != 0) {
                        if (z) {
                            try {
                                if (b(a3)) {
                                }
                                o.a();
                            } catch (Throwable th) {
                                af.d(null, th.toString());
                                i++;
                            } finally {
                                o.a();
                            }
                            i++;
                        } else {
                            if (a(a3)) {
                                o.a();
                                break loop0;
                            }
                            o.a();
                            i++;
                        }
                        break;
                    }
                    e = false;
                    break loop0;
                }
                e = false;
                o.a();
                return;
            } catch (Throwable th2) {
            }
        } else {
            return;
        }
        e = false;
        o.a();
    }

    private static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            af.c(null, "Config Is Empty");
            return;
        }
        try {
            i iVar = b.a().o;
            if (iVar != null) {
                JSONObject jSONObject = new JSONObject(str).getJSONObject("config");
                if (jSONObject != null) {
                    Iterator keys = jSONObject.keys();
                    if (keys == null || !keys.hasNext()) {
                        af.b(null, "No Config Update");
                        return;
                    }
                    while (keys.hasNext()) {
                        String str2 = (String) keys.next();
                        if (!TextUtils.isEmpty(str2)) {
                            Map hashMap = new HashMap();
                            JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
                            if (jSONObject2 != null) {
                                Iterator keys2 = jSONObject2.keys();
                                if (keys2 != null) {
                                    while (keys2.hasNext()) {
                                        Object obj;
                                        String str3 = (String) keys2.next();
                                        if (jSONObject2.get(str3) == null) {
                                            obj = null;
                                        } else {
                                            obj = jSONObject2.get(str3);
                                        }
                                        hashMap.put(str3, obj);
                                    }
                                }
                            }
                            af.a("Config Update", "namespace", str2, "configs", hashMap);
                            iVar.a(str2, hashMap);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            af.b("Upload", th, new Object[0]);
        }
    }

    private static c b() {
        String a = e.a();
        if ("2G".equalsIgnoreCase(a)) {
            return c.TWO_GENERATION;
        }
        if ("3G".equalsIgnoreCase(a)) {
            return c.THRID_GENERATION;
        }
        if ("4G".equalsIgnoreCase(a)) {
            return c.FOUR_GENERATION;
        }
        if ("Wi-Fi".equalsIgnoreCase(a)) {
            return c.WIFI;
        }
        return c.NONE;
    }

    private static am a(String str, Map<String, Object> map) {
        am amVar = am.d;
        if (str != null) {
            ad a = com.alibaba.analytics.a.f.a(2, str, map);
            byte[] bArr = a.b;
            af.a("Upload", "url", str);
            if (bArr != null) {
                String str2;
                try {
                    str2 = new String(bArr, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    str2 = null;
                }
                if (str2 != null) {
                    af.a("Upload", "result", str2);
                    amVar = aa.a(str2);
                    amVar.f = (double) a.c;
                    if (!TextUtils.isEmpty(amVar.b)) {
                        amVar.e = amVar.b;
                    }
                    amVar.c = str2.length();
                }
            } else {
                amVar.f = (double) a.c;
                amVar.e = "timeout";
            }
        }
        c = amVar.e;
        return amVar;
    }

    private int a(Boolean bool, long j) {
        if (j < 0) {
            return this.g;
        }
        float f = ((float) this.j) / ((float) j);
        if (!bool.booleanValue()) {
            this.g /= 2;
            h++;
        } else if (j > 45000) {
            return this.g;
        } else {
            this.g = (int) ((((double) (f * 45000.0f)) / ((double) this.i)) - ((double) h));
        }
        if (this.g <= 0) {
            this.g = 1;
            h = 0;
        } else if (this.g > 350) {
            this.g = 350;
        }
        af.a("Upload", "winsize", Integer.valueOf(this.g));
        return this.g;
    }

    private static List<com.alibaba.analytics.core.model.b> a(List<com.alibaba.analytics.core.model.b> list, com.alibaba.analytics.core.model.b bVar) {
        if (list == null) {
            list = new ArrayList();
        }
        list.add(bVar);
        return list;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.util.List<com.alibaba.analytics.core.model.b> r12) throws java.lang.Exception {
        /*
        r11 = this;
        if (r12 == 0) goto L_0x0008;
    L_0x0002:
        r0 = r12.size();
        if (r0 != 0) goto L_0x0016;
    L_0x0008:
        r0 = 0;
    L_0x0009:
        if (r0 == 0) goto L_0x0011;
    L_0x000b:
        r1 = r0.size();
        if (r1 != 0) goto L_0x0119;
    L_0x0011:
        r0 = 0;
        e = r0;
        r0 = 1;
    L_0x0015:
        return r0;
    L_0x0016:
        r6 = new java.util.HashMap;
        r6.<init>();
        r1 = 0;
        r2 = 0;
        r0 = 0;
        r5 = r0;
    L_0x001f:
        r0 = r12.size();
        if (r5 >= r0) goto L_0x00b6;
    L_0x0025:
        r0 = r11.o;
        if (r2 <= r0) goto L_0x003c;
    L_0x0029:
        if (r1 != 0) goto L_0x02eb;
    L_0x002b:
        r0 = new java.util.ArrayList;
        r0.<init>();
    L_0x0030:
        r1 = r12.get(r5);
        r0.add(r1);
    L_0x0037:
        r1 = r5 + 1;
        r5 = r1;
        r1 = r0;
        goto L_0x001f;
    L_0x003c:
        r0 = r12.get(r5);
        r0 = (com.alibaba.analytics.core.model.b) r0;
        r0 = r0.a();
        r0 = com.alibaba.analytics.core.b.b.a(r0);
        r3 = com.alibaba.analytics.core.h.p.a();
        r0 = r3.a(r0);
        r7 = new java.util.ArrayList;
        r3 = 1;
        r7.<init>(r3);
        r3 = android.text.TextUtils.isEmpty(r0);
        if (r3 != 0) goto L_0x0061;
    L_0x005e:
        r7.add(r0);
    L_0x0061:
        r0 = "delay";
        r0 = r7.contains(r0);
        if (r0 == 0) goto L_0x0077;
    L_0x0069:
        if (r1 != 0) goto L_0x0070;
    L_0x006b:
        r1 = new java.util.ArrayList;
        r1.<init>();
    L_0x0070:
        r0 = r12.get(r5);
        r1.add(r0);
    L_0x0077:
        r0 = 0;
        r3 = r2;
        r2 = r0;
    L_0x007a:
        r0 = r7.size();
        if (r2 >= r0) goto L_0x02ee;
    L_0x0080:
        r0 = r7.get(r2);
        r0 = r6.get(r0);
        r0 = (java.lang.StringBuilder) r0;
        if (r0 != 0) goto L_0x00af;
    L_0x008c:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r4 = r7.get(r2);
        r6.put(r4, r0);
        r4 = r0;
    L_0x0099:
        r0 = r12.get(r5);
        r0 = (com.alibaba.analytics.core.model.b) r0;
        r0 = r0.a();
        r4.append(r0);
        r0 = r0.length();
        r3 = r3 + r0;
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x007a;
    L_0x00af:
        r4 = "\n";
        r0.append(r4);
        r4 = r0;
        goto L_0x0099;
    L_0x00b6:
        if (r1 == 0) goto L_0x00bb;
    L_0x00b8:
        r12.removeAll(r1);
    L_0x00bb:
        r2 = new java.util.HashMap;
        r2.<init>();
        r0 = 0;
        r11.j = r0;
        r0 = r6.keySet();
        r3 = r0.iterator();
    L_0x00cb:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x00ef;
    L_0x00d1:
        r0 = r3.next();
        r0 = (java.lang.String) r0;
        r1 = r6.get(r0);
        r1 = (java.lang.StringBuilder) r1;
        r1 = r1.toString();
        r1 = com.alibaba.analytics.a.p.a(r1);
        r2.put(r0, r1);
        r0 = r11.j;
        r1 = r1.length;
        r0 = r0 + r1;
        r11.j = r0;
        goto L_0x00cb;
    L_0x00ef:
        r0 = r12.size();
        if (r0 <= 0) goto L_0x0100;
    L_0x00f5:
        r0 = r11.j;
        r0 = (float) r0;
        r1 = r12.size();
        r1 = (float) r1;
        r0 = r0 / r1;
        r11.i = r0;
    L_0x0100:
        r0 = "Upload";
        r1 = 2;
        r1 = new java.lang.Object[r1];
        r3 = 0;
        r4 = "averagePackageSize";
        r1[r3] = r4;
        r3 = 1;
        r4 = r11.i;
        r4 = java.lang.Float.valueOf(r4);
        r1[r3] = r4;
        com.alibaba.analytics.a.af.a(r0, r1);
        r0 = r2;
        goto L_0x0009;
    L_0x0119:
        r2 = android.os.SystemClock.elapsedRealtime();
        r1 = com.alibaba.analytics.core.b.a();
        r1 = r1.k();
        r1 = com.alibaba.analytics.a.m.a(r1, r0);
        r4 = "Upload";
        r5 = 2;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = "lTransferUrl";
        r5[r6] = r7;
        r6 = 1;
        r5[r6] = r1;
        com.alibaba.analytics.a.af.a(r4, r5);
        r1 = a(r1, r0);
        r4 = r1.a;
        r0 = r1.c;
        r11.p = r0;
        r6 = android.os.SystemClock.elapsedRealtime();
        r2 = r6 - r2;
        r0 = java.lang.Boolean.valueOf(r4);
        r11.a(r0, r2);
        if (r4 == 0) goto L_0x024e;
    L_0x0152:
        r0 = 1;
        l = r0;
        r0 = 0;
        m = r0;
        r0 = com.alibaba.analytics.core.f.f.a();
        r0 = r0.a(r12);
        r8 = r11.k;
        r0 = (long) r0;
        r0 = r0 + r8;
        r11.k = r0;
        r0 = b;
        r1 = com.alibaba.analytics.core.c.i.d;
        r5 = 0;
        r8 = r11.j;
        r8 = (double) r8;
        r8 = java.lang.Double.valueOf(r8);
        r1 = com.alibaba.analytics.core.c.i.a(r1, r5, r8);
        r0.a(r1);
    L_0x0179:
        r0 = android.os.SystemClock.elapsedRealtime();
        r5 = "UploadTask";
        r8 = 8;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = "isSendSuccess";
        r8[r9] = r10;
        r9 = 1;
        r4 = java.lang.Boolean.valueOf(r4);
        r8[r9] = r4;
        r4 = 2;
        r9 = "upload log count";
        r8[r4] = r9;
        r4 = 3;
        r9 = r12.size();
        r9 = java.lang.Integer.valueOf(r9);
        r8[r4] = r9;
        r4 = 4;
        r9 = "upload consume";
        r8[r4] = r9;
        r4 = 5;
        r2 = java.lang.Long.valueOf(r2);
        r8[r4] = r2;
        r2 = 6;
        r3 = "delete consume";
        r8[r2] = r3;
        r2 = 7;
        r0 = r0 - r6;
        r0 = java.lang.Long.valueOf(r0);
        r8[r2] = r0;
        com.alibaba.analytics.a.af.b(r5, r8);
        r0 = new java.util.Random;	 Catch:{ Throwable -> 0x02c8 }
        r0.<init>();	 Catch:{ Throwable -> 0x02c8 }
        r1 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r0 = r0.nextInt(r1);	 Catch:{ Throwable -> 0x02c8 }
        r0 = (long) r0;	 Catch:{ Throwable -> 0x02c8 }
        java.lang.Thread.sleep(r0);	 Catch:{ Throwable -> 0x02c8 }
    L_0x01ca:
        r0 = com.alibaba.analytics.core.b.a();	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r0 = r0.b;	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        if (r0 == 0) goto L_0x0245;
    L_0x01d2:
        r1 = q;	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        if (r1 != 0) goto L_0x01e5;
    L_0x01d6:
        r1 = r;	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        if (r1 == 0) goto L_0x01e5;
    L_0x01da:
        r1 = "com.taobao.analysis.FlowCenter";
        r1 = java.lang.Class.forName(r1);	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r = r1;	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r1 = 1;
        q = r1;	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
    L_0x01e5:
        r1 = r;	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        if (r1 == 0) goto L_0x0245;
    L_0x01e9:
        r1 = r;	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r2 = "getInstance";
        r1 = com.alibaba.analytics.a.u.a(r1, r2);	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        if (r1 == 0) goto L_0x0245;
    L_0x01f3:
        r2 = "commitFlow";
        r3 = 6;
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r4 = 0;
        r3[r4] = r0;	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r0 = 1;
        r4 = "ut";
        r3[r0] = r4;	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r0 = 2;
        r4 = 1;
        r4 = java.lang.Boolean.valueOf(r4);	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r3[r0] = r4;	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r0 = 3;
        r4 = "ut";
        r3[r0] = r4;	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r0 = 4;
        r4 = r11.j;	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r4 = (long) r4;	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r3[r0] = r4;	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r0 = 5;
        r4 = r11.p;	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r4 = (long) r4;	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r3[r0] = r4;	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r0 = 6;
        r0 = new java.lang.Class[r0];	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r4 = 0;
        r5 = android.content.Context.class;
        r0[r4] = r5;	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r4 = 1;
        r5 = java.lang.String.class;
        r0[r4] = r5;	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r4 = 2;
        r5 = java.lang.Boolean.TYPE;	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r0[r4] = r5;	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r4 = 3;
        r5 = java.lang.String.class;
        r0[r4] = r5;	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r4 = 4;
        r5 = java.lang.Long.TYPE;	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r0[r4] = r5;	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r4 = 5;
        r5 = java.lang.Long.TYPE;	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        r0[r4] = r5;	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
        com.alibaba.analytics.a.u.a(r1, r2, r3, r0);	 Catch:{ Throwable -> 0x02da, all -> 0x02e3 }
    L_0x0245:
        r0 = 0;
        r11.p = r0;
        r0 = 0;
        r11.j = r0;
    L_0x024b:
        r0 = 0;
        goto L_0x0015;
    L_0x024e:
        r0 = m;
        r0 = r0 + 1;
        m = r0;
        r0 = "E0102";
        r5 = r1.b;
        r0 = r0.equalsIgnoreCase(r5);
        if (r0 == 0) goto L_0x0264;
    L_0x025e:
        r0 = 1;
    L_0x025f:
        if (r0 == 0) goto L_0x0266;
    L_0x0261:
        r0 = 1;
        goto L_0x0015;
    L_0x0264:
        r0 = 0;
        goto L_0x025f;
    L_0x0266:
        r0 = "E0111";
        r5 = r1.b;
        r0 = r0.equalsIgnoreCase(r5);
        if (r0 != 0) goto L_0x027a;
    L_0x0270:
        r0 = "E0112";
        r5 = r1.b;
        r0 = r0.equalsIgnoreCase(r5);
        if (r0 == 0) goto L_0x0283;
    L_0x027a:
        r0 = 1;
    L_0x027b:
        if (r0 == 0) goto L_0x0285;
    L_0x027d:
        r0 = 1;
        f = r0;
        r0 = 1;
        goto L_0x0015;
    L_0x0283:
        r0 = 0;
        goto L_0x027b;
    L_0x0285:
        r0 = l;
        if (r0 == 0) goto L_0x0179;
    L_0x0289:
        r0 = m;
        r5 = 10;
        if (r0 > r5) goto L_0x0179;
    L_0x028f:
        r0 = new java.util.HashMap;
        r0.<init>();
        r5 = "rt";
        r8 = r1.f;
        r8 = java.lang.Double.valueOf(r8);
        r0.put(r5, r8);
        r5 = "pSize";
        r8 = r11.j;
        r8 = java.lang.Integer.valueOf(r8);
        r0.put(r5, r8);
        r5 = "errCode";
        r1 = r1.e;
        r0.put(r5, r1);
        r1 = b;
        r5 = com.alibaba.analytics.core.c.i.c;
        r0 = com.alibaba.fastjson.a.a(r0);
        r8 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r8 = java.lang.Double.valueOf(r8);
        r0 = com.alibaba.analytics.core.c.i.a(r5, r0, r8);
        r1.a(r0);
        goto L_0x0179;
    L_0x02c8:
        r0 = move-exception;
        r1 = 0;
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = "thread sleep interrupted";
        r2[r3] = r4;
        r3 = 1;
        r2[r3] = r0;
        com.alibaba.analytics.a.af.c(r1, r2);
        goto L_0x01ca;
    L_0x02da:
        r0 = move-exception;
        r0 = 0;
        r11.p = r0;
        r0 = 0;
        r11.j = r0;
        goto L_0x024b;
    L_0x02e3:
        r0 = move-exception;
        r1 = 0;
        r11.p = r1;
        r1 = 0;
        r11.j = r1;
        throw r0;
    L_0x02eb:
        r0 = r1;
        goto L_0x0030;
    L_0x02ee:
        r2 = r3;
        r0 = r1;
        goto L_0x0037;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.analytics.core.a.h.a(java.util.List):boolean");
    }

    private boolean b(List<com.alibaba.analytics.core.model.b> list) throws Exception {
        if (list == null || list.size() == 0) {
            Map map = null;
        } else {
            int i;
            String a;
            int i2 = 0;
            HashMap hashMap = new HashMap();
            List list2 = null;
            List list3 = null;
            int i3 = 0;
            while (i3 < list.size()) {
                List list4;
                com.alibaba.analytics.core.model.b bVar = (com.alibaba.analytics.core.model.b) list.get(i3);
                List a2;
                if (i2 > this.o) {
                    a2 = a(list2, bVar);
                    af.a("log delay to upload because totalUploadSize Exceed", "log", bVar, "totalUploadSize", Integer.valueOf(i2));
                    list4 = a2;
                    i = i2;
                } else if (com.alibaba.analytics.core.h.e.a().a(com.alibaba.analytics.core.b.b.a(bVar.a()))) {
                    ArrayList arrayList;
                    list2 = a(list2, bVar);
                    if (((com.alibaba.analytics.core.model.b) list.get(i3)).b.compareToIgnoreCase("3") >= 0) {
                        if (list3 == null) {
                            arrayList = new ArrayList();
                        } else {
                            a2 = list3;
                        }
                        arrayList.add(list.get(i3));
                    } else {
                        a2 = list3;
                    }
                    af.a("log delay to upload because delay config", "log", bVar);
                    Object obj = arrayList;
                    list4 = list2;
                    i = i2;
                } else {
                    StringBuilder stringBuilder = (StringBuilder) hashMap.get(bVar.a);
                    if (stringBuilder == null) {
                        stringBuilder = new StringBuilder();
                        hashMap.put(bVar.a, stringBuilder);
                    } else {
                        stringBuilder.append('\u0001');
                        i2++;
                    }
                    a = ((com.alibaba.analytics.core.model.b) list.get(i3)).a();
                    stringBuilder.append(a);
                    i = a.length() + i2;
                    list4 = list2;
                }
                i3++;
                i2 = i;
                list2 = list4;
            }
            if (list2 != null) {
                list.removeAll(list2);
            }
            if (list3 != null) {
                for (i = 0; i < list3.size(); i++) {
                    ((com.alibaba.analytics.core.model.b) list3.get(i)).b = Global.APOLLO_SERIES;
                }
                f a3 = f.a();
                af.a("LogStoreMgr", list3);
                a3.a.c(list3);
            }
            HashMap hashMap2 = new HashMap();
            this.j = i2;
            for (String a4 : hashMap.keySet()) {
                hashMap2.put(a4, ((StringBuilder) hashMap.get(a4)).toString());
            }
            if (list.size() > 0) {
                this.i = ((float) this.j) / ((float) list.size());
            }
            af.a("Upload", "averagePackageSize", Float.valueOf(this.i), "mUploadByteSize", Integer.valueOf(this.j), "count", Integer.valueOf(list.size()));
            Object obj2 = hashMap2;
        }
        if (map == null || map.size() == 0) {
            e = false;
            return true;
        }
        byte[] bArr = null;
        try {
            bArr = d.a(map);
        } catch (Exception e) {
            af.d(null, e.toString());
        }
        if (bArr == null) {
            this.g /= 2;
            if (this.g <= 0) {
                this.g = 1;
                h = 0;
            } else if (this.g > 350) {
                this.g = 350;
            }
            af.a("Upload", null, "winsize", Integer.valueOf(this.g));
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ag a5 = d.a(bArr);
        boolean a6 = a5.a();
        a(Boolean.valueOf(a6), SystemClock.elapsedRealtime() - elapsedRealtime);
        if (a6) {
            b.a().t = true;
            l = true;
            n = 0;
            this.k = ((long) f.a().a((List) list)) + this.k;
            b.a(com.alibaba.analytics.core.c.i.a(com.alibaba.analytics.core.c.i.d, null, Double.valueOf((double) this.j)));
            try {
                a(a5.c);
            } catch (Exception e2) {
            }
        } else {
            n++;
            if (a5.b() || n > 10) {
                b.a().b();
                return true;
            } else if (b.a().t) {
                if (!l || n > 10) {
                    b.a().t = false;
                } else {
                    Object hashMap3 = new HashMap();
                    hashMap3.put("rt", String.valueOf(a5.b));
                    hashMap3.put("pSize", String.valueOf(this.j));
                    hashMap3.put("errCode", String.valueOf(a5.a));
                    b.a(com.alibaba.analytics.core.c.i.a(com.alibaba.analytics.core.c.i.c, a.a(hashMap3), Double.valueOf(1.0d)));
                }
            }
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        af.b("UploadTask", "isSendSuccess", Boolean.valueOf(a6), "upload log count", Integer.valueOf(list.size()), "upload consume", Long.valueOf(r4 - elapsedRealtime), "delete consume", Long.valueOf(elapsedRealtime2 - r4));
        try {
            Thread.sleep((long) new Random().nextInt(5000));
        } catch (Throwable th) {
            af.c(null, "thread sleep interrupted", th);
        }
        return false;
    }
}
