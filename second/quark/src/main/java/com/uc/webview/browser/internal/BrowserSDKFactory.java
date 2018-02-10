package com.uc.webview.browser.internal;

import android.content.Context;
import com.uc.webview.browser.interfaces.BrowserExtension;
import com.uc.webview.browser.interfaces.BrowserMobileWebKit;
import com.uc.webview.browser.interfaces.IAccessControl;
import com.uc.webview.browser.interfaces.ICoreStat;
import com.uc.webview.browser.interfaces.IStateChangeDispatcher;
import com.uc.webview.browser.interfaces.IUserAgent;
import com.uc.webview.browser.internal.interfaces.IBrowserCookieManager;
import com.uc.webview.browser.internal.interfaces.IBrowserGlobalSettings;
import com.uc.webview.browser.internal.interfaces.IBrowserWebView;
import com.uc.webview.browser.internal.interfaces.INotificationPermissions;
import com.uc.webview.browser.internal.uc.a;
import com.uc.webview.export.annotations.Reflection;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IGlobalSettings;
import com.uc.webview.export.internal.uc.CoreFactory;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class BrowserSDKFactory {
    private static boolean a = false;
    private static boolean b = false;

    private BrowserSDKFactory() {
    }

    public static BrowserMobileWebKit a() {
        if (((Integer) SDKFactory.invoke(SDKFactory.getCoreType, new Object[0])).intValue() == 2) {
            return null;
        }
        return (BrowserMobileWebKit) CoreFactory.getUCMobileWebKit();
    }

    public static synchronized int a(Context context, boolean z, boolean z2) {
        int intValue;
        synchronized (BrowserSDKFactory.class) {
            if (((Boolean) SDKFactory.invoke(10010, new Object[0])).booleanValue()) {
                intValue = ((Integer) SDKFactory.invoke(SDKFactory.getCoreType, new Object[0])).intValue();
            } else {
                CoreFactory.initUCMobileWebKit(context, z, z2);
                intValue = CoreFactory.getCoreType().intValue();
                SDKFactory.invoke(10021, Integer.valueOf(intValue));
            }
        }
        return intValue;
    }

    public static ICoreStat b() {
        if (((Integer) SDKFactory.invoke(SDKFactory.getCoreType, new Object[0])).intValue() == 2) {
            return null;
        }
        return a.b();
    }

    public static IStateChangeDispatcher c() {
        if (((Integer) SDKFactory.invoke(SDKFactory.getCoreType, new Object[0])).intValue() == 2) {
            return null;
        }
        return a.a();
    }

    public static IUserAgent d() {
        if (((Integer) SDKFactory.invoke(SDKFactory.getCoreType, new Object[0])).intValue() == 2) {
            return null;
        }
        return a.d();
    }

    public static HashMap<String, String> a(int i) {
        if (((Integer) SDKFactory.invoke(SDKFactory.getCoreType, new Object[0])).intValue() == 2) {
            return null;
        }
        return a.a(i);
    }

    public static IAccessControl e() {
        if (((Integer) SDKFactory.invoke(SDKFactory.getCoreType, new Object[0])).intValue() == 2) {
            return null;
        }
        return a.c();
    }

    public static synchronized void f() {
        synchronized (BrowserSDKFactory.class) {
            if (!a) {
                g();
                SDKFactory.invoke(10008, new BrowserWebViewFactory());
                a = true;
            }
        }
    }

    public static synchronized void g() {
        synchronized (BrowserSDKFactory.class) {
            if (!b) {
                SDKFactory.invoke(10009, new Object[0]);
                b = true;
            }
        }
    }

    @Reflection
    public static IBrowserGlobalSettings getGlobalSettings() {
        if (((Integer) SDKFactory.invoke(SDKFactory.getCoreType, new Object[0])).intValue() == 2) {
            return null;
        }
        return (IBrowserGlobalSettings) ((IGlobalSettings) SDKFactory.invoke(10022, new Object[0]));
    }

    public static IBrowserCookieManager h() {
        if (((Integer) SDKFactory.invoke(SDKFactory.getCoreType, new Object[0])).intValue() == 2) {
            return new com.uc.webview.browser.internal.android.a();
        }
        return (IBrowserCookieManager) CoreFactory.getCookieManager();
    }

    @Reflection
    public static INotificationPermissions getNotificationPermissionsInstance() {
        if (((Integer) SDKFactory.invoke(SDKFactory.getCoreType, new Object[0])).intValue() == 2) {
            return null;
        }
        return a.e();
    }

    public static BrowserExtension a(IBrowserWebView iBrowserWebView, int i) {
        if (i == 2) {
            return null;
        }
        return new BrowserExtension(iBrowserWebView);
    }
}
