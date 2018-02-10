package com.ucpro.feature.webwindow.e;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import com.quark.browser.R;
import com.uc.webview.export.HttpAuthHandler;
import com.uc.webview.export.SslErrorHandler;
import com.uc.webview.export.WebView;
import com.uc.webview.export.WebViewClient;
import com.uc.weex.d.a.b;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.base.a.j;
import com.ucpro.base.c.a.c;
import com.ucpro.base.c.b.m;
import com.ucpro.feature.webwindow.at;
import com.ucpro.feature.webwindow.ba;
import com.ucpro.feature.webwindow.be;
import com.ucpro.feature.webwindow.bo;
import com.ucpro.feature.webwindow.d.a;
import com.ucweb.common.util.i.f;
import java.util.HashMap;
import java.util.List;

/* compiled from: ProGuard */
public final class i extends WebViewClient {
    private final bo a;
    private at b;
    private m c;
    private c d;
    private Context e;
    private a f;
    private boolean g = true;

    public i(Context context, at atVar, bo boVar, m mVar, c cVar) {
        this.e = context;
        this.a = boVar;
        this.b = atVar;
        this.c = mVar;
        this.d = cVar;
        com.ucpro.feature.u.a.a("WebViewClientImpl", this);
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        boolean z = false;
        this.a.e(str);
        Object a = b.a(str);
        if (a != null) {
            g.a().a(e.bN, a);
            return true;
        } else if (TextUtils.isEmpty(str)) {
            return false;
        } else {
            if (!str.startsWith("http://") && !str.startsWith("https://") && !str.startsWith("javascript:") && !str.startsWith("ext:")) {
                if (this.f == null) {
                    this.f = new a(this.e);
                }
                if (this.f.a(str)) {
                    return true;
                }
                com.ucpro.feature.webwindow.external.c a2 = com.ucpro.feature.webwindow.external.c.a();
                Context context = this.e;
                CharSequence c = f.c(webView.getUrl());
                String d = f.d(str);
                if (com.ucpro.c.b.b()) {
                    new StringBuilder("tryCallApp:host=").append(c).append(", scheme=").append(d);
                }
                Intent g = com.ucpro.base.system.b.a.g(str);
                if (com.ucpro.feature.webwindow.external.c.a(g)) {
                    com.ucpro.feature.webwindow.external.c.a = true;
                    com.ucpro.feature.webwindow.external.c.b = webView.getUrl();
                    com.ucpro.business.stat.m.a("p2p_video", "xigua_website", "xigua_url", com.ucpro.feature.webwindow.external.c.b);
                    g.a().a(e.cU, g.getData().toString());
                } else {
                    com.ucpro.feature.webwindow.external.c.a = false;
                    if (!TextUtils.isEmpty(c)) {
                        if (a2.b(c, d)) {
                            com.ucpro.feature.webwindow.external.c.a(context, str, d);
                            if (com.ucpro.c.b.b()) {
                                new StringBuilder("in white list:host=").append(c).append(", scheme=").append(d);
                            }
                        } else if (!a2.a((String) c, d)) {
                            if (com.ucpro.c.b.b()) {
                                new StringBuilder("neither in white nor black list, need choose:host=").append(c).append(", scheme=").append(d);
                            }
                            if (com.ucpro.feature.webwindow.external.c.a(context, g)) {
                                com.ucweb.common.util.c.a(c);
                                com.ucpro.ui.g.g gVar = new com.ucpro.ui.g.g(context);
                                gVar.a(com.ucpro.ui.c.a.d((int) R.string.external_app_weak_up_dialog_title));
                                gVar.b(com.ucpro.ui.c.a.d((int) R.string.external_app_allow_ckeck_box));
                                gVar.a(com.ucpro.ui.c.a.d((int) R.string.external_app_allow_this_time_item), com.ucpro.ui.c.a.d((int) R.string.external_app_disallow_this_time_item));
                                gVar.b(com.ucpro.ui.c.a.c("default_maintext_gray"));
                                gVar.a(new com.ucpro.feature.webwindow.external.a(a2, c, d, context, str, gVar));
                                gVar.show();
                            }
                        } else if (com.ucpro.c.b.b()) {
                            new StringBuilder("in black list:host=").append(c).append(", scheme=").append(d);
                        }
                        z = true;
                    }
                }
                if (z) {
                    return true;
                }
                return true;
            } else if (!str.startsWith("ext:") || !str.startsWith("ext:") || !"ext:refresh".equalsIgnoreCase(str)) {
                return false;
            } else {
                webView.reload();
                return true;
            }
        }
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.a.c(str);
    }

    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.a.B();
        this.a.d(str);
        com.ucpro.base.a.f.a().a(j.c, this.c.c(this.a), null);
        if (!TextUtils.isEmpty(str)) {
            com.ucpro.feature.bookmarkhis.a.c a = com.ucpro.feature.bookmarkhis.a.e.a;
            String title = webView.getTitle();
            String c = f.c(str);
            if (a.a) {
                new StringBuilder("statHostoryAdd: \ntitle: ").append(title).append("\nhostName: ").append(c);
                HashMap hashMap = new HashMap();
                hashMap.put("history_item_title", title);
                hashMap.put("history_item_host_name", f.c(c));
                hashMap.put("is_incognito", String.valueOf(com.ucpro.feature.e.b.a.a));
                com.ucpro.business.stat.m.a("histroy", "history_add", hashMap);
            }
        }
        a(this.a, com.ucpro.feature.webwindow.f.c.a().a(f.c(str), "T3"));
        if (!this.a.G() && this.g) {
            this.g = false;
            com.ucweb.common.util.h.m.a(0, new v(this));
        }
        com.ucweb.common.util.h.m.a(0, com.ucpro.feature.video.player.c.i.b);
    }

    private static void a(bo boVar, List<String> list) {
        if (boVar != null && list != null && !list.isEmpty()) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    boVar.b("javascript: " + str);
                }
            }
        }
    }

    public final void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        com.ucweb.common.util.h.m.a(2, new l(this, httpAuthHandler, str, str2));
    }

    public final void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        if (!z) {
            String title = webView.getTitle();
            if (com.ucweb.common.util.n.a.a(title)) {
                title = str;
            }
            if (!com.ucweb.common.util.n.a.a(title) && !com.ucweb.common.util.n.a.a(str)) {
                g.a().a(e.az, new String[]{title, str});
            }
        }
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        r.a(true, sslError.getPrimaryError(), null, sslError.getUrl());
        ba c = this.b.c();
        bo boVar = this.a;
        com.ucpro.ui.g.m mVar = new com.ucpro.ui.g.m(c.a, true);
        mVar.a(1);
        mVar.a(com.ucpro.ui.c.a.d((int) R.string.ssl_dialog_title));
        mVar.a(com.ucpro.ui.c.a.d((int) R.string.ssl_dialog_title_cand_txt), com.ucpro.ui.c.a.d((int) R.string.ssl_dialog_title_default_txt));
        mVar.a(new be(c, sslErrorHandler, webView, boVar));
        mVar.show();
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        r.a(false, i, str, str2);
        this.a.E();
    }
}
