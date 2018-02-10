package com.uc.base.jssdk;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.uc.base.jssdk.a.g;

/* compiled from: ProGuard */
public class ShellJsInterface {
    public static final String EXT_JS_SDK = "JS-SDK";
    public static final String SHELL_JS_NAME = "UCShellJava";
    private h a;

    public ShellJsInterface(h hVar) {
        this.a = hVar;
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    @Deprecated
    public String invoke(String str, String str2, String str3, String[] strArr, String str4) {
        h hVar = this.a;
        if (!TextUtils.isEmpty(hVar.a.getCallerUrl())) {
            hVar.a.getCallerUrl();
        }
        g c = hVar.d.a.c(str2);
        if (c != null) {
            return c.a();
        }
        return "";
    }

    @JavascriptInterface
    @com.uc.webview.export.JavascriptInterface
    public String sdkInvoke(String str, String str2, String str3, String str4) {
        return this.a.a(str, str2, str3, str4);
    }
}
