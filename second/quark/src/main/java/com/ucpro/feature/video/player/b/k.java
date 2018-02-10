package com.ucpro.feature.video.player.b;

import android.util.SparseArray;
import com.ucpro.feature.video.player.a.i;
import com.ucpro.feature.video.player.e.b;
import com.ucpro.feature.video.player.e.c;
import com.ucpro.feature.video.player.e.d;
import com.ucpro.feature.video.player.e.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class k implements d {
    public Map<Class<?>, List<e>> a;
    private i b;
    private Map<Class<?>, c> c;
    private SparseArray<Class<?>[]> d = new SparseArray();

    public k(i iVar, Map<Class<?>, b> map) {
        this.b = iVar;
        if (map.size() > 0 && map.containsKey(s.class) && map.containsKey(r.class) && map.containsKey(f.class) && map.containsKey(m.class) && map.containsKey(l.class) && map.containsKey(y.class) && map.containsKey(n.class)) {
            this.c = new HashMap();
            this.c.put(s.class, new w(this, this, (b) map.get(s.class)));
            this.c.put(r.class, new c(this, this, (b) map.get(r.class)));
            this.c.put(f.class, new u(this, this, (b) map.get(f.class)));
            this.c.put(m.class, new z(this, this, (b) map.get(m.class)));
            this.c.put(l.class, new p(this, this, (b) map.get(l.class)));
            this.c.put(y.class, new g(this, this, (b) map.get(y.class)));
            this.c.put(n.class, new i(this, this, (b) map.get(n.class)));
            return;
        }
        throw new IllegalArgumentException("defaultStates must contains HoverStatus, PlayStatus, DisplayStatus, LockStatus, ExtendStatus");
    }

    public final boolean b(int i, com.ucpro.feature.video.player.a.b bVar, com.ucpro.feature.video.player.a.b bVar2) {
        return this.b.b(i, bVar, bVar2);
    }

    public final boolean a(int i, com.ucpro.feature.video.player.a.b bVar, com.ucpro.feature.video.player.a.b bVar2) {
        boolean z = false;
        Class[] clsArr = (Class[]) this.d.get(i);
        if (clsArr == null) {
            boolean z2 = false;
            for (Entry value : this.c.entrySet()) {
                z2 = ((c) value.getValue()).a(i, bVar, bVar2) | z2;
            }
            return z2;
        }
        for (Object obj : clsArr) {
            c cVar = (c) this.c.get(obj);
            if (cVar != null && cVar.a(i, bVar, bVar2)) {
                z = true;
                break;
            }
        }
        return z;
    }

    public final void a(int i, Class<?>... clsArr) {
        this.d.put(i, clsArr);
    }

    public final b a(Class<?> cls) {
        c cVar = (c) this.c.get(cls);
        if (cVar != null) {
            return cVar.a;
        }
        return null;
    }

    public final void a(Class<?> cls, e eVar) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        List list = (List) this.a.get(cls);
        if (list == null) {
            list = new ArrayList();
            this.a.put(cls, list);
        }
        if (!list.contains(eVar)) {
            list.add(eVar);
        }
    }

    public final void a(Class<?> cls, b bVar, b bVar2) {
        if (this.a != null) {
            List list = (List) this.a.get(cls);
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    ((e) list.get(i)).a(cls, bVar, bVar2);
                }
            }
        }
    }
}
