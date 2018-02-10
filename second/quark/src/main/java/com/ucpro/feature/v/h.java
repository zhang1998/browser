package com.ucpro.feature.v;

import android.text.Html;
import android.text.TextUtils;
import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class h implements ValueCallback<String> {
    final /* synthetic */ c a;

    h(c cVar) {
        this.a = cVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        String str = (String) obj;
        k kVar = new k(this.a.b.b);
        kVar.a(new e(this, str));
        String str2 = this.a.a;
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        kVar.a.setText(Html.fromHtml(str2));
        kVar.b.setText(Html.fromHtml(str));
        kVar.show();
    }
}
