package com.ucpro.feature.bookmarkhis.bookmark.a;

import android.webkit.ValueCallback;
import com.raizlabs.android.dbflow.structure.database.transaction.k;

/* compiled from: ProGuard */
final class ae implements k<m> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ s b;

    ae(s sVar, ValueCallback valueCallback) {
        this.b = sVar;
        this.a = valueCallback;
    }

    public final /* synthetic */ void a(Object obj) {
        this.a.onReceiveValue((m) obj);
    }
}
