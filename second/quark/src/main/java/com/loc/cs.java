package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/* compiled from: ProGuard */
public final class cs {
    private static cs a = null;
    private Hashtable<String, ArrayList<cr>> b = new Hashtable();
    private long c = 0;
    private boolean d = false;

    private cs() {
    }

    private synchronized cr a(StringBuilder stringBuilder, String str) {
        cr crVar;
        if (this.b.isEmpty() || TextUtils.isEmpty(stringBuilder)) {
            crVar = null;
        } else if (this.b.containsKey(str)) {
            Hashtable hashtable = new Hashtable();
            Hashtable hashtable2 = new Hashtable();
            Hashtable hashtable3 = new Hashtable();
            ArrayList arrayList = (ArrayList) this.b.get(str);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                cr crVar2 = (cr) arrayList.get(size);
                if (!TextUtils.isEmpty(crVar2.b)) {
                    boolean z;
                    String str2;
                    Object obj = null;
                    String str3 = crVar2.b;
                    if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(stringBuilder)) {
                        z = false;
                    } else {
                        if (str3.contains(",access")) {
                            if (stringBuilder.indexOf(",access") != -1) {
                                String[] split = str3.split(",access");
                                Object substring = split[0].contains("#") ? split[0].substring(split[0].lastIndexOf("#") + 1) : split[0];
                                z = TextUtils.isEmpty(substring) ? false : stringBuilder.toString().contains(substring + ",access");
                            }
                        }
                        z = false;
                    }
                    if (z) {
                        obj = 1;
                        if (a(crVar2.b, stringBuilder)) {
                            crVar = crVar2;
                            break;
                        }
                    }
                    Object obj2 = obj;
                    a(crVar2.b, hashtable);
                    a(stringBuilder.toString(), hashtable2);
                    hashtable3.clear();
                    for (String str22 : hashtable.keySet()) {
                        hashtable3.put(str22, "");
                    }
                    for (String str222 : hashtable2.keySet()) {
                        hashtable3.put(str222, "");
                    }
                    Set keySet = hashtable3.keySet();
                    double[] dArr = new double[keySet.size()];
                    double[] dArr2 = new double[keySet.size()];
                    Iterator it = keySet.iterator();
                    int i = 0;
                    while (it != null && it.hasNext()) {
                        str222 = (String) it.next();
                        dArr[i] = hashtable.containsKey(str222) ? 1.0d : 0.0d;
                        dArr2[i] = hashtable2.containsKey(str222) ? 1.0d : 0.0d;
                        i++;
                    }
                    keySet.clear();
                    double[] a = a(dArr, dArr2);
                    if (a[0] < 0.800000011920929d) {
                        if (a[1] < 0.618d) {
                            if (obj2 != null && a[0] >= 0.618d) {
                                crVar = crVar2;
                                break;
                            }
                        }
                        crVar = crVar2;
                        break;
                    }
                    crVar = crVar2;
                    break;
                }
            }
            crVar = null;
            hashtable.clear();
            hashtable2.clear();
            hashtable3.clear();
        } else {
            crVar = null;
        }
        return crVar;
    }

    public static synchronized cs a() {
        cs csVar;
        synchronized (cs.class) {
            if (a == null) {
                a = new cs();
            }
            csVar = a;
        }
        return csVar;
    }

    private static void a(String str, Hashtable<String, String> hashtable) {
        if (!TextUtils.isEmpty(str)) {
            hashtable.clear();
            for (Object obj : str.split("#")) {
                if (!(TextUtils.isEmpty(obj) || obj.contains("|"))) {
                    hashtable.put(obj, "");
                }
            }
        }
    }

    public static boolean a(String str, StringBuilder stringBuilder) {
        String[] split = str.split("#");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < split.length) {
            if (split[i].contains(",nb") || split[i].contains(",access")) {
                arrayList.add(split[i]);
            }
            i++;
        }
        String[] split2 = stringBuilder.toString().split("#");
        i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < split2.length) {
            if (split2[i2].contains(",nb") || split2[i2].contains(",access")) {
                i3++;
                if (arrayList.contains(split2[i2])) {
                    i++;
                }
            }
            i2++;
        }
        return ((double) (i * 2)) >= ((double) (arrayList.size() + i3)) * 0.618d;
    }

    private static double[] a(double[] dArr, double[] dArr2) {
        int i;
        double[] dArr3 = new double[3];
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        int i2 = 0;
        int i3 = 0;
        for (i = 0; i < dArr.length; i++) {
            d2 += dArr[i] * dArr[i];
            d3 += dArr2[i] * dArr2[i];
            d += dArr[i] * dArr2[i];
            if (dArr2[i] == 1.0d) {
                i2++;
                if (dArr[i] == 1.0d) {
                    i3++;
                }
            }
        }
        dArr3[0] = d / (Math.sqrt(d3) * Math.sqrt(d2));
        dArr3[1] = (1.0d * ((double) i3)) / ((double) i2);
        dArr3[2] = (double) i3;
        for (i = 0; i < 2; i++) {
            if (dArr3[i] > 1.0d) {
                dArr3[i] = 1.0d;
            }
        }
        return dArr3;
    }

    private boolean b() {
        return this.c == 0 ? false : this.b.size() > 360 ? true : dm.b() - this.c > 36000000;
    }

    private void c() {
        this.c = 0;
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
        this.d = false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.autonavi.aps.amapapi.model.AmapLoc a(java.lang.String r5, java.lang.StringBuilder r6, boolean r7) {
        /*
        r4 = this;
        r1 = 0;
        monitor-enter(r4);
        r0 = "gps";
        r0 = r5.contains(r0);	 Catch:{ all -> 0x0091 }
        if (r0 != 0) goto L_0x0012;
    L_0x000a:
        if (r7 == 0) goto L_0x0012;
    L_0x000c:
        r0 = com.loc.de.s();	 Catch:{ all -> 0x0091 }
        if (r0 != 0) goto L_0x0015;
    L_0x0012:
        r0 = r1;
    L_0x0013:
        monitor-exit(r4);
        return r0;
    L_0x0015:
        r0 = r4.b();	 Catch:{ all -> 0x0091 }
        if (r0 == 0) goto L_0x0020;
    L_0x001b:
        r4.c();	 Catch:{ all -> 0x0091 }
        r0 = r1;
        goto L_0x0013;
    L_0x0020:
        r0 = r4.b;	 Catch:{ all -> 0x0091 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0091 }
        if (r0 == 0) goto L_0x002a;
    L_0x0028:
        r0 = r1;
        goto L_0x0013;
    L_0x002a:
        r0 = "cgiwifi";
        r0 = r5.contains(r0);	 Catch:{ all -> 0x0091 }
        if (r0 == 0) goto L_0x0062;
    L_0x0032:
        r0 = r4.a(r6, r5);	 Catch:{ all -> 0x0091 }
        if (r0 == 0) goto L_0x0038;
    L_0x0038:
        if (r0 == 0) goto L_0x0060;
    L_0x003a:
        r2 = r0.a;	 Catch:{ all -> 0x0091 }
        r2 = com.loc.dm.a(r2);	 Catch:{ all -> 0x0091 }
        if (r2 == 0) goto L_0x0060;
    L_0x0042:
        r0 = r0.a;	 Catch:{ all -> 0x0091 }
        r2 = "mem";
        r0.f = r2;	 Catch:{ all -> 0x0091 }
        r2 = com.loc.cq.d;	 Catch:{ all -> 0x0091 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x0091 }
        if (r2 == 0) goto L_0x0058;
    L_0x0050:
        r2 = r0.x;	 Catch:{ all -> 0x0091 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ all -> 0x0091 }
        com.loc.cq.d = r2;	 Catch:{ all -> 0x0091 }
    L_0x0058:
        r2 = r0.e;	 Catch:{ all -> 0x0091 }
        r2 = com.loc.de.c(r2);	 Catch:{ all -> 0x0091 }
        if (r2 != 0) goto L_0x0013;
    L_0x0060:
        r0 = r1;
        goto L_0x0013;
    L_0x0062:
        r0 = "wifi";
        r0 = r5.contains(r0);	 Catch:{ all -> 0x0091 }
        if (r0 == 0) goto L_0x0071;
    L_0x006a:
        r0 = r4.a(r6, r5);	 Catch:{ all -> 0x0091 }
        if (r0 == 0) goto L_0x0038;
    L_0x0070:
        goto L_0x0038;
    L_0x0071:
        r0 = "cgi";
        r0 = r5.contains(r0);	 Catch:{ all -> 0x0091 }
        if (r0 == 0) goto L_0x0094;
    L_0x0079:
        r0 = r4.b;	 Catch:{ all -> 0x0091 }
        r0 = r0.containsKey(r5);	 Catch:{ all -> 0x0091 }
        if (r0 == 0) goto L_0x0094;
    L_0x0081:
        r0 = r4.b;	 Catch:{ all -> 0x0091 }
        r0 = r0.get(r5);	 Catch:{ all -> 0x0091 }
        r0 = (java.util.ArrayList) r0;	 Catch:{ all -> 0x0091 }
        r2 = 0;
        r0 = r0.get(r2);	 Catch:{ all -> 0x0091 }
        r0 = (com.loc.cr) r0;	 Catch:{ all -> 0x0091 }
        goto L_0x0038;
    L_0x0091:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
    L_0x0094:
        r0 = r1;
        goto L_0x0038;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.cs.a(java.lang.String, java.lang.StringBuilder, boolean):com.autonavi.aps.amapapi.model.AmapLoc");
    }

    public final void a(Context context) {
        if (!this.d) {
            dm.b();
            try {
                cu.a().a(context);
            } catch (Throwable th) {
                cq.a(th, "Cache", "loadDB");
            }
            this.d = true;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r9, java.lang.StringBuilder r10, com.autonavi.aps.amapapi.model.AmapLoc r11, android.content.Context r12, boolean r13) {
        /*
        r8 = this;
        r7 = 3;
        r6 = 0;
        r0 = 1;
        r1 = 0;
        monitor-enter(r8);
        r2 = android.text.TextUtils.isEmpty(r9);	 Catch:{ all -> 0x012b }
        if (r2 != 0) goto L_0x0011;
    L_0x000b:
        r2 = com.loc.dm.a(r11);	 Catch:{ all -> 0x012b }
        if (r2 != 0) goto L_0x0016;
    L_0x0011:
        r0 = r1;
    L_0x0012:
        if (r0 != 0) goto L_0x002a;
    L_0x0014:
        monitor-exit(r8);
        return;
    L_0x0016:
        r2 = "#";
        r2 = r9.startsWith(r2);	 Catch:{ all -> 0x012b }
        if (r2 == 0) goto L_0x0020;
    L_0x001e:
        r0 = r1;
        goto L_0x0012;
    L_0x0020:
        r2 = "network";
        r2 = r9.contains(r2);	 Catch:{ all -> 0x012b }
        if (r2 != 0) goto L_0x0012;
    L_0x0028:
        r0 = r1;
        goto L_0x0012;
    L_0x002a:
        r0 = r11.f;	 Catch:{ all -> 0x012b }
        r2 = "mem";
        r0 = r0.equals(r2);	 Catch:{ all -> 0x012b }
        if (r0 != 0) goto L_0x0014;
    L_0x0034:
        r0 = r11.f;	 Catch:{ all -> 0x012b }
        r2 = "file";
        r0 = r0.equals(r2);	 Catch:{ all -> 0x012b }
        if (r0 != 0) goto L_0x0014;
    L_0x003e:
        r0 = r11.k;	 Catch:{ all -> 0x012b }
        r2 = "-3";
        r0 = r0.equals(r2);	 Catch:{ all -> 0x012b }
        if (r0 != 0) goto L_0x0014;
    L_0x0048:
        r0 = r8.b();	 Catch:{ all -> 0x012b }
        if (r0 == 0) goto L_0x0051;
    L_0x004e:
        r8.c();	 Catch:{ all -> 0x012b }
    L_0x0051:
        r0 = r11.E;	 Catch:{ all -> 0x012b }
        r2 = "offpct";
        r2 = com.loc.dm.a(r0, r2);	 Catch:{ all -> 0x012b }
        if (r2 == 0) goto L_0x0062;
    L_0x005b:
        r2 = "offpct";
        r0.remove(r2);	 Catch:{ all -> 0x012b }
        r11.E = r0;	 Catch:{ all -> 0x012b }
    L_0x0062:
        r0 = "wifi";
        r0 = r9.contains(r0);	 Catch:{ all -> 0x012b }
        if (r0 == 0) goto L_0x0197;
    L_0x006a:
        r0 = android.text.TextUtils.isEmpty(r10);	 Catch:{ all -> 0x012b }
        if (r0 != 0) goto L_0x0014;
    L_0x0070:
        r0 = r11.d;	 Catch:{ all -> 0x012b }
        r2 = 1133903872; // 0x43960000 float:300.0 double:5.60222949E-315;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 < 0) goto L_0x012e;
    L_0x0078:
        r0 = r10.toString();	 Catch:{ all -> 0x012b }
        r2 = "#";
        r2 = r0.split(r2);	 Catch:{ all -> 0x012b }
        r3 = r2.length;	 Catch:{ all -> 0x012b }
        r0 = r1;
    L_0x0084:
        if (r1 >= r3) goto L_0x0095;
    L_0x0086:
        r4 = r2[r1];	 Catch:{ all -> 0x012b }
        r5 = ",";
        r4 = r4.contains(r5);	 Catch:{ all -> 0x012b }
        if (r4 == 0) goto L_0x0092;
    L_0x0090:
        r0 = r0 + 1;
    L_0x0092:
        r1 = r1 + 1;
        goto L_0x0084;
    L_0x0095:
        r1 = 8;
        if (r0 >= r1) goto L_0x0014;
    L_0x0099:
        r0 = "cgiwifi";
        r0 = r9.contains(r0);	 Catch:{ all -> 0x012b }
        if (r0 == 0) goto L_0x00cb;
    L_0x00a1:
        r0 = r11.y;	 Catch:{ all -> 0x012b }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x012b }
        if (r0 != 0) goto L_0x00cb;
    L_0x00a9:
        r0 = "cgiwifi";
        r1 = "cgi";
        r1 = r9.replace(r0, r1);	 Catch:{ all -> 0x012b }
        r0 = r11.y;	 Catch:{ all -> 0x012b }
        r2 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x012b }
        if (r2 == 0) goto L_0x0138;
    L_0x00b9:
        r3 = r6;
    L_0x00ba:
        r0 = com.loc.dm.a(r3);	 Catch:{ all -> 0x012b }
        if (r0 == 0) goto L_0x00cb;
    L_0x00c0:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x012b }
        r2.<init>();	 Catch:{ all -> 0x012b }
        r5 = 1;
        r0 = r8;
        r4 = r12;
        r0.a(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x012b }
    L_0x00cb:
        r0 = 1;
        r0 = r8.a(r9, r10, r0);	 Catch:{ all -> 0x012b }
        r1 = com.loc.dm.a(r0);	 Catch:{ all -> 0x012b }
        if (r1 == 0) goto L_0x00e6;
    L_0x00d6:
        r1 = 1;
        r0 = r0.c(r1);	 Catch:{ all -> 0x012b }
        r1 = 3;
        r1 = r11.c(r1);	 Catch:{ all -> 0x012b }
        r0 = r0.equals(r1);	 Catch:{ all -> 0x012b }
        if (r0 != 0) goto L_0x0014;
    L_0x00e6:
        r0 = com.loc.dm.b();	 Catch:{ all -> 0x012b }
        r8.c = r0;	 Catch:{ all -> 0x012b }
        r1 = new com.loc.cr;	 Catch:{ all -> 0x012b }
        r1.<init>();	 Catch:{ all -> 0x012b }
        r1.a = r11;	 Catch:{ all -> 0x012b }
        r0 = android.text.TextUtils.isEmpty(r10);	 Catch:{ all -> 0x012b }
        if (r0 == 0) goto L_0x01b4;
    L_0x00f9:
        r0 = r6;
    L_0x00fa:
        r2 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x012b }
        if (r2 == 0) goto L_0x01ba;
    L_0x0100:
        r0 = 0;
        r1.b = r0;	 Catch:{ all -> 0x012b }
    L_0x0103:
        r0 = r8.b;	 Catch:{ all -> 0x012b }
        r0 = r0.containsKey(r9);	 Catch:{ all -> 0x012b }
        if (r0 == 0) goto L_0x01c6;
    L_0x010b:
        r0 = r8.b;	 Catch:{ all -> 0x012b }
        r0 = r0.get(r9);	 Catch:{ all -> 0x012b }
        r0 = (java.util.ArrayList) r0;	 Catch:{ all -> 0x012b }
        r0.add(r1);	 Catch:{ all -> 0x012b }
    L_0x0116:
        if (r13 == 0) goto L_0x0014;
    L_0x0118:
        r0 = com.loc.cu.a();	 Catch:{ Throwable -> 0x0121 }
        r0.a(r9, r11, r10, r12);	 Catch:{ Throwable -> 0x0121 }
        goto L_0x0014;
    L_0x0121:
        r0 = move-exception;
        r1 = "Cache";
        r2 = "add";
        com.loc.cq.a(r0, r1, r2);	 Catch:{ all -> 0x012b }
        goto L_0x0014;
    L_0x012b:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x012e:
        r0 = r11.d;	 Catch:{ all -> 0x012b }
        r1 = 1092616192; // 0x41200000 float:10.0 double:5.398241246E-315;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 > 0) goto L_0x0099;
    L_0x0136:
        goto L_0x0014;
    L_0x0138:
        r2 = ",";
        r0 = r0.split(r2);	 Catch:{ all -> 0x012b }
        r2 = r0.length;	 Catch:{ all -> 0x012b }
        if (r2 == r7) goto L_0x0144;
    L_0x0141:
        r3 = r6;
        goto L_0x00ba;
    L_0x0144:
        r3 = new com.autonavi.aps.amapapi.model.AmapLoc;	 Catch:{ all -> 0x012b }
        r3.<init>();	 Catch:{ all -> 0x012b }
        r2 = r11.a;	 Catch:{ all -> 0x012b }
        r3.a = r2;	 Catch:{ all -> 0x012b }
        r2 = 0;
        r2 = r0[r2];	 Catch:{ all -> 0x012b }
        r4 = java.lang.Double.parseDouble(r2);	 Catch:{ all -> 0x012b }
        r3.b = r4;	 Catch:{ all -> 0x012b }
        r2 = 1;
        r2 = r0[r2];	 Catch:{ all -> 0x012b }
        r4 = java.lang.Double.parseDouble(r2);	 Catch:{ all -> 0x012b }
        r3.c = r4;	 Catch:{ all -> 0x012b }
        r2 = 2;
        r0 = r0[r2];	 Catch:{ all -> 0x012b }
        r0 = java.lang.Float.parseFloat(r0);	 Catch:{ all -> 0x012b }
        r3.a(r0);	 Catch:{ all -> 0x012b }
        r0 = r11.m;	 Catch:{ all -> 0x012b }
        r3.m = r0;	 Catch:{ all -> 0x012b }
        r0 = r11.o;	 Catch:{ all -> 0x012b }
        r3.o = r0;	 Catch:{ all -> 0x012b }
        r0 = r11.p;	 Catch:{ all -> 0x012b }
        r3.p = r0;	 Catch:{ all -> 0x012b }
        r0 = r11.q;	 Catch:{ all -> 0x012b }
        r3.q = r0;	 Catch:{ all -> 0x012b }
        r0 = r11.r;	 Catch:{ all -> 0x012b }
        r3.r = r0;	 Catch:{ all -> 0x012b }
        r4 = r11.e;	 Catch:{ all -> 0x012b }
        r3.e = r4;	 Catch:{ all -> 0x012b }
        r0 = r11.f;	 Catch:{ all -> 0x012b }
        r3.f = r0;	 Catch:{ all -> 0x012b }
        r0 = r11.x;	 Catch:{ all -> 0x012b }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x012b }
        r3.c(r0);	 Catch:{ all -> 0x012b }
        r0 = com.loc.dm.a(r3);	 Catch:{ all -> 0x012b }
        if (r0 != 0) goto L_0x00ba;
    L_0x0194:
        r3 = r6;
        goto L_0x00ba;
    L_0x0197:
        r0 = "cgi";
        r0 = r9.contains(r0);	 Catch:{ all -> 0x012b }
        if (r0 == 0) goto L_0x00cb;
    L_0x019f:
        r0 = ",";
        r0 = r10.indexOf(r0);	 Catch:{ all -> 0x012b }
        r1 = -1;
        if (r0 != r1) goto L_0x0014;
    L_0x01a8:
        r0 = r11.k;	 Catch:{ all -> 0x012b }
        r1 = "4";
        r0 = r0.equals(r1);	 Catch:{ all -> 0x012b }
        if (r0 == 0) goto L_0x00cb;
    L_0x01b2:
        goto L_0x0014;
    L_0x01b4:
        r0 = r10.toString();	 Catch:{ all -> 0x012b }
        goto L_0x00fa;
    L_0x01ba:
        r2 = "##";
        r3 = "#";
        r0 = r0.replace(r2, r3);	 Catch:{ all -> 0x012b }
        r1.b = r0;	 Catch:{ all -> 0x012b }
        goto L_0x0103;
    L_0x01c6:
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x012b }
        r0.<init>();	 Catch:{ all -> 0x012b }
        r0.add(r1);	 Catch:{ all -> 0x012b }
        r1 = r8.b;	 Catch:{ all -> 0x012b }
        r1.put(r9, r0);	 Catch:{ all -> 0x012b }
        goto L_0x0116;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.cs.a(java.lang.String, java.lang.StringBuilder, com.autonavi.aps.amapapi.model.AmapLoc, android.content.Context, boolean):void");
    }
}
