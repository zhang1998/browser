package com.raizlabs.android.dbflow.a.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.raizlabs.android.dbflow.a.f;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.e;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class r<TModel> extends s<TModel> {
    @NonNull
    private f b;
    @Nullable
    private i c;
    @NonNull
    private final List<q> d = new ArrayList();

    public r(@NonNull f fVar, @NonNull Class<TModel> cls) {
        super(cls);
        this.b = fVar;
    }

    @NonNull
    public final e j() {
        return this.b instanceof x ? e.DELETE : e.CHANGE;
    }

    public final String a() {
        com.raizlabs.android.dbflow.a.e b = new com.raizlabs.android.dbflow.a.e().b(this.b.a());
        if (!(this.b instanceof v)) {
            b.b((Object) "FROM ");
        }
        if (this.c == null) {
            this.c = new h(FlowManager.a(this.a)).a();
        }
        b.b(this.c);
        if (this.b instanceof o) {
            if (!this.d.isEmpty()) {
                b.b();
            }
            for (q a : this.d) {
                b.b(a.a());
            }
        } else {
            b.b();
        }
        return b.a();
    }

    @NonNull
    public final f k() {
        return this.b;
    }
}
