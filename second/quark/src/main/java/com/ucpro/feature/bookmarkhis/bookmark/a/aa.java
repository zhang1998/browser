package com.ucpro.feature.bookmarkhis.bookmark.a;

import com.raizlabs.android.dbflow.structure.database.b;
import com.raizlabs.android.dbflow.structure.database.transaction.a;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ProGuard */
final class aa implements a {
    final /* synthetic */ AtomicBoolean a;
    final /* synthetic */ i b;
    final /* synthetic */ s c;

    aa(s sVar, AtomicBoolean atomicBoolean, i iVar) {
        this.c = sVar;
        this.a = atomicBoolean;
        this.b = iVar;
    }

    public final void a(b bVar) {
        this.a.set(this.b.a());
    }
}
