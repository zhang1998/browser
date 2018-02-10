package com.ucpro.feature.webwindow;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.LinearInterpolator;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.browser.BrowserWebView.HitTestResult;
import com.uc.webview.browser.interfaces.BrowserClient.CustomViewCallbackEx;
import com.uc.webview.browser.interfaces.BrowserExtension.TextSelectionClient;
import com.uc.webview.browser.interfaces.DownloadListener;
import com.uc.webview.export.WebBackForwardList;
import com.uc.webview.export.WebView.FindListener;
import com.uc.webview.export.extension.IBackForwardListListener;
import com.ucpro.b;
import com.ucpro.base.a.j;
import com.ucpro.business.stat.a.c;
import com.ucpro.d.k;
import com.ucpro.feature.webwindow.a.g;
import com.ucpro.feature.webwindow.a.i;
import com.ucpro.feature.webwindow.e.a.a;
import com.ucpro.feature.webwindow.e.m;
import com.ucpro.feature.webwindow.e.o;
import com.ucpro.feature.webwindow.g.d;
import com.ucpro.feature.webwindow.h.h;
import com.ucpro.feature.webwindow.l.a.f;
import com.ucpro.feature.webwindow.n.e;
import com.ucpro.feature.y.l;
import com.ucpro.feature.y.p;
import com.ucpro.feature.y.r;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class bb extends bo implements OnLongClickListener, c {
    private static boolean o;
    private int A;
    private f B;
    private IBackForwardListListener C;
    private String D;
    private Bitmap E;
    private af F;
    private g G;
    private int H;
    private e I;
    private boolean J;
    private int K;
    private d L;
    private com.ucpro.feature.webwindow.g.e M;
    private HashMap<String, String> N;
    private aq O;
    private a P;
    private View Q;
    private CustomViewCallbackEx R;
    m e;
    com.ucpro.feature.webwindow.e.f f;
    boolean g;
    bn h;
    h i;
    com.ucpro.feature.webwindow.h.f j;
    int k;
    af l;
    WeakReference<com.ucpro.base.c.b.g> m;
    int n;
    private at p;
    private o q;
    private m r;
    private TextSelectionClient s;
    private DownloadListener t;
    private boolean u;
    private boolean v;
    private x w;
    private r x;
    private ab y;
    private FrameLayout z;

    private bb(Context context) {
        super(context);
        this.u = false;
        this.A = -1;
        this.k = 1;
        this.n = -1;
        this.J = false;
        this.K = -1;
        this.O = new d(this);
        this.P = new q(this);
        com.ucpro.feature.u.a.a("WebWindow", this);
    }

    public bb(Context context, at atVar) {
        this(context);
        setEnableSwipeGesture(false);
        this.p = atVar;
        this.y = new ab(getContext());
        this.l = new af(getContext());
        this.l.a = new ac(this.y);
        this.l.b = this.O;
        this.y.setGestureManager(this.l);
        this.y.setVisibility(4);
        b(this.y);
        this.w = new x(getContext());
        this.F = new af(getContext());
        this.F.a = new ad(this.w, this);
        this.F.b = this.O;
        this.w.setGestureManager(this.F);
        b(this.w);
        this.h = new bn(getContext());
        com.ucpro.ui.widget.e eVar = this.w;
        View view = this.h;
        int c = com.ucpro.ui.c.a.c((int) R.dimen.bottom_bar_height);
        eVar.a = view;
        eVar.b = c;
        eVar.addView(eVar.a);
    }

    public final void setWebViewCallback(o oVar) {
        this.q = oVar;
    }

    public final void setPictureViewListener(m mVar) {
        this.r = mVar;
    }

    public final void setTextSelectionClient(TextSelectionClient textSelectionClient) {
        this.s = textSelectionClient;
    }

    public final void setIBackForwardListListener(IBackForwardListListener iBackForwardListListener) {
        this.C = iBackForwardListListener;
    }

    public final void setDownloadListener(DownloadListener downloadListener) {
        this.t = downloadListener;
    }

    public final void setFindListener(FindListener findListener) {
        if (this.f != null) {
            this.f.setFindListener(findListener);
        }
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.A == -1) {
            a(0);
        }
    }

    public final void a() {
        if (!G()) {
            getAddressBar();
            T();
            a(0);
        }
    }

    protected final void a(byte b) {
        super.a(b);
        if (b == (byte) 8) {
            if (G()) {
                p.a.a(getHomePageProxy());
            }
        } else if (b == (byte) 11) {
            p();
        }
    }

    public final FrameLayout getBusinessLayer() {
        if (this.z == null) {
            this.z = new FrameLayout(getContext());
            this.y.a(this.z);
        }
        return this.z;
    }

    public final boolean b() {
        if (this.f != null) {
            return this.f.c();
        }
        return false;
    }

    public final boolean c() {
        if (this.f != null) {
            return this.f.e();
        }
        return false;
    }

    private void R() {
        if (this.j != null) {
            b();
        }
    }

    private void S() {
        if (this.j != null) {
            c();
        }
    }

    private void f(boolean z) {
        if (this.j != null) {
            this.j.a.a(z);
        }
    }

    public final Bitmap getIcon() {
        if (this.E == null) {
            this.E = com.ucpro.services.c.f.a.a.a(getContext(), getUrl());
        }
        return this.E;
    }

    public final void setIcon(Bitmap bitmap) {
        this.E = bitmap;
    }

    public final void a(String str, String str2, String str3) {
        Object obj = null;
        if (this.j != null) {
            boolean z;
            com.ucpro.feature.webwindow.h.f fVar = this.j;
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(ah.a())) {
                z = false;
            } else {
                z = TextUtils.equals(str2, ah.a());
            }
            new StringBuilder("checkUrlBlackList\ncurrent url is: ").append(str2).append("\nforbidden url is: ").append(ah.a()).append("\ncheck Result is: ").append(String.valueOf(z));
            if (z) {
                fVar.a.a(str);
                if (TextUtils.isEmpty(fVar.c)) {
                    fVar.c = str2;
                }
            } else {
                if (!(TextUtils.isEmpty(str) || str.equals("ext:uc:home") || TextUtils.isEmpty(str2) || str2.equals("ext:lp:home") || str2.startsWith("javascript") || TextUtils.isEmpty(str3) || str3.equals("ext:lp:home"))) {
                    obj = 1;
                }
                if (obj != null) {
                    if (!com.ucweb.common.util.i.f.b(str2)) {
                        com.ucweb.common.util.i.f.b(str3);
                    }
                    if (str.length() <= 6 || !str.startsWith("ext:a:")) {
                        fVar.a.a(str);
                    } else {
                        fVar.a.a(str.substring(6));
                    }
                }
                fVar.c = str2;
            }
        }
        if (this.e != null) {
            this.e.a(str2, str3);
        }
    }

    public final void a(boolean z, boolean z2) {
        if (this.f == null) {
            this.f = com.ucpro.feature.webwindow.e.c.a(getContext(), z2);
            this.f.setIWebViewProxyListener(this.P);
            this.f.setWebViewCallback(this.q);
            this.f.setPictureViewListener(this.r);
            this.f.a(new WebPageStatInterface(this.f), "PageStat");
            if (this.s != null) {
                this.f.setTextSelectionClient(this.s);
            }
            if (this.C != null) {
                this.f.setIBackForwardListListener(this.C);
            }
            if (this.t != null) {
                this.f.setDownloadListener(this.t);
            }
            this.f.setLongClickListener(this);
            if (z) {
                T();
            }
        }
    }

    protected final void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (b.a) {
            b.a = false;
            Activity activity = (Activity) getContext();
            com.ucpro.base.a.f.a().a(j.q, 0, null);
            com.ucweb.common.util.h.m.a(2, new com.ucpro.d.g(activity));
            com.ucweb.common.util.h.m.a(2, new k(activity), 1000);
            com.ucpro.d.e.a("fdf1");
            com.ucpro.d.e.b();
        }
    }

    private void T() {
        if (this.f != null) {
            a(true, false);
            this.f.a("ext:lp:home", "<head><title>ext:uc:home</title></head><body></body>", "text/html", "UTF-8", "ext:lp:home");
        }
    }

    public final x getHomePageLayer() {
        return this.w;
    }

    public final ab getWebPageLayer() {
        return this.y;
    }

    public final void a(int i) {
        if (this.A != i) {
            this.H = this.A;
            this.A = i;
            boolean z;
            x homePageLayer;
            g guideManager;
            if (i == 0) {
                if (getHomePageProxy() != null && getHomePageProxy().getParent() == null) {
                    this.w.setContentView(getHomePageProxy());
                }
                if (!(j() && this.H == -1)) {
                    p.a.a(getHomePageProxy());
                }
                z = getWebPageLayer().getVisibility() == 0;
                homePageLayer = getHomePageLayer();
                homePageLayer.e = 1;
                homePageLayer.a();
                homePageLayer.setVisibility(0);
                homePageLayer.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
                if (z) {
                    if (homePageLayer.c == null) {
                        homePageLayer.c = ObjectAnimator.ofFloat(homePageLayer, "alpha", new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE});
                        homePageLayer.c.setDuration(300);
                        homePageLayer.c.setInterpolator(new LinearInterpolator());
                    }
                    homePageLayer.c.start();
                }
                ab webPageLayer = getWebPageLayer();
                if (webPageLayer.f != 0) {
                    webPageLayer.f = 0;
                    webPageLayer.c();
                    if (z) {
                        if (webPageLayer.c == null) {
                            webPageLayer.c = ValueAnimator.ofFloat(new float[]{IPictureView.DEFAULT_MIN_SCALE, 0.0f});
                            webPageLayer.c.addUpdateListener(new al(webPageLayer));
                            webPageLayer.c.setDuration(300);
                            webPageLayer.c.addListener(new ap(webPageLayer));
                        }
                        webPageLayer.c.setFloatValues(new float[]{IPictureView.DEFAULT_MIN_SCALE, 0.0f});
                        webPageLayer.c.start();
                    } else {
                        webPageLayer.setVisibility(8);
                    }
                }
                if (com.ucpro.ui.c.a.a()) {
                    b(z);
                    com.ucpro.feature.i.f.a.a((Activity) getContext(), 0);
                }
                this.e.a(this.H);
                guideManager = getGuideManager();
                Context context = getContext();
                if (!com.ucweb.common.util.j.a.b(context, "ECC3CF22A48D384F", "24E6E448A6A97026", false)) {
                    if (G()) {
                        guideManager.b();
                        guideManager.g = new com.ucpro.feature.webwindow.a.f(context);
                        com.ucweb.common.util.h.m.a(2, new i(guideManager), 1000);
                        guideManager.g.setListener(new com.ucpro.feature.webwindow.a.j(guideManager));
                    }
                    b(guideManager.g);
                }
            } else if (i == 1) {
                int i2;
                if (this.H == 0) {
                    i2 = 1;
                } else {
                    z = false;
                }
                homePageLayer = getHomePageLayer();
                homePageLayer.e = 0;
                homePageLayer.a();
                if (i2 != 0) {
                    if (homePageLayer.d == null) {
                        homePageLayer.d = ObjectAnimator.ofFloat(homePageLayer, "alpha", new float[]{IPictureView.DEFAULT_MIN_SCALE, 0.0f});
                        homePageLayer.d.setDuration(300);
                        homePageLayer.d.setInterpolator(new LinearInterpolator());
                        homePageLayer.d.addListener(new h(homePageLayer));
                    }
                    homePageLayer.d.start();
                } else {
                    homePageLayer.setVisibility(8);
                }
                if (getWebView().getParent() == null) {
                    getWebPageLayer().setWebView(getWebView());
                }
                if (getAddressBar().getParent() == null) {
                    int c = com.ucpro.ui.c.a.c((int) R.dimen.search_bar_min_height);
                    ab webPageLayer2 = getWebPageLayer();
                    webPageLayer2.a = getAddressBar();
                    webPageLayer2.a.setProgressListener(webPageLayer2);
                    webPageLayer2.addView(webPageLayer2.a);
                    webPageLayer2.e = c;
                    webPageLayer2.b = new View(webPageLayer2.getContext());
                    webPageLayer2.b.setBackgroundColor(com.ucpro.ui.c.a.c("default_cutting_line"));
                    webPageLayer2.addView(webPageLayer2.b);
                    webPageLayer2.g = 1;
                }
                ab webPageLayer3 = getWebPageLayer();
                if (webPageLayer3.f != 1) {
                    webPageLayer3.f = 1;
                    webPageLayer3.c();
                    webPageLayer3.setVisibility(0);
                    webPageLayer3.getAddressBar().setAlpha(IPictureView.DEFAULT_MIN_SCALE);
                    webPageLayer3.getBarShadowView().setAlpha(IPictureView.DEFAULT_MIN_SCALE);
                    webPageLayer3.getAddressBar().setTranslationY(0.0f);
                    webPageLayer3.getBarShadowView().setTranslationY(0.0f);
                    if (i2 != 0) {
                        if (webPageLayer3.d == null) {
                            webPageLayer3.d = ValueAnimator.ofFloat(new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE});
                            webPageLayer3.d.addUpdateListener(new ak(webPageLayer3));
                            webPageLayer3.d.setDuration(300);
                        }
                        webPageLayer3.d.start();
                    }
                }
                if (com.ucpro.ui.c.a.a()) {
                    if (this.a != null && this.a.getVisibility() == 0) {
                        if (i2 != 0) {
                            this.a.animate().cancel();
                            this.a.animate().alpha(IPictureView.DEFAULT_MIN_SCALE).setDuration(300).start();
                        } else {
                            this.a.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
                        }
                    }
                    com.ucpro.feature.i.f.a.a((Activity) getContext(), com.ucpro.ui.c.a.c("status_bar_color"));
                }
                this.y.d();
                this.e.b(this.H);
                guideManager = getGuideManager();
                getContext();
                guideManager.a();
            }
            setIcon(null);
        }
    }

    private g getGuideManager() {
        if (this.G == null) {
            this.G = new g();
        }
        return this.G;
    }

    public final boolean m() {
        return this.u;
    }

    public final void setIsCloseAllJsDialog(boolean z) {
        this.u = z;
    }

    public final h getAddressBar() {
        if (this.i == null) {
            this.i = new h(getContext(), this.e != null ? this.e.i() : 0);
            this.i.setLayoutParams(new LayoutParams(0, com.ucpro.ui.c.a.c((int) R.dimen.search_bar_max_height)));
            this.j = new com.ucpro.feature.webwindow.h.f(this.i);
            this.j.b = this.e;
            this.j.a(this.k);
        }
        return this.i;
    }

    private r getHomePageProxy() {
        if (this.x == null) {
            l a = p.a;
            Context context = getContext();
            r rVar = new r(context, new com.ucpro.feature.y.f(a, context));
            a.a.add(new WeakReference(rVar));
            this.x = rVar;
        }
        return this.x;
    }

    public final void setPresenter(com.ucpro.base.d.b bVar) {
        this.e = (m) bVar;
        setWindowCallBacks(this.e);
        this.h.setCallback(this.e);
        if (this.e.h()) {
            if (this.l != null) {
                this.l.c = true;
            }
        } else if (this.l != null) {
            this.l.c = false;
        }
    }

    public final com.ucpro.feature.webwindow.e.f getWebView() {
        return this.f;
    }

    public final void a(boolean z) {
        if (this.f != null) {
            com.ucpro.feature.webwindow.e.f fVar = this.f;
            if (fVar.a != null) {
                fVar.a.findNext(z);
            }
        }
    }

    public final void n() {
        if (this.f != null) {
            com.ucpro.feature.webwindow.e.f fVar = this.f;
            if (fVar.a != null) {
                fVar.a.clearMatches();
            }
        }
    }

    public final void o() {
        if (!this.J) {
            this.J = true;
            if (this.y != null) {
                this.K = this.y.getAddressBarState();
                this.y.d();
                this.y.setEnableScroll(false);
                this.y.setEnableSourceDelegateDispatchTouchEvent(false);
                this.M = new com.ucpro.feature.webwindow.g.e(getContext(), this.i.getLayoutParams().height);
                this.L = new d(this, this.M);
                setFindListener(new com.ucpro.feature.webwindow.e.a(this.M, this));
                this.M.setPresenter(this.L);
                d dVar = this.L;
                dVar.a.getViewTreeObserver().addOnGlobalLayoutListener(new com.ucpro.feature.webwindow.g.a(dVar));
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(0, dVar.a.getMeasuredHeight() - dVar.b.getSearchPageHeight(), 0, 0);
                layoutParams.leftMargin = dVar.a.getMeasuredWidth();
                dVar.a.getBusinessLayer().addView(dVar.b, layoutParams);
                dVar.e = (FrameLayout.LayoutParams) dVar.b.getLayoutParams();
                if (dVar.d != null) {
                    dVar.d.cancel();
                }
                if (dVar.c == null) {
                    dVar.c = ValueAnimator.ofInt(new int[]{dVar.a.getMeasuredWidth(), 0});
                }
                dVar.c.setDuration(300);
                dVar.c.addUpdateListener(new com.ucpro.feature.webwindow.g.m(dVar));
                dVar.c.addListener(new com.ucpro.feature.webwindow.g.g(dVar));
                dVar.c.start();
            }
        }
    }

    public final void p() {
        if (this.J && this.y != null) {
            this.y.setEnableSourceDelegateDispatchTouchEvent(true);
            this.y.setEnableScroll(true);
            this.y.e();
            this.K = -1;
            d dVar = this.L;
            if (dVar.c != null) {
                dVar.c.cancel();
            }
            if (dVar.d == null) {
                dVar.d = ValueAnimator.ofInt(new int[]{0, dVar.b.getMeasuredHeight()});
            }
            dVar.d.setDuration(800);
            dVar.d.addUpdateListener(new com.ucpro.feature.webwindow.g.h(dVar));
            dVar.d.addListener(new com.ucpro.feature.webwindow.g.i(dVar));
            dVar.d.start();
            com.ucweb.common.util.f.a(getContext(), (View) this);
            n();
            setFindListener(null);
            this.J = false;
            this.L = null;
            this.L = null;
        }
    }

    public final void a(String str) {
        if (this.f != null) {
            com.ucpro.feature.webwindow.e.f fVar = this.f;
            if (fVar.a != null) {
                fVar.a.findAllAsync(str);
            }
        }
    }

    public final void b(String str) {
        a(str, false, "");
    }

    public final void a(String str, boolean z, String str2) {
        p();
        a(true, false);
        a(1);
        this.f.a(str);
        this.j.a(str, z, str2);
        U();
    }

    public final void c(String str) {
        a(getTitle(), str, str);
        com.ucweb.common.util.h.m.a(2, new bk(this, str), 100);
    }

    public final void d(String str) {
        if (!G()) {
            this.u = false;
        }
        a(getTitle(), str, str);
    }

    public final e getBannerManager() {
        if (this.I == null) {
            this.I = new e(this);
        }
        return this.I;
    }

    public final void q() {
        if (this.f != null) {
            WebBackForwardList copyBackForwardList;
            p();
            com.ucpro.feature.webwindow.e.f fVar = this.f;
            if (fVar.a != null) {
                copyBackForwardList = fVar.a.copyBackForwardList();
            } else {
                copyBackForwardList = null;
            }
            if (copyBackForwardList == null || copyBackForwardList.getCurrentIndex() != 0) {
                String backUrl = this.f.getBackUrl();
                if (backUrl == null) {
                    return;
                }
                if (this.v && backUrl.equals("ext:lp:home")) {
                    this.e.a(this);
                    return;
                }
                if (backUrl.equals("ext:lp:home")) {
                    a(0);
                } else {
                    a(1);
                }
                getWebPageLayer().b();
                this.f.d();
                setIcon(null);
                U();
            } else if (this.A != 0) {
                a(0);
                this.f.d();
            }
        }
    }

    public final void setShouldBackToCallerActivity(boolean z) {
        this.v = z;
    }

    public final void e(String str) {
        this.e.a(getWebView(), str);
    }

    public final void r() {
        if (this.f != null) {
            p();
            String forwardUrl = this.f.getForwardUrl();
            if (forwardUrl != null) {
                if (forwardUrl.equals("ext:lp:home")) {
                    a(0);
                } else {
                    a(1);
                }
                getWebPageLayer().b();
                com.ucpro.feature.webwindow.e.f fVar = this.f;
                if (fVar.a != null) {
                    fVar.a.goForward();
                }
                setIcon(null);
                U();
            }
        }
    }

    public final void s() {
        if (!G() && this.f != null) {
            com.ucpro.feature.webwindow.e.f fVar = this.f;
            if (fVar.a != null) {
                fVar.a.stopLoading();
            }
        }
    }

    public final void t() {
        this.y.d();
    }

    public final void u() {
        if (!G() && this.f != null) {
            this.f.f();
            U();
        }
    }

    public final void f(String str) {
        if (this.f != null) {
            com.ucpro.feature.webwindow.e.f fVar = this.f;
            com.ucweb.common.util.c.a(fVar.b);
            if (fVar.b != null && !com.ucweb.common.util.n.a.a(str)) {
                fVar.b.loadAndShowPicture(str);
            }
        }
    }

    public final void v() {
        if (this.f != null) {
            com.ucpro.feature.webwindow.e.f fVar = this.f;
            if (fVar.b != null && fVar.b.getImageViewer() != null) {
                fVar.b.closePictureViewer();
            }
        }
    }

    public final boolean w() {
        if (this.f == null) {
            return false;
        }
        com.ucpro.feature.webwindow.e.f fVar = this.f;
        if (fVar.b != null) {
            return fVar.b.openPictureViewer();
        }
        return false;
    }

    public final void setPictureViewerOpened(boolean z) {
        this.g = z;
    }

    public final boolean x() {
        return this.g;
    }

    public final boolean y() {
        if (this.m == null || this.n == -1 || this.f == null || this.f.c()) {
            return false;
        }
        return true;
    }

    public final com.ucpro.base.c.b.g getSourceWindow() {
        if (this.m != null) {
            return (com.ucpro.base.c.b.g) this.m.get();
        }
        return null;
    }

    public final int getSourceWindowIndex() {
        return this.n;
    }

    public final void z() {
        if (this.j != null) {
            com.ucpro.feature.webwindow.h.f fVar = this.j;
            if (fVar.a.a()) {
                fVar.a.c();
            } else {
                fVar.a.b();
            }
        }
    }

    public final String getTitle() {
        if (G()) {
            return getHomePageString();
        }
        return this.f != null ? this.f.getTitle() : null;
    }

    private String getHomePageString() {
        if (this.D == null) {
            this.D = com.ucpro.ui.c.a.d((int) R.string.homepage);
        }
        return this.D;
    }

    public final String getDisplayTitle() {
        String title = getTitle();
        if (title == null) {
            return com.ucpro.ui.c.a.d((int) R.string.app_name);
        }
        return title;
    }

    public final String getUrl() {
        String str = null;
        if (this.f != null) {
            str = this.f.getUrl();
        }
        if (str == null) {
            return "ext:lp:home";
        }
        return str;
    }

    public final void k() {
        if (this.f != null) {
            com.ucpro.feature.webwindow.e.f fVar = this.f;
            ValueCallback aVar = new a(this);
            com.ucweb.common.util.c.a(fVar.b);
            if (fVar.b != null) {
                fVar.b.getEditorContent(aVar);
            }
        }
    }

    public final void l() {
        super.l();
        if (this.h != null) {
            this.h.a();
        }
        if (this.i != null) {
            this.i.d();
        }
        if (this.F != null) {
            this.F.a();
        }
        if (this.l != null) {
            this.l.a();
        }
        if (this.f != null) {
            this.f.h();
        }
        if (this.B != null) {
            this.B.d();
        }
        if (this.M != null) {
            this.M.c();
        }
        if (this.y != null) {
            ab abVar = this.y;
            if (abVar.b != null) {
                abVar.b.setBackgroundColor(com.ucpro.ui.c.a.c("default_cutting_line"));
            }
            if (abVar.k != null) {
                abVar.k.a();
            }
            if (abVar.m != null) {
                abVar.m.a();
            }
            if (abVar.n != null) {
                abVar.n.a();
            }
        }
        if (this.A == 0 && com.ucpro.ui.c.a.a()) {
            b(true);
        }
        com.ucpro.ui.contextmenu.f a = com.ucpro.ui.contextmenu.f.a();
        if (a.b != null) {
            a.b.a();
        }
    }

    public final void c(boolean z) {
        if (this.h != null) {
            bn bnVar = this.h;
            int childCount = bnVar.getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = bnVar.getChildAt(i);
                if ((childAt instanceof ar) && ((ar) childAt).getItemID() == 30029) {
                    ar arVar = (ar) childAt;
                    if (z) {
                        arVar.setIconName("home_toolbar_menu_traceless.svg");
                        arVar.setDarkIconName("home_toolbar_menu_traceless_dark.svg");
                    } else {
                        arVar.setIconName("home_toolbar_menu.svg");
                        arVar.setDarkIconName("home_toolbar_menu_dark.svg");
                    }
                    ((ar) childAt).a();
                } else {
                    i++;
                }
            }
        }
        if (this.y != null) {
            ab abVar = this.y;
            if (abVar.a != null) {
                abVar.a.a.b();
            }
        }
    }

    public final void a(View view, int i, CustomViewCallbackEx customViewCallbackEx) {
        if (view != null && customViewCallbackEx != null) {
            this.Q = view;
            this.R = customViewCallbackEx;
            this.e.a(view, i);
        }
    }

    public final void A() {
        if (this.Q != null && this.Q.getParent() != null && this.R != null) {
            this.R.doHideCustomView();
            this.e.b(this.Q);
            this.Q = null;
            this.R.onCustomViewHidden();
            this.R = null;
        }
    }

    public final void d(boolean z) {
        this.e.c(z);
    }

    public final void setWebViewFillParent(boolean z) {
        this.y.setWebViewFillParent(z);
        if (!com.ucpro.feature.i.f.a.b()) {
            if (z) {
                com.ucpro.feature.i.f.a.b((Activity) getContext());
            } else {
                com.ucpro.feature.i.f.a.a((Activity) getContext());
            }
        }
        if (com.ucpro.feature.i.f.a.a()) {
            if (z) {
                f();
            } else if (!(this.a == null || this.a.getVisibility() == 0)) {
                this.a.setVisibility(0);
            }
        }
        this.e.d(!z);
    }

    public final void b(int i) {
        if (i == 0) {
            R();
            S();
            f(true);
            if (this.i != null) {
                h hVar = this.i;
                if (hVar.getProgressBar() != null) {
                    hVar.getProgressBar().setVisible(true);
                }
                hVar.d = true;
                this.i.setProgress(0.0f);
            }
            U();
        } else if (i == 100) {
            B();
            f(false);
        }
        if (getProgress() * 100.0f < ((float) i)) {
            setProgress(((float) i) * 0.01f);
        }
    }

    private void setProgress(float f) {
        if (this.i != null) {
            this.i.setProgress(f);
        }
    }

    public final float getProgress() {
        if (this.i != null) {
            return this.i.getProgress();
        }
        return 0.0f;
    }

    public final void a(int i, Object obj) {
        com.ucpro.feature.webwindow.o.a.a(i, obj);
        if (this.i != null) {
            h hVar = this.i;
            if (hVar.getProgressBar() != null) {
                com.ucpro.ui.widget.b.e progressBar = hVar.getProgressBar();
                switch (i) {
                    case 5:
                        progressBar.b = 1;
                        progressBar.c = 0;
                        progressBar.d = 0;
                        progressBar.a = 0;
                        return;
                    case 6:
                        progressBar.c = 1;
                        if (progressBar.d == 1) {
                            progressBar.b();
                        }
                        progressBar.a = 0;
                        return;
                    case 7:
                        progressBar.b();
                        return;
                    case 8:
                        progressBar.d = 1;
                        if (progressBar.c == 1) {
                            progressBar.b();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public final void B() {
        R();
        S();
    }

    public final boolean onLongClick(View view) {
        if (this.f != null) {
            Object hitTestResult = getHitTestResult();
            if (hitTestResult != null) {
                com.ucpro.ui.contextmenu.d a = com.ucpro.ui.contextmenu.f.a().a(getContext());
                if (a != null) {
                    a.c();
                    this.e.a((HitTestResult) hitTestResult, a);
                    if (a.getCount() > 0) {
                        a.a(hitTestResult);
                        String url = getUrl();
                        int count = a.getCount();
                        HashMap hashMap = new HashMap();
                        hashMap.put("url", url);
                        hashMap.put("context_menu_count", String.valueOf(count));
                        com.ucpro.business.stat.m.a("webwindow", "context_menu_pop_up", hashMap);
                        com.ucpro.ui.contextmenu.f.a().a(getContext(), this.e);
                    }
                }
            }
        }
        return false;
    }

    public final void C() {
        if (this.f != null) {
            com.ucpro.feature.webwindow.e.f fVar = this.f;
            if (fVar.b != null) {
                fVar.b.selectText();
            }
        }
    }

    public final void D() {
        if (this.f != null) {
            com.ucpro.feature.webwindow.e.f fVar = this.f;
            if (fVar.b != null) {
                fVar.b.expandSelection();
            }
        }
    }

    public final void E() {
        if (this.y != null) {
            View f = this.y.f();
            if (f != null) {
                com.ucweb.common.util.h.m.a(2, new c(this));
                f.setOnClickListener(new av(this));
            }
        }
    }

    public final com.uc.base.jssdk.h getJsApiManager() {
        return this.f.getJsApiManager();
    }

    public final void a(ValueCallback<String> valueCallback) {
        if (this.f != null) {
            this.f.a("(function() { return ('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>'); })();", new ay(this, valueCallback));
        }
    }

    public final void e(boolean z) {
        if (this.y != null) {
            ab abVar = this.y;
            if (abVar.n == null) {
                return;
            }
            if (z) {
                abVar.n.setVisibility(0);
            } else {
                abVar.n.setVisibility(8);
            }
        }
    }

    public final View F() {
        if (this.y == null) {
            return null;
        }
        ab abVar = this.y;
        if (abVar.n == null) {
            abVar.n = new com.ucpro.feature.j.b.e(abVar.getContext());
            abVar.addView(abVar.n);
        }
        return abVar.n;
    }

    private void U() {
        if (this.y != null) {
            ab abVar = this.y;
            if (abVar.m != null) {
                if (abVar.m.getParent() != null) {
                    abVar.removeView(abVar.m);
                }
                abVar.m = null;
            }
        }
    }

    public final void g(String str) {
        if (this.f != null) {
            com.ucpro.feature.webwindow.e.f fVar = this.f;
            if (fVar.b != null) {
                fVar.b.paste(str);
            }
        }
    }

    public final HitTestResult getHitTestResult() {
        if (this.f != null) {
            return this.f.getHitTestResult();
        }
        return null;
    }

    public final void setReceivedDispatchResponse(HashMap<String, String> hashMap) {
        if (this.N == null) {
            this.N = new HashMap();
        }
        this.N.clear();
        this.N.putAll(hashMap);
        if (hashMap != null && !hashMap.isEmpty()) {
            com.ucpro.business.stat.m.a("webwindow", "received_dispatch_response", (HashMap) hashMap);
        }
    }

    public final HashMap<String, String> getReceivedDispatchResponse() {
        return this.N;
    }

    public final void c(int i) {
        if ((this.e == null || !this.e.j()) && this.y != null) {
            ab abVar = this.y;
            if (abVar.l != null) {
                bg bgVar = abVar.l;
                if (i < 0) {
                    bgVar.d = true;
                }
            }
        }
    }

    public final String getFocusedNodeLinkUrl() {
        if (this.f != null) {
            return this.f.getFocusedNodeLinkUrl();
        }
        return null;
    }

    public final String getFocusedNodeAnchorText() {
        if (this.f != null) {
            return this.f.getFocusedNodeAnchorText();
        }
        return null;
    }

    public final void e() {
        super.e();
        if (this.f != null) {
            this.f.a(false);
        }
    }

    public final void d() {
        super.d();
        if (this.f != null) {
            this.f.a(true);
        }
    }

    public final boolean G() {
        return this.A == 0;
    }

    public final boolean H() {
        return 1 == this.A;
    }

    public final void a(String str, String str2, String str3, ValueCallback<Bundle> valueCallback) {
        if (this.f != null) {
            com.ucpro.feature.webwindow.e.f fVar = this.f;
            if (fVar.b != null) {
                fVar.b.savePagePicture(str, str2, str3, valueCallback);
            }
        }
    }

    public final f getFreeCopyMenu() {
        if (this.B == null) {
            this.B = new com.ucpro.feature.webwindow.l.a.g(getContext());
            this.B.setWebMenuListener(this.e);
            this.B.setItems(com.ucpro.feature.webwindow.l.a.c.a());
            getBusinessLayer().addView(this.B.getContentView(), new FrameLayout.LayoutParams(-2, -2));
        }
        return this.B;
    }

    public final void I() {
        getWebView().a("adblock.addRulesForFocusNode()", null);
    }

    public final void J() {
        if (this.f != null) {
            this.f.g();
        }
    }

    public final void a(Point point, Point point2, Rect rect, Rect rect2) {
        if (point != null && point2 != null && rect != null && rect2 != null) {
            int height = rect.top < rect2.top ? rect.height() : rect2.height();
            int height2 = rect.top > rect2.top ? rect.height() : rect2.height();
            CharSequence selection = getSelection();
            if (selection != null) {
                if (com.ucweb.common.util.i.f.a(selection)) {
                    f freeCopyMenu = getFreeCopyMenu();
                    if (com.ucpro.feature.webwindow.l.a.c.a == null) {
                        com.ucpro.feature.webwindow.l.a.c.a = new ArrayList();
                        com.ucpro.feature.webwindow.l.a.a aVar = new com.ucpro.feature.webwindow.l.a.a(com.ucpro.ui.c.a.d((int) R.string.context_menu_free_copy_select_all), 40022);
                        com.ucpro.feature.webwindow.l.a.a aVar2 = new com.ucpro.feature.webwindow.l.a.a(com.ucpro.ui.c.a.d((int) R.string.context_menu_free_copy_copy), 40001);
                        com.ucpro.feature.webwindow.l.a.a aVar3 = new com.ucpro.feature.webwindow.l.a.a(com.ucpro.ui.c.a.d((int) R.string.context_menu_free_copy_open), 40007);
                        com.ucpro.feature.webwindow.l.a.c.a.add(aVar);
                        com.ucpro.feature.webwindow.l.a.c.a.add(aVar2);
                        com.ucpro.feature.webwindow.l.a.c.a.add(aVar3);
                    }
                    freeCopyMenu.setItems(com.ucpro.feature.webwindow.l.a.c.a);
                } else {
                    getFreeCopyMenu().setItems(com.ucpro.feature.webwindow.l.a.c.a());
                }
            }
            getFreeCopyMenu().a(point, point2, getHeight() - com.ucpro.ui.c.a.c((int) R.dimen.search_bar_max_height), height, height2);
        }
    }

    public final String getSelection() {
        if (this.f != null) {
            return this.f.getSelection();
        }
        return "";
    }

    public final void K() {
        if (this.f != null && this.B != null) {
            this.B.b();
            com.ucpro.feature.webwindow.e.f fVar = this.f;
            if (fVar.b != null) {
                fVar.b.selectionDone();
            }
        }
    }

    public final bn getHomeToolbar() {
        return this.h;
    }

    public final void L() {
        if (this.h != null) {
            this.h.a.a("lottie/menu_gift/data.json", "lottie/menu_gift/images", "lottie/menu_gift/images_night");
        }
        if (this.i != null) {
            this.i.a.a("lottie/menu_gift/data.json", "lottie/menu_gift/images", "lottie/menu_gift/images_night");
        }
    }

    public final void M() {
        if (this.h != null) {
            this.h.a.b();
        }
        if (this.i != null) {
            this.i.a.d();
        }
    }

    public final com.ucpro.business.stat.a.d getCurUtPage() {
        if (this.A == 0) {
            return getHomePageLayer();
        }
        if (this.A == 1) {
            return getWebPageLayer();
        }
        return null;
    }

    public final void N() {
        if (this.h != null) {
            ar arVar = this.h.a;
            if (arVar.a != null) {
                arVar.a.setVisibility(0);
            }
        }
    }

    public final void O() {
        if (this.h != null) {
            ar arVar = this.h.a;
            if (arVar.a != null) {
                arVar.a.setVisibility(8);
            }
        }
    }
}
