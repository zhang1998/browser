package com.ucpro.feature.bookmarkhis.bookmark;

import android.webkit.ValueCallback;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import java.util.List;

/* compiled from: ProGuard */
final class e implements ValueCallback<List<m>> {
    final /* synthetic */ ai a;

    e(ai aiVar) {
        this.a = aiVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        ai.a(this.a, (List) obj);
    }
}
