package com.uc.base.wa.e;

import android.util.Log;
import com.uc.base.wa.a.c;
import com.uc.base.wa.config.b;
import com.uc.base.wa.e;
import com.uc.base.wa.x;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public class i {
    private static volatile i a;
    private static boolean b = false;
    private static g c = new g();
    private volatile Hashtable<Long, Integer> d = new Hashtable();

    private void c() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0061 in list [B:20:0x005e]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r10 = this;
        r2 = 1;
        r3 = com.uc.base.wa.e.e.a();
        r3.c();	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        r0 = com.uc.base.wa.e.e.a();	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        r1 = "status is 1";	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        r4 = 1;	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        r4 = r0.a(r1, r4);	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        r5 = new java.util.Hashtable;	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        r5.<init>();	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        a(r4, r5);	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        r0 = r0 / r6;	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        r6 = (int) r0;	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        r7 = r4.iterator();	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
    L_0x0027:
        r0 = r7.hasNext();	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        if (r0 == 0) goto L_0x0073;	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
    L_0x002d:
        r0 = r7.next();	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        r0 = (com.uc.base.wa.e.c) r0;	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        r8 = r0.a;	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        r8 = java.lang.Long.valueOf(r8);	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        r1 = r5.get(r8);	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        r1 = (java.lang.Integer) r1;	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        if (r1 == 0) goto L_0x0047;	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
    L_0x0041:
        r1 = r1.intValue();	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        if (r6 <= r1) goto L_0x0027;	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
    L_0x0047:
        r1 = r0.e;	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        r1 = r1 & 1;	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        if (r1 <= 0) goto L_0x0062;	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
    L_0x004d:
        r1 = r2;	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
    L_0x004e:
        if (r1 == 0) goto L_0x0064;	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
    L_0x0050:
        r1 = 4;	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        r0.d = r1;	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
    L_0x0053:
        r5.remove(r8);	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        goto L_0x0027;
    L_0x0057:
        r0 = move-exception;
        r0 = r3.b();	 Catch:{ Exception -> 0x008c }
        if (r0 == 0) goto L_0x0061;	 Catch:{ Exception -> 0x008c }
    L_0x005e:
        r3.e();	 Catch:{ Exception -> 0x008c }
    L_0x0061:
        return;
    L_0x0062:
        r1 = 0;
        goto L_0x004e;
    L_0x0064:
        r1 = 2;
        r0.d = r1;	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        goto L_0x0053;
    L_0x0068:
        r0 = move-exception;
        r1 = r3.b();	 Catch:{ Exception -> 0x008a }
        if (r1 == 0) goto L_0x0072;	 Catch:{ Exception -> 0x008a }
    L_0x006f:
        r3.e();	 Catch:{ Exception -> 0x008a }
    L_0x0072:
        throw r0;
    L_0x0073:
        r0 = r3.a(r4);	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        r3.d();	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
        if (r0 == 0) goto L_0x007e;	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
    L_0x007c:
        r10.d = r5;	 Catch:{ Exception -> 0x0057, all -> 0x0068 }
    L_0x007e:
        r0 = r3.b();	 Catch:{ Exception -> 0x0088 }
        if (r0 == 0) goto L_0x0061;	 Catch:{ Exception -> 0x0088 }
    L_0x0084:
        r3.e();	 Catch:{ Exception -> 0x0088 }
        goto L_0x0061;
    L_0x0088:
        r0 = move-exception;
        goto L_0x0061;
    L_0x008a:
        r1 = move-exception;
        goto L_0x0072;
    L_0x008c:
        r0 = move-exception;
        goto L_0x0061;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.base.wa.e.i.c():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.uc.base.wa.e.i r12, com.uc.base.wa.e.e r13, int[] r14, int[] r15) {
        /*
        r3 = 0;
        r11 = 3;
        r1 = 0;
        r0 = "status is 2";
        r2 = 3;
        r4 = r13.a(r0, r2);	 Catch:{ Exception -> 0x013a, all -> 0x0137 }
        r2 = new com.uc.base.wa.e.h;	 Catch:{ Exception -> 0x013e, all -> 0x0137 }
        r2.<init>();	 Catch:{ Exception -> 0x013e, all -> 0x0137 }
        r3 = r4.iterator();	 Catch:{ Exception -> 0x008d }
    L_0x0013:
        r0 = r3.hasNext();	 Catch:{ Exception -> 0x008d }
        if (r0 == 0) goto L_0x0101;
    L_0x0019:
        r0 = r3.next();	 Catch:{ Exception -> 0x008d }
        r0 = (com.uc.base.wa.e.c) r0;	 Catch:{ Exception -> 0x008d }
        r5 = r0.d;	 Catch:{ Exception -> 0x008d }
        r6 = 2;
        if (r5 != r6) goto L_0x0013;
    L_0x0024:
        r5 = 3;
        r0.d = r5;	 Catch:{ Exception -> 0x008d }
        r5 = r0.b;	 Catch:{ Exception -> 0x008d }
        r5 = com.uc.base.wa.config.b.i(r5);	 Catch:{ Exception -> 0x008d }
        r6 = r0.b;	 Catch:{ Exception -> 0x008d }
        r8 = r0.a;	 Catch:{ Exception -> 0x008d }
        r7 = java.lang.String.valueOf(r8);	 Catch:{ Exception -> 0x008d }
        r8 = r0.f;	 Catch:{ Exception -> 0x008d }
        r0 = r2.a;	 Catch:{ Exception -> 0x008d }
        r9 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x008d }
        r0 = r0.get(r9);	 Catch:{ Exception -> 0x008d }
        r0 = (java.lang.Integer) r0;	 Catch:{ Exception -> 0x008d }
        r9 = r2.b;	 Catch:{ Exception -> 0x008d }
        r10 = r0.intValue();	 Catch:{ Exception -> 0x008d }
        r9 = r9[r10];	 Catch:{ Exception -> 0x008d }
        r10 = r2.c;	 Catch:{ Exception -> 0x008d }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x008d }
        r0 = r10[r0];	 Catch:{ Exception -> 0x008d }
        if (r9 <= r0) goto L_0x00d4;
    L_0x0055:
        r0 = 1;
    L_0x0056:
        if (r0 == 0) goto L_0x00d6;
    L_0x0058:
        r0 = r8.size();	 Catch:{ Exception -> 0x008d }
        r6 = "gzm_SessionService";
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x008d }
        r8 = "size = ";
        r7.<init>(r8);	 Catch:{ Exception -> 0x008d }
        r7 = r7.append(r0);	 Catch:{ Exception -> 0x008d }
        r8 = ", level = ";
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x008d }
        r5 = r7.append(r5);	 Catch:{ Exception -> 0x008d }
        r5 = r5.toString();	 Catch:{ Exception -> 0x008d }
        r7 = new java.lang.Throwable;	 Catch:{ Exception -> 0x008d }
        r7.<init>();	 Catch:{ Exception -> 0x008d }
        android.util.Log.e(r6, r5, r7);	 Catch:{ Exception -> 0x008d }
        r5 = 0;
        r6 = r14[r5];	 Catch:{ Exception -> 0x008d }
        r6 = r6 + 1;
        r14[r5] = r6;	 Catch:{ Exception -> 0x008d }
        r5 = 0;
        r6 = r15[r5];	 Catch:{ Exception -> 0x008d }
        r0 = r0 + r6;
        r15[r5] = r0;	 Catch:{ Exception -> 0x008d }
        goto L_0x0013;
    L_0x008d:
        r0 = move-exception;
        r3 = r4;
    L_0x008f:
        r4 = "gzm_SessionService";
        r5 = "";
        android.util.Log.e(r4, r5, r0);	 Catch:{ all -> 0x00fa }
        r4 = com.uc.base.wa.a.c.a();	 Catch:{ all -> 0x00fa }
        r0 = r0.getMessage();	 Catch:{ all -> 0x00fa }
        r4.b(r0);	 Catch:{ all -> 0x00fa }
        if (r2 == 0) goto L_0x00a6;
    L_0x00a3:
        r2.a();	 Catch:{ IOException -> 0x010e }
    L_0x00a6:
        r4 = r3;
    L_0x00a7:
        if (r2 == 0) goto L_0x00d3;
    L_0x00a9:
        r13.a(r4);
        r0 = r2.b();	 Catch:{ Exception -> 0x0121 }
    L_0x00b0:
        r1 = com.uc.base.wa.config.b.n();
        if (r1 != 0) goto L_0x00c7;
    L_0x00b6:
        r1 = com.uc.base.wa.component.e.a;
        r2 = "E5FFFDF082B7E88B73195E0ED684035D";
        r4 = 0;
        r1.a(r2, r4);
        r1 = com.uc.base.wa.component.e.a;
        r2 = "1114AA5B512B55CECADDF881C655BFA4";
        r4 = (long) r0;
        r1.a(r2, r4);
    L_0x00c7:
        r12.c();
        r0 = "status in (3, 4)";
        r0 = r13.a(r0, r11);
        r13.b(r0);
    L_0x00d3:
        return;
    L_0x00d4:
        r0 = r1;
        goto L_0x0056;
    L_0x00d6:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x008d }
        r9 = "lt=session`seid=";
        r0.<init>(r9);	 Catch:{ Exception -> 0x008d }
        r0 = r0.append(r7);	 Catch:{ Exception -> 0x008d }
        r7 = "`sename=";
        r0 = r0.append(r7);	 Catch:{ Exception -> 0x008d }
        r0 = r0.append(r6);	 Catch:{ Exception -> 0x008d }
        r6 = "`action=";
        r0 = r0.append(r6);	 Catch:{ Exception -> 0x008d }
        r0 = r0.toString();	 Catch:{ Exception -> 0x008d }
        r2.a(r5, r8, r0);	 Catch:{ Exception -> 0x008d }
        goto L_0x0013;
    L_0x00fa:
        r0 = move-exception;
    L_0x00fb:
        if (r2 == 0) goto L_0x0100;
    L_0x00fd:
        r2.a();	 Catch:{ IOException -> 0x0118 }
    L_0x0100:
        throw r0;
    L_0x0101:
        r2.a();	 Catch:{ IOException -> 0x0105 }
        goto L_0x00a7;
    L_0x0105:
        r0 = move-exception;
        r3 = "gzm_wa_WaCache";
        r5 = "";
        android.util.Log.e(r3, r5, r0);
        goto L_0x00a7;
    L_0x010e:
        r0 = move-exception;
        r4 = "gzm_wa_WaCache";
        r5 = "";
        android.util.Log.e(r4, r5, r0);
        r4 = r3;
        goto L_0x00a7;
    L_0x0118:
        r1 = move-exception;
        r2 = "gzm_wa_WaCache";
        r3 = "";
        android.util.Log.e(r2, r3, r1);
        goto L_0x0100;
    L_0x0121:
        r0 = move-exception;
        r2 = "gzm_SessionService";
        r3 = "";
        android.util.Log.e(r2, r3, r0);
        r2 = com.uc.base.wa.a.c.a();
        r0 = r0.getMessage();
        r2.b(r0);
        r0 = r1;
        goto L_0x00b0;
    L_0x0137:
        r0 = move-exception;
        r2 = r3;
        goto L_0x00fb;
    L_0x013a:
        r0 = move-exception;
        r2 = r3;
        goto L_0x008f;
    L_0x013e:
        r0 = move-exception;
        r2 = r3;
        r3 = r4;
        goto L_0x008f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.base.wa.e.i.a(com.uc.base.wa.e.i, com.uc.base.wa.e.e, int[], int[]):void");
    }

    public static void a() {
        if (!b) {
            x.a("session", c);
            b = true;
        }
    }

    public static i b() {
        if (a == null) {
            synchronized (i.class) {
                if (a == null) {
                    a = new i();
                }
            }
        }
        return a;
    }

    private i() {
        a(e.a().a("status is 1", 1), this.d);
    }

    private static void a(List<c> list, Hashtable<Long, Integer> hashtable) {
        if (list != null) {
            for (c cVar : list) {
                int i;
                long j = cVar.a;
                List list2 = cVar.f;
                if (list2.size() > 0) {
                    b bVar = (b) list2.get(0);
                    i = bVar.f + bVar.e;
                } else {
                    i = -1;
                }
                hashtable.put(Long.valueOf(j), Integer.valueOf(i));
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.lang.String r14, int r15, java.lang.String r16, int r17, int r18, java.lang.String r19, java.util.List<java.lang.String> r20, java.util.HashMap<java.lang.String, java.lang.String> r21, java.lang.String r22, com.uc.base.wa.e r23) {
        /*
        r13 = this;
        r5 = 0;
        r2 = java.lang.System.currentTimeMillis();
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r2 / r6;
        r7 = (int) r2;
        r3 = com.uc.base.wa.e.e.a();
        r2 = 0;
        if (r16 == 0) goto L_0x007f;
    L_0x0010:
        r0 = r23;
        r2 = r0.a;	 Catch:{ Exception -> 0x0086 }
        r4 = r2.c;	 Catch:{ Exception -> 0x0086 }
        if (r4 == 0) goto L_0x006e;
    L_0x0018:
        r2 = r2.c;	 Catch:{ Exception -> 0x0086 }
    L_0x001a:
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0086 }
        r6 = "token is '";
        r4.<init>(r6);	 Catch:{ Exception -> 0x0086 }
        r4 = r4.append(r2);	 Catch:{ Exception -> 0x0086 }
        r6 = "'";
        r4 = r4.append(r6);	 Catch:{ Exception -> 0x0086 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0086 }
        r4 = r3.a(r14, r4);	 Catch:{ Exception -> 0x0086 }
        r6 = r2;
    L_0x0034:
        if (r4 == 0) goto L_0x00e7;
    L_0x0036:
        r2 = r4.d;
        r8 = 1;
        if (r2 != r8) goto L_0x00e7;
    L_0x003b:
        r8 = r4.a;
        r2 = r13.d;
        r8 = java.lang.Long.valueOf(r8);
        r2 = r2.get(r8);
        r2 = (java.lang.Integer) r2;
        if (r2 != 0) goto L_0x009b;
    L_0x004b:
        r2 = 0;
    L_0x004c:
        if (r2 <= 0) goto L_0x00e7;
    L_0x004e:
        if (r7 <= r2) goto L_0x00e7;
    L_0x0050:
        r3.c();	 Catch:{ Exception -> 0x00a6, all -> 0x00d1 }
        r2 = r15 & 1;
        if (r2 <= 0) goto L_0x00a0;
    L_0x0057:
        r2 = 1;
    L_0x0058:
        if (r2 == 0) goto L_0x00a2;
    L_0x005a:
        r2 = 4;
        r4.d = r2;	 Catch:{ Exception -> 0x00a6, all -> 0x00d1 }
    L_0x005d:
        r2 = r3.a(r4);	 Catch:{ Exception -> 0x00a6, all -> 0x00d1 }
        if (r2 != 0) goto L_0x00bd;
    L_0x0063:
        r2 = r3.b();	 Catch:{ Exception -> 0x0260 }
        if (r2 == 0) goto L_0x006c;
    L_0x0069:
        r3.e();	 Catch:{ Exception -> 0x0260 }
    L_0x006c:
        r2 = 0;
    L_0x006d:
        return r2;
    L_0x006e:
        r4 = r2.a;	 Catch:{ Exception -> 0x0086 }
        if (r4 == 0) goto L_0x007d;
    L_0x0072:
        r2 = r2.a;	 Catch:{ Exception -> 0x0086 }
        r0 = r16;
        r2 = r2.get(r0);	 Catch:{ Exception -> 0x0086 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0086 }
        goto L_0x001a;
    L_0x007d:
        r2 = 0;
        goto L_0x001a;
    L_0x007f:
        r4 = 0;
        r4 = r3.a(r14, r4);	 Catch:{ Exception -> 0x0086 }
        r6 = r2;
        goto L_0x0034;
    L_0x0086:
        r2 = move-exception;
        r3 = "gzm_SessionService";
        r4 = "";
        android.util.Log.e(r3, r4, r2);
        r3 = com.uc.base.wa.a.c.a();
        r2 = r2.toString();
        r3.b(r2);
        r2 = 0;
        goto L_0x006d;
    L_0x009b:
        r2 = r2.intValue();
        goto L_0x004c;
    L_0x00a0:
        r2 = 0;
        goto L_0x0058;
    L_0x00a2:
        r2 = 2;
        r4.d = r2;	 Catch:{ Exception -> 0x00a6, all -> 0x00d1 }
        goto L_0x005d;
    L_0x00a6:
        r2 = move-exception;
        r2 = r5;
    L_0x00a8:
        r5 = r3.b();	 Catch:{ Exception -> 0x00ce }
        if (r5 == 0) goto L_0x00b1;
    L_0x00ae:
        r3.e();	 Catch:{ Exception -> 0x00ce }
    L_0x00b1:
        r5 = r2;
    L_0x00b2:
        if (r5 != 0) goto L_0x00dc;
    L_0x00b4:
        r2 = "gzm_SessionService";
        r3 = "update sessionStruct fail";
        android.util.Log.e(r2, r3);
        r2 = 0;
        goto L_0x006d;
    L_0x00bd:
        r3.d();	 Catch:{ Exception -> 0x025d, all -> 0x00d1 }
        r5 = r3.b();	 Catch:{ Exception -> 0x00cb }
        if (r5 == 0) goto L_0x00c9;
    L_0x00c6:
        r3.e();	 Catch:{ Exception -> 0x00cb }
    L_0x00c9:
        r5 = r2;
        goto L_0x00b2;
    L_0x00cb:
        r5 = move-exception;
        r5 = r2;
        goto L_0x00b2;
    L_0x00ce:
        r5 = move-exception;
        r5 = r2;
        goto L_0x00b2;
    L_0x00d1:
        r2 = move-exception;
        r4 = r3.b();	 Catch:{ Exception -> 0x025a }
        if (r4 == 0) goto L_0x00db;
    L_0x00d8:
        r3.e();	 Catch:{ Exception -> 0x025a }
    L_0x00db:
        throw r2;
    L_0x00dc:
        r2 = r13.d;
        r8 = r4.a;
        r7 = java.lang.Long.valueOf(r8);
        r2.remove(r7);
    L_0x00e7:
        r12 = r5;
        r2 = 1;
        r0 = r17;
        if (r0 != r2) goto L_0x017d;
    L_0x00ed:
        if (r4 == 0) goto L_0x0108;
    L_0x00ef:
        r2 = r4.d;
        r5 = 1;
        if (r2 != r5) goto L_0x0108;
    L_0x00f4:
        r5 = 2;
        r2 = r13;
        r6 = r18;
        r7 = r19;
        r8 = r20;
        r9 = r21;
        r10 = r22;
        r11 = r23;
        r2 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11);
        goto L_0x006d;
    L_0x0108:
        r4 = new com.uc.base.wa.e.c;
        r2 = 1;
        r4.<init>(r14, r6, r2, r15);
        r3.c();	 Catch:{ Exception -> 0x0162, all -> 0x0172 }
        r12 = r3.a(r4);	 Catch:{ Exception -> 0x0162, all -> 0x0172 }
        if (r12 != 0) goto L_0x012a;
    L_0x0117:
        r2 = "gzm_SessionService";
        r4 = "add sessionStruct fail";
        android.util.Log.e(r2, r4);	 Catch:{ Exception -> 0x024d, all -> 0x0172 }
        r2 = r3.b();	 Catch:{ Exception -> 0x0257 }
        if (r2 == 0) goto L_0x0127;
    L_0x0124:
        r3.e();	 Catch:{ Exception -> 0x0257 }
    L_0x0127:
        r2 = 0;
        goto L_0x006d;
    L_0x012a:
        r5 = 1;
        r2 = r13;
        r6 = r18;
        r7 = r19;
        r8 = r20;
        r9 = r21;
        r10 = r22;
        r11 = r23;
        r2 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x024d, all -> 0x0172 }
        if (r2 != 0) goto L_0x0151;
    L_0x013e:
        r4 = "gzm_SessionService";
        r5 = "add sessionItem fail";
        android.util.Log.e(r4, r5);	 Catch:{ Exception -> 0x0251, all -> 0x0172 }
        r2 = r3.b();	 Catch:{ Exception -> 0x0254 }
        if (r2 == 0) goto L_0x014e;
    L_0x014b:
        r3.e();	 Catch:{ Exception -> 0x0254 }
    L_0x014e:
        r2 = 0;
        goto L_0x006d;
    L_0x0151:
        r3.d();	 Catch:{ Exception -> 0x0251, all -> 0x0172 }
        r4 = r3.b();	 Catch:{ Exception -> 0x015f }
        if (r4 == 0) goto L_0x006d;
    L_0x015a:
        r3.e();	 Catch:{ Exception -> 0x015f }
        goto L_0x006d;
    L_0x015f:
        r3 = move-exception;
        goto L_0x006d;
    L_0x0162:
        r2 = move-exception;
        r2 = r12;
    L_0x0164:
        r4 = r3.b();	 Catch:{ Exception -> 0x016f }
        if (r4 == 0) goto L_0x006d;
    L_0x016a:
        r3.e();	 Catch:{ Exception -> 0x016f }
        goto L_0x006d;
    L_0x016f:
        r3 = move-exception;
        goto L_0x006d;
    L_0x0172:
        r2 = move-exception;
        r4 = r3.b();	 Catch:{ Exception -> 0x024a }
        if (r4 == 0) goto L_0x017c;
    L_0x0179:
        r3.e();	 Catch:{ Exception -> 0x024a }
    L_0x017c:
        throw r2;
    L_0x017d:
        r2 = 2;
        r0 = r17;
        if (r0 != r2) goto L_0x01a3;
    L_0x0182:
        if (r4 != 0) goto L_0x0187;
    L_0x0184:
        r2 = 0;
        goto L_0x006d;
    L_0x0187:
        r2 = r4.d;
        r5 = 2;
        if (r2 < r5) goto L_0x018f;
    L_0x018c:
        r2 = 1;
        goto L_0x006d;
    L_0x018f:
        r5 = 2;
        r2 = r13;
        r6 = r18;
        r7 = r19;
        r8 = r20;
        r9 = r21;
        r10 = r22;
        r11 = r23;
        r2 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11);
        goto L_0x006d;
    L_0x01a3:
        r2 = 3;
        r0 = r17;
        if (r0 != r2) goto L_0x022d;
    L_0x01a8:
        if (r4 != 0) goto L_0x01ad;
    L_0x01aa:
        r2 = 0;
        goto L_0x006d;
    L_0x01ad:
        r2 = r4.d;
        r5 = 2;
        if (r2 < r5) goto L_0x01b5;
    L_0x01b2:
        r2 = 1;
        goto L_0x006d;
    L_0x01b5:
        r3.c();	 Catch:{ Exception -> 0x0214, all -> 0x0222 }
        r5 = 3;
        r2 = r13;
        r6 = r18;
        r7 = r19;
        r8 = r20;
        r9 = r21;
        r10 = r22;
        r11 = r23;
        r2 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x0214, all -> 0x0222 }
        if (r2 != 0) goto L_0x01df;
    L_0x01cc:
        r5 = "gzm_SessionService";
        r6 = "add sessionStruct fail";
        android.util.Log.e(r5, r6);	 Catch:{ Exception -> 0x0242, all -> 0x0222 }
        r2 = r3.b();	 Catch:{ Exception -> 0x0248 }
        if (r2 == 0) goto L_0x01dc;
    L_0x01d9:
        r3.e();	 Catch:{ Exception -> 0x0248 }
    L_0x01dc:
        r2 = 0;
        goto L_0x006d;
    L_0x01df:
        r5 = 2;
        r4.d = r5;	 Catch:{ Exception -> 0x0242, all -> 0x0222 }
        r2 = r3.a(r4);	 Catch:{ Exception -> 0x0242, all -> 0x0222 }
        if (r2 != 0) goto L_0x01fb;
    L_0x01e8:
        r5 = "gzm_SessionService";
        r6 = "update sessionStruct fail";
        android.util.Log.e(r5, r6);	 Catch:{ Exception -> 0x0242, all -> 0x0222 }
        r2 = r3.b();	 Catch:{ Exception -> 0x0246 }
        if (r2 == 0) goto L_0x01f8;
    L_0x01f5:
        r3.e();	 Catch:{ Exception -> 0x0246 }
    L_0x01f8:
        r2 = 0;
        goto L_0x006d;
    L_0x01fb:
        r3.d();	 Catch:{ Exception -> 0x0242, all -> 0x0222 }
        r5 = r3.b();	 Catch:{ Exception -> 0x0244 }
        if (r5 == 0) goto L_0x0207;
    L_0x0204:
        r3.e();	 Catch:{ Exception -> 0x0244 }
    L_0x0207:
        r3 = r13.d;
        r4 = r4.a;
        r4 = java.lang.Long.valueOf(r4);
        r3.remove(r4);
        goto L_0x006d;
    L_0x0214:
        r2 = move-exception;
        r2 = r12;
    L_0x0216:
        r5 = r3.b();	 Catch:{ Exception -> 0x0220 }
        if (r5 == 0) goto L_0x0207;
    L_0x021c:
        r3.e();	 Catch:{ Exception -> 0x0220 }
        goto L_0x0207;
    L_0x0220:
        r3 = move-exception;
        goto L_0x0207;
    L_0x0222:
        r2 = move-exception;
        r4 = r3.b();	 Catch:{ Exception -> 0x0240 }
        if (r4 == 0) goto L_0x022c;
    L_0x0229:
        r3.e();	 Catch:{ Exception -> 0x0240 }
    L_0x022c:
        throw r2;
    L_0x022d:
        r2 = com.uc.base.wa.a.c.a();
        r3 = "error step";
        r2.b(r3);
        r2 = "gzm_SessionService";
        r3 = "error step";
        android.util.Log.e(r2, r3);
        r2 = r12;
        goto L_0x006d;
    L_0x0240:
        r3 = move-exception;
        goto L_0x022c;
    L_0x0242:
        r5 = move-exception;
        goto L_0x0216;
    L_0x0244:
        r3 = move-exception;
        goto L_0x0207;
    L_0x0246:
        r2 = move-exception;
        goto L_0x01f8;
    L_0x0248:
        r2 = move-exception;
        goto L_0x01dc;
    L_0x024a:
        r3 = move-exception;
        goto L_0x017c;
    L_0x024d:
        r2 = move-exception;
        r2 = r12;
        goto L_0x0164;
    L_0x0251:
        r4 = move-exception;
        goto L_0x0164;
    L_0x0254:
        r2 = move-exception;
        goto L_0x014e;
    L_0x0257:
        r2 = move-exception;
        goto L_0x0127;
    L_0x025a:
        r3 = move-exception;
        goto L_0x00db;
    L_0x025d:
        r5 = move-exception;
        goto L_0x00a8;
    L_0x0260:
        r2 = move-exception;
        goto L_0x006c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.base.wa.e.i.a(java.lang.String, int, java.lang.String, int, int, java.lang.String, java.util.List, java.util.HashMap, java.lang.String, com.uc.base.wa.e):boolean");
    }

    private boolean a(e eVar, c cVar, int i, int i2, String str, List<String> list, HashMap<String, String> hashMap, String str2, e eVar2) {
        String stringBuilder;
        long j = cVar.a;
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        String str3 = "";
        if (eVar2 != null) {
            HashMap a = eVar2.a.a();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str2).append("|").append((String) a.get("ev_ct")).append("|").append((String) a.get("ev_ac"));
            if (str != null) {
                stringBuilder2.append("|").append((String) a.get(str));
            }
            if (list != null) {
                for (String str32 : list) {
                    stringBuilder2.append("`").append(str32).append("=").append((String) a.get(str32));
                }
            }
            HashMap hashMap2 = eVar2.a.d;
            if (hashMap2 != null) {
                for (Entry entry : hashMap2.entrySet()) {
                    stringBuilder2.append("`").append((String) entry.getKey()).append("=").append((String) entry.getValue());
                }
            }
            if (hashMap != null) {
                for (Entry entry2 : hashMap.entrySet()) {
                    stringBuilder2.append("`").append((String) entry2.getKey()).append("=").append((String) entry2.getValue());
                }
            }
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = str32;
        }
        try {
            boolean add;
            byte[] bArr = null;
            try {
                bArr = c.a().a(stringBuilder.getBytes("utf-8"));
            } catch (Throwable e) {
                Log.e("gzm_SessionService", "", e);
                c.a().b(e.toString());
            }
            if (b.l() != null) {
                new StringBuilder("node -> id=").append(cVar.a).append(", name=").append(cVar.b).append(", token=").append(cVar.c).append(", config=").append(cVar.e).append(", step=").append(i).append(", value=").append(stringBuilder);
            }
            b bVar = new b(cVar, bArr, i, currentTimeMillis, i2);
            boolean a2 = eVar.a(bVar);
            if (a2) {
                add = cVar.f.add(bVar);
            } else {
                Log.e("gzm_SessionService", "add sessionItem fail");
                add = a2;
            }
            this.d.put(Long.valueOf(j), Integer.valueOf(currentTimeMillis + i2));
            return add;
        } catch (Throwable e2) {
            Log.e("gzm_SessionService", "", e2);
            c.a().b(e2.toString());
            return false;
        }
    }
}
