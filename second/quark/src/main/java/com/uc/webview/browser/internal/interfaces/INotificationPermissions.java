package com.uc.webview.browser.internal.interfaces;

import android.webkit.ValueCallback;
import com.uc.webview.export.annotations.Interface;
import com.uc.webview.export.internal.interfaces.InvokeObject;
import java.util.Set;

@Interface
/* compiled from: ProGuard */
public interface INotificationPermissions extends InvokeObject {
    void allow(String str);

    void clear(String str);

    void clearAll();

    void getAllowed(String str, ValueCallback<Boolean> valueCallback);

    void getOrigins(ValueCallback<Set<String>> valueCallback);
}
