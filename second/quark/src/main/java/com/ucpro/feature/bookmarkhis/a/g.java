package com.ucpro.feature.bookmarkhis.a;

import android.webkit.ValueCallback;
import com.ucweb.common.util.h.a;

/* compiled from: ProGuard */
final class g extends a {
    final /* synthetic */ a a;
    final /* synthetic */ ValueCallback b;
    final /* synthetic */ i c;

    g(i iVar, a aVar, ValueCallback valueCallback) {
        this.c = iVar;
        this.a = aVar;
        this.b = valueCallback;
    }

    public final void run() {
        if (this.a.f != null) {
            this.b.onReceiveValue(this.a.f);
        }
    }
}
