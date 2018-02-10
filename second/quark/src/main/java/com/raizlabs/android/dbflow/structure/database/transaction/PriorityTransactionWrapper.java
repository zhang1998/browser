package com.raizlabs.android.dbflow.structure.database.transaction;

import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.structure.database.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: ProGuard */
public final class PriorityTransactionWrapper implements a, Comparable<PriorityTransactionWrapper> {
    private final int a;
    private final a b;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    public @interface Priority {
    }

    public final /* bridge */ /* synthetic */ int compareTo(@NonNull Object obj) {
        return ((PriorityTransactionWrapper) obj).a - this.a;
    }

    public final void a(b bVar) {
        this.b.a(bVar);
    }
}
