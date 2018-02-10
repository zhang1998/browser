package com.raizlabs.android.dbflow.a.b;

import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.a.e;
import com.raizlabs.android.dbflow.a.f;

/* compiled from: ProGuard */
public final class x implements f {
    @NonNull
    public final <TModel> r<TModel> a(@NonNull Class<TModel> cls) {
        return new r(this, cls);
    }

    public final String a() {
        return new e().b((Object) "DELETE").b().a();
    }
}
