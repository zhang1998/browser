package com.uc.webview.browser;

import android.webkit.ValueCallback;
import com.uc.webview.browser.internal.BrowserSDKFactory;
import com.uc.webview.browser.internal.interfaces.INotificationPermissions;
import com.uc.webview.export.WebView;
import com.uc.webview.export.annotations.Api;
import com.uc.webview.export.internal.SDKFactory;
import java.util.HashMap;
import java.util.Set;

@Api
/* compiled from: ProGuard */
public class NotificationPermissions implements INotificationPermissions {
    private static HashMap<Integer, NotificationPermissions> b;
    private INotificationPermissions a;

    @Api
    /* compiled from: ProGuard */
    public interface Callback {
        void invoke(String str, boolean z, boolean z2);
    }

    private NotificationPermissions(INotificationPermissions iNotificationPermissions) {
        this.a = iNotificationPermissions;
    }

    public static NotificationPermissions getInstance() throws RuntimeException {
        return a(((Integer) SDKFactory.invoke(SDKFactory.getCoreType, new Object[0])).intValue());
    }

    public static NotificationPermissions getInstance(WebView webView) throws RuntimeException {
        return a(webView.getCurrentViewCoreType());
    }

    private static synchronized NotificationPermissions a(int i) throws RuntimeException {
        NotificationPermissions notificationPermissions;
        synchronized (NotificationPermissions.class) {
            if (b == null) {
                b = new HashMap();
            }
            notificationPermissions = (NotificationPermissions) b.get(Integer.valueOf(i));
            if (notificationPermissions == null) {
                notificationPermissions = new NotificationPermissions(BrowserSDKFactory.getNotificationPermissionsInstance());
                b.put(Integer.valueOf(i), notificationPermissions);
            }
        }
        return notificationPermissions;
    }

    public void getOrigins(ValueCallback<Set<String>> valueCallback) {
        this.a.getOrigins(valueCallback);
    }

    public void getAllowed(String str, ValueCallback<Boolean> valueCallback) {
        this.a.getAllowed(str, valueCallback);
    }

    public void clear(String str) {
        this.a.clear(str);
    }

    public void allow(String str) {
        this.a.allow(str);
    }

    public void clearAll() {
        this.a.clearAll();
    }

    public Object invoke(int i, Object[] objArr) {
        return null;
    }

    public String toString() {
        return "NotificationPermissions@" + hashCode() + "[" + this.a + "]";
    }
}
