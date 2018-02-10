package com.ucpro.feature.webwindow;

import android.view.MotionEvent;
import android.view.View;
import com.ucpro.feature.webwindow.e.f;

/* compiled from: ProGuard */
public final class ac implements bp {
    private final ab a;

    public ac(ab abVar) {
        this.a = abVar;
    }

    public final View a() {
        return this.a.getWebView();
    }

    public final View b() {
        return this.a.getAddressBar();
    }

    public final boolean c() {
        f webView = this.a.getWebView();
        if (webView.b != null) {
            return webView.b.ignoreTouchEvent();
        }
        return false;
    }

    public final boolean d() {
        f webView = this.a.getWebView();
        if (webView.a != null) {
            return webView.a.canZoomOut();
        }
        return false;
    }

    public final boolean e() {
        return this.a.getWebView().c();
    }

    public final boolean f() {
        return this.a.getWebView().e();
    }

    public final void a(MotionEvent motionEvent) {
        this.a.a(motionEvent);
    }

    public final void a(View view) {
        this.a.a(view);
    }
}
