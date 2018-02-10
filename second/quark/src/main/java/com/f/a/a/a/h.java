package com.f.a.a.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ProGuard */
public final class h implements f {
    final /* synthetic */ g a;
    private final Map<String, Object> b = new HashMap();
    private boolean c = false;

    public h(g gVar) {
        this.a = gVar;
    }

    public final f a(String str, String str2) {
        synchronized (this) {
            this.b.put(str, str2);
        }
        return this;
    }

    public final f a(String str, int i) {
        synchronized (this) {
            this.b.put(str, Integer.valueOf(i));
        }
        return this;
    }

    public final f a(String str, long j) {
        synchronized (this) {
            this.b.put(str, Long.valueOf(j));
        }
        return this;
    }

    public final f a(String str, float f) {
        synchronized (this) {
            this.b.put(str, Float.valueOf(f));
        }
        return this;
    }

    public final f a(String str, boolean z) {
        synchronized (this) {
            this.b.put(str, Boolean.valueOf(z));
        }
        return this;
    }

    public final f a(String str) {
        synchronized (this) {
            this.b.put(str, this);
        }
        return this;
    }

    public final f a() {
        synchronized (this) {
            this.c = true;
        }
        return this;
    }

    public final boolean b() {
        Set hashSet;
        boolean c;
        synchronized (b.c) {
            List list;
            Object obj = this.a.g.size() > 0 ? 1 : null;
            if (obj != null) {
                ArrayList arrayList = new ArrayList();
                hashSet = new HashSet(this.a.g.keySet());
                list = arrayList;
            } else {
                hashSet = null;
                list = null;
            }
            synchronized (this) {
                if (this.c) {
                    this.a.a.clear();
                    this.c = false;
                }
                for (Entry entry : this.b.entrySet()) {
                    String str = (String) entry.getKey();
                    h value = entry.getValue();
                    if (value == this) {
                        this.a.a.remove(str);
                    } else {
                        this.a.a.put(str, value);
                    }
                    if (obj != null) {
                        list.add(str);
                    }
                }
                this.b.clear();
            }
            c = this.a.e();
            if (c) {
                g gVar = this.a;
                synchronized (gVar) {
                    gVar.b = true;
                }
            }
        }
        if (obj != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                list.get(size);
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
        return c;
    }
}
