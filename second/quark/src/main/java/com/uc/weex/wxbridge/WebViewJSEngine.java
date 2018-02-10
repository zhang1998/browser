package com.uc.weex.wxbridge;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.taobao.weex.ad;
import com.taobao.weex.b;
import com.taobao.weex.common.c;
import com.taobao.weex.common.g;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public class WebViewJSEngine implements b {
    private boolean isFrameworkInitFinish = false;
    Handler mHander = new Handler(Looper.getMainLooper());
    private String mInstanceId;
    private List<Runnable> mTaskList = new ArrayList();
    private c mWXBridge;
    private WebView mWebView;

    public WebViewJSEngine(Context context) {
        init(context);
    }

    private void init(Context context) {
        if (this.mWebView == null) {
            this.mWebView = new WebView(context);
            WebSettings settings = this.mWebView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            this.mWebView.setWebViewClient(new g(this));
            this.mWebView.setWebChromeClient(new h(this));
        }
    }

    public void initBridge(c cVar) {
        this.mWXBridge = cVar;
    }

    public int initFramework(String str) {
        this.mHander.post(new j(this, str));
        return 1;
    }

    public int execJS(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return 0;
        }
        if (!TextUtils.isEmpty(str)) {
            this.mInstanceId = str;
        }
        execJSCode(str2);
        return 1;
    }

    public int execJSService(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        execJSCode(str);
        return 1;
    }

    private void execJSCode(String str) {
        exeTaskList(new l(this, str));
    }

    private synchronized void exeTaskList(Runnable runnable) {
        if (runnable != null) {
            this.mTaskList.add(runnable);
        }
        if (this.isFrameworkInitFinish) {
            for (Runnable post : this.mTaskList) {
                this.mHander.post(post);
            }
            this.mTaskList.clear();
        }
    }

    @JavascriptInterface
    public void initFrameworkFinish() {
        this.isFrameworkInitFinish = true;
        exeTaskList(null);
    }

    @JavascriptInterface
    public int callNative(String str, String str2, String str3) {
        return this.mWXBridge.callNative(str, str2, str3);
    }

    @JavascriptInterface
    public int callAddElement(String str, String str2, String str3, String str4, String str5) {
        return this.mWXBridge.callAddElement(str, str2, str3, str4, str5);
    }

    @JavascriptInterface
    public Object callNativeModule(String str, String str2, String str3, String str4, String str5) {
        byte[] bArr = null;
        c cVar = this.mWXBridge;
        byte[] bytes = str4 != null ? str4.getBytes() : null;
        if (str5 != null) {
            bArr = str5.getBytes();
        }
        return cVar.callNativeModule(str, str2, str3, bytes, bArr);
    }

    @JavascriptInterface
    public void callNativeComponent(String str, String str2, String str3, String str4, String str5) {
        byte[] bytes;
        byte[] bArr = null;
        c cVar = this.mWXBridge;
        if (str4 != null) {
            bytes = str4.getBytes();
        } else {
            bytes = null;
        }
        if (str5 != null) {
            bArr = str5.getBytes();
        }
        cVar.callNativeComponent(str, str2, str3, bytes, bArr);
    }

    @JavascriptInterface
    public void setTimeoutNative(String str, String str2) {
        this.mWXBridge.setTimeoutNative(str, str2);
    }

    @JavascriptInterface
    public void reportException(String str) {
        ad.a().l.a(this.mInstanceId, g.WX_ERR_JS_EXECUTE.toString(), str);
    }

    @JavascriptInterface
    public void notifySerializeCodeCache() {
    }
}
