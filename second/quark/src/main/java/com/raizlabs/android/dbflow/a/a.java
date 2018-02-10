package com.raizlabs.android.dbflow.a;

import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.structure.database.transaction.b;
import com.raizlabs.android.dbflow.structure.database.transaction.g;

/* compiled from: ProGuard */
final class a implements b {
    final /* synthetic */ c a;

    a(c cVar) {
        this.a = cVar;
    }

    public final void a(@NonNull g gVar, @NonNull Throwable th) {
        if (this.a.d != null) {
            this.a.d.a(gVar, th);
        }
        this.a.e = null;
    }
}
