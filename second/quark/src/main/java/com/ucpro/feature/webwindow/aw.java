package com.ucpro.feature.webwindow;

import android.os.Bundle;
import android.util.Log;
import android.webkit.ValueCallback;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.feature.c.e.a;

/* compiled from: ProGuard */
final class aw implements ValueCallback<Bundle> {
    final /* synthetic */ boolean a = false;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ y d;

    aw(y yVar, String str, String str2) {
        this.d = yVar;
        this.b = str;
        this.c = str2;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.a) {
            g.a().a(e.bF, this.b + this.c);
        } else if (bundle.getBoolean("succeed")) {
            com.ucpro.feature.c.d.e.a(this.b + this.c, new e(this));
            a.a();
        } else {
            Log.e("hjw-pic", "onReceiveValue isSucceed == false");
            a.b("onReceiveValue isSucceed == false");
        }
    }
}
