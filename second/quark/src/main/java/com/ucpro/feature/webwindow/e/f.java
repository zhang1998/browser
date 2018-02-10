package com.ucpro.feature.webwindow.e;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View.OnLongClickListener;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.uc.base.jssdk.h;
import com.uc.base.jssdk.m;
import com.uc.base.jssdk.u;
import com.uc.webview.browser.BrowserWebView;
import com.uc.webview.browser.BrowserWebView.HitTestResult;
import com.uc.webview.browser.interfaces.BrowserClient;
import com.uc.webview.browser.interfaces.BrowserExtension;
import com.uc.webview.browser.interfaces.BrowserExtension.TextSelectionClient;
import com.uc.webview.browser.interfaces.DownloadListener;
import com.uc.webview.browser.interfaces.PictureViewer.Listener;
import com.uc.webview.export.WebView.FindListener;
import com.uc.webview.export.extension.IBackForwardListListener;
import com.uc.webview.export.extension.UCExtension;
import com.uc.webview.export.extension.UCExtension.InjectJSProvider;
import com.ucpro.a.d;
import com.ucpro.a.g;
import com.ucpro.feature.webwindow.e.a.a;
import com.ucpro.feature.webwindow.o.b;
import com.ucweb.common.util.c;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProGuard */
public final class f extends FrameLayout implements m, d {
    private static boolean v = true;
    private ConcurrentHashMap<String, Object> A;
    public t a;
    public BrowserExtension b;
    private com.ucpro.a.c.m c;
    private Context d;
    private o e;
    private o f;
    private String g;
    private a h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private Listener n;
    private TextSelectionClient o;
    private OnLongClickListener p;
    private IBackForwardListListener q;
    private DownloadListener r;
    private FindListener s;
    private boolean t = false;
    private long u = 0;
    private InjectJSProvider w;
    private int x;
    private boolean y = false;
    private h z;

    public f(Context context, boolean z) {
        super(context);
        this.d = context;
        this.t = false;
        com.ucpro.feature.u.a.a("WebViewWrapper", this);
        this.c = new com.ucpro.a.c.m();
        boolean c = g.a().c();
        if (this.t) {
            b.a(c, true);
        } else {
            b.a(c, false);
        }
        if (!c) {
            this.u = System.currentTimeMillis();
            g.a().a((d) this);
        } else if (z) {
            a(this.d);
        } else {
            com.ucweb.common.util.h.m.a(2, new d(this));
        }
    }

    private void a(Context context) {
        int i = 314572800;
        int i2 = 104857600;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.a == null) {
            this.a = new t(context);
        }
        this.z = u.a.a((m) this, this.a.hashCode());
        com.ucweb.common.util.a.a.a(this.a.getCoreView(), com.ucpro.ui.c.a.a("scrollbar_thumb.9.png"));
        c.a(this.a);
        if (this.a != null) {
            com.ucpro.a.c.m mVar = this.c;
            BrowserWebView browserWebView = this.a;
            if (mVar.a == null) {
                mVar.a = browserWebView;
                mVar.b = mVar.a.getSettings();
            }
        }
        c.a(this.a);
        if (this.a != null) {
            this.b = this.a.getUCExtension();
            BrowserExtension browserExtension = this.b;
            int i3 = (int) (((float) com.ucweb.common.util.k.a.i(com.ucpro.c.c.c().getPath()).b) * 0.1f);
            if (i3 >= 104857600) {
                i2 = i3;
            }
            if (i2 <= 314572800) {
                i = i2;
            }
            browserExtension.setHttpCacheMaxSize(i);
        }
        addView(this.a, new LayoutParams(-1, -1));
        if (v && !this.t) {
            v = false;
            g.a().f();
            g.a().e();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            boolean c = com.ucpro.b.d.a.c();
            HashMap hashMap = new HashMap();
            hashMap.put("is_first_run", c ? "yes" : "no");
            hashMap.put("time_cost", String.valueOf(currentTimeMillis2));
            com.ucpro.business.stat.m.a(com.ucpro.business.stat.d.FORCED, "core", "webview_cost", hashMap);
        }
    }

    public final h getJsApiManager() {
        return this.z;
    }

    public final void a(String str, @Nullable ValueCallback<String> valueCallback) {
        if (this.a != null) {
            this.a.evaluateJavascript(str, valueCallback);
        }
    }

    public final void a(String str) {
        if (this.a != null) {
            if (this.e != null) {
                this.e.a(str);
            }
            this.a.loadUrl(str);
            return;
        }
        this.g = str;
    }

    public final void a(String str, String str2, String str3, String str4, String str5) {
        if (this.a != null) {
            if (this.e != null) {
                this.e.a(str5);
            }
            this.a.loadDataWithBaseURL(str, str2, str3, str4, str5);
            return;
        }
        this.i = str;
        this.j = str2;
        this.k = str3;
        this.l = str4;
        this.m = str5;
    }

    public final void a(Object obj, String str) {
        if (this.a != null) {
            this.a.addJavascriptInterface(obj, str);
            return;
        }
        if (this.A == null) {
            this.A = new ConcurrentHashMap();
        }
        this.A.putIfAbsent(str, obj);
    }

    public final String getCallerUrl() {
        if (this.y) {
            return null;
        }
        return getUrl();
    }

    public final void a(String str, int i, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:UCShellJava.sdkCallback('");
        stringBuilder.append(str);
        stringBuilder.append("',");
        stringBuilder.append(i);
        stringBuilder.append(",'");
        try {
            stringBuilder.append(URLEncoder.encode(str2, "UTF-8").replace("+", "%20"));
        } catch (UnsupportedEncodingException e) {
        }
        stringBuilder.append("');");
        a(stringBuilder.toString());
    }

    public final void setCustomBrowserClient(BrowserClient browserClient) {
    }

    public final com.ucpro.a.c.m getWebViewSetting() {
        return this.c;
    }

    public final void setWebViewCallback(o oVar) {
        if (oVar == null) {
            return;
        }
        if (this.a != null) {
            this.e = oVar;
            this.a.setWebViewClient(oVar.a());
            this.a.setWebChromeClient(oVar.c());
            this.a.getUCExtension().setClient(oVar.b());
            return;
        }
        this.f = oVar;
    }

    public final void setTextSelectionClient(TextSelectionClient textSelectionClient) {
        if (textSelectionClient == null) {
            return;
        }
        if (this.b != null) {
            this.b.setTextSelectionClient(textSelectionClient);
        } else {
            this.o = textSelectionClient;
        }
    }

    public final void setLongClickListener(OnLongClickListener onLongClickListener) {
        if (this.a != null && onLongClickListener != null) {
            this.a.setOnLongClickListener(onLongClickListener);
        } else if (onLongClickListener != null) {
            this.p = onLongClickListener;
        }
    }

    public final void setIBackForwardListListener(IBackForwardListListener iBackForwardListListener) {
        if (this.b != null && iBackForwardListListener != null) {
            this.b.setBackForwardListListener(iBackForwardListListener);
        } else if (iBackForwardListListener != null) {
            this.q = iBackForwardListListener;
        }
    }

    public final void setDownloadListener(DownloadListener downloadListener) {
        if (this.a != null && downloadListener != null) {
            this.a.setDownloadListener(downloadListener);
        } else if (downloadListener != null) {
            this.r = downloadListener;
        }
    }

    public final HitTestResult getHitTestResult() {
        if (this.a != null) {
            return this.a.getHitTestResult();
        }
        return null;
    }

    public final void a(InjectJSProvider injectJSProvider, int i) {
        if (this.b != null) {
            this.b.setInjectJSProvider(injectJSProvider, i);
            return;
        }
        this.w = injectJSProvider;
        this.x = i;
    }

    public final void a(boolean z) {
        if (this.b != null) {
            this.b.notifyContextMenuExpanded(z);
        }
    }

    public final String getFocusedNodeLinkUrl() {
        if (this.b != null) {
            return this.b.getFocusedNodeLinkUrl();
        }
        return null;
    }

    public final String getFocusedNodeAnchorText() {
        if (this.b != null) {
            return this.b.getFocusedNodeAnchorText();
        }
        return null;
    }

    public final BrowserWebView getBrowserWebView() {
        return this.a;
    }

    public final int getPageScrollY() {
        if (this.a != null) {
            return this.a.getPageScrollY();
        }
        return 0;
    }

    public final UCExtension getUCExtentsion() {
        return this.b;
    }

    public final String getUrl() {
        if (this.a != null) {
            return this.a.getUrl();
        }
        return null;
    }

    public final String getTitle() {
        if (this.a != null) {
            return this.a.getTitle();
        }
        return null;
    }

    public final void setIWebViewProxyListener(a aVar) {
        if (this.a != null) {
            this.a.setWebViewProxyListener(aVar);
        } else {
            this.h = aVar;
        }
    }

    public final String getBackUrl() {
        c.a(this.b);
        if (this.b != null) {
            return this.b.getBackUrl();
        }
        return null;
    }

    public final String getForwardUrl() {
        c.a(this.b);
        if (this.b != null) {
            return this.b.getForwardUrl();
        }
        return null;
    }

    public final void setPrivateBrowsing(boolean z) {
        c.a(this.b);
        if (this.b != null) {
            this.b.setPrivateBrowsing(z);
        }
    }

    public final boolean c() {
        if (this.a != null) {
            return this.a.canGoBack();
        }
        return false;
    }

    public final void d() {
        if (this.a != null) {
            this.a.goBack();
        }
    }

    public final boolean e() {
        if (this.a != null) {
            return this.a.canGoForward();
        }
        return false;
    }

    public final String getSelection() {
        if (this.b != null) {
            return this.b.getSelection();
        }
        return "";
    }

    public final void f() {
        if (this.a != null) {
            this.a.reload();
        }
    }

    public final void g() {
        if (!this.y && this.a != null) {
            removeView(this.a);
            this.a.destroy();
            this.c = null;
            this.a = null;
            this.b = null;
            this.y = true;
        }
    }

    public final void h() {
        if (this.a != null) {
            com.ucweb.common.util.a.a.a(this.a.getCoreView(), com.ucpro.ui.c.a.a("scrollbar_thumb.9.png"));
        }
    }

    public final void setFindListener(FindListener findListener) {
        if (this.a != null) {
            this.a.setFindListener(findListener);
        } else {
            this.s = findListener;
        }
    }

    public final void setPictureViewListener(Listener listener) {
        if (this.b != null) {
            this.b.setPictureViewerListener(listener);
        } else {
            this.n = listener;
        }
    }

    public final void a() {
        long currentTimeMillis = System.currentTimeMillis() - this.u;
        boolean c = com.ucpro.b.d.a.c();
        HashMap hashMap = new HashMap();
        hashMap.put("is_first_run", c ? "yes" : "no");
        hashMap.put("time_delay", String.valueOf(currentTimeMillis));
        com.ucpro.business.stat.m.a(com.ucpro.business.stat.d.FORCED, "core", "core_delay", hashMap);
        a(this.d);
        if (this.s != null) {
            setFindListener(this.s);
        }
        if (this.n != null) {
            setPictureViewListener(this.n);
        }
        if (this.f != null) {
            setWebViewCallback(this.f);
        }
        if (this.h != null) {
            setIWebViewProxyListener(this.h);
        }
        if (this.o != null) {
            setTextSelectionClient(this.o);
        }
        if (this.p != null) {
            setLongClickListener(this.p);
        }
        if (this.q != null) {
            setIBackForwardListListener(this.q);
        }
        if (this.r != null) {
            setDownloadListener(this.r);
        }
        if (!(this.A == null || this.A.isEmpty())) {
            for (Entry entry : this.A.entrySet()) {
                a(entry.getValue(), (String) entry.getKey());
            }
        }
        if (this.w != null) {
            a(this.w, this.x);
        }
        if (this.j != null) {
            a(this.i, this.j, this.k, this.l, this.m);
        }
        if (this.g != null) {
            a(this.g);
        }
    }

    public final void b() {
    }
}
