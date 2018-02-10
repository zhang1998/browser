package com.uc.webview.browser.interfaces;

import android.app.Notification;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.WebView;
import com.uc.webview.export.annotations.Reflection;

@Reflection
/* compiled from: ProGuard */
public interface IWindowLauncherDelegate {
    void cancelNotification(String str);

    void displayNotification(String str, Notification notification);

    void onOpenUrl(int i, String str, ValueCallback<Pair<Integer, WebView>> valueCallback);
}
