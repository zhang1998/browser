package com.ucpro.feature.collectpanel;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ProGuard */
final class d implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ long c;
    final /* synthetic */ k d;

    d(k kVar, String str, String str2, long j) {
        this.d = kVar;
        this.a = str;
        this.b = str2;
        this.c = j;
    }

    public final void onClick(View view) {
        k.a(this.d, this.a, this.b, this.c);
    }
}
