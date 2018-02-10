package com.uc.webview.browser.internal.interfaces;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.WebResourceResponse;
import com.uc.webview.export.annotations.Interface;
import java.util.AbstractQueue;

@Interface
/* compiled from: ProGuard */
public interface IPreloadManager extends com.uc.webview.export.internal.interfaces.IPreloadManager {
    public static final int ERROR_KEY_NOT_VALID = 1;
    public static final String PROTOCOL_VERSION = "1.0";
    public static final String PSEUDONYM = "uc-sir-prefetch";
    public static final String VIA = "1.0 uc-sir-prefetch";

    void callback(String str, ValueCallback<Pair<Boolean, String>> valueCallback, Boolean bool, String str2, int i, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, int i2, int i3);

    void deleteAllScope();

    void deletePreloadResource(String str, String str2, String str3);

    void deleteScope(String str, String str2, ValueCallback<Pair<Boolean, String>> valueCallback);

    Pair<Boolean, String> getPrefetchResult(String str, String str2);

    Pair<Boolean, String> getPrefetchUrlResult(String str, String str2, String str3);

    String getPreloadResourcePath(String str, String str2, String str3);

    WebResourceResponse getPreloadResourceWithNetwork(String str, String str2, String str3, String str4);

    AbstractQueue<Pair<Integer, Object>> getStats();

    Object invoke(String str, Object obj);

    void prefetchScope(String str, String str2, ValueCallback<Pair<Boolean, String>> valueCallback);

    void setStatCallback(Runnable runnable);
}
