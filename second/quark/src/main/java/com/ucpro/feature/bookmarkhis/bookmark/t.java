package com.ucpro.feature.bookmarkhis.bookmark;

import android.webkit.ValueCallback;
import com.ucpro.business.stat.m;

/* compiled from: ProGuard */
final class t implements ValueCallback<Boolean> {
    final /* synthetic */ ai a;

    t(ai aiVar) {
        this.a = aiVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        Boolean bool = (Boolean) obj;
        this.a.j();
        ai.d(bool.booleanValue());
        m.a("bookmark", "bookmark_change_category", new String[0]);
    }
}
