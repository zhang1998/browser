package com.raizlabs.android.dbflow.a.b;

import android.database.Cursor;
import android.support.annotation.Nullable;
import com.raizlabs.android.dbflow.b.a;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.b;
import com.raizlabs.android.dbflow.structure.database.c;

/* compiled from: ProGuard */
public final class n<TModel> implements a<TModel> {
    public final b<TModel> a;
    @Nullable
    public c b;

    n(Class<TModel> cls, @Nullable Cursor cursor) {
        if (cursor != null) {
            this.b = c.a(cursor);
        }
        this.a = FlowManager.f(cls);
    }

    public final void close() {
        if (this.b != null) {
            this.b.close();
        }
    }
}
