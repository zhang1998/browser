package com.ucpro.feature.bookmarkhis.bookmark;

import android.webkit.ValueCallback;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
final class af implements ValueCallback<m> {
    final /* synthetic */ aa a;

    af(aa aaVar) {
        this.a = aaVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        obj = (m) obj;
        c.a(obj);
        if (obj != null) {
            this.a.f.a(obj.e);
        }
    }
}
