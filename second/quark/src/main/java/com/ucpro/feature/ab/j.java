package com.ucpro.feature.ab;

import android.webkit.ValueCallback;
import com.uc.qrcode.m;
import com.ucpro.base.system.b;

/* compiled from: ProGuard */
final class j implements m {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ boolean b;
    final /* synthetic */ String c;

    j(ValueCallback valueCallback, boolean z, String str) {
        this.a = valueCallback;
        this.b = z;
        this.c = str;
    }

    public final void a(String str) {
        this.a.onReceiveValue(str);
        if (this.b) {
            b.a.d(this.c);
        }
    }

    public final void a() {
        this.a.onReceiveValue("");
        if (this.b) {
            b.a.d(this.c);
        }
    }
}
