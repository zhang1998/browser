package com.ucpro.feature.z.f.a;

import android.text.TextUtils;
import com.uc.browser.a;
import com.uc.browser.b;
import hugo.weaving.DebugLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* compiled from: ProGuard */
public final class c {
    private static final String c = a.class.getSimpleName();
    private static c d;
    private static Random g = null;
    public List<g> a = new ArrayList();
    public a b = new a();
    private b e = new b(this);
    private boolean f = false;

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (d == null) {
                d = new c();
            }
            cVar = d;
        }
        return cVar;
    }

    private c() {
    }

    public final void b() {
        this.e.removeMessages(1);
        this.e.sendEmptyMessage(1);
    }

    @DebugLog
    public final int a(String str) {
        int i = -1;
        d();
        com.ucweb.common.util.c.a((CharSequence) str);
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = this.b.b;
            if (arrayList != null) {
                f fVar = null;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    f fVar2 = (f) it.next();
                    if (fVar2.c.equalsIgnoreCase(str)) {
                        fVar = fVar2;
                        break;
                    }
                }
                if (fVar == null) {
                    Object fVar3 = new f();
                    int e = e();
                    fVar3.b = e;
                    fVar3.c = str;
                    fVar3.e = 1;
                    fVar3.d = System.currentTimeMillis();
                    com.ucweb.common.util.c.a(fVar3);
                    ArrayList arrayList2 = this.b.b;
                    if (arrayList2 != null) {
                        if (arrayList2.size() >= 10 && arrayList2 != null) {
                            int i2 = 1;
                            long j = ((f) arrayList2.get(0)).d;
                            int i3 = 0;
                            while (i2 < arrayList2.size()) {
                                long j2;
                                int i4;
                                long j3 = ((f) arrayList2.get(i2)).d;
                                if (j3 < j) {
                                    j2 = j3;
                                    i4 = i2;
                                } else {
                                    i4 = i3;
                                    j2 = j;
                                }
                                i2++;
                                i3 = i4;
                                j = j2;
                            }
                            arrayList2.remove(i3);
                        }
                        arrayList2.add(0, fVar3);
                    }
                    i = e;
                } else {
                    fVar.e++;
                    fVar.d = System.currentTimeMillis();
                    i = fVar.b;
                    arrayList.remove(fVar);
                    arrayList.add(0, fVar);
                }
                b();
            }
        }
        return i;
    }

    @DebugLog
    public final ArrayList<f> a(e eVar, int i) {
        com.ucweb.common.util.c.b(i > 0);
        if (i <= 0) {
            return new ArrayList();
        }
        d();
        Object obj = this.b.b;
        if (obj == null) {
            return new ArrayList();
        }
        if (eVar == null) {
            return new ArrayList(obj);
        }
        ArrayList<f> arrayList = new ArrayList();
        Iterator it = obj.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar != null && eVar.a(fVar)) {
                f fVar2 = new f();
                fVar2.b = fVar.b;
                fVar2.c = fVar.c;
                fVar2.d = fVar.d;
                fVar2.e = fVar.e;
                arrayList.add(fVar2);
                if (arrayList.size() >= i) {
                    break;
                }
            }
        }
        return arrayList;
    }

    public final void c() {
        d();
        ArrayList arrayList = this.b.b;
        if (arrayList != null && arrayList.size() > 0) {
            arrayList.clear();
            b();
        }
        for (g a : this.a) {
            a.a();
        }
    }

    private static synchronized int e() {
        int currentTimeMillis;
        synchronized (c.class) {
            if (g == null) {
                g = new Random();
            }
            currentTimeMillis = ((int) System.currentTimeMillis()) + g.nextInt();
        }
        return currentTimeMillis;
    }

    private void d() {
        if (!this.f) {
            try {
                this.b = (a) b.a("history", "input_history", a.class);
            } catch (a e) {
            }
            Collections.sort(this.b.b, new d(this));
            this.f = true;
        }
    }
}
