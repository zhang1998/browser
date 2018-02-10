package com.raizlabs.android.dbflow.a.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.raizlabs.android.dbflow.a.e;
import com.raizlabs.android.dbflow.a.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
public final class g extends c implements f, Iterable<d> {
    @NonNull
    public final List<d> g;
    boolean h;
    boolean i;
    private e j;
    private boolean k;

    @NonNull
    public static g i() {
        return new g((byte) 0);
    }

    public static g j() {
        g gVar = new g((byte) 0);
        gVar.k = false;
        gVar.h = true;
        return gVar;
    }

    private g() {
        super(null);
        this.g = new ArrayList();
        this.k = true;
        this.e = "AND";
    }

    private g(byte b) {
        this();
    }

    @NonNull
    public final g a(d... dVarArr) {
        for (d a : dVarArr) {
            a("AND", a);
        }
        return this;
    }

    @NonNull
    public final g a(String str, @Nullable d dVar) {
        if (dVar != null) {
            if (this.g.size() > 0) {
                ((d) this.g.get(this.g.size() - 1)).b(str);
            }
            this.g.add(dVar);
            this.h = true;
        }
        return this;
    }

    public final void a(@NonNull e eVar) {
        int size = this.g.size();
        if (this.k && size > 0) {
            eVar.b((Object) "(");
        }
        int i = 0;
        while (i < size) {
            d dVar = (d) this.g.get(i);
            dVar.a(eVar);
            if (!this.i && dVar.e() && i < size - 1) {
                eVar.a(dVar.d());
            } else if (i < size - 1) {
                eVar.b((Object) ", ");
            }
            i++;
        }
        if (this.k && size > 0) {
            eVar.b((Object) ")");
        }
    }

    public final String a() {
        if (this.h) {
            this.j = k();
        }
        return this.j == null ? "" : this.j.toString();
    }

    public final String toString() {
        return k().toString();
    }

    public final Iterator<d> iterator() {
        return this.g.iterator();
    }

    private e k() {
        e eVar = new e();
        a(eVar);
        return eVar;
    }
}
