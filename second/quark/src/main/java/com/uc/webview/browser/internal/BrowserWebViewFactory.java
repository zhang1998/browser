package com.uc.webview.browser.internal;

import android.content.Context;
import android.util.AttributeSet;
import com.uc.webview.browser.internal.android.b;
import com.uc.webview.browser.internal.interfaces.IBrowserWebView;
import com.uc.webview.export.JavascriptInterface;
import com.uc.webview.export.WebView;
import com.uc.webview.export.annotations.Reflection;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.AbstractWebViewFactory;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.CommonDef;
import com.uc.webview.export.internal.interfaces.IWebView;
import com.uc.webview.export.internal.uc.CoreFactory;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: ProGuard */
public final class BrowserWebViewFactory extends AbstractWebViewFactory {

    @Reflection
    /* compiled from: ProGuard */
    class JSObject {
        Context mAppContext;

        public JSObject(Context context) {
            this.mAppContext = context.getApplicationContext();
        }

        @JavascriptInterface
        public void callTest() {
            Log.d("BrowserWebViewFactory", "java object call");
        }

        @JavascriptInterface
        @Reflection
        public void setCDParame(String str) {
            Log.d("BrowserWebViewFactory", "setCDParame cd: " + str);
            UCCore.setParam(str);
        }

        @JavascriptInterface
        @Reflection
        public void parserMiddlewareCd(String str) {
            Log.d("BrowserWebViewFactory", "parserMiddlewareCd cd: " + str);
            SDKFactory.invoke(10053, str, this.mAppContext.getApplicationInfo().dataDir + "/app_ucmsdk/cms");
        }
    }

    public final IWebView createWebView(Context context, AttributeSet attributeSet, WebView webView, boolean z, int[] iArr) {
        int i;
        if (CommonDef.sOnCreateWindowType == 1 || z) {
            i = 2;
        } else if (CommonDef.sOnCreateWindowType == 2) {
            i = CoreFactory.getCoreType().intValue();
        } else {
            i = ((Integer) SDKFactory.invoke(SDKFactory.getCoreType, new Object[0])).intValue();
        }
        Log.d("BrowserWebViewFactory", String.format("createWebView(forceUsingSystem=%b, sOnCreateWindowType=%d)=%d", new Object[]{Boolean.valueOf(z), Integer.valueOf(CommonDef.sOnCreateWindowType), Integer.valueOf(i)}));
        iArr[0] = i;
        if (i == 2) {
            return new b(context, attributeSet, webView);
        }
        return (IBrowserWebView) CoreFactory.createWebView(context, attributeSet);
    }
}
