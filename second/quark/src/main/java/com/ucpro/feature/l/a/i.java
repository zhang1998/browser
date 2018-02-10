package com.ucpro.feature.l.a;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import com.quark.browser.R;
import com.ucpro.ui.b.e;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class i implements ValueCallback<Boolean> {
    final /* synthetic */ String a;
    final /* synthetic */ View b;
    final /* synthetic */ Drawable c;
    final /* synthetic */ Drawable d = null;
    final /* synthetic */ ValueCallback e;
    final /* synthetic */ j f;

    i(j jVar, String str, View view, Drawable drawable, Drawable drawable2, ValueCallback valueCallback) {
        this.f = jVar;
        this.a = str;
        this.b = view;
        this.c = drawable;
        this.e = valueCallback;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            e.a().a(a.d((int) R.string.discover_bookmark_nav_full_tips), 1);
        } else {
            this.f.a(this.a, (ImageView) this.b, this.c, this.e);
        }
    }
}
