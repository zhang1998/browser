package com.ucpro.feature.bookmarkhis.bookmark.a;

import android.webkit.ValueCallback;
import com.raizlabs.android.dbflow.structure.database.transaction.j;
import java.util.List;

/* compiled from: ProGuard */
final class k implements j<m> {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ s b;

    k(s sVar, ValueCallback valueCallback) {
        this.b = sVar;
        this.a = valueCallback;
    }

    public final void a(List<m> list) {
        this.a.onReceiveValue(list);
    }
}
