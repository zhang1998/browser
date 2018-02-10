package com.ucpro.feature.webwindow.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.uc.webview.export.GeolocationPermissions.Callback;
import com.uc.webview.export.JsPromptResult;
import com.uc.webview.export.JsResult;
import com.uc.webview.export.WebChromeClient;
import com.uc.webview.export.WebChromeClient.FileChooserParams;
import com.uc.webview.export.WebView;
import com.uc.webview.export.WebView.WebViewTransport;
import com.ucpro.base.a.e;
import com.ucpro.base.a.f;
import com.ucpro.base.a.g;
import com.ucpro.base.a.j;
import com.ucpro.base.c.a.c;
import com.ucpro.base.c.b.m;
import com.ucpro.feature.u.a;
import com.ucpro.feature.webwindow.at;
import com.ucpro.feature.webwindow.bb;
import com.ucpro.feature.webwindow.bo;
import com.ucpro.feature.webwindow.c.h;
import com.ucpro.feature.webwindow.c.k;
import com.ucpro.feature.webwindow.c.l;

/* compiled from: ProGuard */
public final class y extends WebChromeClient {
    private bo a;
    private at b;
    private m c;
    private c d;
    private Context e;

    public y(Context context, at atVar, bo boVar, m mVar, c cVar) {
        this.b = atVar;
        this.a = boVar;
        this.e = context;
        this.c = mVar;
        this.d = cVar;
        a.a("WebChromeClientImpl", this);
    }

    public final boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        return this.b.a(valueCallback, fileChooserParams);
    }

    public final void onProgressChanged(WebView webView, int i) {
        this.a.b(i);
    }

    public final void onReceivedTitle(WebView webView, String str) {
        String url = webView.getUrl();
        String originalUrl = webView.getOriginalUrl();
        if (!(com.ucweb.common.util.n.a.a(str) || com.ucweb.common.util.n.a.a(url) || com.ucweb.common.util.n.a.a(originalUrl))) {
            g.a().a(e.aA, new String[]{str, url, originalUrl});
        }
        this.a.a(str, url, originalUrl);
        f.a().a(j.e, this.c.c(this.a), null);
        this.a.setIcon(null);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        if (this.b != null && this.b.c() != null) {
            new com.ucpro.feature.webwindow.c.c(this.b.c().a, str, callback).a.show();
        }
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        if (this.a.getVisibility() != 0) {
            return false;
        }
        bb a = this.b.a(this.a);
        if (a == null) {
            return false;
        }
        a.a(false, true);
        a.b("");
        WebView browserWebView = a.getWebView().getBrowserWebView();
        WebViewTransport webViewTransport = (WebViewTransport) message.obj;
        if (browserWebView != null) {
            a.getWebView().setVisibility(4);
            a.getWebView().setVisibility(0);
            webViewTransport.setWebView(browserWebView);
        }
        message.sendToTarget();
        return true;
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        com.ucpro.feature.webwindow.c.a.a(com.ucweb.common.util.i.f.c(str));
        if (this.a.m()) {
            if (jsResult != null) {
                jsResult.cancel();
            }
            this.a.setIsCloseAllJsDialog(false);
        } else if (com.ucpro.feature.webwindow.c.a.b()) {
            jsResult.cancel();
            com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.js_dialog_disturb_toast), 0);
            this.a.setIsCloseAllJsDialog(true);
            com.ucpro.feature.webwindow.c.a.c();
        } else if (!(this.b.c() == null || this.b.c().a() == null)) {
            l lVar = new l(this.b.c().a().a, str2, jsResult);
            if (lVar.a != null) {
                lVar.a.show();
            }
        }
        return true;
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        com.ucpro.feature.webwindow.c.a.a(com.ucweb.common.util.i.f.c(str));
        if (this.a.m()) {
            if (jsResult != null) {
                jsResult.cancel();
            }
            this.a.setIsCloseAllJsDialog(false);
        } else if (com.ucpro.feature.webwindow.c.a.b()) {
            jsResult.cancel();
            com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.js_dialog_disturb_toast), 0);
            this.a.setIsCloseAllJsDialog(true);
            com.ucpro.feature.webwindow.c.a.c();
        } else if (!(this.b.c() == null || this.b.c().a() == null)) {
            k kVar = new k(this.b.c().a().a, str2, jsResult);
            if (kVar.a != null) {
                kVar.a.show();
            }
        }
        return true;
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        com.ucpro.feature.webwindow.c.a.a(com.ucweb.common.util.i.f.c(str));
        if (this.a.m()) {
            if (jsPromptResult != null) {
                jsPromptResult.cancel();
            }
            this.a.setIsCloseAllJsDialog(false);
        } else if (com.ucpro.feature.webwindow.c.a.b()) {
            jsPromptResult.cancel();
            com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.js_dialog_disturb_toast), 0);
            this.a.setIsCloseAllJsDialog(true);
            com.ucpro.feature.webwindow.c.a.c();
        } else if (!(this.b.c() == null || this.b.c().a() == null)) {
            h a = this.b.c().a();
            com.ucpro.ui.g.j jVar = new com.ucpro.ui.g.j(a.a, str2, str3);
            boolean[] zArr = new boolean[]{false};
            jVar.a(new com.ucpro.feature.webwindow.c.f(a, zArr, jsPromptResult));
            jVar.a(new com.ucpro.feature.webwindow.c.m(a, jsPromptResult, zArr));
            jVar.show();
        }
        return true;
    }

    public final void onHideCustomView() {
        this.a.A();
    }

    public final void onReceivedIcon(WebView webView, Bitmap bitmap) {
        com.ucweb.common.util.h.m.a(0, new com.ucpro.feature.webwindow.i.e(com.ucpro.feature.webwindow.i.c.a, webView.getUrl(), bitmap));
        this.a.setIcon(bitmap);
        f.a().a(j.d, this.c.c(this.a), bitmap);
    }

    public final void onCloseWindow(WebView webView) {
        com.ucpro.base.c.b.g gVar;
        m mVar = this.c;
        loop0:
        for (int i = 0; i < this.d.a(); i++) {
            com.ucpro.base.c.b.g a = this.c.a();
            while (true) {
                if (a instanceof bb) {
                    gVar = (bb) a;
                    if (gVar.getWebView().getBrowserWebView() == webView) {
                        break loop0;
                    }
                }
                if (a == null) {
                    break;
                }
                a = this.c.a(i, a);
            }
        }
        gVar = null;
        int c = mVar.c(gVar);
        if (c >= 0) {
            this.d.a(c);
        }
    }
}
