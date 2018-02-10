package com.taobao.weex.ui.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

/* compiled from: ProGuard */
public final class x implements d {
    WebView a;
    b b;
    c c;
    private Context d;
    private ProgressBar e;
    private boolean f = true;

    public x(Context context) {
        this.d = context;
    }

    public final View a() {
        View frameLayout = new FrameLayout(this.d);
        frameLayout.setBackgroundColor(-1);
        this.a = new WebView(this.d);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.a.setLayoutParams(layoutParams);
        frameLayout.addView(this.a);
        WebView webView = this.a;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        webView.setWebViewClient(new v(this));
        webView.setWebChromeClient(new w(this));
        this.e = new ProgressBar(this.d);
        b(false);
        layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.e.setLayoutParams(layoutParams);
        layoutParams.gravity = 17;
        frameLayout.addView(this.e);
        return frameLayout;
    }

    public final void a(boolean z) {
        this.f = z;
    }

    public final void a(b bVar) {
        this.b = bVar;
    }

    public final void a(c cVar) {
        this.c = cVar;
    }

    final void b(boolean z) {
        if (this.f) {
            this.e.setVisibility(z ? 0 : 8);
        }
    }

    public final void b() {
        if (this.a != null) {
            this.a.removeAllViews();
            this.a.destroy();
            this.a = null;
        }
    }

    public final void a(String str) {
        if (this.a != null) {
            this.a.loadUrl(str);
        }
    }

    public final void c() {
        if (this.a != null) {
            this.a.reload();
        }
    }

    public final void d() {
        if (this.a != null) {
            this.a.goBack();
        }
    }

    public final void e() {
        if (this.a != null) {
            this.a.goForward();
        }
    }
}
