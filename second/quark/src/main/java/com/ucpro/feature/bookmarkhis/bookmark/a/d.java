package com.ucpro.feature.bookmarkhis.bookmark.a;

import android.support.annotation.NonNull;
import android.webkit.ValueCallback;
import com.raizlabs.android.dbflow.structure.database.transaction.c;
import com.raizlabs.android.dbflow.structure.database.transaction.g;

/* compiled from: ProGuard */
final class d implements c {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ s b;

    d(s sVar, ValueCallback valueCallback) {
        this.b = sVar;
        this.a = valueCallback;
    }

    public final void a(@NonNull g gVar) {
        if (this.a != null) {
            this.a.onReceiveValue(Boolean.valueOf(true));
        }
    }
}
