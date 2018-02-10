package com.ucpro.feature.webwindow;

import android.content.Context;
import android.os.Bundle;
import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.ucpro.ui.b.e;
import com.ucweb.common.util.d;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class g implements ValueCallback<Bundle> {
    final /* synthetic */ String a;
    final /* synthetic */ t b;

    g(t tVar, String str) {
        this.b = tVar;
        this.a = str;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        int i;
        Bundle bundle = (Bundle) obj;
        boolean z = bundle.getBoolean("succeed");
        if (z) {
            m.a(0, new b(this, bundle));
        }
        e a = e.a();
        Context a2 = d.a();
        if (z) {
            i = R.string.pic_save_sucess;
        } else {
            i = R.string.pic_save_fail;
        }
        a.a(a2.getString(i), 0);
    }
}
