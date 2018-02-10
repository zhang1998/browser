package com.bumptech.glide.b.b.a;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class j<K extends s, V> {
    private final i<K, V> a = new i();
    private final Map<K, i<K, V>> b = new HashMap();

    j() {
    }

    public final void a(K k, V v) {
        i iVar = (i) this.b.get(k);
        if (iVar == null) {
            iVar = new i(k);
            b(iVar);
            iVar.d = this.a.d;
            iVar.c = this.a;
            a(iVar);
            this.b.put(k, iVar);
        } else {
            k.a();
        }
        if (iVar.b == null) {
            iVar.b = new ArrayList();
        }
        iVar.b.add(v);
    }

    @Nullable
    public final V a(K k) {
        i iVar = (i) this.b.get(k);
        if (iVar == null) {
            iVar = new i(k);
            this.b.put(k, iVar);
        } else {
            k.a();
        }
        b(iVar);
        iVar.d = this.a;
        iVar.c = this.a.c;
        a(iVar);
        return iVar.a();
    }

    @Nullable
    public final V a() {
        for (i iVar = this.a.d; !iVar.equals(this.a); iVar = iVar.d) {
            V a = iVar.a();
            if (a != null) {
                return a;
            }
            b(iVar);
            this.b.remove(iVar.a);
            ((s) iVar.a).a();
        }
        return null;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("GroupedLinkedMap( ");
        Object obj = null;
        for (i iVar = this.a.c; !iVar.equals(this.a); iVar = iVar.c) {
            obj = 1;
            stringBuilder.append('{').append(iVar.a).append(':').append(iVar.b()).append("}, ");
        }
        if (obj != null) {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }
        return stringBuilder.append(" )").toString();
    }

    private static <K, V> void a(i<K, V> iVar) {
        iVar.c.d = iVar;
        iVar.d.c = iVar;
    }

    private static <K, V> void b(i<K, V> iVar) {
        iVar.d.c = iVar.c;
        iVar.c.d = iVar.d;
    }
}
