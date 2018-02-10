package com.ucpro.a;

import android.webkit.ValueCallback;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class ap implements ValueCallback<byte[]> {
    final /* synthetic */ ay a;

    ap(ay ayVar) {
        this.a = ayVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        m.a(0, new aa(this.a.b, (byte[]) obj));
    }
}
