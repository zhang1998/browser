package com.ucpro.feature.webwindow;

import android.os.Bundle;
import android.webkit.ValueCallback;
import com.ucpro.feature.ab.c;
import com.ucpro.ui.contextmenu.d;

/* compiled from: ProGuard */
final class bj implements ValueCallback<Bundle> {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ d c;
    final /* synthetic */ y d;

    bj(y yVar, String str, String str2, d dVar) {
        this.d = yVar;
        this.a = str;
        this.b = str2;
        this.c = dVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        c.a(this.a + this.b, new as(this), true);
    }
}
