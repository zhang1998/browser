package com.ucweb.a;

import com.d.a.b.d;
import com.uc.apollo.impl.SettingsConst;
import com.ucweb.a.a.c;
import com.ucweb.a.b.e;
import com.ucweb.common.util.h.m;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class r implements d {
    private static final String b = (c.a ? "http://puds.test.uae.uc.cn/upgrade/index.xhtml?from=pb_query" : "http://puds.ucweb.com/upgrade/index.xhtml");
    public com.ucweb.a.b.c a = this;
    private HashMap<String, j> c;
    private HashMap<String, v> d;
    private long e;
    private t f;
    private boolean g;
    private p h;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.ucweb.a.r r12, com.ucweb.a.s r13) {
        /*
        r10 = 0;
        r3 = 0;
        r2 = 1;
        r12.b();
        if (r13 == 0) goto L_0x00c7;
    L_0x0009:
        r0 = r13.a;
        r1 = new java.lang.StringBuilder;
        r4 = "[";
        r1.<init>(r4);
        r0 = r1.append(r0);
        r1 = "]开始检查更新.";
        r0.append(r1);
        r5 = r13.a;
        if (r5 == 0) goto L_0x00c7;
    L_0x001f:
        r0 = r12.b(r5);
        if (r0 != 0) goto L_0x00c7;
    L_0x0025:
        r0 = com.ucweb.a.a.c.c();
        r0 = r0.r();
        r6 = r5.equalsIgnoreCase(r0);
        r7 = r13.f;
        r0 = r13.b;
        if (r0 != r2) goto L_0x00c8;
    L_0x0037:
        r1 = r2;
    L_0x0038:
        r4 = 0;
        r0 = r12.c;
        r0 = r0.get(r5);
        r0 = (com.ucweb.a.j) r0;
        if (r0 == 0) goto L_0x0112;
    L_0x0043:
        if (r1 == 0) goto L_0x0112;
    L_0x0045:
        if (r7 != 0) goto L_0x0112;
    L_0x0047:
        if (r6 == 0) goto L_0x00cd;
    L_0x0049:
        r6 = r12.e;
        r1 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r1 >= 0) goto L_0x0055;
    L_0x004f:
        r6 = com.ucweb.a.i.a();
        r12.e = r6;
    L_0x0055:
        r6 = r12.e;
        r1 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r1 >= 0) goto L_0x00a5;
    L_0x005b:
        r6 = java.lang.System.currentTimeMillis();
        r12.e = r6;
        r6 = r12.e;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r8 = com.ucweb.a.a.c.c();
        r8 = r8.I();
        r1 = r1.append(r8);
        r8 = "upgrade_firstcheck";
        r1 = r1.append(r8);
        r1 = r1.toString();
        r8 = new java.io.File;
        r8.<init>(r1);
        r1 = r8.exists();
        if (r1 != 0) goto L_0x008c;
    L_0x0089:
        r8.mkdirs();	 Catch:{ Exception -> 0x016a }
    L_0x008c:
        r1 = r8.exists();
        if (r1 == 0) goto L_0x0095;
    L_0x0092:
        r8.delete();
    L_0x0095:
        r1 = java.lang.String.valueOf(r6);
        r1 = r1.getBytes();
        r6 = com.ucweb.a.a.c.b();
        r7 = r1.length;
        r6.a(r8, r1, r7);
    L_0x00a5:
        r6 = java.lang.System.currentTimeMillis();
        r8 = r12.e;
        r6 = r6 - r8;
        r6 = java.lang.Math.abs(r6);
        r1 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));
        if (r1 >= 0) goto L_0x00cb;
    L_0x00b4:
        r1 = r2;
    L_0x00b5:
        if (r1 == 0) goto L_0x00cd;
    L_0x00b7:
        r0 = new java.lang.StringBuilder;
        r1 = "[";
        r0.<init>(r1);
        r0 = r0.append(r5);
        r1 = "]没有必要检查更新，因为还没到达首次检查时间点.";
        r0.append(r1);
    L_0x00c7:
        return;
    L_0x00c8:
        r1 = r3;
        goto L_0x0038;
    L_0x00cb:
        r1 = r3;
        goto L_0x00b5;
    L_0x00cd:
        r1 = r0.e;
        r6 = r0.b;
        r7 = new java.lang.StringBuilder;
        r8 = "[";
        r7.<init>(r8);
        r1 = r7.append(r1);
        r7 = "]检查更新周期(小时)";
        r1 = r1.append(r7);
        r6 = r6 * 24;
        r1.append(r6);
        r6 = java.lang.System.currentTimeMillis();
        r8 = r0.a;
        r6 = r6 - r8;
        r6 = java.lang.Math.abs(r6);
        r1 = r0.b;
        r8 = (long) r1;
        r10 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r8 = r8 * r10;
        r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r1 >= 0) goto L_0x0110;
    L_0x00fd:
        if (r2 == 0) goto L_0x0112;
    L_0x00ff:
        r0 = new java.lang.StringBuilder;
        r1 = "[";
        r0.<init>(r1);
        r0 = r0.append(r5);
        r1 = "]没有必要检查更新，因为还没到达下一次的检查时间点.";
        r0.append(r1);
        goto L_0x00c7;
    L_0x0110:
        r2 = r3;
        goto L_0x00fd;
    L_0x0112:
        if (r0 == 0) goto L_0x016d;
    L_0x0114:
        r0 = r0.c;
    L_0x0116:
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 == 0) goto L_0x0136;
    L_0x011c:
        r0 = r12.c;
        r1 = com.ucweb.a.a.c.c();
        r1 = r1.r();
        r0 = r0.get(r1);
        r0 = (com.ucweb.a.j) r0;
        if (r0 == 0) goto L_0x015f;
    L_0x012e:
        r0 = r0.c;
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x015f;
    L_0x0136:
        r1 = new com.ucweb.a.v;
        r1.<init>(r13);
        r1.b = r0;
        r2 = r12.d;
        monitor-enter(r2);
        r0 = r12.d;	 Catch:{ all -> 0x0162 }
        r3 = r1.a;	 Catch:{ all -> 0x0162 }
        r3 = r3.a;	 Catch:{ all -> 0x0162 }
        r0.put(r3, r1);	 Catch:{ all -> 0x0162 }
        monitor-exit(r2);	 Catch:{ all -> 0x0162 }
        r0 = r12.f;
        r0.b = r1;
        r2 = r1.d();
        if (r2 != 0) goto L_0x0165;
    L_0x0154:
        r2 = r0.c;
        if (r2 == 0) goto L_0x00c7;
    L_0x0158:
        r0 = r0.c;
        r0.a(r1);
        goto L_0x00c7;
    L_0x015f:
        r0 = b;
        goto L_0x0136;
    L_0x0162:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0162 }
        throw r0;
    L_0x0165:
        r0.a();
        goto L_0x00c7;
    L_0x016a:
        r1 = move-exception;
        goto L_0x008c;
    L_0x016d:
        r0 = r4;
        goto L_0x0116;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucweb.a.r.a(com.ucweb.a.r, com.ucweb.a.s):void");
    }

    private r() {
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = -1;
        this.g = false;
        this.f = new t();
        this.f.c = this;
    }

    public static r a() {
        return q.a;
    }

    private static j a(String str) {
        j jVar = new j();
        jVar.a = System.currentTimeMillis();
        jVar.e = str;
        jVar.b = 7;
        jVar.d = 72;
        return jVar;
    }

    private void b() {
        if (!this.g) {
            Map b = i.b();
            if (b == null || b.size() <= 0) {
                this.c.put(c.c().r(), a(c.c().r()));
                a((int) SettingsConst.GLOBAL_SETTINGS);
            } else {
                this.c.putAll(b);
            }
            this.g = true;
        }
    }

    private void a(int i) {
        if (this.h != null) {
            m.c(this.h);
        }
        this.h = new p(this.c);
        m.a(0, this.h, (long) i);
    }

    public final void a(s sVar) {
        m.a(0, new m(this, sVar));
    }

    private v b(String str) {
        v vVar;
        synchronized (this.d) {
            vVar = (v) this.d.get(str);
        }
        return vVar;
    }

    private void b(e eVar) {
        if (eVar != null) {
            synchronized (this.d) {
                this.d.remove(eVar.c());
            }
        }
    }

    public static void a(u uVar) {
        if (uVar != null) {
            String str = uVar.m;
            if (str != null) {
                File file = new File(c.c().I() + "upgrade_log");
                if (!file.exists()) {
                    try {
                        file.mkdirs();
                    } catch (Exception e) {
                    }
                }
                if (file.exists()) {
                    file.delete();
                }
                byte[] bytes = str.getBytes();
                c.b().a(file, bytes, bytes.length);
            }
        }
    }

    private void c(e eVar) {
        if (eVar != null) {
            u uVar = new u();
            uVar.a = eVar.c();
            uVar.i = eVar.b();
            m.a(2, new o(this, uVar));
        }
    }

    public final void a(e eVar) {
        b(eVar);
        c(eVar);
    }

    public final Object a(byte[] bArr) {
        byte[] bArr2;
        int i = 1;
        if (bArr == null) {
            bArr2 = null;
        } else if (bArr.length < 16) {
            bArr2 = null;
        } else if (bArr[0] != (byte) 96) {
            bArr2 = null;
        } else {
            int i2 = (bArr[2] == (byte) 1 || bArr[2] == (byte) 11 || bArr[2] == (byte) 31) ? 1 : 0;
            if (bArr[1] != (byte) 1) {
                i = 0;
            }
            byte[] bArr3 = new byte[(bArr.length - 16)];
            System.arraycopy(bArr, 16, bArr3, 0, bArr3.length);
            if (i2 != 0) {
                bArr2 = c.b().b(bArr3);
            } else {
                bArr2 = bArr3;
            }
            if (i != 0) {
                bArr2 = i.a(bArr2);
            }
        }
        d dVar = new d();
        if (dVar.a(bArr2)) {
            return dVar;
        }
        return null;
    }

    public final void a(e eVar, Object obj) {
        b(eVar);
        if (obj instanceof d) {
            u uVar = new u((d) obj);
            String c = eVar.c();
            uVar.a = c;
            uVar.i = eVar.b();
            String str = uVar.a;
            new StringBuilder("[").append(str).append("]match_type:").append(uVar.k).append("mFullLink:").append(uVar.c);
            new StringBuilder("[").append(str).append("]display_type:").append(uVar.l);
            new StringBuilder("[").append(str).append("]upgrade_mode:").append(uVar.i);
            new StringBuilder("[").append(str).append("]bgcolor:").append(uVar.s);
            new StringBuilder("[").append(str).append("]body:").append(uVar.q);
            new StringBuilder("[").append(str).append("]footer:").append(uVar.r);
            new StringBuilder("[").append(str).append("]header:").append(uVar.p);
            new StringBuilder("[").append(str).append("]description:").append(uVar.g);
            new StringBuilder("[").append(str).append("]image:").append(uVar.t == null ? "null" : "[valid_data]");
            m.a(2, new n(this, uVar));
            String r = c.c().r();
            b();
            j jVar = (j) this.c.get(r);
            if (jVar == null) {
                jVar = a(r);
            }
            jVar.a = System.currentTimeMillis();
            a(10);
            if (!c.c().r().equals(c)) {
                jVar = (j) this.c.get(c);
                if (jVar == null) {
                    jVar = a(c);
                    this.c.put(c, jVar);
                }
                jVar.a = System.currentTimeMillis();
                a(50);
            }
            if (c.c().r().equals(c) && !uVar.a()) {
                jVar = (j) this.c.get(c);
                if (jVar != null) {
                    jVar.a = System.currentTimeMillis();
                } else {
                    jVar = new j();
                    jVar.a = System.currentTimeMillis();
                    jVar.e = c;
                    jVar.d = 72;
                    jVar.b = 7;
                    this.c.put(c, jVar);
                }
                a(50);
                return;
            }
            return;
        }
        c(eVar);
    }
}
