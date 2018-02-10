package com.bumptech.glide.b.b.a;

import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.bumptech.glide.util.j;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: ProGuard */
public final class n implements b {
    private final j<l, Object> a;
    private final m b;
    private final Map<Class<?>, NavigableMap<Integer, Integer>> c;
    private final Map<Class<?>, a<?>> d;
    private final int e;
    private int f;

    @VisibleForTesting
    public n() {
        this.a = new j();
        this.b = new m();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = 4194304;
    }

    public n(int i) {
        this.a = new j();
        this.b = new m();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = i;
    }

    public final synchronized <T> void a(T t, Class<T> cls) {
        Object obj;
        a b = b((Class) cls);
        int a = b.a((Object) t);
        int b2 = a * b.b();
        if (b2 <= this.e / 2) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            l a2 = this.b.a(a, cls);
            this.a.a(a2, t);
            NavigableMap a3 = a((Class) cls);
            Integer num = (Integer) a3.get(Integer.valueOf(a2.a));
            a3.put(Integer.valueOf(a2.a), Integer.valueOf(num == null ? 1 : num.intValue() + 1));
            this.f += b2;
            b(this.e);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T a(int r8, java.lang.Class<T> r9) {
        /*
        r7 = this;
        r6 = 2;
        r1 = 1;
        r2 = 0;
        r4 = r7.b(r9);
        monitor-enter(r7);
        r0 = r7.a(r9);	 Catch:{ all -> 0x0084 }
        r3 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x0084 }
        r0 = r0.ceilingKey(r3);	 Catch:{ all -> 0x0084 }
        r0 = (java.lang.Integer) r0;	 Catch:{ all -> 0x0084 }
        if (r0 == 0) goto L_0x007b;
    L_0x0018:
        r3 = r7.f;	 Catch:{ all -> 0x0084 }
        if (r3 == 0) goto L_0x0023;
    L_0x001c:
        r3 = r7.e;	 Catch:{ all -> 0x0084 }
        r5 = r7.f;	 Catch:{ all -> 0x0084 }
        r3 = r3 / r5;
        if (r3 < r6) goto L_0x0079;
    L_0x0023:
        r3 = r1;
    L_0x0024:
        if (r3 != 0) goto L_0x002e;
    L_0x0026:
        r3 = r0.intValue();	 Catch:{ all -> 0x0084 }
        r5 = r8 * 8;
        if (r3 > r5) goto L_0x007b;
    L_0x002e:
        if (r1 == 0) goto L_0x007d;
    L_0x0030:
        r1 = r7.b;	 Catch:{ all -> 0x0084 }
        r0 = r0.intValue();	 Catch:{ all -> 0x0084 }
        r0 = r1.a(r0, r9);	 Catch:{ all -> 0x0084 }
    L_0x003a:
        r1 = r7.a;	 Catch:{ all -> 0x0084 }
        r0 = r1.a(r0);	 Catch:{ all -> 0x0084 }
        if (r0 == 0) goto L_0x0057;
    L_0x0042:
        r1 = r7.f;	 Catch:{ all -> 0x0084 }
        r2 = r4.a(r0);	 Catch:{ all -> 0x0084 }
        r3 = r4.b();	 Catch:{ all -> 0x0084 }
        r2 = r2 * r3;
        r1 = r1 - r2;
        r7.f = r1;	 Catch:{ all -> 0x0084 }
        r1 = r4.a(r0);	 Catch:{ all -> 0x0084 }
        r7.b(r1, r9);	 Catch:{ all -> 0x0084 }
    L_0x0057:
        monitor-exit(r7);	 Catch:{ all -> 0x0084 }
        if (r0 != 0) goto L_0x0078;
    L_0x005a:
        r0 = r4.a();
        r0 = android.util.Log.isLoggable(r0, r6);
        if (r0 == 0) goto L_0x0074;
    L_0x0064:
        r0 = new java.lang.StringBuilder;
        r1 = "Allocated ";
        r0.<init>(r1);
        r0 = r0.append(r8);
        r1 = " bytes";
        r0.append(r1);
    L_0x0074:
        r0 = r4.a(r8);
    L_0x0078:
        return r0;
    L_0x0079:
        r3 = r2;
        goto L_0x0024;
    L_0x007b:
        r1 = r2;
        goto L_0x002e;
    L_0x007d:
        r0 = r7.b;	 Catch:{ all -> 0x0084 }
        r0 = r0.a(r8, r9);	 Catch:{ all -> 0x0084 }
        goto L_0x003a;
    L_0x0084:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x0084 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.b.b.a.n.a(int, java.lang.Class):T");
    }

    public final synchronized void a() {
        b(0);
    }

    public final synchronized void a(int i) {
        if (i >= 40) {
            a();
        } else if (i >= 20) {
            b(this.e / 2);
        }
    }

    private void b(int i) {
        while (this.f > i) {
            Object a = this.a.a();
            j.a(a, "Argument must not be null");
            a b = b(a.getClass());
            this.f -= b.a(a) * b.b();
            b(b.a(a), a.getClass());
            if (Log.isLoggable(b.a(), 2)) {
                new StringBuilder("evicted: ").append(b.a(a));
            }
        }
    }

    private void b(int i, Class<?> cls) {
        NavigableMap a = a((Class) cls);
        Integer num = (Integer) a.get(Integer.valueOf(i));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
        } else if (num.intValue() == 1) {
            a.remove(Integer.valueOf(i));
        } else {
            a.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
        }
    }

    private NavigableMap<Integer, Integer> a(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = (NavigableMap) this.c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        NavigableMap treeMap = new TreeMap();
        this.c.put(cls, treeMap);
        return treeMap;
    }

    private <T> a<T> b(Class<T> cls) {
        a<T> aVar = (a) this.d.get(cls);
        if (aVar == null) {
            if (cls.equals(int[].class)) {
                aVar = new k();
            } else if (cls.equals(byte[].class)) {
                aVar = new h();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.d.put(cls, aVar);
        }
        return aVar;
    }
}
