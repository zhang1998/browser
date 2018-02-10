package com.ucpro.feature.webwindow;

import android.os.Bundle;
import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.ucpro.services.download.b;
import com.ucpro.ui.b.e;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
final class t implements ValueCallback<Bundle> {
    final /* synthetic */ String a;
    final /* synthetic */ y b;

    t(y yVar, String str) {
        this.b = yVar;
        this.a = str;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        if (((Bundle) obj).getBoolean("succeed")) {
            e.a().a(d.a().getString(R.string.pic_save_sucess), 0);
            return;
        }
        String d = b.d();
        this.b.a.a(d, null, this.a, new g(this, d));
    }
}
