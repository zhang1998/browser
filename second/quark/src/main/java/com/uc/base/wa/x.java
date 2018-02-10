package com.uc.base.wa;

import android.content.IntentFilter;
import android.util.Log;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.uc.base.wa.a.c;
import com.uc.base.wa.b.g;
import com.uc.base.wa.b.h;
import com.uc.base.wa.b.i;
import com.uc.base.wa.b.j;
import com.uc.base.wa.b.o;
import com.uc.base.wa.b.p;
import com.uc.base.wa.config.WaIpcHelper;
import com.uc.base.wa.config.WaIpcHelper.WaBroadcastReceiver;
import com.uc.base.wa.config.b;
import com.uc.base.wa.config.m;
import com.uc.base.wa.d.l;
import com.uc.base.wa.f.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ProGuard */
public class x {
    private static HashMap<String, j> a = new HashMap();
    private static a b = new f();
    private static long c = -1;

    static {
        c.d();
    }

    private static l a(String str, o oVar) {
        j jVar;
        h a;
        c.d();
        synchronized (a) {
            jVar = (j) a.get(str);
            if (jVar == null) {
                String str2 = b.e(str).g;
                if (str2 != null) {
                    a(str2, null);
                }
                j a2 = i.a(str);
                a.put(str, a2);
                if (str2 != null) {
                    a2.a((j) a.get(str2));
                }
                jVar = a2;
            }
            a = i.a(str, jVar, oVar);
        }
        return new l(jVar, a);
    }

    public static void a(String[] strArr, String[] strArr2, int i) {
        com.uc.base.wa.config.c.a(strArr, strArr2, i);
    }

    public static void a(w wVar) {
        p.a(wVar);
    }

    public static void a(q qVar) {
        b.a(qVar);
    }

    public static void a(p pVar) {
        b.a(pVar);
    }

    private static void a(String str, boolean z, d dVar, e eVar, String... strArr) {
        v vVar = new v();
        vVar.a = z;
        a(str, vVar, dVar, eVar, strArr);
    }

    public static void a(String str, d dVar, e eVar, String... strArr) {
        a(str, true, dVar, eVar, strArr);
    }

    public static void a(String str, v vVar, e eVar, String... strArr) {
        a(str, vVar, b.a(), eVar, strArr);
    }

    public static void a(String str, e eVar, String... strArr) {
        a(str, true, b.a(), eVar, strArr);
    }

    public static void b(String str, e eVar, String... strArr) {
        a(str, false, c.a(), eVar, strArr);
    }

    public static void a(String str, u uVar) {
        if (uVar != null) {
            l.a(str, uVar);
        }
    }

    public static boolean a(int i) {
        return a(i, 0, null);
    }

    public static void a() {
        a(2, 2, null);
    }

    public static boolean a(int i, int i2, Object... objArr) {
        c.d();
        if (z.a()) {
            z.b();
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis > c + 300000) {
                c = currentTimeMillis;
            }
            switch (i) {
                case 1:
                    a(i2, objArr);
                    break;
                case 2:
                    b(i2);
                    break;
                case 3:
                    c(i2);
                    break;
                case 4:
                    b(i2);
                    break;
                case 5:
                    c(i2);
                    break;
                case 8:
                    b(i2);
                    break;
                case 9:
                    c(i2);
                    break;
            }
            return true;
        }
        HashMap c = z.c();
        if (c.size() > 0) {
            Set entrySet = c.entrySet();
            if (entrySet != null && entrySet.size() > 0) {
                HashMap hashMap = new HashMap();
                Iterator it = entrySet.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    int i4;
                    Entry entry = (Entry) it.next();
                    i3++;
                    hashMap.put(entry.getKey(), entry.getValue());
                    if (i3 >= 30 || !it.hasNext()) {
                        String str = "ev_ac";
                        a("wa", new e().a("ev_ct", INoCaptchaComponent.status).a(str, "flush").a(hashMap), new String[0]);
                        hashMap.clear();
                        i4 = 0;
                    } else {
                        i4 = i3;
                    }
                    i3 = i4;
                }
            }
        }
        switch (i) {
            case 1:
                a(i2, objArr);
                break;
            case 2:
                b(i2);
                break;
            case 3:
                c(i2);
                break;
            case 4:
                b(i2);
                break;
            case 5:
                c(i2);
                break;
            case 8:
                b(i2);
                break;
            case 9:
                c(i2);
                break;
        }
        return true;
    }

    private static boolean a(int i, Object... objArr) {
        if (b.a()) {
            return true;
        }
        o oVar = null;
        boolean a = a(i, 1);
        if (a && objArr != null && objArr.length > 0) {
            oVar = (o) objArr[0];
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean i2 = c.a().i();
        boolean j = c.a().j();
        if (!i2 && !j) {
            return false;
        }
        long c;
        long j2;
        boolean z;
        long a2;
        long b = m.b();
        long c2 = m.c();
        if (b > 0) {
            c = b.c();
            j2 = currentTimeMillis - b;
            if (j2 >= c) {
                z = false;
            } else {
                b = currentTimeMillis - l.a();
                if (!a && b < c) {
                    if (oVar != null) {
                        oVar.a();
                    }
                    return false;
                } else if (i2) {
                    z = false;
                } else {
                    z = true;
                }
            }
        } else {
            j2 = 0;
            z = false;
        }
        if (c2 > 0) {
            c2 = currentTimeMillis - c2;
        } else {
            c2 = 0;
        }
        if (j) {
            a2 = m.a() + b.b(j2);
            c = b.a(a2);
        } else {
            a2 = 0;
            c = m.i();
        }
        String a3 = com.uc.base.wa.c.c.a(1);
        ArrayList arrayList = new ArrayList();
        for (int i3 : b.d) {
            if (i3 != 1) {
                arrayList.add(com.uc.base.wa.c.c.a(i3));
            }
        }
        return l.a(i2, j, c, z, a3, arrayList, a, new s(a2, currentTimeMillis, z, i2, j, j2, c2, oVar, a));
    }

    private static void b(int i) {
        if (!b.n() && e.b() > 30000) {
            a("forced", new e().a("sv_thread_time", String.valueOf(e.b())), new String[0]);
        }
        boolean a = a(i, 2);
        g.b(true);
        if (a) {
            com.uc.base.wa.component.e.a.a(true);
        } else {
            e.a(4, new j());
        }
    }

    private static void c(int i) {
        b(i);
        if (c.a().o() != null) {
            a(1, 0, null);
        }
    }

    private static boolean a(int i, int i2) {
        return (i & i2) > 0;
    }

    public static void a(String str) {
        long n;
        if (WaIpcHelper.a == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.UCMobile.intent.action.DISABLE_WA_CATEGORY");
            WaIpcHelper.a = new WaBroadcastReceiver();
            try {
                c.b().registerReceiver(WaIpcHelper.a, intentFilter);
            } catch (Throwable e) {
                Log.e("WaIpcHelper", "", e);
            }
        }
        b.a(str);
        if (c.a().j()) {
            n = m.n();
        } else {
            n = m.m();
        }
        l.a((System.currentTimeMillis() - n) + m.o());
        String a = WaIpcHelper.a();
        if (a != null) {
            b.b(a);
        }
        c.e();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.lang.String r15, com.uc.base.wa.v r16, com.uc.base.wa.d r17, com.uc.base.wa.e r18, java.lang.String... r19) {
        /*
        r4 = 0;
        if (r18 != 0) goto L_0x0029;
    L_0x0003:
        r2 = 0;
        r3 = r2;
    L_0x0005:
        if (r3 == 0) goto L_0x038a;
    L_0x0007:
        r2 = r3.a();
        if (r2 != 0) goto L_0x0085;
    L_0x000d:
        r2 = 0;
    L_0x000e:
        switch(r2) {
            case 0: goto L_0x009d;
            case 1: goto L_0x00a0;
            case 2: goto L_0x00c2;
            default: goto L_0x0011;
        };
    L_0x0011:
        r2 = com.uc.base.wa.a.c.a();
        r5 = "";
        r2.b(r5);
    L_0x001a:
        r2 = r4;
    L_0x001b:
        r4 = r3.a;
        if (r4 == 0) goto L_0x0026;
    L_0x001f:
        r4 = r3.a;
        r0 = r18;
        r4.a(r15, r0, r3);
    L_0x0026:
        if (r2 == 0) goto L_0x00e7;
    L_0x0028:
        return;
    L_0x0029:
        r0 = r18;
        r2 = r0.a;
        r3 = r2.c();
        if (r3 != 0) goto L_0x0036;
    L_0x0033:
        r2 = 0;
        r3 = r2;
        goto L_0x0005;
    L_0x0036:
        r5 = com.uc.base.wa.config.b.f(r15);
        r6 = r2.a();
        r2 = "ev_ct";
        r2 = r6.get(r2);
        r2 = (java.lang.String) r2;
        r3 = "ev_ac";
        r3 = r6.get(r3);
        r3 = (java.lang.String) r3;
        r2 = com.uc.base.wa.config.b.a(r15, r2, r3);
        if (r2 != 0) goto L_0x0083;
    L_0x0054:
        r2 = "ev_ct";
        r2 = r6.get(r2);
        r2 = (java.lang.String) r2;
        r3 = "ev_ac";
        r3 = r6.get(r3);
        r3 = (java.lang.String) r3;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r2 = r6.append(r2);
        r6 = "#";
        r2 = r2.append(r6);
        r2 = r2.append(r3);
        r2 = r2.toString();
        r3 = r5.n;
        r2 = r3.get(r2);
        r2 = (com.uc.base.wa.config.i) r2;
    L_0x0083:
        r3 = r2;
        goto L_0x0005;
    L_0x0085:
        r6 = r2.a;
        r8 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r5 >= 0) goto L_0x008f;
    L_0x008d:
        r2 = 0;
        goto L_0x000e;
    L_0x008f:
        r2 = r2.b;
        r2 = r2.b();
        if (r2 == 0) goto L_0x009a;
    L_0x0097:
        r2 = 1;
        goto L_0x000e;
    L_0x009a:
        r2 = 2;
        goto L_0x000e;
    L_0x009d:
        r2 = r4;
        goto L_0x001b;
    L_0x00a0:
        r2 = com.uc.base.wa.config.e.a();
        if (r2 != 0) goto L_0x00af;
    L_0x00a6:
        r5 = com.uc.base.wa.a.c.a();
        r6 = "";
        r5.b(r6);
    L_0x00af:
        r5 = "ev_sd";
        r0 = r18;
        r0.a(r5, r2);
        r2 = "ev_sr";
        r5 = "1";
        r0 = r18;
        r0.a(r2, r5);
        r2 = r4;
        goto L_0x001b;
    L_0x00c2:
        r2 = r3.a();
        r5 = r2.a();
        if (r5 != 0) goto L_0x00cf;
    L_0x00cc:
        r2 = 1;
        goto L_0x001b;
    L_0x00cf:
        if (r18 == 0) goto L_0x001a;
    L_0x00d1:
        r5 = r18.a();
        if (r5 != 0) goto L_0x001a;
    L_0x00d7:
        r6 = r2.a;
        r2 = "ev_sr";
        r5 = java.lang.String.valueOf(r6);
        r0 = r18;
        r0.a(r2, r5);
        r2 = r4;
        goto L_0x001b;
    L_0x00e7:
        if (r16 != 0) goto L_0x010f;
    L_0x00e9:
        r2 = 1;
        r3 = r2;
    L_0x00eb:
        if (r16 != 0) goto L_0x0115;
    L_0x00ed:
        r2 = 0;
        r14 = r2;
    L_0x00ef:
        if (r16 != 0) goto L_0x011b;
    L_0x00f1:
        r9 = 0;
    L_0x00f2:
        if (r3 != 0) goto L_0x0181;
    L_0x00f4:
        r2 = com.uc.base.wa.config.b.a();
        if (r2 != 0) goto L_0x0028;
    L_0x00fa:
        r2 = com.uc.base.wa.f.e.a();
        r3 = android.os.Looper.myLooper();
        if (r2 != r3) goto L_0x0120;
    L_0x0104:
        r2 = com.uc.base.wa.a.c.a();
        r3 = "dead lock";
        r2.b(r3);
        goto L_0x0028;
    L_0x010f:
        r0 = r16;
        r2 = r0.a;
        r3 = r2;
        goto L_0x00eb;
    L_0x0115:
        r0 = r16;
        r2 = r0.b;
        r14 = r2;
        goto L_0x00ef;
    L_0x011b:
        r0 = r16;
        r9 = r0.c;
        goto L_0x00f2;
    L_0x0120:
        r2 = com.uc.base.wa.a.c.a();
        r8 = r2.j();
        r6 = java.lang.System.currentTimeMillis();
        r2 = com.uc.base.wa.config.m.b();
        r4 = 0;
        r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x015d;
    L_0x0136:
        r2 = r6 - r2;
    L_0x0138:
        r4 = com.uc.base.wa.config.m.a();
        r2 = com.uc.base.wa.config.b.b(r2);
        r4 = r4 + r2;
        r3 = new com.uc.base.wa.h;
        r10 = r15;
        r11 = r17;
        r12 = r18;
        r13 = r19;
        r3.<init>(r4, r6, r8, r9, r10, r11, r12, r13);
        if (r17 != 0) goto L_0x0160;
    L_0x014f:
        r2 = "gzm_wa_WaEntry";
        r3 = "";
        r4 = new java.lang.Throwable;
        r4.<init>();
        android.util.Log.e(r2, r3, r4);
        goto L_0x0028;
    L_0x015d:
        r2 = 0;
        goto L_0x0138;
    L_0x0160:
        r9 = 0;
        if (r18 == 0) goto L_0x0167;
    L_0x0163:
        r0 = r18;
        r9 = r0.a;
    L_0x0167:
        r0 = r17;
        r2 = a(r15, r0);
        r4 = r2.a;
        r5 = new com.uc.base.wa.i;
        r0 = r17;
        r5.<init>(r0, r15);
        r8 = r2.b;
        r6 = r3;
        r7 = r14;
        r10 = r19;
        r4.a(r5, r6, r7, r8, r9, r10);
        goto L_0x0028;
    L_0x0181:
        if (r17 == 0) goto L_0x0028;
    L_0x0183:
        r0 = r17;
        r3 = a(r15, r0);
        r2 = 0;
        if (r18 == 0) goto L_0x0190;
    L_0x018c:
        r0 = r18;
        r2 = r0.a;
    L_0x0190:
        if (r2 == 0) goto L_0x0378;
    L_0x0192:
        r4 = r2.c();
        if (r4 == 0) goto L_0x0378;
    L_0x0198:
        r4 = r2.d();
        if (r4 == 0) goto L_0x0378;
    L_0x019e:
        r8 = r2.a();
        r9 = r2.b();
        r2 = r9.b();
        if (r2 == 0) goto L_0x0204;
    L_0x01ac:
        r2 = r9.g();
        r2 = r2.entrySet();
        r4 = r2.iterator();
    L_0x01b8:
        r2 = r4.hasNext();
        if (r2 == 0) goto L_0x0204;
    L_0x01be:
        r2 = r4.next();
        r2 = (java.util.Map.Entry) r2;
        r3 = r2.getKey();
        r3 = (java.lang.String) r3;
        r3 = com.uc.base.wa.y.a(r3);
        r3 = r3.a(r8);
        r3 = r3.a();
        r5 = new com.uc.base.wa.e;
        r5.<init>();
        r2 = r2.getValue();
        r2 = (java.lang.String) r2;
        if (r3 == 0) goto L_0x01f4;
    L_0x01e3:
        r6 = r5.a;
        r7 = 1;
        r6.e = r7;
        r6 = r5.a;
        r6 = r6.b();
        if (r6 == 0) goto L_0x01f4;
    L_0x01f0:
        if (r3 == 0) goto L_0x01f4;
    L_0x01f2:
        if (r2 != 0) goto L_0x01fc;
    L_0x01f4:
        r0 = r17;
        r1 = r19;
        a(r15, r0, r5, r1);
        goto L_0x01b8;
    L_0x01fc:
        r6 = r6.g();
        r6.put(r3, r2);
        goto L_0x01f4;
    L_0x0204:
        r2 = r9.c();
        if (r2 == 0) goto L_0x026e;
    L_0x020a:
        r2 = r9.h();
        r2 = r2.entrySet();
        r4 = r2.iterator();
    L_0x0216:
        r2 = r4.hasNext();
        if (r2 == 0) goto L_0x026e;
    L_0x021c:
        r2 = r4.next();
        r2 = (java.util.Map.Entry) r2;
        r3 = r2.getKey();
        r3 = (java.lang.String) r3;
        r3 = com.uc.base.wa.y.a(r3);
        r3 = r3.a(r8);
        r3 = r3.a();
        r5 = new com.uc.base.wa.e;
        r5.<init>();
        r2 = r2.getValue();
        r2 = (com.uc.base.wa.b.a) r2;
        r6 = r2.a;
        if (r3 == 0) goto L_0x0258;
    L_0x0243:
        r2 = r5.a;
        r10 = 1;
        r2.e = r10;
        r2 = r5.a;
        r2 = r2.b();
        r6 = java.lang.Double.valueOf(r6);
        if (r2 == 0) goto L_0x0258;
    L_0x0254:
        if (r3 == 0) goto L_0x0258;
    L_0x0256:
        if (r6 != 0) goto L_0x0260;
    L_0x0258:
        r0 = r17;
        r1 = r19;
        a(r15, r0, r5, r1);
        goto L_0x0216;
    L_0x0260:
        r7 = new com.uc.base.wa.b.a;
        r10 = r6.doubleValue();
        r6 = 1;
        r7.<init>(r10, r6);
        com.uc.base.wa.b.q.a(r2, r3, r7);
        goto L_0x0258;
    L_0x026e:
        r2 = r9.d();
        if (r2 == 0) goto L_0x02bc;
    L_0x0274:
        r2 = r9.i();
        r2 = r2.entrySet();
        r10 = r2.iterator();
    L_0x0280:
        r2 = r10.hasNext();
        if (r2 == 0) goto L_0x02bc;
    L_0x0286:
        r2 = r10.next();
        r2 = (java.util.Map.Entry) r2;
        r3 = r2.getKey();
        r3 = (java.lang.String) r3;
        r2 = r2.getValue();
        r7 = r2;
        r7 = (com.uc.base.wa.b.b) r7;
        r2 = com.uc.base.wa.y.a(r3);
        r2 = r2.a(r8);
        r3 = r2.a();
        r2 = new com.uc.base.wa.e;
        r2.<init>();
        r4 = r7.a;
        r6 = r7.b;
        r7 = r7.c;
        r2 = r2.a(r3, r4, r6, r7);
        r0 = r17;
        r1 = r19;
        a(r15, r0, r2, r1);
        goto L_0x0280;
    L_0x02bc:
        r2 = r9.e();
        if (r2 == 0) goto L_0x031a;
    L_0x02c2:
        r2 = r9.j();
        r2 = r2.entrySet();
        r4 = r2.iterator();
    L_0x02ce:
        r2 = r4.hasNext();
        if (r2 == 0) goto L_0x031a;
    L_0x02d4:
        r2 = r4.next();
        r2 = (java.util.Map.Entry) r2;
        r3 = r2.getKey();
        r3 = (java.lang.String) r3;
        r3 = com.uc.base.wa.y.a(r3);
        r3 = r3.a(r8);
        r5 = r3.a();
        r3 = new com.uc.base.wa.e;
        r3.<init>();
        r2 = r2.getValue();
        r2 = (java.lang.Long) r2;
        r6 = r2.longValue();
        if (r5 != 0) goto L_0x0306;
    L_0x02fd:
        r2 = r3;
    L_0x02fe:
        r0 = r17;
        r1 = r19;
        a(r15, r0, r2, r1);
        goto L_0x02ce;
    L_0x0306:
        r2 = r3.a;
        r10 = 1;
        r2.e = r10;
        r2 = r3.a;
        r2 = r2.b();
        r6 = java.lang.Long.valueOf(r6);
        com.uc.base.wa.b.q.a(r2, r5, r6);
        r2 = r3;
        goto L_0x02fe;
    L_0x031a:
        r2 = r9.f();
        if (r2 == 0) goto L_0x0028;
    L_0x0320:
        r2 = r9.k();
        r2 = r2.entrySet();
        r4 = r2.iterator();
    L_0x032c:
        r2 = r4.hasNext();
        if (r2 == 0) goto L_0x0028;
    L_0x0332:
        r2 = r4.next();
        r2 = (java.util.Map.Entry) r2;
        r3 = r2.getKey();
        r3 = (java.lang.String) r3;
        r3 = com.uc.base.wa.y.a(r3);
        r3 = r3.a(r8);
        r5 = r3.a();
        r3 = new com.uc.base.wa.e;
        r3.<init>();
        r2 = r2.getValue();
        r2 = (java.lang.Long) r2;
        r6 = r2.longValue();
        if (r5 != 0) goto L_0x0364;
    L_0x035b:
        r2 = r3;
    L_0x035c:
        r0 = r17;
        r1 = r19;
        a(r15, r0, r2, r1);
        goto L_0x032c;
    L_0x0364:
        r2 = r3.a;
        r9 = 1;
        r2.e = r9;
        r2 = r3.a;
        r2 = r2.b();
        r6 = java.lang.Long.valueOf(r6);
        com.uc.base.wa.b.q.b(r2, r5, r6);
        r2 = r3;
        goto L_0x035c;
    L_0x0378:
        r4 = r3.a;
        r5 = new com.uc.base.wa.g;
        r0 = r17;
        r5.<init>(r0, r15);
        r3 = r3.b;
        r0 = r19;
        r4.a(r5, r3, r2, r0);
        goto L_0x0028;
    L_0x038a:
        r2 = r4;
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.base.wa.x.a(java.lang.String, com.uc.base.wa.v, com.uc.base.wa.d, com.uc.base.wa.e, java.lang.String[]):void");
    }
}
