package com.raizlabs.android.dbflow.a.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.raizlabs.android.dbflow.a.e;
import com.raizlabs.android.dbflow.config.s;
import com.raizlabs.android.dbflow.config.t;
import com.raizlabs.android.dbflow.d.a;

/* compiled from: ProGuard */
public final class b<T> extends c implements e<T> {
    private a g;
    private boolean h;

    @NonNull
    public static <T> b<T> a(i iVar) {
        return new b(iVar);
    }

    private b(i iVar) {
        super(iVar);
    }

    public final void a(@NonNull e eVar) {
        eVar.b(c()).b(f());
        if (this.f) {
            eVar.b(a(b(), true));
        }
        if (g() != null) {
            eVar.b().b(g());
        }
    }

    @NonNull
    public final b<T> a(@NonNull String str) {
        this.a = String.format(" %1s ", new Object[]{"LIKE"});
        return c(str);
    }

    public final b<T> c(@Nullable Object obj) {
        this.b = obj;
        this.f = true;
        return this;
    }

    @NonNull
    public final b<T> d(@NonNull T t) {
        this.a = ">";
        return c(t);
    }

    public final String a() {
        e eVar = new e();
        a(eVar);
        return eVar.a();
    }

    public final String a(Object obj, boolean z) {
        if (this.g == null) {
            return super.a(obj, z);
        }
        try {
            if (this.h) {
                obj = this.g.a(obj);
            }
        } catch (Throwable e) {
            t.a(s.d, e);
        }
        return c.a(obj, z, false);
    }

    @NonNull
    public final b<T> a(@Nullable T t) {
        this.a = "=";
        return c(t);
    }

    @NonNull
    public final b<T> b(@Nullable T t) {
        this.a = "!=";
        return c(t);
    }
}
