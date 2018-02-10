package com.ucpro.feature.webwindow;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.uc.webview.browser.BrowserWebView.HitTestResult;
import com.uc.webview.browser.interfaces.BrowserClient.CustomViewCallbackEx;
import com.ucpro.base.c.b.g;
import com.ucpro.base.d.a;
import com.ucpro.feature.webwindow.h.h;
import com.ucpro.feature.webwindow.l.a.f;
import java.util.HashMap;

/* compiled from: ProGuard */
public abstract class bo extends g implements a {
    public abstract void A();

    public abstract void B();

    public abstract void C();

    public abstract void D();

    public abstract void E();

    public abstract View F();

    public abstract boolean G();

    public abstract void I();

    public abstract void K();

    public abstract void L();

    public abstract void M();

    public abstract void N();

    public abstract void O();

    public abstract void a(int i, Object obj);

    public abstract void a(Point point, Point point2, Rect rect, Rect rect2);

    public abstract void a(View view, int i, CustomViewCallbackEx customViewCallbackEx);

    public abstract void a(ValueCallback<String> valueCallback);

    public abstract void a(String str);

    public abstract void a(String str, String str2, String str3);

    public abstract void a(String str, String str2, String str3, ValueCallback<Bundle> valueCallback);

    public abstract void a(boolean z);

    public abstract void b(int i);

    public abstract void b(String str);

    public abstract boolean b();

    public abstract void c(int i);

    public abstract void c(String str);

    public abstract void d(String str);

    public abstract void d(boolean z);

    public abstract void e(String str);

    public abstract void e(boolean z);

    public abstract void f(String str);

    public abstract void g(String str);

    public abstract h getAddressBar();

    public abstract FrameLayout getBusinessLayer();

    public abstract String getFocusedNodeAnchorText();

    public abstract String getFocusedNodeLinkUrl();

    public abstract f getFreeCopyMenu();

    public abstract HitTestResult getHitTestResult();

    public abstract x getHomePageLayer();

    public abstract com.uc.base.jssdk.h getJsApiManager();

    public abstract HashMap<String, String> getReceivedDispatchResponse();

    public abstract String getSelection();

    public abstract g getSourceWindow();

    public abstract int getSourceWindowIndex();

    public abstract String getUrl();

    public abstract ab getWebPageLayer();

    public abstract com.ucpro.feature.webwindow.e.f getWebView();

    public abstract boolean m();

    public abstract void n();

    public abstract void o();

    public abstract void p();

    public abstract void q();

    public abstract void s();

    public abstract void setIsCloseAllJsDialog(boolean z);

    public abstract void setPictureViewerOpened(boolean z);

    public abstract void setReceivedDispatchResponse(HashMap<String, String> hashMap);

    public abstract void setShouldBackToCallerActivity(boolean z);

    public abstract void setWebViewFillParent(boolean z);

    public abstract void t();

    public abstract void v();

    public abstract boolean w();

    public abstract boolean x();

    public abstract boolean y();

    public abstract void z();

    public bo(Context context) {
        super(context);
    }
}
