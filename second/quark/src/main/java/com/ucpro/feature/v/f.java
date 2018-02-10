package com.ucpro.feature.v;

import android.text.TextUtils;
import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class f implements ValueCallback<String> {
    final /* synthetic */ g a;

    f(g gVar) {
        this.a = gVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        String str;
        String str2 = (String) obj;
        b b = this.a.c.c;
        CharSequence charSequence = this.a.a;
        String str3 = this.a.b;
        if (TextUtils.isEmpty(str2)) {
            str = "";
        } else {
            str = str2;
        }
        b.f.getSettings().setJavaScriptEnabled(true);
        b.f.loadDataWithBaseURL(str3, str, "text/html", "UTF-8", "");
        if (TextUtils.isEmpty(charSequence)) {
            str = "";
        } else {
            CharSequence charSequence2 = charSequence;
        }
        b.e.getSettings().setJavaScriptEnabled(true);
        b.e.loadDataWithBaseURL(str3, str, "text/html", "UTF-8", "");
    }
}
