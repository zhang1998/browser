package com.ucpro.feature.webwindow;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.browser.BrowserWebView.HitTestResult;
import com.uc.webview.browser.BrowserWebView.HitTestResult.Extension;
import com.uc.webview.export.internal.setup.UCMPackageInfo;
import com.ucpro.base.a.g;
import com.ucpro.base.a.j;
import com.ucpro.base.c.a.c;
import com.ucpro.base.c.b.m;
import com.ucpro.feature.c.d.h;
import com.ucpro.feature.c.d.i;
import com.ucpro.feature.j.a;
import com.ucpro.feature.j.b.e;
import com.ucpro.feature.webwindow.e.k;
import com.ucpro.feature.y.o;
import com.ucpro.services.a.b;
import com.ucpro.ui.contextmenu.d;
import com.ucweb.common.util.i.f;
import java.util.HashMap;
import java.util.List;

/* compiled from: ProGuard */
public final class y implements m {
    bo a;
    String b;
    private c c;
    private m d;
    private at e;
    private Context f;
    private a g;

    public y(Context context, bb bbVar, m mVar, c cVar, at atVar) {
        this.a = bbVar;
        this.d = mVar;
        this.c = cVar;
        this.e = atVar;
        this.f = context;
        boolean b = com.ucpro.services.a.a.a.b("ECC3F137B865BDEDBB09172B0652773C");
        boolean b2 = com.ucpro.services.a.a.a.b("56DB53DAD2D33272456868E88138FD31");
        if (b && b2) {
            b = true;
        } else {
            b = false;
        }
        if (b) {
            this.a.L();
        } else {
            this.a.M();
        }
        if (com.ucpro.services.a.a.a.b(b.a)) {
            this.a.N();
        } else {
            this.a.O();
        }
        View F = this.a.F();
        if (F instanceof e) {
            this.g = new a(this.d, (e) F);
        }
        com.ucpro.feature.j.a.b.a();
        List<Integer> b3 = com.ucpro.feature.j.a.b.b();
        com.ucpro.feature.j.a.b.a();
        if (!com.ucpro.feature.j.a.b.d() || b3.size() <= 0) {
            this.a.e(false);
            com.ucpro.business.stat.m.a("shrotcut_menu", "shortcut_menu_status", "enable", "false");
            return;
        }
        this.a.e(true);
        String str = "";
        for (Integer num : b3) {
            str = str + num + ",";
        }
        com.ucpro.business.stat.m.a("shrotcut_menu", "shortcut_menu_status", "enable", "true", "value", str);
    }

    public final void a() {
        if (this.a.b()) {
            this.a.q();
        }
    }

    public final void b() {
        this.a.t();
    }

    public final void a(int i) {
        if (i == 1) {
            this.a.getWebPageLayer();
        }
        com.ucpro.business.stat.m.a(this.a.getHomePageLayer());
    }

    public final void b(int i) {
        if (i == 0) {
            this.a.getHomePageLayer();
        }
        com.ucpro.business.stat.m.a(this.a.getWebPageLayer());
        com.ucpro.e.c.a.b = false;
        if (this.g != null) {
            a aVar = this.g;
            aVar.b.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
            aVar.e.postDelayed(aVar.f, 5000);
        }
    }

    public final void a(bb bbVar) {
        bbVar.setShouldBackToCallerActivity(false);
        ((Activity) bbVar.getContext()).moveTaskToBack(true);
    }

    public final void d(int i) {
        switch (i) {
            case 30029:
                com.ucpro.business.stat.m.a("home_tool_bar", "cli_men_b", new String[0]);
                com.ucpro.business.stat.m.a(o.c);
                g.a().b(com.ucpro.base.a.e.g, 0);
                com.ucpro.services.a.a.a.c(b.a);
                g.a().a(com.ucpro.base.a.e.f, Boolean.valueOf(false));
                com.ucpro.business.stat.m.a("home_tool_bar", "cli_men_b", new String[0]);
                return;
            case 30030:
                g.a().b(com.ucpro.base.a.e.cP);
                com.ucpro.business.stat.m.a("home_tool_bar", "cli_discovery", new String[0]);
                com.ucpro.business.stat.m.b("home_tool_bar_ut", "cli_discovery", new String[0]);
                com.ucpro.business.stat.o.a(o.b.c);
                com.ucpro.business.stat.m.a(o.b);
                return;
            case 30039:
                com.ucpro.business.stat.m.a("home_tool_bar", "cli_mul_b", new String[0]);
                com.ucpro.business.stat.o.a(o.a.c);
                com.ucpro.business.stat.m.a(o.a);
                g.a().b(com.ucpro.base.a.e.B, 1);
                com.ucpro.business.stat.m.a("home_tool_bar", "cli_mul_b", new String[0]);
                return;
            default:
                return;
        }
    }

    public final void e(int i) {
        if (i == 30039) {
            g.a().b(com.ucpro.base.a.e.H, Boolean.TRUE);
            com.ucpro.business.stat.m.a("home_tool_bar", "lon_cli_mul_b", new String[0]);
        }
    }

    public final void a(boolean z) {
    }

    public final void a(com.ucpro.base.c.b.g gVar, byte b) {
    }

    public final void c(boolean z) {
        if (z) {
            this.a.setWebViewFillParent(true);
            g.a().b(com.ucpro.base.a.e.ch, 6);
            return;
        }
        g.a().b(com.ucpro.base.a.e.ch, 1);
        this.a.setWebViewFillParent(false);
    }

    public final void a(View view, int i) {
        if (view != null && view.getParent() == null) {
            g.a().b(com.ucpro.base.a.e.ch, i);
            this.a.setWebViewFillParent(true);
            this.a.getBusinessLayer().addView(view, new LayoutParams(-1, -1));
        }
    }

    public final void b(View view) {
        if (view != null && view.getParent() != null) {
            this.a.getBusinessLayer().removeView(view);
            g.a().a(com.ucpro.base.a.e.ch, 1);
            this.a.setWebViewFillParent(false);
        }
    }

    public final void c() {
        this.e.c();
    }

    public final void a(HitTestResult hitTestResult, d dVar) {
        String focusedNodeLinkUrl;
        String focusedNodeAnchorText;
        int type = hitTestResult.getType();
        Extension extension = hitTestResult.getExtension();
        if (extension != null) {
            switch (type) {
                case 0:
                    if (extension != null && extension.hasImage()) {
                        dVar.a(com.ucpro.ui.c.a.d((int) R.string.context_menu_webview_useradblock), 20070);
                        if (extension.imageIsLoaded() && extension.imageIsVisible()) {
                            dVar.a(com.ucpro.ui.c.a.d((int) R.string.context_menu_webview_save_image), 20006);
                            if (!com.ucpro.model.a.a.a.a("setting_enable_smart_no_image", false)) {
                                dVar.a(com.ucpro.ui.c.a.d((int) R.string.context_menu_webview_enable_smart_no_image), 20098);
                            }
                            if (!(!extension.canEnterPictureMode() || this.a.G() || this.a.x())) {
                                g.a().a(com.ucpro.base.a.e.cp, new o(this, dVar));
                            }
                            if (!com.ucpro.b.a.a.a()) {
                                dVar.a(com.ucpro.ui.c.a.d((int) R.string.context_menu_webview_search_image), 20099);
                            }
                        } else {
                            dVar.a(com.ucpro.ui.c.a.d((int) R.string.context_menu_webview_show_image), 20004);
                        }
                    }
                    dVar.a(com.ucpro.ui.c.a.d((int) R.string.context_menu_webview_free_copy), 20012);
                    dVar.a(com.ucpro.ui.c.a.d((int) R.string.context_menu_search_in_page), UCMPackageInfo.getLibFilter);
                    break;
                case 1:
                case 7:
                    dVar.a(com.ucpro.ui.c.a.d((int) R.string.context_menu_webview_open_in_background_window), 20002);
                    dVar.a(com.ucpro.ui.c.a.d((int) R.string.context_menu_webview_open_new_window), 20003);
                    focusedNodeLinkUrl = this.a.getFocusedNodeLinkUrl();
                    focusedNodeAnchorText = this.a.getFocusedNodeAnchorText();
                    if (focusedNodeLinkUrl != null) {
                        dVar.a(com.ucpro.ui.c.a.d((int) R.string.context_menu_webview_copy_link), 20085);
                    }
                    if (focusedNodeAnchorText != null) {
                        dVar.a(com.ucpro.ui.c.a.d((int) R.string.context_menu_webview_free_copy), 20012);
                    }
                    if (extension != null && extension.hasImage()) {
                        dVar.a(com.ucpro.ui.c.a.d((int) R.string.context_menu_webview_useradblock), 20070);
                    }
                    dVar.a(com.ucpro.ui.c.a.d((int) R.string.context_menu_search_in_page), UCMPackageInfo.getLibFilter);
                    break;
                case 5:
                case 6:
                case 8:
                    if (extension.imageIsLoaded() && extension.imageIsVisible()) {
                        dVar.a(com.ucpro.ui.c.a.d((int) R.string.context_menu_webview_save_image), 20006);
                        if (!com.ucpro.model.a.a.a.a("setting_enable_smart_no_image", false)) {
                            dVar.a(com.ucpro.ui.c.a.d((int) R.string.context_menu_webview_enable_smart_no_image), 20098);
                        }
                        if (!(!extension.canEnterPictureMode() || this.a.G() || this.a.x())) {
                            g.a().a(com.ucpro.base.a.e.cp, new i(this, dVar));
                        }
                        if (!com.ucpro.b.a.a.a()) {
                            dVar.a(com.ucpro.ui.c.a.d((int) R.string.context_menu_webview_search_image), 20099);
                        }
                    } else {
                        dVar.a(com.ucpro.ui.c.a.d((int) R.string.context_menu_webview_show_image), 20004);
                    }
                    dVar.a(com.ucpro.ui.c.a.d((int) R.string.context_menu_webview_useradblock), 20070);
                    break;
                case 9:
                    com.ucpro.services.e.e.a.d();
                    if (!TextUtils.isEmpty(com.ucpro.services.e.e.a.b())) {
                        dVar.a(com.ucpro.ui.c.a.d((int) R.string.context_menu_webview_paste), 20019);
                    }
                    focusedNodeLinkUrl = extension.getText();
                    if (focusedNodeLinkUrl != null && focusedNodeLinkUrl.length() > 0) {
                        dVar.a(com.ucpro.ui.c.a.d((int) R.string.context_menu_webview_free_copy), 20012);
                        break;
                    }
            }
        }
        if (extension.imageIsLoaded() && extension.imageIsVisible()) {
            focusedNodeAnchorText = com.ucpro.c.c.b("tmp").getAbsolutePath() + "/";
            focusedNodeLinkUrl = null;
            if (hitTestResult.getExtension() != null) {
                focusedNodeLinkUrl = hitTestResult.getExtension().getImageUrl();
            }
            String f = f.f(focusedNodeLinkUrl);
            if (!(f == null || f.trim().length() <= 0 || f.contains("."))) {
                f = f + ".jpg";
            }
            this.a.a(focusedNodeAnchorText, f, focusedNodeLinkUrl, new bj(this, focusedNodeAnchorText, f, dVar));
        }
    }

    public final void f() {
        this.a.s();
    }

    public final void c(int i) {
        if (this.a.G()) {
            g.a().a(com.ucpro.base.a.e.cQ, i, 1);
        }
    }

    public final void g() {
        if (this.a.G()) {
            g.a().b(com.ucpro.base.a.e.cR);
        }
    }

    public final void a(String str, String str2) {
        if (a(str) || a(str2)) {
            this.a.getWebPageLayer().setEnableShrinkAddressBarByTouchEvent(false);
        } else {
            this.a.getWebPageLayer().setEnableShrinkAddressBarByTouchEvent(true);
        }
    }

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str) || (!str.contains("weibo.cn") && !str.contains("m.taobao.com"))) {
            return false;
        }
        return true;
    }

    public final boolean j() {
        if (this.a == null || !this.a.getUrl().contains("m.taobao.com")) {
            return false;
        }
        return true;
    }

    public final void d(boolean z) {
        if (this.a == null) {
            return;
        }
        if (z) {
            com.ucpro.feature.j.a.b.a();
            List b = com.ucpro.feature.j.a.b.b();
            com.ucpro.feature.j.a.b.a();
            if (com.ucpro.feature.j.a.b.d() && b.size() > 0) {
                this.a.e(true);
                return;
            }
            return;
        }
        this.a.e(false);
    }

    public final boolean a(com.ucpro.base.c.b.g gVar, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            switch (i) {
                case 4:
                    boolean z;
                    if (gVar == null) {
                        z = false;
                    } else {
                        Object obj = new boolean[]{null};
                        g.a().b(com.ucpro.base.a.e.bo, gVar.getID(), 0, obj);
                        z = obj[0];
                    }
                    if (z) {
                        return true;
                    }
                    if (this.a.y()) {
                        com.ucpro.base.c.b.g gVar2 = this.a;
                        int sourceWindowIndex = gVar2.getSourceWindowIndex();
                        if (sourceWindowIndex != -1) {
                            com.ucpro.base.c.b.g sourceWindow = gVar2.getSourceWindow();
                            int c = this.d.c(gVar2);
                            int a = this.c.a();
                            if (sourceWindow == null || this.d.c(sourceWindow) != sourceWindowIndex) {
                                if (c >= 0 && c < a && a > 1) {
                                    if (c - 1 >= 0 && c - 1 < a) {
                                        sourceWindowIndex = c - 1;
                                    } else if (c + 1 >= 0 && c + 1 < a) {
                                        sourceWindowIndex = c + 1;
                                    }
                                }
                                sourceWindowIndex = -1;
                            }
                            if (sourceWindowIndex >= 0 && sourceWindowIndex < a && c != sourceWindowIndex && c >= 0 && c < a && a > 1) {
                                this.c.b(sourceWindowIndex);
                                this.c.a(c);
                                return true;
                            }
                        }
                        return false;
                    } else if (!this.a.G()) {
                        this.a.q();
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    public final View a(View view) {
        if (view instanceof com.ucpro.base.c.b.g) {
            return this.d.b((com.ucpro.base.c.b.g) view);
        }
        return null;
    }

    public final void d() {
        this.a.d();
    }

    public final void e() {
        this.a.e();
    }

    public final void a(com.ui.edittext.c cVar, Object obj) {
        Object obj2 = null;
        if ((obj instanceof HitTestResult) && !this.a.G()) {
            HitTestResult hitTestResult = (HitTestResult) obj;
            Extension extension = hitTestResult.getExtension();
            String url = this.a.getUrl();
            int i = cVar.a;
            HashMap hashMap = new HashMap();
            hashMap.put("url", url);
            hashMap.put("context_menu_id", String.valueOf(i));
            com.ucpro.business.stat.m.a("webwindow", "context_menu_click", hashMap);
            String linkUrl;
            String url2;
            switch (cVar.a) {
                case UCMPackageInfo.getLibFilter /*10023*/:
                    this.a.o();
                    return;
                case 20002:
                    if (extension != null) {
                        linkUrl = extension.getLinkUrl();
                    }
                    url2 = this.a.getUrl();
                    if (linkUrl == null || !f.a(linkUrl) || f.a(url2)) {
                        url2 = com.ucpro.feature.webwindow.m.a.a(linkUrl);
                        if (url2 != null) {
                            this.e.a(url2, true, true, false, false);
                        }
                        this.a.z();
                        return;
                    }
                    return;
                case 20003:
                    if (extension != null) {
                        linkUrl = extension.getLinkUrl();
                    }
                    url2 = this.a.getUrl();
                    if (linkUrl == null || !f.a(linkUrl) || f.a(url2)) {
                        url2 = com.ucpro.feature.webwindow.m.a.a(linkUrl);
                        if (url2 != null) {
                            this.e.a(url2, true, true, false, true);
                            return;
                        }
                        return;
                    }
                    return;
                case 20004:
                    if (extension != null) {
                        this.a.f(extension.getImageUrl());
                        return;
                    }
                    return;
                case 20005:
                    this.a.w();
                    return;
                case 20006:
                    HitTestResult hitTestResult2 = this.a.getHitTestResult();
                    if (!(hitTestResult2 == null || hitTestResult2.getExtension() == null)) {
                        linkUrl = hitTestResult2.getExtension().getImageUrl();
                    }
                    if (com.ucweb.common.util.n.a.b(linkUrl)) {
                        com.ucpro.ui.b.e.a().a(com.ucweb.common.util.d.a().getString(R.string.pic_start_save), 0);
                        k.a(linkUrl, this.a.getUrl(), new t(this, linkUrl));
                        return;
                    }
                    return;
                case 20012:
                    this.a.C();
                    return;
                case 20019:
                    this.a.g(com.ucpro.services.e.e.a.b());
                    return;
                case 20070:
                    this.a.I();
                    return;
                case 20085:
                    linkUrl = com.ucpro.feature.webwindow.m.a.a(this.a.getFocusedNodeLinkUrl());
                    if (!com.ucweb.common.util.n.a.a(linkUrl)) {
                        com.ucpro.services.e.e.a.a(linkUrl);
                        com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.context_menu_webview_copy_link_toast_text), 0);
                        return;
                    }
                    return;
                case 20098:
                    com.ucpro.model.a.a.a.b("setting_enable_smart_no_image", true);
                    com.ucpro.base.a.f.a().a(j.s);
                    return;
                case 20099:
                    if (!(hitTestResult == null || hitTestResult.getExtension() == null)) {
                        obj2 = hitTestResult.getExtension().getImageUrl();
                    }
                    if (!TextUtils.isEmpty(obj2)) {
                        i kVar = new k(this, hitTestResult);
                        com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.search_image_ing), 1);
                        if (TextUtils.isEmpty(obj2)) {
                            kVar.a("pic path empty.");
                        } else if (TextUtils.isEmpty(obj2)) {
                            kVar.a("uploadablePictureName empty");
                        } else {
                            com.ucweb.common.util.h.m.a(0, new h(obj2, kVar));
                        }
                        com.ucpro.feature.c.e.a.a();
                        return;
                    }
                    return;
                case 20100:
                    g.a().a(com.ucpro.base.a.e.bF, this.b);
                    return;
                case 20101:
                    g.a().a(com.ucpro.base.a.e.cE, new String[]{this.a.getUrl(), this.a.getTitle()});
                    return;
                default:
                    return;
            }
        }
    }

    public final void f(int i) {
        Object selection = this.a.getSelection();
        if (40022 != i) {
            this.a.K();
        }
        if (selection != null && selection.length() != 0) {
            if (!(selection == null || selection.length() == 0)) {
                selection = selection.replace(' ', ' ');
            }
            Object ajVar;
            switch (i) {
                case 40001:
                    com.ucpro.services.e.e.a.a(selection);
                    com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.free_copy_tip), 0);
                    return;
                case 40004:
                    if (!TextUtils.isEmpty(selection.trim())) {
                        ajVar = new aj();
                        ajVar.s = aj.f;
                        ajVar.p = selection;
                        g.a().b(com.ucpro.base.a.e.k, ajVar);
                        return;
                    }
                    return;
                case 40007:
                    ajVar = new aj();
                    ajVar.o = selection;
                    ajVar.s = aj.b;
                    g.a().a(com.ucpro.base.a.e.k, ajVar);
                    return;
                case 40022:
                    this.a.D();
                    return;
                case 40025:
                    g.a().a(com.ucpro.base.a.e.cY, selection);
                    return;
                case 40028:
                    this.a.a(new u(this));
                    return;
                default:
                    return;
            }
        }
    }

    public final void b(boolean z) {
        com.ucpro.e.f a = com.ucpro.e.c.a;
        if (!z) {
            a.b = false;
        }
    }

    public final void a(com.ucpro.feature.webwindow.e.f fVar, String str) {
        if (fVar != null && !TextUtils.isEmpty(str) && !"ext:lp:home".equalsIgnoreCase(str)) {
            fVar.a(new s(this, str), 1);
        }
    }

    public final boolean h() {
        if (com.ucpro.model.a.a.a.a("setting_toolbar_style", 0) == 0) {
            return true;
        }
        return false;
    }

    public final int i() {
        return com.ucpro.model.a.a.a.a("setting_toolbar_style", 0);
    }
}
