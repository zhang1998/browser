package com.uc.media.interfaces;

import android.os.Message;
import com.uc.webview.export.annotations.Reflection;

@Reflection
/* compiled from: ProGuard */
public interface IWebViewIME {
    boolean handleImeEvent(Message message, Object obj);

    void hideSoftKeyboard();

    void selectInputMethod();

    void sendInputMessage(int i, int i2, int i3, Object obj);
}
