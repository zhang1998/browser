package com.raizlabs.android.dbflow.runtime;

import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.structure.database.transaction.b;
import com.raizlabs.android.dbflow.structure.database.transaction.g;

/* compiled from: ProGuard */
final class h implements b {
    final /* synthetic */ i a;

    h(i iVar) {
        this.a = iVar;
    }

    public final void a(@NonNull g gVar, @NonNull Throwable th) {
        if (this.a.e != null) {
            this.a.e.a(gVar, th);
        }
    }
}
