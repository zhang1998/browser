package com.ucpro.feature.bookmarkhis.bookmark.a;

import android.support.annotation.NonNull;
import android.webkit.ValueCallback;
import com.raizlabs.android.dbflow.structure.database.transaction.b;

/* compiled from: ProGuard */
public final class g implements b {
    final /* synthetic */ ValueCallback a = null;
    final /* synthetic */ s b;

    public g(s sVar) {
        this.b = sVar;
    }

    public final void a(@NonNull com.raizlabs.android.dbflow.structure.database.transaction.g gVar, @NonNull Throwable th) {
        if (this.a != null) {
            this.a.onReceiveValue(Boolean.valueOf(false));
        }
    }
}
