package com.uc.webview.browser;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.browser.interfaces.BrowserMobileWebKit;
import com.uc.webview.browser.interfaces.BrowserPreloader;
import com.uc.webview.browser.interfaces.IAccessControl;
import com.uc.webview.browser.interfaces.ICoreStat;
import com.uc.webview.browser.interfaces.IStateChangeDispatcher;
import com.uc.webview.browser.interfaces.IUserAgent;
import com.uc.webview.browser.internal.BrowserSDKFactory;
import com.uc.webview.browser.internal.PreloadManager;
import com.uc.webview.export.WebResourceResponse;
import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IPreloadManager;
import com.uc.webview.export.internal.setup.BrowserSetupTask;
import com.uc.webview.export.internal.setup.l;
import com.uc.webview.export.internal.uc.CoreFactory;
import com.uc.webview.export.utility.SetupTask;
import java.util.HashMap;

@Api
/* compiled from: ProGuard */
public final class BrowserCore extends UCCore {
    public static final int BUSINESS_INFO_TYPE_ACCESSIBLE_LIST = 1;
    public static final int BUSINESS_INFO_TYPE_CDPARAM = 2;
    public static final int CORE_EVENT_WEB_NOTIFICATION_MESSAGE = 51;
    public static final int CORE_EVENT_WEB_PUSH_MESSAGE = 50;
    private static BrowserMobileWebKit a;
    private static ICoreStat b;
    private static IStateChangeDispatcher c;
    private static IUserAgent d;
    private static IAccessControl e;

    private BrowserCore() {
    }

    public static BrowserMobileWebKit getMobileWebKit() {
        if (a == null) {
            a = BrowserSDKFactory.a();
        }
        return a;
    }

    public static int initUCMobileWebKit(Context context, boolean z, boolean z2) {
        return BrowserSDKFactory.a(context, z, z2);
    }

    public static ICoreStat getCoreStat() {
        if (b == null) {
            b = BrowserSDKFactory.b();
        }
        return b;
    }

    public static IStateChangeDispatcher getStateChangeDispatcher() {
        if (c == null) {
            c = BrowserSDKFactory.c();
        }
        return c;
    }

    public static IUserAgent getUserAgent() {
        if (d == null) {
            d = BrowserSDKFactory.d();
        }
        return d;
    }

    public static HashMap<String, String> getBusinessInfo(int i) {
        return BrowserSDKFactory.a(i);
    }

    public static boolean initUCMobileWebkitCoreSo(Context context, String str) throws RuntimeException {
        return CoreFactory.initUCMobileWebkitCoreSo(context, null, null, str);
    }

    public static IAccessControl getAccessControl() {
        if (e == null) {
            e = BrowserSDKFactory.e();
        }
        return e;
    }

    public static void handlePerformanceTests(String str) {
        SDKFactory.invoke(SDKFactory.handlePerformanceTests, str);
    }

    public static SetupTask setup(String str, Object obj) {
        BrowserSDKFactory.f();
        BrowserSDKFactory.g();
        if (obj instanceof Context) {
            BrowserPreloader.initInst(PreloadManager.getInstance()).setContext((Context) obj);
        }
        return (SetupTask) BrowserSetupTask.getInstance().setup(str, obj);
    }

    public static void decompress7zCore(Context context, String str, ValueCallback<Pair<String, HashMap<String, String>>> valueCallback) {
    }

    public static void createCoreZip(Context context, ValueCallback<Bundle> valueCallback) {
        new Thread(new l(context, valueCallback)).start();
    }

    public static boolean isCoreInited() {
        return ((Boolean) SDKFactory.invoke(10010, new Object[0])).booleanValue();
    }

    public static BrowserPreloader getPreloader(Context context) {
        return BrowserPreloader.initInst(PreloadManager.getInstance()).setContext(context);
    }

    @Deprecated
    public static void prefetch(Context context, String str, String str2, ValueCallback<Pair<Boolean, String>> valueCallback) {
        getPreloader(context).prefetch(IPreloadManager.SIR_COMMON_TYPE, str, str2, valueCallback);
    }

    @Deprecated
    public static Pair<Boolean, String> getPrefetchResult(Context context, String str) {
        return getPreloader(context).getPrefetchResult(IPreloadManager.SIR_COMMON_TYPE, str);
    }

    @Deprecated
    public static WebResourceResponse getPreloadResource(String str, String str2) {
        return getPreloader(null).getPreloadResource(IPreloadManager.SIR_COMMON_TYPE, str, str2);
    }

    public static boolean is7zCompressCore() {
        return false;
    }

    public static String get7zCoreFileName() {
        return "libkernelu4_uc_7z.so";
    }

    public static boolean isErrorCodeShouldRestart(int i) {
        if (i == 1008 || i == 2008 || i == SettingsConst.ENABLE_FULL_SCREEN || i == SettingsConst.PRELOAD_CD_PARAMS || i == 4007) {
            return true;
        }
        return false;
    }

    public static boolean isErrorCodeShouldCleanup(int i) {
        if (i == 1003 || i == 1006 || i == 2001 || i == 1012) {
            return true;
        }
        return false;
    }
}
