package com.ucpro.feature.collectpanel;

import android.view.View;
import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class b implements ValueCallback<Boolean> {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ long c;
    final /* synthetic */ k d;

    b(k kVar, String str, String str2, long j) {
        this.d = kVar;
        this.a = str;
        this.b = str2;
        this.c = j;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        i a = this.d.c;
        String str = this.a;
        String str2 = this.b;
        long j = this.c;
        if (a.a != null) {
            a.b.a((View) a.a);
            a.a.a(str, str2, booleanValue);
            a.c = j;
        }
    }
}
