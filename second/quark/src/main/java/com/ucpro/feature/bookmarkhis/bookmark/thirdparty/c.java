package com.ucpro.feature.bookmarkhis.bookmark.thirdparty;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.business.stat.m;

/* compiled from: ProGuard */
final class c implements ValueCallback<String> {
    final /* synthetic */ i a;

    c(i iVar) {
        this.a = iVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        String str = (String) obj;
        if (!this.a.a.a.d && !TextUtils.isEmpty(str)) {
            this.a.a.a.d = true;
            this.a.a.a.c = str;
            Object bundle = new Bundle();
            bundle.putString("TITLE", this.a.a.a.c);
            bundle.putString("URL", this.a.a.a.b);
            g.a().b(e.aG, bundle);
            g.a().b(e.aR);
            m.a("bookmark", "bookmark_copy_toast_click", new String[0]);
        }
    }
}
