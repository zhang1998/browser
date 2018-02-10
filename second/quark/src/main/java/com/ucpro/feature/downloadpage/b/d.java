package com.ucpro.feature.downloadpage.b;

import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import java.util.HashSet;

/* compiled from: ProGuard */
final class d implements ValueCallback<HashSet<String>> {
    final /* synthetic */ j a;
    final /* synthetic */ q b;

    d(q qVar, j jVar) {
        this.b = qVar;
        this.a = jVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        HashSet hashSet = (HashSet) obj;
        a a = this.b.d;
        a.b = hashSet;
        if (a.b == null) {
            a.b = new HashSet();
        }
        this.b.d.setPresenter(this.a);
        a = this.b.d;
        CharSequence d = a.d((int) R.string.download_setting_store);
        if (a.a != null) {
            a.a.setText(d);
        }
        this.b.d.show();
    }
}
