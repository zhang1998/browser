package com.uc.webview.browser.interfaces;

import android.content.Context;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.browser.internal.interfaces.IPreloadManager;
import com.uc.webview.export.WebResourceResponse;
import com.uc.webview.export.annotations.Interface;
import com.uc.webview.export.annotations.Reflection;
import com.uc.webview.export.internal.SDKFactory;

@Interface
/* compiled from: ProGuard */
public class BrowserPreloader {
    public static final String CDKEY_SIR_DELETE = "sir_delete";
    public static final String CDKEY_SIR_PREFETCH = "sir_prefetch";
    private static BrowserPreloader a = null;
    private IPreloadManager b;

    public static BrowserPreloader initInst(IPreloadManager iPreloadManager) {
        if (a == null) {
            synchronized (BrowserPreloader.class) {
                if (a == null) {
                    a = new BrowserPreloader(iPreloadManager);
                    SDKFactory.invoke(SDKFactory.setPreloadManager, a.b);
                }
            }
        }
        return a;
    }

    public static BrowserPreloader getInst() {
        return initInst(null);
    }

    @Reflection
    public static IPreloadManager getPreloadManager() {
        return initInst(null).b;
    }

    private BrowserPreloader(IPreloadManager iPreloadManager) {
        if (iPreloadManager != null) {
            this.b = iPreloadManager;
            return;
        }
        try {
            Class cls = Class.forName("PreloadManager");
            this.b = (IPreloadManager) cls.getDeclaredMethod("getInstance", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public BrowserPreloader setContext(Context context) {
        if (context != null) {
            this.b.setContext(context.getApplicationContext());
        }
        return this;
    }

    public void prefetch(String str, String str2, String str3, ValueCallback<Pair<Boolean, String>> valueCallback) {
        if (str2.equals(CDKEY_SIR_PREFETCH)) {
            this.b.prefetchScope(str, str3, valueCallback);
            return;
        }
        if (str2.equals(CDKEY_SIR_DELETE)) {
            this.b.deleteScope(str, str3, valueCallback);
            return;
        }
        this.b.callback(str, valueCallback, Boolean.valueOf(false), str2 + ":key not valid.", 1, "unknown", str2, false, false, false, false, 0, 0);
    }

    public Pair<Boolean, String> getPrefetchResult(String str, String str2) {
        return this.b.getPrefetchResult(str2, str);
    }

    public WebResourceResponse getPreloadResource(String str, String str2, String str3) {
        return this.b.getPreloadResource(str2, str, str3);
    }

    public Pair<Boolean, String> getPrefetchUrlResult(String str, String str2, String str3) {
        return this.b.getPrefetchUrlResult(str2, str, str3);
    }

    public WebResourceResponse getPreloadResourceWithNetWork(String str, String str2, String str3, String str4) {
        return this.b.getPreloadResourceWithNetwork(str2, str, str3, str4);
    }

    public String getPreloadResourcePath(String str, String str2, String str3) {
        return this.b.getPreloadResourcePath(str2, str, str3);
    }

    public void deletePreloadResource(String str, String str2, String str3) {
        this.b.deletePreloadResource(str2, str, str3);
    }

    public void deleteAllScope() {
        this.b.deleteAllScope();
    }
}
