package com.ucpro.feature.f;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.uc.base.a.a.a.d.b;
import com.uc.base.a.a.a.h.a;
import com.uc.base.a.a.a.h.e;

/* compiled from: ProGuard */
final class g implements e {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ e b;

    g(e eVar, ValueCallback valueCallback) {
        this.b = eVar;
        this.a = valueCallback;
    }

    public final void a(boolean z, a aVar) {
        new StringBuilder("getProfileFromService success, showRefresh: ").append(String.valueOf(z));
        if (this.a != null) {
            this.a.onReceiveValue(aVar);
        }
        d.a(true, String.valueOf(z), null);
    }

    public final void b(b bVar) {
        new StringBuilder("getProfileFromService fail\njsContent: \n").append(bVar.c).append("\nDebugInfo: \n").append(bVar.d);
        if (!TextUtils.isEmpty(bVar.b())) {
            com.ucpro.ui.b.e.a().a(bVar.b(), 0);
        }
        d.a(false, null, bVar.c);
    }
}
