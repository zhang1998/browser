package com.raizlabs.android.dbflow.a.b;

import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.structure.database.b;
import com.raizlabs.android.dbflow.structure.database.c;
import java.util.List;

/* compiled from: ProGuard */
public abstract class s<TModel> extends j<TModel> implements t<TModel> {
    protected s(Class<TModel> cls) {
        super(cls);
    }

    @NonNull
    public final u<TModel> a(@NonNull d... dVarArr) {
        return new u(this, dVarArr);
    }

    public final c i() {
        return a(new d[0]).i();
    }

    public final c d(@NonNull b bVar) {
        return a(new d[0]).d(bVar);
    }

    public final long h() {
        return a(new d[0]).h();
    }

    public final long b(@NonNull b bVar) {
        return a(new d[0]).b(bVar);
    }

    public final long a(@NonNull b bVar) {
        return a(new d[0]).a(bVar);
    }

    @NonNull
    public final u<TModel> a(int i) {
        u<TModel> a = a(new d[0]);
        a.d = i;
        return a;
    }

    @NonNull
    public final List<TModel> c() {
        a("query");
        return super.c();
    }

    public final TModel d() {
        a("query");
        a(1);
        return super.d();
    }

    private void a(String str) {
        if (!(k() instanceof o)) {
            throw new IllegalArgumentException("Please use " + str + "(). The beginning is not a Select");
        }
    }
}
