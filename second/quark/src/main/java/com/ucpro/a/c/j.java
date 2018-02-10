package com.ucpro.a.c;

import com.uc.webview.browser.interfaces.SettingKeys;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.i.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: ProGuard */
public final class j {
    public List<g> a;
    public HashMap<String, String> b;
    public d c;
    public c d;
    private CopyOnWriteArraySet e;
    private CopyOnWriteArraySet f;

    private j() {
        this.d = new c();
        this.e = null;
        this.f = null;
    }

    public static void a(int i) {
        p.a(SettingKeys.AdvancedPrereadOptions, i - 1);
    }

    public static void b(int i) {
        p.a(SettingKeys.PageImageQuality, i - 1);
    }

    public static void a(boolean z) {
        new StringBuilder("setEnableSmartNoImage: ").append(String.valueOf(z));
        p.a("enable_smart_no_image", z);
        b(c(z) ? t.a : t.c);
    }

    public static void b(boolean z) {
        int i;
        if (z) {
            i = 2;
        } else {
            i = 1;
        }
        p.a(SettingKeys.PageLayoutStyle, i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> d() {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = android.os.Looper.myLooper();	 Catch:{ all -> 0x0026 }
        r0.toString();	 Catch:{ all -> 0x0026 }
        r0 = com.ucpro.a.g.a();	 Catch:{ all -> 0x0026 }
        r0 = r0.c();	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x0024;
    L_0x0012:
        r0 = new java.util.concurrent.ConcurrentHashMap;	 Catch:{ all -> 0x0026 }
        r1 = 1;
        r1 = com.ucpro.a.c.p.a(r1);	 Catch:{ all -> 0x0026 }
        r0.<init>(r1);	 Catch:{ all -> 0x0026 }
        r1 = r0.isEmpty();	 Catch:{ all -> 0x0026 }
        if (r1 != 0) goto L_0x0024;
    L_0x0022:
        monitor-exit(r2);
        return r0;
    L_0x0024:
        r0 = 0;
        goto L_0x0022;
    L_0x0026:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.a.c.j.d():java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String>");
    }

    public final synchronized CopyOnWriteArraySet<String> a() {
        if (this.e == null) {
            Map d = d();
            if (!(d == null || d.isEmpty())) {
                this.e = new CopyOnWriteArraySet(d.keySet());
            }
        }
        return this.e;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String> e() {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = com.ucpro.a.g.a();	 Catch:{ all -> 0x001f }
        r0 = r0.c();	 Catch:{ all -> 0x001f }
        if (r0 == 0) goto L_0x001d;
    L_0x000b:
        r0 = new java.util.concurrent.ConcurrentHashMap;	 Catch:{ all -> 0x001f }
        r1 = 2;
        r1 = com.ucpro.a.c.p.a(r1);	 Catch:{ all -> 0x001f }
        r0.<init>(r1);	 Catch:{ all -> 0x001f }
        r1 = r0.isEmpty();	 Catch:{ all -> 0x001f }
        if (r1 != 0) goto L_0x001d;
    L_0x001b:
        monitor-exit(r2);
        return r0;
    L_0x001d:
        r0 = 0;
        goto L_0x001b;
    L_0x001f:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.a.c.j.e():java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.String>");
    }

    public final synchronized CopyOnWriteArraySet<String> b() {
        if (this.f == null) {
            Map e = e();
            if (!(e == null || e.isEmpty())) {
                this.f = new CopyOnWriteArraySet(e.keySet());
            }
        }
        return this.f;
    }

    public final void c() {
        if (this.a != null && this.a.size() > 0) {
            for (g gVar : this.a) {
                if (gVar != null) {
                    m.a(2, new a(this, gVar));
                }
            }
        }
    }

    public final void a(g gVar) {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.add(gVar);
    }

    static boolean c(boolean z) {
        if (!z || c.b()) {
            return false;
        }
        return true;
    }

    public static int d(boolean z) {
        if (!z) {
            return l.a;
        }
        if (c.b()) {
            return l.d;
        }
        return l.a;
    }
}
