package com.ucpro.feature.bookmarkhis.bookmark.a;

import android.support.annotation.NonNull;
import android.webkit.ValueCallback;
import com.raizlabs.android.dbflow.structure.database.transaction.c;
import com.raizlabs.android.dbflow.structure.database.transaction.g;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ProGuard */
public final class a implements c {
    final /* synthetic */ ValueCallback a = null;
    final /* synthetic */ AtomicBoolean b;
    final /* synthetic */ s c;

    public a(s sVar, AtomicBoolean atomicBoolean) {
        this.c = sVar;
        this.b = atomicBoolean;
    }

    public final void a(@NonNull g gVar) {
        if (this.a != null) {
            this.a.onReceiveValue(Boolean.valueOf(this.b.get()));
        }
    }
}
