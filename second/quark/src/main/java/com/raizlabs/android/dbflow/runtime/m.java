package com.raizlabs.android.dbflow.runtime;

import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.structure.a;
import com.raizlabs.android.dbflow.structure.e;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: ProGuard */
public final class m implements b {
    public static m a;
    private final Map<Class<?>, Set<Object>> b = new LinkedHashMap();
    private final Map<Class<?>, Set<d>> c = new LinkedHashMap();
    private final c d = new l();

    public m() {
        if (a != null) {
            throw new IllegalStateException("Cannot instantiate more than one DirectNotifier. Use DirectNotifier.get()");
        }
    }

    public final <T> void a(@NonNull T t, @NonNull a<T> aVar, @NonNull e eVar) {
        Set set = (Set) this.b.get(aVar.i());
        if (set != null) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final <T> void a(@NonNull Class<T> cls, @NonNull e eVar) {
        Set set = (Set) this.c.get(cls);
        if (set != null) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }
}
