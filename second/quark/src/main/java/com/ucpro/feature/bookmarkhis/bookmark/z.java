package com.ucpro.feature.bookmarkhis.bookmark;

import android.webkit.ValueCallback;
import com.ucpro.business.stat.m;

/* compiled from: ProGuard */
final class z implements ValueCallback<Boolean> {
    final /* synthetic */ long a;
    final /* synthetic */ ai b;

    z(ai aiVar, long j) {
        this.b = aiVar;
        this.a = j;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        Boolean bool = (Boolean) obj;
        if (bool.booleanValue()) {
            this.b.j();
        }
        ai.d(bool.booleanValue());
        if (this.a != -1) {
            m.a("bookmark", "bookmark_change_category", new String[0]);
        }
    }
}
