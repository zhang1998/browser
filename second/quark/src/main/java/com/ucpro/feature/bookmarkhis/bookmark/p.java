package com.ucpro.feature.bookmarkhis.bookmark;

import android.webkit.ValueCallback;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import java.util.List;

/* compiled from: ProGuard */
final class p implements ValueCallback<List<m>> {
    final /* synthetic */ ai a;

    p(ai aiVar) {
        this.a = aiVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        ai.a(this.a, (List) obj);
    }
}
