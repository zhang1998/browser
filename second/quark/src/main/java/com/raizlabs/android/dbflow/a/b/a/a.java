package com.raizlabs.android.dbflow.a.b.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.raizlabs.android.dbflow.a.b.b;
import com.raizlabs.android.dbflow.a.b.e;
import com.raizlabs.android.dbflow.a.b.f;
import com.raizlabs.android.dbflow.a.b.h;
import com.raizlabs.android.dbflow.a.b.i;
import java.util.Collection;

/* compiled from: ProGuard */
public class a<T> implements b<a<T>>, e<T>, f {
    public static final a<String> a = new a(i.a("*").a());
    public static final a<?> b = new a(i.a("?").a());
    @Nullable
    final Class<?> c;
    public i d;

    public a(i iVar) {
        this.c = null;
        this.d = iVar;
    }

    public a(@Nullable Class<?> cls, @Nullable String str) {
        this.c = cls;
        if (str != null) {
            this.d = new h(str).a();
        }
    }

    @NonNull
    public i b() {
        return this.d;
    }

    public final String a() {
        return b().a();
    }

    public String toString() {
        return b().toString();
    }

    @NonNull
    public final b<T> a(@NonNull String str) {
        return b.a(b()).a(str);
    }

    @NonNull
    public final b<T> a(@Nullable T t) {
        return b.a(b()).a((Object) t);
    }

    @NonNull
    public final b<T> b(@Nullable T t) {
        return b.a(b()).b((Object) t);
    }

    @NonNull
    public final b<T> c(@NonNull T t) {
        return b.a(b()).d(t);
    }

    @NonNull
    public final com.raizlabs.android.dbflow.a.b.a<T> a(@NonNull Collection<T> collection) {
        return new com.raizlabs.android.dbflow.a.b.a(b.a(b()), collection);
    }
}
