package com.ucpro.base.e;

import android.os.Message;
import android.util.Log;
import com.ucpro.base.a.a;
import com.ucpro.base.a.i;
import com.ucweb.common.util.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProGuard */
public final class b implements a, i, d {
    private com.ucpro.base.c.b a;
    private ConcurrentHashMap<Class<? extends e>, h> b = new ConcurrentHashMap();
    private ConcurrentHashMap<Class<? extends e>, e> c = new ConcurrentHashMap();

    public b(com.ucpro.base.c.b bVar) {
        c.a((Object) bVar);
        this.a = bVar;
    }

    public final void a(int[] iArr, int[] iArr2, Class<? extends e> cls) {
        h hVar;
        boolean z = true;
        if (iArr != null) {
            c.a((Object) iArr);
            c.b(iArr.length > 0);
            synchronized (this.b) {
                if (this.b.containsKey(cls)) {
                    hVar = (h) this.b.get(cls);
                    if (hVar.a != null) {
                        c.a("double registration: " + cls);
                    } else {
                        boolean z2;
                        if (hVar.b != null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        c.b(z2);
                        hVar.a = a(iArr);
                    }
                } else {
                    hVar = new h();
                    hVar.a = a(iArr);
                    this.b.put(cls, hVar);
                }
            }
        }
        if (iArr2 != null) {
            boolean z3;
            c.a((Object) iArr2);
            if (iArr2.length > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            c.b(z3);
            synchronized (this.b) {
                if (this.b.containsKey(cls)) {
                    hVar = (h) this.b.get(cls);
                    if (hVar.b != null) {
                        c.a("double registration: " + cls);
                    } else {
                        if (hVar.a == null) {
                            z = false;
                        }
                        c.b(z);
                        hVar.b = a(iArr2);
                    }
                } else {
                    hVar = new h();
                    hVar.b = a(iArr2);
                    this.b.put(cls, hVar);
                }
            }
        }
    }

    private static List<Integer> a(int[] iArr) {
        return new c(iArr);
    }

    public final void a(Message message, boolean z) {
        int i = message.what;
        ArrayList a = a(i, z);
        if (a.size() > 0) {
            Iterator it = a.iterator();
            while (it.hasNext()) {
                ((e) it.next()).b(i, message);
            }
        }
    }

    private ArrayList<e> a(int i, boolean z) {
        ArrayList<e> arrayList = new ArrayList();
        for (Entry entry : this.b.entrySet()) {
            List list = ((h) entry.getValue()).b;
            if (list != null && list.contains(Integer.valueOf(i))) {
                Class cls = (Class) entry.getKey();
                e eVar = (e) this.c.get(cls);
                if (eVar == null && z) {
                    synchronized (this.c) {
                        try {
                            eVar = (e) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                            a(eVar);
                            this.c.put(cls, eVar);
                        } catch (Throwable e) {
                            Throwable th = e;
                            e eVar2 = eVar;
                            c.a("fail to construct controller " + cls, th);
                            eVar = eVar2;
                        }
                    }
                }
                if (r2 != null) {
                    arrayList.add(r2);
                }
            }
        }
        return arrayList;
    }

    public final void a(Message message) {
        int i = message.what;
        e a = a(i);
        if (a != null) {
            a.a(i, message);
        } else {
            c.a("not controller to handle message which id is: " + i, new Throwable());
        }
    }

    private e a(int i) {
        for (Entry entry : this.b.entrySet()) {
            List list = ((h) entry.getValue()).a;
            if (list != null && list.contains(Integer.valueOf(i))) {
                e eVar;
                Class cls = (Class) entry.getKey();
                e eVar2 = (e) this.c.get(cls);
                synchronized (this.c) {
                    if (eVar2 == null) {
                        try {
                            eVar2 = (e) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                            a(eVar2);
                            this.c.put(cls, eVar2);
                            eVar = eVar2;
                        } catch (Throwable e) {
                            Log.e("ControllerCenter", e.getMessage(), e);
                            c.a("fail to construct controller:" + e);
                        }
                    }
                    eVar = eVar2;
                }
                return eVar;
            }
        }
        return null;
    }

    private void a(e eVar) {
        eVar.a(this.a);
    }

    public final void a(g gVar) {
        if (this.c != null && !this.c.isEmpty()) {
            for (Entry entry : this.c.entrySet()) {
                e eVar = (e) entry.getValue();
                if (eVar != null) {
                    new StringBuilder().append(gVar.name()).append("---------").append(((Class) entry.getKey()).toString());
                    switch (a.a[gVar.ordinal()]) {
                        case 1:
                            eVar.q_();
                            break;
                        case 2:
                            eVar.v_();
                            break;
                        case 3:
                            eVar.h();
                            break;
                        case 4:
                            eVar.g();
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }
}
