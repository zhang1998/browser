package com.ucpro.feature.webwindow.c;

import android.content.Context;
import com.quark.browser.R;
import com.uc.webview.export.GeolocationPermissions.Callback;
import com.ucpro.ui.c.a;
import com.ucpro.ui.g.k;

/* compiled from: ProGuard */
public final class c {
    public k a = null;
    String b = null;
    Callback c = null;
    boolean d = false;
    private Context e = null;

    public c(Context context, String str, Callback callback) {
        CharSequence charSequence = null;
        this.e = context;
        this.b = str;
        this.c = callback;
        this.a = new k(context);
        this.a.a(2);
        this.a.a(a.d((int) R.string.browser_geolocation_permissions_title));
        k kVar = this.a;
        if (this.e != null) {
            charSequence = this.b + a.d((int) R.string.browser_geolocation_permissions_message);
        }
        kVar.b(charSequence);
        this.a.a(a.d((int) R.string.browser_geolocation_permissions_permit), a.d((int) R.string.browser_geolocation_permissions_refuse));
        this.a.a(new g(this));
        this.a.a(new b(this));
    }
}
