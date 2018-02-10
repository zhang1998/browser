package com.raizlabs.android.dbflow.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.raizlabs.android.dbflow.a.c.a;
import com.raizlabs.android.dbflow.runtime.b;
import com.raizlabs.android.dbflow.runtime.e;
import com.raizlabs.android.dbflow.structure.database.d;
import com.raizlabs.android.dbflow.structure.database.l;
import com.raizlabs.android.dbflow.structure.database.transaction.f;
import com.raizlabs.android.dbflow.structure.database.transaction.v;
import com.raizlabs.android.dbflow.structure.h;
import com.raizlabs.android.dbflow.structure.i;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public abstract class c {
    public final Map<Integer, List<a>> a = new HashMap();
    public final Map<Class<?>, com.raizlabs.android.dbflow.structure.a> b = new HashMap();
    public final Map<Class<?>, h> c = new LinkedHashMap();
    final Map<Class<?>, i> d = new LinkedHashMap();
    @NonNull
    public e e;
    @Nullable
    b f;
    private final Map<String, Class<?>> g = new HashMap();
    private d h;
    private com.raizlabs.android.dbflow.structure.database.e i;
    private boolean j = false;
    @Nullable
    private k k = ((k) FlowManager.a().b.get(e()));

    @NonNull
    public abstract String b();

    public abstract int d();

    @NonNull
    public abstract Class<?> e();

    public c() {
        if (this.k != null) {
            for (g gVar : this.k.e.values()) {
                com.raizlabs.android.dbflow.structure.a aVar = (com.raizlabs.android.dbflow.structure.a) this.b.get(gVar.a);
                if (aVar != null) {
                    if (gVar.d != null) {
                        aVar.d = gVar.d;
                    }
                    if (gVar.c != null) {
                        aVar.c = gVar.c;
                    }
                    if (gVar.b != null) {
                        aVar.b = gVar.b;
                        aVar.b.a = aVar;
                    }
                }
            }
            this.i = this.k.d;
        }
        if (this.k == null || this.k.c == null) {
            this.e = new v(this);
        } else {
            this.e = this.k.c.a();
        }
    }

    protected final <T> void a(com.raizlabs.android.dbflow.structure.a<T> aVar, f fVar) {
        fVar.putDatabaseForTable(aVar.i(), this);
        this.g.put(aVar.j_(), aVar.i());
        this.b.put(aVar.i(), aVar);
    }

    @NonNull
    private synchronized d f() {
        if (this.h == null) {
            k kVar = (k) FlowManager.a().b.get(e());
            if (kVar == null || kVar.a == null) {
                this.h = new l(this, this.i);
            } else {
                this.h = kVar.a.a();
            }
            this.h.a();
        }
        return this.h;
    }

    @NonNull
    public final com.raizlabs.android.dbflow.structure.database.b a() {
        return f().b();
    }

    @NonNull
    public final f a(@NonNull com.raizlabs.android.dbflow.structure.database.transaction.a aVar) {
        return new f(aVar, this);
    }

    @NonNull
    public final String c() {
        String str;
        StringBuilder append = new StringBuilder().append(b());
        if (com.raizlabs.android.dbflow.a.a("db")) {
            str = ".db";
        } else {
            str = "";
        }
        return append.append(str).toString();
    }
}
