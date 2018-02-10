package com.ucpro.feature.webwindow;

import android.content.Context;
import com.uc.webview.export.WebView;
import com.ucpro.a.d;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
final class bd implements d {
    final /* synthetic */ am a;
    private Context b;

    public bd(am amVar, Context context) {
        this.a = amVar;
        this.b = context;
    }

    public final void a() {
        WebView webView = new WebView(this.b);
        webView.loadUrl("ext:lp:home");
        webView.setWebViewClient(new j(this));
        this.a.b = null;
        this.a.a = v.c;
        for (WeakReference weakReference : this.a.a()) {
            if (!(weakReference == null || weakReference.get() == null)) {
                weakReference.get();
            }
        }
    }

    public final void b() {
        this.a.b = null;
    }
}
